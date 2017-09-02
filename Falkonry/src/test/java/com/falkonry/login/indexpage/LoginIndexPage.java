package com.falkonry.login.indexpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.falkonry.init.AbstractPage;
import com.falkonry.init.Common;
import com.falkonry.login.verification.LoginVerificationPage;

public class LoginIndexPage extends AbstractPage{

	public LoginIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath=".//button/div[contains(text(),'Log in with Google')]")
	WebElement g_l;
	
	public LoginVerificationPage clickLoginGooglebtn() {	
		Common.clickOn(driver, g_l);
		log("Clicked on 'LOGIN WITH GOOGLE' button.");
		return new LoginVerificationPage(driver);
	}
	
	@FindBy(xpath=".//input[@id='identifierId']")
	WebElement email_gl;
	@FindBy(xpath=".//input[@type='password']")
	WebElement pswd_gl;
	@FindBy(xpath=".//span[contains(text(),'Next')]")
	WebElement next;
	@FindBy(xpath=".//input[@id='signIn']")
	WebElement sign_in_gl;
	
	public LoginVerificationPage loginGoogle(String e , String p){
		
		Common.type(email_gl, e);
		log("Enter registered Email : <b>"+e+"</b>");
		Common.clickOn(driver, next);
		log("Clicked on 'Next' button.");
		Common.pause(2);
		Common.type(pswd_gl, p);
		log("Enter registered Password : <b>"+p+"</b>");
		Common.clickOn(driver, next);
		log("Clicked on 'Next' button.");

		return new LoginVerificationPage(driver);
	}	
	
	// Login with Google Full method
	
	public LoginVerificationPage loginWithGoogleFull(String e , String p){
		clickLoginGooglebtn();
		Common.pause(3);
		loginGoogle(e,p);
		Common.pause(7);
		return new LoginVerificationPage(driver);
	}
	
	
	
	@FindBy(xpath=".//div[contains(@class,'pull-right')]/button[contains(text(),'Facts')]")
	WebElement facts_btn;
	
	public LoginVerificationPage clickFactsbtn() {	
		Common.clickOn(driver, facts_btn);
		log("Clicked on 'Facts' button.");
		return new LoginVerificationPage(driver);
	}
	
	
	@FindBy(xpath=".//div[contains(text(),'Select or Drop CSV or JSON file here')]")
	WebElement upload;
	
	
	
	@FindBy(xpath="//input[@type='text']")
	WebElement email;
	@FindBy(xpath="//input[@type='password']")
	WebElement pswd;
	@FindBy(xpath=".//button/span")
	WebElement login_btn;
	
	public LoginVerificationPage enterEmail(String e){
		
		Common.type(email, e);
		log("Entered 'Email' :: <b>"+e+"</b>");
		return new LoginVerificationPage(driver);
	} 
	
	public LoginVerificationPage enterPswd(String p){
		
		Common.type(pswd, p);
		log("Entered 'Password' :: <b>"+p+"</b>");
		return new LoginVerificationPage(driver);
	} 
	
	public LoginVerificationPage clickLoginbtn(){
		
		Common.clickOn(driver, login_btn);
		log("Clicked on 'Log In' button.");
		return new LoginVerificationPage(driver);
	}
	

	
	
}
