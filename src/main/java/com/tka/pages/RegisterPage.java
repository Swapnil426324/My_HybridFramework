package com.tka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	@FindBy(linkText = "Register") WebElement clickRegister;  
	@FindBy(name="title") WebElement txtTitle;
	@FindBy(id="first_name") WebElement txtFirstName;
	@FindBy(id="last_name") WebElement txtLastNname;
	@FindBy(id="email") WebElement txtEmail;
	@FindBy(id="phone") WebElement txtPhone;
	@FindBy(id="mobile") WebElement txtMobile;
	@FindBy(id="password") WebElement txtPassword;
	@FindBy(id="passconf") WebElement txtPassconform;
	@FindBy(id="terms") WebElement clickTerms;
	@FindBy(id="mailing") WebElement clickMailing;
	@FindBy(id="register_submit") WebElement clickRegister_submit;	
	@FindBy(xpath="//li[contains(text(),'Your email ')]") WebElement conformMsg;
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickRegisterBtn() {
		clickRegister.click();
	}
	
	public void typeTitle(String title) {
		txtTitle.sendKeys(title);
	}
	
	public void typeFname(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void typeLname(String lname) {
		txtLastNname.sendKeys(lname);
	}
	
	public void typeEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void typePhone(String phone) {
		txtPhone.sendKeys(phone);
	}
	
	public void typeMobile(String mobile) {
		txtMobile.sendKeys(mobile);
	}
	
	public void typePassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void typePassConform(String passconform) {
		txtPassconform.sendKeys(passconform);
	}
	
	public void clickTerms() {
		clickTerms.click();
	}
	
	public void clickMailbox() {
		clickMailing.click();
	}
	
	public void clickSubmit() {
		clickRegister_submit.click();
	}
	
	public String displayConformMsg() {
		return conformMsg.getText();
	}





}
