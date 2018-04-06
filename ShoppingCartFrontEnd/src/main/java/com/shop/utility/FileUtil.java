package com.shop.utility;


import java.io.File;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component//will create singleton instance with namefileUtil
public class FileUtil {

	private static final Logger log = LoggerFactory
			.getLogger(FileUtil.class);
	
	//private static String rootPath = System.getProperty("catalina.home");//catalina home gives the location of tomcat directory
	//or give rootpath= "resources//images//"
	
	//private static String rootPath="resources//images//";
	
	//private static final String imageDirectory="ShoppingCartImages";
	
	@Autowired
	private  HttpSession httpSession;
	
	public  boolean fileCopyNIO(MultipartFile file,String fileName)
	{
		log.debug("Starting of fileCopyNIO method");
		File dest=new File(httpSession.getAttribute("rootpath")+File.separator+fileName);
		System.out.println(dest.getAbsolutePath());
		try
		{
			file.transferTo(dest);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		log.debug("ending of fileCopyNIO method");
		return false;
	}
	
}
	
	/*public static boolean copyFile(String fileName,MultipartFile file)
	{
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				// Creating the directory to store file
				File dir = new File(rootPath + File.separator + fileName);//sepator for diff os is diff so we use file.separator
				if (!dir.exists())
					dir.mkdirs();//mkdirs=make directory

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());
                 //in case of boolean simply return true or false
				return  true;//"You successfully uploaded file=" + fileName;
			} catch (Exception e) {
				return false;//"You failed to upload " + fileName + " => " + e.getMessage();
			}
		} else {
			return false;// "You failed to upload " + fileName
					//+ " because the file was empty.";
		}
	}*/
	
	

	

