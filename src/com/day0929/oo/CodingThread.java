package com.day0929.oo;

public class CodingThread {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Thread print = new PrintThread();
//		print.run();
//		print.setName("��ӡ�߳�");
//		print.setDaemon(true);
		try {
			print.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print.start();
//
//		DownloadMovie dm = new DownloadMovie();
//		Thread downloader = new Thread(dm);
//		downloader.start();
		
		coding();
//		System.out.println(Thread.currentThread().getName());
		long finishTime = System.currentTimeMillis();
		System.out.println("����ʱ" + (finishTime - startTime));
	}

	public static void coding() {
		for (int i = 0; i < 10; i++) {
			System.out.println("С����д��" + i + "�д���");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class PrintThread extends Thread {
	public void run() {
		
		for (int i = 1; i <= 200; i++) {
			System.out.println("printng��" + i + "ҳֽ");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class DownloadMovie implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("���ص�" + i + "��");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
