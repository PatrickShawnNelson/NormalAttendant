package disc.discbot;

//use org.apache.httpcomponents

import java.io.File;
import java.io.IOException;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.apache.http.client.ClientProtocolException;


public class test {
  public static void removeBG(String img) throws ClientProtocolException, IOException {
	  Response response = Request.post("https://api.remove.bg/v1.0/removebg")
			    .addHeader("X-Api-Key", "DHSPYdqNBmAp2wFujn66QUUc")
			    .body(org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder.create().addBinaryBody("image_file", new File(img))
			        .addTextBody("size", "auto")
			        .build()
			    ).execute();
			response.saveContent(new File((img)));
}}