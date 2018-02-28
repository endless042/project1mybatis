package comment;

import java.util.Date;

public class CommentData {
	private int conum;
	private String id;
	private String pwd;
	private String cocontent;
	private Date codate;
	private int articlenum;
	public int getConum() {
		return conum;
	}
	public void setConum(int conum) {
		this.conum = conum;
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
	public String getCocontent() {
		return cocontent;
	}
	public void setCocontent(String cocontent) {
		this.cocontent = cocontent;
	}
	public Date getCodate() {
		return codate;
	}
	public void setCodate(Date codate) {
		this.codate = codate;
	}
	public int getArticlenum() {
		return articlenum;
	}
	public void setArticlenum(int articlenum) {
		this.articlenum = articlenum;
	}
	@Override
	public String toString() {
		return "CommentData [conum=" + conum + ", id=" + id + ", pwd=" + pwd + ", cocontent=" + cocontent + ", codate="
				+ codate + ", articlenum=" + articlenum + "]";
	}
	
	
}
