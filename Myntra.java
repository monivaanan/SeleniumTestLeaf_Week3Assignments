package AssignmentWeek3;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		/*** Mouse over ***/
		Actions action=new Actions(driver);
		WebElement mouseOver=driver.findElement(By.xpath("(//a[@class='desktop-main'])[2]"));
		action.moveToElement(mouseOver).perform();
		//System.out.println("Mouse Hovered");
		Thread.sleep(2000);
		/*** Click Jackets and Coats ***/
		WebElement jandc=driver.findElement(By.linkText("Jackets & Coats"));
		jandc.click();
		Thread.sleep(2000);
		
		/*** Check Total items returned in Jackets and Coats page ***/
		WebElement itemNumbers=driver.findElement(By.xpath("//span[@class='title-count']"));
		String totalCount=itemNumbers.getText();
		String tc=totalCount.replaceAll("[\\-\\s a-zA-Z]", "");
		//System.out.println(tc);
		int totalItems=	Integer.parseInt(tc);
		System.out.println("There are "+totalItems+" available now");
		
		
		/*** Get items count by each category and get the sum of both (jackets and Coats)  ***/
		List<WebElement> categories=driver.findElements(By.xpath("//span[@class='categories-num']"));
		int sumofCategories=0;
		for (WebElement category : categories) 
		{
			String noc_value=category.getText();
			//System.out.println(noc_value);
			String eachCategory=noc_value.replaceAll("[\\()]","");
			System.out.println(eachCategory);
			int eachCat=Integer.parseInt(eachCategory);
			sumofCategories=sumofCategories+eachCat;
		
	}
		
		//System.out.println("There are "+sumofCategories+" available");
		
		/*** Sum of Categories matches with total items  ***/
		if(totalItems==sumofCategories) 
		{
			System.out.println("Sum of Categories matches with total items " +totalItems);
		}
		/*** Click on Coats check box***/
		WebElement coats_ChkBox=driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]"));
		coats_ChkBox.click();
		Thread.sleep(2000);
		/*** Click on MoreBrands ***/
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement searchBrand=driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']"));
		wait.until(ExpectedConditions.visibilityOf(searchBrand));
		searchBrand.sendKeys("MANGO");
		/***Select Mango ***/
		driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div[1]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		Thread.sleep(2000);
		/***Sort by better discount ***/
		Actions action2=new Actions(driver);
		WebElement mouseOver2=driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		action2.moveToElement(mouseOver2).perform();
		//System.out.println("Mouse Hovered");
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();  
		
		/*** Get the first selected item price ***/
		String price=driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("The first item Price from Mango is "+price);
		/***Mouse hover****/
		Actions action3=new Actions(driver);
		WebElement mouseOver3=driver.findElement(By.xpath("//ul[@class='results-base']//li[1]"));
		action3.moveToElement(mouseOver3).perform();
		//System.out.println("Mouse Hovered");
		/***Click on Wishlist***/
		driver.findElement(By.xpath("//span[@class='product-wishlistFlex product-actionsButton product-wishlist ']")).click();
		
		driver.close();
		
	}
	
}
