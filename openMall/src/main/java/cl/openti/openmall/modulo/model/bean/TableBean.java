package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.openti.openmall.modulo.service.IBusinessService;


@ManagedBean(name = "tableBean")
@RequestScoped
public class TableBean implements Serializable {
	private final static String[] locales;

	static final Logger log = Logger.getLogger(TableBean.class);
   
	private MeterGaugeChartModel meterGaugeModel;
	private String fecha = "12/12/2012";
	private String fechaC = "12/12/2012";
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
	
	private List<LocalBean> metas = new ArrayList<LocalBean>();
	
	private LocalBean localSelected = new LocalBean();
	
	private AreaBean areaSelected = new AreaBean();
	
	private MetasBean metaSelected = new MetasBean();

	// metas, ventas y avance seleccionado
	private long metasTotal = 0;
	private long ventasTotal = 0;
	private double avanceTotal = 0;
	
	private String smetasTotal = "0";
	private String sventasTotal = "0";
	private String savanceTotal = "0";
	

	public TableBean() {
		cargaVentas();
		
		cargaMetas();
		
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

	private void cargaVentas() { 

		log.debug("cargaVentas::::::::::");
		ventas.clear();
		try {

			// llamada Spring
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
			IBusinessService proxy = (IBusinessService) beanFactory
					.getBean("proxyGestor");

			// Se audita llamada
			proxy.loadVentas(this);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void cargaMetas() { 

		log.debug("cargaMetas::::::::::");
		ventas.clear();
		try {

			// llamada Spring
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
			IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");

			// Se audita llamada
			proxy.loadMetas(this);

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
		fecha = fecha.substring(0,10);
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFechaC() {
		fechaC = fechaC.substring(0,10);
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

	public String getSmetasTotal() {
		
		System.out.println("0....................................");
		metasTotal = getMetasTotal();
		if((""+metasTotal).length() >= 4 &&  (""+metasTotal).length() < 7 ){
			smetasTotal = (""+metasTotal).substring(0,(""+metasTotal).length()-3)
					+"."+
					(""+metasTotal).substring((""+metasTotal).length()-3, (""+metasTotal).length());
		}
		else
		{
			System.out.println("....................................");
			if((""+metasTotal).length() >= 7){
				smetasTotal = (""+metasTotal).substring(0,(""+metasTotal).length()-6)
						+"."+
						(""+metasTotal).substring((""+metasTotal).length()-6,(""+metasTotal).length()-3 )
						+"."+
						(""+metasTotal).substring((""+metasTotal).length()-3, (""+metasTotal).length());
			}
		}
		
		return "$ " + smetasTotal;
		
		
	}

	public void setSmetasTotal(String smetasTotal) {
		this.smetasTotal = smetasTotal;
	}

	public String getSventasTotal() {
		
		ventasTotal = getVentasTotal();
		if((""+ventasTotal).length() >= 4 && (""+ventasTotal).length() < 7){
			sventasTotal = (""+ventasTotal).substring(0,(""+ventasTotal).length()-3)
					+"."+
					(""+ventasTotal).substring((""+ventasTotal).length()-3, (""+ventasTotal).length());
		}
		else
		{
			System.out.println("....................................2");
			if((""+ventasTotal).length() >= 7){
				sventasTotal = (""+ventasTotal).substring(0,(""+ventasTotal).length()-6)
						+"."+
						(""+ventasTotal).substring((""+ventasTotal).length()-6, (""+ventasTotal).length()-3)
						+"."+
						(""+ventasTotal).substring((""+ventasTotal).length()-3, (""+ventasTotal).length());
			}
		}
		
		return "$ " + sventasTotal;
		
	}

	public void setSventasTotal(String sventasTotal) {
		this.sventasTotal = sventasTotal;
	}

	public String getSavanceTotal() {
		
		
		avanceTotal = getAvanceTotal()*100;
		if(avanceTotal  >= 100)
			savanceTotal = (""+avanceTotal).substring(0,3)+"%";
		else
		if(avanceTotal > 9)
		  savanceTotal = (""+avanceTotal).substring(0,2)+"%";
		else
			if(avanceTotal <= 9)
			savanceTotal = (""+avanceTotal).substring(0,1)+"%";
		
		return savanceTotal;
		
	}

	public void setSavanceTotal(String savanceTotal) {
		this.savanceTotal = savanceTotal;
	}

	public MetasBean getMetaSelected() {
		return metaSelected;
	}

	public void setMetaSelected(MetasBean metaSelected) {
		this.metaSelected = metaSelected;
	}

	public List<LocalBean> getMetas() {
		return metas;
	}

	public void setMetas(List<LocalBean> metas) {
		this.metas = metas;
	}

	
	
    
}