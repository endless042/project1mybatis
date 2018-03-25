package reply;

import java.util.Date;

public class ReplyDataBean {

	private int num;
	private String userid;
	private String password;
	private Date rdate;
	private String content;
	private String pronum;

	


	@Override
	public String toString() {
		return "Message [num=" + num + ", userid=" + userid + ", password=" + password + ", rdate=" + rdate
				+ ", content=" + content + ", pronum=" + pronum + "]";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPronum() {
		return pronum;
	}

	public void setPronum(String pronum) {
		this.pronum = pronum;
	}

	public boolean hasPassword() {
		return password != null && !password.isEmpty();
	}

	public boolean matchPassword(String pwd) {
		return password != null && password.equals(pwd);
	}
}