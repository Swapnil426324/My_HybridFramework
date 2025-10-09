package com.tka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tka.utilities.ReadProperty;

public class LoginPage {

	@FindBy(name="username")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="remember")
	WebElement txtRemember;
	
	@FindBy(name="submit")
	WebElement btnSubmit;
	
	@FindBy(xpath="//li[text()='Invalid username or password']")
	WebElement wrongEmailPasswordMsg;
	
	@FindBy(id="login-username-error")
	WebElement wrongEmail;
	
	@FindBy(id="login-password-error")
	WebElement invalidPassword;
	
	@FindBy(xpath = "(//a[@class='button secondary expand nomarg'])[1]") WebElement clickProfile;
	@FindBy(xpath = "//p[text()='Your existing details can be edited below.']") WebElement profileMsgVerify;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void clickRemember() {
		txtRemember.click();
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public String errorEmailAndPassword() {
		return wrongEmailPasswordMsg.getText();
	}
	
	public String wrongEmail() {
		return wrongEmail.getText();
	}
	
	public String wrongPassword() {
		return invalidPassword.getText();
	}
	
	public void validLogin() {
		enterEmail(ReadProperty.readConfig("username"));
		enterPassword(ReadProperty.readConfig("password"));
		clickRemember();
		clickSubmit();
	}
	
	public void clickProfileBtn() {
		clickProfile.click();
	}
	
	public String verifyProfileMsg() {
		return profileMsgVerify.getText();
	}
}
