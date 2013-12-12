package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;

public class AnexoBean implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id =0;
	private String nombre = "";
	private String anexo = "";
	private String cargo = "";
	private String departamento = "";
	private String direccion = "";
	private String mapa = "";
	private String foto = "";
	private String email = "";
	private double rating = 0;
	
	/**
	 *  u.id_usuario,du.nombres,du.apellidos,du.anexo,c.descripcion as 'cargo',d.descripcion as 'departamento',d.direccion as 'direccion'
	 */
	
	
	
	public AnexoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public AnexoBean(int id, String nombre, String anexo, String cargo,
			String departamento, String direccion, String mapa, String foto,
			String email, double rating) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anexo = anexo;
		this.cargo = cargo;
		this.departamento = departamento;
		this.direccion = direccion;
		this.mapa = mapa;
		this.foto = foto;
		this.email = email;
		this.rating = rating;
	}



	public AnexoBean(int id, String nombre, String anexo, String cargo,
			String departamento, String direccion, String mapa, String foto,
			String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anexo = anexo;
		this.cargo = cargo;
		this.departamento = departamento;
		this.direccion = direccion;
		this.mapa = mapa;
		this.foto = foto;
		this.email = email;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAnexo() {
		return anexo;
	}
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMapa() {
		return mapa;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	
	
}
