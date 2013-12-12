package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cl.openti.openmall.modulo.model.datamodel.SalesDataModel;
import cl.openti.openmall.modulo.model.datamodel.SellerDataModel;

public class DsctoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fecha;
	
	private long codigoTienda = 0;
	private String tienda;
	private String vendedor;
	private String supervisor;
	private long montoBase = 0;
	private long montoNeto = 0;
	private long dscto = 0;
	private double por_dscto = 0;
	
	/**
	 * Vendedor y Supervisor
	 */
	private List<SalesBean> saless = new ArrayList<SalesBean>();
	private  SalesDataModel modelSales = new SalesDataModel();

	
	
	
	
	private List<SellerBean> sellers = new ArrayList<SellerBean>();
	
	private  SellerDataModel modelSeller = new SellerDataModel();
	
	
	
	
	public DsctoBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DsctoBean(String fecha, long codigoTienda, String tienda,
			String vendedor, long montoBase, long montoNeto, long dscto,
			double por_dscto) {
		super();
		this.fecha = fecha;
		this.codigoTienda = codigoTienda;
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

	public List<SellerBean> getSellers() {
		return sellers;
	}

	public void setSellers(List<SellerBean> sellers) {
		this.sellers = sellers;
	}

	public SellerDataModel getModelSeller() {
		return modelSeller;
	}

	public void setModelSeller(SellerDataModel modelSeller) {
		this.modelSeller = modelSeller;
	}

	public long getCodigoTienda() {
		return codigoTienda;
	}

	public void setCodigoTienda(long codigoTienda) {
		this.codigoTienda = codigoTienda;
	}

	public List<SalesBean> getSaless() {
		return saless;
	}

	public void setSaless(List<SalesBean> saless) {
		this.saless = saless;
	}

	public SalesDataModel getModelSales() {
		return modelSales;
	}

	public void setModelSales(SalesDataModel modelSales) {
		this.modelSales = modelSales;
	}

	
}