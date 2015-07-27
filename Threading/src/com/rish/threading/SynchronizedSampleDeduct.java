package com.rish.threading;

public class SynchronizedSampleDeduct extends Thread {
	
	SynchronizedSample s;
	
	public SynchronizedSampleDeduct(SynchronizedSample s) {
		this.s = s;
	}
	
	@Override
	public void run(){
		
		s.operate(3);
		
	}

}
