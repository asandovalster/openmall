package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.PerfilBean;


public class PerfilDataModel extends PrimeDataModel<PerfilBean> {

	
	 public PerfilDataModel() {  
	    }  
	  
	    public PerfilDataModel(Object data) {  
	        super(data);  
	    }  
	      
	    @Override  
	    public PerfilBean getRowData(String rowKey) {  
	          
	        List<PerfilBean> perfiles = (List<PerfilBean>) getWrappedData();  
	          
	        for(PerfilBean perfil : perfiles) {  
	            if(perfil.getIdperfil() ==Integer.parseInt(rowKey))  
	            {	
	                System.out.println("RowKey:"+rowKey);
	            	return perfil; 
	            }
	        }  
	          
	        return null;  
	    }  
	  
	    @Override  
	    public String getRowKey(PerfilBean perfil) {  
	        return perfil.getIdperfil()+"";  
	    }  
	
	
}
