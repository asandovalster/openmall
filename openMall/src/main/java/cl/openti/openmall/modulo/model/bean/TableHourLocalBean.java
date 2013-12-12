package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ValueChangeEvent;
import org.apache.log4j.Logger;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.openti.openmall.modulo.service.IBusinessService;

@ManagedBean(name = "tableHourLocalBean")
@SessionScoped
public class TableHourLocalBean implements Serializable {
	private final static String[] locales;

	static final Logger log = Logger.getLogger(TableHourLocalBean.class);
   
	private MeterGaugeChartModel meterGaugeModel;
	private String fecha = "12/12/2012";
	private String fechaC = "12/12/2012";
	private String horaSelected = "";
	private Date dfecha;
	private CartesianChartModel categoryModel;

	List<Number> intervals = new ArrayList<Number>();

	static {
		locales = new String[10];
		locales[0] = "Mercedes";
		locales[1] = "BMW";
		locales[2] = "Volvo";
		locales[3] = "Audi";
		locales[4] = "Renault";
		locales[5] = "Opel";
		locales[6] = "Volkswagen";
		locales[7] = "Chrysler";
		locales[8] = "Ferrari";
		locales[9] = "Ford";
	}

	private List<LocalBean> ventas = new ArrayList<LocalBean>();
	
	// Ventas Reporte Tabular 3
	private List<VentasHoraBean> ventashora = new ArrayList<VentasHoraBean>();
	
	private LocalBean localSelected = new LocalBean();
	
	private AreaBean areaSelected = new AreaBean();

	// metas, ventas y avance seleccionado
	private long metasTotal = 0;
	private long ventasTotal = 0;
	private double avanceTotal = 0;
	

	public TableHourLocalBean() {
		cargaVentasHora();
		
	}

	private long getRandomMeta() {
		return (long) (Math.random() * 100000);
	}

	private long getRandomVenta() {
		return (long) (Math.random() * 100);
	}

	private double getRandomAvance() {
		return (double) (Math.random() * 100000.23);
	}

	public List<LocalBean> getSales() {
		return ventas;
	}

	
	private void cargaVentasHora() { 

		log.debug("cargaVentas::::::::::");
		ventas.clear();
		try {

			// llamada Spring
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
			IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");

			// Se audita llamada
			proxy.loadVentasHora(this);

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

	public long getVentasTotal() {
		long ltotal = 0;

		for (LocalBean sale : getSales()) {
			ltotal += sale.getVentas();
		}

		return ltotal;
	}

	public long getMetasTotal() {
		long ltotal = 0;

		for (LocalBean sale : getSales()) {
			ltotal += sale.getMetas();
		}

		return ltotal;
	}

	public double getAvanceTotal() {

		long vt = getVentasTotal();
		long mt = getMetasTotal();

		System.out.println((double) vt / mt);

		return (double) vt / mt;
	}

	public List<LocalBean> getVentas() {
		return ventas;
	}

	public void setVentas(List<LocalBean> ventas) {
		this.ventas = ventas;
	}

	public static String[] getLocales() {
		return locales;
	}

	public void setMetasTotal(long metasTotal) {
		this.metasTotal = metasTotal;
	}

	public void setVentasTotal(long ventasTotal) {
		this.ventasTotal = ventasTotal;
	}

	public void setAvanceTotal(long avanceTotal) {
		this.avanceTotal = avanceTotal;
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

	private void createCategoryModel() {
		categoryModel = new CartesianChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Metas");

		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Ventas");

		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 135);
		girls.set("2008", 120);

		categoryModel.addSeries(boys);
		categoryModel.addSeries(girls);
	}

	public void setAvanceTotal(double avanceTotal) {
		this.avanceTotal = avanceTotal;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = (""+fecha).length()>10?fecha.substring(0,10):fecha;
	}

	public String getFechaC() {
		return fechaC;
	}

	public void setFechaC(String fechaC) {
		
		this.fechaC = (""+fechaC).length()>10?fechaC.substring(0,10):fechaC;
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
    
    
    public void valueChangeCalendar(ValueChangeEvent evt){
    	System.out.println("....");
        if(evt.getComponent().getId().equalsIgnoreCase("dfecha")){
        	System.out.println("::::");
        	System.out.println("valueChangeCalendar:"+((Calendar)evt.getComponent()).getValue());
        	SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.CANADA);
        	
        
        	try {
    			setDfecha( sdf.parse( ((Calendar)evt.getComponent()).getValue().toString() ));
    			cargaVentasHora();
    			Iterator<UIComponent> it = evt.getComponent().getParent().getChildren().iterator();
    			for (Iterator iterator = it; iterator.hasNext();) {
    				UIComponent ui = (UIComponent) iterator.next();
					System.out.println(ui.getId());
				}
    			
    			System.out.println("exito:"+getDfecha());
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }

    }	
    public void handleDateSelect(DateSelectEvent event) {  
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");  
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Seleccionada", format.format(event.getDate())));  
        cargaVentasHora();
        System.out.println("handleDateSelect");
    }  

	public List<VentasHoraBean> getVentashora() {
		return ventashora;
	}

	public void setVentashora(List<VentasHoraBean> ventashora) {
		this.ventashora = ventashora;
	}

	public Date getDfecha() {
		return dfecha;
	}

	public void setDfecha(Date dfecha) {
		this.dfecha = dfecha;
	}

	
public String goReporte12() {
		
		System.out.println("goReporte12..........");

		System.out.println(getDfecha());
		
		String url = "reporte1_2.xhtml";

		return url + "?faces-redirect=true";
	}

public String getHoraSelected() {
	return horaSelected;
}

public void setHoraSelected(String horaSelected) {
	this.horaSelected = horaSelected;
}

	
	
}