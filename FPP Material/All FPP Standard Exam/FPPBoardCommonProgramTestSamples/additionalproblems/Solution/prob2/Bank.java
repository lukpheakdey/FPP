package prob2;

import java.util.*;

//You are not allowed to remove the 'final' keyword.
//You are allowed to change Object type in addAccount to another type, as necessary
public final class Bank {
	
	private List<Account> accountList = new ArrayList<>();
	
	public void addAccount(Account account) {
		accountList.add(account);
	}
	
	//IMPLEMENT - polymorphically determine the totals of
	//each account and then return the sum of all these totals 
	public double computeBalanceSum() {
		double sum = 0.0;
		for(Account ac : accountList){
			sum +=ac.computeTotal();
		}
		return sum;
	}
	
	
	
}
