
package jp.tomorrowkey.checkoutorderimporter.cellprocessor;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CSVContext;

public class IgnoreNullOrEmpty extends CellProcessorAdaptor {

    public IgnoreNullOrEmpty() {
        super();
    }

    public IgnoreNullOrEmpty(CellProcessor next) {
        super(next);
    }

    @Override
    public Object execute(Object value, CSVContext context) {
        if (value == null)
            return null;
        if (value instanceof String && ((String)value).isEmpty())
            return null;

        return next.execute(value, context);
    }
}
