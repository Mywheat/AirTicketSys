package cn.edu.lingnan.dto;

public class ClientDTO {
	private String cid;
	private String cname;
	private int status;
	private String tel;
	private String password;
	private String superpassword;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSuperpassword() {
		return superpassword;
	}
	public void setSuperpassword(String superpassword) {
		this.superpassword = superpassword;
	}

	
	
}
