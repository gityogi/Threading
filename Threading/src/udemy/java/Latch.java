package udemy.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



class ProcessorL implements Runnable{

	private CountDownLatch latch;
	
	public ProcessorL(CountDownLatch latch){
		this.latch = latch;
	}
	@Override
	public void run() {
		System.out.println("Started ...");
		
		System.out.println("This is actually working");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
	}
	
}


public class Latch {

	public static void main(String[] args) {
		
		List<? extends Object> myList = new ArrayList<Integer>();
		
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<3;i++){
			executor.submit(new ProcessorL(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed...");

	}

}
