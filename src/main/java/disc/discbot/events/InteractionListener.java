package disc.discbot.events;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.jetbrains.annotations.NotNull;

import disc.discbot.Selenium;
import disc.discbot.Constants.Emote;
import disc.discbot.Interpretors.ImageInterpretor;
import disc.discbot.dtos.UpdateUserRequest;
import net.dv8tion.jda.api.entities.Message.Attachment;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.utils.FileUpload;


public class InteractionListener extends ListenerAdapter{
	ImageInterpretor iI = new ImageInterpretor();
	public static int count = 0;
	int messagesD = 0;
	@SuppressWarnings("null")
	@Override
	public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
		InteractionListener il = new InteractionListener();
		super.onSlashCommandInteraction(event);
		
		if (event.getName().equals("upload-video")) {
			System.out.println("Directing to 3rd party app");
			Selenium s = new Selenium();
			event.deferReply().queue();
			try {
				s.setup();
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			event.getHook().sendMessage("Directing you to site").queue();
		}
		//Quiz
		if (event.getName().equals("make-quiz")) {
			String users = (event.getMember().getUser().getName().toString());
			event.deferReply().queue();
			System.out.println("make quiz");
			OptionMapping option = event.getOption("quiz-name");
			try {
				 URL url = new URL("http://localhost:8080/quiz/update");
				 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				 conn.setDoOutput(true);
				 conn.setRequestMethod("PUT");
				 conn.setRequestProperty("Content-Type", "application/json");
				 System.out.println(option);
				 String input = "{\"userName\":\"" + users +"\",\"quizName\":\"" + option.getAsString() +"\"}";
				 OutputStream os = conn.getOutputStream();
				 os.write(input.getBytes());
				 os.flush();
				 if(conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
					System.out.println("Quiz or User already exists");
				 }
				 InputStream in;
				 BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				 System.out.println("test2");
				 //event.getChannel().send
				 
				 event.getHook().sendMessage("Quiz established, you may now add questions to this quiz").queue();
				 //System.out.println(response.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		//Make a util that handles making http connections to reduce boilerplate code
		//Make a json request/body to make it more clean
		//Separate sign in and display
		//Info
		if (event.getName().equals("my-info")) {
			System.out.println("display info");
			event.deferReply().queue();
			String users = (event.getMember().getUser().getName().toString());

			try { String input = "{\"userName\":\"" + users +"\"}";
				/* URL url = new URL("http://localhost:8080/users/update");
				 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				 conn.setDoOutput(true);
				 conn.setRequestMethod("PUT");
				 conn.setRequestProperty("Content-Type", "application/json");
				
				 OutputStream os = conn.getOutputStream();
				 os.write(input.getBytes());
				 os.flush();
				 if(conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
					System.out.println("User already exists");
				 }
				 InputStream in;
				 BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				 */
				 URL url2 = new URL("http://localhost:8080/users/info");
				 HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
				 conn2.setDoOutput(true);
				 conn2.setRequestMethod("POST");
				 conn2.setRequestProperty("Content-Type", "application/json");

				 OutputStream os2 = conn2.getOutputStream();
				 os2.write(input.getBytes());
				 os2.flush();
				 if(conn2.getResponseCode() != HttpURLConnection.HTTP_OK) {
					System.out.println("User already exists");
				 }
				 InputStream in2;
				 BufferedReader br2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
				 String output;
				 event.getHook().sendMessage("Here is your information.").queue();
				 while ((output = br2.readLine())!=null) { 
					 event.getHook().sendMessage("``` " + output + " ```").queue();
				 }
				 System.out.println(br2);
				 //System.out.println(response.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}

			
		}
		
		//Upload
		if (event.getName().equals("upload")) {
			try {
				System.out.println("found upload request");
				OptionMapping option = event.getOption("attachment");
				System.out.println("received upload");
				event.deferReply().queue();
			
			//Retrieves the list of attachments on that message
			List<Attachment> messageImage = new ArrayList<Attachment>();
			messageImage.add(option.getAsAttachment());
			//System.out.println(option.getAsAttachment().getFileName());
			//Stores it to drive and announces response
			while (count < 20 ) {
				event.getHook().sendMessage(iI.upload(messageImage)).queue();
				count++;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Upload
				if (event.getName().equals("upload-s3-test")) {
					try {
						System.out.println("found upload request");
						OptionMapping option = event.getOption("attachment");
						System.out.println("received upload");
						event.deferReply().queue();
					
					//Retrieves the list of attachments on that message
					List<Attachment> messageImage = new ArrayList<Attachment>();
					messageImage.add(option.getAsAttachment());
					//System.out.println(option.getAsAttachment().getFileName());
					//Stores it to drive and announces response
					while (count < 20 ) {
						try {
							 URL url = new URL("http://localhost:8080/s3/upload");
							 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
							 conn.setDoOutput(true);
							 conn.setRequestMethod("POST");
							 conn.setRequestProperty("Content-Type", "application/json");
							 System.out.println(option);
							 OutputStream os = conn.getOutputStream();
							 System.out.print("under os, above flush");
							 os.write(iI.upload(messageImage).getBytes());
							 os.flush();
							 //System.out.println(response.toString());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
						count++;
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					event.getHook().sendMessage("test").queue();
				}
				
		if (event.getName().equals("purge")) {
			OptionMapping option = event.getOption("value");
			event.deferReply().queue();
			if (option.getAsInt() > MessageListener.messages.size()) {
				event.getHook().sendMessage("This exceeds the amount of values that are able to be deleted (" +
				MessageListener.messages.size() + ")").queue();
			}
			else {
				//Remove messages from the channel
				for (int i = 0; i < option.getAsInt(); i++) {
					event.getChannel().deleteMessageById(MessageListener.messages.get(i)).queue();
					messagesD++;
				}
				
				//Remove messages from array
				for (int i = 0; i < messagesD; i++) {
					MessageListener.messages.remove(i);
				}
				
				messagesD = 0;
				event.getHook().sendMessage(option.getAsString() + " Message(s) have been deleted").queue();
			//event.reply("deleted").queue();
			}
		}
		//Set emoji
		if (event.getName().equals("set-emoji")) {
			OptionMapping option = event.getOption("attachment");
			event.deferReply().queue();
			
			//Retrieves the list of attachments on that message
			List<Attachment> messageImage = new ArrayList<Attachment>();
			messageImage.add(option.getAsAttachment());
			
			//Stores it to drive and announces response
			event.getHook().sendMessage(iI.setImage(messageImage)).queue();
		}
		
		//Make emoji
		if (event.getName().equals("make-emoji-no-bg")) {
			OptionMapping option = event.getOption("attachment");
			event.deferReply().queue();
			
			//Reads the attachment to reference
			List<Attachment> messageImage = new ArrayList<Attachment>();
			messageImage.add(option.getAsAttachment());
			
			//Looping through several attachments
			for (Attachment attachment:messageImage) {
				//Searches for the attachment in the drive
				File file = new File(Emote.EMOTEDESTINATION + attachment.getFileName());
				
				//Removes bg, resizes it to emoji standard and announces response	
				event.getHook().sendMessage(iI.makeImage(attachment, file)).queue();
				
				//Upload attachment
				event.getHook().sendFiles(FileUpload.fromData(file)).queue();
			};
		}
		
		//Make emoji
		if (event.getName().equals("make-emoji")) {
			OptionMapping option = event.getOption("attachment");
			event.deferReply().queue();
			
			//Reads the attachment to reference
			List<Attachment> messageImage = new ArrayList<Attachment>();
			messageImage.add(option.getAsAttachment());
			
			//Looping through several attachments
			for (Attachment attachment:messageImage) {
				//Searches for the attachment in the drive
				File file = new File(Emote.EMOTEDESTINATION + attachment.getFileName());
				
				//Removes bg, resizes it to emoji standard and announces response	
				event.getHook().sendMessage(iI.makeImageBG(attachment, file)).queue();
				
				//Upload attachment
				event.getHook().sendFiles(FileUpload.fromData(file)).queue();
			};
		}
		/*
		switch(event.getName()) {
		
		case "create-emoji":
			//System.out.println("Success");
			//event.getOption(il.onMessageReceived(event)).getAsAttachment();
			
			break;
		}

	}
	
	@SuppressWarnings("deprecation")
	/*public void onMessageReceived(@NotNull MessageReceivedEvent event) {
		super.onMessageReceived(event);
		
		//List<Attachment> messageImage = (event.getMessage().getAttachments());
		
		CompletableFuture<Icon> image = messageImage.get(0).retrieveAsIcon();
	
	}*/
}}
