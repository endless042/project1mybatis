package user;

import java.util.Map;

public class JoinRequest {
	private String id;
	private String name;
	private String pwd;
	private String confirmPwd;
	private String bdate;
	private String email;
	
	
	
	
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public boolean isPasswordEqualToConfirm() {
		return pwd!=null&&pwd.equals(confirmPwd);
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id,"id");
		checkEmpty(errors, name,"name");
		checkEmpty(errors,pwd,"pwd");
		checkEmpty(errors,confirmPwd,"confirmPwd");
		checkEmpty(errors, email, "email");
		checkEmpty(errors, bdate, "bdate");
		
		if(!errors.containsKey("confirmPassword")) {
			if(!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}
	private void checkEmpty(Map<String, Boolean> errors,String value, String fieldName) {
		if(value==null||value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);}
	}
	@Override
	public String toString() {
		return "JoinRequest [id=" + id + ", name=" + name + ", pwd=" + pwd + ", confirmPwd=" + confirmPwd + ", bdate="
				+ bdate + ", email=" + email + "]";
	}
	
	
	
	
}
