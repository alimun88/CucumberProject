package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static String takeScreenShot(WebDriver driver, String fileName)throws IOException{
		 fileName = fileName +".png";
		 String directory = "C:\\Users\\Liaquat\\Desktop";		 
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(directory+fileName));
		String destination = directory+fileName;
		return destination;
	}

}
