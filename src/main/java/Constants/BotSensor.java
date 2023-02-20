package Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import Util.RandomGen;

import static java.util.Map.entry;  

public final class BotSensor {
	
	//Array of possible offensive language
	public final List<String> profanity = Arrays.asList("fuck","shut", "gay", "nigger", "nigga", "bitch", "ass", "trash", "garbage"
			,"nig", "negroid", "loser", "suck", "dick", "btch", "sht", "shit", "fck", "finna", "weak", 
			"monkey", "useless", "fuckin", "fucking", "garb", "dumbass", "stupid", "dam", "ugly");
							
	//Array of possible ways to refer to this specific bot
	public final List<String> botPronouns = Arrays.asList("east side slave", "that bot", "ass bot", "weak bot", "stupid bot", 
			"trash bot", "garbage bot", "this bot", "dam bot", "damn bot", "fucking bot", "fuckin bot", "useless bot", 
			"lame bot", "you bot", "garb bot", "dumbass bot", "ugly bot", "bitch bot");
	
	public final String [] botReply = {Emote.BRUH, "Fuck off nigga", "And you ain't shit", "What you say nigga", "And you still ain't shit",
			"Quiet little bitch nigga", "Suck my dick", "Quiet little bitch", "You're not shit", "Calm that down", "Calm down",
			Emote.CHAD};
	
	public final String [] botReplyFrigg = {Emote.GAVIN,"This server literally gave me permissions to remove that shit",
			"I will remove that shit", "You still using that damn emote", "Man Frigg, shut your dumbass up", 
			"Literally the worst emote in the server",
			};
	
	public final String [] botReplyGay = {"Cut that gay shit out man", "Can I get a kiss too?", "Stop gay"};
	
	public final Map<String, String> emojiResp = Map.ofEntries(
		    entry(":gavin:", botReplyFrigg[RandomGen.respGen(botReplyFrigg.length)]),
		    entry(":wegay:", botReplyGay[RandomGen.respGen(botReplyGay.length)])
		);
	
	public final String [] botRequest = {"@Based East Side Slave Set emoji", "@Based East Side Slave Make emoji"};
	
}
