package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.database;
import model.chiTietDonHang;
import model.donHang;
import model.sanPham;

public class chiTietDonHangDAO {
	public static chiTietDonHangDAO get() {
		return new chiTietDonHangDAO();
	}

	public int insert(chiTietDonHang sp) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO chitietdonhang(donhang_id,sanpham_id,soLuong)"
					+ "VALUES('" + sp.getDonHang().getId() + "','" + sp.getSanPham().getId() + "','" + sp.getSoLuong()+"')";

			int check = st.executeUpdate(sql);
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	public int delete(int sp) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM chitietdonhang WHERE donhang_id='" + sp + "'";

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

	public ArrayList<chiTietDonHang> sellectAll() {
		ArrayList<chiTietDonHang> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM chitietdonhang ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int donhang_id = rs.getInt("donhang_id");
				int sanpham_id = rs.getInt("sanpham_id");
				donHangDAO dhd= new donHangDAO();
				donHang dh= dhd.sellectByid(donhang_id);
				int soluong = rs.getInt("soLuong");
				sanPhamDAO spd= new sanPhamDAO();
				sanPham sp= spd.sellectByid(sanpham_id);
				chiTietDonHang chiTietDonHang = new chiTietDonHang(dh, sp, soluong);
				ketqua.add(chiTietDonHang);
			}

		} catch (SQLException ex) {
			Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ketqua;
	}
	public ArrayList<chiTietDonHang> sellectAllById(int id) {
		ArrayList<chiTietDonHang> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM chitietdonhang WHERE donhang_id ='"+id+"';";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int donhang_id = rs.getInt("donhang_id");
				int sanpham_id = rs.getInt("sanpham_id");
				donHangDAO dhd= new donHangDAO();
				donHang dh= dhd.sellectByid(donhang_id);
				int soluong = rs.getInt("soLuong");
				sanPhamDAO spd= new sanPhamDAO();
				sanPham sp= spd.sellectByid(sanpham_id);
				chiTietDonHang chiTietDonHang = new chiTietDonHang(dh, sp, soluong);
				ketqua.add(chiTietDonHang);
			}

		} catch (SQLException ex) {
			Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ketqua;
	}
	
}
