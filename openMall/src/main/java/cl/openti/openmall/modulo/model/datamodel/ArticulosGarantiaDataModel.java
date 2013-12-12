package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.ArticuloGarantiaBean;



@SuppressWarnings("serial")
public class ArticulosGarantiaDataModel extends PrimeDataModel<ArticuloGarantiaBean> {

	public ArticulosGarantiaDataModel() {
	}

	public ArticulosGarantiaDataModel(Object data) {
		super(data);
	}

	@Override
	public ArticuloGarantiaBean getRowData(String rowKey) {

		List<ArticuloGarantiaBean> articulos = (List<ArticuloGarantiaBean>) getWrappedData();

		for (ArticuloGarantiaBean articulo : articulos) {
			if (articulo.getId_articulo() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
				return articulo;
			}
		}
		return null;
	}

	@Override
	public String getRowKey(ArticuloGarantiaBean articulo) {
		return articulo.getId_articulo() + "";
	}

}
