package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.openti.openmall.modulo.service.IBusinessService;

@ManagedBean(name = "tableCdaBean")
@SessionScoped
public class TableCDABean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4193237938659143665L;

	static final Logger log = Logger.getLogger(TableCDABean.class);
	
	
	private String filterArchivo = "";
	private Date filterDesde = new Date();
	private Date filterHasta = new Date();
	
	
	// lista de auxiliar coas se carga en el modulo dao.
	private List<CDABean> cda = new ArrayList<CDABean>();

    private List<SelectItem> archivos = new ArrayList<SelectItem>();
		
		
	
	public TableCDABean() {
		super();
		cargaArchivos(this);
		cargaVentas();

	}

     /**
      * Carga de Archivos CDE de ventas 
      * Centro de estadisticas de Archivos
      */
	private void cargaVentas() { 
		
		try {
			log.debug("................212");
			// llamada Spring
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
			IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");

			// Se audita llamada
			log.debug("TableActBean.cargaVentas CDA: Filtro Fecha Desde: "+filterDesde + " Hasta:"+ filterHasta + " Filtro Archivo: " + filterArchivo);
			proxy.loadVentas(this);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * Carga la lista de Archivos
	 * @param table
	 */
	private void cargaArchivos(TableCDABean table) { 
	       
        archivos.clear();
		try {
			
			// llamada Spring
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
			IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");
			// Se audita llamada
			proxy.loadArchivos(table);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onRowSelect(SelectEvent event) {
		
		System.out.println("onRowSelect");
//        FacesMessage msg = new FacesMessage("Area Selected", ""+((AreaBean) event.getObject()).getId_area());  
        
			List<DepartamentoBean>  deptos = ((AreaBean) event.getObject()).getDeptos();
			String cadena = "<br><u><b>Departamentos</b></u><br>";
		   for (Iterator<DepartamentoBean> iterator = deptos.iterator(); iterator.hasNext();) {
			   
			DepartamentoBean depto = (DepartamentoBean) iterator.next();
			
			DecimalFormat df1 = new DecimalFormat("###,###,###");//.000
			String s = "$"+df1.format(depto.getMonto());
			
			
			if(depto.getMonto()<=0) s= "<font color=\"red\" size=2>"+s+"</font>";
			
			cadena += "<br><font size=2>" + depto.getDepartamento() + "</font><br><font size=2>" + s + "</font><br>";
		  }
	    
		FacesMessage msg = new FacesMessage("<b>AREA :" + ((AreaBean) event.getObject()).getArea()+"</b><br>", cadena);
      //  setAreaSelected(((AreaBean) event.getObject()));
        
        FacesContext.getCurrentInstance().addMessage("asasa", msg);
//        FacesContext context = FacesContext.getCurrentInstance();  
//        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();  
//        Flash flash = context.getExternalContext().getFlash();  
//        flash.clear();
        
    }  
  
    public void onRowUnselect(UnselectEvent event) {
    	System.out.println("onRowUnSelect");
        FacesMessage msg = new FacesMessage("Area DesSelected", ""+((AreaBean) event.getObject()).getId_area());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        
     
    }  
    
    public String filtrar() throws ParseException{
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	
    	String url="/reporte1_0.xhtml";
    	
    	System.out.println("... ingresando filtrar()");
    	 
    	 if( this.getFilterHasta().compareTo(this.getFilterDesde() ) < 0 )
    	 {
    		 // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample error message", "PrimeFaces makes no mistakes"));  
    	  
    	    
             FacesMessage message = new FacesMessage("Fechas ingresadas son invalidas.");
             message.setSeverity(FacesMessage.SEVERITY_ERROR);
             FacesContext.getCurrentInstance().addMessage("Error",message);
             
             
    	 }
    	 
    	cargaArchivos(this); 
    	
    	cargaVentas();
    	
    	
    	return url+"?faces-redirect=true";
    }


  
    public void onRowDblselect(SelectEvent event) {  
        FacesContext context = FacesContext.getCurrentInstance();  
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();  
        Flash flash = context.getExternalContext().getFlash();  
        flash.put("selectedDepto", (DepartamentoBean) event.getObject());  
          
        handler.performNavigation("deptoDetail");  
    }

	

     public String goReporte10() {
		
		System.out.println("goReporte10..........");

	
		String url = "reporte1_1.xhtml";

		return url + "?faces-redirect=true";
	}
     
    public void valueChangeCalendar(ValueChangeEvent evt){
//	System.out.println("....valueChangeCalendar");
//    if(evt.getComponent().getId().equalsIgnoreCase("dfecha")){
//    	System.out.println("::::valueChangeCalendar");
//    	System.out.println(((Calendar)evt.getComponent()).getValue());
//    	SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.CANADA);
//    	
//    
//    	try {
//			setDfecha( sdf.parse( ((Calendar)evt.getComponent()).getValue().toString() ));
//			cargaVentas();
//			
//			System.out.println("exito:"+getDfecha());
//		} catch (ParseException e) {
//			
//			e.printStackTrace();
//		}
//    }

}	
   public void handleDateSelect(DateSelectEvent event) {  
    FacesContext facesContext = FacesContext.getCurrentInstance();  
    SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");  
    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Seleccionada", format.format(event.getDate())));  
    
    
    cargaVentas();
}

public String getFilterArchivo() {
	return filterArchivo;
}

public void setFilterArchivo(String filterArchivo) {
	this.filterArchivo = filterArchivo;
}

public Date getFilterDesde() {
	return filterDesde;
}

public void setFilterDesde(Date filterDesde) {
	this.filterDesde = filterDesde;
}

public Date getFilterHasta() {
	return filterHasta;
}

public void setFilterHasta(Date filterHasta) {
	this.filterHasta = filterHasta;
}

public List<CDABean> getCda() {
	return cda;
}

public void setCda(List<CDABean> cda) {
	this.cda = cda;
}

public List<SelectItem> getArchivos() {
	return archivos;
}

public void setArchivos(List<SelectItem> archivos) {
	this.archivos = archivos;
}


public void toPrint() {
	// TODO Auto-generated method stub
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	
	log.debug("Filtros");
	log.debug("Desde:" + sdf.format(filterDesde));
	log.debug("Hasta:"+ sdf.format(filterHasta));
	log.debug("Archivo:"+ filterArchivo);

}


}
