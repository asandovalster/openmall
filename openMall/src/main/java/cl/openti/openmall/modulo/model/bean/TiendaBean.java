package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;

public class TiendaBean implements Serializable {

	
	
	 	String zona = "";
		String cod_local = "";
		String tienda = "";
		String direccion = "";
		String comuna = "";
		String ciudad = "";
		String pais = "";
		String latitud = "";
		String longitud = "";
		long vta_neta =0;
		long vta_Fin = 0;
		long cant_Boleta = 0;
		
		String svta_neta = "0";
		String svta_Fin = "0";
		String scant_Boleta = "0";

		
		public TiendaBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		public TiendaBean(String zona, String cod_local, String tienda,
				String direccion, String comuna, String ciudad, String pais,
				String latitud, String longitud, long vta_neta, long vta_Fin,
				long cant_Boleta) {
			super();
			this.zona = zona;
			this.cod_local = cod_local;
			this.tienda = tienda;
			this.direccion = direccion;
			this.comuna = comuna;
			this.ciudad = ciudad;
			this.pais = pais;
			this.latitud = latitud;
			this.longitud = longitud;
			this.vta_neta = vta_neta;
			this.vta_Fin = vta_Fin;
			this.cant_Boleta = cant_Boleta;
		}



		public String getZona() {
			return zona;
		}
		public void setZona(String zona) {
			this.zona = zona;
		}
		public String getCod_local() {
			return cod_local;
		}
		public void setCod_local(String cod_local) {
			this.cod_local = cod_local;
		}
		public String getTienda() {
			return tienda;
		}
		public void setTienda(String tienda) {
			this.tienda = tienda;
		}
		public long getVta_neta() {
			return vta_neta;
		}
		public void setVta_neta(long vta_neta) {
			this.vta_neta = vta_neta;
		}
		public long getVta_Fin() {
			return vta_Fin;
		}
		public void setVta_Fin(long vta_Fin) {
			this.vta_Fin = vta_Fin;
		}
		public long getCant_Boleta() {
			return cant_Boleta;
		}
		public void setCant_Boleta(long cant_Boleta) {
			this.cant_Boleta = cant_Boleta;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getComuna() {
			return comuna;
		}
		public void setComuna(String comuna) {
			this.comuna = comuna;
		}
		public String getCiudad() {
			return ciudad;
		}
		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}



		public String getLatitud() {
			return latitud;
		}



		public void setLatitud(String latitud) {
			this.latitud = latitud;
		}



		public String getLongitud() {
			return longitud;
		}



		public void setLongitud(String longitud) {
			this.longitud = longitud;
		}



		public String getSvta_neta() {
			
			long valor=getVta_neta();
			if((""+valor).length() >= 7){
				svta_neta = (""+valor).substring(0,(""+valor).length()-6)
						+"."+
						(""+valor).substring((""+valor).length()-6, (""+valor).length()-3)
						+"."+
						(""+valor).substring((""+valor).length()-3, (""+valor).length());
						;
			}else{
				if((""+valor).length() >= 4){
					svta_neta = (""+valor).substring(0,(""+valor).length()-3)
						+"."+
						(""+valor).substring((""+valor).length()-3, (""+valor).length());
				}	
			}
			
			
			return svta_neta;
		}



		public void setSvta_neta(String svta_neta) {
			this.svta_neta = svta_neta;
		}



		public String getSvta_Fin() {
			
			
			long valor=getVta_Fin();
			if((""+valor).length() >= 7){
				svta_Fin = (""+valor).substring(0,(""+valor).length()-6)
						+"."+
						(""+valor).substring((""+valor).length()-6, (""+valor).length()-3)
						+"."+
						(""+valor).substring((""+valor).length()-3, (""+valor).length());
						;
			}else{
				if((""+valor).length() >= 4){
					svta_Fin = (""+valor).substring(0,(""+valor).length()-3)
						+"."+
						(""+valor).substring((""+valor).length()-3, (""+valor).length());
				}	
			}
			return svta_Fin;
		}



		public void setSvta_Fin(String svta_Fin) {
			this.svta_Fin = svta_Fin;
		}



		public String getScant_Boleta() {
			return scant_Boleta;
		}



		public void setScant_Boleta(String scant_Boleta) {
			this.scant_Boleta = scant_Boleta;
		}
		
		
		
		
	
	
	
}
