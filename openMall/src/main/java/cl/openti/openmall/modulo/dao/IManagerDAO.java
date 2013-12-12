package cl.openti.openmall.modulo.dao;

import java.sql.SQLException;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.PieChartModel;

import cl.openti.openmall.modulo.model.bean.MeterGaugeChart;
import cl.openti.openmall.modulo.model.bean.TableBean;
import cl.openti.openmall.modulo.model.bean.TableCDABean;
import cl.openti.openmall.modulo.model.bean.TableDsctoGarantiaDeptoBean;
import cl.openti.openmall.modulo.model.bean.TableDsctoSuperBean;
import cl.openti.openmall.modulo.model.bean.TableHourBean;
import cl.openti.openmall.modulo.model.bean.TableHourLocalBean;
import cl.openti.openmall.modulo.model.bean.UserBean;
import cl.openti.openmall.modulo.model.bean.ZonaBean;

public interface IManagerDAO {

	void loadUser(UserBean user) throws SQLException;
	/**
	 * Para la carga de las estadisticas
	 * @throws SQLException
	 */
	void loadArchivos(TableCDABean table) throws SQLException;
	
	void loadModulos(UserBean user) throws SQLException;
	
	void loadMetas(TableBean table) throws SQLException;
	
	void loadVentas(TableBean table) throws SQLException;
	
	void loadVentas(TableHourBean table) throws SQLException;
	
	void loadVentasCDA(TableCDABean table) throws SQLException;
	
	void loadVentasHora(TableHourLocalBean table) throws SQLException;
	
	void loadRankingSupervisor(TableDsctoSuperBean table) throws SQLException;
	
	void loadGarantiaExtendida(TableDsctoGarantiaDeptoBean table) throws SQLException;
	
	void loadMedidor(MeterGaugeChart model) throws SQLException;
	
	void loadPie(PieChartModel  meter) throws SQLException;

	void loadBarra(CartesianChartModel category) throws SQLException;
	
	void loadMap(ZonaBean bean,int cod) throws SQLException;
	
}
