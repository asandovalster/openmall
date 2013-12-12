package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cl.openti.openmall.modulo.model.datamodel.AreaDataModel;
import cl.openti.openmall.modulo.model.datamodel.MetasDataModel;

public class LocalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_local;
	private String fecha;
	private String fechaC;
	private String local;
	public long metas=0;
	private long ventas=0;
	// VENTAS SEGMENTADAS
	private long ventas13=0;
	private long ventas15=0;
	private long ventas18=0;
	private long ventas23=0;
	// AVANCES SEGMENTADOS
	private double avance = 0;
	private double avance13 = 0;
	private double avance15 = 0;
	private double avance18 = 0;
	private double avance23 = 0;
	
	private int unidades = 0;
	private int boletas = 0;
	
	
	private List<MetasBean> metasBean = new ArrayList<MetasBean>(); 
	
	private List<AreaBean> areas = new ArrayList<AreaBean>(); 
	
	private AreaDataModel modelArea = new AreaDataModel();
	
	private MetasDataModel modelMetas = new MetasDataModel();
	
	
	
	
	
	public LocalBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalBean(String fecha,String fechaC, String local, long metas, long ventas,
			double avance) {
		super();
		this.fecha = fecha;
		this.fechaC = fechaC;
		this.local = local;
		this.metas = metas;
		this.ventas = ventas;
		this.avance = avance;
	}
	
	public LocalBean(String fecha, String fechaC, String local, long metas,
			long ventas13, long ventas15, long ventas18, long ventas23) {
		super();
		this.fecha = fecha;
		this.fechaC = fechaC;
		this.local = local;
		this.metas = metas;
		this.ventas13 = ventas13;
		this.ventas15 = ventas15;
		this.ventas18 = ventas18;
		this.ventas23 = ventas23;
		
	}
	public LocalBean(String fecha,String local, long metas, long ventas,
			double avance) {
		super();
		this.fecha = fecha;
		this.fechaC = fechaC;
		this.local = local;
		this.metas = metas;
		this.ventas = ventas;
		this.avance = avance;
	}
	/**
	 * Para el reporte de Metas 
	 * @param id_local
	 * @param fecha
	 * @param local
	 * @param ventas
	 * @param unidades
	 * @param boletas
	 */
	public LocalBean(int id_local, String fecha, String local, long ventas,
			int unidades, int boletas) {
		super();
		this.id_local = id_local;
		this.fecha = fecha;
		this.local = local;
		this.ventas = ventas;
		this.unidades = unidades;
		this.boletas = boletas;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public long getMetas() {
		return metas;
	}
	public void setMetas(long metas) {
		this.metas = metas;
	}
	
	public long getVentas13() {
		
		return ventas13;
	}
	public void setVentas13(long ventas13) {
		this.ventas13 = ventas13;
	}
	public long getVentas15() {
		
		return ventas15;
	}
	public void setVentas15(long ventas15) {
		this.ventas15 = ventas15;
	}
	public long getVentas18() {
		
		
		return ventas18;
	}
	public void setVentas18(long ventas18) {
		this.ventas18 = ventas18;
	}
	public long getVentas23() {
		
		return ventas23;
	}
	public void setVentas23(long ventas23) {
		this.ventas23 = ventas23;
	}
	public double getAvance13() {

		if(metas > 0)
			avance13 = Double.valueOf(ventas13).doubleValue() / Double.valueOf(metas).doubleValue();
		
		return avance13;
	}
	public void setAvance13(double avance13) {
		
		this.avance13 = avance13;
	}
	public double getAvance15() {
		
		if(metas > 0)
			avance15 = Double.valueOf(ventas15).doubleValue() / Double.valueOf(metas).doubleValue();
		
		return avance15;
	}
	public void setAvance15(double avance15) {
		this.avance15 = avance15;
	}
	public double getAvance18() {
		
		if(metas > 0)
			avance18 = Double.valueOf(ventas18).doubleValue() / Double.valueOf(metas).doubleValue();
		
		return avance18;
	}
	public void setAvance18(double avance18) {
		this.avance18 = avance18;
	}
	public double getAvance23() {
		
		if(metas > 0)
			avance23 = Double.valueOf(ventas23).doubleValue() / Double.valueOf(metas).doubleValue();
		
		return avance23;
	}
	public void setAvance23(double avance23) {
		this.avance23 = avance23;
	}
	public String getFechaC() {
		return fechaC;
	}
	public void setFechaC(String fechaC) {
		this.fechaC = fechaC;
	}
	public List<AreaBean> getAreas() {
		return areas;
	}
	public void setAreas(List<AreaBean> areas) {
		this.areas = areas;
	}
	public AreaDataModel getModelArea() {
		return modelArea;
	}
	public void setModelArea(AreaDataModel modelArea) {
		this.modelArea = modelArea;
	}
	public long getVentas() {
		return ventas;
	}
	public void setVentas(long ventas) {
		this.ventas = ventas;
	}
	public double getAvance() {
		if(getMetas() > 0)
		{	
			//System.out.println( "Metas:"+getMetas() + " Venta13:"+ getVentas13() +" Avance13:" + getAvance13() + " Avance15:"+ getAvance15() + " Venta15:"+ getVentas15() + "  Avance18:" + getAvance18() + " Venta18:"+ getVentas18() +" Avance23:"+getAvance23() + " Venta23:"+ getVentas23());
			
			if(getVentas13()>0)	
				avance = getAvance13();
			
			if(getVentas15()>0)	
				avance = getAvance15();
			
			if(getVentas18()>0)
				avance = getAvance18();
			
			if(getVentas23()>0)
				avance = getAvance23();
		}else{
			
			avance = 1;
		}
		
		return avance;
	}
	public void setAvance(double avance) {
		this.avance = avance;
	}
	public int getId_local() {
		return id_local;
	}
	public void setId_local(int id_local) {
		this.id_local = id_local;
	}
	public List<MetasBean> getMetasBean() {
		return metasBean;
	}
	public void setMetasBean(List<MetasBean> metasBean) {
		this.metasBean = metasBean;
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
	public MetasDataModel getModelMetas() {
		return modelMetas;
	}
	public void setModelMetas(MetasDataModel modelMetas) {
		this.modelMetas = modelMetas;
	}
	
	
	
	
}