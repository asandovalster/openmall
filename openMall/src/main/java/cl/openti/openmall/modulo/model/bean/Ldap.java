package cl.openti.openmall.modulo.model.bean;


public class Ldap {

	private String ldap_URL;  
	private String searchBase;
	private String dominio;
	private String ldapFactory;
	

		
		
		


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
