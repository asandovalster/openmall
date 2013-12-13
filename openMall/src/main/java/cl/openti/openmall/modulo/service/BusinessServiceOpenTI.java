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
import cl.openti.openmall.modulo.model.bean.MeterGaugeChart;
import cl.openti.openmall.modulo.model.bean.TableBean;
import cl.openti.openmall.modulo.model.bean.TableCDABean;
import cl.openti.openmall.modulo.model.bean.TableDsctoGarantiaDeptoBean;
import cl.openti.openmall.modulo.model.bean.TableDsctoSuperBean;
import cl.openti.openmall.modulo.model.bean.TableHourBean;
import cl.openti.openmall.modulo.model.bean.TableHourLocalBean;
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
	public void loadArchivos(TableCDABean cda) throws OpenTIException {
		// TODO Auto-generated method stub
		
		try {
			
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadArchivos(cda);
			
			
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
	public void loadVentas(TableBean table) throws OpenTIException {
		// TODO Auto-generated method stub
		try {
			System.out.println("loadVentas");
			log.debug("loadVentas");
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadVentas( table );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");
	}
	
	@Override
	public void loadVentas(TableCDABean table) throws OpenTIException {
		// TODO Auto-generated method stub
		try {
			System.out.println("loadVentas");
			log.debug("loadVentas");
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadVentasCDA( table );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");
	}
	
	
	@Override
	public void loadMetas(TableBean table) throws OpenTIException {
		// TODO Auto-generated method stub
		try {
			System.out.println("loadMetas");
			log.debug("loadMetas");
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadMetas( table );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");
	}
	
	
	
	
	public void loadVentasHora(TableHourLocalBean table) throws OpenTIException{
		
				try {
					System.out.println("loadVentasHora");
					log.debug("loadVentas");
					ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
							"bean_configuration.xml", this.getClass());
					IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
					dao.loadVentasHora( table );
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
				}
				
				log.debug("Finalizando la capa de Servicio");
		
	}
	
	
	
    /**
     * Carga del Ranking Supervisor
     */
	public void loadRankingSupervisor(TableDsctoSuperBean table) throws OpenTIException{
		
				try {
					
					ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
							"bean_configuration.xml", this.getClass());
					IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
					dao.loadRankingSupervisor( table );
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
				}
				
				log.debug("Finalizando la capa de Servicio");
		
	}
	
	
	public void loadGarantiaExtendida(TableDsctoGarantiaDeptoBean table) throws OpenTIException{
		
		try {
			
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadGarantiaExtendida( table );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");

}
	
	/**
	 * Servicio de carga de las garantias extendidas en el Aread de Seguros.
	 */
//	@Override
//	public void loadGarantiasExtendidas(TableGarantiaExtendidaBean table)
//			throws OpenTIException {
//
//
//		try {
//			
//			UsuarioDAO.getInstance().loadRankingSupervisor( table );
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
//		}
//		
//		log.debug("Finalizando la capa de Servicio");
//		
//		
//	}
	
	
	@Override
	public void loadMedidor(MeterGaugeChart bean) throws OpenTIException {
		// TODO Auto-generated method stub
		try {
			System.out.println("loadVentas");
			log.debug("loadVentas");
			
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadMedidor( bean );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");
	}
		
	
	
	@Override
	public void loadPie(PieChartModel pie) throws OpenTIException {
		// TODO Auto-generated method stub
		try {
			System.out.println("loadVentas");
			log.debug("loadVentas");
			
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadPie( pie );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");
	}
	
	
	@Override
	public void loadBarra(CartesianChartModel  category) throws OpenTIException {
		// TODO Auto-generated method stub
		try {
			
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
					"bean_configuration.xml", this.getClass());
			IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
			dao.loadBarra( category );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OpenTIException("Error en la capa de Servicio " + e.getCause());
		}
		
		log.debug("Finalizando la capa de Servicio");
	}

	@Override
	public void loadVentas(TableHourBean table) throws OpenTIException {
		// TODO Auto-generated method stub
				try {
					System.out.println("BusinessServiceHites.loadVentas:"+table.getDfecha());
					log.debug("loadVentas");
					
					ApplicationContext beanFactory = new ClassPathXmlApplicationContext(
							"bean_configuration.xml", this.getClass());
					IManagerDAO dao = (IManagerDAO) beanFactory.getBean("ManagerDao");
					dao.loadVentas( table );
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


