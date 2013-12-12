package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;

public class CentroBean extends ZonaBean implements Serializable {
	
	TiendaBean tienda6 = new TiendaBean();
	TiendaBean tienda8 = new TiendaBean();
	TiendaBean tienda11 = new TiendaBean();
	TiendaBean tienda50 = new TiendaBean();
	TiendaBean tienda51 = new TiendaBean();
	TiendaBean tienda54 = new TiendaBean();
	public CentroBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CentroBean(TiendaBean tienda6, TiendaBean tienda8,
			TiendaBean tienda11, TiendaBean tienda50, TiendaBean tienda51,
			TiendaBean tienda54) {
		super();
		this.tienda6 = tienda6;
		this.tienda8 = tienda8;
		this.tienda11 = tienda11;
		this.tienda50 = tienda50;
		this.tienda51 = tienda51;
		this.tienda54 = tienda54;
	}
	public TiendaBean getTienda6() {
		return tienda6;
	}
	public void setTienda6(TiendaBean tienda6) {
		this.tienda6 = tienda6;
	}
	public TiendaBean getTienda8() {
		return tienda8;
	}
	public void setTienda8(TiendaBean tienda8) {
		this.tienda8 = tienda8;
	}
	public TiendaBean getTienda11() {
		return tienda11;
	}
	public void setTienda11(TiendaBean tienda11) {
		this.tienda11 = tienda11;
	}
	public TiendaBean getTienda50() {
		return tienda50;
	}
	public void setTienda50(TiendaBean tienda50) {
		this.tienda50 = tienda50;
	}
	public TiendaBean getTienda51() {
		return tienda51;
	}
	public void setTienda51(TiendaBean tienda51) {
		this.tienda51 = tienda51;
	}
	public TiendaBean getTienda54() {
		return tienda54;
	}
	public void setTienda54(TiendaBean tienda54) {
		this.tienda54 = tienda54;
	}
	
	
	
	
	
}
