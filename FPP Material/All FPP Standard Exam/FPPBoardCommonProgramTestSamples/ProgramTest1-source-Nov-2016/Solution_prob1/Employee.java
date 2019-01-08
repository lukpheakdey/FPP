package prob1;

public class Employee {
	
	private String ssn;
    private String name;
    int salary;
    
    
	public Employee(String ssn, String name, int salary) {
	
		this.ssn = ssn;
		this.name = name;
		this.salary = salary;
	}
	public String getSsn() {
		return ssn;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return "Employee [ssn=" + ssn + ", name=" + name + ", salary=" + salary + "]";
	}
    
    

}
