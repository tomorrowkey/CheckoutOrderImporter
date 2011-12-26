
package jp.tomorrowkey.checkoutorderimporter.cellprocessor;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.cellprocessor.ift.StringCellProcessor;
import org.supercsv.exception.ClassCastInputCSVException;
import org.supercsv.exception.NullInputException;
import org.supercsv.util.CSVContext;

public class ParseEnum<T extends Enum<T>> extends CellProcessorAdaptor implements
        StringCellProcessor {

    private Class<T> enumType;

    public ParseEnum(Class<T> enumType) {
        super();
        this.enumType = enumType;
    }

    public ParseEnum(Class<T> enumType, CellProcessor next) {
        super(next);
        this.enumType = enumType;
    }

    @Override
    public Object execute(Object value, CSVContext context) {
        if (value == null)
            throw new NullInputException("Input cannot be null on line " + context.lineNumber
                    + " column " + context.columnNumber, context, this);
        if (!(value instanceof String))
            throw new ClassCastInputCSVException("the value '" + value + "' is not of type String",
                    context, this);

        String str = (String)value;
        T result = Enum.valueOf(enumType, str);
        return next.execute(result, context);
    }
}
