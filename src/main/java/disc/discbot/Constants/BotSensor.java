package disc.discbot.Constants;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import disc.discbot.Util.*;  

public final class BotSensor {
	
	//----------------------------------------------------------------------------
	//									Sensors
	//----------------------------------------------------------------------------
	//Tali triggers
	public final List<String> tali = Arrays.asList("Nerds");
	
	//Neutral face trigger
	public final List<String> neutral = Arrays.asList("😐");
	
	//Happy for you/sarcastic trigger
	public final List<String> happy4you = Arrays.asList("happy for you", "Happy for you", "Happy For You");
	
	//Array of possible offensive language
	public final List<String> profanity = Arrays.asList("fuck","shut", "gay", "nigger", "nigga", "bitch", "ass", "trash", "garbage"
			,"nig", "negroid", "loser", "suck", "dick", "btch", "sht", "shit", "fck", "finna", "weak", 
			"monkey", "useless", "fuckin", "fucking", "garb", "dumbass", "stupid", "dam", "ugly", "kick", "ban", "kicked", "banned",
			"mute", "muted", "remove", "removed", "bad");
	
	//Array of possible offensive dialogue
	//To be edited
	public final List<String> offensiveDialogue = Arrays.asList("fuck","shut", "gay", "nigger", "nigga", "bitch", "ass", "trash", "garbage"
			,"nig", "negroid", "loser", "suck", "dick", "btch", "sht", "shit", "fck", "finna", "weak", 
			"monkey", "useless", "fuckin", "fucking", "garb", "dumbass", "stupid", "dam", "ugly", "kick", "ban", "kicked", "banned",
			"mute", "muted", "remove", "removed", "bad");
							
	//Array of possible ways to refer to this specific bot
	public final List<String> botPronouns = Arrays.asList("totally normal attendant", "that bot", "ass bot", "weak bot", "stupid bot", 
			"trash bot", "garbage bot", "this bot", "dam bot", "damn bot", "fucking bot", "fuckin bot", "useless bot", "headass bot", "stinky bot", 
			"lame bot", "you bot", "garb bot", "dumbass bot", "ugly bot", "bitch bot", "attendant", "normal attendant");
	//----------------------------------------------------------------------------
	//								 Sensors [End]
	//----------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------
	//								   Responses
	//----------------------------------------------------------------------------
	//List of replies to trash talk towards bot
	//Currently holds multiple use cases that need to be branched out
	public final String [] botReply = {Emote.BRUH, "Fuck off", "you wot m8","Ok buddy",
			"stfu", "smd", "Calm down", "smh", "smh my head", "no u", "deleteMessage",
			Emote.CHAD, Emote.FUCKOFF, Emote.UNOREVERSE, ":)", ":(", Emote.DERP, ":neutral_face:"};
	
	//List of replies to trash talk towards My Hero Academia
	public final String [] botReplyMHA = {"Yes.", "Correct.", "Indeed.", "https://tenor.com/view/approve-deku-thumbs-up-mha-gif-20970173", "It is indeed a show of poor quality.", "Agreed.", "https://tenor.com/view/jim-and-pam-yes-gif-21499107",
			"https://tenor.com/view/correct-plankton-gif-14118231"};
	
	//List of replies to fate trash talk 
	public final String [] botReplyFate = {Emote.BOI, Emote.SMITH, Emote.ARMSTRONG, "Fate is actually good",
			"Fate is the greatest anime series of all times", "You probably too used to dog shit anime", "How to say you didn't watch fate without saying you didn't watch fate", 
			"Your opinion is invalid.", "Your opinion is irrelevant actually", "You're a joke", "Nah.", Emote.FUCKOFF, "Fate is actually good though", Emote.UNOREVERSE,
			"no u", "Clown", "Clown mentality", "Actual clown opinion", "Goofy", "The series went over your head, its okay", "The series is too complex for your small little brain qq", 
			"Unfortunately for you, to appreciate the series the viewer requires at least 3 minimum IQ.", "READ THE VN", "Have you tried watching the anime",
			"Have you actually tried watching the anime though", "You don't know what you're saying.", "You simply lack the required brain cells to properly enjoy the series.", 
			"Logically, this would be bait, but it's also possible that you may have suffered from a tramutic brain injury.", 
			"Logically this must be bait.", "B8", "Did you know according to statistics, approximately 9/10 fate haters have suffer from some form of chronic brain disease? Symptoms include...\n Speech Diffulty (Such as; Being unable to form proper, coherent sentences), Numbness (Dullness in the brain and problems with Concentraion), and Memory Loss.",
			"Fate is peak.", "Fate is actually a great series that deconstructs the hero of justice trope masterfully.", "Fate is a good shounen actually", "You're only used to watching bad shounens I see", Emote.ASTOLFGUN,
			"You're only used to watching garbage, understandable.", "You're a funny guy", "Delusional.", "Silence mongrel.", "The lack of brain cells being exuded in this chat is exquisite", Emote.DERP,
			Emote.WAITS, ":neutral_face:", "deleteMessage"};
				
	
	//List of replies to Frigg using Gavin
	public final String [] botReplyFrigg = {Emote.GAVIN, "", "deleteMessage", "https://tenor.com/view/slap-in-the-face-angry-gtfo-bitc-bitch-slap-gif-15667197",
			Emote.BOI, Emote.SMITH, Emote.WAITS, "no u", Emote.UNOREVERSE, ":neutral_face:", "https://tenor.com/view/punch-beat-up-pogger-gif-22865694",
			"https://tenor.com/view/spongebob-kill-yourself-kys-gif-21429491", "https://tenor.com/view/mean-kill-you-kys-gif-22888869", "https://tenor.com/view/someday-spongebob-not-today-gif-25411607",
			"How original", Emote.DERP};
	
	
	//List of replies to gay sht
	public final String [] botReplyGay = {"gay", "Can I get a kiss too?", "Stop gay", Emote.WEGAY};
	
	//List of replies to talia
	//have to get her role or username for implementation
	public final String [] botReplyTali = {"Shut up Tali", ":neutral_face:", "no u", Emote.UNOREVERSE};
	
	//List of replies to Happy for you
	public final String [] botReplyHappy = {"deleteMessage", "He's not actually happy for you.", "https://tenor.com/view/doubt-press-x-press-la-noire-gif-18717264"};
	
	//List of replies to neutral emoji
	public final String [] botReplyNeutral = {"deleteMessage","deleteMessage", ":neutral_face:", "", "", "", "", Emote.NOTMAD, "https://tenor.com/view/kanye-stare-lmao-neutral-face-not-funny-gif-23051909"};
	
	//Emoji specific responses
	public final Map<String, String> emojiResp = Stream.of(new String[][]{
        {":gavin:", botReplyFrigg[RandomGen.respGen(botReplyFrigg.length)]},
        {":wegay:", botReplyGay[RandomGen.respGen(botReplyGay.length)]}
		}).collect(Collectors.toMap(p -> p[0], p -> p[1]));
		
	//----------------------------------------------------------------------------
	//								 Responses [End]
	//----------------------------------------------------------------------------
	public final String [] botRequest = {"@Totally Normal Attendant Set emoji", "@Totally Normal Attendant Make emoji"};
	
	//add case for neutral face
}
