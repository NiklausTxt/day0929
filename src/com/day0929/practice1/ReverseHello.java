package com.day0929.practice1;

public class ReverseHello {
	public static void main(String[] args) {
		ReverseThread thread = new ReverseThread(50);
//		Thread reverse = new Thread(thread);
//		reverse.start();
		thread.start();
	}
}

class ReverseThread extends Thread{
	private int num;
	public ReverseThread(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		if(num==0){
			;
		}else{
			System.out.println("Hello Form Thread"+num);
			num--;
			ReverseThread thread = new ReverseThread(num);
			thread.start();
		}
		
	}
}

