package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PerfilBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2464421154182761688L;
	private int idperfil=0;
	private int idpadre=0;
	private String nombre="";
	private List<RolBean> roles = new ArrayList<RolBean>();	
	
	
	public PerfilBean(int idperfil, String nombre) {
		super();
		this.idperfil = idperfil;
		this.nombre = nombre;
	}

	
	public PerfilBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerfilBean(int idperfil, int idpadre, String nombre,
			List<RolBean> roles) {
		super();
		this.idperfil = idperfil;
		this.idpadre = idpadre;
		this.nombre = nombre;
		this.roles = roles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(int idperfil) {
		this.idperfil = idperfil;
	}

	public int getIdpadre() {
		return idpadre;
	}

	public void setIdpadre(int idpadre) {
		this.idpadre = idpadre;
	}

	public List<RolBean> getRoles() {
		return roles;
	}

	public void setRoles(List<RolBean> roles) {
		this.roles = roles;
	}
	
	
	
	
}
