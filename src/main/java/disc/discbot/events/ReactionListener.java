package disc.discbot.events;


import org.jetbrains.annotations.NotNull;


import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionListener extends ListenerAdapter{
	
	@SuppressWarnings({ "unlikely-arg-type", "deprecation" })
	@Override
	 public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event)
    {
		final Emoji HEART = Emoji.fromUnicode("U+2764");
		
		String reactions = event.getEmoji().toString();
		System.out.println(reactions);
		
		 if (event.getEmoji().equals(HEART)) {
            event.getChannel().sendMessage("Get that shit off me").queue();
            System.out.println("NO");
		 }
            
        
    }

}
