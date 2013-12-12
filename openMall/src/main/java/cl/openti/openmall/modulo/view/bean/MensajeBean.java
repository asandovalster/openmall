package cl.openti.openmall.modulo.view.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensajeBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1357011015846823383L;

	public static void showErrorMessage(String errorString) {
	    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorString, "");
	    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	
	
}
