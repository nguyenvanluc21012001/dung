package model;

public class feedBack {
	private sanPham sanPham_id;
	private user user;
	private String tieuDe;
	private String noiDung;

	public feedBack() {

	}
	public feedBack(sanPham sanPham_id, model.user user, String tieuDe, String noiDung) {
		super();
		this.sanPham_id = sanPham_id;
		this.user = user;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
	}
	
	public sanPham getSanPham_id() {
		return sanPham_id;
	}

	public void setSanPham_id(sanPham sanPham_id) {
		this.sanPham_id = sanPham_id;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

}
