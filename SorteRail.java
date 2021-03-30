package AssignmentWeek3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SorteRail {

	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		WebElement fromStation=driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("Chennai");
		WebElement autoSearch_From=driver.findElement(By.xpath("//div[@title='Chennai Egmore']"));
		wait.until(ExpectedConditions.visibilityOf(autoSearch_From));
		autoSearch_From.click();
		
		
		WebElement toStation=driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("Vill");
		WebElement autoSearch_To=driver.findElement(By.xpath("//div[@title='Villupuram Jn']"));
		wait.until(ExpectedConditions.visibilityOf(autoSearch_To));
		autoSearch_To.click();
		
		WebElement Table = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tbody//tr"));
		wait.until(ExpectedConditions.visibilityOfAllElements(Table));	
		List<WebElement> tableRows=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		int test=tableRows.size();
		System.out.println("No. of trains available:"+test);
		List<WebElement> tableCols=null;
		List<String> trainNames=new ArrayList<String>();
		
		for (WebElement eachRow : tableRows) {
			
			tableCols=eachRow.findElements(By.tagName("td")); 
			String showText=tableCols.get(1).getText();
			trainNames.add(showText);
		}
	
	Collections.sort(trainNames);
	Iterator<String> temp=trainNames.iterator();  
	while(temp.hasNext())
	{  
	System.out.println(temp.next()); 
	}
	
	}	
	
}


			
		

		
		
		

		
		
	




