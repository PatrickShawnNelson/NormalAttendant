package Interpretors;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import Constants.BotSensor;
import Util.RandomGen;
import net.dv8tion.jda.api.utils.FileUpload;

public class BotInterpretor {
	BotSensor sensor = new BotSensor();
	
	//This method will determine if offensive language towards the bot has occurred	
	public String botReactions (String [] messageArray, String message) {
	
		for (int pronouns = 0; pronouns < sensor.botPronouns.size(); pronouns++) {
			//Iterate through the list of pronouns and the message to determine if the bot is being referenced
			if (message.contains(sensor.botPronouns.get(pronouns))) {
				//Iterate through the list of offensive language
				for (int i = 0; i < messageArray.length; i++) {
					//Iterate through each word to determine if the bot is being insulted
					if (sensor.profanity.contains(messageArray[i].toLowerCase()))
					{
						return sensor.botReply[RandomGen.respGen(sensor.botReply.length)];	
					}	
					//return message;
				}//end of messageArray.length for loop
			}//end of message.contains for loop
		}//end of pronouns for loop
		 return "";
	}//end of botReactions method
}
