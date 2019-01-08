package commontestmarch2017.prob2;

import java.time.LocalDate;

public abstract class Vehicle {
	
	public abstract String getOwner();
	//public abstract void setOwner(String owner);
	//public abstract LocalDate getLastServiced();
	
	//public void setLastServiced(LocalDate lastServiced) {
		//this.lastServiced = lastServiced;
	//
	
//}
	public abstract int getMilesUsedToday();
	
	public abstract void setMilesUsedToday(int milesUsedToday);
}