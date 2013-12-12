package cl.openti.openmall.modulo.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cl.openti.openmall.modulo.model.bean.PerfilBean;


public class PerfilesTableBean implements Serializable {

	private List<PerfilBean> perfiles;
	private PerfilBean selectedPerfil;

	public PerfilesTableBean() {

		perfiles = new ArrayList<PerfilBean>();

	}

	public List<PerfilBean> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<PerfilBean> perfiles) {
		this.perfiles = perfiles;
	}

	public PerfilBean getSelectedPerfil() {
		return selectedPerfil;
	}

	public void setSelectedPerfil(PerfilBean selectedPerfil) {
		this.selectedPerfil = selectedPerfil;
	}

	
	
}