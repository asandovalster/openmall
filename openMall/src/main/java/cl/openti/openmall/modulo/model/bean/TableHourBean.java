package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import cl.openti.openmall.modulo.service.IBusinessService;

@ManagedBean(name = "tableHourBean")
@SessionScoped
public class TableHourBean implements Serializable {
	private final static String[] locales = null;

	static final Logger log = Logger.getLogger(TableHourBean.class);
	
	private Date dfecha;
	private Date dfecha2;
	private MeterGaugeChartModel meterGaugeModel;
	private String fecha = "12/12/2012";
	private String fechaC = "12/12/2012";

	
	// Totales Generales para el reporte 1_2 correspondente a las ventas on line x hora
	
	private long metasTotal = 0;
	private long ventas13Total = 0;
	private long ventas15Total = 0;
	private long ventas18Total = 0;
	private long ventas23Total = 0;
	private double avanceTotal = 0;
	
	private String smetasTotal = "0"; 
	private String sventas13Total = "0";
	private String sventas15Total = "0";
	private String sventas18Total = "0";
	private String sventas23Total = "0";
	private String savanceTotal = "0";
	
	private CartesianChartModel categoryModel;

	List<Number> intervals = new ArrayList<Number>();

	
	private List<PosicionBean> pos = new ArrayList<PosicionBean>();
	
	private LocalBean localSelected = new LocalBean();
	
	private AreaBean areaSelected = new AreaBean();

	

	public TableHourBean() {
		super();
		cargaVentas();
		
	}

//	public TableHourBean(Date d1 ) {
//		System.out.println("constructor TableHourBean:"+d1);
//		setDfecha(d1);
//		cargaVentas();
//		 
//	}

	private long getRandomMeta() {
		return (long) (Math.random() * 100000);
	}

	private long getRandomVenta() {
		return (long) (Math.random() * 100);
	}

	private double getRandomAvance() {
		return (double) (Math.random() * 100000.23);
	}

	public List<PosicionBean> getSales() {
		return pos;
	}

