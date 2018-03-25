package order;

import java.util.Date;

import auction.AuctionDataBean;
import gpurc.GpurcDataBean;
import userlist.UserlistDBBean;
import userlist.UserlistDataBean;

public class OrderDataBean {
	private int num;
	private String  userid;
	private String pronum;
	private Date rdate;
	private String aprice;
	private String payState;
	private AuctionDataBean aproduct;
	private GpurcDataBean gproduct;
	private int remainTime;
	private int count;
	private int startRemain;
	
	private String deliv;
	private String payPrice;
	private UserlistDataBean user;
	
	
	
	public String getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}
	public String getDeliv() {
		return deliv;
	}
	public void setDeliv(String deliv) {
		this.deliv = deliv;
	}
	public UserlistDataBean getUser() {
		UserlistDBBean upro=UserlistDBBean.getInstance();
		upro.getUser(userid);
		return user;
	}
	
	public int getStartRemain() {
		return startRemain;
	}
	public void setStartRemain(int startRemain) {
		this.startRemain = startRemain;
	}
	public int getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getAprice() {
		return aprice;
	}
	public void setAprice(String aprice) {
		this.aprice = aprice;
	}
	public String getPayState() {
		return payState;
	}
	public void setPayState(String payState) {
		this.payState = payState;
	}
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
	@Override
	public String toString() {
		return "OrderDataBean [num=" + num + ", userid=" + userid + ", pronum=" + pronum + ", rdate=" + rdate
				+ ", aprice=" + aprice + ", payState=" + payState + ", aproduct=" + aproduct + ", gproduct=" + gproduct
				+ ", remainTime=" + remainTime + ", count=" + count + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
