package AssignmentWeek3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	//	System.setProperty("webdriver.chrome.driver","C:Program Files_chromedriver.exe");
		WebDriverManager.chromedriver().setup();  	
		WebDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement dateCheck=driver.findElement(By.id("chkSelectDateOnly"));
		boolean date_C=dateCheck.isSelected();
		if (date_C==false)
		{
			dateCheck.click();
		}
		
		WebElement fromStation=driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("Chennai");
		WebElement autoSearch_From=driver.findElement(By.xpath("//div[@title='Chennai Egmore']"));
		autoSearch_From.click();
		
		
		WebElement toStation=driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("Hyderabad");
		WebElement autoSearch_To=driver.findElement(By.xpath("//div[@title='Hyderabad Decan']"));
		autoSearch_To.click();
		
		Thread.sleep(2000);
		
		//WebElement Table = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tbody//tr"));
		Thread.sleep(2000);	
		List<WebElement> tableRows=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		int test=tableRows.size();
		System.out.println("No. of trains available:"+test);
		List<WebElement> tableCols=null;
		List<String> trainNames=new ArrayList<String>();
		
		for(int i=0;i<test;i++) {
			WebElement eachRow=tableRows.get(i);   
			tableCols=eachRow.findElements(By.tagName("td")); 
			Thread.sleep(2000);
			//System.out.println("No. of Columns\t:" +tableCols.size());
			String showText=tableCols.get(1).getText();
			trainNames.add(showText);
			System.out.println("Train Name:"+showText);
		}
		
		int listSize = trainNames.size();
		System.out.println("List Size:"+listSize);
		
		 Set<String> trainNamesSet = new HashSet<String>();
	     for (String listElements : trainNames)
	     trainNamesSet.add(listElements);
	     int setSize=trainNamesSet.size();
	     System.out.println("Set Size:"+setSize);
	
	}

}
