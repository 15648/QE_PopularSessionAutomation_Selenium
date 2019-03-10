package perscholas.sba_selenium;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopularSessionRequirementTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dulce\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		//Scroll down to ‘Faded Short Sleeve T-shirts’
		JavascriptExecutor js1 =((JavascriptExecutor)driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
		js1.executeScript("arguments[0].scrollIntoView(true)", element);
		
		//Hover over ‘Faded Short Sleeve T-shirts’
		WebElement hoverItem1 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(hoverItem1).perform();
		
		//Click ‘Add to cart’
		WebDriverWait waitAdd1 = new WebDriverWait(driver, 10);
	    WebElement goToItem1 = waitAdd1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span")));
	    goToItem1.click(); 
	    driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span")).click();
		
	    //Click ‘Continue shopping’
	    WebDriverWait waitContinue1 = new WebDriverWait(driver, 10);
	    WebElement goToContinue1 = waitContinue1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")));
	    goToContinue1.click(); 
	    driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();
	    
	    //Scroll down to  ‘Printed Chiffon Dress’
	    JavascriptExecutor js2 =((JavascriptExecutor)driver);
	    WebElement element2 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[7]/div/div[1]/div/a[1]/img"));
	    js2.executeScript("arguments[0].scrollIntoView(true)", element2);
	  		
	    //Hover over ‘Printed Chiffon Dress’
	    WebElement hoverItem2 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[7]/div/div[1]/div/a[1]/img"));
	    Actions action2 = new Actions(driver);
	    action2.moveToElement(hoverItem2).perform();
	  		
	    //Click ‘Add to cart’
	    WebDriverWait waitAdd2 = new WebDriverWait(driver, 10);
	    WebElement goToItem2 = waitAdd2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"homefeatured\"]/li[7]/div/div[2]/div[2]/a[1]/span")));
	    goToItem2.click(); 
	    driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[7]/div/div[2]/div[2]/a[1]/span")).click();
	    
	    //Click ‘Continue shopping’
	    WebDriverWait waitContinue2 = new WebDriverWait(driver, 10);
	    WebElement goToContinue2 = waitContinue2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")));
	    goToContinue2.click(); 
	    driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();
	    
	    JavascriptExecutor jsCart =((JavascriptExecutor)driver);
	    WebElement elementCart = driver.findElement(By.xpath("//*//*[@id=\"header\"]/div[3]/div/div/div[3]/div"));
	    jsCart.executeScript("arguments[0].scrollIntoView(true)", element);
	    
		//Scroll to 'Cart'
		JavascriptExecutor top =((JavascriptExecutor)driver);
		WebElement topElement = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
		top.executeScript("arguments[0].scrollIntoView(true)", topElement);
	    
		//Hover ‘Cart'
		WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
		Actions action_cart = new Actions(driver);
		action_cart.moveToElement(dropDown).perform();
   	
		//Click ‘Cart’
		WebDriverWait cart = new WebDriverWait(driver, 10);
	    WebElement goToCart = 
	               cart.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")));
	    goToCart.click();
	    driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
	    
	    //Scroll to 'Total'
	    JavascriptExecutor total =((JavascriptExecutor)driver);
	    WebElement totalElement = driver.findElement(By.xpath("//*[@id=\"total_price\"]"));
	    total.executeScript("arguments[0].scrollIntoView(true)", totalElement);
	    
	}
	
//	@AfterClass
//	public static void tearDown() throws InterruptedException {
//		driver.close();
//	}
	
	@Test
	public void selectItemsTest() {
		String total = driver.findElement(By.xpath("//*[@id=\"total_price\"]")).getText();
		assertEquals("$34.91", total);
	}
	
}
