package prob2.solution;

import java.util.List;

public class AccountManager {
	public static double computeAccountBalanceSum(List<Employee> emps) {
		double sum = 0;
		for(Employee e : emps) {
			List<Account> accounts = e.getAccounts();
			for(Account a: accounts) {
				sum += a.getBalance();
			}
		}
		return sum;
	}
}
