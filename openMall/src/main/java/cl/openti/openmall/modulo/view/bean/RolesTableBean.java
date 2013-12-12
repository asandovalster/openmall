package cl.openti.openmall.modulo.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cl.openti.openmall.modulo.model.bean.RolBean;

public class RolesTableBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1708344652269046164L;
	private List<RolBean> roles;
	private RolBean selectedRol;

	public RolesTableBean() {

		roles = new ArrayList<RolBean>();

	}

	public List<RolBean> getRoles() {
		return roles;
	}

	public void setRoles(List<RolBean> roles) {
		this.roles = roles;
	}

	public RolBean getSelectedRol() {
		return selectedRol;
	}

	public void setSelectedRol(RolBean selectedRol) {
		this.selectedRol = selectedRol;
	}

}