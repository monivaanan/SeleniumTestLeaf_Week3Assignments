package AssignmentWeek3;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TextChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //Implicit elememts to be loaded
		String retrieved_text = driver.findElement(By.id("btn")).getText(); //Get the text from button to be tested
		//System.out.println(retrieved_text);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));  //wait element
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("btn"), retrieved_text)); //check text to be disapperared from button
		WebElement button1=driver.findElement(By.id("btn")); //webelement created
		button1.click(); //click the button
		
		Alert alert = driver.switchTo().alert();  //Handling alert
		String alertMsg=driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		alert.accept();
		
		

	}

}
