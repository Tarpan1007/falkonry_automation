package com.falkonry.login.verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.falkonry.init.AbstractPage;
import com.falkonry.init.Common;

public class LoginVerificationPage extends AbstractPage{

	public LoginVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath=".//*[@id='identifierId']")
	WebElement email_gl;
	@FindBy(xpath=".//input[@type='password']")
	WebElement pswd_gl;
	@FindBy(xpath=".//span[contains(text(),'Next')]")
	WebElement next;
	@FindBy(xpath=".//input[@id='signIn']")
	WebElement sign_in_gl;
	
	public boolean verifyGoogleLoginpage(){
		
		return  driver.findElement(By.xpath(".//input[@id='identifierId']")).isDisplayed() && 
				driver.findElement(By.xpath(".//span[contains(text(),'Next')]")).isDisplayed() ;	
	}

	
	public boolean verifyAfterLogin(){
		
		return driver.findElement(By.xpath(".//span[@class='falkonry-label']")).isDisplayed()
				|| driver.findElement(By.xpath(".//div[contains(text(),'Profile')]")).isDisplayed()
				|| driver.findElement(By.xpath(".//div[contains(text(),'Logout')]")).isDisplayed()
				&& driver.findElement(By.xpath(".//ul//a[contains(.,'Datastreams')]")).isDisplayed()
				&& driver.findElement(By.xpath(".//ul//a[contains(.,'Account')]")).isDisplayed();
	}
	
	
	public boolean verifyAfterUploadFacts(){
		
		return driver.findElement(By.xpath(".//label[contains(text(),'Facts Upload')]")).isDisplayed();
		
	}
	
	
	public boolean verifyErrormsg(){
		
		Common.pause(1);
		String msg = driver.findElement(By.xpath(".//span[contains(text(),'Wrong email or password.')]")).getText();
		log("Verified message :: <b>"+ msg +" </b>");
		return driver.findElement(By.xpath(".//span[contains(text(),'Wrong email or password.')]")).isDisplayed();
		
	}
	
	
}
