package com.falkonry.datastream.indexpage;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.falkonry.datastream.verification.DatastreamVerificationPage;
import com.falkonry.init.AbstractPage;
import com.falkonry.init.Common;
import com.falkonry.login.verification.LoginVerificationPage;

public class DatastreamIndexPage extends AbstractPage{

	public DatastreamIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//ul//a[contains(.,'Datastreams')]")
	WebElement datastream;
	@FindBy(xpath="//ul//a[contains(.,'Account')]")
	WebElement account;
	@FindBy(xpath="//table[@id='datastream-table']/tbody/tr[1]/td[3]")
	WebElement first_datastream;
	
	public DatastreamVerificationPage clickDatastream() {
		Common.pause(1);
		Common.clickOn(driver, datastream);
		log("Clicked on 'Datastream' menu from Leftside.");
		Common.pause(3);
		return new DatastreamVerificationPage(driver);
	}
	
	public DatastreamIndexPage clickFirstDatastream(){
		
		WebElement selected = driver.findElement(By.xpath("//div[@class='datastream-title ng-binding ng-scope']"));
		log("first Datastream : "+selected.getText());
		Common.clickOn(driver, first_datastream);
		log("Clicked on this Datastream. ");
		Common.pause(3);
		return new DatastreamIndexPage(driver);
	}
	
	public DatastreamVerificationPage clickAccount() {	
		Common.clickOn(driver, account);
		log("Clicked on 'Account' menu.");
		return new DatastreamVerificationPage(driver);
	}
	
	public DatastreamVerificationPage clickNewlyCreatedDatastream(String s){
		
		String xpath = "//div[contains(text(),'"+s+"')]";
		WebElement name = driver.findElement(By.xpath(xpath));
		name.click();
		log("Clicked on : "+s);
		return new DatastreamVerificationPage(driver);
	}
	
	
	@FindBy(xpath="//a[contains(.,'Add new Datastream')]")
	WebElement add_new_datastream;
	
