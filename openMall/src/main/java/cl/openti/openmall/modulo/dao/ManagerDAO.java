package cl.openti.openmall.modulo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import cl.openti.openmall.modulo.model.bean.DatosUsuarioBean;
import cl.openti.openmall.modulo.model.bean.UserBean;
import cl.openti.openmall.modulo.model.bean.ZonaBean;

/**
 * 
 * Dao que reune los servicios de Seguridad y de Negocio.
 * 
 * @author Alejandro Sandoval Schwartzmann
 *
 */
public class ManagerDAO implements IManagerDAO{

	static final Logger log = Logger.getLogger(ManagerDAO.class);

	
	@Resource 
	DataSource dataSource;
	
	
	private static ManagerDAO  instance= null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy");
	
	String value = "";
	
	private ManagerDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ManagerDAO getInstance() {

		if (instance == null) {
			instance = new ManagerDAO();

		}

		return instance;

	}
	
	@Override
	public void loadModulos(UserBean user) throws SQLException {
		
		// Apunta al modelo de datos de desarrollo , al modulo de seguridad
		Connection con = dataSource.getConnection();
		//ManagerConnection.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		try {
			
			String sql_archivos = ""+
					"SELECT  " +
					"  a.ID_USUARIO,a.USERNAME,b.ID_MODULO " + 
					" FROM openmall_USUARIO a JOIN openmall_UXM b ON" + 
					" a.USERNAME =  ? and a.ID_USUARIO = b.ID_USUARIO";
			
			pst = con.prepareStatement( sql_archivos );
			pst.setString(1, user.getName()); 
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				log.debug("*** Si esta lo muestra ***");
				long modulo = rs.getLong("ID_MODULO");
				log.debug("*** MODULO:  *** " + modulo);
				
				if(modulo == 1)
				{
					user.setRenderedR1(true);
				}
				if(modulo == 2)
				{
					user.setRenderedR2(true);
				}
				if(modulo == 3)
				{
					user.setRenderedR3(true);
				}
				if(modulo == 4)
				{
					user.setRenderedR4(true);
				}
				if(modulo == 5)
				{
					user.setRenderedR5(true);
				}
				if(modulo == 6)
				{
					user.setRenderedR6(true);
				}
				if(modulo == 7)
				{
					user.setRenderedR7(true);
				}
				if(modulo == 8)
				{
					user.setRenderedR8(true);
				}
				if(modulo == 9)
				{
					user.setRenderedR9(true);
				}
				if(modulo == 10)
				{
					user.setRenderedR10(true);
				}
				
				if(modulo == 11)
				{
					user.setRenderedR11(true);
				}
				if(modulo == 12)
				{
					user.setRenderedR12(true);
				}
				if(modulo == 13)
				{
					user.setRenderedR13(true);
				}
				if(modulo == 14)
				{
					user.setRenderedR14(true);
				}
				if(modulo == 15)
				{
					user.setRenderedR15(true);
				}
				if(modulo == 16)
				{
					user.setRenderedR16(true);
				}
				if(modulo == 17)
				{
					user.setRenderedR17(true);
				}
				if(modulo == 18)
				{
					user.setRenderedR18(true);
				}
				if(modulo == 19)
				{
					user.setRenderedR19(true);
				}
				if(modulo == 20)
				{
					user.setRenderedR20(true);
				}
				
				
				if(modulo == 21)
				{
					user.setRenderedR21(true);
				}
				if(modulo == 22)
				{
					user.setRenderedR22(true);
				}
				if(modulo == 23)
				{
					user.setRenderedR23(true);
				}
				if(modulo == 24)
				{
					user.setRenderedR24(true);
				}
				if(modulo == 25)
				{
					user.setRenderedR25(true);
				}
				if(modulo == 26)
				{
					user.setRenderedR26(true);
				}
				if(modulo == 27)
				{
					user.setRenderedR27(true);
				}
				if(modulo == 28)
				{
					user.setRenderedR28(true);
				}
				if(modulo == 29)
				{
					user.setRenderedR29(true);
				}
				if(modulo == 30)
				{
					user.setRenderedR30(true);
				}
				
				if(modulo == 31)
				{
					user.setRenderedR31(true);
				}
				if(modulo == 32)
				{
					user.setRenderedR32(true);
				}
				if(modulo == 33)
				{
					user.setRenderedR33(true);
				}
				if(modulo == 34)
				{
					user.setRenderedR34(true);
				}
				if(modulo == 35)
				{
					user.setRenderedR35(true);
				}
				if(modulo == 36)
				{
					user.setRenderedR36(true);
				}
				if(modulo == 37)
				{
					user.setRenderedR37(true);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			

		} 
		
		
	}

