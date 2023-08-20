package disc.discbot.Util;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;
/*
public class VideoRetrieval {

	static void retrieve(String bName, String s3ObjName, int expiration) {
	
	    expiration = 3600;
	    

	    GetObjectPresignRequest request = GetObjectPresignRequest.builder().
	    												.key(s3ObjName)
	    												
	    												.build();
	    
	    s3_client = boto3.client('s3')
	    try:
	        response = s3_client.generate_presigned_url('get_object',
	                                                    Params={'Bucket': bucket_name,
	                                                            'Key': object_name},
	                                                    ExpiresIn=expiration)
	    except ClientError as e:
	        logging.error(e)
	        return None

	    # The response contains the presigned URL
	    return response

}
*/