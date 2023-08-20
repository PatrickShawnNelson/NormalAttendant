package disc.discbot.Util;

import java.util.Random;

public final class RandomGen {
	//Random number generator
	static Random rand = new Random();
	
	//Returns the length of each reply
	public static int respGen (int responseSize) {
		
		int randomResponse = rand.nextInt(responseSize);
		
		return randomResponse;
		//prob remove this, does not achieve anything lol
	}
	
}
