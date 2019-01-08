package prob2;

public class Teacher implements EmployeeData{
	
	private String name;
	private int no_ofDependents;
	private double salary;
	private double bonus;
	public Teacher(String name, int no_ofDependents, double salary, double bonus) {
		
		this.name = name;
		this.no_ofDependents = no_ofDependents;
		this.salary = salary;
		this.bonus = bonus;
	}
	public String getName() {
		return name;
	}
	public int getNo_ofDependents() {
		return no_ofDependents;
	}
	public double getSalary() {
		return salary+bonus;
	}
	
	
	
	

}
