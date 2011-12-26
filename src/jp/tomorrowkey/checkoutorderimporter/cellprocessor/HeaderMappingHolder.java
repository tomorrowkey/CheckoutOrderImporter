
package jp.tomorrowkey.checkoutorderimporter.cellprocessor;

import org.supercsv.cellprocessor.NullObjectPattern;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.StrReplace;
import org.supercsv.cellprocessor.constraint.StrNotNullOrEmpty;


import java.util.HashMap;
import java.util.Map;

import jp.tomorrowkey.checkoutorderimporter.entity.Country;
import jp.tomorrowkey.checkoutorderimporter.entity.CountryCode;
import jp.tomorrowkey.checkoutorderimporter.entity.Currency;
import jp.tomorrowkey.checkoutorderimporter.entity.FinancialStatus;
import jp.tomorrowkey.checkoutorderimporter.entity.FulfillmentStatus;
import jp.tomorrowkey.checkoutorderimporter.entity.YesNo;

/**
 * 各カラムのパース方法を保持するクラス<br>
 */
public class HeaderMappingHolder {

    private Map<String, HeaderMapping> holder = new HashMap<String, HeaderMapping>();

    public HeaderMappingHolder() {
        // @formatter:off
        holder.put("Order ID",                new HeaderMapping("OrderID",               new StrNotNullOrEmpty()));
        holder.put("Merchant Order Number",   new HeaderMapping("MerchantOrderNumber",   NullObjectPattern.INSTANCE));
        holder.put("Order Creation Date",     new HeaderMapping("OrderCreationDate",     new ParseTimestamp("yyyy-MM-dd HH:mm:ss")));
        holder.put("Currency of Transaction", new HeaderMapping("CurrencyOfTransaction", new ParseEnum<Currency>(Currency.class)));
        holder.put("Order Amount",            new HeaderMapping("OrderAmount",           new RejectSeperator(new ParseDouble())));
        holder.put("Amount Charged",          new HeaderMapping("AmountCharged",         new RejectSeperator(new ParseDouble())));
        holder.put("Financial Status",        new HeaderMapping("FinancialStatus",       new StrReplace(" ", "_", new UpperCase(new ParseEnum<FinancialStatus>(FinancialStatus.class)))));
        holder.put("Fulfillment Status",      new HeaderMapping("FulfillmentStatus",     new StrReplace(" ", "_", new UpperCase(new ParseEnum<FulfillmentStatus>(FulfillmentStatus.class)))));
        holder.put("Link to Order",           new HeaderMapping("LinkToOrder",           NullObjectPattern.INSTANCE));
        holder.put("Total Tax",               new HeaderMapping("TotalTax",              new ParseDouble()));
        holder.put("Total Shipping",          new HeaderMapping("TotalShipping",         new ParseDouble()));
        holder.put("Amount Refunded",         new HeaderMapping("AmountRefunded",        new ParseDouble()));
        holder.put("Amount Charged Back",     new HeaderMapping("AmountChargedBack",     new ParseDouble()));
        holder.put("Chargeback Protection",   new HeaderMapping("ChargebackProtection",  new UpperCase(new ParseEnum<YesNo>(YesNo.class))));
        holder.put("Shipping Method",         new HeaderMapping("ShippingMethod",        NullObjectPattern.INSTANCE));
        holder.put("Email Marketing",         new HeaderMapping("EmailMarketing",        new UpperCase(new ParseEnum<YesNo>(YesNo.class))));
        holder.put("Buyer Email Address",     new HeaderMapping("BuyerEmailAddress",     NullObjectPattern.INSTANCE));
        holder.put("Buyer Name",              new HeaderMapping("BuyerName",             NullObjectPattern.INSTANCE));
        holder.put("Buyer Address 1",         new HeaderMapping("BuyerAddress1",         NullObjectPattern.INSTANCE));
        holder.put("Buyer Address 2",         new HeaderMapping("BuyerAddress2",         NullObjectPattern.INSTANCE));
        holder.put("Buyer City",              new HeaderMapping("BuyerCity",             NullObjectPattern.INSTANCE));
        holder.put("Buyer State",             new HeaderMapping("BuyerState",            NullObjectPattern.INSTANCE));
        holder.put("Buyer Postal Code",       new HeaderMapping("BuyerPostalCode",       NullObjectPattern.INSTANCE));
        holder.put("Buyer Country",           new HeaderMapping("BuyerCountry",          new StrReplace(" ", "_" , new UpperCase(new ParseEnum<Country>(Country.class)))));
        holder.put("Buyer Phone Number",      new HeaderMapping("BuyerPhoneNumber",      NullObjectPattern.INSTANCE));
        holder.put("Tracking Data",           new HeaderMapping("TrackingData",          NullObjectPattern.INSTANCE));
        holder.put("Item 1 ID",               new HeaderMapping("Item1ID",               NullObjectPattern.INSTANCE));
        holder.put("Item 1 Name",             new HeaderMapping("Item1Name",             NullObjectPattern.INSTANCE));
        holder.put("Item 1 Description",      new HeaderMapping("Item1Description",      NullObjectPattern.INSTANCE));
        holder.put("Item 1 Price",            new HeaderMapping("Item1Price",            new RejectSeperator(new ParseDouble())));
        holder.put("Item 1 Quantity",         new HeaderMapping("Item1Quantity",         new ParseInt()));
        holder.put("Item 2 ID",               new HeaderMapping("Item2ID",               NullObjectPattern.INSTANCE));
        holder.put("Item 2 Name",             new HeaderMapping("Item2Name",             NullObjectPattern.INSTANCE));
        holder.put("Item 2 Description",      new HeaderMapping("Item2Description",      NullObjectPattern.INSTANCE));
        holder.put("Item 2 Price",            new HeaderMapping("Item2Price",            new IgnoreNullOrEmpty(new RejectSeperator(new ParseDouble()))));
        holder.put("Item 2 Quantity",         new HeaderMapping("Item2Quantity",         new IgnoreNullOrEmpty(new ParseInt())));

        holder.put("Order Number",            new HeaderMapping("OrderNumber",           NullObjectPattern.INSTANCE));
        holder.put("Order Charged Date",      new HeaderMapping("OrderChargedDate",      new ParseDate("yyyy-MM-dd")));
        holder.put("Order Charged Timestamp", new HeaderMapping("OrderChargedTimestamp", new ParseLong()));
        // holder.put("Financial Status",        new HeaderMapping("FinancialStatus",       new StrReplace(" ", "_", new UpperCase(new ParseEnum<FinancialStatus>(FinancialStatus.class)))));
        holder.put("Payout Date",             new HeaderMapping("PayoutDate",            new ParseDate("yyyy-MM-dd")));
        holder.put("Device Model",            new HeaderMapping("DeviceModel",           NullObjectPattern.INSTANCE));
        holder.put("Product Title",           new HeaderMapping("ProductTitle",          NullObjectPattern.INSTANCE));
        holder.put("Product ID",              new HeaderMapping("ProductID",             NullObjectPattern.INSTANCE));
        holder.put("Currency of Sale",        new HeaderMapping("CurrencyOfSale",        new UpperCase(new ParseEnum<Currency>(Currency.class))));
        holder.put("Item Price",              new HeaderMapping("ItemPrice",             new RejectSeperator(new ParseDouble())));
        holder.put("Taxes Collected",         new HeaderMapping("TaxesCollected",        new RejectSeperator(new ParseDouble())));
        holder.put("Charged Amount",          new HeaderMapping("ChargedAmount",         new RejectSeperator(new ParseDouble())));
        holder.put("Merchant Currency",       new HeaderMapping("MerchantCurrency",      new UpperCase(new ParseEnum<Currency>(Currency.class))));
        holder.put("Estimated FX Rate",       new HeaderMapping("EstimatedFXRate",       new IgnoreNullOrEmpty(new RejectSeperator(new ParseDouble()))));
        holder.put("Merchant Receives",       new HeaderMapping("MerchantReceives",      new RejectSeperator(new ParseDouble())));
        holder.put("City of Buyer",           new HeaderMapping("CityOfBuyer",           NullObjectPattern.INSTANCE));
        holder.put("State of Buyer",          new HeaderMapping("StateOfBuyer",          NullObjectPattern.INSTANCE));
        holder.put("Postal Code of Buyer",    new HeaderMapping("PostalCodeOfBuyer",     NullObjectPattern.INSTANCE));
        holder.put("Country of Buyer",        new HeaderMapping("CountryOfBuyer",        new UpperCase(new ParseEnum<CountryCode>(CountryCode.class))));
        // @formatter:on
    }

    public HeaderMapping get(String headerName) {
        if (!holder.containsKey(headerName))
            throw new IllegalArgumentException("unknown header:" + headerName);

        return holder.get(headerName);
    }
}
