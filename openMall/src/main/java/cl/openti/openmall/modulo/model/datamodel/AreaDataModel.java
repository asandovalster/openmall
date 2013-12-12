package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.AreaBean;


public class AreaDataModel extends PrimeDataModel<AreaBean> {

	public AreaDataModel() {
	}

	public AreaDataModel(Object data) {
		super(data);
	}

	@Override
	public AreaBean getRowData(String rowKey) {

		List<AreaBean> areas = (List<AreaBean>) getWrappedData();

		for (AreaBean area : areas) {
			if (area.getId_area() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
				return area;
			}
		}
		return null;
	}

	@Override
	public String getRowKey(AreaBean area) {
		return area.getId_area() + "";
	}

}