	/**
	 * Carga los datos del usuario al momento de autenticar
	 * @param user
	 * @throws SQLException
	 */
	@Override
	public void loadUser(UserBean user) throws SQLException {
		//
		Connection con = dataSource.getConnection();
		//ManagerConnection.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement pst = null;
		////////System.out.println(con);
		try {

			String query = "select du.nombres,du.apellidos,u.id_usuario,du.direccion,du.email,du.telefono" +
					" from openmall_usuario u ,openmall_datos_usuario du" +
					" where u.id_usuario = du.id_usuario and u.username = ? and u.password = ?";
					//",openmall_rol r,openmall_cargo c where u.id_usuario = du.id_usuario and u.id_perfil = r.id_rol and c.id = r.id_cargo and u.username = ?");

			pst = con.prepareStatement( query );
			
			
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			
			rs = pst.executeQuery();
			
			if (rs.next()) {
				//////////System.out.println("Acceso a la Base de Datos... ");
				// Cargamos Nombre, Apellido, Perfil, Email
				user.getDatos().setNombres(rs.getString("nombres"));
				user.getDatos().setApellidos(rs.getString("apellidos"));
				user.getDatos().setEmail(rs.getString("email"));
				user.getDatos().setDireccion( rs.getString("direccion") );
				user.getDatos().setTelefono(rs.getString("telefono"));
				/*************************/
			}else{
				log.debug("NO Acceso a la Base de Datos... ");
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			

		} 

	}
	
	@Override
	public void registerUsuario(DatosUsuarioBean datos) throws SQLException {
		// TODO Auto-generated method stub
		
		//
		Connection con = dataSource.getConnection();
	    long id_usuario = 0;
		PreparedStatement pst = null;
		try {
			// se un numero nuevo!!!! en un segundo 0000000000.1 segundo
			pst = con.prepareStatement("insert into openmall_usuario values(0,0,?,?)");

			pst.setString(1, datos.getUsername());
			pst.setString(2, datos.getPassword());
			
			boolean ret = pst.execute();
			
			// se un numero nuevo!!!! en un segundo 0000000000.1 segundo
			pst = con.prepareStatement("select max(id_usuario) from openmall_usuario");

			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				id_usuario = rs.getLong(1);
				
			}
			
			
			
			if( !ret && id_usuario > 0)
			{
				
			    pst = con.prepareStatement("insert into openmall_datos_usuario values(?,?,?,? ,?,?,?,?)");

			    pst.setLong(1, id_usuario);
			    pst.setString(2, datos.getNombres());
			    pst.setString(3, datos.getApellidos());
			    pst.setString(4, datos.getEmail());
			    pst.setString(5, datos.getDireccion());
			    pst.setString(6, datos.getTelefono());
			    pst.setInt(7, 0);
			    pst.setInt(8, 0);
			    
			    pst.execute();
			}   
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally { 
			

		} 
		
		
		
	}
	
	@Override
	/**
	 * Servicio que Carga la ZonaBean
	 */
	public void loadMap(ZonaBean zona,int cod) throws SQLException {
		
		Connection con = dataSource.getConnection();
		   //ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		
		String sql_tiendas_zonas= "" +
				" select  p1.glozon as Zona  " + 
				" , v1.codigo_local as Cod_Local   " +   
				" , v1.tienda as Tienda    " + 
				" , p1.direccion as Direccion  " + 
				" , p1.comuna as Comuna  " + 
				" , p1.ciudad as Ciudad  " + 
				" , p1.pais as Pais  " + 
				" , p1.cordenadas as LatLon  " + 
				" , sum(v1.monto) as Vta_Neta   " +   
				" , sum(v1.venta_finan) as Vta_Fin    " + 
				" , count (distinct v1.id_boleta) as Cant_Boleta  " +   
				" from fact_venta_diaria2 v1, parzon p1     " + 
				" where   p1.codzon = ? and v1.fecha = to_date(sysdate, 'dd-mm-yy')  " +    
				" and v1.codigo_local <=80 and v1.codigo_local = p1.codloc  " +   
				" group by v1.codigo_local, v1.tienda,p1.direccion,p1.comuna,p1.ciudad,p1.pais, p1.cordenadas , p1.glozon  " +   
				" order by p1.glozon,v1.codigo_local    " ;
		
		
	try{	
		pst = con.prepareStatement(sql_tiendas_zonas);
		pst.setInt(1, cod);
		rs = pst.executeQuery();
		
  
		while (rs.next()) {// ciclo de locales
			
			// detectar zona
			if(cod == ZonaBean.ZONA_CENTRO)
			{
				switch (rs.getInt("Cod_Local")) {
				case 6:
					zona.getTienda6().setZona(rs.getString("Zona"));
					zona.getTienda6().setCod_local(""+rs.getInt("Cod_Local"));
					zona.getTienda6().setTienda(rs.getString("Tienda"));
					zona.getTienda6().setDireccion(rs.getString("Direccion"));
					zona.getTienda6().setComuna(rs.getString("Comuna"));
					zona.getTienda6().setCiudad(rs.getString("Ciudad"));
					zona.getTienda6().setPais(rs.getString("Pais"));
					zona.getTienda6().setLatitud(rs.getString("LatLon").split(",")[0]);
					zona.getTienda6().setLongitud(rs.getString("LatLon").split(",")[1]);
					zona.getTienda6().setVta_neta(rs.getLong("Vta_Neta"));
					zona.getTienda6().setVta_Fin(rs.getLong("Vta_Fin"));
					zona.getTienda6().setCant_Boleta(rs.getLong("Cant_Boleta"));
					
					break;
				case 8:

					zona.getTienda8().setZona(rs.getString("Zona"));
					zona.getTienda8().setCod_local(""+rs.getInt("Cod_Local"));
					zona.getTienda8().setTienda(rs.getString("Tienda"));
					zona.getTienda8().setDireccion(rs.getString("Direccion"));
					zona.getTienda8().setComuna(rs.getString("Comuna"));
					zona.getTienda8().setCiudad(rs.getString("Ciudad"));
					zona.getTienda8().setPais(rs.getString("Pais"));
					zona.getTienda8().setLatitud(rs.getString("LatLon").split(",")[0]);
					zona.getTienda8().setLongitud(rs.getString("LatLon").split(",")[1]);
					zona.getTienda8().setVta_neta(rs.getLong("Vta_Neta"));
					zona.getTienda8().setVta_Fin(rs.getLong("Vta_Fin"));
					zona.getTienda8().setCant_Boleta(rs.getLong("Cant_Boleta"));

					break;	
				case 11:
					
					zona.getTienda11().setZona(rs.getString("Zona"));
					zona.getTienda11().setCod_local(""+rs.getInt("Cod_Local"));
					zona.getTienda11().setTienda(rs.getString("Tienda"));
					zona.getTienda11().setDireccion(rs.getString("Direccion"));
					zona.getTienda11().setComuna(rs.getString("Comuna"));
					zona.getTienda11().setCiudad(rs.getString("Ciudad"));
					zona.getTienda11().setPais(rs.getString("Pais"));
					zona.getTienda11().setLatitud(rs.getString("LatLon").split(",")[0]);
					zona.getTienda11().setLongitud(rs.getString("LatLon").split(",")[1]);
					zona.getTienda11().setVta_neta(rs.getLong("Vta_Neta"));
					zona.getTienda11().setVta_Fin(rs.getLong("Vta_Fin"));
					zona.getTienda11().setCant_Boleta(rs.getLong("Cant_Boleta"));

					
					break;	
				case 50:

					zona.getTienda50().setZona(rs.getString("Zona"));
					zona.getTienda50().setCod_local(""+rs.getInt("Cod_Local"));
					zona.getTienda50().setTienda(rs.getString("Tienda"));
					zona.getTienda50().setDireccion(rs.getString("Direccion"));
					zona.getTienda50().setComuna(rs.getString("Comuna"));
					zona.getTienda50().setCiudad(rs.getString("Ciudad"));
					zona.getTienda50().setPais(rs.getString("Pais"));
					zona.getTienda50().setLatitud(rs.getString("LatLon").split(",")[0]);
					zona.getTienda50().setLongitud(rs.getString("LatLon").split(",")[1]);
					zona.getTienda50().setVta_neta(rs.getLong("Vta_Neta"));
					zona.getTienda50().setVta_Fin(rs.getLong("Vta_Fin"));
					zona.getTienda50().setCant_Boleta(rs.getLong("Cant_Boleta"));


					
					break;	
				case 51:
					
					zona.getTienda51().setZona(rs.getString("Zona"));
					zona.getTienda51().setCod_local(""+rs.getInt("Cod_Local"));
					zona.getTienda51().setTienda(rs.getString("Tienda"));
					zona.getTienda51().setDireccion(rs.getString("Direccion"));
					zona.getTienda51().setComuna(rs.getString("Comuna"));
					zona.getTienda51().setCiudad(rs.getString("Ciudad"));
					zona.getTienda51().setPais(rs.getString("Pais"));
					zona.getTienda51().setLatitud(rs.getString("LatLon").split(",")[0]);
					zona.getTienda51().setLongitud(rs.getString("LatLon").split(",")[1]);
					zona.getTienda51().setVta_neta(rs.getLong("Vta_Neta"));
					zona.getTienda51().setVta_Fin(rs.getLong("Vta_Fin"));
					zona.getTienda51().setCant_Boleta(rs.getLong("Cant_Boleta"));


					
					break;
				case 54:
					
					zona.getTienda54().setZona(rs.getString("Zona"));
					zona.getTienda54().setCod_local(""+rs.getInt("Cod_Local"));
					zona.getTienda54().setTienda(rs.getString("Tienda"));
					zona.getTienda54().setDireccion(rs.getString("Direccion"));
					zona.getTienda54().setComuna(rs.getString("Comuna"));
					zona.getTienda54().setCiudad(rs.getString("Ciudad"));
					zona.getTienda54().setPais(rs.getString("Pais"));
					zona.getTienda54().setLatitud(rs.getString("LatLon").split(",")[0]);
					zona.getTienda54().setLongitud(rs.getString("LatLon").split(",")[1]);
					zona.getTienda54().setVta_neta(rs.getLong("Vta_Neta"));
					zona.getTienda54().setVta_Fin(rs.getLong("Vta_Fin"));
					zona.getTienda54().setCant_Boleta(rs.getLong("Cant_Boleta"));
					
					
					break;	

				case 55:
					
					zona.getTienda55().setZona(rs.getString("Zona"));
					zona.getTienda55().setCod_local(""+rs.getInt("Cod_Local"));
					zona.getTienda55().setTienda(rs.getString("Tienda"));
					zona.getTienda55().setDireccion(rs.getString("Direccion"));
					zona.getTienda55().setComuna(rs.getString("Comuna"));
					zona.getTienda55().setCiudad(rs.getString("Ciudad"));
					zona.getTienda55().setPais(rs.getString("Pais"));
					zona.getTienda55().setLatitud(rs.getString("LatLon").split(",")[0]);
					zona.getTienda55().setLongitud(rs.getString("LatLon").split(",")[1]);
					zona.getTienda55().setVta_neta(rs.getLong("Vta_Neta"));
					zona.getTienda55().setVta_Fin(rs.getLong("Vta_Fin"));
					zona.getTienda55().setCant_Boleta(rs.getLong("Cant_Boleta"));
					
					
					break;	
					
				default:
					break;
				}
				
				
				
			}else
			if(cod == ZonaBean.ZONA_NORTE)
			{
				System.out.println("Entro Norte!!!");
				System.out.println("Local Codigo:" + rs.getInt("Cod_Local"));
				switch (rs.getInt("Cod_Local")) {
				case 40:
					zona.getTienda40().setZona(rs.getString("Zona"));
					zona.getTienda40().setCod_local(""+rs.getInt("Cod_Local"));
					zona.getTienda40().setTienda(rs.getString("Tienda"));
					zona.getTienda40().setDireccion(rs.getString("Direccion"));
					zona.getTienda40().setComuna(rs.getString("Comuna"));
					zona.getTienda40().setCiudad(rs.getString("Ciudad"));
					zona.getTienda40().setPais(rs.getString("Pais"));
					zona.getTienda40().setLatitud(rs.getString("LatLon").split(",")[0]);
					zona.getTienda40().setLongitud(rs.getString("LatLon").split(",")[1]);
					zona.getTienda40().setVta_neta(rs.getLong("Vta_Neta"));
					zona.getTienda40().setVta_Fin(rs.getLong("Vta_Fin"));
					zona.getTienda40().setCant_Boleta(rs.getLong("Cant_Boleta"));
					System.out.println(zona.getTienda40().getTienda());
					break;
					
				case 47:
					zona.getTienda47().setZona(rs.getString("Zona"));
					zona.getTienda47().setCod_local(""+rs.getInt("Cod_Local"));
					zona.getTienda47().setTienda(rs.getString("Tienda"));
					zona.getTienda47().setDireccion(rs.getString("Direccion"));
					zona.getTienda47().setComuna(rs.getString("Comuna"));
					zona.getTienda47().setCiudad(rs.getString("Ciudad"));
					zona.getTienda47().setPais(rs.getString("Pais"));
					zona.getTienda47().setLatitud(rs.getString("LatLon").split(",")[0]);
					zona.getTienda47().setLongitud(rs.getString("LatLon").split(",")[1]);
					zona.getTienda47().setVta_neta(rs.getLong("Vta_Neta"));
					zona.getTienda47().setVta_Fin(rs.getLong("Vta_Fin"));
					zona.getTienda47().setCant_Boleta(rs.getLong("Cant_Boleta"));
					System.out.println(zona.getTienda47().getTienda());
					break;
				case 59:

					zona.getTienda59().setZona(rs.getString("Zona"));
					zona.getTienda59().setCod_local(""+rs.getInt("Cod_Local"));
					zona.getTienda59().setTienda(rs.getString("Tienda"));
					zona.getTienda59().setDireccion(rs.getString("Direccion"));
					zona.getTienda59().setComuna(rs.getString("Comuna"));
					zona.getTienda59().setCiudad(rs.getString("Ciudad"));
					zona.getTienda59().setPais(rs.getString("Pais"));
					zona.getTienda59().setLatitud(rs.getString("LatLon").split(",")[0]);
					zona.getTienda59().setLongitud(rs.getString("LatLon").split(",")[1]);
					zona.getTienda59().setVta_neta(rs.getLong("Vta_Neta"));
					zona.getTienda59().setVta_Fin(rs.getLong("Vta_Fin"));
					zona.getTienda59().setCant_Boleta(rs.getLong("Cant_Boleta"));
					System.out.println(zona.getTienda59().getTienda());
					break;	
				default:
					break;
				}
			}else
			{
					if(cod == ZonaBean.ZONA_SUR)
					{
						switch (rs.getInt("Cod_Local")) {
						case 34:
							zona.getTienda34().setZona(rs.getString("Zona"));
							zona.getTienda34().setCod_local(""+rs.getInt("Cod_Local"));
							zona.getTienda34().setTienda(rs.getString("Tienda"));
							zona.getTienda34().setDireccion(rs.getString("Direccion"));
							zona.getTienda34().setComuna(rs.getString("Comuna"));
							zona.getTienda34().setCiudad(rs.getString("Ciudad"));
							zona.getTienda34().setPais(rs.getString("Pais"));
							zona.getTienda34().setLatitud(rs.getString("LatLon").split(",")[0]);
							zona.getTienda34().setLongitud(rs.getString("LatLon").split(",")[1]);
							zona.getTienda34().setVta_neta(rs.getLong("Vta_Neta"));
							zona.getTienda34().setVta_Fin(rs.getLong("Vta_Fin"));
							zona.getTienda34().setCant_Boleta(rs.getLong("Cant_Boleta"));
							
							break;
						case 45:

							zona.getTienda45().setZona(rs.getString("Zona"));
							zona.getTienda45().setCod_local(""+rs.getInt("Cod_Local"));
							zona.getTienda45().setTienda(rs.getString("Tienda"));
							zona.getTienda45().setDireccion(rs.getString("Direccion"));
							zona.getTienda45().setComuna(rs.getString("Comuna"));
							zona.getTienda45().setCiudad(rs.getString("Ciudad"));
							zona.getTienda45().setPais(rs.getString("Pais"));
							zona.getTienda45().setLatitud(rs.getString("LatLon").split(",")[0]);
							zona.getTienda45().setLongitud(rs.getString("LatLon").split(",")[1]);
							zona.getTienda45().setVta_neta(rs.getLong("Vta_Neta"));
							zona.getTienda45().setVta_Fin(rs.getLong("Vta_Fin"));
							zona.getTienda45().setCant_Boleta(rs.getLong("Cant_Boleta"));

							break;	
					
						case 49:

							zona.getTienda49().setZona(rs.getString("Zona"));
							zona.getTienda49().setCod_local(""+rs.getInt("Cod_Local"));
							zona.getTienda49().setTienda(rs.getString("Tienda"));
							zona.getTienda49().setDireccion(rs.getString("Direccion"));
							zona.getTienda49().setComuna(rs.getString("Comuna"));
							zona.getTienda49().setCiudad(rs.getString("Ciudad"));
							zona.getTienda49().setPais(rs.getString("Pais"));
							zona.getTienda49().setLatitud(rs.getString("LatLon").split(",")[0]);
							zona.getTienda49().setLongitud(rs.getString("LatLon").split(",")[1]);
							zona.getTienda49().setVta_neta(rs.getLong("Vta_Neta"));
							zona.getTienda49().setVta_Fin(rs.getLong("Vta_Fin"));
							zona.getTienda49().setCant_Boleta(rs.getLong("Cant_Boleta"));


							
							break;	
						case 56:
							
							zona.getTienda56().setZona(rs.getString("Zona"));
							zona.getTienda56().setCod_local(""+rs.getInt("Cod_Local"));
							zona.getTienda56().setTienda(rs.getString("Tienda"));
							zona.getTienda56().setDireccion(rs.getString("Direccion"));
							zona.getTienda56().setComuna(rs.getString("Comuna"));
							zona.getTienda56().setCiudad(rs.getString("Ciudad"));
							zona.getTienda56().setPais(rs.getString("Pais"));
							zona.getTienda56().setLatitud(rs.getString("LatLon").split(",")[0]);
							zona.getTienda56().setLongitud(rs.getString("LatLon").split(",")[1]);
							zona.getTienda56().setVta_neta(rs.getLong("Vta_Neta"));
							zona.getTienda56().setVta_Fin(rs.getLong("Vta_Fin"));
							zona.getTienda56().setCant_Boleta(rs.getLong("Cant_Boleta"));


							
							break;
						case 57:
							
							zona.getTienda57().setZona(rs.getString("Zona"));
							zona.getTienda57().setCod_local(""+rs.getInt("Cod_Local"));
							zona.getTienda57().setTienda(rs.getString("Tienda"));
							zona.getTienda57().setDireccion(rs.getString("Direccion"));
							zona.getTienda57().setComuna(rs.getString("Comuna"));
							zona.getTienda57().setCiudad(rs.getString("Ciudad"));
							zona.getTienda57().setPais(rs.getString("Pais"));
							zona.getTienda57().setLatitud(rs.getString("LatLon").split(",")[0]);
							zona.getTienda57().setLongitud(rs.getString("LatLon").split(",")[1]);
							zona.getTienda57().setVta_neta(rs.getLong("Vta_Neta"));
							zona.getTienda57().setVta_Fin(rs.getLong("Vta_Fin"));
							zona.getTienda57().setCant_Boleta(rs.getLong("Cant_Boleta"));
							
							
							break;	

						default:
							break;
						}
						
					}
			
			
			}
			
		}
			
	} catch (Exception e) {

		e.printStackTrace();
	} finally {
		
		try{
			rs.close();
			
		}catch(Exception e){}	
		try{
		pst.close();
		}catch(Exception e){}
		try{
		con.close();
		}catch(Exception e){}
	} 
		
		
		
		
		
		
	}
	
	public void loadPie(PieChartModel pie) throws SQLException {
		// TODO Auto-generated method stub
		//
		Connection con = dataSource.getConnection();
		   //ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		//////////System.out.println("---------------------------------------- loadMedidor");
		try {

		
			
			pst = con.prepareStatement("select local,ventas FROM ventasact1 where  ventas <> 0 ");
			rs = pst.executeQuery();
			while (rs.next()) {
				try{
					pie.set(rs.getString(1),new Long(rs.getLong(2)));
			    	
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			rs.close();
			pst.close();
		}
		//////////System.out.println("Fin loadMedidor");
	}
	
	
	public void loadBarra(CartesianChartModel category) throws SQLException {
		// TODO Auto-generated method stub
		//
		category.clear();
		Connection con = dataSource.getConnection();
		   //ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		//////////System.out.println("---------------------------------------- loadMedidor");
		
		
//		 ChartSeries boys = new ChartSeries();  
//	        boys.setLabel("Boys");  
//	  
//	        boys.set("2004", 120);  
//	        boys.set("2005", 100);  
//	        boys.set("2006", 44);  
//	        boys.set("2007", 150);  
//	        boys.set("2008", 25);  
//	  
//	        ChartSeries girls = new ChartSeries();  
//	        girls.setLabel("Girls");  
//	  
//	        girls.set("2004", 52);  
//	        girls.set("2005", 60);  
//	        girls.set("2006", 110);  
//	        girls.set("2007", 135);  
//	        girls.set("2008", 120);  
//	  
//	        category.addSeries(boys);  
//	        category.addSeries(girls);  
//		
		ChartSeries metas = new ChartSeries("Metas"); 
		ChartSeries ventas = new ChartSeries("Ventas"); 
		
		try {

			
			pst = con.prepareStatement("select local,metas,ventas FROM ventasact1 where  ventas <> 0 ");
			rs = pst.executeQuery();
			while (rs.next()) {
				try{
					
					metas.set(rs.getString(1),new Long(rs.getLong(2)));
					ventas.set(rs.getString(1),new Long(rs.getLong(3)));
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			rs.close();
			pst.close();
		}
		category.addSeries(metas);  
		category.addSeries(ventas);     	
		//////////System.out.println("Fin loadMedidor");
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

		
	
}