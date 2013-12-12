package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;


public class RolBean implements Serializable {

	private int idrol = 0;
	private String rol = "";
	PerfilBean perfil;
	private String descripcion = "";

	
	
	
	public RolBean(int idrol, String rol, PerfilBean perfil) {
		super();
		this.idrol = idrol;
		this.rol = rol;
		this.perfil = perfil;
	}

	public RolBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	
	public PerfilBean getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
