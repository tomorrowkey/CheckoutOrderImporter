
package jp.tomorrowkey.checkoutorderimporter.cellprocessor;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.cellprocessor.ift.StringCellProcessor;
import org.supercsv.exception.NullInputException;
import org.supercsv.util.CSVContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParseTimestamp extends CellProcessorAdaptor implements StringCellProcessor {

    private DateFormat formatter;

    public ParseTimestamp(String pattern) {
        super();
        setPattern(pattern);
    }

    public ParseTimestamp(String pattern, CellProcessor next) {
        super(next);
        setPattern(pattern);
    }

    private void setPattern(String pattern) {
        formatter = new SimpleDateFormat(pattern);
    }

    @Override
    public Object execute(Object value, CSVContext context) {
        if (value == null)
            throw new NullInputException("Input cannot be null on line " + context.lineNumber
                    + " column " + context.columnNumber, context, this);
        if (value instanceof String) {
            try {
                value = formatter.parse((String)value).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        return next.execute(value, context);
    }

}
