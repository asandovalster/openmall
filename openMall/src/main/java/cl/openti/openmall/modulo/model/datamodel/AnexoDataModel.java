package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.AnexoBean;



public class AnexoDataModel extends PrimeDataModel<AnexoBean> {

	public AnexoDataModel() {
	}

	public AnexoDataModel(Object data) {
		super(data);
	}

	@Override
	public AnexoBean getRowData(String rowKey) {

		List<AnexoBean> anexos = (List<AnexoBean>) getWrappedData();

		for (AnexoBean anexo : anexos) {
			if (anexo.getId() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
				return anexo;
			}
		}

		return null;
	}

	@Override
	public String getRowKey(AnexoBean anexo) {
		return anexo.getId() + "";
	}

}
