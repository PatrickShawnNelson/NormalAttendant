package disc.discbot.Interpretors;

import disc.discbot.Constants.BotSensor;
import disc.discbot.Constants.Emoji;

public class MemberInterpretor {
	BotSensor sensor = new BotSensor();
	String resp = "";
	
	//This method will determine if frigg used gavin emote
	public String friggReactions (){

		return sensor.emojiResp.get(Emoji.GAVIN);
}
	//This method will determine if someone used the wegay emote
	public String wegayReactions (){

		return sensor.emojiResp.get(Emoji.WEGAY);
}
}
