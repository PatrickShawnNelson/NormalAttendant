package disc.discbot.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;



//import software.amazon.awssdk.services.s3.model.PutObjectRequest;


public class S3StorageTest {
	private String bucketName = "normalattendanttv";
	private AmazonS3 s3Client;

	public String upload (MultipartFile file) {
		
		File fileObj = convertMultipartFileToFile(file);
		String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
		s3Client.putObject(new PutObjectRequest(bucketName,fileName, fileObj));
		fileObj.delete();
		return "File uploaded : " + fileName;
		//String filepath = AttendantTV.VIDEOS + file;
	}
	
	public byte[] downloadFile(String fileName) {
		S3Object s3Object = s3Client.getObject(bucketName, fileName);
		S3ObjectInputStream inputStream = s3Object.getObjectContent();
		try {
			byte[] content = IOUtils.toByteArray(inputStream);
			return content;
		} catch (IOException e) {
			
		}
		return null;
	}
	
	public String deleteFile(String fileName) {
		s3Client.deleteObject(bucketName, fileName);
		return fileName + "removed ...";
	}
	
	private File convertMultipartFileToFile(MultipartFile file) {
		File convertedFile = new File(file.getOriginalFilename());
		try(FileOutputStream fos = new FileOutputStream(convertedFile)) {
			fos.write(file.getBytes());
		} catch (IOException e ) {
			System.out.println("Error converting multipart file to file\n" + e);
		}
		return convertedFile;
	}
}
