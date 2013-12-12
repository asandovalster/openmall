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
import javax.faces.model.SelectItem;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.jdbc.core.JdbcTemplate;

import cl.openti.openmall.modulo.model.bean.AreaBean;
import cl.openti.openmall.modulo.model.bean.BoletaBean;
import cl.openti.openmall.modulo.model.bean.BoletaGarantiaBean;
import cl.openti.openmall.modulo.model.bean.CDABean;
import cl.openti.openmall.modulo.model.bean.DepartamentoBean;
import cl.openti.openmall.modulo.model.bean.DsctoBean;
import cl.openti.openmall.modulo.model.bean.DsctoGarantiaDeptoBean;
import cl.openti.openmall.modulo.model.bean.ItemBoletaBean;
import cl.openti.openmall.modulo.model.bean.LocalBean;
import cl.openti.openmall.modulo.model.bean.LocalGarantiaBean;
import cl.openti.openmall.modulo.model.bean.MetasBean;
import cl.openti.openmall.modulo.model.bean.MeterGaugeChart;
import cl.openti.openmall.modulo.model.bean.PosicionBean;
import cl.openti.openmall.modulo.model.bean.SalesBean;
import cl.openti.openmall.modulo.model.bean.TableBean;
import cl.openti.openmall.modulo.model.bean.TableCDABean;
import cl.openti.openmall.modulo.model.bean.TableDsctoGarantiaDeptoBean;
import cl.openti.openmall.modulo.model.bean.TableDsctoSuperBean;
import cl.openti.openmall.modulo.model.bean.TableHourBean;
import cl.openti.openmall.modulo.model.bean.TableHourLocalBean;
import cl.openti.openmall.modulo.model.bean.UserBean;
import cl.openti.openmall.modulo.model.bean.VendedorGarantiaBean;
import cl.openti.openmall.modulo.model.bean.VentasHoraBean;
import cl.openti.openmall.modulo.model.bean.ZonaBean;
import cl.openti.openmall.modulo.model.datamodel.AreaDataModel;
import cl.openti.openmall.modulo.model.datamodel.BoletaDataModel;
import cl.openti.openmall.modulo.model.datamodel.BoletaGarantiaDataModel;
import cl.openti.openmall.modulo.model.datamodel.LocalDataModel;
import cl.openti.openmall.modulo.model.datamodel.LocalGarantiaDataModel;
import cl.openti.openmall.modulo.model.datamodel.MetasDataModel;
import cl.openti.openmall.modulo.model.datamodel.SalesDataModel;
import cl.openti.openmall.modulo.model.datamodel.VendedorGarantiaDataModel;

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
	
	/**
	 * Carga los archivos, para la carga de las estadisticas
	 * @param user
	 * @throws SQLException
	 */
	@Override
	public void loadArchivos(TableCDABean table) throws SQLException {
		//
		Connection con = dataSource.getConnection();
				//;ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			List lista = new ArrayList();

			String sql_archivos = ""+
					"SELECT  " +
					"  DISTINCT trim(CDAT_ARCH) as CDAT_ARCH " + // archivos a evaluar
					" FROM CDATT01 " ;
			log.debug("................2");
			pst = con.prepareStatement( sql_archivos );

			rs = pst.executeQuery();
			
			while (rs.next()) {
				
					SelectItem item = new SelectItem(rs.getString("CDAT_ARCH"),rs.getString("CDAT_ARCH"));
					table.getArchivos().add(item);
					/*****************************/
					log.debug("................");
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			

		} 

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
	 * Lista de Ventas Activas
	 */
	@Override
	public void loadVentasCDA(TableCDABean table) throws SQLException {
		
		Connection con = dataSource.getConnection();
		//ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		String sql = "";
		String filterArchivo = " TRIM(CDAT_ARCH) = ?";
		String filterFechas = " CDAT_FCAR >= ? and CDAT_FCAR <= ?";
		
		String sql_local = ""+
				"SELECT CDAT_AREA, " +
				"  CDAT_FCAR, " +
				"  trim(CDAT_ARCH) as CDAT_ARCH, " + // archivos a evaluar
//				"  CDAT_BIB," +
//				"  to_char(CDAT_FINI, 'yyyy/MM/dd') AS CDAT_FINI," +
//				"  CDAT_HINI," +
//				"  to_char(CDAT_FFIN, 'yyyy/MM/dd') AS CDAT_FFIN," +
//				"  CDAT_HFIN," +
				"  CDAT_TREG," + // Registros iseries
//				"  CDAT_TSUM," +
//				"  CDAT_EST," +
//				"  to_char(CDAT_FINIP, 'yyyy/MM/dd') AS CDAT_FINIP," +
//				"  CDAT_HINIP," +
//				"  to_char(CDAT_FFINP, 'yyyy/MM/dd') AS CDAT_FFINP," +
//				"  CDAT_HFINP," +
				"  CDAT_TREGP," + // registros de pentaho
//				"  CDAT_TSUMP," +
				"  CDAT_DIF" +
				" FROM CDATT01   " ;
				
		try {
			
			if (!String.valueOf(table.getFilterArchivo()).equalsIgnoreCase("0")) // Involucra a un archivo en particular
			{
					sql = sql_local + " WHERE " + filterArchivo + " and" + filterFechas;

					pst = con.prepareStatement(sql);
					
					log.debug("Entro >>>> sql:"+sql);
					
					table.toPrint();
					
					pst.setString(1, table.getFilterArchivo().trim()); // se limpia el filtro de archivo
					pst.setString(2, sdf3.format(table.getFilterDesde()));
					pst.setString(3, sdf3.format(table.getFilterHasta()));
					
			} else {
				
					log.debug("Entro >>>> 2");
					sql = sql_local + " WHERE " + filterFechas;
					pst = con.prepareStatement(sql);

					pst.setString(1, sdf3.format(table.getFilterDesde()));
					pst.setString(2, sdf3.format(table.getFilterHasta()));
					log.debug("Entro >>>> sql:"+sql);
					
					table.toPrint();
					
			}
			
			table.toPrint();
			
			
			log.debug("|||||||||||||||||| Antes de executeQuery");
			rs = pst.executeQuery();
			log.debug("|||||||||||||||||| Despues de executeQuery");
			table.getCda().clear();
			while (rs.next()) { 
				
				log.debug("|||||||||||||||||| Entro >>>> While");
				
				
				String sd3 = sdf3.format(rs.getDate("CDAT_FCAR"));
				log.debug("sd3:"+sd3);
				
				table.getCda().add(
						new CDABean(
								rs.getDate("CDAT_FCAR"),
								sd3,
								rs.getString("CDAT_ARCH"),
								rs.getLong("CDAT_TREG"),
								rs.getLong("CDAT_TREGP"),
								rs.getLong("CDAT_DIF")));
				
				CDABean cd1 = new CDABean(
						rs.getDate("CDAT_FCAR"),
						sd3,
						rs.getString("CDAT_ARCH"),
						rs.getLong("CDAT_TREG"),
						rs.getLong("CDAT_TREGP"),
						rs.getLong("CDAT_DIF"));
				
				cd1.toPrint();
				
				/*************************/
				
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

			pst = con.prepareStatement("select du.nombres,du.apellidos,du.email,r.nombre,u.id_usuario,c.descripcion from openmall_usuario u ,openmall_datos_usuario du,openmall_rol r,openmall_cargo c where u.id_usuario = du.id_usuario and u.id_perfil = r.id_rol and c.id = r.id_cargo and u.username = ?");

			pst.setString(1, user.getName());
			rs = pst.executeQuery();
			if (rs.next()) {
				//////////System.out.println("Acceso a la Base de Datos... ");
				// Cargamos Nombre, Apellido, Perfil, Email
				user.getDatos().setNombres(rs.getString("nombres"));
				user.getDatos().setApellido(rs.getString("apellidos"));
				user.getDatos().setEmail(rs.getString("email"));
				user.getDatos().setCargo( rs.getString("nombre") );
				user.getPerfil().setNombre(rs.getString("descripcion"));
				/*************************/
			}else{
				//////////System.out.println("NO Acceso a la Base de Datos... ");
				//////////System.out.println("user:" + user.getName());
				//////////System.out.println("pass:" + user.getPassword());
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			

		} 

	}
	/**
	 * Carga de las Metas correspondientes, a la fecha actual
	 * @param table
	 * @throws SQLException
	 */
	@Override
	public void loadMetas(TableBean table) throws SQLException {
		// TODO Auto-generated method stub
		//
		
		MetasBean mb = new MetasBean();
		Connection con = dataSource.getConnection();
				//ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		Connection con2 = dataSource.getConnection();
		//ManagerConnection.getInstance().getConnectionP();
		ResultSet rs2 = null;
		PreparedStatement pst2 = null;
		

		// corresponde a la ventas por local 
		String sql_resumen = "select to_char(fecha,'dd-MM-yyyy') as fecha,codigo_local, tienda,  count(cantidad) as unidades, count(distinct num_boleta) as Boletas , sum(monto) as Vta_neta  "+
		" from fact_venta_diaria2 "+
		" where to_char(fecha,'yyyy') = to_char(sysdate,'yyyy')  " +
		" group by fecha,fecha, cod_local,tienda " +
		" order by fecha desc, tienda asc";
		
		String sql_metas = "select hh ,count(cantidad) as unidades, count(distinct num_boleta) as Boletas , sum(monto) as Vta_neta "+
				" from fact_venta_diaria2 where codigo_local = ? and hh <= to_number(to_char(sysdate,'HH'))"+
				" group by tienda, hh, codigo_local " +
				" order by hh asc";
		
		
		try {

			pst = con.prepareStatement( sql_resumen );
			rs = pst.executeQuery();
			
			while (rs.next()) { // ciclo de locales
			
				LocalBean lb=null;
						        
			    lb = new LocalBean( 
			    		rs.getInt("codigo_local"),
			    		rs.getString("fecha"), 
			    		rs.getString("tienda"),
			    		rs.getLong("Vta_neta"),
			    		rs.getInt("unidades"),
			    		rs.getInt("boletas"));
			   
			    pst2 = con2.prepareStatement( sql_metas );
			    
			    pst2.setInt(1, rs.getInt("codigo_local"));
			    
			    List<MetasBean> lmb = new ArrayList<MetasBean>();
			    rs2 = pst2.executeQuery();
			   
			    while (rs2.next()) { // ciclo de Areas
			    	 

			    	mb = new MetasBean();
			    	mb.setHora(rs2.getInt("hh"));
			    	mb.setVentas(rs2.getLong("Vta_neta"));
			    	mb.setUnidades(rs2.getInt("unidades"));
			    	mb.setBoletas(rs2.getInt("boletas"));
			    	
				    lmb.add(mb);
			    	
			    }
			    rs2.close();
			    pst2.close();
			    con2.close();
			    
			    lb.setMetasBean(lmb);
			    lb.setModelMetas( new MetasDataModel( lmb ) );
			    
				table.setFecha(rs.getString("dia"));
				table.setFechaC(rs.getString("dia_comp"));
				table.getVentas().add(lb);
				
				
				
				/*************************/
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
	
	
	@Override
	public void loadVentas(TableBean table) throws SQLException {
		// TODO Auto-generated method stub
		//
		
		AreaBean ab = new AreaBean();
		Connection con = dataSource.getConnection(); 
				//ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		Connection con2 = dataSource.getConnection();
		   //ManagerConnection.getInstance().getConnectionP();
		ResultSet rs2 = null;
		PreparedStatement pst2 = null;
		
		
		Connection con3 = dataSource.getConnection();
		//ManagerConnection.getInstance().getConnectionP();
		ResultSet rs3 = null;
		PreparedStatement pst3 = null;
		
		String sql_local = "select codigo, dia, dia_comp, local, metas, ventas, case when metas > 0 then ventas/(metas+0.000001) else 1 end  as avance FROM ventasact1 where  ventas <> 0 ";
		
		String sql_area = "select are_cod, area , sum(monto) as monto_neto from fact_venta_diaria2 where codigo_local = ? and fecha = ? group by are_cod,area order by sum(monto) desc";
		
		String sql_depto = "select departamento, sum(monto) as monto_neto from fact_venta_diaria2 where codigo_local = ? and are_cod = ? and fecha = ? group by departamento order by sum(monto) desc";
		
		try {

		
			
			pst = con.prepareStatement(sql_local);
			rs = pst.executeQuery();
			Date d2 = new Date();
	  
			while (rs.next()) { // ciclo de locales
			
				LocalBean lb=null;
				ChartSeries metas = new ChartSeries();  
		        metas.setLabel("Metas");  
		        ChartSeries ventas = new ChartSeries();  
		        ventas.setLabel("Ventas");  
		        
			    lb = new LocalBean(rs.getString("dia"),rs.getString("dia_comp"),rs.getString("local"),rs.getLong("metas"),rs.getLong("ventas"),rs.getDouble("avance"));
			   
			    pst2 = con2.prepareStatement(sql_area);
			    
			    pst2.setInt(1, rs.getInt("codigo"));
			    pst2.setDate(2, new java.sql.Date(d2.getTime()));
			    
			    List<AreaBean> lab = new ArrayList<AreaBean>();
			    rs2 = pst2.executeQuery();
			    ////////System.out.println("...........");
			    while (rs2.next()) { // ciclo de Areas
			    	   ////////System.out.println("2...........");

			    	ab = new AreaBean();
			    	ab.setId_area(rs2.getInt("are_cod"));
			    	ab.setArea(rs2.getString("area"));
			    	ab.setMonto(rs2.getDouble("monto_neto"));
			    	
			    	List<DepartamentoBean> ldb = new ArrayList<DepartamentoBean>();
			    	pst3 = con3.prepareStatement(sql_depto);
			    	////////System.out.println( "area:"+ab.getArea() + " local: " + rs.getInt("codigo"));
			    	pst3.setInt(1, rs.getInt("codigo"));
			    	pst3.setInt(2, rs2.getInt("are_cod"));
			    	pst3.setDate(3, new java.sql.Date(d2.getTime()));
				    
				    rs3 = pst3.executeQuery();
				    while (rs3.next()) { // ciclo de departamento
				    	ldb.add(new DepartamentoBean(rs3.getString("departamento"), rs3.getDouble("monto_neto")));
				    }
				    ab.setDeptos(ldb);
			    	lab.add(ab);
			    	////////System.out.println("ab:" + ab.getArea() + " Lista de Depto:" + ldb.size());
			    }
			    lb.setAreas(lab);
			    lb.setModelArea(new AreaDataModel(lab));
				table.setFecha(rs.getString("dia"));
				table.setFechaC(rs.getString("dia_comp"));
				table.getVentas().add(lb);
				
				
				
				/*************************/
			}
//			table.setMeterGaugeModel(new MeterGaugeChartModel("avance",12, table.getIntervals()));
  
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
	
	
	/**
	 * Carga la lista de Ventas Resumen
	 */
	public void loadVentas(TableHourBean table) throws SQLException {
		AreaBean ab = new AreaBean();
		Connection con = dataSource.getConnection();
		//ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		

		//////System.out.println("---------------------------------------------------------------------------------------fecha:"+table.getDfecha());
		
//		String sql_venta_hour = "select local,dia_comp,metas,sum(venta) AS VENTA,HORVEN from FACT_VENTA_HORA where dia = to_date(?,'yyyy-mm-dd') group by local,dia_comp,metas,venta,horven order by local,horven";
		
		String sql_venta_hour = "select local,dia_comp,metas,sum(venta) AS VENTA,HORVEN,ubicacion " + 
		 " from FACT_VENTA_HORA " + 
//		 " where dia BETWEEN to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd') and local <> 'EDIFICIO PUENTE' " + 
		 " where dia = to_date(?,'yyyy-mm-dd')  and local <> 'EDIFICIO PUENTE' " + 
		 " group by ubicacion,local,dia_comp,metas,venta,horven " + 
		 " order by ubicacion,local,horven ";
		List<PosicionBean> lubibean = new ArrayList<PosicionBean>();
		PosicionBean ubibean = new PosicionBean();
		
		List<LocalBean> ventas = new ArrayList<LocalBean>();
		
		try {
			////////System.out.println("ManagerDAO.loadventas.table.getDfecha():"+table.getDfecha());
			pst = con.prepareStatement( sql_venta_hour );
			if(table.getDfecha()==null)
				{
				  table.setDfecha(new Date());
				}
			String sf = sdf.format(table.getDfecha());
//			String sf2 = sdf.format(table.getDfecha2());
			////System.out.println("fecha:"+sf);
			pst.setString(1, sf);
//			pst.setString(2, sf2);
			rs = pst.executeQuery();
			
			
			// Calcular la hora Actual
			
			SimpleDateFormat sdf0 = new SimpleDateFormat("HH:mm");
			
			
			
			Date hoy = new Date();
			boolean flag = false;
			if(sdf.format(table.getDfecha()).equalsIgnoreCase(sdf.format(hoy))){
				 //////System.out.println("Mismo Dia:" + sdf.format(hoy));
				flag = true;
			}
			
			
			
	        // por cada 4 registros hay un local
			int row=0;
			LocalBean lb=null;
			long v1=0,v2=0,v3=0,v4 =0;
			
			
			
			//////System.out.println(sql_venta_hour);
			long id_ubicacion = 0;
			long back_id_ubicacion = 0;
			
			while (rs.next()) { // ciclo de locales
				
				
				if(id_ubicacion==0)
				{	
					//////System.out.println("Se instancia con cumplimiento");
					ubibean = new PosicionBean(1, "Centrales", null);
				}
				back_id_ubicacion = id_ubicacion;
				id_ubicacion = rs.getLong("ubicacion");
				
				if(rs.getLong("ubicacion")==2 && back_id_ubicacion == 1)
				{	
					//////System.out.println("Se instancia sin cumplimiento");
					ubibean.setVentas(ventas);
					lubibean.add(ubibean);
					ventas = new ArrayList<LocalBean>();
					ubibean = new PosicionBean(2, "Nuevos", null);
				}
				
				if(rs.getString("HORVEN").equalsIgnoreCase("13:00"))
				{	
					v1 = rs.getLong("venta");
					lb = new LocalBean();
		            lb.setLocal( rs.getString("local") + "......" );
		            lb.setMetas( rs.getLong("metas") );
		            lb.setVentas13(v1);
		            lb.setVentas15(v2);
		            lb.setVentas18(v3);
                    lb.setVentas23(v4);
                    
                    if((sdf0.parse("13:00").getTime() > sdf0.parse(sdf0.format(hoy)).getTime()) && flag)
		            {
		            	ventas.add(lb);
            		}
            		 
				}else if(rs.getString("HORVEN").equalsIgnoreCase("15:00")){
					
					 v2 = rs.getLong("venta");
					 lb = new LocalBean();
			         lb.setLocal( rs.getString("local")  );
			         lb.setMetas( rs.getLong("metas") );
			         lb.setVentas13(v1);
			         lb.setVentas15(v2);
			         lb.setVentas18(v3);
	                 lb.setVentas23(v4);
	                 table.setFechaC(rs.getString("dia_comp").substring(0, 10));
			         
		            if((sdf0.parse("15:00").getTime() < sdf0.parse(sdf0.format(hoy)).getTime()) 
            				&& sdf0.parse(sdf0.format(hoy)).getTime() < (sdf0.parse("18:00").getTime() )  && flag){
            		
			        	ventas.add(lb);
            			
            		}
			        
				}else if(rs.getString("HORVEN").equalsIgnoreCase("18:00")){
					
					v3 = rs.getLong("venta");
					lb = new LocalBean();
		            lb.setLocal( rs.getString("local") );
		            lb.setMetas( rs.getLong("metas") );
		            lb.setVentas13(v1);
		            lb.setVentas15(v2);
		            lb.setVentas18(v3);
                    lb.setVentas23(v4);
        			
                    table.setFechaC(rs.getString("dia_comp").substring(0, 10));
		            
		            if((sdf0.parse("18:00").getTime() < sdf0.parse(sdf0.format(hoy)).getTime()) && 
		            		(sdf0.parse(sdf0.format(hoy)).getTime() < sdf0.parse("23:00").getTime()) && flag)
		            {
            			ventas.add(lb);
            			//////System.out.println("ventas:" + ventas.size());
            		}
				}else if(rs.getString("HORVEN").equalsIgnoreCase("23:00")){ // Corresponde al Cierre de Ventas
					
					v4 = rs.getLong("venta");
					
					lb = new LocalBean();
		            lb.setLocal( rs.getString("local") );
		            lb.setMetas( rs.getLong("metas") );
		            lb.setVentas13(v1);
		            lb.setVentas15(v2);
		            lb.setVentas18(v3);
                    lb.setVentas23(v4);
                    table.setFechaC(rs.getString("dia_comp").substring(0, 10));
		            ventas.add(lb);
				}
				/*************************/
			}
			if(ventas != null)
			ubibean.setVentas(ventas);
			lubibean.add(ubibean);
			
			/******************************************************/
			
			table.setPos(lubibean);
			//////System.out.println("Lista de Posiciones o ubicaciones:"+table.getPos().size());
			
//			for (Iterator iterator = table.getPos().iterator(); iterator.hasNext();) {
//				PosicionBean pos = (PosicionBean) iterator.next();
//				//////System.out.println("Posicion:"+pos.getPosicion());
//				//////System.out.println("Posicion:"+pos.getVentas().size());
//				
//			}
	       /******************************************************/
  
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
	
	/***
	 * Lista de las ventas por Hora Detalle
	 */
	public void loadVentasHora(TableHourLocalBean table) throws SQLException {
		// TODO Auto-generated method stub
		//
		
		Connection con = dataSource.getConnection(); 
				//ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		Connection con2 = dataSource.getConnection();
		ResultSet rs2 = null;
		PreparedStatement pst2 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String sql_venta_hour = "select dia,dia_comp,sum(metas) as metas,sum(venta) AS ventas, COALESCE(sum(venta),0) / COALESCE(sum(metas),0) as avance,horven from FACT_VENTA_HORA where dia = to_date(?,'yyyy-mm-dd') and HORVEN in ('13:00','15:00','18:00','23:00') " +
				"group by dia,dia_comp,horven order by horven asc";
		String sql_local = "select dia,dia_comp,local,metas,sum(venta) AS ventas, horven from FACT_VENTA_HORA where dia = to_date(?,'yyyy-mm-dd') and HORVEN = ? and local <> 'EDIFICIO PUENTE' group by dia,dia_comp,local,metas,horven";
		
		try {

			VentasHoraBean vhb=null;
			table.getVentashora().clear();

			if(table.getDfecha()==null)
			{
			  table.setDfecha(new Date());
			}
			
			String sf = sdf.format(table.getDfecha());
			
			pst = con.prepareStatement(sql_venta_hour);
			pst.setString(1, sf);
			rs = pst.executeQuery();
			
	  
			while (rs.next()) { // ciclo de locales
			
				vhb = new VentasHoraBean(rs.getString("dia"),rs.getString("dia_comp"),rs.getString("horven"),rs.getLong("metas"),rs.getLong("ventas"),rs.getDouble("avance"));
			    pst2 = con2.prepareStatement(sql_local);
			    pst2.setString(1, sdf.format(sdf.parse(vhb.getFecha())));
			    pst2.setString(2, vhb.getHora());
			    
			    ////System.out.println("Fecha: " + vhb.getFecha() + " Hora:"+ vhb.getHora());
			    
			    rs2 = pst2.executeQuery();			    
			    List<LocalBean> lab = new ArrayList<LocalBean>();
			    LocalBean lb =  new LocalBean();

			    while (rs2.next()) { // ciclo de hora

			    	double avance = 1;
			    	if(rs.getLong("metas")>0){
			    		
			    		avance = Double.parseDouble(""+rs2.getLong("ventas")) / Double.parseDouble(""+rs2.getLong("metas"));
			    		
			    		////System.out.println( rs2.getString("local") + " " + rs2.getLong("metas") + " " + rs2.getLong("ventas") + " " + avance);	
			    		
			    	}	
			    	
			    		lb = new LocalBean(
			    			rs2.getString("dia"),
			    			rs2.getString("dia_comp"),
			    			rs2.getString("local"),
			    			rs2.getLong("metas"),
			    			rs2.getLong("ventas"),
			    			avance
			    			);
			    	lab.add(lb);
			    }    
			    vhb.setLocales(lab);   
			    vhb.setModelLocal(new LocalDataModel(lab));
			    
			    table.setFecha(rs.getString("dia"));
				table.setFechaC(rs.getString("dia_comp"));
				vhb.setFecha("dia");
				vhb.setFechaC("dia_comp");
				
				// se agrega una venta hora bean con todos los locales respectivos
				table.getVentashora().add(vhb);
			
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
		
		//////System.out.println("VentasHora size " + table.getVentashora().size());
		
	}
	
	
	
	
	
	
	/***
	 * Lista de Descuentos: 
	 * Nivel 1: lista de locales, con suma general
	 * Nivel 2: lista de vendedores dado un local, agrupado por vendedor 
	 * Nivel 2: lista de supervisores dado un local, agrupado por supervisor
	 */
	public void loadRankingSupervisor(TableDsctoSuperBean table) throws SQLException {
		// TODO Auto-generated method stub
		//
		
		Connection con = dataSource.getConnection();
		    //ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		Connection con2 = dataSource.getConnection();
		//ManagerConnection.getInstance().getConnectionP();
		ResultSet rs2 = null;
		PreparedStatement pst2 = null;
		
		Connection con3 = dataSource.getConnection();
		//ManagerConnection.getInstance().getConnectionP();
		ResultSet rs3 = null;
		PreparedStatement pst3 = null;
		
		Connection con4 = dataSource.getConnection();
		   //ManagerConnection.getInstance().getConnectionP();
		ResultSet rs4 = null;
		PreparedStatement pst4 = null;
		
		if(table.getFecha()==null)
		{
		  String sf = sdf.format(new Date());
		  table.setFecha(sf);
		}
		
		/**
		 * Corresponde a la lista de los descuentos otorgados por Local.
		 */
		
		String sql_nivel_1 = "" +
		"select fecha "+
		", codigo_local,tienda "+
		", sum(monto+monto_dscto_total) as monto_base " + 
		", sum(monto) monto_neto "+
		", sum(monto_dscto_total) as Dscto "+
		", (sum(monto_dscto_total)/(nvl2(sum(monto+monto_dscto_total),sum(monto + 0.01 + monto_dscto_total),1)))*100 as PORC "+
		"from fact_venta_diaria2 "+
		"where tipo_ttr = 50 "+ 
		"and fecha >= to_date(add_months(sysdate,-1)) " +
		"and monto_dscto_total > 0 "+
		"and cod_supervisor > 0 "+
		"and monto_dscto_total <= monto "+
		"group by fecha, "+
		"codigo_local, "+
		"tienda "+
		"order by (sum(monto_dscto_total)/(nvl2(sum(monto),sum(monto + 0.01),1)))*100 desc ";
		
		
		String sql_nivel_2_supervisor= "" +
				"select " + 
				"fecha , " +  
				"tienda , " +
				"cod_supervisor, " +
				"supervisor, " +  
				"sum(monto+monto_dscto_total) as monto_base, " +  
				"sum(monto) monto_neto ,  " +  
				"sum(monto_dscto_total) as Dscto , " +  
				"(sum(monto_dscto_total)/(nvl2(sum(monto+monto_dscto_total), " +  
				"sum(monto + 0.01 + monto_dscto_total),1)))*100 as PORC  " +  
				" from fact_venta_diaria2 where tipo_ttr = 50  " +  
				"and monto_dscto_total > 0 and cod_supervisor > 0  " +  
				"and monto_dscto_total <= monto  " +  
				"and codigo_local = ? " +
				"and fecha >= to_date(add_months(sysdate,-1)) " +
				"group by fecha, tienda,  cod_supervisor, supervisor " +  
				"order by (sum(monto_dscto_total)/(nvl2(sum(monto),sum(monto + 0.01),1)))*100 desc ";
		
		String sql_nivel_3_boletas= "" +
				"select " + 
				"  caja " + 
				", num_boleta " + 
				", area " + 
				", departamento " +
				", fecha " +
				", hhmm " +
				", sum(monto+monto_dscto_total) as monto_base " + 
				", sum(monto) monto_neto " + 
				", sum(monto_dscto_total) as Dscto " + 
				", (sum(monto_dscto_total)/(nvl2(sum(monto+monto_dscto_total),sum(monto + 0.01+monto_dscto_total),1)))*100 as PORC " + 
				" from fact_venta_diaria2 " + 
				"where tipo_ttr = 50  " + 
				"and codigo_local = ? and cod_supervisor = ? " + 
				"and monto_dscto_total > 0 " + 
				"and cod_supervisor > 0 "+
				"and fecha >= to_date(add_months(sysdate,-1)) " +
				"group by caja, num_boleta, area, departamento ,fecha, hhmm " +  
				"order by (sum(monto_dscto_total)/(nvl2(sum(monto),sum(monto + 0.01),1)))*100 desc ";
		
		String sql_nivel_4_detalle_boletas= "" +
				"select fecha " + 
				", case when tipo_ttr = 50 then 'VENTA'  " + 
				"       when tipo_ttr = 70 then 'NOTA DE CREDITO' " + 
				"           end as Transaccion " + 
				", case when tipo_fin = 1 then 'CONTADO' " + 
				"       when tipo_fin = 2 then 'CREDITO' " + 
				"            end as Financiamiento " + 
				", hora " + 
				", seccion " + 
				", familia " + 
				", articulo " + 
				", glosa_producto " + 
				", monto as Precio " + 
				", cantidad " + 
				", supervisor " + 
				", codigo_local " + 
				"from fact_venta_diaria2 " + 
				"where fecha >= to_date(add_months(sysdate,-1)) " +
				"and fecha = ?  " + //40
				"and codigo_local = ?  " + //40
				"and caja = ?  " + //41
				"and num_boleta = ? ";//9049
		
		try {

			DsctoBean dscto=null;
			//table.getDescuentos2().clear();
			//////System.out.println(sql_nivel_1);
           Date d2 = new Date();
			
			pst = con.prepareStatement(sql_nivel_1);
			rs = pst.executeQuery();
			
	  
			while (rs.next()) {// ciclo de locales
				
					dscto = new DsctoBean(sdf3.format(rs.getDate("fecha")),
									rs.getLong("codigo_local"),
									rs.getString("tienda"),
									"",
									rs.getLong("monto_base"),
									rs.getLong("monto_neto"),
									rs.getLong("Dscto"),
									rs.getDouble("PORC")/100);

				/* 
				 * Lista de Supervisores
				 */
				pst2 = con2.prepareStatement(sql_nivel_2_supervisor);
				pst2.setLong(1, dscto.getCodigoTienda());
				rs2 = pst2.executeQuery();
				List<SalesBean> lsales = new ArrayList<SalesBean>();
				while (rs2.next())
				{
			
					SalesBean sales = new SalesBean(
							rs2.getLong("cod_supervisor"),
							sdf3.format(rs2.getDate("fecha")),
							rs2.getString("tienda"),
							rs2.getString("supervisor"),
							rs2.getLong("monto_base"),
							rs2.getLong("monto_neto"),
							rs2.getLong("Dscto"),
							rs2.getDouble("PORC")/100);
				
					//////System.out.println("id_sales:"+sales.getId_sales()); 
					//////System.out.println("PORC:"+sales.getPor_dscto()); 
					
					// obtencion de boletas del vendedor
					pst3 = con3.prepareStatement(sql_nivel_3_boletas);
					pst3.setLong(1, dscto.getCodigoTienda());
					pst3.setLong(2, sales.getId_sales());
					rs3 = pst3.executeQuery();
					List<BoletaBean> boletas = new ArrayList<BoletaBean>();
					int i =0;
//					//System.out.println("tienda:"+sales.getTienda()); 
//					//System.out.println("cod_supervisor:"+sales.getId_sales()); 
					while(rs3.next() && i < 25){
						
//								//System.out.println("Hay Boleta"); 
						
					
						
								BoletaBean bol = new BoletaBean(
								sdf3.format(rs3.getDate("FECHA")), 
								rs3.getString("HHMM"),
								rs3.getInt("CAJA"), 
								rs3.getInt("NUM_BOLETA"), 
								rs3.getString("AREA"), 
								rs3.getString("DEPARTAMENTO"),
								rs3.getLong("MONTO_BASE"),
								rs3.getLong("MONTO_NETO"), 
								rs3.getLong("DSCTO"), 
								rs3.getDouble("PORC")/100
								);
								// obtencion del listado de items de la boleta
								pst4 = con4.prepareStatement(sql_nivel_4_detalle_boletas);
								pst4.setDate(1, rs3.getDate("FECHA"));
								pst4.setLong(2, dscto.getCodigoTienda());
								pst4.setInt(3, bol.getCaja());
								pst4.setInt(4, bol.getNumBoleta());
								rs4 = pst4.executeQuery();
								int x=0;
								while(rs4 != null && rs4.next() && x < 25){
									//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Entro Cuarto Nivel");
									ItemBoletaBean item = new ItemBoletaBean(
											sdf3.format(rs4.getDate("FECHA")),  
											rs4.getString("hora"), 
											rs4.getString("seccion"), 
											rs4.getString("familia"), 
											rs4.getString("articulo"), 
											rs4.getString("glosa_producto"), 
											rs4.getLong("precio"),
											rs4.getLong("cantidad"),
											rs4.getString("supervisor"), 
											rs4.getString("codigo_local"),
											sales.getTienda()
											);
									bol.setTrx(rs4.getString("Transaccion"));
									bol.setFin(rs4.getString("Financiamiento"));
									bol.getItems().add(item);
									x++;
								}
								rs4.close();
								pst4.close();
								
								boletas.add(bol);
								//////System.out.println("Boleta:"+bol.getNumBoleta());
								
								
								
					i++;
					}
					rs3.close();
					pst3.close();
					sales.setBoletas(boletas);
					sales.setModelBoleta(new BoletaDataModel(boletas));
					
					
					
					lsales.add(sales);
				}
				
				dscto.setSaless(lsales);
				dscto.setModelSales(new SalesDataModel(lsales));
				
				table.getDescuentos().add(dscto);
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

		//////System.out.println("Descuentos size " + table.getDescuentos().size());
		
	}
	
	
	
	/***
	 * Lista de Descuentos de Garantia Extendidas a los seguros: 
	 * Nivel 1: lista de departamentos, con suma general
	 * Nivel 2: lista de Locales dado un departamento, agrupado por Local 
	 * Nivel 3: lista de supervisores / vendedores dado un local, agrupado por supervisor
	 * Nivel 4: lista de boletas dado un supervisor / vendedor, agrupado por boleta
	 * Nivel 5: lista de articulos dado un boleta / vendedor, agrupado por articulos
	 */
	public void loadGarantiaExtendida(TableDsctoGarantiaDeptoBean table) throws SQLException {
		
		Connection con = dataSource.getConnection();
		   //ManagerConnection.getInstance().getConnectionP();
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		Connection con2 = dataSource.getConnection();
		    //ManagerConnection.getInstance().getConnectionP();
		ResultSet rs2 = null;
		PreparedStatement pst2 = null;
		
		Connection con3 = dataSource.getConnection();
		     //ManagerConnection.getInstance().getConnectionP();
		ResultSet rs3 = null;
		PreparedStatement pst3 = null;
		
		Connection con4 = dataSource.getConnection();
		   //ManagerConnection.getInstance().getConnectionP();
		ResultSet rs4 = null;
		PreparedStatement pst4 = null;
		


		
		if(table.getFecha()==null)
		{
		  String sf = sdf.format(new Date());
		  table.setFecha(sf);
		}
		
		/**
		 * Corresponde a la lista de los departamentos otorgados por el area de seguros.
		 * Area 14: Corresponde al Area de Seguros
		 */
		// date por entrada
		String sql_nivel_1_depto = "" +
				" select fecha " + 
				" , dep_cod " +
				" , departamento " + 
				" , sum(cantidad) as Unidades  " + 
				" , sum(cant_boletas) as Cant_Boleta  " + 
				" , ( sum(round(monto)) + sum(round(monto_dscto_total))) as total_base  " + 
				" , sum(round(monto)) as venta_neta  " + 
				" , sum(round(monto_dscto_total)) as Descto_tot  " + 
				" from fact_venta_diaria2  " + 
				" where to_char(fecha,'yyyy-mm-dd')=? and are_cod = 14 and dep_cod <> 75 and cod_vendedor <> 0 and cod_supervisor <> 0 and monto_dscto_total <> 0  " + 
				" group by fecha,dep_cod, departamento  "; 

		
		
		String sql_nivel_2_local= "" +
				" select fecha  " + 
				" , codigo_local as Cod_Local " + 
				" , tienda " + 
				" , departamento " + 
				" , sum(cantidad) as Unidades " + 
				" , sum(cant_boletas) as Cant_Boleta " + 
				" , ( sum(round(monto)) + sum(round(monto_dscto_total))) as total_base " + 
				" , sum(round(monto)) as venta_neta " + 
				" , sum(round(monto_dscto_total)) as Descto_tot " + 
				" from fact_venta_diaria2 " + 
				" where to_char(fecha,'yyyy-mm-dd')=? and dep_cod = ? and are_cod = 14  and cod_vendedor <> 0 and cod_supervisor <> 0 and monto_dscto_total <> 0 " + 
				" group by fecha, codigo_local, tienda, departamento, dep_cod";
		
		String sql_nivel_3_vendedor= "" +
				" select fecha  " +
				" , hora,cod_vendedor  " +
				" , vendedor  " +
				" , sum(cantidad) as Unidades  " +
				" , sum(cant_boletas) as Cant_Boleta  " +
				" , ( sum(round(monto)) + sum(round(monto_dscto_total))) as total_base  " +
				" , sum(round(monto)) as venta_neta  " +
				" , sum(round(monto_dscto_total)) as Descto_tot  " +
				" from fact_venta_diaria2  " +
				" where to_char(fecha,'yyyy-mm-dd')=? and dep_cod = ?  and codigo_local = ? and are_cod = 14 and cod_vendedor <> 0 and cod_supervisor <> 0 and monto_dscto_total <> 0  " +
				" group by fecha, hora, cod_vendedor, vendedor  ";

		
		String sql_nivel_4_boleta= "" +
				" select fecha  " +
				" ,articulo "+
				" ,glosa_producto " +
				" , case when tipo_ttr = 50  " +
				"               then 'Venta'  " +
				"         when tipo_ttr = 70  " +
				"               then 'Nota de Credito'  " +
				"               End as Transaccion  " +
				" , num_boleta  " +
				" , caja  " +
				" , hora  " +
				" , cant_boletas as Cant_Boleta  " +
				" , monto + monto_dscto_total as total_base  " +
				" , monto as venta_neta  " +
				" ,  monto_dscto_total  as Descto_tot  " +
				" from fact_venta_diaria2  " +
				" where to_char(fecha,'yyyy-mm-dd')= ? and dep_cod = ? and codigo_local = ? and cod_vendedor = ? and are_cod = 14 and cod_vendedor <> 0 and cod_supervisor <> 0 and monto_dscto_total <> 0  ";
				//" group by fecha, tipo_ttr, num_boleta, caja  ";

		
//		String sql_nivel_5_articulo= "" +
//				" select fecha " +
//				" , articulo " +
//				" , glosa_producto " +
//				" , (monto + monto_dscto_total) as total_base " +
//				" , ( monto ) as venta_neta " +
//				" , round(monto_dscto_total) as Descto_tot " +
//				" from fact_venta_diaria2 " +
//				" where to_char(fecha,'yyyy-mm-dd')= ? and dep_cod = ? and codigo_local = ? and cod_vendedor = ? and num_boleta= ? and caja= ?  and are_cod = 14"; 
//		
//		
		
		try {

			pst = con.prepareStatement(sql_nivel_1_depto);
			pst.setString(1, sdf.format(new Date()));
			rs = pst.executeQuery();
			
	  
			while (rs.next()) {// Lista de Departamentos
					DsctoGarantiaDeptoBean dsctobean = new DsctoGarantiaDeptoBean(
							        sdf3.format(rs.getDate("fecha")),
							        rs.getInt("dep_cod"),
									rs.getString("departamento"),
									rs.getLong("Unidades"),
									rs.getDouble("Cant_Boleta"),
									rs.getLong("total_base"),
									rs.getLong("venta_neta"),
									rs.getLong("Descto_tot"));

					
					
				/* 
				 * Lista de Locales
				 */
					//System.out.println(sql_nivel_2_local);
					//System.out.println("depto:"+dsctobean.getDep_cod());
					
				pst2 = con2.prepareStatement(sql_nivel_2_local);
				pst2.setString(1, sdf.format(new Date()));
				pst2.setInt(2, dsctobean.getDep_cod());
				rs2 = pst2.executeQuery();
				
				while (rs2.next())
				{
					LocalGarantiaBean localbean = new LocalGarantiaBean(
							    sdf3.format(rs.getDate("fecha")),
							    rs2.getInt("Cod_Local"),
								rs2.getString("tienda"),
								rs2.getString("departamento"),
								rs2.getLong("Unidades"),
								rs2.getDouble("Cant_Boleta"),
								rs2.getLong("total_base"),
								rs2.getLong("venta_neta"),
								rs2.getLong("Descto_tot"));
					
					//System.out.println(":::::::::::::::::::::::::" + localbean.getId_local());
					
					dsctobean.getLocales().add(localbean);
					
					//System.out.println(sql_nivel_3_vendedor);
//					System.out.println("dep cod:"+dsctobean.getDep_cod());
//					System.out.println("local:"+localbean.getId_local());
					
					pst3 = con3.prepareStatement(sql_nivel_3_vendedor);
					pst3.setString(1, sdf.format(new Date()));
					pst3.setInt(2, dsctobean.getDep_cod());
					pst3.setInt(3, localbean.getId_local());
					rs3 = pst3.executeQuery();
					
					int i =0;

					while(rs3.next() && i < 25){
//					System.out.println("VENDEDORES ENTRO");
						VendedorGarantiaBean vendedorBean = new VendedorGarantiaBean(
										 sdf3.format(rs.getDate("fecha")),
										 	rs3.getString("hora"),
										    rs3.getInt("cod_vendedor"),
											rs3.getString("vendedor"),
											rs3.getLong("Unidades"),
											rs3.getDouble("Cant_Boleta"),
											rs3.getLong("total_base"),
											rs3.getLong("venta_neta"),
											rs3.getLong("Descto_tot"));
								
								
								// obtencion del listado de items de la boleta
						
//								System.out.println(sql_nivel_4_boleta);
//								System.out.println("dep:"+dsctobean.getDep_cod());
//								System.out.println("local:"+localbean.getId_local());
//								System.out.println("vendedor:"+vendedorBean.getId_vendedor());
								pst4 = con4.prepareStatement(sql_nivel_4_boleta);
								pst4.setString(1, sdf.format(new Date()));
								pst4.setInt(2, dsctobean.getDep_cod());
								pst4.setInt(3, localbean.getId_local());
								pst4.setInt(4, vendedorBean.getId_vendedor());
								rs4 = pst4.executeQuery();
								int x=0;
								while(rs4 != null && rs4.next() && x < 25){
									
									
									
//									System.out.println("BOLETA ENTRO");
									
									BoletaGarantiaBean boletaBean = new BoletaGarantiaBean(
												sdf3.format(rs.getDate("fecha")),
												rs4.getInt("articulo"),
												rs4.getString("glosa_producto"),
											    rs4.getInt("num_boleta"),
											    rs4.getString("Transaccion"),
											    rs4.getInt("caja"),
											    rs4.getInt("hora"),
												rs4.getDouble("Cant_Boleta"),
												rs4.getLong("total_base"),
												rs4.getLong("venta_neta"),
												rs4.getLong("Descto_tot"));
									
									
									
									vendedorBean.getBoletas().add(boletaBean);
									
//									pst5 = con5.prepareStatement( sql_nivel_5_articulo );
//									pst5.setString(1, sdf.format(new Date()));
//									pst5.setInt(2, dsctobean.getDep_cod());
//									pst5.setInt(3, localbean.getId_local());
//									pst5.setInt(4, vendedorBean.getId_vendedor());
//									pst5.setInt(5, boletaBean.getId_boleta());
//									pst5.setInt(6, boletaBean.getCaja());
//									
//									rs5 = pst5.executeQuery();
//									while(rs5 != null && rs5.next() && x < 25){
//										// se completa los datos del articulos
//								
//										ArticuloGarantiaBean articuloBean = new ArticuloGarantiaBean(
//												sdf3.format(rs.getDate("fecha")),
//											    rs5.getInt("articulo"),
//											    rs5.getString("glosa_producto"),
//											    rs5.getLong("total_base"),
//												rs5.getLong("venta_neta"),
//												rs5.getLong("Descto_tot"));
//										
//										boletaBean.getArticulos().add(articuloBean);
//										
//										
//									}
//									boletaBean.setModelArticulos(new ArticulosGarantiaDataModel(boletaBean.getArticulos()));
									
									
									
									x++;
								}
								vendedorBean.setModelBoleta(new BoletaGarantiaDataModel(vendedorBean.getBoletas()));
								
								localbean.getVendedores().add(vendedorBean);	
					i++;
					}
					localbean.setModelVendedor(new VendedorGarantiaDataModel(localbean.getVendedores()));
					
				
				}
				
//				System.out.println("Locales: " + dsctobean.getLocales());
				dsctobean.setModelLocales(new LocalGarantiaDataModel(dsctobean.getLocales()));
				
				table.getDescuentos().add(dsctobean);
				
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			
			try{
				rs.close();
				rs2.close();
				rs3.close();
				rs4.close();
				
				
			}catch(Exception e){}	
			try{
			pst.close();
			pst2.close();
			pst3.close();
			pst4.close();
			
			}catch(Exception e){}
			try{
			con.close();
			con2.close();
			con3.close();
			con4.close();
			
			}catch(Exception e){}
		} 

		log.debug("Descuentos Garantia size " + table.getDescuentos().size());
		
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
	
	@Override
	public void loadMedidor(MeterGaugeChart chart) throws SQLException {
		// TODO Auto-generated method stub
		//
		
		////////System.out.println("...loadMedidor");
		Connection con = dataSource.getConnection();
		 // ManagerConnection.getInstance().getConnectionP();
		////////System.out.println("...loadMedidor2");
		ResultSet rs = null;
		////////System.out.println("...loadMedidor3");
		PreparedStatement pst = null;
		////////System.out.println("...loadMedidor4");
		////////System.out.println("---------------------------------------- loadMedidor");
		try {
			
			////////System.out.println("...loadMedidor5");
			pst = con.prepareStatement("select sum(metas),sum(ventas) FROM ventasact1 where  ventas <> 0 ");
			////////System.out.println("...loadMedidor6");
			rs = pst.executeQuery();
			////////System.out.println("...loadMedidor7");
			List<Number> intervalos = new ArrayList<Number>();
			////////System.out.println("...loadMedidor8");
			long metaOriginal=0;
			long venta=0;
			long meta=0;
			if (rs.next()) {
			   
				try{
					////////System.out.println("...loadMedidor9");
					intervalos.add(new Long(rs.getLong(1)));
			    	
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			   
				meta+=rs.getLong(1);   	
			   	venta+=rs.getLong(2);
			}
			////////System.out.println(".............................................................."+venta);
			////////System.out.println(".............................................................."+meta);
			chart.getModel().setLabel("Avance");
			if(venta>meta){
				metaOriginal = meta;
				intervalos.clear();
				intervalos.add(new Long(venta)*0.3);
				intervalos.add(new Long(venta)*0.6);
				intervalos.add(new Long(venta)*0.9);
				intervalos.add(new Long(venta));
			}
			////////System.out.println(".............................................................."+1);
			chart.getModel().setValue(new Long(venta));
			////////System.out.println(".............................................................."+chart.getModel().getValue());
			chart.getModel().setIntervals(intervalos);
			////////System.out.println(".............................................................."+chart.getModel().getIntervals());
//			chart.getModel().setVentaGeneralGauge(venta);
			////////System.out.println(".............................................................."+chart.getModel());
  
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			rs.close();
			pst.close();

		}
		//////////System.out.println("Fin loadMedidor");
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