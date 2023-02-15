package Interpretors;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import Constants.Emotes;
import Constants.RandomResponseGen;
import net.dv8tion.jda.api.utils.FileUpload;

public class BotInterpretor {
	Emotes emote = new Emotes();
	RandomResponseGen rg = new RandomResponseGen();
		
	public String botReactions (String [] messageArray, String message) {
	
		String [] botReply = {emote.BRUH, "Fuck off nigga", "And you ain't shit", "What you say nigga", "And you still ain't shit",
				"Quiet little bitch nigga", "Suck my dick", "Quiet little bitch", "You're not shit", "Calm that down", "Calm down",
				emote.CHAD};
	
		return botReply[rg.randomGenerator(botReply.length)];	
	}
}
