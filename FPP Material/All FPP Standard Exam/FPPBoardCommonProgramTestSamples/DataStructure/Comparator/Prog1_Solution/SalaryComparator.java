package prog8_3_soln;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
	//compareTo in this case is not consistent with equals
	public int compare(Employee e1, Employee e2) {
		double sal1 = e1.getSalary();
		double sal2 = e2.getSalary();
		if(sal1 < sal2) return -1;
		if(sal1 == sal2) return 0;
		return 1;
		
	}
	
}