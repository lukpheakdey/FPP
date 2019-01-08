package prob2;

import java.util.List;

public class Statistics {
	
	public static double computeSumSalary(List<EmployeeData> t){
		double sum=0;
		
		for (EmployeeData x:t){
			
			sum +=x.getSalary();
		}
		
		return sum;
	}

}
