package com.falkonry.login.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.falkonry.init.Common;
import com.falkonry.init.SeleniumInit;
import com.falkonry.init.TestData;

public class LoginIndex extends SeleniumInit{

	
	@Test
	public void validLoginviaGoogle(){
		
		int numOfFailure = 0;
		int step=1;
		
		log("Test Case Id :<b>"+" </b>");
		log("Testcase Discription : To verify Login with 'Google' account. ");
		log("Step "+step++ +" : Open url:<a>" + testUrl + "</a>");
	
		Common.pause(1);
	
		log("Step "+step++ +"  Log in with Google account.");
		loginIndexPage.clickLoginGooglebtn();
		Common.pause(2);
		
		log("To verify user redirects to the 'Google Login' page.");
		if (loginVerificationPage.verifyGoogleLoginpage()) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure++;
		}
		
		log("Step "+step++ +" : Eneter registered Google account's Email and Password.");
		loginIndexPage.loginGoogle(TestData.getUsernameGP(),TestData.getPasswordGP());
		Common.pause(6);
	
		log("To verify that user Logged In successfully.");
		if (loginVerificationPage.verifyAfterLogin()) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}

	}
	
	
	@Test
	public void inValidLogin(){
		
		int numOfFailure = 0;
		int step=1;
		
		log("Test Case Id :<b>"+" </b>");
		log("Testcase Discription : To verify Login with invalid credentials. ");
		log("Step "+step++ +" : Open url:<a>" + testUrl + "</a>");
	
		Common.pause(2);
		
		log("Step "+step++ +" : Eneter In-valid Credentials.");
		loginIndexPage.enterEmail(TestData.getInvalidEmail());
		loginIndexPage.enterPswd(TestData.getInvalidPswd());
	
		loginIndexPage.clickLoginbtn();
		Common.pause(4);
		
		log("To verify user gets the wrong email / password validation message.");
		if (loginVerificationPage.verifyErrormsg()) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
}
