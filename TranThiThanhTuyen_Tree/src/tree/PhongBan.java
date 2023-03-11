package tree;

import java.util.ArrayList;

public class PhongBan {
	private String maPhong;
	private String tenPhong;
	private ArrayList<Employee> listEployee;

	public PhongBan(String maPhong, String tenPhong) {
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.listEployee = new ArrayList<Employee>();
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		if (!maPhong.trim().equals("")) {
			this.maPhong = maPhong;
		} else {
			this.maPhong = "xxx";
		}
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		if (!tenPhong.trim().equals(""))
			this.tenPhong = tenPhong;
		else
			this.tenPhong = "-----";
	}

	public ArrayList<Employee> getListEployee() {
		return listEployee;
	}

	public void setListEployee(ArrayList<Employee> listEployee) {
		this.listEployee = listEployee;
	}

	private boolean isExists(String id) {
		int vitri = listEployee.indexOf(new Employee(id));
		if (vitri < 0)
			return false;
		else
			return true;
	}

	public boolean addEmployee(Employee nv) {
		if (isExists(nv.getId())) {
			return false;
		} else {
			listEployee.add(nv);
			return true;
		}
	}

	public boolean removeEmployee(Employee nv) {
		if (isExists(nv.getId())) {
			listEployee.remove(nv);
			return true;
		} else
			return false;
	}

	public int search(String id) {
		int virtri = listEployee.indexOf(new Employee(id));
		if (virtri < 0)
			return -1;
		return virtri;
	}

	public Employee getEmployeeByIndex(int viTri) {
		if (viTri < 0 || viTri > listEployee.size())
			return null;
		return listEployee.get(viTri);
	}

	public boolean update(String id, String firstName, String lastName, boolean gender, double salary, int age) {
		Employee newEmpl;
		if (search(id) < 0) {
			return false;
		} else {
			newEmpl = listEployee.get(search(id));
			newEmpl.setFirstName(firstName);
			newEmpl.setLastName(lastName);
			newEmpl.setGender(false);
			newEmpl.setSalary(salary);
			newEmpl.setAge(age);
			return true;
		}

	}
	
	@Override
	public String toString() {
		return tenPhong;
	}

}
