package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.RolBean;



public class RolDataModel extends PrimeDataModel<RolBean> {

	public RolDataModel() {
	}

	public RolDataModel(Object data) {
		super(data);
	}

	@Override
	public RolBean getRowData(String rowKey) {

		List<RolBean> roles = (List<RolBean>) getWrappedData();

		for (RolBean rol : roles) {
			if (rol.getIdrol() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
				return rol;
			}
		}

		return null;
	}

	@Override
	public String getRowKey(RolBean rol) {
		return rol.getIdrol() + "";
	}

}
