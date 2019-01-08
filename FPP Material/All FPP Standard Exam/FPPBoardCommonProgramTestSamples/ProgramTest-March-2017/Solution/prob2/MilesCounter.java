package commontestmarch2017.prob2;

//import java.util.List;
import java.util.*;

public class MilesCounter {
	public static List<Vehicle>/*<implement>*/ convertArray(Object[] vehicleArray) {
		/* implement */
		
		List <Vehicle> l1  = new ArrayList <Vehicle> ();
		
		for (Object o1 : vehicleArray )
		{
			Vehicle v1 = (Vehicle) o1;
			l1.add(v1);
		}
		
		return l1;
	}
	
	
	
	public static int computeTotalMiles(List <Vehicle>/*<implement>*/ vehicleList) {
		/*implement */
		
		int total = 0;
		
		for (Vehicle v2 : vehicleList )
		{
			total += v2.getMilesUsedToday();
		}
		
		return total;
	}
}
