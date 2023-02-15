package Constants;

import java.util.Random;

public final class RandomResponseGen {
	//Random number generator
	static Random rand = new Random();
	
	//Returns the length of each reply
	public static int randomGenerator (int responseSize) {
		
		int randomResponse = rand.nextInt(responseSize);
		
		return randomResponse;
		//prob remove this, does not achieve anything lol
	}
	
}
