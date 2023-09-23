package quanLy;

import java.util.ArrayList;

import model.danhMuc;
import model.user;

public class quanLyDanhMuc {
	ArrayList<danhMuc> list = new ArrayList<>();

	// them
	public void them(danhMuc d) {
		list.add(d);
	}

	// xoa
	public void xoa(danhMuc d) {
		list.remove(d);
	}

	// sua
	public void sua(danhMuc d) {
		for (danhMuc danhMuc : list) {
			if (danhMuc.getId() == d.getId()) {
				danhMuc.setTenDanhMuc(d.getTenDanhMuc());
			}
		}
	}

	// tim kiem theo ma
	public danhMuc timKieṃ̣̣̣Ma(int id) {
		for (danhMuc danhMuc : list) {
			if (danhMuc.getId() == id) {
				return danhMuc;
			}
		}
		return null;
	}

	// tim kiem theo ten
	public ArrayList<danhMuc> timKiemTen(String ten) {
		ArrayList<danhMuc> list_danhMuc = new ArrayList<>();
		for (danhMuc danhMuc : list) {
			if (danhMuc.getTenDanhMuc().equals("ten")) {
				list_danhMuc.add(danhMuc);
			}
		}
		return list_danhMuc;
	}

}
