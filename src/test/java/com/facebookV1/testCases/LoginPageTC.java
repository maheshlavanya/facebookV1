package com.facebookV1.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.facebookV1.pageObject.LoginPage;
import com.facebookV1.utilities.Readconfig;

public class LoginPageTC {
	Readconfig readconfig = new Readconfig();
	public String fbUrl = readconfig.getFacebookUrl();
	public String orgUrl = readconfig.getOrangermUrl();
	public String userName = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public String expectedText = readconfig.getExpectedText();
	LoginPage lp = new LoginPage(driver);

	@Parameters({"Browser","ApplicationUrl"})
	@BeforeTest
	public void launchBrowser(String br, String appurl) {
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			driver = new ChromeDriver(options);
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		if(appurl.equals("facebook")) 
		{
		driver.get(fbUrl);
		}
		else if (appurl.equals("orangehrm")) {
			driver.get(orgUrl);
		}
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}

	public void captureScreenshots(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy%MM%dd%HH%mm%ss%SSS");
        String timestamp = dateFormat.format(new Date());
        String fileName = tname + "_" + timestamp + ".png";
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + fileName);
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken "+ fileName);

	}
}
