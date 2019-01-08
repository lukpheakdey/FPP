package grading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;
import prob2.solution.AccountManager;
import prob2.solution.CheckingAccount;
import prob2.solution.Employee;
import prob2.solution.RetirementAccount;
import prob2.solution.SavingsAccount;

/**
 * Note: This unit test does not check whether student 
 * implemented polymorphism. Needs to be checked manually.
 */
public class TestProb2 extends TestCase {
	final double answer = 629000.0;
	
	public void testComputation() {
		RetirementAccount rAccount1 = new RetirementAccount(50000, null);
		RetirementAccount rAccount2 = new RetirementAccount(40000, null);
		RetirementAccount rAccount3 = new RetirementAccount(30000, null);
		RetirementAccount rAccount4 = new RetirementAccount(90000, null);
		SavingsAccount sAccount1 = new SavingsAccount(80000, .05);
		SavingsAccount sAccount3 = new SavingsAccount(120000, .07);
		SavingsAccount sAccount4 = new SavingsAccount(60000, .03);
		CheckingAccount cAccount2 = new CheckingAccount(70000);
		CheckingAccount cAccount3 = new CheckingAccount(30000);
		CheckingAccount cAccount4 = new CheckingAccount(45000);
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("12", Arrays.asList(rAccount1, sAccount1)));
		emps.add(new Employee("31", Arrays.asList(rAccount2, cAccount2)));
		emps.add(new Employee("42", Arrays.asList(rAccount3, cAccount3, sAccount3)));
		emps.add(new Employee("33", Arrays.asList(rAccount4, sAccount4, cAccount4)));
		double sum = AccountManager.computeAccountBalanceSum(emps);
		assertEquals(answer, sum);
	}
}