	public DatastreamVerificationPage clickAddnewDatastream() {	
		Common.clickOn(driver, add_new_datastream);
		log("Clicked on 'Add new Datastream' link.");
		Common.pause(2);
		return new DatastreamVerificationPage(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Name your Datastream']")
	WebElement name;
	
	@FindBy(xpath="//div[@title='Choose Datastream Type']")
	WebElement datastream_dropdown;
	
	@FindBy(xpath="//div[contains(text(),'Standalone')]")
	WebElement datastream_option;
	
	@FindBy(xpath="//button[@id='next_create']")
	WebElement next_button;
	
	public DatastreamVerificationPage enterName(String n){	
		Common.type(name, n);
		log("Entered Datastream Name :: <b>"+n+"</b>");
		return  new DatastreamVerificationPage(driver);
	}
	
	public DatastreamVerificationPage selectDatastream(String n){	

		String xpath = "//div[contains(text(),'"+n+"')]";
		Common.clickOn(driver, datastream_dropdown);
		driver.findElement(By.xpath(xpath)).click();
		log("Selected Datastream :: "+driver.findElement(By.xpath("//div[@title='Choose Datastream Type']/a/span[2]/span")).getText());
		return  new DatastreamVerificationPage(driver);
	}
	
	public DatastreamVerificationPage selectTypeDatastream(String s){
		WebElement type = driver.findElement(By.xpath("//div[@id='add_datastream_panel']/div[2]//fieldset/div[1]/div/div/a/span[2]/span"));
		type.click();
		
		String xpath = "//div[contains(text(),'"+s+"')]";
	
		WebElement type_data = driver.findElement(By.xpath(xpath));
		type_data.click();
		log("Type of DataStream selected : <b>"+s+"</b>");
		Common.pause(1);
	return  new DatastreamVerificationPage(driver);
	}
	
	
	public DatastreamVerificationPage clickNextbtn(){	
		Common.clickOn(driver, next_button);
		log("Clicked on 'NEXT' button.");
		Common.pause(3);
		return  new DatastreamVerificationPage(driver);
	}
	
	
	
	public DatastreamVerificationPage clickDatastreamNextbtn(){	
		WebElement next =  driver.findElement(By.xpath("//div/button[2][contains(text(),'Next')]"));
		next.click();
		log("Clicked on 'NEXT' button.");
		Common.pause(3);
		return  new DatastreamVerificationPage(driver);
	}
	
	public DatastreamVerificationPage selectedTypeDatastream(){
		
		WebElement type_data = driver.findElement(By.xpath("//span[contains(text(),'File')]"));
		log("Type of DataStream : <b>"+type_data.getText()+"</b>");
		Common.pause(1);
		return new DatastreamVerificationPage(driver);
	} 
	
	public LoginVerificationPage uploadFile() throws AWTException, IOException{
		
		WebElement upload = driver.findElement(By.xpath("//div[contains(text(),'Select or Drop CSV or JSON file here')]"));
		
		String filepath = "C:/Users/KSPL08/Downloads/source1.csv";	
		Actions action = new Actions(driver);
		action.moveToElement(upload).click().build().perform();
		
		Common.pause(1);
		Runtime.getRuntime().exec("D:/FalkonryAutomation/Falkonry/Resources/fileupload.exe");
		Common.pause(2);
		driver.findElement(By.xpath("//html/body/input")).sendKeys(filepath);

		log("'CSV' file Uploaded successfully");
		Common.pause(7);
		
		return new LoginVerificationPage(driver);
	}

	public DatastreamVerificationPage selectTimeField(String s){
		
		WebElement drop = driver.findElement(By.xpath("//span[contains(text(),'Select time field')]"));
		Common.clickOn(driver, drop);
		
		String xpath = "//div[contains(text(),'"+s+"')]";
		driver.findElement(By.xpath(xpath)).click();
		log("Selected 'Time Field': <b>"+s+"</b>");
		return new DatastreamVerificationPage(driver);
	}
	
	public DatastreamVerificationPage selectEntity(String e){
		
		WebElement drop = driver.findElement(By.xpath("//span[contains(text(),'None')]"));
		Common.clickOn(driver, drop);
		
		String xpath = "//div[contains(text(),'"+e+"')]";
		driver.findElement(By.xpath(xpath)).click();
		log("Selected 'Entity  Field': <b>"+e+"</b>");
		return new DatastreamVerificationPage(driver);
	}
	
	
	public DatastreamVerificationPage addDatastreamFull(String name , String option){
		
		enterName(name);
		selectDatastream(option);
		clickNextbtn();
		Common.pause(2);
		return new DatastreamVerificationPage(driver);
	} 

	
	@FindBy(xpath="//div[@id='datastream-detail-tabpanel']/div[2]/button/i[@class='md md-mode-edit']")
	WebElement edit_assement;
	
	public DatastreamVerificationPage clickEditIconAssmnt(){
		
		Common.clickOn(driver, edit_assement);
		log("Clicked on 'Edit' icon of Assessment.");
		Common.pause(2);
		return new DatastreamVerificationPage(driver);
	}
	
	
	@FindBy(xpath="//div[@id='add_assessment_panel']//input")
	WebElement original_assement_name;

	public DatastreamVerificationPage renameAssessment(String rename){
		
		Common.type(original_assement_name, rename);
		log("Renamed Assessment to :: <b>"+rename+"</b>");
		Common.pause(2);
		return new DatastreamVerificationPage(driver);
	}
	
	@FindBy(xpath="//div[@class='display-inline-block']/div/a/span[2]/div")
	WebElement assmnt_on_datastream;
	
	public String getAssessmentNameRenamepage(){
		String actual_name = driver.findElement(By.xpath("//div[@id='add_assessment_panel']//input")).getAttribute("value");
		return actual_name;
	}
	
	public String getAssessmentNamemainPage(){		
		String name = assmnt_on_datastream.getText();
		return name;
	}
	
	
	@FindBy(xpath="//button[contains(text(),'Signals')]")
	WebElement Signal_btn;
	
	public DatastreamVerificationPage clickSignalsbtn(){
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Signals')]")));
		
		Common.clickOn(driver, Signal_btn);
		log("Clicked on 'Signal' button.");
		Common.pause(2);
		return new DatastreamVerificationPage(driver);
	}
	
	@FindBy(xpath="//div[@id='signal_filter_panel']//label/input[@class='ng-pristine ng-valid ng-touched']")
	WebElement select_deselect_all_checkbox;
	
	public DatastreamVerificationPage checkSelectDeselectAllSignals(){
		
		Common.clickOn(driver, select_deselect_all_checkbox);
		log("Checked 'Select / Deselect All Signals' checkbox .");
		Common.pause(1);
		return new DatastreamVerificationPage(driver);
	}
	
	public int countAllSignals(){
		
		List <WebElement> signals = driver.findElements(By.xpath("//tr[@class='ng-scope']"));
		int signals_count = signals.size();
		
		return  signals_count;
	}
	
	public int countAllSignalsonDashboard(){
		
		List <WebElement> signals = driver.findElements(By.xpath("//div[@class='graph-legend-alias']/a"));
		int signals_count = signals.size();
		
		return  signals_count;
	}
	
	public int signalsDisplay(){
		int i=0;
		if(driver.findElement(By.xpath("//div[@class='checkbox p-l-0']/label/input")).isSelected()){
		 i = countAllSignals();
		 log("All the Input-Signals are already checked.");
		 log("And Total Signals Checked :- <b>"+i+"</b>");
		} 
		else{
			driver.findElement(By.xpath("//div[@class='checkbox p-l-0']/label/input")).click();
			Common.pause(1);
			log("Checked 'Select All / Deselect All' checkbox.");
			i = countAllSignals();
			log("Total Signals checked :-+<b>"+i+"</b>");
		}
		
		return i;
	}
	
	
	@FindBy(xpath="//div[@id='signal_filter_panel']//button[Contains(text(),'Save')]")
	WebElement save_btn_signal;
	
	public DatastreamVerificationPage clickSignalSavebtn(){
		
		Common.clickOn(driver, save_btn_signal);
		log("Clicked on 'Save' button.");
		Common.pause(3);
		return new DatastreamVerificationPage(driver);
	}
	
	@FindBy(xpath="//button/span[contains(text(),'Save')]")
	WebElement save_btn_datastream;
	
	public DatastreamVerificationPage clickDataStreamSavebtn(){
		
		Common.clickOn(driver, save_btn_datastream);
		log("Clicked on 'Save' button.");
		Common.pause(2);
		return new DatastreamVerificationPage(driver);
	}
	
	public int countallSignals(){
		
		int i =0;
		List<WebElement> signals = driver.findElements(By.xpath("//input[@class='m-b-0 ng-pristine ng-untouched ng-valid']"));
		
		for(WebElement w : signals){
			if(w.isSelected()){
				i = i+1;
			}
				}
		
		return i;
	}
	
	@FindBy(xpath="//i[@class='md md-close']")
	WebElement close;
	
	public DatastreamVerificationPage clickClosebtn(){
		
		Common.clickOn(driver, close);
		log("Clicked  on 'Close' icon.");
		Common.pause(2);
		return new DatastreamVerificationPage(driver);
	}
	
	@FindBy(xpath="//input[@class='form-control ng-pristine ng-valid ng-touched']")
	WebElement time_input;
	public DatastreamVerificationPage enterTime(String t){
				
		Common.type(time_input, t);
		log("Entered Time Field : <b>"+t+"</b>");
		return new DatastreamVerificationPage(driver);
	}
	
	@FindBy(xpath="//input[@class='form-control ng-pristine ng-valid ng-touched']")
	WebElement entity_input;
	public DatastreamVerificationPage enterEntity(String t){
				
		Common.type(entity_input, t);
		log("Entered Entity  : <b>"+t+"</b>");
		return new DatastreamVerificationPage(driver);
	}
	
	public DatastreamVerificationPage selectTimeFormat(String t){
		
		WebElement drop = driver.findElement(By.xpath("//span[contains(text(),'Select time format')]"));
		Common.clickOn(driver, drop);
		
		String xpath = "//div[contains(text(),'"+t+"')]";
		driver.findElement(By.xpath(xpath)).click();
		log("Selected 'Time Format': <b>"+t+"</b>");
		return new DatastreamVerificationPage(driver);
	}
	
	
	public DatastreamVerificationPage deleteDatastream(String s){
		
	String xpath = "//tr/td[3]/div[contains(text(),'"+s+"')]/../../td[9]//button[3]/i";	
	WebElement w = driver.findElement(By.xpath(xpath));	
		
	w.click();
	log("Clicked on 'Delete' icon.");
	
		return new DatastreamVerificationPage(driver);
	}
	
	
	public ArrayList<String> getSinalsfromCSV(String path) throws IOException{
		
		String inputPath = path; 
		FileReader fr  = new FileReader(inputPath); 
		BufferedReader br = new BufferedReader(fr); 
	//	String line = null; 
		ArrayList<String> myList = new ArrayList<String>(); 
		String [] l = br.readLine().split(","); 
		
		for(int i=2;i<l.length ; i++ ){
		//System.err.println(l[i]);
		myList.add(l[i]);
		
		}
		log("Total No. of Signals in CSV : <b>"+myList.size()+"</b>");
		return myList;
		
	}
	
	


}
	

