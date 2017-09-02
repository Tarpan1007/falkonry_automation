package com.falkonry.datastream.verification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.falkonry.init.AbstractPage;

public class DatastreamVerificationPage extends AbstractPage{

	public DatastreamVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyExistAssessmentName(String name){
		
		String actual_name = driver.findElement(By.xpath(".//div[@id='add_assessment_panel']//input")).getAttribute("value");
		if(actual_name.equals(name)){
			log("<b>Verified Actual Assessment name :: "+actual_name+"</b>");
			return true;
		}	
		else{
		log("Different Assessment name is displaying while Edit.");
		return false;
			}
		}

	public boolean verifyAfterEditname(String name){
		
		String actual_name = driver.findElement(By.xpath(".//div[@class='display-inline-block']/div/a/span[2]/div")).getText();
		if(actual_name.equals(name)){
			log("<b>Verified Assessment name after Rename :: "+actual_name+"</b>");
			return true;
		}	
		else{
		log("Assessment name is not updated after rename.");
		return false;
			}
		}
	
	public boolean verifyNotifymessage(String msg , String name){	

		String[] new_msg = msg.split("Assessment"); 
		String msg2 = "Assessment"+new_msg[1];
		
		String expected = "Assessment '"+name+"' updated successfully";
		if(msg2.equals(expected)){
			log("Message : <b>"+msg2+"</b>");
			return true;
		}
		else{
			log("Different message is displaying :- "+msg);
			return false;
		}
	}	
	
	public boolean verifySuccessfulDatastreamMessage(String msg , String name){	

		String[] new_msg = msg.split("Datastream"); 
		String msg2 = "Datastream"+new_msg[1];
		
		String expected = "Datastream '"+name+"' created successfully!";
		if(msg2.equals(expected)){
			log("Message : <b>"+msg2+"</b>");
			return true;
		}
		else{
			log("Different message is displaying :- "+msg);
			return false;
		}
	}
	
	
	public boolean verifyAfterUploadFile(){
		
		String s = driver.findElement(By.xpath("//div[contains(text(),'File: ')]")).getText();
		log("Verified message : <b>"+s+"</b>");
		return driver.findElement(By.xpath("//div[contains(text(),'File: ')]")).isDisplayed();
	}
	
	public boolean verifyDatastreamonDashboard(String s){
		
		String xpath = "//h3[contains(text(),'"+s+"')]";
		WebElement datastream = driver.findElement(By.xpath(xpath));
		log("Verified DataStream from dashboard : <b>"+datastream.getText()+"</b>");
		
		return datastream.isDisplayed();
	}
	
	@FindBy(xpath="//div[@class='display-inline-block']/div/a/span[2]/div")
	WebElement assmnt_on_datastream;
	
	public boolean verifyAssessment(String s){
		
		String actual = assmnt_on_datastream.getText();
		if(actual.equals(s)){
			log("Verified Assessment Name : <b>"+actual+"</b>");
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean verifyAllSignalsName(ArrayList<String> s){
		
		List<WebElement> signals = driver.findElements(By.xpath("//tr[@class='ng-scope']/td[2]/div"));
		ArrayList<String> signal_name = new ArrayList<>();
		for (WebElement w : signals){
			
			String name = w.getText();
			signal_name.add(name);
		}
		
		log("Total Input-Signals in drop-down : <b>"+signal_name.size()+"</b>");
		
		Collections.sort(s);
		Collections.sort(signal_name);
		
		log("<b>Input Signals from 'CSV' file :</b>");
		logList(s);
		log("<b>Input Signals from drop down list :</b>");
		logList(signal_name);
		
		return s.equals(signal_name); 
	}
}
