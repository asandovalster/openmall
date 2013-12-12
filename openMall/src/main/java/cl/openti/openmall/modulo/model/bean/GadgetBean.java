package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;


public class GadgetBean implements Serializable {

	private static final long serialVersionUID = -2464421154182761688L;
	private int id = 0;
	private int idusuario = 0;
	private String descripcion = "";
	private String viewId = "";
	private String icono = "";
	private String icono2 = "";
	private String titulo = "";
	private UsuarioBean usuario = new UsuarioBean();
	
	public GadgetBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public GadgetBean(int id, int idusuario, String descripcion, String viewId,
			String icono, String icono2, UsuarioBean usuario) {
		super();
		this.id = id;
		this.idusuario = idusuario;
		this.descripcion = descripcion;
		this.viewId = viewId;
		this.icono = icono;
		this.icono2 = icono2;
		this.usuario = usuario;
	}




	public GadgetBean(int id, int idusuario, String descripcion, String viewId,
			String icono, String icono2, String titulo, UsuarioBean usuario) {
		super();
		this.id = id;
		this.idusuario = idusuario;
		this.descripcion = descripcion;
		this.viewId = viewId;
		this.icono = icono;
		this.icono2 = icono2;
		this.titulo = titulo;
		this.usuario = usuario;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getViewId() {
		return viewId;
	}
	public void setViewId(String viewId) {
		this.viewId = viewId;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getIcono2() {
		return icono2;
	}

	public void setIcono2(String icono2) {
		this.icono2 = icono2;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	
	  
	
	
}
