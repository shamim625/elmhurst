package premierleague;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  

public class ReadExcelFileDemo {

	public static void main(String[] args) throws Throwable   {  
		
		FileInputStream fis=new FileInputStream(new File("./excel/student.xls"));
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sheet=wb.getSheetAt(0);
		
		String value= sheet.getRow(3).getCell(0).getStringCellValue();
		
		System.out.println(value);
		
		sheet.getRow(6).getCell(0).setCellValue("Jahid");
		FileOutputStream fso= new FileOutputStream("./excel/student.xls");
		wb.write(fso);
        String jahid= sheet.getRow(6).getCell(0).getStringCellValue();
		
		System.out.println(jahid);
		
		
	}
}