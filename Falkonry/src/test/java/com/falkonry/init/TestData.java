package com.falkonry.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {


	
	public static String rndmString(int length) {
		String rnd1 = RandomStringUtils.randomAlphabetic(length);
		return rnd1;

	}


	public static int rndmNumber(int length) {

		Random randm = new Random();
		int numNoRange = randm.nextInt(length);
		return numNoRange;

	}
	
	public static String rndmmob() {

		Random randm = new Random();
		int i= randm.nextInt(999999);
		long x = i+5629000000L;
		String s = new StringBuilder().append(x).toString();
		return s;

	}



	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	static int hour1 = TestData.randBetween(7, 12); // Hours will be displayed
													// in between 9 to 22
	static int min = TestData.randBetween(0, 59);

	static int hour2 = TestData.randBetween(13, 20);

	public static String intime = hour1 + ":" + min;
	public static String outtime = hour2 + ":" + min;

	public static int diff = (((hour2) * 60) + min) - (((hour1) * 60) + min);

	public static String total_time = Integer.toString(diff);

	/**
	 * Get Data from the Excel
	 * @param sheetIndex
	 * @return
	 */

	public static Sheet getExcelSheet(int sheetIndex) {
		String dataFilePath = "Resources/DataConfigurations.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;

		try {

			/*System.out.println("full path " + datafile.getAbsolutePath()
					+ " con " + datafile.getCanonicalPath());*/

			FileInputStream inputStream = new FileInputStream(
					new File(fullpath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(sheetIndex);

			workbook.close();
			inputStream.close();

		} catch (Exception e) {

		}
		return firstSheet;
	}

	public static Sheet getExcelSheetforUser(int sheetIndex) {
		String dataFilePath = "Resources/data.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;

		try {

			/*System.out.println("full path " + datafile.getAbsolutePath()
					+ " con " + datafile.getCanonicalPath());*/

			FileInputStream inputStream = new FileInputStream(
					new File(fullpath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(sheetIndex);

			workbook.close();
			inputStream.close();

		} catch (Exception e) {

		}
		return firstSheet;
	}
	
	
	public static String getEmployeeCodeFromExcel() {
		
		DataFormatter formatter = new DataFormatter(); 
		 Cell cell = getExcelSheet(0).getRow(1).getCell(1);
		 String emp_code_login = formatter.formatCellValue(cell);
		 
		return emp_code_login;

	}

	
	public static String getLoginUrlCB() {

		return getExcelSheet(4).getRow(6).getCell(4).getStringCellValue();

	}
	

	public static int getlastRowcount(int sheetNo) {

		return getExcelSheet(sheetNo).getLastRowNum();
	}

	static Random randm = new Random();

	public static int rndmday() {
		int day = randm.nextInt(28 - 10) + 10;
		return day;
	}

	public static String rndmmonth() {

		ArrayList<String> month = new ArrayList<String>();

		month.add("Jan");
		month.add("Feb");
		month.add("Mar");
		month.add("Apr");
		month.add("May");
		month.add("Jun");
		month.add("Jul");
		month.add("Aug");
		month.add("Sep");
		month.add("Oct");
		month.add("Nov");
		month.add("Dec");

		int i = randm.nextInt(month.size());
		String month1 = month.get(i);
		return month1;
	}

	
	public static int rndmyear() {
		int start = 1970;
		int end = 1997;
		int day = randm.nextInt(end - start) + start;
		return day;
	}
	
	public static String rndmAccNo(){
		Random r = new Random();
		int a = r.nextInt(999999);
		int b = r.nextInt(999999);
		String c = new StringBuilder(20).append(a).append(b).toString();
		return c;
	}

	public static String rndBDY() {
		String final_bday = new StringBuilder(20).append(rndmday())
				.append(rndmmonth()).append(rndmyear()).toString();

		return final_bday;
	}
	
	 
	 public static String fathername() {
			String fathername = new StringBuilder(10).append("KiwQA").append(rndmString(3)).toString();
			return fathername;
		}
	
	 			/**
	 			 * Getting Downloaded file path
	 			 * @param sheetIndex
	 			 * @return
	 			 */
	
	public static HSSFSheet getDonloadedExcelSheet(int sheetIndex) {
		String ss = "==download path system====";
		System.out.println("===*******====  "+ss);
		String dataFilePath = ss+"EmployeeMaster.xls";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		HSSFSheet firstSheet = null;

		try {

			/*System.out.println("full path " + datafile.getAbsolutePath()
					+ " con " + datafile.getCanonicalPath());*/

			FileInputStream inputStream = new FileInputStream(
					new File(fullpath));

			/*XSSFWorkbook(inputStream) */
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

			firstSheet = workbook.getSheetAt(sheetIndex);
			

			workbook.close();
			inputStream.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("====:"+firstSheet.getSheetName());
		
		return firstSheet;
	}
	
	public static String cell_data;
	public static short fg;
	public static short getcellData() {
		System.out.println(getDonloadedExcelSheet(0));
		cell_data = getDonloadedExcelSheet(0).getRow(3).getCell(1).getStringCellValue();
		
		System.out.println("--- :: "+cell_data);
		
		fg = getDonloadedExcelSheet(0).getRow(3).getCell(1).getCellStyle().getFillForegroundColor(); 
		System.out.println("-- :: "+fg); 
		
		return fg;

		 }
		
			 public static String rndmClassName() {
					String firstname = new StringBuilder(10).append("Kiwi_Test").append(rndmString(3)).append("Automation").toString();
					return firstname;
					}

			public static String rndmemail(int i , int j) {
				String email = new StringBuilder(30).append("Kiwi")
						.append(rndmNumber(i)).append(rndmString(j))
						.append("@mailinator.com").toString();

				return email;
			}	
			
			public static String rndmTitle(int i) {
				String sc = "Name "+rndmString(i)+" by Automation."+rndmString(i);

				return sc;
			}
			
			public static String rndmKiwiEmail(int i , int j) {
				String email = new StringBuilder(30).append("Kiwi")
						.append(rndmNumber(i)).append(rndmString(j))
						.append("@kiwiqa.com").toString();

				return email;
			}
			
			public static String getURL() {
				
				DataFormatter formatter = new DataFormatter(); 
				 Cell cell = getExcelSheet(0).getRow(3).getCell(1);
				 String url = formatter.formatCellValue(cell);
				 
				return url;

			}
			
			public static String getUsernameC() {
						
					DataFormatter formatter = new DataFormatter(); 
					 Cell cell = getExcelSheet(0).getRow(3).getCell(3);
					 String url = formatter.formatCellValue(cell);
						 
					return url;
		
				}

			public static String getPasswordC() {
			
				DataFormatter formatter = new DataFormatter(); 
				Cell cell = getExcelSheet(0).getRow(3).getCell(4);
				String url = formatter.formatCellValue(cell);
			 
				return url;
		
		}
			
			
			public static String getUsernameP() {
				
				DataFormatter formatter = new DataFormatter(); 
				 Cell cell = getExcelSheet(0).getRow(3).getCell(7);
				 String url = formatter.formatCellValue(cell);
				 
				return url;
	
			}

			public static String getPasswordP() {
				
				DataFormatter formatter = new DataFormatter(); 
				Cell cell = getExcelSheet(0).getRow(3).getCell(8);
				String url = formatter.formatCellValue(cell);
				 
				return url;
			}
		
			public static String getInvalidEmail() {
				
				DataFormatter formatter = new DataFormatter(); 
				 Cell cell = getExcelSheet(0).getRow(6).getCell(6);
				 String url = formatter.formatCellValue(cell);
				 
				return url;
	
			}

			public static String getInvalidPswd() {
				
				DataFormatter formatter = new DataFormatter(); 
				Cell cell = getExcelSheet(0).getRow(6).getCell(7);
				String url = formatter.formatCellValue(cell);
				 
				return url;
			}
			
			
			public static String getUsernameGP() {
				
				DataFormatter formatter = new DataFormatter(); 
				 Cell cell = getExcelSheet(0).getRow(3).getCell(3);
				 String url = formatter.formatCellValue(cell);
				 
				return url;
	
			}

			public static String getPasswordGP() {
				
				DataFormatter formatter = new DataFormatter(); 
				Cell cell = getExcelSheet(0).getRow(3).getCell(4);
				String url = formatter.formatCellValue(cell);
				 
				return url;
			}
					
			public static String getCSVPath() {
				
				DataFormatter formatter = new DataFormatter(); 
				Cell cell = getExcelSheet(0).getRow(10).getCell(3);
				String url = formatter.formatCellValue(cell);
				 
				return url;
			}
			
			
		/**
		 * User Email id and Password data into data.xls file
		 */
			
			public static XSSFSheet ExcelWSheet;
			 
			public static XSSFWorkbook ExcelWBook;
 
			public static XSSFCell Cell;
 
			public static XSSFRow Row;
 
		public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
 
		   String[][] tabArray = null;
 
		   try {
 
			   FileInputStream ExcelFile = new FileInputStream(FilePath);
 
			   // Access the required test data sheet
 
			   ExcelWBook = new XSSFWorkbook(ExcelFile);
 
			   ExcelWSheet = ExcelWBook.getSheet(SheetName);
 
			   int startRow = 1;
			   int startCol = 1;
			   int ci,cj;
			   int totalRows = ExcelWSheet.getLastRowNum();
 
 
			   int totalCols = 2;
 
			   tabArray=new String[totalRows][totalCols];
 
			   ci=0;
 
			   for (int i=startRow;i<=totalRows;i++, ci++) {           	   
 
				  cj=0;
 
				   for (int j=startCol;j<=totalCols;j++, cj++){
 
					   tabArray[ci][cj]=getCellData(i,j);
 
					   System.out.println(tabArray[ci][cj]);  
 
						}
					}
				}
 
			catch (FileNotFoundException e){
 
				System.out.println("Could not read the Excel sheet");
 
				e.printStackTrace();
 
				}
 
			catch (IOException e){
 
				System.out.println("Could not read the Excel sheet");
 
				e.printStackTrace();
 
				}
 
			return(tabArray);
 
			}
		

		public static String getCellData(int RowNum, int ColNum) throws Exception {
 
			try{
 
				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
 
				int dataType = Cell.getCellType();
				System.out.println("==--- >> "+dataType +"==--->>"+Cell);
				if  (dataType == 3) {
 
					return "";
 
				}else{
 
					String CellData = Cell.getStringCellValue();
 
					return CellData;
				}}
				catch (Exception e){
 
				System.out.println(e.getMessage());
 
				throw (e);
 
		}}
		
			
}
	

