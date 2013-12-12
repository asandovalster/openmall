package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BoletaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fecha;
	private String hora;
	private int caja=0;
	private int numBoleta=0;
	private String area;
	private String departamento;
	private long montoBase = 0;
	private long montoNeto = 0;
	private long dscto = 0;
	private double por_dscto = 0;
	private String trx;
	private String fin;
	
	private List<ItemBoletaBean> items = new ArrayList<ItemBoletaBean>();
	

	public BoletaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoletaBean(
			String fecha,
			String hora,
			int caja, 
			int numBoleta, 
			String area,
			String departamento, 
			long montoBase,
			long montoNeto, 
			long dscto, 
			double por_dscto) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.caja = caja;
		this.numBoleta = numBoleta;
		this.area = area;
		this.departamento = departamento;
		this.montoBase = montoBase;
		this.montoNeto = montoNeto;
		this.dscto = dscto;
		this.por_dscto = por_dscto;
	}
	public int getCaja() {
		return caja;
	}
	public void setCaja(int caja) {
		this.caja = caja;
	}
	public int getNumBoleta() {
		return numBoleta;
	}
	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
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
	public long getMontoBase() {
		return montoBase;
	}
	public void setMontoBase(long montoBase) {
		this.montoBase = montoBase;
	}
	public List<ItemBoletaBean> getItems() {
		return items;
	}
	public void setItems(List<ItemBoletaBean> items) {
		this.items = items;
	}
	public String getTrx() {
		return trx;
	}
	public void setTrx(String trx) {
		this.trx = trx;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	
		
	
}