package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.VendedorGarantiaBean;

@SuppressWarnings("serial")
public class VendedorGarantiaDataModel extends PrimeDataModel<VendedorGarantiaBean> {

	public VendedorGarantiaDataModel() {
	}

	public VendedorGarantiaDataModel(Object data) {
		super(data);
	}

	@Override
	public VendedorGarantiaBean getRowData(String rowKey) {

		List<VendedorGarantiaBean> vendedores = (List<VendedorGarantiaBean>) getWrappedData();

		for (VendedorGarantiaBean vendedor : vendedores) {
			if (vendedor.getId_vendedor() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
				return vendedor;
			}
		}
		return null;
	}

	@Override
	public String getRowKey(VendedorGarantiaBean vendedor) {
		return vendedor.getId_vendedor() + "";
	}

}
