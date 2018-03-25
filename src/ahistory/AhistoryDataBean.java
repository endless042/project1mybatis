package ahistory;

import java.util.Date;

public class AhistoryDataBean {
	int num;
	String userid;
	String price;
	Date adate;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getAdate() {
		return adate;
	}
	public void setAdate(Date adate) {
		this.adate = adate;
	}
	@Override
	public String toString() {
		return "AhistoryDataBean [num=" + num + ", userid=" + userid + ", price=" + price + ", adate=" + adate + "]";
	}
	
	
}
