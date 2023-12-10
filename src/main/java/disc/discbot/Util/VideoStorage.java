package disc.discbot.Util;

import java.io.File;

import disc.discbot.Constants.*;
import disc.discbot.events.InteractionListener;
import software.amazon.awssdk.core.internal.http.AmazonAsyncHttpClient;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3BaseClientBuilder;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
//This will use Amazon S3 Bucket to store videos
public class VideoStorage {
	//InteractionListener listener = new InteractionListener();
	//AmazonAsyncHttpClient apClient = (AmazonAsyncHttpClient) S3BaseClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion("<aws-region>").build();
	public void upload (String filename) {
		String bucketName = "normalattendanttv";
		String file = filename;
		String filepath = AttendantTV.VIDEOS + file;
	
		S3Client client = S3Client.builder().build();
	
		PutObjectRequest request = PutObjectRequest.builder()
											.bucket(bucketName)
											.key("test" + InteractionListener.count)
											.build();
		client.putObject(request, RequestBody.fromFile(new File(filepath)));
}
}
