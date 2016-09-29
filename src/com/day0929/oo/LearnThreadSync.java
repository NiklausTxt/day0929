package com.day0929.oo;

public class LearnThreadSync {
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		BankThread husband = new BankThread(bankAccount);
		BankThread wife = new BankThread(bankAccount);
		husband.start();
		wife.start();
	}
}

class BankAccount{
	private double balance = 1000 ;
	public boolean deposit(double newAdd){
		if(newAdd <= 0){
			return false;
		}else{
			synchronized (this) {
				System.out.println("当前的余额为："+balance);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance+=newAdd;
				System.out.println("新的余额为："+balance);
			}
			
		
			return true;
		}
	}
}

class BankThread extends Thread{
	private BankAccount bankAccount;
	public BankThread(BankAccount account) {
		bankAccount=account;
	}
	@Override
	public void run() {
		bankAccount.deposit(200);
	}
}