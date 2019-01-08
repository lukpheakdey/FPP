package prob2;

public class Staff implements EmployeeData {
	
	public String name;
	public int no_ofDependents;
	public double salary;
	public Staff(String name, int no_ofDependents, double salary) {
		
		this.name = name;
		this.no_ofDependents = no_ofDependents;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public int getNo_ofDependents() {
		return no_ofDependents;
	}
	public double getSalary() {
		return salary;
	}
	
	
	

}
