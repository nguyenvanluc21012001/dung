package model;

public class role {
    private int role_id;
    private String ten;
    
	public role() {

	}

	public role(int role_id, String ten) {
		this.role_id = role_id;
		this.ten = ten;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	
    
}
