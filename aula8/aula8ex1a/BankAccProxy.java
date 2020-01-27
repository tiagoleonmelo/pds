package aula8ex1a;

public class BankAccProxy implements BankAccount {
	private BankAccountImpl bankAcc;
	
	public BankAccProxy(BankAccountImpl bankAcc) {
		this.bankAcc = bankAcc;
	}

	@Override
	public void deposit(double amount) {
		bankAcc.deposit(amount);

	}

	@Override
	public boolean withdraw(double amount) {
		if (Company.user == User.OWNER) {
			return bankAcc.withdraw(amount);
		} else
			throw new UnsupportedOperationException("Error");

	}

	@Override
	public double balance() {
		if (Company.user == User.OWNER) {
			return bankAcc.balance();
		} else
			throw new UnsupportedOperationException("Error");

	}

}
