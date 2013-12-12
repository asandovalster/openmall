package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.LocalGarantiaBean;

@SuppressWarnings("serial")
public class LocalGarantiaDataModel extends PrimeDataModel<LocalGarantiaBean> {

	public LocalGarantiaDataModel() {
	}

	public LocalGarantiaDataModel(Object data) {
		super(data);
	}

	@Override
	public LocalGarantiaBean getRowData(String rowKey) {

		List<LocalGarantiaBean> locales = (List<LocalGarantiaBean>) getWrappedData();

		for (LocalGarantiaBean local : locales) {
			if (local.getId_local() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
				return local;
			}
		}
		return null;
	}

	@Override
	public String getRowKey(LocalGarantiaBean local) {
		return local.getId_local() + "";
	}

}
