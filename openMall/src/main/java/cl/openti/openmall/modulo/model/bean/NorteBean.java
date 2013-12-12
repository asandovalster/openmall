package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;

public class NorteBean extends ZonaBean implements Serializable {

	TiendaBean tienda40 = new TiendaBean();
	TiendaBean tienda59 = new TiendaBean();
	public NorteBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NorteBean(TiendaBean tienda40, TiendaBean tienda59) {
		super();
		this.tienda40 = tienda40;
		this.tienda59 = tienda59;
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

	
	
	
}
