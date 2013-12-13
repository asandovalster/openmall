package cl.openti.openmall.modulo.service;

import java.io.Serializable;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.openti.openmall.modulo.dao.IManagerDAO;
import cl.openti.openmall.modulo.exception.OpenTIException;
import cl.openti.openmall.modulo.model.bean.DatosUsuarioBean;
import cl.openti.openmall.modulo.model.bean.UserBean;
import cl.openti.openmall.modulo.model.bean.ZonaBean;


public class BusinessServiceOpenTI implements IBusinessService, Serializable {

	
	private String ldap_URL;  
	private String searchBase;
	private String dominio;
	private String ldapFactory;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(BusinessServiceOpenTI.class);
	
	
	@Override
	public void saveRegister(DatosUsuarioBean datos) throws OpenTIException {
		// TODO Auto-generated method stub
	
		try {
			
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.registerUsuario(datos);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");
		
	}
	
	@Override
	public void loadUser(UserBean user) throws OpenTIException {
		
		try {
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadUser(user);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");
	
	}
	
	
	@Override
	public void loadModulos(UserBean user) throws OpenTIException {
		
		try {
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadModulos(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");
	
	}
	
	


	@Override
	public void loadMap(ZonaBean zona, int cod) throws OpenTIException {
		// TODO Auto-generated method stub
		
		
		// TODO Auto-generated method stub
		try {
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadMap( zona , cod );
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");
		
		
	}

	
	/**
	 * Security --
	 */
	public String getLdapFactory() {
		return ldapFactory;
	}

	public void setLdapFactory(String ldapFactory) {
		this.ldapFactory = ldapFactory;
	}

		public String getLdap_URL() {
			return ldap_URL;
		}

		public void setLdap_URL(String ldap_URL) {
			this.ldap_URL = ldap_URL;
		}

		public String getSearchBase() {
			return searchBase;
		}

		public void setSearchBase(String searchBase) {
			this.searchBase = searchBase;
		}

		public String getDominio() {
			return dominio;
		}


		public void setDominio(String dominio) {
			this.dominio = dominio;
		}

	
	
		

	
	
	
}


