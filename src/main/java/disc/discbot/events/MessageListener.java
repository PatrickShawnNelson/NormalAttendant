package disc.discbot.events;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jetbrains.annotations.NotNull;

import disc.discbot.Constants.BotSensor;
import disc.discbot.Constants.Emoji;
import disc.discbot.Constants.Emote;
import disc.discbot.Constants.Role;
import disc.discbot.Interpretors.BotInterpretor;
import disc.discbot.Interpretors.ImageInterpretor;
import disc.discbot.Interpretors.MemberInterpretor;
import disc.discbot.Util.LoggerObject;
import net.dv8tion.jda.api.entities.Message.Attachment;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;

public class MessageListener extends ListenerAdapter{
	//Random number generator
	static Random rand = new Random();
	static int frigCounter = 0;
	static ArrayList<String> messages = new ArrayList<String>();
	LoggerObject messageLogs = new LoggerObject();
	
	@SuppressWarnings({ "unlikely-arg-type", "deprecation", "unused" })
	@Override
	public void onMessageReceived(@NotNull MessageReceivedEvent event) {
		super.onMessageReceived(event);
		//----------------------------------------------------------------------------
		//								Imports
		//----------------------------------------------------------------------------
		BotInterpretor bI = new BotInterpretor();
		MemberInterpretor mI = new MemberInterpretor();
		ImageInterpretor iI = new ImageInterpretor();
		BotSensor botSense = new BotSensor();
		//----------------------------------------------------------------------------
		//							 Imports [End]
		//----------------------------------------------------------------------------

		//----------------------------------------------------------------------------
		//								  Logs
		//----------------------------------------------------------------------------
		String message = (event.getMessage().getContentDisplay()).toString();
		String roles = (event.getMember().getRoles()).toString();
		String users = (event.getMember().getUser().toString());
		String guild = (event.getGuild().getName().toString());
		String messageID = (event.getMessageId());
		String channel = (event.getChannel().getName());
		
		messageLogs.LoggerObjectConfig((Emote.RESOURCES + "Guilds/" + guild +"/"+ channel),  "messageLog.log");
		//LoggerObject messageIDLogs = new LoggerObject((Emote.RESOURCES + "Guilds/" + guild +"/"+ channel),  "messageIDLog.txt");
		messageLogs.logger.setLevel(Level.INFO);
		
		
		//System.out.println(botSense.botReplyFrigg.length + 0);
		if(event.getAuthor().isBot()) {
			return;
		}
		else {
			messageLogs.logger.info(event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());
			//messageLogs.logger.info(event.getAuthor().getName() + "'s Roles: " + roles);
			//messageIDLogs.logger.info(messageID);
			
		//----------------------------------------------------------------------------
		//							 Delete Messages
		//----------------------------------------------------------------------------
			//As long as the messages don't exceed 50, add it to the list of messages
			if (messages.size() <= 50) {
				messages.add(event.getMessageId());
			}
			//If list of messages exceeds acceptable threshold, remove the first message from the list
			else if(messages.size() >= 50) {
				messages.remove(0);
				messages.add(event.getMessageId());
			}
		//----------------------------------------------------------------------------
		//						  Delete Messages [End]
		//----------------------------------------------------------------------------
			//Shojiki(id=239584033426767874)
			//Co(id=190239284123533312)
			//System.out.println("Activity: " + event.getMessage().getActivity());
			//System.out.println(event.getGuild().getRoles());
		}
		//----------------------------------------------------------------------------
		//							   Logs [End]
		//----------------------------------------------------------------------------
		
		//----------------------------------------------------------------------------
		//								Message Reactions
		//----------------------------------------------------------------------------
		/*These responses will be printed X the amount of times the program has been run 
		without restarting the Client/Stopping APP before running it again.*/
		//Tali
		/*if (users.contains("taliaem")) {
			
		}*/
		//Frigg
		if((roles.contains(Role.FRIGG))) { 
		if(message.contains(Emoji.GAVIN)|| message.contains(Emoji.GAVIN2)|| message.contains("download_15.jpg")){
			String friggReaction = mI.friggReactions();
			boolean exit = false;
			frigCounter++;
			if (friggReaction.contains(Emote.EMOTEDESTINATION)){
				File emoteLocation = new File(""+ friggReaction);
				event.getChannel().sendFiles(FileUpload.fromData(emoteLocation)).queue();
				if (friggReaction.contains("derp.png")) {
					event.getChannel().sendMessage("This you??").queue();
					
				}
			}
			else if (friggReaction.contains("deleteMessage")) {
				event.getMessage().delete().queue();
			}
			else {
				if (frigCounter >= 20) {
					//Say it in caps
					//event.getChannel().sendMessage(mI.friggReactions().toUpperCase()).queue();
					event.getChannel().sendMessage("We riding gavin till it dies.").queue();
					event.getChannel().sendTyping().queue();
					
					File emoteLocation = new File(""+ Emote.GAVIN);
					while (frigCounter >= 4) {
						for (int i = 0; i < 4; i++) {
							event.getChannel().sendFiles(FileUpload.fromData(emoteLocation)).queue();
							frigCounter++;
						}
						
						event.getChannel().sendTyping().queue();
						event.getChannel().sendMessage("GARBAGE").queue();
						event.getChannel().sendTyping().queue();
						
						for (int i = 0; i < 6; i++) {
							event.getChannel().sendFiles(FileUpload.fromData(emoteLocation)).queue();
							frigCounter++;
						}
						event.getChannel().sendTyping().queue();
						event.getChannel().sendMessage("ASS").queue();
						event.getChannel().sendTyping().queue();
						
						for (int i = 0; i < 10; i++) {
							event.getChannel().sendFiles(FileUpload.fromData(emoteLocation)).queue();
							frigCounter++;
						}
						event.getChannel().sendTyping().queue();
						event.getChannel().sendMessage("EMOTE").queue();
						event.getChannel().sendTyping().queue();
						
						event.getChannel().sendMessage("```This bot has been terminated```").queue();
						if (frigCounter >= 20) {
							frigCounter = -20;
						}
						
						//if (frigCounter >= 8) {
							//frigCounter = 0;
						//}
					}
					
				}// Include case where at certain negative values, it ignores frig
				else {
					event.getChannel().sendMessage(mI.friggReactions()).queue();
				}
			}
		}
		}//Frigg end
		
		//Gay emote
		if(message.contains(Emoji.WEGAY)){
			String gayReaction = mI.wegayReactions();
			
			if (gayReaction.contains(Emote.EMOTEDESTINATION)){
				File emoteLocation = new File(""+ gayReaction);
				event.getChannel().sendFiles(FileUpload.fromData(emoteLocation)).queue();
			}
			else {
				event.getChannel().sendMessage(mI.wegayReactions()).queue();
			}
		}
		
		if((roles.contains(Role.SHOJIKI))) {
			//after a certain amount of characters un-interrupted, utter a response
		}
		//----------------------------------------------------------------------------
		//							  Message Reactions [End]
		//----------------------------------------------------------------------------
		
		//----------------------------------------------------------------------------
		//								Bot Reactions
		//----------------------------------------------------------------------------
		//Breaks up the message into individual words
		String [] messageArray = message.split(" ");
		
		String lMessage = message.toLowerCase();
		//This method will determine if offensive language towards the bot has occurred
		String botReaction = bI.botReactions(messageArray, lMessage);
		
		if (botReaction.contains(Emote.EMOTEDESTINATION)){
			File emoteLocation = new File(""+ botReaction);
			event.getChannel().sendFiles(FileUpload.fromData(emoteLocation)).queue();
			
			if (botReaction.contains("derp.png")) {
				event.getMessage().reply("This you??").queue();
				
			}
			
			if (botReaction.contains("notmad.png")) {
				event.getChannel().sendTyping();
				event.getMessage().reply("https://tenor.com/view/crying-black-guy-meme50fps-interpolated-interpolated-crying-black-guy-crying-crying-black-guy-gif-23747218").queue();
				
			}
			
		}
		else if (botReaction == ""){
			//System.out.println("nothing happens");
			
		} else if (botReaction.contains("deleteMessage")) {
			event.getMessage().delete().queue();
		}
		else {
			event.getMessage().reply(botReaction).queue();
		}		
		//----------------------------------------------------------------------------
		//								Bot Reactions [End]
		//----------------------------------------------------------------------------
		
		//----------------------------------------------------------------------------
		//							  	Emoji Creation
		//----------------------------------------------------------------------------
		//Set Emoji
		//Bot reads for these exact words before conducting processing
		if (message.equalsIgnoreCase("Attendant" + /*event.get*/ " Set emoji")) {
			
			//Retrieves the list of attachments on that message
			List<Attachment> messageImage = (event.getMessage().getAttachments());
			
			//Stores it to drive and announces response
			event.getChannel().sendMessage(iI.setImage(messageImage)).queue();
		}
		
		//Make Emoji
		//Bot reads for these exact words before conducting processing
		if (message.equalsIgnoreCase("Attendant Make emoji")) {
			
			//Reads the attachment to reference
			List<Attachment> messageImage = (event.getMessage().getAttachments());
			
			//Looping through several attachments
			for (Attachment attachment:messageImage) {
				//Searches for the attachment in the drive
				File file = new File(Emote.EMOTEDESTINATION + attachment.getFileName());
				
				//Removes bg, resizes it to emoji standard and announces response	
				event.getChannel().sendMessage(iI.makeImage(attachment, file)).queue();
				
				//Upload attachment
				event.getChannel().sendFiles(FileUpload.fromData(file)).queue();
			}
		}
		//----------------------------------------------------------------------------
		//							  	Emoji Creation [End]
		//----------------------------------------------------------------------------
	}
}
