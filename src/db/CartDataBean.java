package db;

import java.util.Date;

public class CartDataBean {

	String  userid;
	String pronum;
	Date rdate;
	
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
