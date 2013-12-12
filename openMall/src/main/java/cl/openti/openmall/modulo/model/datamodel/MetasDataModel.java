package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.MetasBean;




public class MetasDataModel extends PrimeDataModel<MetasBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1272613435247029063L;

	public MetasDataModel() {
	}

	public MetasDataModel(Object data) {
		super(data);
	}

	@Override
	public MetasBean getRowData(String rowKey) {

		List<MetasBean> metas = (List<MetasBean>) getWrappedData();

		for (MetasBean meta : metas) {
			if (meta.getId_local() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
				return meta;
			}
		}
		return null;
	}

	@Override
	public String getRowKey(MetasBean area) {
		return area.getId_local() + "";
	}

}
