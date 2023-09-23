package model;

public class gioHang {
	private user user;
	private sanPham sanPham;
	private int soLuong;

	public gioHang() {

	}

	public gioHang(model.user user, model.sanPham sanPham, int soLuong) {
		this.user = user;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public sanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(sanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
