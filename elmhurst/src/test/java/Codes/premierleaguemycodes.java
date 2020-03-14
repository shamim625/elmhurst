package Codes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class premierleaguemycodes {
	static WebDriver driver;
	static String[][] tableValue;
	static int rowCount, colCount;
	private static final String FILE_NAME="./excel/premierleague.xls";
	

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.premierleague.com/tables");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[contains(text(),'I accept cookies from this site')]")).click();
		
		driver.findElement(By.xpath("//*[contains(text(),'First Team')]")).click();
		Thread.sleep(4000);

		
		List<WebElement> rows= driver.findElements(By.xpath("(//table)[1]/tbody/tr"));
		rowCount= rows.size();
		List<WebElement> col = driver.findElements(By.xpath("//div[2]/div[1]/div[4]/div/div/div/table/thead/tr/th"));
		colCount= col.size();
		
		tableValue= new String[rowCount][colCount];
		
		System.out.println("Row size:"+rows.size());
		System.out.println("Column size:"+col.size());

		for (int i=1; i<rowCount; i=i++) {
			for(int j=1; j<=colCount; j++) {
				if (i==1) {
					
					tableValue[i-1][j-1] = driver.findElement(By.xpath("//div[1]/div[4]/div/div/div/table/thead/tr["+i+"]/th["+j+"]")).getText();
					System.out.println(driver.findElement(By.xpath("//div[2]/div[1]/div[4]/div/div/div/table/thead/tr["+i+"]/th["+j+"]")).getText());
					
					tableValue[i-1][j-1]= driver.findElement(By.xpath("//div[2]/div[1]/div[4]/div/div/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.println(driver.findElement(By.xpath("//div[2]/div[1]/div[4]/div/div/div/table/tbody/tr["+i+"]/td["+j+"]")).getText());
				}
				
			}
		}
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet= workbook.createSheet("Datatypes in java");
		
		System.out.println("Creating excel");
		
		for (Object[] datatype:tableValue) {
			int rowNum=0;
			Row row= sheet.createRow(rowNum++);
			int columnNum=0;
			for(Object field: datatype) {
				Cell cell= row.createCell(columnNum++);
				if(field instanceof String) {
					cell.setCellValue((String) field);
				}
				else if (field instanceof Integer) {
					cell.setCellValue((Integer)field);
				}
			}
		}
		
		try {
			FileOutputStream output= new FileOutputStream(FILE_NAME);
		workbook.write(output);
		}
		catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            workbook.close();
        }
		
		System.out.println("Done");
		
		driver.close();
	}

}
