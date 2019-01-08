package prob2;

import java.util.ArrayList;
import java.util.List;

public class MainEmpClass {
	
	
	public static void main(String[] args){
		
		List<Teacher> teachers= new ArrayList<Teacher>();
		
		teachers.add(new Teacher("David",4,90000,4000));
		teachers.add(new Teacher("Abigail",3,85000,6000));
		teachers.add(new Teacher("Michael",5,95000,7000));
		teachers.add(new Teacher("Forst",6,80000,3000));
		teachers.add(new Teacher("Glen",2,75000,9000));
		
		List<Staff> stf= new ArrayList<Staff>();
		
		stf.add(new Staff("Saly",4,78000));
		stf.add(new Staff("Becky",3,89000));
		stf.add(new Staff("Alan",4,95000));
		stf.add(new Staff("Paul",4,100000));
		
		List<EmployeeData> cmbd= combine(teachers,stf);
		
		System.out.println(Statistics.computeSumSalary(cmbd));
		
	}
	
	public static List<EmployeeData> combine(List<Teacher>t1,List<Staff>s1){
		List<EmployeeData> temp= new ArrayList<EmployeeData>();
		temp.addAll(t1);
		temp.addAll(s1);
		
		return temp;
	}

}
