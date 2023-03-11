package tree;

import java.util.ArrayList;

public class DanhSachPhongBan {
	private ArrayList<PhongBan> listPhongBan;

	public DanhSachPhongBan() {
		listPhongBan = new ArrayList<PhongBan>();
	}

	public void addPhongBan(PhongBan pb) {
		listPhongBan.add(pb);
	}

	public ArrayList<PhongBan> getListPhongBan() {
		return listPhongBan;
	}

}
