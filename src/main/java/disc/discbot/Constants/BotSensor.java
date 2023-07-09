package Constants;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Util.RandomGen;  

public final class BotSensor {
	
	//Array of possible offensive language
	public final List<String> profanity = Arrays.asList("fuck","shut", "gay", "nigger", "nigga", "bitch", "ass", "trash", "garbage"
			,"nig", "negroid", "loser", "suck", "dick", "btch", "sht", "shit", "fck", "finna", "weak", 
			"monkey", "useless", "fuckin", "fucking", "garb", "dumbass", "stupid", "dam", "ugly");
							
	//Array of possible ways to refer to this specific bot
	public final List<String> botPronouns = Arrays.asList("east side slave", "that bot", "ass bot", "weak bot", "stupid bot", 
			"trash bot", "garbage bot", "this bot", "dam bot", "damn bot", "fucking bot", "fuckin bot", "useless bot", 
			"lame bot", "you bot", "garb bot", "dumbass bot", "ugly bot", "bitch bot");
	
	//List of replies to trash talk towards bot
	public final String [] botReply = {Emote.BRUH, "Fuck off nigga", "And you ain't shit", "What you say nigga", "And you still ain't shit",
			"Quiet little bitch nigga", "Suck my dick", "Quiet little bitch", "You're not shit", "Calm that down", "Calm down",
			Emote.CHAD, Emote.FUCKOFF};
	
	//List of replies to Frigg using Gavin
	public final String [] botReplyFrigg = {Emote.GAVIN,"This server seriously needs to give me permissions to remove that shit",
			"Someone needs to remove this shit", "You still using that damn emote", "Man Frigg, shut your dumbass up", 
			"Obnoxious ass emote", "dog ass emote", "annoying ass emote", "trash ass emote", "What if I told you that there are other emotes for you to use in this server?",
			"Did you know that there are other emotes for you to choose from?", "Stop using that fucking emote", "We need to ban that emote",
			"You are actually an annoying ass nigga", "Give it up my guy", "Don't you get tired of using that", "Use something else",
			"Say something else", "There are other emotes for you to choose from you negroid", "You can use another emote btw", Emote.ARMSTRONG, Emote.STOPIT,
			Emote.BEATASS, "You're such a fucking loser", "Give it up nigga", "Why isn't this shit removed", "Why is this shit still in the server",
			"A literal plague to the server", "Someone bout to come here and remove either me or that emote", "If the server removes me that emote better be next", 
			Emote.BOI, Emote.SMITH, Emote.WAITS, "Stop using that shit"};
	
	//List of replies to gay sht
	public final String [] botReplyGay = {"Cut that gay shit out man", "Can I get a kiss too?", "Stop gay", Emote.WEGAY};
	
	public final Map<String, String> emojiResp = Stream.of(new String[][]{
        {":gavin:", botReplyFrigg[RandomGen.respGen(botReplyFrigg.length)]},
        {":wegay:", botReplyGay[RandomGen.respGen(botReplyGay.length)]}
		}).collect(Collectors.toMap(p -> p[0], p -> p[1]));
		
	
	public final String [] botRequest = {"@Based East Side Slave Set emoji", "@Based East Side Slave Make emoji"};
	
}
