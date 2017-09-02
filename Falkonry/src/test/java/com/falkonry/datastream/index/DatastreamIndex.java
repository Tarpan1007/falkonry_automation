package com.falkonry.datastream.index;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.falkonry.init.Common;
import com.falkonry.init.SeleniumInit;
import com.falkonry.init.TestData;

public class DatastreamIndex extends SeleniumInit{

	
	@Test
	public void addNewDatastream() throws AWTException, IOException{
		
		int numOfFailure = 0;
		int step=1;
		
		log("Test Case Id : <b>"+" TC_DS_02</b>");
		log("Testcase Description :  To verify user can create 'New Standalone File type Datastream'. ");
		log("Step "+step++ +" : Open URL :<a>" + testUrl + "</a>");
		Common.pause(2);
		
		log("Step "+step++ +" : Login with valid credentials.");
		loginIndexPage.loginWithGoogleFull(TestData.getUsernameGP(),TestData.getPasswordGP());
		Common.pause(1);
		
		log("To verify that user Logged In successfully.");
		if (loginVerificationPage.verifyAfterLogin()) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		log("Step "+step++ +" : Goto 'Datastream' dashboard.");
		datastreamIndexPage.clickDatastream();
		
		log("Step "+step++ +" : 'Add new Datastream'.");
		datastreamIndexPage.clickAddnewDatastream();
		
		String name = TestData.rndmTitle(5);
		datastreamIndexPage.enterName(name);
		datastreamIndexPage.selectDatastream("Standalone");
		datastreamIndexPage.clickNextbtn();
		datastreamIndexPage.selectedTypeDatastream();
		datastreamIndexPage.uploadFile();
		
		log("To verify user gets the File Analyzed successfully message.");
		if (datastreamVerificationPage.verifyAfterUploadFile()) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		datastreamIndexPage.clickDatastreamNextbtn();
		datastreamIndexPage.selectedTypeDatastream();
		datastreamIndexPage.selectTimeField("time");
		datastreamIndexPage.selectEntity("person");
		datastreamIndexPage.clickDataStreamSavebtn();
		
		WebElement notify = driver.findElement(By.xpath("//notify[@class='ng-scope']/div"));
		String msg = notify.getText();
		
		log("To verify user gets Successful message after click on Save button.");
		if (datastreamVerificationPage.verifySuccessfulDatastreamMessage(msg, name)) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		Common.pause(1);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//legend[contains(text(),'Datastream Configuration')]")));
		
		datastreamIndexPage.clickClosebtn();
		
		log("To verify user gets Newly created DataStream on the Dashboard.");
		if (datastreamVerificationPage.verifyDatastreamonDashboard(name)) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		log("To verify that user gets the same name as 'Assessment'.");
	//	String before_rename = datastreamIndexPage.getAssessmentNamemainPage();
		if (datastreamVerificationPage.verifyAssessment(name)) {
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
	public void verifyRenameAssessment(){
		
		int numOfFailure = 0;
		int step=1;
		
		log("Test Case Id : <b>"+"TC_DS_10 </b>");
		log("Testcase Description : To verify Rename Assessment functionality. ");
		log("Step "+step++ +" : Open URL :<a>" + testUrl + "</a>");
		Common.pause(2);
		
		log("Step "+step++ +" : Login with valid credentials.");
		loginIndexPage.loginWithGoogleFull("tarpan.patel@kiwiqa.com","Taps@107");
		
		log("To verify that user Logged In successfully.");
		if (loginVerificationPage.verifyAfterLogin()) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		log("Step "+step++ +" : Go to Datastream dashboard.");
		datastreamIndexPage.clickDatastream();
		
		log("Step "+step++ +" : Open First Datastream.");
		datastreamIndexPage.clickFirstDatastream();
		
		String before_rename = datastreamIndexPage.getAssessmentNamemainPage();
		log("Assessment Name before 'Rename' :: "+before_rename);
		
		datastreamIndexPage.clickEditIconAssmnt();
		
		log("To verify that user gets same Assessment name displaying in datastream.");
		if (datastreamVerificationPage.verifyExistAssessmentName(before_rename)) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		log("Step "+step++ +" : Rename Assessment.");
		String rename = TestData.rndmTitle(3);
		datastreamIndexPage.renameAssessment(rename);
		datastreamIndexPage.clickNextbtn();
		
		WebElement notify = driver.findElement(By.xpath("//notify[@class='ng-scope']/div"));
		String msg = notify.getText();
		
		log("To verify user gets Notification message after the 'Rename Assessment'.");
		if (datastreamVerificationPage.verifyNotifymessage(msg,before_rename)) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		String after_rename = datastreamIndexPage.getAssessmentNamemainPage();
		
		log("To verify renamed Assessment reflects on datastream page.");
		if (datastreamVerificationPage.verifyAfterEditname(after_rename)) {
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
	public void  verifyCheckedSignalsonDashboard() throws IOException{
		
		int numOfFailure = 0;
		int step=1;
		
		log("Test Case Id : <b>"+"TC_DS_17</b>");
		log("Testcase Description : To verify user can filter Assessmet Dashboard's Input Signal by available individual Input Signal.");
		log("Step "+step++ +" : Open URL : <a>" + testUrl + "</a>");
		Common.pause(2);
		
		log("Step "+step++ +" : Login with valid credentials.");
		loginIndexPage.loginWithGoogleFull(TestData.getUsernameGP(),TestData.getPasswordGP());
		
		log("To verify that user Logged In successfully.");
		if (loginVerificationPage.verifyAfterLogin()) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		log("Step "+step++ +" : Go to Datastream dashboard.");
		datastreamIndexPage.clickDatastream();
		
		log("Step "+step++ +" : Open First Datastream.");
		datastreamIndexPage.clickFirstDatastream();
		
		log("Step "+step++ +" : Open 'Signals' page.");
		datastreamIndexPage.clickSignalsbtn();
		
		ArrayList<String> signalsList = new ArrayList<>();
		signalsList = datastreamIndexPage.getSinalsfromCSV(TestData.getCSVPath());
		
		log("To verify All the Input Singals displaying are Same as Displaying in CSV file.");
		if (datastreamVerificationPage.verifyAllSignalsName(signalsList)) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		int signals = datastreamIndexPage.countallSignals();
		log("Total Checked 'Input-Signals' : <b>"+signals+"</b>");
		datastreamIndexPage.clickClosebtn();
		
		log("Step "+step++ +" : Count Input-Signals from the Dashboard.");
		int s_d = datastreamIndexPage.countAllSignalsonDashboard();
		log("Total 'Input Signal's Chart' displaying on the Dashboard : <b>"+s_d+"</b>");
	
		
		log("To verify that Selected Signals count should be same as Signals Displaying on Dashboard.");
		if (s_d==signals) {
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
	public void addNewManualDatastream() throws AWTException, IOException{
		
		int numOfFailure = 0;
		int step=1;
		
		log("Test Case Id : <b>"+"TC_DS_25</b>");
		log("Testcase Description : To verify Add 'New Manaul DataStream' functionality and Delete Datastream functionality. ");
		log("Step "+step++ +" : Open URL :<a>" + testUrl + "</a>");
		Common.pause(2);
		
		log("Step "+step++ +" : Login with valid credentials.");
		loginIndexPage.loginWithGoogleFull(TestData.getUsernameGP(),TestData.getPasswordGP());
		Common.pause(1);
		
		log("To verify that user Logged In successfully.");
		if (loginVerificationPage.verifyAfterLogin()) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		log("Step "+step++ +" : Open 'Datastream' dashboard.");
		datastreamIndexPage.clickDatastream();
		
		log("Step "+step++ +" : 'Add new Manual Datastream'.");
		datastreamIndexPage.clickAddnewDatastream();
		
		String name = TestData.rndmTitle(5);
		datastreamIndexPage.enterName(name);
		datastreamIndexPage.selectDatastream("Standalone");
		datastreamIndexPage.clickNextbtn();
		datastreamIndexPage.selectTypeDatastream("Manual Setup");
		datastreamIndexPage.selectTimeField("time");
		
		datastreamIndexPage.enterTime("time");
		datastreamIndexPage.selectTimeFormat("Unix Time Milliseconds");
		datastreamIndexPage.enterEntity("person");
		datastreamIndexPage.clickDataStreamSavebtn();
		
		WebElement notify = driver.findElement(By.xpath("//notify[@class='ng-scope']/div"));
		String msg = notify.getText();
		
		log("To verify user gets Successful message after click on Save button.");
		if (datastreamVerificationPage.verifySuccessfulDatastreamMessage(msg, name)) {
			Common.logStatus("pass");
		} else {
			Common.logStatus("fail");
			numOfFailure ++;
		}
		
		datastreamIndexPage.clickClosebtn();
		
		datastreamIndexPage.deleteDatastream(name);
		
		
		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	}
	
	
}
