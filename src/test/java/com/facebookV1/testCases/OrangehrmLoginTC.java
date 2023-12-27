package com.facebookV1.testCases;

import java.util.concurrent.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.facebookV1.pageObject.LoginPage;
import com.facebookV1.utilities.XLUtils;

public class OrangehrmLoginTC extends LoginPageTC {

	@Test(dataProvider = "LoginData")
	public void loginDDt(String usr, String pwd) throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		captureScreenshots(driver, "loginDDt");
		LoginPage lp = new LoginPage(driver);
		lp.orangeuserTextBox(usr);
		captureScreenshots(driver, "loginDDt");
		lp.orangepasswordTextBox(pwd);
		captureScreenshots(driver, "loginDDt");
		lp.orangelgButton();
		captureScreenshots(driver, "loginDDt");
		Thread.sleep(5000);
		usermethod();
	}

	public boolean usermethod() {
		try {
			LoginPage lp = new LoginPage(driver);
			String actualText = lp.Errormsg.getText();
			String expectedText = "Invalid credentials";
			Assert.assertEquals(actualText, expectedText);
			System.out.println("Actual Text Present "+ actualText);
			return true;

		} catch (Exception e) {
			System.out.println("ErrorPopup Is Not Present");
		}
		return false;
	}

	public void logOut() {
		LoginPage lp = new LoginPage(driver);
		String ele = lp.UDDN.getText();
		System.out.println("UserName:- " + ele);
		lp.UDDN.click();
		lp.orglogoutButton.click();

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/java/com/facebookV1/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getcellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);

			}
		}
		return logindata;
	}

}
