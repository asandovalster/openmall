package cl.openti.openmall.modulo.model.datamodel;

import java.util.List;

import cl.openti.openmall.modulo.model.bean.LocalBean;
import cl.openti.openmall.modulo.model.bean.SellerBean;


public class SellerDataModel extends PrimeDataModel<SellerBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2385463321986669379L;

	private String fecha;
	private String tienda;
	private String vendedor;
	private String supervisor;
	private long montoBase = 0;
	private long montoNeto = 0;
	private long dscto = 0;
	private double por_dscto = 0;
	
	
	
	private long metas=0;
	private long ventas=0;
	private double avance =0;

	private String smetas="0";
	private String sventas="0";
	private String savance = "0";

	public SellerDataModel() {
	}

	public SellerDataModel(Object data) {
		super(data);
	}

	@Override
	public SellerBean getRowData(String rowKey) {

		List<SellerBean> sellers = (List<SellerBean>) getWrappedData();
        metas =0;
        ventas=0;
        avance = 0;
		for (SellerBean seller : sellers) {
			if (seller.getId_seller() == Integer.parseInt(rowKey)) {
				System.out.println("RowKey:" + rowKey);
			
				
				return seller;
			}
			
		}
		return null;
	}

	@Override
	public String getRowKey(SellerBean seller) {
		return seller.getId_seller() + "";
	}

	public long getMetas() {
		
		metas = 0;
		List<LocalBean> locales = (List<LocalBean>) getWrappedData();
		
		for (LocalBean local : locales) {
			LocalBean loc = local;
			
			metas += loc.getMetas();
		}
		
		return metas;
		
	}

	public void setMetas(long metas) {
		this.metas = metas;
	}

	public long getVentas() {
		
		ventas = 0;
		List<LocalBean> locales = (List<LocalBean>) getWrappedData();
		
		for (LocalBean local : locales) {
			LocalBean loc = local;
			
			ventas += loc.getVentas();
		}
		
		return ventas;
	}

	public void setVentas(long ventas) {
		this.ventas = ventas;
	}

	public double getAvance() {
		
		avance = 0;
		List<LocalBean> locales = (List<LocalBean>) getWrappedData();
		
		for (LocalBean local : locales) {
			LocalBean loc = local;
			
			avance += loc.getAvance();
		}
		if(locales.size() > 0)
		avance = avance / locales.size();
		
		return avance;
	}

	public void setAvance(double avance) {
		this.avance = avance;
	}

	public String getSmetas() {
		
		metas = getMetas();
		if((""+metas).length() >= 4){
			smetas = (""+metas).substring(0,(""+metas).length()-3)
					+"."+
					(""+metas).substring((""+metas).length()-3, (""+metas).length());
		}
		
		return "$ " + smetas;
	}

	public void setSmetas(String smetas) {
		this.smetas = smetas;
	}

	public String getSventas() {
		

		ventas = getVentas();
		if((""+ventas).length() >= 4){
			sventas = (""+ventas).substring(0,(""+ventas).length()-3)
					+"."+
					(""+ventas).substring((""+ventas).length()-3, (""+ventas).length());
		}
		
		return "$ " + sventas;
	}

	public void setSventas(String sventas) {
		this.sventas = sventas;
	}

	public String getSavance() {
		
		avance = getAvance()*100;
		if(avance  >= 100)
			savance = (""+avance).substring(0,3)+"%";
		else
		if(avance > 9)
		  savance = (""+avance).substring(0,2)+"%";
		else
			if(avance <= 9)
			savance = (""+avance).substring(0,1)+"%";
		
		return savance;
	
	}

	public void setSavance(String savance) {
		this.savance = savance;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public long getMontoBase() {
		return montoBase;
	}

	public void setMontoBase(long montoBase) {
		this.montoBase = montoBase;
	}

	public long getMontoNeto() {
		return montoNeto;
	}

	public void setMontoNeto(long montoNeto) {
		this.montoNeto = montoNeto;
	}

	public long getDscto() {
		return dscto;
	}

	public void setDscto(long dscto) {
		this.dscto = dscto;
	}

	public double getPor_dscto() {
		return por_dscto;
	}

	public void setPor_dscto(double por_dscto) {
		this.por_dscto = por_dscto;
	}

	
	
	
}
