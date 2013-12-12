package cl.openti.openmall.modulo.commons.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class ManagerConnection {

	private static ManagerConnection instance = null;
	static final Logger log = Logger.getLogger(ManagerConnection.class);
	Connection con = null;
	Connection con2 = null;
	
	private ManagerConnection() {
		// TODO Auto-generated constructor stub

		try {
			//Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static ManagerConnection getInstance() {

		if(instance==null ){
			instance = new ManagerConnection();

		}

		return instance;

	}

	public Connection getConnection() {

		
		try {
			log.debug(">>>3.1::: loadUser getConnection:" );
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "admin");
			log.debug(">>>3.1::: loadUser getConnection:" +con);
		
		} catch (SQLException e) {
			log.debug(">>>3.1::: loadUser getConnection error:");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public Connection getConnectionP() {

		
		try {
			if(con2==null || con2.isClosed())
				con2 = DriverManager.getConnection(
						"jdbc:mysql://68.169.50.24:3306/test", "root", "kR2CssK6");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con2;
	}

}
