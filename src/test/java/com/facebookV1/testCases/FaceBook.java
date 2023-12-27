package com.facebookV1.testCases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.facebookV1.pageObject.LoginPage;

public class FaceBook extends LoginPageTC {
	
	@Test(priority = 1)
	public void login() {
		LoginPage lp = new LoginPage(driver);
		lp.userNameTextBox(userName);
		lp.passwordTextBox(password);
		lp.loginButton.click();

	}

	@Test(priority = 2)
	public void validating() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		WebElement verify = lp.UserVerify;
		String actualText = verify.getText();
		if (actualText.equals(expectedText)) {
			captureScreenshots(driver, "Validation");
			System.out.println("UserName is Matching:- " + actualText);
		} else {
			captureScreenshots(driver, "Validation");
			System.out.println("UserName is not Matching " + actualText);
		}
		Thread.sleep(5000);
		System.out.println("Test 2 is executed");
	}

	@Test(priority = 3)
	public void name() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		if (lp.SearchBox == null) {
			System.out.println("The page does not contain the specified element.");
		} else {
			captureScreenshots(driver, "name");
			System.out.println("The page contains the specified element.");
		}
		Thread.sleep(5000);
		System.out.println("Test 3 is executed");
	}

	@Test(priority = 4)
	public void nameSearch() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.Friends.click();
		lp.SearchBox.sendKeys("Akshat" + Keys.ENTER);
		Thread.sleep(5000);
		captureScreenshots(driver, "nameSearch");
		Thread.sleep(5000);
		System.out.println("Test 4 is executed");
	}

}
