
package jp.tomorrowkey.checkoutorderimporter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.tomorrowkey.checkoutorderimporter.cellprocessor.HeaderMapping;
import jp.tomorrowkey.checkoutorderimporter.cellprocessor.HeaderMappingHolder;
import jp.tomorrowkey.checkoutorderimporter.entity.SalesOrder;
import jp.tomorrowkey.checkoutorderimporter.util.CsvFileFilter;
import jp.tomorrowkey.checkoutorderimporter.util.FileUtil;
import jp.tomorrowkey.checkoutorderimporter.util.ReflectionUtil;
import jp.tomorrowkey.checkoutorderimporter.util.StringUtil;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCSVException;
import org.supercsv.exception.SuperCSVReflectionException;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class Main {

    private static final String DATA_DIRECTORY = "./data";

    private static final String DATABASE_PATH = "orders.db";

    // @formatter:off
    private static final String CREATE_ORDER_TABLE = 
        "CREATE TABLE SALES_ORDER("
        + "ORDER_NUMBER             TEXT PRIMARY KEY ,"
        + "ORDER_CHARGED_DATE       TEXT ,"
        + "ORDER_CHARGED_TIMESTAMP  INTEGER ,"
        + "FINANCIAL_STATUS         TEXT ,"
        + "PAYOUT_DATE              TEXT ,"
        + "DEVICE_MODEL             TEXT ,"
        + "PRODUCT_TITLE            TEXT ,"
        + "PRODUCT_ID               TEXT ,"
        + "CURRENCY_OF_SALE         TEXT ,"
        + "ITEM_PRICE               REAL ,"
        + "TAXES_COLLECTED          REAL ,"
        + "CHARGED_AMOUNT           REAL ,"
        + "MERCHANT_CURRENCY        TEXT ,"
        + "ESTIMATED_FX_RATE        REAL ,"
        + "MERCHANT_RECEIVES        REAL ,"
        + "CITY_OF_BUYER            TEXT ,"
        + "STATE_OF_BUYER           TEXT ,"
        + "POSTAL_CODE_OF_BUYER     TEXT ,"
        + "COUNTRY_OF_BUYER         TEXT ,"
        + "ORDER_ID                 TEXT ,"
        + "MERCHANT_ORDER_NUMBER    TEXT ,"
        + "ORDER_CREATION_DATE      INTEGER ,"
        + "CURRENCY_OF_TRANSACTION  TEXT ,"
        + "ORDER_AMOUNT             REAL ,"
        + "AMOUNT_CHARGED           REAL ,"
        + "FULFILLMENT_STATUS       TEXT ,"
        + "LINK_TO_ORDER            TEXT ,"
        + "TOTAL_TAX                REAL ,"
        + "TOTAL_SHIPPING           REAL ,"
        + "AMOUNT_REFUNDED          REAL ,"
        + "AMOUNT_CHARGED_BACK      REAL ,"
        + "CHARGEBACK_PROTECTION    TEXT ,"
        + "SHIPPING_METHOD          TEXT ,"
        + "EMAIL_MARKETING          TEXT ,"
        + "BUYER_EMAIL_ADDRESS      TEXT ,"
        + "BUYER_NAME               TEXT ,"
        + "BUYER_ADDRESS1           TEXT ,"
        + "BUYER_ADDRESS2           TEXT ,"
        + "BUYER_CITY               TEXT ,"
        + "BUYER_STATE              TEXT ,"
        + "BUYER_POSTAL_CODE        TEXT ,"
        + "BUYER_COUNTRY            TEXT ,"
        + "BUYER_PHONE_NUMBER       TEXT ,"
        + "TRACKING_DATA            TEXT ,"
        + "ITEM1_ID                 TEXT ,"
        + "ITEM1_NAME               TEXT ,"
        + "ITEM1_DESCRIPTION        TEXT ,"
        + "ITEM1_PRICE              REAL ,"
        + "ITEM1_QUANTITY           INTEGER ,"
        + "ITEM2_ID                 TEXT ,"
        + "ITEM2_NAME               TEXT ,"
        + "ITEM2_DESCRIPTION        TEXT ,"
        + "ITEM2_PRICE              REAL ,"
        + "ITEM2_QUANTITY           INTEGER "
        + ");";
    // @formatter:on

    public static void main(String[] args) throws SuperCSVReflectionException, SuperCSVException,
            IOException {
        File directory = new File(DATA_DIRECTORY);
        HeaderMappingHolder headerMappingHolder = new HeaderMappingHolder();
        List<SalesOrder> orderList = new ArrayList<SalesOrder>();

        for (File f : directory.listFiles(new CsvFileFilter())) {
            ICsvBeanReader reader = new CsvBeanReader(new FileReader(f),
                    CsvPreference.EXCEL_PREFERENCE);
            String[] headers = reader.getCSVHeader(true);
            CellProcessor[] processors = new CellProcessor[headers.length];
            String[] fieldMapping = new String[headers.length];
            for (int i = 0; i < headers.length; i++) {
                HeaderMapping headerMapping = headerMappingHolder.get(headers[i]);
                processors[i] = headerMapping.getCellProcessor();
                fieldMapping[i] = headerMapping.getFieldName();
            }

            SalesOrder order;
            while (true) {
                order = reader.read(SalesOrder.class, fieldMapping, processors);
                if (order == null)
                    break;
                orderList.add(order);
            }
        }

        int importCounter = 0;

        Connection connection = null;
        try {
            boolean needCreateTable = !FileUtil.isExistsFile(DATABASE_PATH);

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager
                    .getConnection(String.format("jdbc:sqlite:%s", DATABASE_PATH));

            QueryRunner qr = new QueryRunner();

            if (needCreateTable)
                qr.update(connection, CREATE_ORDER_TABLE);

            {
                BeanListHandler<SalesOrder> handler = new BeanListHandler<SalesOrder>(
                        SalesOrder.class);

                for (SalesOrder order : orderList) {
                    List<SalesOrder> list = qr.query(connection,
                            "SELECT * FROM SALES_ORDER WHERE ORDER_NUMBER = ?", handler,
                            order.getId());
                    if (list.isEmpty()) {
                        // insert
                        String query = "INSERT INTO SALES_ORDER(ORDER_NUMBER) VALUES(?)";
                        qr.update(connection, query, order.getId());
                    }
                    // update
                    StringBuilder queryBuilder = new StringBuilder("UPDATE SALES_ORDER SET ");
                    List<Object> parameterList = new ArrayList<Object>();

                    Class<?> clazz = SalesOrder.class;
                    Field[] fields = clazz.getDeclaredFields();
                    boolean isFirst = true;
                    for (Field field : fields) {
                        String fieldName = field.getName();
                        String columnName = StringUtil.camelCaseToSnakeCase(fieldName);
                        String getterName = ReflectionUtil.getterName(field);
                        Method getter = clazz.getMethod(getterName);
                        Object obj = getter.invoke(order);

                        if (obj != null) {
                            if (isFirst) {
                                queryBuilder.append(" ");
                                isFirst = false;
                            } else {
                                queryBuilder.append(", ");
                            }
                            queryBuilder.append(columnName).append(" = ?");

                            parameterList.add(obj);
                        }
                    }

                    if (parameterList.size() > 0) {
                        queryBuilder.append(" WHERE ORDER_NUMBER = ?;");
                        parameterList.add(order.getId());

                        String query = queryBuilder.toString();
                        Object[] parameters = parameterList
                                .toArray(new Object[parameterList.size()]);
                        int effectedRow = qr.update(connection, query, parameters);

                        if (effectedRow == 0)
                            throw new RuntimeException("effected row:0, "
                                    + Arrays.toString(parameters));
                    }

                    importCounter++;
                }
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                // ignore
            }
        }

        System.out.println(String.format("imported %d recoreds", importCounter));
    }
}
