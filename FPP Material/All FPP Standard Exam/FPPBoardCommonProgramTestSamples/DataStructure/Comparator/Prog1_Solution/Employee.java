package prog8_3_soln;



import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

	private String name;
	private Date hireDate;
	private double salary;
	
	public Employee(String name, double salary, int year, int month, int day){
		this.name = name;
		this.salary = salary;
		GregorianCalendar cal = 
			new GregorianCalendar(year,month,day);
		hireDate= cal.getTime();
	}

	public Date getHireDate() {
		return (Date)hireDate.clone();
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public boolean equals(Object o){
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Employee e = (Employee)o;
		return (e.getName().equals(name)&& 
				e.getHireDate().equals(hireDate) &&
				e.getSalary()== salary);
	}
	
	public int hashCode(){
		int h1 = name.hashCode();
		int h2 = hireDate.hashCode();
		int h3 = (int)(100*salary);
		return combineHashes(h1,h2,h3);
	}
	private static BigInteger bigint(int x){
		return BigInteger.valueOf(x);
}

	public static int combineHashes(int hash1, int hash2, int hash3) {
		BigInteger intmax = bigint(Integer.MAX_VALUE);
		BigInteger power2 = bigint(2).modPow(bigint(hash1),intmax);
		BigInteger power3 = bigint(3).modPow(bigint(hash2),intmax);
		BigInteger power5 = bigint(5).modPow(bigint(hash3),intmax);
		BigInteger product = power2.multiply(power3).multiply(power5).mod(intmax); 
		return product.intValue();
	}
	
	public String toString() {
		String newline = System.getProperty("line.separator");
		return newline+"EMPLOYEE "+name+newline+
				"Date of Hire: "+hireDate+newline+
				"Salary: "+salary+newline;
	}

	

}
