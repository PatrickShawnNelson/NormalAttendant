package Constants;

import java.util.Arrays;
import java.util.List;

public final class BotSensor {

	//Array of possible offensive language
	public static final List<String> profanity = Arrays.asList("fuck","shut", "gay", "nigger", "nigga", "bitch", "ass", "trash", "garbage"
			,"nig", "negroid", "loser", "suck", "dick", "btch", "sht", "shit", "fck", "finna", "weak", 
			"monkey", "useless", "fuckin", "fucking", "garb", "dumbass", "stupid", "dam", "ugly");
							
	//Array of possible ways to refer to this specific bot
	public static final List<String> botPronouns = Arrays.asList("east side slave", "that bot", "ass bot", "weak bot", "stupid bot", 
			"trash bot", "garbage bot", "this bot", "dam bot", "damn bot", "fucking bot", "fuckin bot", "useless bot", 
			"lame bot", "you bot", "garb bot", "dumbass bot", "ugly bot");
}
