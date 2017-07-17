package com.zsz.pc.thread;

public class ThreadA extends Thread {
	
	private P p;
	
	public ThreadA(P p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		while (true) {
			p.setValue();
		}
	}

}
