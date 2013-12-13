package cl.openti.openmall.modulo.service;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.PieChartModel;

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

public interface IBusinessService {

	void loadUser(UserBean user) throws OpenTIException;
	
	void loadModulos(UserBean user) throws OpenTIException;

	void loadVentas(TableBean table) throws OpenTIException;

	void loadVentasHora(TableHourLocalBean table) throws OpenTIException;

	void loadVentas(TableHourBean table) throws OpenTIException;

	void loadVentas(TableCDABean table) throws OpenTIException;
	
	void loadMetas(TableBean table) throws OpenTIException;
	
	void loadRankingSupervisor(TableDsctoSuperBean table) throws OpenTIException;
	
	void loadGarantiaExtendida(TableDsctoGarantiaDeptoBean table) throws OpenTIException;

	void loadMedidor(MeterGaugeChart model) throws OpenTIException;

	void loadPie(PieChartModel pie) throws OpenTIException;

	void loadBarra(CartesianChartModel category) throws OpenTIException;

	void loadMap(ZonaBean zona, int cod) throws OpenTIException;

	void loadArchivos(TableCDABean cda) throws OpenTIException;
	
	public String getLdapFactory() throws OpenTIException;

	public void setLdapFactory(String ldapFactory) throws OpenTIException;

	public String getLdap_URL() throws OpenTIException;

	public void setLdap_URL(String ldap_URL) throws OpenTIException;

	public String getSearchBase() throws OpenTIException;

	public void setSearchBase(String searchBase) throws OpenTIException;

	public String getDominio() throws OpenTIException;

	public void setDominio(String dominio) throws OpenTIException;
	
	public void saveRegister(DatosUsuarioBean datos) throws OpenTIException;

}
