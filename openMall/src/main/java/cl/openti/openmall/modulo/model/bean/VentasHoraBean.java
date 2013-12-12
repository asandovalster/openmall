package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cl.openti.openmall.modulo.model.datamodel.LocalDataModel;

public class VentasHoraBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fecha;
	private String fechaC;
	private String hora;
	private long metas=0;
	private long ventas=0;
	private double avance = 0;
	
	
	private String smetas="";
	private String sventas="";
	private String savance = "";
	
	
	private List<LocalBean> locales = new ArrayList<LocalBean>(); 
	
	private LocalDataModel modelLocal = new LocalDataModel();
	
	
	public VentasHoraBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public VentasHoraBean(String fecha, String fechaC, String hora, long metas,
			long ventas, double avance, List<LocalBean> locales,
			LocalDataModel modelLocal) {
		super();
		this.fecha = fecha;
		this.fechaC = fechaC;
		this.hora = hora;
		this.metas = metas;
		this.ventas = ventas;
		this.avance = avance;
		this.locales = locales;
		this.modelLocal = modelLocal;
	}
	
	



	public VentasHoraBean(String fecha, String fechaC, String hora, long metas,
			long ventas, double avance) {
		super();
		this.fecha = fecha;
		this.fechaC = fechaC;
		this.hora = hora;
		this.metas = metas;
		this.ventas = ventas;
		this.avance = avance;
	}



	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getFechaC() {
		return fechaC;
	}


	public void setFechaC(String fechaC) {
		this.fechaC = fechaC;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public long getMetas() {
		return metas;
	}


	public void setMetas(long metas) {
		this.metas = metas;
	}


	public long getVentas() {
		return ventas;
	}


	public void setVentas(long ventas) {
		this.ventas = ventas;
	}


	public double getAvance() {
		return avance;
	}


	public void setAvance(double avance) {
		this.avance = avance;
	}


	public List<LocalBean> getLocales() {
		return locales;
	}


	public void setLocales(List<LocalBean> locales) {
		this.locales = locales;
	}


	public LocalDataModel getModelLocal() {
		return modelLocal;
	}


	public void setModelLocal(LocalDataModel modelLocal) {
		this.modelLocal = modelLocal;
	}



	public String getSmetas() {
		
		
		if((""+metas).length() >= 4){
			smetas = (""+metas).substring(0,(""+metas).length()-3)
					+"."+
					(""+metas).substring((""+metas).length()-3, (""+metas).length());
		}
		
		return "$ " + smetas;
	}



	public void setSmetas(String smetas) {
		this.smetas = smetas;
	}



	public String getSventas() {
		if((""+ventas).length() >= 4){
			sventas = (""+ventas).substring(0,(""+ventas).length()-3)
					+"."+
					(""+ventas).substring((""+ventas).length()-3, (""+ventas).length());
		}
		
		return "$ " + sventas;
	}



	public void setSventas(String sventas) {
		this.sventas = sventas;
	}



	public String getSavance() {
		//System.out.println(":::::::::::::::::::::::::::::::::::::::::: ventas: " + ventas);
		//System.out.println(":::::::::::::::::::::::::::::::::::::::::: metas:" + metas);
		avance = Double.valueOf(ventas) / Double.valueOf(metas);
		//System.out.println(":::::::::::::::::::::::::::::::::::::::::: avance:" + avance);
		savance = Math.round(avance*100) + "%";
		//System.out.println(":::::::::::::::::::::::::::::::::::::::::: math avance:" + Math.round(avance) + "%");
		return savance;
	}



	public void setSavance(String savance) {
		this.savance = savance;
	}
	
	
	
	
}