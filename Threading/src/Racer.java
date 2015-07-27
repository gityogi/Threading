
public class Racer implements Runnable {
	
	public static String winner;
	
	public void Race(){
		
		for(int distance = 1;distance<=100;distance++){
			System.out.println("Dist covered "+Thread.currentThread().getName()+"is "+distance+"mts");
			
			boolean isRaceWon = this.isRaceWon(distance);
			if(isRaceWon)
				break;
		}
	}

	public boolean isRaceWon(int totaldistance){
		boolean isRaceWon = false;
		
		if((Racer.winner == null )&&(totaldistance == 100)){
			String winnerName = Thread.currentThread().getName();
			Racer.winner = winnerName;
			System.out.println("Winner is "+Racer.winner);
			isRaceWon = true;
			
		}
		else if (Racer.winner == null)
			isRaceWon = false;
		else if (Racer.winner != null)
		{
			isRaceWon =true;
		}
	
		
		return isRaceWon;
		
	}
	@Override
	public void run() {
		this.Race();
		// TODO Auto-generated method stub
		
	}
	

}
