package countycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TopCityUtility {
   /* this method takes the first argument as Hashtable with Country name as key and its top cities as values.
    * Second argument is List of Cities as String.
    * This method need to return the list of top cities which match with the cities in the Hash Table
    */
	
	public static List<TopCity> CityPopulation(Hashtable<String, List<TopCity>> table, List<String> list) {
		//IMPLEMENT
		List<TopCity> temp = new ArrayList<>();
	//	List<Double> pop = new ArrayList<>();
		Set<String> keys = table.keySet();
		List<TopCity> tc = new ArrayList();
		for(String key:keys){
			tc.addAll(table.get(key));
			}
			for(String x:list){
        	   Iterator<TopCity> it = tc.iterator();
        	   while(it.hasNext()){
        		   TopCity y = it.next();
        		   if(x.equals(y.getCname())){
        			   temp.add(y);
        		//	   pop.add(y.getPop());
        		   }
        			   
        	   }
 
           }
   		return temp;
	}	
	
	// This method helps to sort the collection based on user requirements.
	public static void sort(String Country, String sorttype, Hashtable<String, List<TopCity>> table){
	
		List<TopCity> temp = new ArrayList<>();
		Set<String> keys = table.keySet();
		List<TopCity> tc = new ArrayList();
		for(String key:keys){
			if(key.equalsIgnoreCase(Country))
			tc.addAll(table.get(key));
			}
		Comparator<TopCity> cp = new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				TopCity ob1 = (TopCity)o1;
				TopCity ob2 = (TopCity)o2;
				if(sorttype.equalsIgnoreCase("byname"))
				   return ob1.getCname().compareTo(ob2.getCname());
				else
				return  (int) (ob1.getPop()-ob2.getPop());
			}
	};
	Collections.sort(tc,cp);
	System.out.println(tc);
	
	}
			
	/* public void sort(List<Employee> emps, SortMethod method) {
		Collections.sort(emps, (e1,e2) ->
		{
			//local variable method must be effectively final, 
			//but not necessarily final
			if(method == SortMethod.BYNAME) {
				//instance vble ignoreCase does not need to be effectively final
				if(ignoreCase) return e1.name.compareToIgnoreCase(e2.name);
				else return e1.name.compareTo(e2.name);
			} else {
				if(e1.salary == e2.salary) return 0;
				else if(e1.salary < e2.salary) return -1;
				else return 1;
			}		
		});
	}*/
	
}
