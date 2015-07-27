package com.rish.threading;

public class Sample {
	
	
	
	public static void main(String args[]){
		
		SynchronizedSample ss = new SynchronizedSample();
		SychronizedSampleThread s1 = new SychronizedSampleThread(ss);
		SynchronizedSampleDeduct s2 = new SynchronizedSampleDeduct(ss);
		
		s1.start();
		s2.start();
		
		
}


}
