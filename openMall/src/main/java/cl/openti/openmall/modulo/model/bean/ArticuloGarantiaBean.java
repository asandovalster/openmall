package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.openti.openmall.modulo.model.datamodel.AreaDataModel;

public class ArticuloGarantiaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fecha = null;
	private Date dfecha;
	private int id_articulo;
	private String articulo;
	private long baseTotal = 0;
	private long netoTotal = 0;
	private long dsctoTotal = 0;
	
	public ArticuloGarantiaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticuloGarantiaBean(String fecha,int id_articulo, String articulo,
			long baseTotal, long netoTotal, long dsctoTotal) {
		super();
		this.fecha = fecha;
		this.id_articulo = id_articulo;
		this.articulo = articulo;
		this.baseTotal = baseTotal;
		this.netoTotal = netoTotal;
		this.dsctoTotal = dsctoTotal;
	}

	public int getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
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
	
	
	
	
	
}