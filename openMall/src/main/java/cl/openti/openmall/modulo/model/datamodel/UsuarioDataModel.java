package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.UsuarioBean;


public class UsuarioDataModel extends PrimeDataModel<UsuarioBean> {

	public UsuarioDataModel() {
	}

	public UsuarioDataModel(Object data) {
		super(data);
	}

	@Override
	public UsuarioBean getRowData(String rowKey) {

		List<UsuarioBean> usuarios = (List<UsuarioBean>) getWrappedData();

		for (UsuarioBean usuario : usuarios) {
			if (usuario.getIdusuario() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
				return usuario;
			}
		}

		return null;
	}

	@Override
	public String getRowKey(UsuarioBean usuario) {
		return usuario.getIdusuario() + "";
	}

}
