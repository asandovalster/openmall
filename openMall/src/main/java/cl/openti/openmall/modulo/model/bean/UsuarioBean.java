package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;


public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = -2464421154182761688L;
	private int idusuario = 0;
	private PerfilBean perfil;
	private String nombre = "";
	private String apellido = "";
	private String email = "";
	private String foto = "";
	private String icono = "";
	private String cargo = "";
	
	
	
	public UsuarioBean(int idusuario, PerfilBean perfil, String nombre,
			String apellido, String email, String foto, String icono) {
		super();
		this.idusuario = idusuario;
		this.perfil = perfil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.foto = foto;
		this.icono = icono;
	}

	public UsuarioBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public PerfilBean getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
   
}
