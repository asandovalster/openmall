package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;  
import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;  
import org.primefaces.event.map.OverlaySelectEvent;  
import org.primefaces.model.map.DefaultMapModel;  
import org.primefaces.model.map.LatLng;  
import org.primefaces.model.map.MapModel;  
import org.primefaces.model.map.Marker;  
  

@ManagedBean(name = "mapBean")
@SessionScoped
public class MapHitesBean implements Serializable {  
  
    private MapModel simpleModel;  
  
    private Marker marker;  
  
    public MapHitesBean() {  
        simpleModel = new DefaultMapModel();  
          
        //Shared coordinates  
        LatLng coord1 = new LatLng(-33.4350813,-70.6515767);  
        LatLng coord2 = new LatLng(-33.435727,-70.6514848);  
        LatLng coord3 = new LatLng(-33.438608,-70.651099);  
        LatLng coord4 = new LatLng(-33.44275927257664,-70.64679980278015);  
          
        //Basic marker  
        simpleModel.addOverlay(new Marker(coord1, "EDIF.PUENTE"));  
        simpleModel.addOverlay(new Marker(coord2, "PUENTE"));  
        simpleModel.addOverlay(new Marker(coord3, "PLAZA DE ARMAS"));  
        simpleModel.addOverlay(new Marker(coord4, "ALAMEDA 757"));  
    }  
      
    public MapModel getSimpleModel() {  
        return simpleModel;  
    }  
      
    public void onMarkerSelect(OverlaySelectEvent event) {  
        marker = (Marker) event.getOverlay();  
          
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Tienda Seleccionada", marker.getTitle()));  
    }  
      
    public Marker getMarker() {  
        return marker;  
    }  
      
    public void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}  
