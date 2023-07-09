package events;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.validation.constraints.NotNull;

import Constants.BotSensor;
import Constants.Emoji;
import Constants.Emote;
import Constants.Role;
import Interpretors.BotInterpretor;
import Interpretors.ImageInterpretor;
import Interpretors.MemberInterpretor;
import disc.discbot.test;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Message.Attachment;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;
import scalr.Scalr;

public class MessageListener extends ListenerAdapter{
	//Random number generator
	static Random rand = new Random();
	static int frigCounter = 0;
	static ArrayList<String> messages = new ArrayList<String>();
	
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
		//System.out.println(botSense.botReplyFrigg.length + 0);
		if(event.getAuthor().isBot()) {
			return;
		}
		else {
			System.out.println(event.getMember().getNickname() + ": " + event.getMessage().getContentDisplay());
			System.out.println(event.getMember().getNickname() + "'s Roles: " + roles);
			System.out.println(event.getAuthor());
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
		
		//Frigg
		if((roles.contains(Role.FRIGG))) { 
		if(message.contains(Emoji.GAVIN)|| message.contains(Emoji.GAVIN2)){
			String friggReaction = mI.friggReactions();
			frigCounter++;
			if (friggReaction.contains(Emote.EMOTEDESTINATION)){
				File emoteLocation = new File(""+ friggReaction);
				event.getChannel().sendFiles(FileUpload.fromData(emoteLocation)).queue();
			}
			else {
				if (frigCounter >= 5) {
					//Say it in caps
					event.getChannel().sendMessage(mI.friggReactions().toUpperCase()).queue();
					if (frigCounter >= 8) {
						frigCounter = 0;
					}
				}
				else {
					event.getChannel().sendMessage(mI.friggReactions()).queue();
				}
			}
		}
		}//Frigg end
		
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
		}
		else if (botReaction == ""){
			//System.out.println("nothing happens");
		}
		else {
			event.getChannel().sendMessage(botReaction).queue();
		}		
		//----------------------------------------------------------------------------
		//								Bot Reactions [End]
		//----------------------------------------------------------------------------
		//----------------------------------------------------------------------------
		//							  	Emoji Creation
		//----------------------------------------------------------------------------
		//Set Emoji
		//Bot reads for these exact words before conducting processing
		if (message.equalsIgnoreCase("@Based East Side Slave Set emoji")) {
			
			//Retrieves the list of attachments on that message
			List<Attachment> messageImage = (event.getMessage().getAttachments());
			
			//Stores it to drive and announces response
			event.getChannel().sendMessage(iI.setImage(messageImage)).queue();
		}
		
		//Make Emoji
		//Bot reads for these exact words before conducting processing
		if (message.equalsIgnoreCase("@Based East Side Slave Make emoji")) {
			
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
