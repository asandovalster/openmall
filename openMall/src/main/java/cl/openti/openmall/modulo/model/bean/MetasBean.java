package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.Date;

public class MetasBean implements Serializable {

	private int id_local;
	
	private Date fecha;
	
	// horas
	private int hora;
	// unidades
	private int unidades;
	// boletas
	private int boletas;
	// ventas
	private long ventas;

	public MetasBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public MetasBean(int id_local, Date fecha, int hora, int unidades,
			int boletas, long ventas) {
		super();
		this.id_local = id_local;
		this.fecha = fecha;
		this.hora = hora;
		this.unidades = unidades;
		this.boletas = boletas;
		this.ventas = ventas;
	}


	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public int getBoletas() {
		return boletas;
	}

	public void setBoletas(int boletas) {
		this.boletas = boletas;
	}

	public long getVentas() {
		return ventas;
	}

	public void setVentas(long ventas) {
		this.ventas = ventas;
	}

	public int getId_local() {
		return id_local;
	}

	public void setId_local(int id_local) {
		this.id_local = id_local;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
