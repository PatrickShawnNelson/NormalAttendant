package disc.discbot.Interpretors;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import disc.discbot.test;
import disc.discbot.Constants.AttendantTV;
import disc.discbot.Constants.Emote;
import disc.discbot.Util.S3StorageTest;
import disc.discbot.Util.VideoStorage;
import disc.discbot.scalr.Scalr;
import net.dv8tion.jda.api.entities.Message.Attachment;

public class ImageInterpretor {
	VideoStorage vs = new VideoStorage();
	//S3StorageTest s3 = new S3StorageTest();
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
			return "How about you attach an image to set?";
		}
		
	}
	//----------------------------------------------------------------------------
	//							Set Emoji[End]
	//----------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------
	//							  Make Emoji No BG
	//----------------------------------------------------------------------------
	public String makeImage(Attachment attachment, File file) {
		try {
			BufferedImage bImage = null;

			System.out.println(file);
			//Retrieves the attachment
			bImage = ImageIO.read(file);
			System.out.println("retrieved file");
				
	        //Resizes it
			BufferedImage newBImage = Scalr.resize(bImage, 128, 128);
				
			//File newfile = new File(imageStore + "new.png"); 
			//Saves the attachment with its new size
			ImageIO.write(newBImage, attachment.getFileExtension(), new File(""+file));

			//event.getChannel().sendMessage("Retrieving from: " + newfile).queue();
			test.removeBG(file.toString());
			//System.out.println(file.toString());
			//Upload attachment
				
			System.out.println("looking good");
			//Confirms that it recognizes the attachment
			return "Sure, here is your emoji(s).";
			}
		catch (Exception e) {
			return "Having trouble determining the background of this image however I've still managed to resize it to the emoji standard.";
			}
	//----------------------------------------------------------------------------
	//						   Make Emoji No BG[End]
	//----------------------------------------------------------------------------
		}
	//----------------------------------------------------------------------------
	//							  Make Emoji
	//----------------------------------------------------------------------------
	public String makeImageBG(Attachment attachment, File file) {
		try {
			BufferedImage bImage = null;

			System.out.println(file);
			//Retrieves the attachment
			bImage = ImageIO.read(file);
			System.out.println("retrieved file");
				
	        //Resizes it
			BufferedImage newBImage = Scalr.resize(bImage, 128, 128);
				
			//File newfile = new File(imageStore + "new.png"); 
			//Saves the attachment with its new size
			ImageIO.write(newBImage, attachment.getFileExtension(), new File(""+file));

			//event.getChannel().sendMessage("Retrieving from: " + newfile).queue();
			//test.removeBG(file.toString());
			//System.out.println(file.toString());
			//Upload attachment
				
			System.out.println("looking good");
			//Confirms that it recognizes the attachment
			return "Sure, here is your emoji(s).";
			}
		catch (Exception e) {
			return "Having trouble determining the background of this image however I've still managed to resize it to the emoji standard.";
			}
	//----------------------------------------------------------------------------
	//						   Make Emoji[End]
	//----------------------------------------------------------------------------
		}
	//----------------------------------------------------------------------------
	//							  	Upload
	//----------------------------------------------------------------------------
			public String upload(List<Attachment> messageImage) {
				String filename = "";
				try {
					
					//Looping through several attachments
					for (Attachment attachment:messageImage)
						try {
							{
								//attachment = messageImage.get(i);
								filename = attachment.getFileName();
								
								//Downloads the attachment
								attachment.downloadToFile(AttendantTV.VIDEOS + attachment.getFileName())
								.thenAccept(file -> System.out.println("Saved attachment to " + file.getName()))
								.exceptionally(t ->
								{ // handle failure
									t.printStackTrace();
									return null;
								});
								vs.upload(filename);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					//Confirms the saving of the attachment
					return "Sure, saving the image(s) to my drive.";
					}
				catch (Exception e) {
					return "How about you attach an image to set?";
				}
				
			}
	//----------------------------------------------------------------------------
	//							  	Upload
	//----------------------------------------------------------------------------
	//----------------------------------------------------------------------------
	//							  	Upload S3 TEST
	//----------------------------------------------------------------------------
			public File uploadS3(List<Attachment> messageImage) {
				String filename = "";
				try {
					
					//Looping through several attachments
					for (Attachment attachment:messageImage) {
						try {
							{
								//attachment = messageImage.get(i);
								filename = attachment.getFileName();
								
								//Downloads the attachment
								attachment.downloadToFile(AttendantTV.VIDEOS + attachment.getFileName())
								.thenAccept(file -> System.out.println("Saved attachment to " + file.getName()))
								.exceptionally(t ->
								{ // handle failure
									t.printStackTrace();
									return null;
								});
								//s3.upload(attachment.);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					File file = new File(AttendantTV.VIDEOS + attachment.getFileName());
					
					//Confirms the saving of the attachment
					return file;
					}
				}
				catch (Exception e) {
					return null;
				}
				return null;
				
			}
	//----------------------------------------------------------------------------
	//							  	Upload
	//----------------------------------------------------------------------------
	}
