package cl.openti.openmall.modulo.model.bean;

import javax.activation.MimetypesFileTypeMap;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.openti.openmall.modulo.exception.HitesException;
import cl.openti.openmall.modulo.model.datamodel.PerfilDataModel;
import cl.openti.openmall.modulo.model.datamodel.RolDataModel;
import cl.openti.openmall.modulo.model.datamodel.UsuarioDataModel;
import cl.openti.openmall.modulo.service.IBusinessService;
import cl.openti.openmall.modulo.view.bean.PerfilesTableBean;
import cl.openti.openmall.modulo.view.bean.RolesTableBean;
import cl.openti.openmall.modulo.view.bean.UsuariosTableBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final Logger log = Logger.getLogger(UserBean.class);

	
	private StreamedContent dFile;

   private boolean renderedR1 = false;
	private boolean renderedR2 = false;
	private boolean renderedR3 = false;
	private boolean renderedR4 = false;
	private boolean renderedR5 = false;
	private boolean renderedR6 = false;
	private boolean renderedR7 = false;
	private boolean renderedR8 = false;
	private boolean renderedR9 = false;
	private boolean renderedR10 = false;
	private boolean renderedR11 = false;
	private boolean renderedR12 = false;
	private boolean renderedR13 = false;
	private boolean renderedR14 = false;
	private boolean renderedR15 = false;
	private boolean renderedR16 = false;
	private boolean renderedR17 = false;
	private boolean renderedR18 = false;
	private boolean renderedR19 = false;
	private boolean renderedR20 = false;
	
	private boolean renderedR21 = false;
	private boolean renderedR22 = false;
	private boolean renderedR23 = false;
	private boolean renderedR24 = false;
	private boolean renderedR25 = false;
	private boolean renderedR26 = false;
	private boolean renderedR27 = false;
	private boolean renderedR28 = false;
	private boolean renderedR29 = false;
	private boolean renderedR30 = false;
	private boolean renderedR31 = false;
	private boolean renderedR32 = false;
	private boolean renderedR33 = false;
	private boolean renderedR34 = false;
	private boolean renderedR35 = false;
	private boolean renderedR36 = false;
	private boolean renderedR37 = false;
	
	
	@NotNull
	@Size(min = 5, max = 12, message = "El largo de usuario debe estar entre 5 y 12")
	protected String name = "";
	@NotNull
	@Size(min = 5, max = 12, message = "El largo de usuario debe estar entre 5 y 12")
	protected String password = "";
	protected String iframeUrl = "";
	private DatosUsuarioBean datos = new DatosUsuarioBean();

	private MeterGaugeChartModel meterGaugeModel = new MeterGaugeChartModel();
	private long ventaGeneralGauge = 0;
	private PieChartModel pieModel = new PieChartModel();;
    private CartesianChartModel categoryModel = new CartesianChartModel(); 
    
    
    private String companyName="company Name";
    private String companyAddressHTML = "companyAddressHTML";
	private String companyLat = "companyLat";
	private String companyLong = "companyLong";
	private String companyFax = "companyFax";
	private String companyEmail = "companyEmail";
	
    private ZonaBean zonabean = new ZonaBean();
	
	
    
	private Date dfecha;
	
	
	 public StreamedContent getdFile() {
		 
	        return dFile;
	    }
		
	
	 public void setdFile(StreamedContent dFile) {
		this.dFile = dFile;
	}


	/**
	 * Tablas
	 */
	PerfilesTableBean perfilesTable = new PerfilesTableBean();
	RolesTableBean rolesTable = new RolesTableBean();
	UsuariosTableBean usuariosTable = new UsuariosTableBean();
    TableHourBean tableHourBean ;
	
	/**
	 * Model
	 */
	private PerfilBean perfil = new PerfilBean();
	private PerfilBean perfilselected = new PerfilBean();
	private PerfilDataModel perfilModel = new PerfilDataModel();
	/**
	 * Tree Perfil
	 */
	private TreeNode root;
	private TreeNode selectedNode;

	private RolBean rol = new RolBean();
	private RolBean rolselected = new RolBean();
	private RolDataModel rolModel = new RolDataModel();

	private UsuarioBean usuario = new UsuarioBean();
	private UsuarioBean usuarioselected = new UsuarioBean();
	private UsuarioDataModel usuarioModel = new UsuarioDataModel();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	String url = "";
	String url2 = "http://10.107.100.25:8080/pentaho/ViewAction?solution=Reporteria%20Movil&path=&action=Efectividad%20de%20Ventas%20v2.xaction?userid=arquitectura&password=hitesbi";
	String url3 = "http://10.107.100.25:8080/pentaho/ViewAction?solution=Reporteria%20Movil&path=&action=Productividad%20v2.xaction&userid=arquitectura&password=hitesbi";

	
	
	
	public UserBean() {
		
			setName("");
			setPassword("");
			
			InputStream is =this.getClass().getClassLoader().getResourceAsStream("OpenMall.apk");
			
			dFile = new DefaultStreamedContent(is, "application/vnd.android.package-archive", "OpenMall.apk");
			
	}

	public void validateEmail(FacesContext context, UIComponent validated,
			Object value) {
		// simple stupid validation
		String mail = (String) value;
		if (!mail.matches(".+\\@.+\\..+")) {
			FacesMessage msg = new FacesMessage("This is not an e-mail!");
			throw new ValidatorException(msg);
		}
	}

	public String logon() {
		String forward = "fail";
		try {
			System.out.println("...---");
			ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
			
			IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");
			
			proxy.loadUser(this);

			log.debug("..::: Autenticacion: usuario"+ this.getName());

			log.debug("::: Autenticacion: password"
					+ this.getPassword());

			log.debug("::: Autenticacion: datos usuario"
					+ this.getDatos().getNombres() );
			
			
			if( this.getDatos() != null && this.getDatos().getNombres() != null && this.getDatos().getNombres().length() > 0 )
			{
						//if(LoginLdap.getInstance().Authenticate(getName(), getPassword()) && getPassword().length()>0)
						//{
								log.debug(".............::: Autenticacion: entro9 success9");
								forward = "success";
								// cargar los modulos que estan restringidos
								//proxy.loadModulos(this);
							
						//}else{
							//this.clear();
							
						//	FacesContext ctx0 = FacesContext.getCurrentInstance();
						//	Flash flash = ctx0.getExternalContext().getFlash();
						//	flash.setKeepMessages(true);
							
						//	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Acceso Denegado: Clave Invalida","HiNetTablet - Security");
						//	ctx0.addMessage(null,msg);
						//	this.setName("");
						//	this.setPassword("");
							
//							FacesContext.getCurrentInstance()
//							.addMessage(
//									"messages",
//									new FacesMessage(FacesMessage.SEVERITY_ERROR,
//											"Acceso Denegado",
//											"HitesNetTablet - Security"));
							
//						      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "PrimeFaces rocks!"));
//						      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Sample warn message", "Watch out for PrimeFaces!"));
//						      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample error message", "PrimeFaces makes no mistakes"));
//						      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Sample fatal message", "Fatal Error in System"));
					  
							
							
						//	System.out.println("::: Autenticacion: no autenticado");
							
						//	forward = "faces/logon.xhtml?faces-redirect=true";
						//}	
			}else{
				
				this.clear();
				FacesContext ctx1 = FacesContext.getCurrentInstance();
				Flash flash = ctx1.getExternalContext().getFlash();
				flash.setKeepMessages(true);
				
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Acceso Denegado: usuario No registrado","OpenMall - Security");
				ctx1.addMessage(null,msg);
				this.setName("");
				this.setPassword("");
				log.debug("::: Autenticacion: usuario no registrado ");
				forward = "success";
			}		
						
		} catch (HitesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return forward;
	}

	public String logout() {
		this.clear();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession) facesContext
				.getExternalContext().getSession(false);
		httpSession.invalidate();

		return "success";
	}

	public String submit() {

		log.debug("submit..........");

		String param = "&userid=" + name + "&password=" + password;

		url = "http://pentahoo.hites.cl:8080/pentaho/ViewAction?solution=Reporteria%20Movil&path=&action=Cantidad%20de%20Boletas%20vs%20Trafico%20v2.xaction&userid=arquitectura&password=hitesbi";

		return "pentaho.xhtml?faces-redirect=true";

	}

	public String submit2() {

		log.debug("submit..........");

		String param = "&userid=" + name + "&password=" + password;

		url2 = "http://pentahoo.hites.cl:8080/pentaho/ViewAction?solution=Reporteria%20Movil&path=&action=Efectividad%20de%20Ventas%20v2.xaction&userid=arquitectura&password=hitesbi";

		return "pentaho2.xhtml?faces-redirect=true";

	}

	public String submit3() {

		log.debug("submit..........");

		String param = "&userid=" + name + "&password=" + password;

		url = "http://pentahoo.hites.cl:8080/pentaho/ViewAction?solution=Reporteria%20Movil&path=&action=Productividad%20v2.xaction&userid=arquitectura&password=hitesbi";

		return "pentaho3.xhtml?faces-redirect=true";

	}

	/**
	 * Despliega la informacion de las tiendas del centro
	 * @return
	 */
	public String goMapCentro() {
		
		
		 	ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
			
			IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");
			try {
			// Se audita llamada
				proxy.loadMap(zonabean,ZonaBean.ZONA_CENTRO);
			} catch (Exception e) {
						e.printStackTrace();
			}
		
		url = "centro.xhtml";

		return url + "?faces-redirect=true";
	}
	
	/**
	 * Despliega la informacion de las tiendas del centro
	 * @return
	 */
	public String goMapNorte() {
		
	 	ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
		
		IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");
		try {
		// Se audita llamada
			proxy.loadMap(zonabean,ZonaBean.ZONA_NORTE);
		} catch (Exception e) {
					e.printStackTrace();
		}
		
		url = "norte.xhtml";

		return url + "?faces-redirect=true";
	}
	
	/**
	 * Despliega la informacion de las tiendas del centro
	 * @return
	 */
	public String goMapSur() {
		

	 	ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
		
		IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");
		try {
		// Se audita llamada
			proxy.loadMap(zonabean,ZonaBean.ZONA_SUR);
		} catch (Exception e) {
					e.printStackTrace();
		}
		
		url = "sur.xhtml";
		
		return url + "?faces-redirect=true";
	}
	
   public String goReporte10() {
		
		log.debug("goReporte10..........");



		url = "reporte1_0.xhtml";

		return url + "?faces-redirect=true";
	}

	
	public String goReporte11() {
		
		log.debug("goReporte11..........");



		url = "reporte1_1.xhtml";

		return url + "?faces-redirect=true";
	}

	public String goReporte12() {
		
		log.debug("goReporte12..........");

		url = "reporte1_2.xhtml";

		return url + "?faces-redirect=true";
	}
	
	
	
	public String goReporte13() {
		
		log.debug("goReporte13..........");

		url = "reporte1_3.xhtml";

		return url + "?faces-redirect=true";
	}
	public String goReporte14() {
		
		log.debug("goReporte14..........");
		url = "reporte1_4.xhtml";

		return url + "?faces-redirect=true";
	}


	public String goReporte15() {
	
		
		log.debug("goReporte15..........");
		url = "reporte1_5.xhtml";

		return url + "?faces-redirect=true";
	}
	public String goReporte16() {
	
		
		log.debug("goReporte16..........");
		url = "reporte1_6.xhtml";

		return url + "?faces-redirect=true";
	}



	public String goReporte1() {
		
		log.debug("goReporte1..........");



		url = "reporte1.xhtml";

		return url + "?faces-redirect=true";
	}
	

 public String goReporte3() {
	 
	 log.debug("goReporte3..........");

		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
		
		IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");
		try {
		// Se audita llamada
			proxy.loadBarra(categoryModel);
		} catch (Exception e) {
					e.printStackTrace();
		}
		url = "reporte3.xhtml";
	 
		return url + "?faces-redirect=true";
 }
