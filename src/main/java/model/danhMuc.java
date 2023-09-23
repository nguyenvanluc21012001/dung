package model;

public class danhMuc {
	private int id;
	private String tenDanhMuc;

	public danhMuc() {

	}

	public danhMuc(int id, String tenDanhMuc) {
		this.id = id;
		this.tenDanhMuc = tenDanhMuc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	

}
