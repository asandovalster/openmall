package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cl.openti.openmall.modulo.model.datamodel.BoletaDataModel;



public class SalesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id_sales = 0;
	
	private String fecha;
	private String tienda;
	private String vendedor;
	private String supervisor;
	private long montoBase = 0;
	private long montoNeto = 0;
	private long dscto = 0;
	private double por_dscto = 0;
	
	
	private List<BoletaBean> boletas = new ArrayList<BoletaBean>();
	
	private  BoletaDataModel modelBoleta = new BoletaDataModel();
	
	
	
	
	public SalesBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesBean(long id_sales ,String fecha, String tienda, String vendedor,long montoBase,long montoNeto, long dscto, double por_dscto) {
		super();
		this.id_sales = id_sales; 
		this.fecha = fecha;
		this.tienda = tienda;
		this.vendedor = vendedor;
		this.montoBase = montoBase;
		this.montoNeto = montoNeto;
		this.dscto = dscto;
		this.por_dscto = por_dscto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public long getMontoNeto() {
		return montoNeto;
	}

	public void setMontoNeto(long montoNeto) {
		this.montoNeto = montoNeto;
	}

	public long getDscto() {
		return dscto;
	}

	public void setDscto(long dscto) {
		this.dscto = dscto;
	}

	public double getPor_dscto() {
		return por_dscto;
	}

	public void setPor_dscto(double por_dscto) {
		this.por_dscto = por_dscto;
	}

	public long getMontoBase() {
		return montoBase;
	}

	public void setMontoBase(long montoBase) {
		this.montoBase = montoBase;
	}

	public long getId_sales() {
		return id_sales;
	}

	public void setId_sales(long id_sales) {
		this.id_sales = id_sales;
	}

	public List<BoletaBean> getBoletas() {
		return boletas;
	}

	public void setBoletas(List<BoletaBean> boletas) {
		this.boletas = boletas;
	}

	public BoletaDataModel getModelBoleta() {
		return modelBoleta;
	}

	public void setModelBoleta(BoletaDataModel modelBoleta) {
		this.modelBoleta = modelBoleta;
	}


	
	
}