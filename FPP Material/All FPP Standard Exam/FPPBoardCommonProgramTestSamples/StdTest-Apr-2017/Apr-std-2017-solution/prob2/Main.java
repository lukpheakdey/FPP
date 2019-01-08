package apr_std_2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Bicycle[] bikes = {
				new Bicycle("1054",  125.50, Brand.SCHWINN),
				new Bicycle("2122",  145.00, Brand.BIANCHI ),
				new Bicycle("1442",  95.50, Brand.SURLY),
				new Bicycle("0606",  225.75, Brand.SCHWINN),
				new Bicycle("2411",  88.00, Brand.TREK),
		};
		Accessory[] accessories = {
				new Accessory("148", 45.00, Item.BICYCLE_PUMP),
				new Accessory("033", 18.50, Item.KICKSTAND),
				new Accessory("233", 25.00, Item.MIRROR),
				new Accessory("148", 55.00, Item.SECURITY_LOCK)	
		};
		int x = 20;
		int count = 0;
		for(Accessory a : accessories) {
			a.setNumInStock(x + (count = count + 5));
		}
		count = 8;
		for(Bicycle b : bikes) {
			b.setNumInStock(count--);
		}
		
		List<Bicycle> list1 = Arrays.asList(bikes);
		List<Accessory> list2 = Arrays.asList(accessories); 
		int productValue = Inventory.inventoryValue(list1,  list2);
		System.out.println("Store value as of " 
			    + LocalDate.now().getMonth() + " " +
				+ LocalDate.now().getDayOfMonth() + ", " 
				+ LocalDate.now().getYear() + ": " 
			    + "$" + productValue);

	}

}
