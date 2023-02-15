package events;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.swing.ImageIcon;
import javax.validation.constraints.NotNull;

import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.Message.Attachment;
import net.dv8tion.jda.api.entities.RichPresence.Image;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command.Option;

public class InteractionListener extends ListenerAdapter{
	
	@Override
	public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
		InteractionListener il = new InteractionListener();
		super.onSlashCommandInteraction(event);
		
		
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
