package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;

public class DepartamentoBean implements Serializable {
/**
select departamento
, sum(monto) as monto_neto from fact_venta_diaria
where codigo_local = 56 (Ejemplo) and are_cod = 8 (Ejemplo)
group by departamento
order by sum(monto) desc;
 */
 private String departamento;
 private double monto=0;
 
public DepartamentoBean() {
	super();
	// TODO Auto-generated constructor stub
}

public DepartamentoBean(String departamento, double monto) {
	super();
	this.departamento = departamento;
	this.monto = monto;
}

public String getDepartamento() {
	return departamento;
}

public void setDepartamento(String departamento) {
	this.departamento = departamento;
}

public double getMonto() {
	return monto;
}

public void setMonto(double monto) {
	this.monto = monto;
}
	
	
}
