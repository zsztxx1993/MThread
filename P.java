package com.zsz.pc.thread;

public class P {
	
	private String lock;
	
	public P(String lock) {
		super();
		this.lock = lock;
	}
	
	public void setValue() {
		try {
			synchronized(lock) {
				while (!ValueObject.value.equals("")) {
					System.out.println("生产者：" + Thread.currentThread().getName() + " waiting 111 ");
					lock.wait();
				}
				System.out.println("生产者：" + Thread.currentThread().getName() + " runnable ");
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				ValueObject.value = value;
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
