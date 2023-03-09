package tuan02_qlNhanVien;

import java.io.Serializable;
import java.util.ArrayList;

public class ListEmployee implements Serializable{
	private ArrayList<Employee> ds;

	public ListEmployee() {
		this.ds = new ArrayList<Employee>();
	}

	public ArrayList<Employee> getDs() {
		return ds;
	}

	private boolean isExists(String id) {
		int vitri = ds.indexOf(new Employee(id));
		if (vitri < 0)
			return false;
		else
			return true;
	}

	public boolean addEmployee(Employee nv) {
		if (isExists(nv.getId())) {
			return false;
		} else {
			ds.add(nv);
			return true;
		}
	}

	public boolean removeEmployee(Employee nv) {
		if (isExists(nv.getId())) {
			ds.remove(nv);
			return true;
		} else
			return false;
	}

	public int search(String id) {
		int virtri = ds.indexOf(new Employee(id));
		if (virtri < 0)
			return -1;
		return virtri;
	}

	public Employee getEmployeeByIndex(int viTri) {
		if (viTri < 0 || viTri > ds.size())
			return null;
		return ds.get(viTri);
	}

	public boolean update(String id, String firstName, String lastName, boolean gender, double salary, int age) {
		Employee newEmpl;
		if (search(id) < 0) {
			return false;
		} else {
			newEmpl = ds.get(search(id));
			newEmpl.setFirstName(firstName);
			newEmpl.setLastName(lastName);
			newEmpl.setGender(false);
			newEmpl.setSalary(salary);
			newEmpl.setAge(age);
			return true;
		}

	}
}
