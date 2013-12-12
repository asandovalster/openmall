package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.openti.openmall.modulo.service.IBusinessService;


@ManagedBean(name = "meterGaugeChart")
@SessionScoped	
public class MeterGaugeChart implements Serializable {

	
	private MeterGaugeChartModel model = new MeterGaugeChartModel();

	public MeterGaugeChartModel getModel() {
		return model;
	}

	public void setModel(MeterGaugeChartModel model) {
		this.model = model;
	}


	 public String goReporte2() {
	
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
			
			IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");
			try {
			// Se audita llamada
				proxy.loadMedidor(this);
			} catch (Exception e) {
						e.printStackTrace();
			}
			String url = "reporte2.xhtml";

			return url + "?faces-redirect=true";
		}
		
	
	
	
	
	
}
