package disc.discbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
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
   
    	//jda.upsertCommand("response", "Generic bot response").setGuildOnly(true).queue();
    };
}
