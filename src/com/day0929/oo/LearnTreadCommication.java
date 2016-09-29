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
						System.out.println("Producer:Box为满，进入等待");
						box.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Producer: Box中放入了" + i + ",并通知其他等待者");
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
						System.out.println("Customer:box为空，进入等待队列");
						box.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println("Customer: Box中取出了" + i + ",并通知其他等待者");
				box.boxValue = 0;
				box.notify();
			}
		}
	}
}