package cl.openti.openmall.modulo.model.bean;

import java.util.List;

public class MenuBean {

	 private int id;
	 private String descripcion;
	 private String viewId;
	 private String icono;
	 private MenuBean menu;
	 private List<MenuBean> listaMenu;
	public MenuBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuBean(int id, String descripcion, String viewId, String icono,
			MenuBean menu, List<MenuBean> listaMenu) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.viewId = viewId;
		this.icono = icono;
		this.menu = menu;
		this.listaMenu = listaMenu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getViewId() {
		return viewId;
	}
	public void setViewId(String viewId) {
		this.viewId = viewId;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public MenuBean getMenu() {
		return menu;
	}
	public void setMenu(MenuBean menu) {
		this.menu = menu;
	}
	public List<MenuBean> getListaMenu() {
		return listaMenu;
	}
	public void setListaMenu(List<MenuBean> listaMenu) {
		this.listaMenu = listaMenu;
	}

	public void mostrar(){
		String s = "id: "+id;
		s += "\t" + "descripcion: " + descripcion;
		s += "\t" + "viewid: " + viewId;
		s += "\t" + "icono: " + icono;
		
		System.out.println(s);
		
		
	}
}
