package com.rish.threading;

public class DispThread implements Runnable{

	String msg;
	
	@Override
	public void run() {
		for(int i=0;i<100000;i++)
		System.out.println(msg);
		
	}
	
	public DispThread(String m){
		this.msg = m;
	}

}
