package com.day0929.oo;

public class LearnTreadCommication {
	public static void main(String[] args) {
		Box box = new Box();
		Customer customer = new Customer(box);
		Producer producer = new Producer(box);
		customer.start();
		producer.start();
	}
}

class Box {
	int boxValue = 0;
}

class Producer extends Thread {
	private Box box;

	public Producer(Box box) {
		this.box = box;
	}

	@Override
	public void run() {
		for (int i = 1; i < 6; i++) {
			synchronized (box) {
				while (box.boxValue != 0) {

					try {
						System.out.println("Producer:BoxΪ��������ȴ�");
						box.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Producer: Box�з�����" + i + ",��֪ͨ�����ȴ���");
				box.boxValue = i;
				box.notify();
			}
		}
	}
}

class Customer extends Thread {
	private Box box;

	public Customer(Box box) {
		this.box = box;
	}

	@Override
	public void run() {
		for (int i = 1; i < 6; i++) {
			synchronized (box) {
				while (box.boxValue == 0) {

					try {
						System.out.println("Customer:boxΪ�գ�����ȴ�����");
						box.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println("Customer: Box��ȡ����" + i + ",��֪ͨ�����ȴ���");
				box.boxValue = 0;
				box.notify();
			}
		}
	}
}