package quanLy;

import java.util.ArrayList;

import model.user;

public class quanLyUser {
     ArrayList<user> list= new ArrayList<>();
     //them
     public void them(user u) {
    	 list.add(u);
     }
    
     //xoa
     public boolean xoa(int i) {
    	 for (user user : list) {
			if (user.getId()==i) {
				return true;
			}
		}
    	 return false;
     }
     
     public void sua(user u) {
    	 for (user user : list) {
			if(user.getId()==u.getId()) {
				user.setTenDangNhap(u.getTenDangNhap());
				user.setMatKhau(u.getMatKhau());
				user.setTen(u.getTen());
				user.setEmail(u.getEmail());
				user.setDiaChi(u.getDiaChi());
				user.setSdt(u.getSdt());
				user.setRole(u.getRole());
			}
		}
     }
     
     //tim kiem theo ma
     public user timKieṃ̣̣̣Ma(int id){
    	 for (user user : list) {
			if(user.getId()==id) {
				return user;
			}
		 }
    	 return null;
     }
     
     //tim kiem theo ten
     public ArrayList<user> timKiemTen(String ten) {
    	 ArrayList<user> list_user= new ArrayList<>();
    	 for (user user : list) {
			if(user.getTen().equals("ten")) {
				list_user.add(user);
			}
		}
    	 return list_user;
     }
     
     
     
}
