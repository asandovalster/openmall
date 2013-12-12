package cl.openti.openmall.modulo.model.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.openti.openmall.modulo.service.IBusinessService;


/**
 * Informacion del departamento donde se realiza la garantia extedida
 * 
 * 
 * @author Alejandro Sandoval Schwartzmann
 *
 */


@ManagedBean(name = "tableDsctoGarantiaDeptoBean")
@SessionScoped
public class TableDsctoGarantiaDeptoBean implements Serializable {

	static final Logger log = Logger.getLogger(TableDsctoGarantiaDeptoBean.class);

	private String fecha = null;
	private Date dfecha;
	
	private List<DsctoGarantiaDeptoBean> descuentos = new ArrayList<DsctoGarantiaDeptoBean>();
	private LocalGarantiaBean localSelected = new LocalGarantiaBean();
	
	
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
	public TableDsctoGarantiaDeptoBean() {
		super();
		cargaGarantias();
		
		// TODO Auto-generated constructor stub
	}
	public TableDsctoGarantiaDeptoBean(String fecha, Date dfecha,
			List<DsctoGarantiaDeptoBean> locales, String departamento, long unidades,
			double boletas, long baseTotal, long netoTotal, long dsctoTotal,
			String sunidades, String sboletas, String sbaseTotal,
			String snetoTotal, String sdsctoTotal) {
		super();
		this.fecha = fecha;
		this.dfecha = dfecha;
		this.descuentos = locales;
		this.departamento = departamento;
		this.unidades = unidades;
		this.boletas = boletas;
		this.baseTotal = baseTotal;
		this.netoTotal = netoTotal;
		this.dsctoTotal = dsctoTotal;
		this.sunidades = sunidades;
		this.sboletas = sboletas;
		this.sbaseTotal = sbaseTotal;
		this.snetoTotal = snetoTotal;
		this.sdsctoTotal = sdsctoTotal;
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
	
	public List<DsctoGarantiaDeptoBean> getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(List<DsctoGarantiaDeptoBean> descuentos) {
		this.descuentos = descuentos;
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
	
	public void setBoletas(double boletas) {
		this.boletas = boletas;
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
	
	public LocalGarantiaBean getLocalSelected() {
		return localSelected;
	}
	public void setLocalSelected(LocalGarantiaBean localSelected) {
		this.localSelected = localSelected;
	}
	

	/**
	 * Cuando se selecciona un local
	 * @param event
	 */
	public void onRowSelect(SelectEvent event) {
		
			try {
				this.setLocalSelected((((LocalGarantiaBean) event.getObject())));
		   
				FacesContext ctx = FacesContext.getCurrentInstance();
				ExternalContext extContext = ctx.getExternalContext();
				String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, "/reporte1_5_1.xhtml"));
		 	
		 		extContext.redirect(url);
		 	} catch (IOException e) {
		 		e.printStackTrace();
		 	}
			
	 } 
	
	public void onRowUnselect(UnselectEvent event) {
		
		System.out.println("onRowUnSelect");
		
		FacesMessage msg = new FacesMessage("Seller DesSelected", "" + ((LocalGarantiaBean) event.getObject()).getId_local());

		FacesContext.getCurrentInstance().addMessage(null, msg);

	}
	
	
	public long getBaseTotal() {
		
		long ltotal = 0;

		for (DsctoGarantiaDeptoBean dscto : getDescuentos()) {
			ltotal += dscto.getBaseTotal();
		}

		return ltotal;
		
	}

	public void setBaseTotal(long baseTotal) {
		this.baseTotal = baseTotal;
	}

	public long getNetoTotal() {
		
		long ltotal = 0;
		for (DsctoGarantiaDeptoBean dscto : getDescuentos()) {
			ltotal += dscto.getNetoTotal();
		}

		return ltotal;
	}

	public void setNetoTotal(long netoTotal) {
		this.netoTotal = netoTotal;
	}

	public long getDsctoTotal() {
		
		long ltotal = 0;
		for (DsctoGarantiaDeptoBean dscto : getDescuentos()) {
			ltotal += dscto.getDsctoTotal();
		}
		return ltotal;
	}

	public void setDsctoTotal(long dsctoTotal) {
		this.dsctoTotal = dsctoTotal;
	}

	public double getBoletas() {
		
		double ret = 0;
		
		long vt = getDsctoTotal();
		long mt = getBaseTotal();
		System.out.println(vt + " " + mt);
		ret = Double.parseDouble(""+vt) / Double.parseDouble(""+mt);
		System.out.println("ret:"+ret);
		return ret;
		
	}
	
	
public String getSbaseTotal() {
		
		
		long valor=getBaseTotal();
		if((""+valor).length() >= 7){
			sbaseTotal = (""+valor).substring(0,(""+valor).length()-6)
					+"."+
					(""+valor).substring((""+valor).length()-6, (""+valor).length()-3)
					+"."+
					(""+valor).substring((""+valor).length()-3, (""+valor).length());
					;
		}else{
			if((""+valor).length() >= 4){
				sbaseTotal = (""+valor).substring(0,(""+valor).length()-3)
					+"."+
					(""+valor).substring((""+valor).length()-3, (""+valor).length());
			}	
		}
		
		return "$ " + sbaseTotal;
	}

	public void setSbaseTotal(String sbaseTotal) {
		this.sbaseTotal = sbaseTotal;
	}

	public String getSnetoTotal() {
		
		long valor=getNetoTotal();
		if((""+valor).length() >= 7){
			snetoTotal = (""+valor).substring(0,(""+valor).length()-6)
					+"."+
					(""+valor).substring((""+valor).length()-6, (""+valor).length()-3)
					+"."+
					(""+valor).substring((""+valor).length()-3, (""+valor).length());
					;
		}else{
			if((""+valor).length() >= 4){
				snetoTotal = (""+valor).substring(0,(""+valor).length()-3)
					+"."+
					(""+valor).substring((""+valor).length()-3, (""+valor).length());
			}	
		}
		
		return "$ " + snetoTotal;
		
	}

	public void setSnetoTotal(String snetoTotal) {
		this.snetoTotal = snetoTotal;
	}

	public String getSdsctoTotal() {
		
		long valor=getDsctoTotal();
		if((""+valor).length() >= 7){
			sdsctoTotal = (""+valor).substring(0,(""+valor).length()-6)
					+"."+
					(""+valor).substring((""+valor).length()-6, (""+valor).length()-3)
					+"."+
					(""+valor).substring((""+valor).length()-3, (""+valor).length());
					;
		}else{
			if((""+valor).length() >= 4){
				sdsctoTotal = (""+valor).substring(0,(""+valor).length()-3)
					+"."+
					(""+valor).substring((""+valor).length()-3, (""+valor).length());
			}	
		}
			
		return "$ " + sdsctoTotal;
		
	}

	public void setSdsctoTotal(String sdsctoTotal) {
		this.sdsctoTotal = sdsctoTotal;
	}

	public String getSavanceTotal() {
		
		double dboletasTotal = getBoletas()*100;
		if(dboletasTotal  >= 100)
			sboletas = (""+dboletasTotal).substring(0,3)+"%";
		else
		if(dboletasTotal > 9)
			sboletas = (""+dboletasTotal).substring(0,2)+"%";
		else
			if(dboletasTotal <= 9)
				sboletas = (""+dboletasTotal).substring(0,1)+"%";
		
		return sboletas;
		
		
		
	}

	
	/**
	 * Carga Garantias
	 */
	private void cargaGarantias() {

		log.debug("cargaRanking::::::::::");
		descuentos.clear();
		try {

			// llamada Spring
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml", this.getClass());
			IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");

			// Se audita llamada
			proxy.loadGarantiaExtendida( this );
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	
	
	
}