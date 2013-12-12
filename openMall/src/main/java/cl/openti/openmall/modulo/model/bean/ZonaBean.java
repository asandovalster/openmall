package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;

public class ZonaBean implements Serializable {

	public static final int ZONA_CENTRO = 1;
	public static final int ZONA_SUR = 2;
	public static final int ZONA_NORTE = 3;

	

	TiendaBean tienda6 = new TiendaBean();
	TiendaBean tienda8 = new TiendaBean();
	TiendaBean tienda11 = new TiendaBean();
	TiendaBean tienda50 = new TiendaBean();
	TiendaBean tienda51 = new TiendaBean();
	TiendaBean tienda54 = new TiendaBean();
	
	TiendaBean tienda40 = new TiendaBean();
	TiendaBean tienda49 = new TiendaBean();
	TiendaBean tienda59 = new TiendaBean();
	
	TiendaBean tienda34 = new TiendaBean();
	TiendaBean tienda45 = new TiendaBean();
	TiendaBean tienda47 = new TiendaBean();
	TiendaBean tienda55 = new TiendaBean();
	TiendaBean tienda56 = new TiendaBean();
	TiendaBean tienda57 = new TiendaBean();
	
	
	public ZonaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Tiendas del Centro
	 * @param tienda6
	 * @param tienda8
	 * @param tienda11
	 * @param tienda50
	 * @param tienda51
	 * @param tienda54
	 */
	public ZonaBean(TiendaBean tienda6, TiendaBean tienda8,
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
	/**
	 * Tiendas del Norte
	 * @param tienda40
	 * @param tienda59
	 */
	public ZonaBean(TiendaBean tienda40, TiendaBean tienda59) {
		super();
		this.tienda40 = tienda40;
		this.tienda59 = tienda59;
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
	public TiendaBean getTienda40() {
		return tienda40;
	}
	public void setTienda40(TiendaBean tienda40) {
		this.tienda40 = tienda40;
	}
	public TiendaBean getTienda59() {
		return tienda59;
	}
	public void setTienda59(TiendaBean tienda59) {
		this.tienda59 = tienda59;
	}
	public TiendaBean getTienda34() {
		return tienda34;
	}
	public void setTienda34(TiendaBean tienda34) {
		this.tienda34 = tienda34;
	}
	public TiendaBean getTienda45() {
		return tienda45;
	}
	public void setTienda45(TiendaBean tienda45) {
		this.tienda45 = tienda45;
	}
	public TiendaBean getTienda47() {
		return tienda47;
	}
	public void setTienda47(TiendaBean tienda47) {
		this.tienda47 = tienda47;
	}
	public TiendaBean getTienda55() {
		return tienda55;
	}
	public void setTienda55(TiendaBean tienda55) {
		this.tienda55 = tienda55;
	}
	public TiendaBean getTienda56() {
		return tienda56;
	}
	public void setTienda56(TiendaBean tienda56) {
		this.tienda56 = tienda56;
	}
	public TiendaBean getTienda57() {
		return tienda57;
	}
	public void setTienda57(TiendaBean tienda57) {
		this.tienda57 = tienda57;
	}
	public TiendaBean getTienda49() {
		return tienda49;
	}
	public void setTienda49(TiendaBean tienda49) {
		this.tienda49 = tienda49;
	}
	
	
	
}
