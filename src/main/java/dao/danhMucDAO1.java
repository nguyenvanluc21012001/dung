package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.database;
import model.danhMuc;

public class danhMucDAO1 {
	public static danhMucDAO1 get() {
    	return new danhMucDAO1();
    }

  
    public int insert(danhMuc t) {
        Connection con =database.getconnection();
                try {
			Statement st=con.createStatement();
			String sql="INSERT INTO danhmuc(id,ten)"
					+"VALUES('"+t.getId()+"','"+t.getTenDanhMuc()+"')";
                                  
			int check=st.executeUpdate(sql);
			database.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
    }

 
    public int update(danhMuc t) {
         Connection con =database.getconnection();
                try {
			Statement st=con.createStatement();
			String sql= "UPDATE danhmuc"
                                +" SET ten ='"+t.getTenDanhMuc()+"'"  
                                +"WHERE id='"+t.getId()+"\'";
                        int check=st.executeUpdate(sql);
                        System.out.println("so dong thay doi la :"+check);
			if (check>0) {
			    System.out.println("thuc hien thanh cong :"+sql);	
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

  
    public int delete(danhMuc t) {
         Connection con =database.getconnection();
                try {
			Statement st=con.createStatement();
			String sql= "DELETE FROM danhmuc WHERE id='"+t.getId()+"'";
                                
			int check=st.executeUpdate(sql);
			System.out.println("so dong thay doi la :"+check);
			if (check>0) {
			    System.out.println("thuc hien thanh cong :"+sql);	
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

 
    public ArrayList<danhMuc> sellectAll() {
       ArrayList<danhMuc> ketqua= new ArrayList<>();
        Connection con= database.getconnection();
        try {
            Statement st = con.createStatement();
            String sql = "SELECT*FROM danhmuc";
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()) {                
                int id=rs.getInt("id");
                String ten=rs.getString("ten");
                danhMuc dm= new danhMuc(id,ten);
                ketqua.add(dm);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketqua;
    }

 
    public danhMuc sellectByid(int id) {
        danhMuc dm= null;
        Connection con= database.getconnection();
        try {
            Statement st = con.createStatement();
            String sql = "SELECT*FROM danhmuc WHERE id='"+id+"'";
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()) {                
                int ma = rs.getInt("id");
                String ten=rs.getString("ten");
                dm= new danhMuc(ma, ten);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(danhMucDAO1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }
}
