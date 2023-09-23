package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.database;
import model.feedBack;
import model.sanPham;
import model.user;

public class feedbackDAO {
	public static feedbackDAO get() {
		return new feedbackDAO();
	}

	public int insert(feedBack fb) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO feedback(id,user_id,tieuDe,noiDung)"
					+ "VALUES('" + fb.getSanPham_id().getId() + "','" + fb.getUser().getId() + "','" + fb.getTieuDe()+"','"
					+ fb.getNoiDung() + "')";

			int check = st.executeUpdate(sql);
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	public int delete(int sanpham_id, int user_id) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM feedback WHERE id='" + sanpham_id + "' AND user_id='"+user_id+"'";
			int check = st.executeUpdate(sql);
			System.out.println(sql);
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

	public ArrayList<feedBack> sellectAll() {
		ArrayList<feedBack> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM feedback ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				sanPhamDAO spd= new sanPhamDAO();
				sanPham sp=spd.sellectByid(id);
				int user_id = rs.getInt("user_id");
				userDAO usd= new userDAO();
				user u= usd.sellectByid(user_id);
				String tieuDe = rs.getString("tieuDe");
				String noiDung=rs.getString("noiDung");
				feedBack fb = new feedBack(sp, u, tieuDe, noiDung);
				ketqua.add(fb);
			}

		} catch (SQLException ex) {
			Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ketqua;
	}
	public ArrayList<feedBack> sellectAll(int sanpham_id) {
		ArrayList<feedBack> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM feedback WHERE id = '"+sanpham_id+"'";
			ResultSet rs = st.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				sanPhamDAO spd= new sanPhamDAO();
				sanPham sp=spd.sellectByid(id);
				int user_id = rs.getInt("user_id");
				userDAO usd= new userDAO();
				user u= usd.sellectByid(user_id);
				String tieuDe = rs.getString("tieuDe");
				String noiDung=rs.getString("noiDung");
				feedBack fb = new feedBack(sp, u, tieuDe, noiDung);
				ketqua.add(fb);
			}

		} catch (SQLException ex) {
			Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ketqua;
	}

}
