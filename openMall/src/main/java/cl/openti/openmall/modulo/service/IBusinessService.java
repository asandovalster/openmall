package cl.openti.openmall.modulo.service;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.PieChartModel;

import cl.openti.openmall.modulo.exception.HitesException;
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

	void loadUser(UserBean user) throws HitesException;
	
	void loadModulos(UserBean user) throws HitesException;

	void loadVentas(TableBean table) throws HitesException;

	void loadVentasHora(TableHourLocalBean table) throws HitesException;

	void loadVentas(TableHourBean table) throws HitesException;

	void loadVentas(TableCDABean table) throws HitesException;
	
	void loadMetas(TableBean table) throws HitesException;
	
	void loadRankingSupervisor(TableDsctoSuperBean table) throws HitesException;
	
	void loadGarantiaExtendida(TableDsctoGarantiaDeptoBean table) throws HitesException;

	void loadMedidor(MeterGaugeChart model) throws HitesException;

	void loadPie(PieChartModel pie) throws HitesException;

	void loadBarra(CartesianChartModel category) throws HitesException;

	void loadMap(ZonaBean zona, int cod) throws HitesException;

	void loadArchivos(TableCDABean cda) throws HitesException;
	
	public String getLdapFactory();

	public void setLdapFactory(String ldapFactory);

	public String getLdap_URL();

	public void setLdap_URL(String ldap_URL);

	public String getSearchBase();

	public void setSearchBase(String searchBase);

	public String getDominio();

	public void setDominio(String dominio);

}
