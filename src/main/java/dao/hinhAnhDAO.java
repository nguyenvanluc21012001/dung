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

public class hinhAnhDAO {
	public static hinhAnhDAO get() {
		return new hinhAnhDAO();
	}

	public int insert(anh a) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO anh(anh_id,hinhAnh)" + "VALUES('" + a.getId() + "','" + a.getLink() + "')";

			int check = st.executeUpdate(sql);
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int update(anh a) {
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "UPDATE anh" + " SET hinhAnh ='" + a.getLink() + "'" + "WHERE anh_id='" + a.getId() + "\'";
			int check = st.executeUpdate(sql);
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int delete(anh a){
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM anh WHERE anh_id='" +a.getId()  + "'";

			int check = st.executeUpdate(sql);
			System.out.println("so dong thay doi la :" + check);
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<anh> sellectAll() {
		ArrayList<anh> ketqua = new ArrayList<>();
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM anh";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("anh_id");
				String link = rs.getString("hinhAnh");
				anh a = new anh(id, link);
				ketqua.add(a);
			}

		} catch (SQLException ex) {
			
		}
		return ketqua;
	}

	public anh sellectByid(int id) {
        anh a= null;
        Connection con= database.getconnection();
        try {
            Statement st = con.createStatement();
            String sql = "SELECT*FROM anh WHERE anh_id='"+id+"'";
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()) {                
                int anh_id = rs.getInt("anh_id");
                String hinhAnh=rs.getString("hinhAnh");
                a= new anh(anh_id, hinhAnh);
            }
           
        } catch (SQLException ex) {
            
        }
        return a;
	}
}
