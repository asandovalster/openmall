package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 
 * Entity Bean de Centro de Datos Estadisticos
 * @author ASandovalS
 *
 */

public class CDABean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	static final Logger log = Logger.getLogger(CDABean.class);
	
	
	private Date feccar;
	private String archivo;
	private long treg;
	private long tregp;
	private long diff;
	private String sfeccar;
	
	
	public CDABean(Date feccar, String archivo, long treg, long tregp, long diff) {
		super();
		this.feccar = feccar;
		this.archivo = archivo;
		this.treg = treg;
		this.tregp = tregp;
		this.diff = diff;
	}

	public CDABean(Date feccar, String sfeccar, String archivo, long treg,
			long tregp, long diff) {
		super();
		this.feccar = feccar;
		this.sfeccar = sfeccar;
		this.archivo = archivo;
		this.treg = treg;
		this.tregp = tregp;
		this.diff = diff;
	}





	public CDABean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Date getFeccar() {
		return feccar;
	}



	public void setFeccar(Date feccar) {
		this.feccar = feccar;
	}



	public String getArchivo() {
		return archivo;
	}



	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}



	public long getTreg() {
		return treg;
	}



	public void setTreg(long treg) {
		this.treg = treg;
	}



	public long getTregp() {
		return tregp;
	}



	public void setTregp(long tregp) {
		this.tregp = tregp;
	}



	public long getDiff() {
		return diff;
	}



	public void setDiff(long diff) {
		this.diff = diff;
	}



	public String getSfeccar() {
		
		return sfeccar;
	}



	public void setSfeccar(String sfeccar) {
		this.sfeccar = sfeccar;
	}
	
	
	public void toPrint() {
	// TODO Auto-generated method stub
	
		log.debug("Valores");
		log.debug("Fecha:" + feccar);
		log.debug("Reg Iseries:" + treg);
		log.debug("Reg Pentaho:" + tregp);
		log.debug("Diferencia:" + diff);
		log.debug("sfeccar:"+sfeccar);


	 
	}	
	
}