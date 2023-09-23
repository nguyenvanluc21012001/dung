package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.database;
import model.size;

public class sizeDAO {
	public static sizeDAO get() {
		return new sizeDAO();
	}

	public size sellectByid(int id) {
		size s = null;
		Connection con = database.getconnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM size WHERE id='" + id + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idd = rs.getInt("id");
				String name = rs.getString("name");

				s = new size(idd, name);
			}
			System.out.println(s.getId()+" "+s.getName());
		} catch (SQLException ex) {
			
		}
		return s;
	}
}
