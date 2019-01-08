package prob2;

import prob2.util.RandomNumbers;

//This class allows you to test your implementation
//by supplying data to use as your code executes.
//DO NOT MODIFY THIS CLASS IN ANY WAY
public class Main {
	private static final int NUM_ACCOUNTS = 5;
	private static final int CHECKING = 1;
	private static final int CERTIFICATE = 2;
	private static final int SAVINGS = 3;
	private static Bank bank;
	//Expected output not available because accounts are
	//added randomly in the main method.
	public static void main(String[] args) {
		bank = new Bank();	
		for(int i = 0; i < NUM_ACCOUNTS; ++i) { 
			int rand = RandomNumbers.getRandomInt(1,3);
			switch(rand) {
				case CHECKING:
					addChecking();
					break;
				case CERTIFICATE:
					addCertificate();
					break;
				case SAVINGS:
					addSavings();
					break;
				default:
					//do nothing
			}		
		}
		System.out.println(bank.computeBalanceSum());
	}
	
	public static void addChecking() {
		bank.addAccount(new CheckingAccount(1000));
	}
	public static void addCertificate() {
		bank.addAccount(new CertificateDeposit(250, 20));
	}
	public static void addSavings() {
		bank.addAccount(new SavingsAccount(1200, 3));
	}
}