public String goReporte4() {
	 
	 log.debug("goReporte4..........");

		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("bean_configuration.xml",this.getClass());
		
		IBusinessService proxy = (IBusinessService) beanFactory.getBean("proxyGestor");
		try {
		// Se audita llamada
			proxy.loadPie(pieModel);
		} catch (Exception e) {
					e.printStackTrace();
		}
		url = "reporte4.xhtml";
	 
		return url + "?faces-redirect=true";
 }
	


	public void setIframeUrl(String iframeUrl) {
		this.iframeUrl = iframeUrl;
	}

	public PerfilBean getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}

	public DatosUsuarioBean getDatos() {
		return datos;
	}

	public void setDatos(DatosUsuarioBean datos) {
		this.datos = datos;
	}

	public String getIframeUrl() {
		return iframeUrl;
	}

	public String toGraphURL(String property) {
		Properties props = new Properties();
		String url = "";
		try {
			InputStream input = getClass().getResourceAsStream(
					"messages.properties");
			props.load(input);

			url = props.getProperty(property);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return url;
	}

	public PerfilesTableBean getPerfilesTable() {
		return perfilesTable;
	}

	public void setPerfilesTable(PerfilesTableBean perfilesTable) {
		this.perfilesTable = perfilesTable;
	}

	public RolesTableBean getRolesTable() {
		return rolesTable;
	}

	public void setRolesTable(RolesTableBean rolesTable) {
		this.rolesTable = rolesTable;
	}

	public UsuariosTableBean getUsuariosTable() {
		return usuariosTable;
	}

	public void setUsuariosTable(UsuariosTableBean usuariosTable) {
		this.usuariosTable = usuariosTable;
	}

	public PerfilBean getPerfilselected() {
		return perfilselected;
	}

	public void setPerfilselected(PerfilBean perfilselected) {
		this.perfilselected = perfilselected;
	}

	public PerfilDataModel getPerfilModel() {
		return perfilModel;
	}

	public void setPerfilModel(PerfilDataModel perfilModel) {
		this.perfilModel = perfilModel;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public RolBean getRol() {
		return rol;
	}

	public void setRol(RolBean rol) {
		this.rol = rol;
	}

	public RolBean getRolselected() {
		return rolselected;
	}

	public void setRolselected(RolBean rolselected) {
		this.rolselected = rolselected;
	}

	public RolDataModel getRolModel() {
		return rolModel;
	}

	public void setRolModel(RolDataModel rolModel) {
		this.rolModel = rolModel;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public UsuarioBean getUsuarioselected() {
		return usuarioselected;
	}

	public void setUsuarioselected(UsuarioBean usuarioselected) {
		this.usuarioselected = usuarioselected;
	}

	public UsuarioDataModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioDataModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	private void clear() {

		this.name = "";
		this.password = "";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MeterGaugeChartModel getMeterGaugeModel() {
		return meterGaugeModel;
	}

	public void setMeterGaugeModel(MeterGaugeChartModel meterGaugeModel) {
		this.meterGaugeModel = meterGaugeModel;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public CartesianChartModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CartesianChartModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public long getVentaGeneralGauge() {
		return ventaGeneralGauge;
	}

	public void setVentaGeneralGauge(long ventaGeneralGauge) {
		this.ventaGeneralGauge = ventaGeneralGauge;
	}

	public String getUrl2() {
		return url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public String getUrl3() {
		return url3;
	}

	public void setUrl3(String url3) {
		this.url3 = url3;
	}

	public Date getDfecha() {
		return dfecha;
	}

	public void setDfecha(Date dfecha) {
		this.dfecha = dfecha;
	}

	public TableHourBean getTableHourBean() {
		return tableHourBean;
	}

	public void setTableHourBean(TableHourBean tableHourBean) {
		this.tableHourBean = tableHourBean;
	}
	public void loadfecha(ActionEvent evt){
		
		    //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+((Calendar) evt.getComponent()).getValue());
		
		
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddressHTML() {
		return companyAddressHTML;
	}

	public void setCompanyAddressHTML(String companyAddressHTML) {
		this.companyAddressHTML = companyAddressHTML;
	}

	public String getCompanyLat() {
		return companyLat;
	}

	public void setCompanyLat(String companyLat) {
		this.companyLat = companyLat;
	}

	
	public String getCompanyLong() {
		return companyLong;
	}

	public void setCompanyLong(String companyLong) {
		this.companyLong = companyLong;
	}

	public String getCompanyFax() {
		return companyFax;
	}

	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public ZonaBean getZonabean() {
		return zonabean;
	}

	public void setZonabean(ZonaBean zonabean) {
		this.zonabean = zonabean;
	}

	public boolean isRenderedR10() {
		return renderedR10;
	}

	public void setRenderedR10(boolean renderedR10) {
		this.renderedR10 = renderedR10;
	}

	public boolean isRenderedR11() {
		return renderedR11;
	}

	public void setRenderedR11(boolean renderedR11) {
		this.renderedR11 = renderedR11;
	}

	public boolean isRenderedR12() {
		return renderedR12;
	}

	public void setRenderedR12(boolean renderedR12) {
		this.renderedR12 = renderedR12;
	}

	public boolean isRenderedR16() {
		return renderedR16;
	}

	public void setRenderedR16(boolean renderedR16) {
		this.renderedR16 = renderedR16;
	}

	public boolean isRenderedR1() {
		return renderedR1;
	}

	public void setRenderedR1(boolean renderedR1) {
		this.renderedR1 = renderedR1;
	}

	public boolean isRenderedR2() {
		return renderedR2;
	}

	public void setRenderedR2(boolean renderedR2) {
		this.renderedR2 = renderedR2;
	}

	public boolean isRenderedR3() {
		return renderedR3;
	}

	public void setRenderedR3(boolean renderedR3) {
		this.renderedR3 = renderedR3;
	}

	public boolean isRenderedR4() {
		return renderedR4;
	}

	public void setRenderedR4(boolean renderedR4) {
		this.renderedR4 = renderedR4;
	}

	public boolean isRenderedR5() {
		return renderedR5;
	}

	public void setRenderedR5(boolean renderedR5) {
		this.renderedR5 = renderedR5;
	}

	public boolean isRenderedR6() {
		return renderedR6;
	}

	public void setRenderedR6(boolean renderedR6) {
		this.renderedR6 = renderedR6;
	}

	public boolean isRenderedR7() {
		return renderedR7;
	}

	public void setRenderedR7(boolean renderedR7) {
		this.renderedR7 = renderedR7;
	}

	public boolean isRenderedR8() {
		return renderedR8;
	}

	public void setRenderedR8(boolean renderedR8) {
		this.renderedR8 = renderedR8;
	}

	public boolean isRenderedR9() {
		return renderedR9;
	}

	public void setRenderedR9(boolean renderedR9) {
		this.renderedR9 = renderedR9;
	}

	public boolean isRenderedR13() {
		return renderedR13;
	}

	public void setRenderedR13(boolean renderedR13) {
		this.renderedR13 = renderedR13;
	}

	public boolean isRenderedR14() {
		return renderedR14;
	}

	public void setRenderedR14(boolean renderedR14) {
		this.renderedR14 = renderedR14;
	}

	public boolean isRenderedR15() {
		return renderedR15;
	}

	public void setRenderedR15(boolean renderedR15) {
		this.renderedR15 = renderedR15;
	}

	public boolean isRenderedR17() {
		return renderedR17;
	}

	public void setRenderedR17(boolean renderedR17) {
		this.renderedR17 = renderedR17;
	}

	public boolean isRenderedR18() {
		return renderedR18;
	}

	public void setRenderedR18(boolean renderedR18) {
		this.renderedR18 = renderedR18;
	}

	public boolean isRenderedR19() {
		return renderedR19;
	}

	public void setRenderedR19(boolean renderedR19) {
		this.renderedR19 = renderedR19;
	}

	public boolean isRenderedR20() {
		return renderedR20;
	}

	public void setRenderedR20(boolean renderedR20) {
		this.renderedR20 = renderedR20;
	}

	public boolean isRenderedR21() {
		return renderedR21;
	}

	public void setRenderedR21(boolean renderedR21) {
		this.renderedR21 = renderedR21;
	}

	public boolean isRenderedR22() {
		return renderedR22;
	}

	public void setRenderedR22(boolean renderedR22) {
		this.renderedR22 = renderedR22;
	}

	public boolean isRenderedR23() {
		return renderedR23;
	}

	public void setRenderedR23(boolean renderedR23) {
		this.renderedR23 = renderedR23;
	}

	public boolean isRenderedR24() {
		return renderedR24;
	}

	public void setRenderedR24(boolean renderedR24) {
		this.renderedR24 = renderedR24;
	}

	public boolean isRenderedR25() {
		return renderedR25;
	}

	public void setRenderedR25(boolean renderedR25) {
		this.renderedR25 = renderedR25;
	}

	public boolean isRenderedR26() {
		return renderedR26;
	}

	public void setRenderedR26(boolean renderedR26) {
		this.renderedR26 = renderedR26;
	}

	public boolean isRenderedR27() {
		return renderedR27;
	}

	public void setRenderedR27(boolean renderedR27) {
		this.renderedR27 = renderedR27;
	}

	public boolean isRenderedR28() {
		return renderedR28;
	}

	public void setRenderedR28(boolean renderedR28) {
		this.renderedR28 = renderedR28;
	}

	public boolean isRenderedR29() {
		return renderedR29;
	}

	public void setRenderedR29(boolean renderedR29) {
		this.renderedR29 = renderedR29;
	}

	public boolean isRenderedR30() {
		return renderedR30;
	}

	public void setRenderedR30(boolean renderedR30) {
		this.renderedR30 = renderedR30;
	}

	public boolean isRenderedR31() {
		return renderedR31;
	}

	public void setRenderedR31(boolean renderedR31) {
		this.renderedR31 = renderedR31;
	}

	public boolean isRenderedR32() {
		return renderedR32;
	}

	public void setRenderedR32(boolean renderedR32) {
		this.renderedR32 = renderedR32;
	}

	public boolean isRenderedR33() {
		return renderedR33;
	}

	public void setRenderedR33(boolean renderedR33) {
		this.renderedR33 = renderedR33;
	}

	public boolean isRenderedR34() {
		return renderedR34;
	}

	public void setRenderedR34(boolean renderedR34) {
		this.renderedR34 = renderedR34;
	}

	public boolean isRenderedR35() {
		return renderedR35;
	}

	public void setRenderedR35(boolean renderedR35) {
		this.renderedR35 = renderedR35;
	}

	public boolean isRenderedR36() {
		return renderedR36;
	}

	public void setRenderedR36(boolean renderedR36) {
		this.renderedR36 = renderedR36;
	}

	public boolean isRenderedR37() {
		return renderedR37;
	}

	public void setRenderedR37(boolean renderedR37) {
		this.renderedR37 = renderedR37;
	}
	
	
	
	
	
	
	
	
}