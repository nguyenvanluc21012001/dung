package model;

import java.util.Date;

public class chiTietDonHang {
    private donHang donHang;
    private sanPham sanPham;
    private int soLuong;
    
	public chiTietDonHang() {
		
	}

	public chiTietDonHang(model.donHang donHang, model.sanPham sanPham, int soLuong) {
		this.donHang = donHang;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public donHang getDonHang() {
		return donHang;
	}

	public void setDonHang(donHang donHang) {
		this.donHang = donHang;
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
