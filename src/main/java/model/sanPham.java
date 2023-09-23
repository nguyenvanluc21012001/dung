package model;

public class sanPham {
    private int id;
    private danhMuc danhMuc;
    private String tieuDe;
    private int gia;
    private int giaBan;
    private int giaGoc;
    private anh anh;
    private String moTaSanPham;
	public sanPham() {
		
	}
	public sanPham(int id, model.danhMuc danhMuc, String tieuDe, int gia, int giaBan, int giaGoc, model.anh anh,
			String moTaSanPham) {
		super();
		this.id = id;
		this.danhMuc = danhMuc;
		this.tieuDe = tieuDe;
		this.gia = gia;
		this.giaBan = giaBan;
		this.giaGoc = giaGoc;
		this.anh = anh;
		this.moTaSanPham = moTaSanPham;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public danhMuc getDanhMuc() {
		return danhMuc;
	}
	public void setDanhMuc(danhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public int getGiaGoc() {
		return giaGoc;
	}
	public void setGiaGoc(int giaGoc) {
		this.giaGoc = giaGoc;
	}
	public anh getAnh() {
		return anh;
	}
	public void setAnh(anh anh) {
		this.anh = anh;
	}
	public String getMoTaSanPham() {
		return moTaSanPham;
	}
	public void setMoTaSanPham(String moTaSanPham) {
		this.moTaSanPham = moTaSanPham;
	}
	@Override
	public String toString() {
		return "sanPham [id=" + id + ", danhMuc=" + danhMuc + ", tieuDe=" + tieuDe + ", gia=" + gia + ", giaBan="
				+ giaBan + ", giaGoc=" + giaGoc + ", anh=" + anh + ", moTaSanPham=" + moTaSanPham + "]";
	}  
	
}
