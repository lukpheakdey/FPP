package prob2;

public class CertificateDeposit implements Account{
	private double balance;
	private double interest;

	public CertificateDeposit(double balance, double interest) {
		this.balance = balance;
		this.interest = interest;
	}

	public double computeTotal() {
		return balance + (balance * interest / 10);
	}
}
