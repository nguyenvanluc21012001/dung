package model;

public class kho {
	private sanPham sanPham;
	private size size;
	private int soLuong;

	public kho() {

	}

	public kho(model.sanPham sanPham, model.size size, int soLuong) {
		this.sanPham = sanPham;
		this.size = size;
		this.soLuong = soLuong;
	}

	public sanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(sanPham sanPham) {
		this.sanPham = sanPham;
	}

	public size getSize() {
		return size;
	}

	public void setSize(size size) {
		this.size = size;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
