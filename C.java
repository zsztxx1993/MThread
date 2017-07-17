package com.zsz.pc.thread;

public class C {

	private String lock;
	
	public C(String lock) {
		super();
		this.lock = lock;
	}
	
	public void getValue() {
		try { 
			synchronized(lock) {
				while (ValueObject.value.equals("")) {
					System.out.println("消费者：" + Thread.currentThread().getName() + " waiting 222 ");
					lock.wait();
				}
				System.out.println("消费者：" + Thread.currentThread().getName() + " runnable ");
				ValueObject.value = "";
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
