package order;

import java.util.Date;

import auction.AuctionDataBean;
import gpurc.GpurcDataBean;

public class ShowOrder {
	private String title;
	private Date rdate;
	private String state;
	private String imgs;
	private AuctionDataBean aproduct;
	private GpurcDataBean gproduct;
	
	
	
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
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ShowCart [title=" + title + ", rdate=" + rdate + ", state=" + state + ", imgs=" + imgs + "]";
	}
	
	
	
	
}
