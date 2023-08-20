package disc.discbot;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

	public WebDriver driver;
	
	public void setup() throws IOException, URISyntaxException 
	{
		System.out.println("Inside selenium with RT");
		Runtime rt = Runtime.getRuntime();
		String url = "https://txmysticxs.webs.com/videos";
		rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\XShoj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
	}
	
	public static void Chrome() throws IOException, URISyntaxException 
	{
		Selenium s = new Selenium();
		s.setup();
	}
}

