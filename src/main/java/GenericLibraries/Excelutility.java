package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	private Workbook workbook=null;

	/**
	 * This class contains reusable methods to perform operations on Excel
	 * @param filepath 
	 * @param args
	 */

		public void excelInit(String filepath)
		{
			FileInputStream fis=null;
			try {
				fis=new FileInputStream(filepath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				workbook= WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * this method reads single data at a time
		 * @param sheetname
		 * @param rownum 
		 * @param rownum 
		 * @param cell 
		 * @param  
		 * @return
		 */
		
		public String getDataFromExcel(String sheetname,  int rownum, int cell) {
			return workbook.getSheet(sheetname).getRow(rownum).getCell(cell).getStringCellValue();
		}
		
		/**
		 * thgis method is ysed to read data in key value pairs
		 * @param sheetName
		 * @param expectedTestName 
		 * @return
		 */
		public Map<String,String> getDataFromExcel(String sheetName, String expectedTestName){
			
			Map<String, String> map=new HashMap<>();
			DataFormatter df=new DataFormatter();
			
			Sheet sheet=workbook.getSheet(sheetName);
			
			for(int i=0; i<=sheet.getLastRowNum(); i++) {
				String actualTestName=df.formatCellValue(sheet.getRow(i).getCell(1));
				if(actualTestName.equals(expectedTestName)) 
				{
					for(int j=i; j<=sheet.getLastRowNum(); j++) {
					String key=df.formatCellValue(sheet.getRow(j).getCell(2));
					String value=df.formatCellValue(sheet.getRow(j).getCell(3));
					
					map.put(key, value);
					if(key.equals("####"))
						break;
					
				}
					break;
					
			}
			
		}
			return map;
		
	}
		public void writeDataTOexcel(String sheetName, String expectedTestName, Date status, String filepath) {
			FileInputStream fos=null;
		Map<String, String> map=new HashMap<>();
		DataFormatter df=new DataFormatter();
		
		Sheet sheet=workbook.getSheet(sheetName);
		
		for(int i=0; i<=sheet.getLastRowNum(); i++) {
			String actualTestName=df.formatCellValue(sheet.getRow(i).getCell(1));
			if(actualTestName.equals(expectedTestName)) {
				sheet.getRow(i).getCell(4).setCellValue(status);
				break;
			}
		}
		try {
			fos=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
		/**
		 * thos method is used to close the workbook.
		 */
		public void closeExcel()
		{
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		}
