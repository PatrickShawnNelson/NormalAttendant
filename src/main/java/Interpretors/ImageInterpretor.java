package Interpretors;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import Constants.Emote;
import disc.discbot.test;
import net.dv8tion.jda.api.entities.Message.Attachment;
import net.dv8tion.jda.api.utils.FileUpload;
import scalr.Scalr;

public class ImageInterpretor {
	//----------------------------------------------------------------------------
	//							  	Set Emoji
	//----------------------------------------------------------------------------
	public String setImage(List<Attachment> messageImage) {
		try {
			
			//Looping through several attachments
			for (Attachment attachment:messageImage) {
				//attachment = messageImage.get(i);
				
				//Downloads the attachment
				attachment.downloadToFile(Emote.EMOTEDESTINATION + attachment.getFileName())
				.thenAccept(file -> System.out.println("Saved attachment to " + file.getName()))
				.exceptionally(t ->
				{ // handle failure
					t.printStackTrace();
					return null;
				});
			}
			
			//Confirms the saving of the attachment
			return "Sure, saving the image(s) to my drive.";
			}
		catch (Exception e) {
			return "How about you attach an image to set? Dumbass";
		}
		
	}
	//----------------------------------------------------------------------------
	//							Set Emoji[End]
	//----------------------------------------------------------------------------
	//----------------------------------------------------------------------------
	//							  Make Emoji
	//----------------------------------------------------------------------------
	public String makeImage(Attachment attachment, File file) {
		try {
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
			test.removeBG(file.toString());
			System.out.println(file.toString());
			//Upload attachment
				
			System.out.println("looking good");
			//Confirms that it recognizes the attachment
			return "Sure, here is your emoji(s).";
			}
		catch (Exception e) {
			return "This is where you reference the emoji(s) you've previously set.";
			}
	//----------------------------------------------------------------------------
	//						   Make Emoji[End]
	//----------------------------------------------------------------------------
		}
	}
