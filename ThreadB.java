package com.zsz.pc.thread;

public class ThreadB extends Thread {
	
	private C c;
	
	public ThreadB(C c) {
		super();
		this.c = c;
	}

	@Override
	public void run() {
		while (true) {
			c.getValue();
		}
	}

}
