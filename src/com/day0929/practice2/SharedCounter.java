package com.day0929.practice2;

public class SharedCounter {
	public static void main(String[] args) {
		// Counter counter = new Counter();
		// CounterThread thread1 = new CounterThread(counter);
		// CounterThread thread2 = new CounterThread(counter);
		// CounterThread thread3 = new CounterThread(counter);
		// CounterThread thread4 = new CounterThread(counter);
		// CounterThread thread5 = new CounterThread(counter);
		// CounterThread thread6 = new CounterThread(counter);
		// CounterThread thread7 = new CounterThread(counter);
		// CounterThread thread8 = new CounterThread(counter);
		// CounterThread thread9 = new CounterThread(counter);
		// CounterThread thread10 = new CounterThread(counter);
		Thread thread1 = new Thread(new CounterThread(),"�߳�1");
		Thread thread2 = new Thread(new CounterThread(),"�߳�2");
		Thread thread3 = new Thread(new CounterThread(),"�߳�3");
		Thread thread4 = new Thread(new CounterThread(),"�߳�4");
		Thread thread5 = new Thread(new CounterThread(),"�߳�5");
		Thread thread6 = new Thread(new CounterThread(),"�߳�6");
		Thread thread7 = new Thread(new CounterThread(),"�߳�7");
		Thread thread8 = new Thread(new CounterThread(),"�߳�8");
		Thread thread9 = new Thread(new CounterThread(),"�߳�9");
		Thread thread10 = new Thread(new CounterThread(),"�߳�10");

	
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();

	}

}

// class Counter {
// int countValue = 0;
// }
//
// class CounterThread extends Thread {
// Counter counter;
//
// public CounterThread(Counter counter1) {
// this.counter = counter1;
// }
//
// @Override
// public void run() {
// synchronized(this) {
// for (int i = 1; i <= 10; i++) {
// counter.countValue = counter.countValue + 1;
// }
// System.out.println("counter��ֵΪ��" + counter.countValue);
// }
//
//
// }
// }

class CounterThread implements Runnable {
	static int count = 0;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				count++;
				// System.out.println(count);
			}
			System.out.println(Thread.currentThread().getName() + "���:" + count);
		}

	}
	public int getCount() {
		return count;
	}

}
