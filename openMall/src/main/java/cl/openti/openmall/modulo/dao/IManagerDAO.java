package cl.openti.openmall.modulo.dao;

import java.sql.SQLException;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.PieChartModel;

import cl.openti.openmall.modulo.model.bean.DatosUsuarioBean;
import cl.openti.openmall.modulo.model.bean.UserBean;
import cl.openti.openmall.modulo.model.bean.ZonaBean;

public interface IManagerDAO {

	void loadUser(UserBean user) throws SQLException;
	/**
	 * Para la carga de las estadisticas
	 * @throws SQLException
	 */
	
	void loadModulos(UserBean user) throws SQLException;
	
	void loadPie(PieChartModel  meter) throws SQLException;

	void loadBarra(CartesianChartModel category) throws SQLException;
	
	void loadMap(ZonaBean bean,int cod) throws SQLException;
	
	void registerUsuario(DatosUsuarioBean datos) throws SQLException;
	
}
