package cl.openti.openmall.modulo.model.datamodel;

import java.io.Serializable;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class PrimeDataModel<T> extends ListDataModel implements SelectableDataModel<T>, Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrimeDataModel() {}
    
    public PrimeDataModel(Object data) {
        setWrappedData(data);
    }
    
    public Object getRowKey(T object) {
        throw new UnsupportedOperationException("Must be implemented");
    }
    
    public T getRowData(String rowKey) {
        throw new UnsupportedOperationException("Must be implemented");
    }
}
