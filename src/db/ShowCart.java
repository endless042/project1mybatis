package db;

import java.util.Date;

public class ShowCart {
	String title;
	Date rdate;
	String state;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ShowCart [title=" + title + ", rdate=" + rdate + ", state=" + state + "]";
	}
	
	
}
