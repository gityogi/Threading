package com.rish.threading;

public class SychronizedSampleThread extends Thread {
	
	SynchronizedSample s;
	
	
     public SychronizedSampleThread( SynchronizedSample s) {
		this.s = s;
	}
	
	@Override
	public void run(){
		
		s.operate(2);
		
	}

}
