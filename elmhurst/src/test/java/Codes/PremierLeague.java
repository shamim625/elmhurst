package Codes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PremierLeague {
        static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.premierleague.com/tables");
		//driver.findElement(By.xpath("//*[@id='advertClose']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'I accept cookies from this site')]")).click();
		driver.manage().window().maximize();
		
		List<WebElement> teams = driver.findElements(By.xpath("//table/tbody/tr/td[3]/a/span[2]"));
		
		//List<WebElement> liverpool= driver.findElements(By.xpath("(//table/tbody/tr[1])[1]"));
		
		FileInputStream fis=new FileInputStream(new File("./excel/premierleague.xls"));
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sheet=wb.getSheetAt(0);
		FileOutputStream fso= new FileOutputStream(new File("./excel/premierleague.xls"));
		
		for (WebElement team: teams) {
			for(int i=0; i<teams.size();i++) {
				System.out.println(i+team.getText().trim());
				sheet.getRow(0);
				
			
			}
			
			System.out.println(team.getText().trim());
			sheet.getRow(0).getCell(0-19).setCellValue(team.getText().trim());
			wb.write(fso);
		}
		
//		for (WebElement liverpoolteam: liverpool) {
//			
//			
//			System.out.println(liverpoolteam.getText().trim());
//		}
		
		
		
		
		
		Thread.sleep(3000);
		driver.close();
	}

}
