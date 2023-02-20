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
import Interpretors.MemberInterpretor;
import net.dv8tion.jda.api.entities.Message.Attachment;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;
import scalr.Scalr;

public class MessageListener extends ListenerAdapter{
	//Random number generator
	static Random rand = new Random();
	
	@SuppressWarnings({ "unlikely-arg-type", "deprecation", "unused" })
	@Override
	public void onMessageReceived(@NotNull MessageReceivedEvent event) {
		super.onMessageReceived(event);
		//----------------------------------------------------------------------------
		//								Imports
		//----------------------------------------------------------------------------
		BotInterpretor bI = new BotInterpretor();
		MemberInterpretor mI = new MemberInterpretor();
		BotSensor botSense = new BotSensor();
		//----------------------------------------------------------------------------
		//							 Imports [End]
		//----------------------------------------------------------------------------
		
		//----------------------------------------------------------------------------
		//								  Logs
		//----------------------------------------------------------------------------
		String message = (event.getMessage().getContentDisplay()).toString();
		String roles = (event.getMember().getRoles()).toString();
		
		if(event.getAuthor().isBot()) {
			return;
		}
		else {
			System.out.println(event.getMember().getNickname() + ": " + event.getMessage().getContentDisplay());
			System.out.println(event.getMember().getNickname() + "'s Roles: " + roles);
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
			event.getChannel().sendMessage(mI.friggReactions()).queue();
		}
		}//Frigg end
		
		if(message.contains(Emoji.WEGAY)){
			event.getChannel().sendMessage(mI.wegayReactions()).queue();
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
		String imageStore = "C:/Users/Shoji/OneDrive/Documents/emojis/";
		//Set emoji
		
		//Bot reads for these exact words before conducting processing
		if (message.equalsIgnoreCase("@Based East Side Slave Set emoji")) {
			
			try {
				//Retrieves the list of attachments on that message
				List<Attachment> messageImage = (event.getMessage().getAttachments());
			
				//Looping through several attachments
				for (Attachment attachment:messageImage) {
					//attachment = messageImage.get(i);
					
					//Downloads the attachment
					attachment.downloadToFile(imageStore + attachment.getFileName())
					.thenAccept(file -> System.out.println("Saved attachment to " + file.getName()))
					.exceptionally(t ->
					{ // handle failure
						t.printStackTrace();
						return null;
					});
				}
				
				//Confirms the saving of the attachment
				event.getChannel().sendMessage("Sure, saving the image(s) to my drive.").queue();
				}
			catch (Exception e) {
				event.getChannel().sendMessage("How about you attach an image to set? Dumbass").queue();
			}

		}
		//Make emoji
		//Bot reads for these exact words before conducting processing
		if (message.equalsIgnoreCase("@Based East Side Slave Make emoji")) {
			
			try {
				//Reads the attachment to reference
				List<Attachment> messageImage = (event.getMessage().getAttachments());
				
				//Looping through several attachments
				for (Attachment attachment:messageImage) {
					//Attachment attachment = messageImage.get(0);
					
					//Searches for the attachment in the drive
					File file = new File(imageStore + attachment.getFileName());
				
					BufferedImage bImage = null;

					System.out.println(file);
					//Retrieves the attachment
					bImage = ImageIO.read(file);
					System.out.println("retrieved file");
					
		        	//Resizes it
					BufferedImage newBImage = Scalr.resize(bImage, 128);
					
					//File newfile = new File(imageStore + "new.png"); 
					//Saves the attachment with its new size
					ImageIO.write(newBImage, attachment.getFileExtension(), new File(""+file));

					//event.getChannel().sendMessage("Retrieving from: " + newfile).queue();
					
					//Upload attachment
					event.getChannel().sendFiles(FileUpload.fromData(file)).queue();
					System.out.println("looking good");
				}
				//Confirms that it recognizes the attachment
				event.getChannel().sendMessage("Sure, here is your emoji(s).").queue();
				
				}
			catch (Exception e) {
				event.getChannel().sendMessage("This is where you reference the emoji(s) you've previously set.").queue();
			}
	         
		}
		//----------------------------------------------------------------------------
		//							  	Emoji Creation [End]
		//----------------------------------------------------------------------------
		
	}
}
