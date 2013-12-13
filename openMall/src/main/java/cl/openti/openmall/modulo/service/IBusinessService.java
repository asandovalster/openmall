package cl.openti.openmall.modulo.service;

import cl.openti.openmall.modulo.exception.OpenTIException;
import cl.openti.openmall.modulo.model.bean.DatosUsuarioBean;
import cl.openti.openmall.modulo.model.bean.UserBean;
import cl.openti.openmall.modulo.model.bean.ZonaBean;

public interface IBusinessService {

	void loadUser(UserBean user) throws OpenTIException;
	
	void loadModulos(UserBean user) throws OpenTIException;

	
	void loadMap(ZonaBean zona, int cod) throws OpenTIException;

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
