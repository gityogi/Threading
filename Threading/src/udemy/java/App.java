package udemy.java;

public class App {
	
	private int count = 0;

	public synchronized void add(){
		count++;
	}
	
	public void doWork(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<1000;i++)
					add();
				
			}
			
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<1000;i++)
					add();
				
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Value : "+count);
	}
	public static void main(String args[]){
		/*App app = new App();
		app.doWork();*/
				
		new Worker().main();
		
	}
}
