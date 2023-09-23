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
import model.gioHang;
import model.sanPham;
import model.user;

public class giohangDAO {
	public static giohangDAO get() {
		return new giohangDAO();
	}

	public int insert(int sanpham_id,int user_id, int soluong) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO giohang(sanpham_id,user_id,soluong)"
					+ "VALUES('" +sanpham_id + "','" + user_id + "','" + soluong  + "')";

			int check = st.executeUpdate(sql);
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	public int delete(int t, int v) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM giohang WHERE sanpham_id='" + t + "' AND user_id='"+v+"'";

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
	public ArrayList<gioHang> sellectAllById(int id) {
		ArrayList<gioHang> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM giohang WHERE user_id='"+id+"';";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int sanpham_id = rs.getInt("sanpham_id");
                sanPhamDAO spd= new sanPhamDAO();
                sanPham sp= new sanPham();
                sp=spd.sellectByid(sanpham_id);
                
                int user_id = rs.getInt("user_id");
				userDAO ud = new userDAO();
				user u = new user();
				u = ud.sellectByid(user_id);

				int sl = rs.getInt("soLuong");
			
				gioHang gh = new gioHang(u,sp,sl);
				ketqua.add(gh);
			}

		} catch (SQLException ex) {
			
		}
		return ketqua;
	}

}
