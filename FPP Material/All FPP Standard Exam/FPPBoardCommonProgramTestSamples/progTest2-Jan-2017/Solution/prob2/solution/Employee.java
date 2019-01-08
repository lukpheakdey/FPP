package prob2.solution;

import java.util.List;

public class Employee {
	public Employee(String id, List<Account> accounts) {
		this.id = id;
		this.accounts = accounts;
	}
	String id;
	List<Account> accounts;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
