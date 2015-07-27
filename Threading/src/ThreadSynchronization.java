
class SynchronizedOutput{
	
	public synchronized void  displayList(String name,String list[]){
		for(int i=0;i<list.length;i++){
			MyThread t  = (MyThread) Thread.currentThread();
			t.randomWait();
			System.out.println(name + list[i]);
		}
	}
}


class MyThread extends Thread{
	
	static String message[] = {
		"Java","is","hot","aromatic","and","invigoration"
	};
	
	public MyThread(String id){
		super(id);
	}
	
	public void run(){
		SynchronizedOutput s1 = new SynchronizedOutput();
		s1.displayList(getName(), message);
	}
	
	void randomWait(){
		try{
			sleep((long)(3000*Math.random()));
			
		}
		catch(InterruptedException x){
			System.out.println("Interrupted");
		}
	}
	
}



public class ThreadSynchronization {

	public static void main(String args[]){
		MyThread t1 = new MyThread("thrad 1 :");
		MyThread t2 = new MyThread("thrad 2 :");
		
		t1.start();
		t2.start();
		
		  boolean thread1IsAlive = true;
	        boolean thread2IsAlive = true;
		
		 do {
	           if (thread1IsAlive && !t1.isAlive()) {
	               thread1IsAlive = false;
	               System.out.println("Thread 1 is dead.");
	           }
	           if (thread2IsAlive && !t2.isAlive()) {
	               thread2IsAlive = false;
	               System.out.println("Thread 2 is dead.");
	           }
	        } while(thread1IsAlive || thread2IsAlive);
		}
	
}
