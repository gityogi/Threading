package com.rish.threading;

public class TestThread {

	public static void main(String[] args){
		
		DispThread dt1 = new DispThread("Hello");
		DispThread dt2 = new DispThread("World");
		
		Thread t1 = new Thread(dt1);
		Thread t2 = new Thread(dt2);
		
		t1.start();
		t2.start();
	}
}
