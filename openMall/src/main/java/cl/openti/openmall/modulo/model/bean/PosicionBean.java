package cl.openti.openmall.modulo.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PosicionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String posicion; // Tiendas con Cumplimiento y din cumplimiento

	private List<LocalBean> ventas = new ArrayList<LocalBean>();

	private long metasTotal = 0;
	private long ventas13Total = 0;
	private long ventas15Total = 0;
	private long ventas18Total = 0;
	private long ventas23Total = 0;
	private double avanceTotal = 0;
	
	private String smetasTotal = "0"; 
	private String sventas13Total = "0";
	private String sventas15Total = "0";
	private String sventas18Total = "0";
	private String sventas23Total = "0";
	private String savanceTotal = "0";
	
	public PosicionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PosicionBean(int id, String posicion, List<LocalBean> ventas) {
		super();
		this.id = id;
		this.posicion = posicion;
		this.ventas = ventas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public List<LocalBean> getVentas() {
		return ventas;
	}

	public void setVentas(List<LocalBean> ventas) {
		this.ventas = ventas;
	}

	public long getMetasTotal() {
		metasTotal=0;
		for (Iterator iterator = getVentas().iterator(); iterator.hasNext();) {
			LocalBean bean = (LocalBean) iterator.next();
			metasTotal += bean.getMetas();
		}
		
		return metasTotal;
	}

	public void setMetasTotal(long metasTotal) {
		this.metasTotal = metasTotal;
	}

	public long getVentas13Total() {
		ventas13Total=0;
		for (Iterator iterator = getVentas().iterator(); iterator.hasNext();) {
			LocalBean bean = (LocalBean) iterator.next();
			ventas13Total += bean.getVentas13();
		}	
		
		return ventas13Total;
	}

	public void setVentas13Total(long ventas13Total) {
		this.ventas13Total = ventas13Total;
	}

	public long getVentas15Total() {
		
		ventas15Total=0;
		for (Iterator iterator = getVentas().iterator(); iterator.hasNext();) {
			LocalBean bean = (LocalBean) iterator.next();
			ventas15Total += bean.getVentas15();
		}	
		return ventas15Total;
	}

	public void setVentas15Total(long ventas15Total) {
		this.ventas15Total = ventas15Total;
	}

	public long getVentas18Total() {
		ventas18Total=0;
		for (Iterator iterator = getVentas().iterator(); iterator.hasNext();) {
			LocalBean bean = (LocalBean) iterator.next();
			ventas18Total += bean.getVentas18();
		}	
		
		return ventas18Total;
	}

	public void setVentas18Total(long ventas18Total) {
		this.ventas18Total = ventas18Total;
	}

	public long getVentas23Total() {
		ventas23Total=0;
		for (Iterator iterator = getVentas().iterator(); iterator.hasNext();) {
			LocalBean bean = (LocalBean) iterator.next();
			ventas23Total += bean.getVentas23();
		}	
		
		return ventas23Total;
	}

	public void setVentas23Total(long ventas23Total) {
		this.ventas23Total = ventas23Total;
	}

	public double getAvanceTotal() {
		
//		avanceTotal=0;
//		int count=0;
//		for (Iterator iterator = getVentas().iterator(); iterator.hasNext();) {
//			LocalBean bean = (LocalBean) iterator.next();
//			//if(bean.metas > 0)
//			avanceTotal += bean.getAvance();
//			
//		}	
//		
//		//avanceTotal=(avanceTotal/getSize()) * 100;
//		
//		avanceTotal=(avanceTotal/getVentas().size()) * 100;
//		System.out.println("avanceTotal:"+avanceTotal);
		
		long ventas = getVentas13Total();
		if(ventas > 0)
			avanceTotal=(Double.valueOf(ventas)/Double.valueOf(getMetasTotal())) * 100;
		
		 ventas = getVentas15Total();
		if(ventas > 0)
			avanceTotal=(Double.valueOf(ventas)/Double.valueOf(getMetasTotal())) * 100;
		
		ventas = getVentas18Total();
		if(ventas > 0)
			avanceTotal=(Double.valueOf(ventas)/Double.valueOf(getMetasTotal())) * 100;
		
		ventas = getVentas23Total();
		if(ventas > 0)
			avanceTotal=(Double.valueOf(ventas)/Double.valueOf(getMetasTotal())) * 100;
		
		
		avanceTotal =  Math.round(avanceTotal);
		
		return avanceTotal;
	}

	public void setAvanceTotal(double avanceTotal) {
		this.avanceTotal = avanceTotal;
	}

	public String getSmetasTotal() {
		
		smetasTotal = "" + getMetasTotal();
		if((""+getMetasTotal()).length() >= 4){
			smetasTotal = (""+getMetasTotal()).substring(0,(""+getMetasTotal()).length()-3)
					+"."+
					(""+getMetasTotal()).substring((""+getMetasTotal()).length()-3, (""+getMetasTotal()).length());
		}
		
		return "$ " + smetasTotal;
	}

	public void setSmetasTotal(String smetasTotal) {
		
		
		
		this.smetasTotal = smetasTotal;
	}

	public String getSventas15Total() {
		sventas15Total = "" + ventas15Total;
		if((""+ventas15Total).length() >= 4){
			sventas15Total = (""+ventas15Total).substring(0,(""+ventas15Total).length()-3)
					+"."+
					(""+ventas15Total).substring((""+ventas15Total).length()-3, (""+ventas15Total).length());
		}
		
		return "$ "+sventas15Total;
	}

	public void setSventas15Total(String sventas15Total) {
		this.sventas15Total = sventas15Total;
	}

	public String getSventas18Total() {
		
		sventas18Total = "" + ventas18Total;
		if((""+ventas18Total).length() >= 4){
			sventas18Total = (""+ventas18Total).substring(0,(""+ventas18Total).length()-3)
					+"."+
					(""+ventas18Total).substring((""+ventas18Total).length()-3, (""+ventas18Total).length());
		}
		
		return "$ "+sventas18Total;
	}

	public void setSventas18Total(String sventas18Total) {
		this.sventas18Total = sventas18Total;
	}

	public String getSventas23Total() {
		sventas23Total = ""+ventas23Total;
		if((""+ventas23Total).length() >= 4){
			
			sventas23Total = (""+ventas23Total).substring(0,(""+ventas23Total).length()-3)
					+"."+
					(""+ventas23Total).substring((""+ventas23Total).length()-3, (""+ventas23Total).length());
		}
		
		return "$ " + sventas23Total;
	}

	public void setSventas23Total(String sventas23Total) {
		this.sventas23Total = sventas23Total;
	}

	public String getSavanceTotal() {
		avanceTotal = getAvanceTotal();
		if(avanceTotal >= 100)
		savanceTotal = (""+avanceTotal).substring(0,3)+"%";
		else
		if(avanceTotal > 9)
		  savanceTotal = (""+avanceTotal).substring(0,2)+"%";
		else
			if(avanceTotal <= 9)
			savanceTotal = (""+avanceTotal).substring(0,1)+"%";
		
		return savanceTotal;
	}

	public void setSavanceTotal(String savanceTotal) {
		
		this.savanceTotal = savanceTotal;
	}

	public String getSventas13Total() {
		ventas13Total =  getVentas13Total();
		if((""+ventas13Total).length() >= 4){
			sventas13Total = (""+ventas13Total).substring(0,(""+ventas13Total).length()-3)
					+"."+
					(""+ventas13Total).substring((""+ventas13Total).length()-3, (""+ventas13Total).length());
		}
		
		return "$ "+sventas13Total;
	}

	public void setSventas13Total(String sventas13Total) {
		this.sventas13Total = sventas13Total;
	}

	public int getSize(){
		int ret = 0;
		Iterator<LocalBean> it = getVentas().iterator();
		for (Iterator iterator = it; iterator.hasNext();) {
			LocalBean lb = (LocalBean) iterator.next();
			if(lb.getMetas()>0)
			{	
				ret++;
			}	
		}
		System.out.println("getSize:"+ret);
		return ret;
	}
	
	
}
class t1{
	
	
	
	public static void main(String[] args) {
		
		long t1 = 241892;
		long t2 = 452924;
		
		System.out.println(Double.valueOf(t1)/Double.valueOf(t2));
		
		
		
		
	}
	
	
}