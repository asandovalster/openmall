package cl.openti.openmall.modulo.model.bean;

import java.io.IOException;
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
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
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
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.openti.openmall.modulo.service.IBusinessService;

@ManagedBean(name = "tableDsctoSuperBean")
@SessionScoped
public class TableDsctoSuperBean implements Serializable {

	static final Logger log = Logger.getLogger(TableDsctoSuperBean.class);

	private String fecha = null;
	private String fechaC = "12/12/2012";
	private Date dfecha;
	private boolean value2 = false;

	private List<DsctoBean> descuentos = new ArrayList<DsctoBean>();
	private SalesBean salesSelected = new SalesBean();

	
	
	private long baseTotal = 0;
	private long netoTotal = 0;
	private long dsctoTotal = 0;
	private double avanceTotal = 0;
	
	private String sbaseTotal = "0";
	private String snetoTotal = "0";
	private String sdsctoTotal = "0";
	private String savanceTotal = "0";
	
	
	
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
		
		double davanceTotal = getAvanceTotal()*100;
		if(davanceTotal  >= 100)
			savanceTotal = (""+davanceTotal).substring(0,3)+"%";
		else
		if(davanceTotal > 9)
		  savanceTotal = (""+davanceTotal).substring(0,2)+"%";
		else
			if(davanceTotal <= 9)
			savanceTotal = (""+davanceTotal).substring(0,1)+"%";
		
		return savanceTotal;
		
		
		
	}

	public void setSavanceTotal(String savanceTotal) {
		this.savanceTotal = savanceTotal;
	}
	
	public TableDsctoSuperBean() {
		cargaRanking();
	}

	/**
	 * Carga Ranking
	 */
	private void cargaRanking() {

		log.debug("cargaRanking::::::::::");
		try {

			// llamada Spring
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IBusinessService proxy = (IBusinessService) beanFactory
					.getBean("proxyGestor");

			// Se audita llamada
			proxy.loadRankingSupervisor( this );

		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	public List<DsctoBean> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(List<DsctoBean> descuentos) {
		this.descuentos = descuentos;
	}

	public String getFecha() {
		if (fecha != null && (fecha + "").length() >= 10)
			fecha = fecha.substring(0, 10);
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFechaC() {
		fechaC = fechaC.substring(0, 10);
		return fechaC;
	}

	public void setFechaC(String fechaC) {
		this.fechaC = fechaC;
	}

	

	public void onRowUnselect(UnselectEvent event) {
		
		System.out.println("onRowUnSelect");
		
		FacesMessage msg = new FacesMessage("Seller DesSelected", "" + ((SellerBean) event.getObject()).getId_seller());

		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	
	public boolean isValue2() {
		return value2;
	}

	public void setValue2(boolean value2) {
		this.value2 = value2;
	}

	public void addMessage() {

		System.out.println("addMessage");

		String summary = value2 ? "Historico" : "On Demand";

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(summary));
	}

	public void valueChangeCalendar(ValueChangeEvent evt) {
		System.out.println("....");
		if (evt.getComponent().getId().equalsIgnoreCase("dfecha")) {
			System.out.println("::::");
			System.out.println("valueChangeCalendar:"
					+ ((Calendar) evt.getComponent()).getValue());
			SimpleDateFormat sdf = new SimpleDateFormat(
					"EEE MMM dd HH:mm:ss z yyyy", Locale.CANADA);

			try {
				setDfecha(sdf.parse(((Calendar) evt.getComponent()).getValue()
						.toString()));
				cargaRanking();
				Iterator<UIComponent> it = evt.getComponent().getParent()
						.getChildren().iterator();
				for (Iterator iterator = it; iterator.hasNext();) {
					UIComponent ui = (UIComponent) iterator.next();
					System.out.println(ui.getId());
				}

				System.out.println("exito:" + getDfecha());
			} catch (ParseException e) {

				e.printStackTrace();
			}
		}

	}
	
	public void onRowSelect(SelectEvent event) {
		
		   DecimalFormat df1 = new DecimalFormat("###,###,###");//.000
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
		   SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		
		    this.setSalesSelected(((SalesBean) event.getObject()));
		   
//		    try {
				//Date d1 = sdf.parse(getSalesSelected().getFecha());
				
				//getSalesSelected().setFecha(sdf2.format(d1));
				
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		    System.out.println("Supervisor:::::: " + getSalesSelected().getVendedor());
		    System.out.println("Boletas:::::: " + getSalesSelected().getBoletas().size());
		    
		    
		 	FacesContext ctx = FacesContext.getCurrentInstance();
		 	ExternalContext extContext = ctx.getExternalContext();
		 	String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, "/reporte1_4_1.xhtml"));
		 	try {
		 		extContext.redirect(url);
		 	} catch (IOException e) {
		 		e.printStackTrace();
		 	}
		
		 	 
			
	 } 

	public Date getDfecha() {
		return dfecha;
	}

	public void setDfecha(Date dfecha) {
		this.dfecha = dfecha;
	}
	

	public SalesBean getSalesSelected() {
		return salesSelected;
	}

	public void setSalesSelected(SalesBean salesSelected) {
		this.salesSelected = salesSelected;
	}

public long getBaseTotal() {
		
		long ltotal = 0;

		for (DsctoBean dscto : getDescuentos()) {
			ltotal += dscto.getMontoBase();
		}

		return ltotal;
		
	}

	public void setBaseTotal(long baseTotal) {
		this.baseTotal = baseTotal;
	}

	public long getNetoTotal() {
		
		long ltotal = 0;

		for (DsctoBean dscto : getDescuentos()) {
			ltotal += dscto.getMontoNeto();
		}

		return ltotal;
	}

	public void setNetoTotal(long netoTotal) {
		this.netoTotal = netoTotal;
	}

	public long getDsctoTotal() {
		
		long ltotal = 0;

		for (DsctoBean dscto : getDescuentos()) {
			ltotal += dscto.getDscto();
		}

		return ltotal;
	}

	public void setDsctoTotal(long dsctoTotal) {
		this.dsctoTotal = dsctoTotal;
	}

	public double getAvanceTotal() {
		
		double ret = 0;
		
		long vt = getDsctoTotal();
		long mt = getBaseTotal();
		System.out.println(vt + " " + mt);
		ret = Double.parseDouble(""+vt) / Double.parseDouble(""+mt);
		System.out.println("ret:"+ret);
		return ret;
		
	}

	public void setAvanceTotal(double avanceTotal) {
		this.avanceTotal = avanceTotal;
	}
	
}