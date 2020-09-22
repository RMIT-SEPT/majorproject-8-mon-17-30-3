package septJUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksTesting {
	//WebDriver driver = new ChromeDriver();
	
	private static ChromeDriver driver;
	private static WebDriverWait wait;
	@BeforeAll
	public static void setup() {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);

	}
	
	@Test
	void Login_Negative_Test() {
		driver.get("http://localhost:3000/");
		String currentUrl = driver.getCurrentUrl();
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		String actualUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, actualUrl);
	}
	
	@Test
	void Login_Positve_Test() {
		driver.get("http://localhost:3000/");
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[1]")).sendKeys("pq@pq.com");;
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[2]")).sendKeys("password");
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		String actualUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, actualUrl);
	}
	
	@Test
	void Register_Account_From_Login_Negative_Case() {
		driver.get("http://localhost:3000/Register");
		String expected = driver.getCurrentUrl();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[1]")).sendKeys("Muhammad");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[2]")).sendKeys("Tariq");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[3]")).sendKeys("M@M.com");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[4]")).sendKeys("password");
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[5]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		String actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	
	@Test
	void Logging_in_registered_account() {
		driver.get("http://localhost:3000/");
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[1]")).sendKeys("M@M.com");;
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[2]")).sendKeys("password");
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		String actualUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, actualUrl);
	}
	
	// Found An Exception Not Clickable
	@Test
	void Create_a_Booking() {
		driver.get("http://localhost:3000/");
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[1]")).sendKeys("pq@pq.com");;
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[2]")).sendKeys("password");
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/a"));
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/form/body/header/div[2]/h1/a[2]")));
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/body/header/div[2]/h1/a[2]")).click();
		String actualUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, actualUrl);
	}

	@AfterAll
	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
