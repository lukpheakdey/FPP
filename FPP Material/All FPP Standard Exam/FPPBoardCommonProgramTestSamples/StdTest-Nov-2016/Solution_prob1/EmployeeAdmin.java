package prob1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EmployeeAdmin {
	
	/**
		Returns a list of Employees whose social security number is on the input list socSecNums
		and whose salary is > 80000. The list must be ordered by social security number,
		from lowest to highest. To sort, you must use a Collections sorting method
		and you must define your own Comparator to be used to compare Employees by ssn. 
	*/
	public static List<Employee> prepareReport(HashMap<String, Employee> table, List<String> socSecNums) {
List<Employee> temp= new ArrayList<Employee>();
		
		Set<Entry<String, Employee>> k= table.entrySet();
		Iterator<Entry<String, Employee>> it= k.iterator();
		
		while(it.hasNext()){
			Entry<String, Employee> m = it.next();
			String sr= m.getKey();
			Employee x= m.getValue();
			
			for(int i=0; i<socSecNums.size();i++){
				if(sr.equals(socSecNums.get(i))&&x.getSalary()>80_000)
					temp.add(x);
			}
			
		  }
		
		Collections.sort(temp,namComp);
		
		return temp;
		
	}
	
	public static final Comparator <Employee>namComp=new Comparator<Employee>(){
		public int compare(Employee e1,Employee e2){
		   return e1.getName().compareTo(e2.getName()) ;}
	};
	
}
