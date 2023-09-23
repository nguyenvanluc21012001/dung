package model;

import java.time.LocalDateTime;

public class donHang {
    private int id;
    private user user;
    private String ten;
    private String email;
    private String sdt;
    private String diaChi;
    private LocalDateTime thoiGianDat;
    
	public donHang() {

	}

	public donHang(int id, model.user user, String ten, String email, String sdt, String diaChi, LocalDateTime thoiGianDat) {
		super();
		this.id = id;
		this.user = user;
		this.ten = ten;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.thoiGianDat=thoiGianDat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public LocalDateTime getThoiGianDat() {
		return thoiGianDat;
	}

	public void setThoiGianDat(LocalDateTime thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}

	@Override
	public String toString() {
		return "donHang [id=" + id + ", user=" + user + ", ten=" + ten + ", email=" + email + ", sdt=" + sdt
				+ ", diaChi=" + diaChi + ", thoiGianDat=" + thoiGianDat + "]";
	}
	
    
}