	private void cargaVentas() { 

		pos.clear();
		try {

			// llamada Spring
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
			IBusinessService proxy = (IBusinessService) beanFactory
					.getBean("proxyGestor");

			// Se audita llamada
			System.out.println("TableHourBean.cargaVentas:"+getDfecha());
			proxy.loadVentas(this);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void createMeterGaugeModel() {

		intervals.add(new Long(45));
		intervals.add(new Long(220));
		intervals.add(new Long(556));

		meterGaugeModel = new MeterGaugeChartModel("avance", 12, getIntervals());
	}


	public static String[] getLocales() {
		return locales;
	}

	public void setMetasTotal(long metasTotal) {
		this.metasTotal = metasTotal;
	}

	public CartesianChartModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CartesianChartModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public MeterGaugeChartModel getMeterGaugeModel() {
		return meterGaugeModel;
	}

	public void setMeterGaugeModel(MeterGaugeChartModel meterGaugeModel) {
		this.meterGaugeModel = meterGaugeModel;
	}

	public List<Number> getIntervals() {
		return intervals;
	}

	public void setIntervals(List<Number> intervals) {
		this.intervals = intervals;
	}

	

	public void setAvanceTotal(double avanceTotal) {
		this.avanceTotal = avanceTotal;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFechaC() {
		return fechaC;
	}

	public void setFechaC(String fechaC) {
		this.fechaC = fechaC;
	}

	public LocalBean getLocalSelected() {
		return localSelected;
	}

	public void setLocalSelected(LocalBean localSelected) {
		this.localSelected = localSelected;
	}

	
	public AreaBean getAreaSelected() {
		return areaSelected;
	}

	public void setAreaSelected(AreaBean areaSelected) {
		this.areaSelected = areaSelected;
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
  
    public void onRowDblselect(SelectEvent event) {  
        FacesContext context = FacesContext.getCurrentInstance();  
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();  
        Flash flash = context.getExternalContext().getFlash();  
        flash.put("selectedDepto", (DepartamentoBean) event.getObject());  
          
        handler.performNavigation("deptoDetail");  
    }

	public Date getDfecha() {
		return dfecha;
	}

	public void setDfecha(Date dfecha) {
		this.dfecha = dfecha;
	}


public Date getDfecha2() {
		return dfecha2;
	}

	public void setDfecha2(Date dfecha2) {
		this.dfecha2 = dfecha2;
	}

public String goReporte11() {
		
		System.out.println("goReporte11..........");

		System.out.println(getDfecha());
		
		String url = "reporte1_1.xhtml";

		return url + "?faces-redirect=true";
	}
public void valueChangeCalendar(ValueChangeEvent evt){
	System.out.println("....valueChangeCalendar");
    if(evt.getComponent().getId().equalsIgnoreCase("dfecha")){
    	System.out.println("::::valueChangeCalendar");
    	System.out.println(((Calendar)evt.getComponent()).getValue());
    	SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.CANADA);
    	
    
    	try {
			setDfecha( sdf.parse( ((Calendar)evt.getComponent()).getValue().toString() ));
			cargaVentas();
			
			System.out.println("exito:"+getDfecha());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
    }

}	
public void handleDateSelect(DateSelectEvent event) {  
    FacesContext facesContext = FacesContext.getCurrentInstance();  
    SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");  
    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Seleccionada", format.format(event.getDate())));  
    
    
    cargaVentas();
}

public List<PosicionBean> getPos() {
	return pos;
}

public void setPos(List<PosicionBean> pos) {
	this.pos = pos;
}

public long getVentas13Total() {
	
	ventas13Total = 0;
	
	for (Iterator iterator = pos.iterator(); iterator.hasNext();) {
		PosicionBean pos = (PosicionBean) iterator.next();
		
		ventas13Total += pos.getVentas13Total();
	}
	
	return ventas13Total;
}

public void setVentas13Total(long ventas13Total) {
	this.ventas13Total = ventas13Total;
}

public long getVentas15Total() {
	
	ventas15Total = 0;
	
	for (Iterator iterator = pos.iterator(); iterator.hasNext();) {
		PosicionBean pos = (PosicionBean) iterator.next();
		
		ventas15Total += pos.getVentas15Total();
	}
	
	return ventas15Total;
}

public void setVentas15Total(long ventas15Total) {
	this.ventas15Total = ventas15Total;
}

public long getVentas18Total() {
	
	ventas18Total = 0;
	
	for (Iterator iterator = pos.iterator(); iterator.hasNext();) {
		PosicionBean pos = (PosicionBean) iterator.next();
		
		ventas18Total += pos.getVentas18Total();
	}
	
	return ventas18Total;
}

public void setVentas18Total(long ventas18Total) {
	this.ventas18Total = ventas18Total;
}

public long getVentas23Total() {
	
    ventas23Total = 0;
	
	for (Iterator iterator = pos.iterator(); iterator.hasNext();) {
		PosicionBean pos = (PosicionBean) iterator.next();
		
		ventas23Total += pos.getVentas23Total();
	}
	
	return ventas23Total;
}

public void setVentas23Total(long ventas23Total) {
	this.ventas23Total = ventas23Total;
}

public String getSmetasTotal() {
	
	metasTotal = getMetasTotal();
	if((""+metasTotal).length() >= 4){
		smetasTotal = (""+metasTotal).substring(0,(""+metasTotal).length()-3)
				+"."+
				(""+metasTotal).substring((""+metasTotal).length()-3, (""+metasTotal).length());
	}
	
	return "$ " + smetasTotal;
	
}

public void setSmetasTotal(String smetasTotal) {
	this.smetasTotal = smetasTotal;
}

public String getSventas13Total() {
	ventas13Total = getVentas13Total();
	if((""+ventas13Total).length() >= 4 && (""+ventas13Total).length() < 7){
		sventas13Total = (""+ventas13Total).substring(0,(""+ventas13Total).length()-3)
				+"."+
				(""+ventas13Total).substring((""+ventas13Total).length()-3, (""+ventas13Total).length());
	}else
		if((""+ventas13Total).length() >= 7){
			sventas13Total = (""+ventas13Total).substring(0,(""+ventas13Total).length()-6)
					+"."+
					(""+ventas13Total).substring((""+ventas13Total).length()-6, (""+ventas13Total).length()-3)
					+"."+
					(""+ventas13Total).substring((""+ventas13Total).length()-3, (""+ventas13Total).length());
		}
	
	return "$ "+sventas13Total;
}

public void setSventas13Total(String sventas13Total) {
	
	
	this.sventas13Total = sventas13Total;
}

public String getSventas15Total() {
	ventas15Total = getVentas15Total();
	if((""+ventas15Total).length() >= 4 && (""+ventas15Total).length() < 7 ){
		sventas15Total = (""+ventas15Total).substring(0,(""+ventas15Total).length()-3)
				+"."+
				(""+ventas15Total).substring((""+ventas15Total).length()-3, (""+ventas15Total).length());
	}else
		if((""+ventas15Total).length() >= 7  ){
			sventas15Total = (""+ventas15Total).substring(0,(""+ventas15Total).length()-6)
					+"."+
					(""+ventas15Total).substring((""+ventas15Total).length()-6, (""+ventas15Total).length()-3)
					+"."+
					(""+ventas15Total).substring((""+ventas15Total).length()-3, (""+ventas15Total).length());
		}
	return "$ "+sventas15Total;
}

public void setSventas15Total(String sventas15Total) {
	this.sventas15Total = sventas15Total;
}

public String getSventas18Total() {
	
	ventas18Total = getVentas18Total();
	if((""+ventas18Total).length() >= 4 && (""+ventas18Total).length() < 7){
		sventas18Total = (""+ventas18Total).substring(0,(""+ventas18Total).length()-3)
				+"."+
				(""+ventas18Total).substring((""+ventas18Total).length()-3, (""+ventas18Total).length());
	}else
		if((""+ventas18Total).length() >= 7 ){
			sventas18Total = (""+ventas18Total).substring(0,(""+ventas18Total).length()-6)
					+"."+
					(""+ventas18Total).substring((""+ventas18Total).length()-6, (""+ventas18Total).length()-3)
					+"."+
					(""+ventas18Total).substring((""+ventas18Total).length()-3, (""+ventas18Total).length());
		}
	
	return "$ "+sventas18Total;
}

public void setSventas18Total(String sventas18Total) {
	this.sventas18Total = sventas18Total;
}

public String getSventas23Total() {
	
	ventas23Total = getVentas23Total();
	if((""+ventas23Total).length() >= 4 && (""+ventas23Total).length() < 7){
		
		sventas23Total = (""+ventas23Total).substring(0,(""+ventas23Total).length()-3)
				+"."+
				(""+ventas23Total).substring((""+ventas23Total).length()-3, (""+ventas23Total).length());
	}else
		if((""+ventas23Total).length() >= 7 ){
			
			sventas23Total = (""+ventas23Total).substring(0,(""+ventas23Total).length()-6)
					+"."+
					(""+ventas23Total).substring((""+ventas23Total).length()-6, (""+ventas23Total).length()-3)
					+"."+
					(""+ventas23Total).substring((""+ventas23Total).length()-3, (""+ventas23Total).length());
		}

		
	
	return "$ " + sventas23Total;
	
}

public void setSventas23Total(String sventas23Total) {
	this.sventas23Total = sventas23Total;
}

public String getSavanceTotal() {
	savanceTotal = getAvanceTotal() + "%";
//	avanceTotal = Math.round(avanceTotal);
//	savanceTotal = (""+avanceTotal).substring(0,3)+"%";
//	savanceTotal = "" + avanceTotal+"%";
	
	return savanceTotal;
}

public void setSavanceTotal(String savanceTotal) {
	this.savanceTotal = savanceTotal;
}

public long getMetasTotal() {
	
	metasTotal = 0;
	
	for (Iterator iterator = pos.iterator(); iterator.hasNext();) {
		PosicionBean pos = (PosicionBean) iterator.next();
		
		metasTotal += pos.getMetasTotal();
	}
	
	
	return metasTotal;
}

public double getAvanceTotal() {
	avanceTotal = 0;

//	for (Iterator iterator = pos.iterator(); iterator.hasNext();) {
//		PosicionBean pos = (PosicionBean) iterator.next();
//		
//		avanceTotal += pos.getAvanceTotal();
//		i++;
//	}
//	if(i==3)
//		avanceTotal = avanceTotal / 2;
//	else
//	{
//		avanceTotal = avanceTotal / i;
//	}
	
	long ventas = getVentas13Total();
	if(ventas > 0)
		avanceTotal=(Double.valueOf(ventas)/Double.valueOf(getMetasTotal())) * 100;
	
	 ventas = getVentas15Total();
	if(ventas > 0)
		avanceTotal=(Double.valueOf(ventas)/Double.valueOf(getMetasTotal())) * 100;
	
	ventas = getVentas18Total();
	if(ventas > 0)
		avanceTotal=(Double.valueOf(ventas)/Double.valueOf(getMetasTotal())) * 100;
	
	ventas = getVentas23Total();
	if(ventas > 0)
		avanceTotal=(Double.valueOf(ventas)/Double.valueOf(getMetasTotal())) * 100;
	
	
	avanceTotal =  Math.round(avanceTotal);
	
	
	
	
	
	return avanceTotal;
}



}
