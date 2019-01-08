package lab2std;
import java.util.*;
public class Admin {
	//Map Student by FirstaName and LastName
	public static HashMap<Key, Student> processStudents(List<Student> students) {
		//implement
		Key k;
		HashMap<Key, Student> table = new HashMap<Key, Student>();
		for(Student s:students){
			k = new Key(s.getFirstName(),s.getLastName());
			table.put(k, s);
		}
		return table;
	}
	
	
}
