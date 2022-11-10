package flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class test {
	
	//@SuppressWarnings("deprecation")
	@Test
	public void test1() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sian2013\\Documents\\dependencies\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	
	Thread.sleep(2000);
	String ex="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	String ac=driver.getTitle();
	Assert.assertEquals(ac, ex, "Title is mismatched");
	
	WebElement phone=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
	phone.sendKeys("9097816210");
	WebElement pwd=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
	pwd.sendKeys("qwertyuiop@123");
	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
	
	//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//deprecated error
	
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
	WebElement cart = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", cart);
	cart.click();
	}
}
