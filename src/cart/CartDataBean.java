package cart;

import java.util.Date;

import auction.AuctionDataBean;
import gpurc.GpurcDataBean;

public class CartDataBean {

	String  userid;
	String pronum;
	Date rdate;
	
	AuctionDataBean aproduct;
	GpurcDataBean gproduct;
	
	
	
	
	public AuctionDataBean getAproduct() {
		return aproduct;
	}
	public void setAproduct(AuctionDataBean aproduct) {
		this.aproduct = aproduct;
	}
	public GpurcDataBean getGproduct() {
		return gproduct;
	}
	public void setGproduct(GpurcDataBean gproduct) {
		this.gproduct = gproduct;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	
	public String getPronum() {
		return pronum;
	}
	public void setPronum(String pronum) {
		this.pronum = pronum;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "CartDataBean [userid=" + userid + ", pronum=" + pronum + ", rdate=" + rdate + "]";
	}

	
	
	
	
}
