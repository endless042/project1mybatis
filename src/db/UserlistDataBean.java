package db;

import java.util.Date;

public class UserlistDataBean {
	
	
	private int num;
	private String ulevel;
	private String name;
	private String id;
	private String pwd;
	private String bdate;
	private String addr;
	private String tel;
	private String email;
	private Date cdate; 
	private String point; 
	
	
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUlevel() {
		return ulevel;
	}
	public void setUlevel(String ulevel) {
		this.ulevel = ulevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserlistDataBean [num=" + num + ", ulevel=" + ulevel + ", name=" + name + ", id=" + id + ", pwd=" + pwd
				+ ", point=" + point + ", bdate=" + bdate + ", addr=" + addr + ", tel=" + tel + ", email=" + email
				+ ", cdate=" + cdate + "]";
	}
	
	
	
	

}
