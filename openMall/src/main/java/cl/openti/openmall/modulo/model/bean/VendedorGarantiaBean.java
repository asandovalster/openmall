package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.openti.openmall.modulo.model.datamodel.BoletaDataModel;
import cl.openti.openmall.modulo.model.datamodel.BoletaGarantiaDataModel;

public class VendedorGarantiaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fecha = null;
	private Date dfecha;
	private String hora = null;
	private int id_vendedor;
	private String vendedor;
	private long unidades=0;
	private double cantidad_boletas = 0;
	private long baseTotal = 0;
	private long netoTotal = 0;
	private long dsctoTotal = 0;
	
	private List<BoletaGarantiaBean> boletas = new ArrayList<BoletaGarantiaBean>(); 
	
	private BoletaGarantiaDataModel modelBoleta = new BoletaGarantiaDataModel();
	
	
	public VendedorGarantiaBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VendedorGarantiaBean(String fecha,String hora, int id_vendedor, String vendedor,
			long unidades, double cantidad_boletas, long baseTotal,
			long netoTotal, long dsctoTotal) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.id_vendedor = id_vendedor;
		this.vendedor = vendedor;
		this.unidades = unidades;
		this.cantidad_boletas = cantidad_boletas;
		this.baseTotal = baseTotal;
		this.netoTotal = netoTotal;
		this.dsctoTotal = dsctoTotal;
	}


	public int getId_vendedor() {
		return id_vendedor;
	}


	public void setId_vendedor(int id_vendedor) {
		this.id_vendedor = id_vendedor;
	}


	public String getVendedor() {
		return vendedor;
	}


	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
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


	public List<BoletaGarantiaBean> getBoletas() {
		return boletas;
	}


	public void setBoletas(List<BoletaGarantiaBean> boletas) {
		this.boletas = boletas;
	}


	public BoletaGarantiaDataModel getModelBoleta() {
		return modelBoleta;
	}


	public void setModelBoleta(BoletaGarantiaDataModel modelBoleta) {
		this.modelBoleta = modelBoleta;
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


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	
	
	
}