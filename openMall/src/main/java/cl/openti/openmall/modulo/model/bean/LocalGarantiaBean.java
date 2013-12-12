package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.openti.openmall.modulo.model.datamodel.AreaDataModel;
import cl.openti.openmall.modulo.model.datamodel.VendedorGarantiaDataModel;

public class LocalGarantiaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fecha = null;
	private Date dfecha;
	private int id_local;
	private String tienda;
	private String departamento;
	// VENTAS SEGMENTADAS
	private long unidades=0;
	private double cantidad_boletas = 0;
	private long baseTotal = 0;
	private long netoTotal = 0;
	private long dsctoTotal = 0;
	
	private List<VendedorGarantiaBean> vendedores = new ArrayList<VendedorGarantiaBean>(); 
	
	private VendedorGarantiaDataModel modelVendedor = new VendedorGarantiaDataModel();
	
	
	public LocalGarantiaBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LocalGarantiaBean(
			String fecha,
			int id_local, 
			String tienda, 
			String departamento,
			long unidades,
			double cantidad_boletas, 
			long baseTotal, 
			long netoTotal,
			long dsctoTotal
			) {
		super();
		this.fecha = fecha;
		this.id_local = id_local;
		this.tienda = tienda;
		this.departamento = departamento;
		
		this.unidades = unidades;
		this.cantidad_boletas = cantidad_boletas;
		this.baseTotal = baseTotal;
		this.netoTotal = netoTotal;
		this.dsctoTotal = dsctoTotal;
	}


	public int getId_local() {
		return id_local;
	}


	public void setId_local(int id_local) {
		this.id_local = id_local;
	}


	public String getTienda() {
		return tienda;
	}


	public void setTienda(String tienda) {
		this.tienda = tienda;
	}


	public long getUnidades() {
		return unidades;
	}


	public void setUnidades(long unidades) {
		this.unidades = unidades;
	}


	public double getCantidad_boletas() {
		return cantidad_boletas;
	}


	public void setCantidad_boletas(double cantidad_boletas) {
		this.cantidad_boletas = cantidad_boletas;
	}


	public long getBaseTotal() {
		return baseTotal;
	}


	public void setBaseTotal(long baseTotal) {
		this.baseTotal = baseTotal;
	}


	public long getNetoTotal() {
		return netoTotal;
	}


	public void setNetoTotal(long netoTotal) {
		this.netoTotal = netoTotal;
	}


	public long getDsctoTotal() {
		return dsctoTotal;
	}


	public void setDsctoTotal(long dsctoTotal) {
		this.dsctoTotal = dsctoTotal;
	}


	public List<VendedorGarantiaBean> getVendedores() {
		return vendedores;
	}


	public void setVendedores(List<VendedorGarantiaBean> vendedores) {
		this.vendedores = vendedores;
	}


	

	public VendedorGarantiaDataModel getModelVendedor() {
		return modelVendedor;
	}


	public void setModelVendedor(VendedorGarantiaDataModel modelVendedor) {
		this.modelVendedor = modelVendedor;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Date getDfecha() {
		return dfecha;
	}


	public void setDfecha(Date dfecha) {
		this.dfecha = dfecha;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
		
	
	
}