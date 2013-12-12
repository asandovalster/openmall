package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;


public class ItemBoletaBean implements Serializable {


	private String fecha;
	private String hora;
	private String seccion;
	private String familia;
	private String articulo;
	private String glosa_prdto;
	private long precio;
	private long cantidad;
	private String vendedor;
	private String cod_local;
	private String local;
	public ItemBoletaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ItemBoletaBean(String fecha, String hora,
			String seccion, String familia, String articulo,
			String glosa_prdto, long precio,long cantidad, String vendedor, String cod_local, String local) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.seccion = seccion;
		this.familia = familia;
		this.articulo = articulo;
		this.glosa_prdto = glosa_prdto;
		this.precio = precio;
		this.cantidad= cantidad;
		this.vendedor = vendedor;
		this.cod_local = cod_local;
		this.local = local;
	}



	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getGlosa_prdto() {
		return glosa_prdto;
	}
	public void setGlosa_prdto(String glosa_prdto) {
		this.glosa_prdto = glosa_prdto;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getCod_local() {
		return cod_local;
	}
	public void setCod_local(String cod_local) {
		this.cod_local = cod_local;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}



	public long getPrecio() {
		return precio;
	}



	public void setPrecio(long precio) {
		this.precio = precio;
	}



	public long getCantidad() {
		return cantidad;
	}



	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
	
		
	
}