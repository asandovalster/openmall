package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.ArticuloGarantiaBean;
import cl.openti.openmall.modulo.model.bean.BoletaGarantiaBean;

@SuppressWarnings("serial")
public class BoletaGarantiaDataModel extends PrimeDataModel<BoletaGarantiaBean> {

	public BoletaGarantiaDataModel() {
	}

	public BoletaGarantiaDataModel(Object data) {
		super(data);
	}

	@Override
	public BoletaGarantiaBean getRowData(String rowKey) {

		List<BoletaGarantiaBean> boletas = (List<BoletaGarantiaBean>) getWrappedData();

		for (BoletaGarantiaBean boleta : boletas) {
			if (boleta.getId_boleta() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
				return boleta;
			}
		}
		return null;
	}

	@Override
	public String getRowKey(BoletaGarantiaBean boleta) {
		return boleta.getId_boleta() + "";
	}

}
