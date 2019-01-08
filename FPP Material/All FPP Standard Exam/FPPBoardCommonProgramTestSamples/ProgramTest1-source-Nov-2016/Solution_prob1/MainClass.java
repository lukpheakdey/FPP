package prob1;

import java.util.ArrayList;
import java.util.HashMap;

public class MainClass {
	
	public static void main(String[] args){
		
		HashMap<String,Employee> test= new HashMap<String,Employee>();
		
		test.put("1254", new Employee("1254","John",100000));
		test.put("9862", new Employee("9862","Dave",70000));
		test.put("8947", new Employee("8947","Rick",90000));
		test.put("4586", new Employee("4586","Abey",200000));
		test.put("2389", new Employee("2389","Cary",85000));
		
		ArrayList<String> ssnc= new ArrayList<String>();
		
		ssnc.add("4586");
		ssnc.add("2147");
		ssnc.add("1258");
		ssnc.add("8947");
		ssnc.add("1254");
		ssnc.add("9862");
		ssnc.add("1440");
		
		System.out.println(NewEmp.highSal(test, ssnc));
		
		
	}

}
