package AssignmentWeek3;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Appear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
			List<WebElement> flexbuttons=driver.findElements(By.xpath("//div[@class='flex']/button"));
			for (WebElement webElement : flexbuttons) {
				
				String buttonNames=webElement.getText();
				System.out.println(buttonNames);
				
			}
			
			 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			 WebElement newbutton=driver.findElement(By.xpath("//button[@id='btn']//b[1]"));
			 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btn")));
			if (newbutton.isDisplayed()) {
				
				String hiddenButton = driver.findElement(By.id("btn")).getText();
				
				System.out.println(hiddenButton);
			}
			else {
				System.out.println("Failed to load button");
			}
		
		
/****Method 2*******/
		
		/*	get the size of the list and text
		wait methods
		get the size of list and text
		compare two and display the newly added*/
		
		/*List<WebElement> b_buttons=driver.findElements(By.xpath("//div[@class='flex']/button"));
		List<String> beforeLoading=new ArrayList<String>();
		
		for(int i=0;i<b_buttons.size();i++) {
			System.out.println(b_buttons.get(i).getText());
			beforeLoading.add(b_buttons.get(i).getText());
			
		}
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));  //wait element
		wait.until(ExpectedConditions.visibilityOfAllElements(b_buttons)); 
		
		List<WebElement> a_buttons=driver.findElements(By.xpath("//div[@class='flex']/button"));
		List<String> afterLoading=new ArrayList<String>();
		
		for(int i=0;i<a_buttons.size();i++) {
			System.out.println(a_buttons.get(i).getText());
			afterLoading.add(a_buttons.get(i).getText());
			
		}
		
		afterLoading.removeAll(beforeLoading);
		System.out.println(afterLoading);*/
			
	
		}



	}


