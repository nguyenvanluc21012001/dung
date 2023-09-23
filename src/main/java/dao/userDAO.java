package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.database;
import model.role;
import model.user;

public class userDAO {
	public static userDAO get() {
		return new userDAO();
	}

	public int insert(user t) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO user(id,tenDangNhap,matKhau,ten,email,sdt,diaChi,role_id)" + "VALUES('"
					+ t.getId() + "','" + t.getTenDangNhap() + "','" + t.getMatKhau() + "','" + t.getTen() + "','"
					+ t.getEmail() + "','" + t.getSdt() + "','" + t.getDiaChi() + "','" + t.getRole().getRole_id()
					+ "')";

			int check = st.executeUpdate(sql);
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int update(user t) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "UPDATE user" + " SET ten ='" + t.getTen() + "'" + "email ='" + t.getEmail() + "'" + "sdt ='"
					+ t.getSdt() + "'" + "diaChi ='" + t.getDiaChi() + "'" + "role_id ='" + t.getRole().getRole_id()
					+ "'" + "WHERE id='" + t.getId() + "\'";
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

	public int delete(int t) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM user WHERE id='" + t + "'";

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

	public ArrayList<user> sellectAll() {
		ArrayList<user> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM user";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String ten = rs.getString("ten");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diaChi");
				int role_id = rs.getInt("role_id");
				role role;
				if (role_id == 1) {
					role = new role(1, "nhân viên");
				} else {
					role = new role(2, "khách hàng");
				}
				user user = new user(id, tenDangNhap, matKhau, ten, email, sdt, diaChi, role);
				ketqua.add(user);
			}

		} catch (SQLException ex) {
			
		}
		return ketqua;
	}

	public user sellectByid(int id) {
		user u = null;
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM user WHERE id='" + id + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idd = rs.getInt("id");
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String ten = rs.getString("ten");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diaChi");
				int role_id = rs.getInt("role_id");
				role role;
				if (role_id == 1) {
					role = new role(1, "nhân viên");
				} else {
					role = new role(2, "khách hàng");
				}
				u = new user(idd, tenDangNhap, matKhau, ten, email, sdt, diaChi, role);
			}

		} catch (SQLException ex) {
			
		}
		return u;
	}

	public boolean kiemTraTenDangNhap(String tenDangNhap) {
		boolean ketQua = false;
		try {
			Connection con = database.getconnection();
			String sql = "SELECT * FROM user WHERE tenDangNhap=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tenDangNhap);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				ketQua = true;
			}

			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public user sellectByTaiKhoanMatKhau(String tendangnhap, String matkhau ) {
		System.out.println(tendangnhap+" "+matkhau);
		user u = null;
		try {

			Connection con = database.getconnection();
			String sql = "SELECT * FROM user WHERE tenDangNhap=? and matKhau=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,tendangnhap);
			st.setString(2,matkhau);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idd = rs.getInt("id");
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String ten = rs.getString("ten");
				String email = rs.getString("email");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diaChi");
				int role_id = rs.getInt("role_id");
				role role;
				if (role_id == 1) {
					role = new role(1, "nhân viên");
				} else {
					role = new role(2, "khách hàng");
				}
				u = new user(idd, tenDangNhap, matKhau, ten, email, sdt, diaChi, role);
			}

		} catch (SQLException ex) {
			
		}
		return u;
	}

}
