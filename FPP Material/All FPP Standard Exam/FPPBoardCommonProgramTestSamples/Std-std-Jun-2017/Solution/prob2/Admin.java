package prob2;

import java.util.*;

public class Admin {
	public static List<Student> convertArray(Object[] studentArray) {
		List<Student> list = new ArrayList<>();
		for(Object ob : studentArray) {
			list.add((Student)ob);
		}
		return list;
	}
	
	
	public static double computeAverageGpa(List<Student> studentList) {
		double totalGpa = 0.0;
		if(studentList.isEmpty()) return 0.0;
		for(Student s : studentList) {
			totalGpa += s.computeGpa();
		}
		return totalGpa / studentList.size();
	}
}
