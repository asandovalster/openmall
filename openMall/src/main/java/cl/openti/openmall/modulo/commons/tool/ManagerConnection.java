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

}
