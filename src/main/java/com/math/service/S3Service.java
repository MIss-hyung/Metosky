package com.math.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.UUID;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class S3Service
{
  private static final Logger logger = LoggerFactory.getLogger(S3Service.class);
  @Resource
  private Properties awsProperties;
  
  public S3Service() {}
  
  public static String uploadFile(String uploadPath, String originalName, MultipartFile file) throws IOException {
	  S3Util s3 = new S3Util();
    String bucket = "problems-image";
    UUID uid = UUID.randomUUID();
    
    String savedName = "/" + uid.toString() + "_" + originalName;
	logger.info("�떎�슫濡쒕뱶 寃쎈줈: " + uploadPath);
	String savedPath = calcPath(uploadPath);
	
	String uploadedFileName = null;
	uploadedFileName = (savedPath + savedName).replace(File.separatorChar, '/');
	s3.fileUpload(bucket, uploadPath + uploadedFileName, file);

	logger.info(uploadedFileName);
	
	return uploadedFileName;
}
  

private static String calcPath(String uploadPath) {

	Calendar cal = Calendar.getInstance();

	String yearPath = File.separator + cal.get(Calendar.YEAR);
	String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
	String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

	makeDir(uploadPath, yearPath, monthPath, datePath);

	logger.info(datePath);

	return datePath;
}

private static void makeDir(String uploadPath, String... paths) {

	if (new File(paths[paths.length - 1]).exists()) {
		return;
	}

	for (String path : paths) {

		File dirPath = new File(uploadPath + path);

		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
	}
}

}