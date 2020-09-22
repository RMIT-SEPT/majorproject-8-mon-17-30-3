
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

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;


public class LinksTesting {
	
	private static ChromeDriver driver;
	private static WebDriverWait wait;
	@BeforeAll
	public static void setup() {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);

	}
	
	@Test
	@SpiraTestCase(testCaseId = 24255)
	void Login_Negative_Test() {
		driver.get("http://localhost:3000/");
		String currentUrl = driver.getCurrentUrl();
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[3]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		String actualUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, actualUrl);
	}
	
	@Test
	@SpiraTestCase(testCaseId = 24256)
	void Login_Positve_Test() {
		driver.get("http://localhost:3000/");
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[1]")).sendKeys("pq@pq.com");;
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[2]")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[3]")).click();
		String actualUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, actualUrl);
	}
	
	@Test
	@SpiraTestCase(testCaseId = 24257)
	void Register_Account_From_Login_Negative_Case() {
		driver.get("http://localhost:3000/Register");
		String expected = driver.getCurrentUrl();
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[1]")).sendKeys("Muhammad");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[2]")).sendKeys("Tariq");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[3]")).sendKeys("M@M.com");
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[4]")).sendKeys("password");
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[5]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		String actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	
	@Test
	@SpiraTestCase(testCaseId = 24258)
	void Logging_in_registered_account() {
		driver.get("http://localhost:3000/");
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[1]")).sendKeys("M@M.com");;
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[2]")).sendKeys("password");
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[3]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		String actualUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, actualUrl);
	}
	
	// Found an exception Not Clickable
	@Test
	@SpiraTestCase(testCaseId = 24259)
	void Create_a_Booking() {
		driver.get("http://localhost:3000/");
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[1]")).sendKeys("M@M.com");;
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[2]")).sendKeys("password");
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div/form/input[3]"));
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/body/header/div/a[1]")));
		driver.findElement(By.xpath("/html/body/div/div/div/body/header/div/a[1]")).click();
		String actualUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, actualUrl);
	}
	

	@AfterAll
	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
