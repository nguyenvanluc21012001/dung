package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.database;
import model.anh;
import model.danhMuc;
import model.role;
import model.sanPham;
import model.user;

public class sanPhamDAO {
	public static sanPhamDAO get() {
		return new sanPhamDAO();
	}

	public int insert(sanPham sp) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO sanpham(id,tieuDe,danhMuc_id,gia,giaBan,giaGoc,hinhAnh_id,moTaSanPham)"
					+ "VALUES('" + sp.getId() + "','" + sp.getTieuDe() + "','" + sp.getDanhMuc().getId() + "','"
					+ sp.getGia() + "','" + sp.getGiaBan() + "','" + sp.getGia() + "','" + sp.getAnh().getId() + "','"
					+ sp.getMoTaSanPham() + "')";

			int check = st.executeUpdate(sql);
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	public int update1(sanPham t) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "UPDATE sanpham" + " SET tieuDe ='" + t.getTieuDe() + "'," + "danhMuc_id ='" + t.getDanhMuc().getId() + "'," + "gia ='"
					+ t.getGia() + "'," + "giaBan ='" + t.getGiaBan() + "'," + "giaGoc ='" + t.getGiaGoc()+"',"+"hinhAnh_id ='" + t.getAnh().getId()+"',"+"moTaSanPham ='" + t.getMoTaSanPham()+"'"
				    + "WHERE id='" + t.getId() + "\'";
			int check = st.executeUpdate(sql);
			System.out.println(sql);
			System.out.println("so dong thay doi la :" + check);
			if (check > 0) {
				System.out.println("thuc hien thanh cong :" + sql);
			} else {
				System.out.println("that bai");
			}
			database.close(con);
		} catch (SQLException ex) {
			Logger.getLogger(sanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

		return 0;
	}
	public int delete(int sp) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM sanpham WHERE id='" + sp + "'";

			int check = st.executeUpdate(sql);
			System.out.println("so dong thay doi la :" + check);
			if (check > 0) {
				System.out.println("thuc hien thanh cong :" + sql);
			} else {
				System.out.println("that bai");
			}
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	public int deletedanhmuc(int danhmuc) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM sanpham WHERE danhMuc_id='" + danhmuc + "'";

			int check = st.executeUpdate(sql);
			System.out.println("so dong thay doi la :" + check);
			if (check > 0) {
				System.out.println("thuc hien thanh cong :" + sql);
			} else {
				System.out.println("that bai");
			}
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<sanPham> sellectAll() {
		ArrayList<sanPham> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM sanpham ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String tieuDe = rs.getString("tieuDe");
				int danhMuc_id = rs.getInt("danhMuc_id");
				danhMucDAO1 dmd = new danhMucDAO1();
				danhMuc dm = new danhMuc();
				dm = dmd.sellectByid(danhMuc_id);
				int gia = rs.getInt("gia");
				int giaBan = rs.getInt("giaBan");
				int giaGoc = rs.getInt("giaGoc");
				int hinhAnh_id=rs.getInt("hinhAnh_id");
				hinhAnhDAO had=new hinhAnhDAO();
				anh a= new anh();
				a=had.sellectByid(hinhAnh_id);
				String moTaSanPham = rs.getString("moTaSanPham");
				sanPham sanPham = new sanPham(id, dm, tieuDe, gia, giaBan, giaGoc, a, moTaSanPham);
				ketqua.add(sanPham);
			}

		} catch (SQLException ex) {
			Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ketqua;
	}

	public sanPham sellectByid(int id) {
		sanPham sp = null;
		Connection con = database.getconnection();
		try {
		    Statement s= con .createStatement();
			String sql = "SELECT*FROM sanpham WHERE id='" + id + "'";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				int idd = rs.getInt("id");
				String tieuDe = rs.getString("tieuDe");

				int danhMuc_id = rs.getInt("danhMuc_id");
				danhMucDAO1 dmd = new danhMucDAO1();
				danhMuc dm = new danhMuc();
				dm = dmd.sellectByid(danhMuc_id);

				int gia = rs.getInt("gia");
				int giaBan = rs.getInt("giaBan");
				int giaGoc = rs.getInt("giaGoc");

				int hinhAnh_id = rs.getInt("hinhAnh_id");
				hinhAnhDAO had = new hinhAnhDAO();
				anh a = new anh();
				a = had.sellectByid(hinhAnh_id);

				String moTaSanPham = rs.getString("moTaSanPham");

				sp = new sanPham(idd, dm, tieuDe, gia, giaBan, giaGoc, a, moTaSanPham);
			}
			System.out.println(sp.getGiaBan()+" "+sp.getMoTaSanPham());
		} catch (SQLException ex) {
			
		}
		return sp;
	}
	
	
	public sanPham[] sellect() {
		System.out.println("sanPhamDao");
		sanPham sp[] = new sanPham[1];
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM sanpham ORDER BY RAND() LIMIT 1";
			ResultSet rs = st.executeQuery(sql);
			int i=0;
			while (rs.next()) {
				int id = rs.getInt("id");
				String tieuDe = rs.getString("tieuDe");

				int danhMuc_id = rs.getInt("danhMuc_id");
				danhMucDAO1 dmd = new danhMucDAO1();
				danhMuc dm = new danhMuc();
				dm = dmd.sellectByid(danhMuc_id);

				int gia = rs.getInt("gia");
				int giaBan = rs.getInt("giaBan");
				int giaGoc = rs.getInt("giaGoc");

				int hinhAnh_id = rs.getInt("hinnAnh_id");
				hinhAnhDAO had = new hinhAnhDAO();
				anh a = new anh();
				a = had.sellectByid(hinhAnh_id);
				String moTaSanPham = rs.getString("moTaSanPham");
				sanPham sanPham = new sanPham(id, dm, tieuDe, gia, giaBan, giaGoc, a, moTaSanPham);
				sp[i]=sanPham;
				i++;
			}

		} catch (SQLException ex) {
			Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return sp;
	}
	//tìm danh sách 8 sản phẩm bất kì
	public ArrayList<sanPham> sellectcuoi() {
		ArrayList<sanPham> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM sanpham ORDER BY RAND() LIMIT 8";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String tieuDe = rs.getString("tieuDe");
				int danhMuc_id = rs.getInt("danhMuc_id");
				danhMucDAO1 dmd = new danhMucDAO1();
				danhMuc dm = new danhMuc();
				dm = dmd.sellectByid(danhMuc_id);
				int gia = rs.getInt("gia");
				int giaBan = rs.getInt("giaBan");
				int giaGoc = rs.getInt("giaGoc");
				int hinhAnh_id=rs.getInt("hinhAnh_id");
				hinhAnhDAO had=new hinhAnhDAO();
				anh a= new anh();
				a=had.sellectByid(hinhAnh_id);
				String moTaSanPham = rs.getString("moTaSanPham");
				sanPham sanPham = new sanPham(id, dm, tieuDe, gia, giaBan, giaGoc, a, moTaSanPham);
				ketqua.add(sanPham);
			}

		} catch (SQLException ex) {
			Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ketqua;
	}
	public ArrayList<sanPham> sellectByTieuDe(String tieuDe) {
		ArrayList<sanPham> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM sanpham WHERE tieuDe LIKE "+"'%"+tieuDe+"%'"+" ORDER BY RAND() LIMIT 8";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idd = rs.getInt("id");
				String td = rs.getString("tieuDe");

				int danhMuc_id = rs.getInt("danhMuc_id");
				danhMucDAO1 dmd = new danhMucDAO1();
				danhMuc dm = new danhMuc();
				dm = dmd.sellectByid(danhMuc_id);

				int gia = rs.getInt("gia");
				int giaBan = rs.getInt("giaBan");
				int giaGoc = rs.getInt("giaGoc");

				int hinhAnh_id = rs.getInt("hinhAnh_id");
				hinhAnhDAO had = new hinhAnhDAO();
				anh a = new anh();
				a = had.sellectByid(hinhAnh_id);

				String moTaSanPham = rs.getString("moTaSanPham");

				sanPham sp = new sanPham(idd, dm, td, gia, giaBan, giaGoc, a, moTaSanPham);
				ketqua.add(sp);
			}
		} catch (SQLException ex) {
			
		}
		return ketqua;
	}
	//tìm danh sách sản phẩm theo danh muc
	public ArrayList<sanPham> sellectDanhMuc1(int x,int y ) {
		ArrayList<sanPham> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM sanpham WHERE danhMuc_id ='"+x+"' OR danhMuc_id='"+y+"'ORDER BY RAND() LIMIT 8";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String tieuDe = rs.getString("tieuDe");
				int danhMuc_id = rs.getInt("danhMuc_id");
				danhMucDAO1 dmd = new danhMucDAO1();
				danhMuc dm = new danhMuc();
				dm = dmd.sellectByid(danhMuc_id);
				int gia = rs.getInt("gia");
				int giaBan = rs.getInt("giaBan");
				int giaGoc = rs.getInt("giaGoc");
				int hinhAnh_id=rs.getInt("hinhAnh_id");
				hinhAnhDAO had=new hinhAnhDAO();
				anh a= new anh();
				a=had.sellectByid(hinhAnh_id);
				String moTaSanPham = rs.getString("moTaSanPham");
				sanPham sanPham = new sanPham(id, dm, tieuDe, gia, giaBan, giaGoc, a, moTaSanPham);
				ketqua.add(sanPham);
			}

		} catch (SQLException ex) {
			Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ketqua;
	}
	//tìm danh sách sản phẩm theo danh muc
	public ArrayList<sanPham> sellectDanhMuc2(int x) {
		ArrayList<sanPham> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM sanpham WHERE danhMuc_id ='"+x+"' ORDER BY RAND() LIMIT 8";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String tieuDe = rs.getString("tieuDe");
				int danhMuc_id = rs.getInt("danhMuc_id");
				danhMucDAO1 dmd = new danhMucDAO1();
				danhMuc dm = new danhMuc();
				dm = dmd.sellectByid(danhMuc_id);
				int gia = rs.getInt("gia");
				int giaBan = rs.getInt("giaBan");
				int giaGoc = rs.getInt("giaGoc");
				int hinhAnh_id=rs.getInt("hinhAnh_id");
				hinhAnhDAO had=new hinhAnhDAO();
				anh a= new anh();
				a=had.sellectByid(hinhAnh_id);
				String moTaSanPham = rs.getString("moTaSanPham");
				sanPham sanPham = new sanPham(id, dm, tieuDe, gia, giaBan, giaGoc, a, moTaSanPham);
				ketqua.add(sanPham);
			}

		} catch (SQLException ex) {
			Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ketqua;
	}

}
