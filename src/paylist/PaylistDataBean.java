package paylist;

import java.util.Date;

import auction.AuctionDataBean;
import gpurc.GpurcDataBean;

public class PaylistDataBean {
	
	private int num;
	private String pronum;
	private String userid;
	private Date rdate;
	private String price;
	private String name;
	private String addr;
	private String tel;
	private String deliv;
	private AuctionDataBean aproduct;
	private GpurcDataBean gproduct;
	private int  count;
	private String point;
	private String ordernum;
	
	

	
	
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPronum() {
		return pronum;
	}
	public void setPronum(String pronum) {
		this.pronum = pronum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDeliv() {
		return deliv;
	}
	public void setDeliv(String deliv) {
		this.deliv = deliv;
	}
	@Override
	public String toString() {
		return "PaylistDataBean [num=" + num + ", pronum=" + pronum + ", userid=" + userid + ", rdate=" + rdate
				+ ", price=" + price + ", name=" + name + ", addr=" + addr + ", tel=" + tel + ", deliv=" + deliv
				+ ", aproduct=" + aproduct + ", gproduct=" + gproduct + ", count=" + count + ", point=" + point
				+ ", ordernum=" + ordernum + "]";
	}

	
	
	
	
	
}
