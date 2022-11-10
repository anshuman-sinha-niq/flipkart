package flipkart;

import org.testng.Assert;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	
	//@SuppressWarnings("deprecation")
	@Test
	public void test1() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sian2013\\Documents\\dependencies\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	
	//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//deprecated error
	
	//verifying whether flipkart site has opened or not
	Thread.sleep(2000);
	String ex="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	String ac=driver.getTitle();
	Assert.assertEquals(ac, ex, "Title is mismatched");
	
	WebElement phone=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
	phone.sendKeys("9097816210");
	WebElement pwd=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
	pwd.sendKeys("qwertyuiop@123");
	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
	
	Thread.sleep(1000);
	WebElement search=driver.findElement(By.className("_3704LK"));
	search.sendKeys("iphone");
	Thread.sleep(1000);
	driver.findElement(By.className("L0Z3Pu")).click();
	
	Thread.sleep(4000);
	String ex1="Iphone- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
	Assert.assertEquals(driver.getTitle(), ex1, "Title is mismatched");
	
	WebElement phonetext = driver.findElement(By.xpath("//*[text()='APPLE iPhone 11 (Black, 64 GB)']"));
	phonetext.click();
	
	Thread.sleep(4000);
	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	String ex2 ="APPLE iPhone 11 ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com";
	driver.switchTo().window(tabs.get(1));
	Assert.assertEquals(driver.getTitle(), ex2,"Title mismatched"); 
	
	WebElement cart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
	cart.click();
	Thread.sleep(3000);
	
	String ex3 ="Shopping Cart | Flipkart.com";
    Assert.assertEquals(driver.getTitle(), ex3,"Title mismatched 3");
	}
}
