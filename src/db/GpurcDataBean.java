package db;

import java.util.Date;

public class GpurcDataBean {

	private String state;
	private String process;
	private int re;
	private int num;
	private String origin;
	private String title;
	private String name;
	private String category;
	private String height;
	private  String sdate;
	private  String edate;
	private String price;
	private int goal;
	private int count;
	private Date rdate;
	private String deliv;
	private String imgs;
	private String content;
	private int readcount;
	private int imgsize;
	
	
	public int getImgsize() {
		return imgsize;
	}
	public void setImgsize(int imgsize) {
		this.imgsize = imgsize;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	@Override
	public String toString() {
		return "GpurcDataBean [state=" + state + ", process=" + process + ", re=" + re + ", num=" + num + ", origin="
				+ origin + ", title=" + title + ", name=" + name + ", category=" + category + ", height=" + height
				+ ", sdate=" + sdate + ", edate=" + edate + ", price=" + price + ", goal=" + goal + ", count=" + count
				+ ", rdate=" + rdate + ", deliv=" + deliv + ", imgs=" + imgs + ", content=" + content + ", readcount="
				+ readcount + ", imgsize=" + imgsize + "]";
	}
	
	
	
	

}
