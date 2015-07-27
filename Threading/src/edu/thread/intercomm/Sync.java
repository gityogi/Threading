package edu.thread.intercomm;

class AnotherClass{
	public void method(){
		
	}
}


class Imp implements Runnable{
	
	
	@Override
	public void run() {
		System.out.println("Run Method...");
		
	}
	
}



public class Sync {

	public static void main(String[] args) {
		Imp i = new Imp();
		Thread t = new Thread(i);

		t.start();
		
	}

}
