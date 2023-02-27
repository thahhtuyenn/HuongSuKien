package tuan02_qlNhanVien;

public class Employee {
	private String id, firstName, lastName, gender;
	private double salary;
	private int age;

	public Employee(String id, String firstName, String lastName, String gender, double salary, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.salary = salary;
		this.age = age;
	}

	public Employee(String id) {
		this.id = id;
		this.firstName = "";
		this.lastName = "";
		this.gender = "";
		this.salary = 0;
		this.age = 1;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getgender() {
		return gender;
	}

	public void setgender(String gender) {
		this.gender = gender;
	}

	public double getsalary() {
		return salary;
	}

	public void setsalary(double salary) {
		this.salary = salary;
	}

	public int getage() {
		return age;
	}

	public void setage(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
