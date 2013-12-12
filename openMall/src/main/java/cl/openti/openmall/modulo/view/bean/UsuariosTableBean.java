package cl.openti.openmall.modulo.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cl.openti.openmall.modulo.model.bean.UsuarioBean;


public class UsuariosTableBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8300872487067362418L;
	private List<UsuarioBean> usuarios;
	private UsuarioBean  selectedUsuario;

	public UsuariosTableBean() {

		usuarios = new ArrayList<UsuarioBean>();

	}

	public List<UsuarioBean> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioBean> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioBean getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(UsuarioBean selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

		
	
}