package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

import cl.openti.openmall.modulo.model.datamodel.ArticulosGarantiaDataModel;
import cl.openti.openmall.modulo.model.datamodel.LocalGarantiaDataModel;

/**
 * Informacion del departamento donde se realiza la garantia extedida
 * 
 * 
 * @author Alejandro Sandoval Schwartzmann
 *
 */

public class DsctoGarantiaDeptoBean implements Serializable {

	static final Logger log = Logger.getLogger(DsctoGarantiaDeptoBean.class);

	private String fecha = null;
	private Date dfecha;
	
	private List<LocalGarantiaBean> locales = new ArrayList<LocalGarantiaBean>();
	
	private LocalGarantiaDataModel modelLocales= new LocalGarantiaDataModel();
	private int dep_cod = 0;
	private String departamento;
	private long unidades = 0;
	private double boletas = 0;
	private long baseTotal = 0;
	private long netoTotal = 0;
	private long dsctoTotal = 0;
	
	private String sunidades = "0";
	private String sboletas = "0";
	private String sbaseTotal = "0";
	private String snetoTotal = "0";
	private String sdsctoTotal = "0";
	public DsctoGarantiaDeptoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DsctoGarantiaDeptoBean(
			String fecha, 
			int dep_cod,
			String departamento, 
			long unidades,
			double boletas, 
			long baseTotal, 
			long netoTotal, 
			long dsctoTotal) {
		super();
		this.fecha = fecha;
		this.dep_cod = dep_cod;
		this.departamento = departamento;
		this.unidades = unidades;
		this.boletas = boletas;
		this.baseTotal = baseTotal;
		this.netoTotal = netoTotal;
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
	

	

	public List<LocalGarantiaBean> getLocales() {
		return locales;
	}

	public void setLocales(List<LocalGarantiaBean> locales) {
		this.locales = locales;
	}

	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public long getUnidades() {
		return unidades;
	}
	public void setUnidades(long unidades) {
		this.unidades = unidades;
	}
	public double getBoletas() {
		return boletas;
	}
	public void setBoletas(double boletas) {
		this.boletas = boletas;
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
	public String getSunidades() {
		return sunidades;
	}
	public void setSunidades(String sunidades) {
		this.sunidades = sunidades;
	}
	public String getSboletas() {
		return sboletas;
	}
	public void setSboletas(String sboletas) {
		this.sboletas = sboletas;
	}
	public String getSbaseTotal() {
		return sbaseTotal;
	}
	public void setSbaseTotal(String sbaseTotal) {
		this.sbaseTotal = sbaseTotal;
	}
	public String getSnetoTotal() {
		return snetoTotal;
	}
	public void setSnetoTotal(String snetoTotal) {
		this.snetoTotal = snetoTotal;
	}
	public String getSdsctoTotal() {
		return sdsctoTotal;
	}
	public void setSdsctoTotal(String sdsctoTotal) {
		this.sdsctoTotal = sdsctoTotal;
	}

	public int getDep_cod() {
		return dep_cod;
	}

	public void setDep_cod(int dep_cod) {
		this.dep_cod = dep_cod;
	}

	public LocalGarantiaDataModel getModelLocales() {
		return modelLocales;
	}

	public void setModelLocales(LocalGarantiaDataModel modelLocales) {
		this.modelLocales = modelLocales;
	}
	

	
	
	
	
}