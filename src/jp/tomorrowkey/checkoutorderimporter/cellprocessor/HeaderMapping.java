
package jp.tomorrowkey.checkoutorderimporter.cellprocessor;

import org.supercsv.cellprocessor.ift.CellProcessor;

public class HeaderMapping {

    private String fieldName;

    private CellProcessor cellProcessor;

    public HeaderMapping(String fieldName, CellProcessor cellProcessor) {
        this.fieldName = fieldName;
        this.cellProcessor = cellProcessor;
    }

    public String getFieldName() {
        return fieldName;
    }

    public CellProcessor getCellProcessor() {
        return cellProcessor;
    }
}
