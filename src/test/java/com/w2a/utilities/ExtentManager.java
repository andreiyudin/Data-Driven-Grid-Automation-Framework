package com.w2a.utilities;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if(extent==null) {
			//Thu dd:mm
			Date d = new Date();
			String fileName = "jenkins_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports(System.getProperty("user.dir")+"\\reports\\"+fileName,true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
		}
		
		return extent;
	}

}
