package disc.discbot.Util;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerObject {
	public Logger logger;
	
	FileHandler fh;
	
	//We want the logs to be categorized by guilds for example, hence filePath
	public void LoggerObjectConfig(String filePath, String file) {
		File fp = new File(filePath);
		File f = new File(file);
		
		//If file path does not exist, make it
		if (!fp.exists()) {
			fp.mkdirs();
		}
		
		//If file does not exist, make it
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	try {
		//Place file in file path
		fh = new FileHandler(filePath+"/"+file, true);
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	logger = Logger.getLogger("User");
	logger.addHandler(fh);
	SimpleFormatter formatter = new SimpleFormatter();
	fh.setFormatter(formatter);
	}
}
