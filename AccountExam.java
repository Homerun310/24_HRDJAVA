package day06;



class Account{
	
	private int balance; 
	public int getBalance() {
		return balance;
		
	}
	
	public void depsoitint (int money) {
		balance += money;
		
	}
	
	public void withdrawint(int money) throws InsufficientExeption {
		if(balance<money) {
			throw new InsufficientExeption("잔고 부족: "+(money-balance)+"모자람");
		}
	balance-=money;
	}
}

public class AccountExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account= new Account();
		
		account.depsoitint(10000);
		System.out.println("예금액: "+account.getBalance());
		
		try {
			account.withdrawint(30000);
		}catch(InsufficientExeption e) {
			String message=e.getMessage();
			System.out.println(message);
		}
	}
	
}
