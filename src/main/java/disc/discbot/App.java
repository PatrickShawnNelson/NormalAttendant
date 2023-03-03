package disc.discbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

@SpringBootApplication(proxyBeanMethods = false)
public class App {

    public static void main(String[] args) {
        //SpringApplication.run(App.class, args);
    	
    	final String T = "NULL";
    	
    	JDABuilder jdb = JDABuilder.createDefault(T);
    	
    	JDA jda = jdb
    		.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
    		.addEventListeners(new MessageListener(), new InitializeListener(), new InteractionListener())
    		.build();
    	//System.out.println(jda.getggetUsers());
    	jda.upsertCommand("purge", "Delete a series of messages from a user").setGuildOnly(true)
    	.addOption(OptionType.INTEGER, "value", "Delete a maximum of 50 messages.", true)
    	.queue();
    };
}
