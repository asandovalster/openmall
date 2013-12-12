package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AreaBean implements Serializable{

 private int id_area;
 private String area;
 private double monto=0;
 
 private List<DepartamentoBean> deptos = new ArrayList<DepartamentoBean>();
 
public AreaBean() {
	super();
	// TODO Auto-generated constructor stub
}



public AreaBean(int id_area) {
	super();
	this.id_area = id_area;
}



public AreaBean(String area, double monto) {
	super();
	this.area = area;
	this.monto = monto;
}

public AreaBean(int id_area, String area, double monto,
		List<DepartamentoBean> deptos) {
	super();
	this.id_area = id_area;
	this.area = area;
	this.monto = monto;
	this.deptos = deptos;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public double getMonto() {
	return monto;
}
public void setMonto(double monto) {
	this.monto = monto;
}
public List<DepartamentoBean> getDeptos() {
	return deptos;
}
public void setDeptos(List<DepartamentoBean> deptos) {
	this.deptos = deptos;
}
public int getId_area() {
	return id_area;
}
public void setId_area(int id_area) {
	this.id_area = id_area;
}
 
	
	
}
