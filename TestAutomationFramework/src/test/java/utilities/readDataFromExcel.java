package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class readDataFromExcel {

	/*public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
	{
		readDataFromExcel read = new readDataFromExcel();
		read.getData("logindetails");
	}*/
	
	@DataProvider(name = "exceldata")
	
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException, InterruptedException
	{
		String excelSheetName = m.getName();
		FileInputStream fis1 = new FileInputStream("C:\\Users\\nitis\\eclipse-workspace\\TestAutomationFramework\\src\\test\\resources\\testdata\\TestDataNew.xlsx");
		
		
		Workbook book = WorkbookFactory.create(fis1);
	    Sheet s = book.getSheet(excelSheetName);
	    Row r = s.getRow(1);
   	    String value = r.getCell(0).getStringCellValue();
   	    //System.out.println(value);
   	    
   	    int lengthroww = s.getLastRowNum();
   	    //System.out.println(lengthroww);
   	    int lengthcelll = r.getLastCellNum();
   	    //System.out.println(lengthcelll);
   	    
   	 DataFormatter formatter = new DataFormatter();
   	    
   	    
   	 //this only says this is the variable and it holds 2 dimentional array
   	 String testdata[][] = new String[lengthroww][lengthcelll];
   	 
   	     for(int a =1 ; a<= lengthroww ; a++)
   	     {
   	    	     for(int b = 0 ; b < lengthcelll ; b++)
   	    	     {
   	    	    	     //String allvalue = formatter.formatCellValue(s.getRow(a).getCell(b));
   	    	    	     //System.out.println(allvalue);
   	    	    	 
   	    	    	     testdata[a-1][b] = formatter.formatCellValue(s.getRow(a).getCell(b));
   	    	    	     //System.out.println(testdata[a-1][b]);
   	    	     }
   	     }
   	     
   	     return testdata;
	}

}
