package edu.thread.intercomm;

import java.util.Vector;

public class ProducerConsumer {
	
	public static void main(String args[]){
		Vector sharedQueue = new Vector();
		int size = 4;
		 Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
	        Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
	        prodThread.start();
	        consThread.start();
		
	}

}

class Producer implements Runnable{
	
	private final Vector sharedQueue;
	private final int SIZE;
	
	public Producer(Vector sharedQueue, int size){
		this.sharedQueue = sharedQueue;
		this.SIZE = size;
	}

	@Override
	public void run() {
			for(int i =0;i<7;i++){
				System.out.println("Produced : "+i);
				try{
					produce(i);
				}
				catch (InterruptedException ex){
					System.out.println("EXC");
				}
			}
		
	}
	private void produce(int i)throws InterruptedException{
		
		while(sharedQueue.size() == SIZE){
			synchronized (sharedQueue) {
				System.out.println("Queue is full "+Thread.currentThread().getName()+"is waiting, Shared size "+sharedQueue.size());
				sharedQueue.wait();
			}
		}
		
		synchronized (sharedQueue) {
			sharedQueue.add(i);
			sharedQueue.notifyAll();
		}
	}
}

class Consumer implements Runnable{
	
	private final Vector sharedQueue;
	private int SIZE;
	
	public Consumer(Vector sharedQueue, int size){
		this.sharedQueue = sharedQueue;
		this.SIZE = size;
	}
	
	

	@Override
	public void run() {
		while (true){
			try{
				System.out.println("Consumed "+consume());
				Thread.sleep(50);
			}
			catch(InterruptedException ex){
				System.out.println("EX");
			}
		}
		
	}
	
	private int consume() throws InterruptedException{
		
		while(sharedQueue.isEmpty()){
			synchronized (sharedQueue) {
				System.out.println("Quueue is empty "+Thread.currentThread().getName()+" waiting, size "+sharedQueue.size());
				sharedQueue.wait();
			}
		}
		
		synchronized (sharedQueue) {
			sharedQueue.notifyAll();
			return (Integer)sharedQueue.remove(0);
		}
	}
}




