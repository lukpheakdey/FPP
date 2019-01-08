package lab2std;

import java.util.Objects;

public class Key {
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Key(String f, String l) {
		this.firstName = f;
		this.lastName = l;
	}
	@Override
	public boolean equals(Object o){
		if(o==null) return false;
	
		if(getClass()!= o.getClass())return false;
		Key k =(Key)o;
		return firstName.equals(k.firstName) && lastName.equals(k.lastName);
		//return Objects.equals(this.firstName, k.firstName) && Objects.equals(this.lastName, k.lastName);
		
	}

	@Override
	public String toString() {
		return "Key [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	@Override
	public int hashCode(){
		int hs = 17;
		hs+= 31*hs +firstName.hashCode();
		hs+= 31*hs +lastName.hashCode();
		return hs;
		//return Objects.hash(firstName,lastName);
	}
	
}
