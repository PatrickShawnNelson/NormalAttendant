package disc.discbot.Interpretors;

import disc.discbot.Constants.BotSensor;
import disc.discbot.Util.RandomGen;

public class BotInterpretor {
	BotSensor sensor = new BotSensor();
	
	//This method will determine if offensive language towards the bot has occurred	
	public String botReactions (String [] messageArray, String message) {
	//----------------------------------------------------------------------------
	//								Fate Insults
	//----------------------------------------------------------------------------
		for (int pronouns = 0; pronouns < sensor.botPronouns.size(); pronouns++) {
			//Iterate through the list of pronouns and the message to determine if the bot is being referenced
			if (message.contains("fate") || message.contains("FATE") || message.contains("Fate")) {
				//Iterate through the list of offensive language
				for (int i = 0; i < messageArray.length; i++) {
					//Iterate through each word to determine if the bot is being insulted
					if (sensor.profanity.contains(messageArray[i].toLowerCase()))
					{
						return sensor.botReplyFate[RandomGen.respGen(sensor.botReplyFate.length)];	
					}	
					//return message;
				}//end of messageArray.length for loop
			}//end of message.contains for loop
		}//end of pronouns for loop
	//----------------------------------------------------------------------------
	//								Fate Insults [End]
	//----------------------------------------------------------------------------
		
	//----------------------------------------------------------------------------
	//									Happy for you
	//----------------------------------------------------------------------------
		for (int pronouns = 0; pronouns < sensor.happy4you.size(); pronouns++) {
			//Iterate through the list of pronouns and the message to determine if the bot is being referenced
			if (message.contains(sensor.happy4you.get(pronouns))) {
				//Iterate through the list of offensive language
				for (int i = 0; i < messageArray.length; i++) {
					//Iterate through each word to determine if the bot is being insulted
					if (message.contains(sensor.happy4you.get(pronouns)))
					{
						return sensor.botReplyHappy[RandomGen.respGen(sensor.botReplyHappy.length)];	
					}	
					//return message;
				}//end of messageArray.length for loop
			}//end of message.contains for loop
		}//end of pronouns for loop
	//----------------------------------------------------------------------------
	//								  Happy for you [End]
	//----------------------------------------------------------------------------	

	//----------------------------------------------------------------------------
	//									Neutral
	//----------------------------------------------------------------------------
		for (int pronouns = 0; pronouns < sensor.neutral.size(); pronouns++) {
			//Iterate through the list of pronouns and the message to determine if the bot is being referenced
			if (message.equalsIgnoreCase(sensor.neutral.get(pronouns))) {
				//Iterate through the list of offensive language
				
						return sensor.botReplyNeutral[RandomGen.respGen(sensor.botReplyNeutral.length)];	
					}	
					//return message;
				}//end of messageArray.length for loop
			//end of message.contains for loop
		//end of pronouns for loop
	//----------------------------------------------------------------------------
	//								  Neutral [End]
	//----------------------------------------------------------------------------	
		
	//----------------------------------------------------------------------------
	//								MHA Insults
	//----------------------------------------------------------------------------
		for (int pronouns = 0; pronouns < sensor.botPronouns.size(); pronouns++) {
			//Iterate through the list of pronouns and the message to determine if the bot is being referenced
			if (message.contains("MHA") || message.contains("mha") || message.contains("My Hero Academia")) {
				//Iterate through the list of offensive language
				for (int i = 0; i < messageArray.length; i++) {
					//Iterate through each word to determine if the bot is being insulted
					if (sensor.profanity.contains(messageArray[i].toLowerCase()))
					{
						return sensor.botReplyMHA[RandomGen.respGen(sensor.botReplyMHA.length)];	
					}	
					//return message;
				}//end of messageArray.length for loop
			}//end of message.contains for loop
		}//end of pronouns for loop
	//----------------------------------------------------------------------------
	//								MHA Insults [End]
	//----------------------------------------------------------------------------
		
	//----------------------------------------------------------------------------
	//								Bot Insults
	//----------------------------------------------------------------------------
		for (int pronouns = 0; pronouns < sensor.botPronouns.size(); pronouns++) {
			//Iterate through the list of pronouns and the message to determine if the bot is being referenced
			if (message.contains(sensor.botPronouns.get(pronouns)) || message.equalsIgnoreCase("People die when they are killed") 
					|| message.equalsIgnoreCase("People die when they're killed") || message.equalsIgnoreCase("People die when theyre killed") 
					|| message.contains("midland") || message.contains("Midland") || message.contains("MIDLAND") || message.contains("mid land")) {
				//Iterate through the list of offensive language
				for (int i = 0; i < messageArray.length; i++) {
					//Iterate through each word to determine if the bot is being insulted
					//Note: make unique case for shirou quotes
					if (sensor.profanity.contains(messageArray[i].toLowerCase()) || message.equalsIgnoreCase("People die when they are killed")
							|| message.equalsIgnoreCase("People die when they're killed") || message.equalsIgnoreCase("People die when theyre killed")
							|| message.contains("midland") || message.contains("Midland") || message.contains("MIDLAND") || message.contains("mid land"))
					{
						return sensor.botReply[RandomGen.respGen(sensor.botReply.length)];	
					}	
					//return message;
				}//end of messageArray.length for loop
			}//end of message.contains for loop
		}//end of pronouns for loop
	//----------------------------------------------------------------------------
	//								Bot Insults [End]
	//----------------------------------------------------------------------------
		 return "";
	}//end of botReactions method
	
}
