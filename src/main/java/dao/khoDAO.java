package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.database;
import model.kho;

public class khoDAO {
	public static khoDAO get() {
		return new khoDAO();
	}
	public kho sellectkho(int sanPham_id, int size_id ) {
		kho k = null;
		try {

			Connection con = database.getconnection();
			String sql = "SELECT * FROM kho WHERE sanpham_id=? and size_id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,sanPham_id);
			st.setInt(2,size_id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int sanPham = rs.getInt("sanPham_id");
				sanPhamDAO spd= new sanPhamDAO();
				model.sanPham sp = spd.sellectByid(sanPham);
				int size = rs.getInt("size_id");
				sizeDAO sd= new sizeDAO();
				model.size s= sd.sellectByid(size);
				int soLuong = rs.getInt("soLuongTonKho");
				
				k= new kho(sp, s, soLuong);
			}
          System.out.println(k.getSanPham().getMoTaSanPham()+" "+k.getSoLuong());
		} catch (SQLException ex) {
			
		}
		return k;
	}
}
