package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.database;
import model.donHang;
import model.user;

public class donHangDAO {
	public static donHangDAO get() {
		return new donHangDAO();
	}

	public int insert(donHang sp) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO donhang(id,user_id,ten,email,sdt,diaChi,thoiGianDat)"
					+ "VALUES('" + sp.getId() + "','" + sp.getUser().getId() + "','" + sp.getTen() + "','"
					+ sp.getEmail() + "','" + sp.getSdt() + "','" + sp.getDiaChi() + "','"+sp.getThoiGianDat()+"')";

			int check = st.executeUpdate(sql);
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	public int update1(donHang t) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "UPDATE donhang" + " SET ten ='" + t.getTen() + "'," + "email ='" + t.getEmail() + "'," + "sdt ='"
					+ t.getSdt() + "'," + "diaChi ='" + t.getDiaChi()+ "','"+t.getThoiGianDat() + "WHERE id='" + t.getId() + "\'";
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
			String sql = "DELETE FROM donhang WHERE id='" + sp + "'";

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

	public ArrayList<donHang> sellectAll() {
		ArrayList<donHang> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM donhang ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				userDAO usd= new userDAO();
				user u= usd.sellectByid(user_id);
				String ten = rs.getString("ten");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				String diachi=rs.getString("diaChi");
				Timestamp thoiGianDatTimestamp=rs.getTimestamp("thoigianDat");
				LocalDateTime thoiGianDat = thoiGianDatTimestamp.toLocalDateTime();
				donHang dh = new donHang(id, u, ten, email, sdt, diachi, thoiGianDat);
				ketqua.add(dh);
			}

		} catch (SQLException ex) {
			Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ketqua;
	}

	public donHang sellectByid(int id) {
		donHang dh = null;
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM donhang WHERE id='" + id + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int donhang_id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				userDAO usd= new userDAO();
				user u= usd.sellectByid(user_id);
				String ten = rs.getString("ten");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				String diachi=rs.getString("diaChi");
				Timestamp thoiGianDatTimestamp=rs.getTimestamp("thoigianDat");
				LocalDateTime thoiGianDat = thoiGianDatTimestamp.toLocalDateTime();
				dh = new donHang(donhang_id, u, ten, email, sdt, diachi,thoiGianDat);
			}
		} catch (SQLException ex) {
			
		}
		return dh;
	}
}
