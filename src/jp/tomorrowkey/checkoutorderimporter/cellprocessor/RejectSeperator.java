
package jp.tomorrowkey.checkoutorderimporter.cellprocessor;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.NullInputException;
import org.supercsv.util.CSVContext;

public class RejectSeperator extends CellProcessorAdaptor {

    public RejectSeperator() {
        super();
    }

    public RejectSeperator(CellProcessor next) {
        super(next);
    }

    @Override
    public Object execute(Object value, CSVContext context) {
        if (value == null)
            throw new NullInputException("Input cannot be null on line " + context.lineNumber
                    + " column " + context.columnNumber, context, this);
        if (value instanceof String)
            value = ((String)value).replaceAll(",", "");

        return next.execute(value, context);
    }
}
