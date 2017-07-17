package com.zsz.pc.thread;

/**
 * 多生产者多消费者模式的假死
 * 原因：可能生产者或者消费者唤醒了同类，导致线程假死。
 * 解决方式：替换唤醒方式，将notify()替换为notifyAll()
 * @author zszyff
 *
 */
public class Run {
	
	public static void main(String[] args) throws InterruptedException {
		String lock = new String("");
		P p = new P(lock);
		C c = new C(lock);
		ThreadA threadA = new ThreadA(p);
		ThreadB threadB = new ThreadB(c);
		for (int i = 0; i < 2; i++) {
			threadA = new ThreadA(p);
			threadA.setName("生产者：" + (i + 1));
			threadB = new ThreadB(c);
			threadB.setName("消费者：" + (i + 1));
			threadA.start();
			threadB.start();
		}
		Thread.sleep(5000);
		Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadArray);
		for (int i = 0; i < threadArray.length; i++) {
			System.out.println(threadArray[i].getName() + " " + threadArray[i].getState());
		}
	}

}
