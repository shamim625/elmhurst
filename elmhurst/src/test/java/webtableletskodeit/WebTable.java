package webtableletskodeit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	static WebDriver driver;

	public static void main(String[] args) throws Throwable {
 System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		List row= driver.findElements(By.xpath("//table/tbody/tr"));
		int rowsize= row.size();
		System.out.println("Number of rows:"+rowsize);
		
		List column= driver.findElements(By.xpath("//table/tbody/tr/th"));
		int columnsize= column.size();
		System.out.println("Number of columns:"+columnsize);
		
		List<WebElement> headers= driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		List<WebElement> column1= driver.findElements(By.xpath("//table/tbody/tr[2]/td"));
		List<WebElement> column2= driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
		List<WebElement> column3= driver.findElements(By.xpath("//table/tbody/tr[4]/td"));
		
		
		for (WebElement header: headers){
			
			System.out.println("Header:"+header.getText());
			
		}
		for(WebElement col1:column1) {
			System.out.println("First row:"+col1.getText());
		}
		for(WebElement col2:column2) {
			System.out.println("Second row:"+col2.getText());
		}
		for(WebElement col3:column3) {
			System.out.println("Third row:"+col3.getText());
		}
		
		FileOutputStream fileoutput = new FileOutputStream("./excel/letskodeit.xlsx");                                 

		XSSFWorkbook workbook = new XSSFWorkbook();       
		XSSFSheet sheet = workbook.createSheet("DataStorage"); 

		for (int i=1;i<=rowsize;i++)      
		{ 
			XSSFRow excelRow = sheet.createRow(i);
		for (int j=1; j<=columnsize;j++)                    
		{  
			XSSFCell excelCell = excelRow.createCell(j);
		if (i==1)       
		{           
		WebElement headervalue= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th["+j+"]"));             
		String  a = headervalue.getText();            
		System.out.print(a);                        
             
		                             
		excelCell.setCellValue(a);  

		//wkb.write(fos);       
		}       
		else        
		{           
		WebElement columnvalue= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]"));             
		String b = columnvalue.getText();                    
		System.out.print(b);                            
                                       
		excelCell.setCellValue(b);   

		//wkb.write(fos);       
		}       
		}               
		System.out.println();     
		}     
		fileoutput.flush();     
		workbook.write(fileoutput);     
		fileoutput.close();
		
		
		driver.close();
	}

}
