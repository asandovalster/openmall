package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.openti.openmall.modulo.model.datamodel.ArticulosGarantiaDataModel;

public class BoletaGarantiaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fecha = null;
	private Date dfecha;
	private int articulo;
	private String glosa_Articulo;
	private int id_boleta;
	private String transaccion;
	private int caja=0;
	private int hora=0;
	private long unidades=0;
	private double cantidad_boletas = 0;
	private long baseTotal = 0;
	private long netoTotal = 0;
	private long dsctoTotal = 0;
	
	private List<ArticuloGarantiaBean> articulos = new ArrayList<ArticuloGarantiaBean>(); 
	
//	private ArticulosGarantiaDataModel modelArticulos = new ArticulosGarantiaDataModel();
	
	public BoletaGarantiaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoletaGarantiaBean(
			String fecha, 
			int articulo,
			String glosa_Articulo,
			int id_boleta, 
			String transaccion, 
			int caja,
			int hora,
			
			double cantidad_boletas, 
			long baseTotal,
			long netoTotal, 
			long dsctoTotal) {
		super();
		this.fecha = fecha;
		this.articulo = articulo;
		this.glosa_Articulo = glosa_Articulo;
		this.id_boleta = id_boleta;
		this.transaccion = transaccion;
		this.caja = caja;
		this.hora = hora;
		this.cantidad_boletas = cantidad_boletas;
		this.baseTotal = baseTotal;
		this.netoTotal = netoTotal;
		this.dsctoTotal = dsctoTotal;
	}

	public int getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(int id_boleta) {
		this.id_boleta = id_boleta;
	}

	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public int getCaja() {
		return caja;
	}

	public void setCaja(int caja) {
		this.caja = caja;
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

	public List<ArticuloGarantiaBean> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<ArticuloGarantiaBean> articulos) {
		this.articulos = articulos;
	}

//	public ArticulosGarantiaDataModel getModelArticulos() {
//		return modelArticulos;
//	}
//
//	public void setModelArticulos(ArticulosGarantiaDataModel modelArticulos) {
//		this.modelArticulos = modelArticulos;
//	}

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

	public int getArticulo() {
		return articulo;
	}

	public void setArticulo(int articulo) {
		this.articulo = articulo;
	}

	public String getGlosa_Articulo() {
		return glosa_Articulo;
	}

	public void setGlosa_Articulo(String glosa_Articulo) {
		this.glosa_Articulo = glosa_Articulo;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	
	
}