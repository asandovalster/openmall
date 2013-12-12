package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.LocalBean;


public class LocalDataModel extends PrimeDataModel<LocalBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2385463321986669379L;

	public LocalDataModel() {
	}

	public LocalDataModel(Object data) {
		super(data);
	}

	@Override
	public LocalBean getRowData(String rowKey) {

		List<LocalBean> locales = (List<LocalBean>) getWrappedData();

		for (LocalBean local : locales) {
			if (local.getId_local() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);

				
				return local;
			}
			
		}
		return null;
	}

	@Override
	public String getRowKey(LocalBean local) {
		return local.getId_local() + "";
	}

	
   
}