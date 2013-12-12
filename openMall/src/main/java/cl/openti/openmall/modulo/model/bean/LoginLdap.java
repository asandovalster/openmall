package cl.openti.openmall.modulo.model.bean;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.openti.openmall.modulo.service.IBusinessService;


public class LoginLdap implements Login {
	
	
	private static LoginLdap instance = null;
	   
    public static LoginLdap getInstance() {
		instance =  new LoginLdap();
		return instance;
	}


	public boolean Authenticate(String User, String Password) {
		
		 Ldap ibc = null;
			try {

//			    ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-security-LDAP.xml");
//			    ibc = (Ldap) ctx.getBean("ldap");
			    
			    ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
				@SuppressWarnings("unchecked")
				IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");
			    
			    Hashtable env = new Hashtable();

			      env.put(Context.INITIAL_CONTEXT_FACTORY, proxy.getLdapFactory());

			      env.put(Context.PROVIDER_URL, proxy.getLdap_URL() + "/" + proxy.getSearchBase());

			      env.put(Context.SECURITY_AUTHENTICATION, "simple");
			      env.put(Context.SECURITY_PRINCIPAL, User.toUpperCase() + "@" + proxy.getDominio() );
			      env.put(Context.SECURITY_CREDENTIALS, Password);

			      try {



			          DirContext dctx = new InitialDirContext(env);
			          dctx.close();
			          
			          return true;

			      } catch (NamingException ex) {

			          //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
			          return false;

			      }

			} catch (Exception e) {
				e.printStackTrace();
			}
		// TODO Auto-generated method stub
			
		return false;
	}
	
	


}
