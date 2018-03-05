package db;

import java.util.Date;

public class ReplyDataBean {

	  private String userid;
	  private Date rdate;
	  private String pronum;
	  private String content;
	  private String password;
	  private int num;
	  
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
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getPronum() {
		return pronum;
	}
	public void setPronum(String pronum) {
		this.pronum = pronum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ReplyDataBean [userid=" + userid + ", rdate=" + rdate + ", pronum=" + pronum + ", content=" + content
				+ ", password=" + password + ", num=" + num + "]";
	}
	
	  
	  
}
