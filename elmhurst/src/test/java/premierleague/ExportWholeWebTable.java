package premierleague;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExportWholeWebTable {

	public static void main(String[] args) throws Throwable {
		
		Document HTMLpageContent ;
        Elements table ;
        Elements header , bodyrows , rowContent;
        String data="",rowValue="",sy;
        File dir_1;
        File parent;
        PrintWriter pw ;
        WebDriver driver;

        
        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 driver.get("https://www.premierleague.com/tables/");
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
        
        
		 String time = new SimpleDateFormat("SSS").format(new Date());
		
        //Waiting for table containing data to appear
      
		 (new WebDriverWait(driver, 100))
	        .until(ExpectedConditions.elementToBeClickable(By.xpath("(//table)[1]"))); 
        
        List<WebElement> tabList= driver.findElements(By.xpath("//*[@class='tablist']/li"));
       Actions ac = new Actions(driver);
        
        for(WebElement tab:tabList) {
        
        	
        	ac.moveToElement(tab).click().build().perform();
        	
      //Creating a file of name 'filename'
        dir_1=new File("./excel/Premeier League Table "+tab.getText()+".csv"+"_time_"+""+time+"");
        parent=dir_1.getParentFile();
        if(!parent.exists())
          parent.mkdirs();
        pw = new PrintWriter(dir_1);
        sy=driver.getPageSource();//Getting the HTML source code
        HTMLpageContent = Jsoup.parse(sy);
        table = HTMLpageContent.getElementsByClass("wrapper col-12");
        header = table.tagName("th");
        bodyrows = table.tagName("tr");
        for(Element headerData:header)
          data+=headerData.text()+",";//Storing column names in string data
        data=data.substring(0,(data.length()-1));
        data+="\n";
        for(Element row:bodyrows)
        {
          rowContent=row.getElementsByTag("td");
          for(Element rowData:rowContent)
          {//Extracting data of a row and storing
            rowValue=rowData.text();//Some data may contain , in there data
            if(rowValue.contains(","))
            {
              rowValue=rowValue.substring(0,rowValue.indexOf(','))+rowValue.substring(rowValue.indexOf(',')+1);
            }
            data+=rowValue+",";
          }
          data=data.substring(0,(data.length()-1));
          data+="\n";
        }
        pw.write(data);
        pw.close();
        
       
        System.out.println("Successfull in generating Premeier League_"+tab.getText()+".csv");
       
        }

	}

}
