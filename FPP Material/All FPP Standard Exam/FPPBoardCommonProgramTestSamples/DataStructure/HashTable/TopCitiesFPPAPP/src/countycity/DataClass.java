package countycity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class DataClass {
	static enum SortMethod {BYNAME, BYPOP};
	public final static List<TopCity> USACITY = new ArrayList<>();
	public final static List<TopCity> INDIANCITY = new ArrayList<>();
	public final static Hashtable<String,List<TopCity>> HT= new Hashtable<>();
	public static void main(String args[]){
		
		USACITY.add(new TopCity("New York", 8_174_959));
		USACITY.add(new TopCity("Los Angeles", 3_792_657));
		USACITY.add(new TopCity("Chicago", 2_695_598));
		USACITY.add(new TopCity("Houston", 2_096_661));
		USACITY.add(new TopCity("Philadelphia", 1_526_006));
		USACITY.add(new TopCity("Phoenix", 1_447_617));
		USACITY.add(new TopCity("San Antonio", 1_327_556));
		USACITY.add(new TopCity("San Diego", 1_301_621));
		USACITY.add(new TopCity("Dallas", 1_197_792));
		USACITY.add(new TopCity("San Jose", 945_942));
		
		INDIANCITY.add(new TopCity("Delhi",	24_953_000));
		INDIANCITY.add(new TopCity("Mumbai",20_741_000));
		INDIANCITY.add(new TopCity("Calcutta", 14_766_000));
		INDIANCITY.add(new TopCity("Hyderabad", 11_458_741));
		INDIANCITY.add(new TopCity("Bangalore", 10_839_725));
		INDIANCITY.add(new TopCity("Chennai", 9_121_477));
		INDIANCITY.add(new TopCity("Ahmedabad", 7_368_614));
		INDIANCITY.add(new TopCity("Jaipur",	6_612_914));
		INDIANCITY.add(new TopCity("Surat",	5_748_238));
		INDIANCITY.add(new TopCity("Pune",	5_571_419));
		
		HT.put("USA", USACITY);
		HT.put("INDIA", INDIANCITY);
		List<String> list = new ArrayList(Arrays.asList("New York","Dallas","Delhi","Pune"));
		List<TopCity> cpop = TopCityUtility.CityPopulation(HT, list);
		System.out.println(cpop);
		System.out.println("Sorting by Indian Cities");
		TopCityUtility.sort("India", SortMethod.BYNAME.toString(), HT);
		System.out.println("Sorting by USA City Population");
		TopCityUtility.sort("USA", SortMethod.BYPOP.toString(), HT);
	}
}
