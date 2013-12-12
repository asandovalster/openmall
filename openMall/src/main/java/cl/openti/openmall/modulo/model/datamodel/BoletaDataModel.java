package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.BoletaBean;


public class BoletaDataModel extends PrimeDataModel<BoletaBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2385463321986669379L;

	public BoletaDataModel() {
	}

	public BoletaDataModel(Object data) {
		super(data);
	}

	@Override
	public BoletaBean getRowData(String rowKey) {

		List<BoletaBean> boletas = (List<BoletaBean>) getWrappedData();
        
		for (BoletaBean boleta : boletas) {
			if (boleta.getNumBoleta() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
				
				return boleta;
			}
			
		}
		return null;
	}

	@Override
	public String getRowKey(BoletaBean boleta) {
		return boleta.getNumBoleta() + "";
	}
	
	
}
