package db;

import java.util.Date;

public class AuctionDataBean {

	
	private String state;
	private int re;
	private int num;
	private String origin;
	private String title;
	private String name;
	private String category;
	private String height;
	private String sdate;
	private String edate;
	private String sprice;
	private String eprice;
	private Date rdate;
	private String deliv;
	private int count;
	
	private String imgs;
	private int imgsize;
	private String content;
	private int readcount; 
	
	

	public int getImgsize() {
		return imgsize;
	}
	public void setImgsize(int imgsize) {
		this.imgsize = imgsize;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getRe() {
		return re;
	}
	public void setRe(int re) {
		this.re = re;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getSprice() {
		return sprice;
	}
	public void setSprice(String sprice) {
		this.sprice = sprice;
	}
	public String getEprice() {
		return eprice;
	}
	public void setEprice(String eprice) {
		this.eprice = eprice;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getDeliv() {
		return deliv;
	}
	public void setDeliv(String deliv) {
		this.deliv = deliv;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "AuctionDataBean [state=" + state + ", re=" + re + ", num=" + num + ", origin=" + origin + ", title="
				+ title + ", name=" + name + ", category=" + category + ", height=" + height + ", sdate=" + sdate
				+ ", edate=" + edate + ", sprice=" + sprice + ", eprice=" + eprice + ", rdate=" + rdate + ", deliv="
				+ deliv + ", count=" + count + ", imgs=" + imgs + ", imgsize=" + imgsize + ", content=" + content
				+ ", readcount=" + readcount + "]";
	}

	
	

}
