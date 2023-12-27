package com.facebookV1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "email")public WebElement usrName;
	@FindBy(id = "pass")public WebElement psdWord;
	@FindBy(name = "login")public WebElement loginButton;
	@FindBy(xpath = "//*[text()='Mahesh Lavanya']")public WebElement UserVerify;
	@FindBy(xpath = "//input[@placeholder='Search Facebook']")public WebElement SearchBox;
	@FindBy(xpath = "//span[text()='Friends']")public WebElement Friends;
	
	//Orangehrm Page Objects
	@FindBy(name = "username")public WebElement orguName;
	@FindBy(name = "password")public WebElement orgpWord;
	@FindBy(xpath = "//button[@type='submit']")public WebElement orgloginButton;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")public WebElement Errormsg;
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")public WebElement UDDN;
	@FindBy(xpath = "//a[text()='Logout']")public WebElement orglogoutButton;

	//FaceBook Login Actions
	public void userNameTextBox(String uname) {
		usrName.sendKeys(uname);
	}

	public void passwordTextBox(String upsd) {
		psdWord.sendKeys(upsd);
	}

	public void lgButton() {
		loginButton.click();
	}
	//Orangehrm Login Actions
	public void orangeuserTextBox(String ornageusrname) {
		orguName.sendKeys(ornageusrname);
	}

	public void orangepasswordTextBox(String orangepsd) {
		orgpWord.sendKeys(orangepsd);
	}
	
	public void orangelgButton() {
		orgloginButton.click();
	}

}
