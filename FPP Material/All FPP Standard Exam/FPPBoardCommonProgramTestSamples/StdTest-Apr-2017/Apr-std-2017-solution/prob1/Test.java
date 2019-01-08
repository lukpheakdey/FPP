package lab2std;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("serial")
		List<Student> list = new ArrayList<Student>() {
			{
				add(new Student("Joe", "Smith", 3.2, Standing.FRESHMAN));
				add(new Student("Tom", "Rogers", 3.5, Standing.SENIOR));
				add(new Student("HeLing", "Wu", 2.9, Standing.JUNIOR));
				add(new Student("Pierre", "Fromage", 2.8, Standing.FRESHMAN));
				add(new Student("Ihaku", "Tamataku", 3.9, Standing.JUNIOR));
				add(new Student("Richard", "Wong", 2.8, Standing.SOPHOMORE));
			}
		};
		
		HashMap<Key, Student> map = Admin.processStudents(list);
		//HashMap<String,Student> map2 =Admin.processStudentsByFirstName(list);
		//System.out.println(map2);
		//HashMap<Standing,Student> map2 =Admin.processStudentsByStanding(list);
		//System.out.println(map2);
		HashMap<Double,Student> map2 =Admin.processStudentsByGpa(list);
		//System.out.println(map2);
		System.out.println(Double.hashCode(2.8));
		System.out.println(Double.hashCode(2.8));

		//String st = null;
//		System.out.println(st.hashCode());
//		System.out.println(Objects.hash(null));
		
		System.out.println(map);
		boolean[] expectedOutput = {true, false};
		boolean[] results = new boolean[2];
		Student s = new Student("Pierre", "Fromage", 2.8, Standing.FRESHMAN);
		Key pierre = new Key("Pierre", "Fromage");
		Key richard = new Key("Richard", "Fremling");
		results[0] = (map.get(pierre).equals(s));
		results[1] = map.containsKey(richard);
		System.out.println((Arrays.equals(expectedOutput, results) ? "pass" : "fail"));

	}

}
