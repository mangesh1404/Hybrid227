package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

public class DriverUtils extends BaseClass {

	public static String getScreenshot(String name) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat sdf= new SimpleDateFormat("ddMMyyyyhhmmss");
		String date=sdf.format(new Date());
		String path=System.getProperty("user.dir")+"/src/test/resources/screenshots/"+name+"_"+date+".jpg";
		File dest= new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
