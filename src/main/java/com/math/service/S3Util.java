package com.math.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
public class S3Util
{
  private static final Logger logger = LoggerFactory.getLogger(S3Util.class);
  
  private static final String accesskey = "AKIAIUXT5V5VJJM2GMFA";
  
  private static final String secreteKey = "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";
  private AmazonS3 s3Client;

	public S3Util() {
		System.out.println("here1");
		AWSCredentials credentials = new BasicAWSCredentials(accesskey, secreteKey);
		ClientConfiguration clientConfig = new ClientConfiguration();
		clientConfig.setProtocol(Protocol.HTTP);
		this.s3Client = new AmazonS3Client(credentials, clientConfig);
		s3Client.setEndpoint("s3.ap-northeast-2.amazonaws.com");
	}
	
	public List<Bucket> getBucketList() {
		return s3Client.listBuckets();
	}
	
	public Bucket createBucket(String bucketName) {
		return s3Client.createBucket(bucketName);
	}
	
	public void createFolder(String bucketName, String folderName) {
		s3Client.putObject(bucketName, folderName + "/", new ByteArrayInputStream(new byte[0]), new ObjectMetadata());
	}

	public void fileUpload(String bucketName, String fileName, MultipartFile file) {
		String filePath = (fileName).replace(File.separatorChar, '/');
		
		ObjectMetadata metaData = new ObjectMetadata();
		metaData.setContentType(file.getContentType());
		metaData.setContentLength(file.getSize());
		//metaData.setHeader("filename", file.getOriginalFilename());

		try {
			s3Client.putObject(bucketName, filePath, file.getInputStream(), metaData);
			logger.info("===============Upload custom file - Done!!!!!! ======================");
		} catch (AmazonServiceException e) {
			logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
			logger.info("Error Message: " + e.getMessage());
			logger.info("HTTP Status Code: " + e.getStatusCode());
			logger.info("AWS Error Code: " + e.getErrorCode());
			logger.info("Error Type: " + e.getErrorType());
			logger.info("Request ID: " + e.getRequestId());
			logger.info("gg" +e.getErrorMessage());
			
		} catch (AmazonClientException e) {
			logger.info("Caught an AmazonClientException: ");
			logger.info("Error Message: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fileDelete(String bucketName, String fileName) {
		String imgName = (fileName).replace(File.separatorChar, '/');
		s3Client.deleteObject(bucketName, imgName);
		System.out.println("�궘�젣 �꽦怨�!!");
	}
	
	public String getFileURL(String bucketName, String fileName) {
		System.out.println("input fileName: " + fileName);
		String imgName = (fileName).replace(File.separatorChar, '/');
		return s3Client.generatePresignedUrl(new GeneratePresignedUrlRequest(bucketName, imgName)).toString();
	}
	
	public String getFileURLString(String bucketName, String fileName) {
		System.out.println("input fileName : " + fileName);
		String imgName = (fileName).replace(File.separatorChar, '/');
		return s3Client.generatePresignedUrl(new GeneratePresignedUrlRequest(bucketName, imgName)).toString();
	}
	//ex
	public byte[] getFileInfo(String bucketName, String key) throws IOException {
		try {
			
          System.out.println("getFileInfo");
          S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucketName, key));
          
          System.out.println("Content-Type: "  + s3Object.getObjectMetadata().getContentType());
          logger.info("===================== getfileInfo =====================");
          
          S3ObjectInputStream objectInputStream = s3Object.getObjectContent();

          byte[] bytes = IOUtils.toByteArray(objectInputStream);

          return bytes;
          
      } catch (AmazonServiceException ase) {
      	logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
      } catch (AmazonClientException ace) {
      	logger.info("Caught an AmazonClientException: ");
          logger.info("Error Message: " + ace.getMessage());
      }

		return null;
	}
	
	public ResponseEntity<byte[]> download(String bucketName, String key) throws IOException {
		try {
			
          System.out.println("Downloading an object");
          S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucketName, key));
          
          System.out.println("Content-Type: "  + s3Object.getObjectMetadata().getContentType());
          logger.info("===================== Import File - Done! =====================");
          
          S3ObjectInputStream objectInputStream = s3Object.getObjectContent();

          byte[] bytes = IOUtils.toByteArray(objectInputStream);

          String fileName = URLEncoder.encode(key, "UTF-8").replaceAll("\\+", "%20");

          HttpHeaders httpHeaders = new HttpHeaders();
          httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
          httpHeaders.setContentLength(bytes.length);
          httpHeaders.setContentDispositionFormData("attachment", fileName);

          return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
          
      } catch (AmazonServiceException ase) {
      	logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
      } catch (AmazonClientException ace) {
      	logger.info("Caught an AmazonClientException: ");
          logger.info("Error Message: " + ace.getMessage());
      } catch (Exception e) {
    	e.printStackTrace();
    	}

		return null;
	}

	
}