package events;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.swing.ImageIcon;
import javax.validation.constraints.NotNull;

import disc.discbot.test;
import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.Message.Attachment;
import net.dv8tion.jda.api.entities.RichPresence.Image;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command.Option;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class InteractionListener extends ListenerAdapter{
	int messagesD = 0;
	@Override
	public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
		InteractionListener il = new InteractionListener();
		super.onSlashCommandInteraction(event);
		
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
		
		if (event.getName().equals("set-emoji")) {
			event.deferReply().queue();
			try {
				//test.removeBG();
				System.out.println("hey");
				event.getHook().sendMessage("tested").queue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
