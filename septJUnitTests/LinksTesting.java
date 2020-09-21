package septJUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksTesting {
	//WebDriver driver = new ChromeDriver();
	
	private static ChromeDriver driver;
	
	@BeforeAll
	public static void setup() {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

	}
	
	@Test
	void create_Account_Link_Negative_Test() {
		driver.get("http://localhost:3000/");
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("/html/body/div/div/div/form/a[1]")).click();
		String actualUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, actualUrl);
	}
	
	@Test
	void create_Account_Link_Positve_Test() {
		driver.get("http://localhost:3000/");
		String currentUrl = "http://localhost:3000/Register";
		driver.findElement(By.xpath("/html/body/div/div/div/form/a[1]")).click();
		String actualUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, actualUrl);
	}
	
	
	
	@Test
	void Login_Link_From_HomePage() {
		driver.get("http://localhost:3000/Home");
		String expected = "http://localhost:3000/Login";
		driver.findElement(By.xpath("/html/body/div/div/div[2]/body/header/ul/li[3]/a")).click();
		String actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	
	@Test
	void Register_Link_From_HomePage() {
		driver.get("http://localhost:3000/Home");
		String expected = "http://localhost:3000/Login";
		driver.findElement(By.xpath("/html/body/div/div/div[2]/body/header/ul/li[3]/a")).click();
		String actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	
	@Test
	void Back_To_Home_From_Register() {
		driver.get("http://localhost:3000/Register");
		String expected = "http://localhost:3000/Home";
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/a[2]")).click();
		String actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	
	@Test
	void register_Account_Pop_Up_Positive_Case() {
		driver.get("http://localhost:3000/Register");
		String expected = "http://localhost:3000/Register";
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[6]")).click();
		String actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	
	// NOT DEVELOPED FALSE TEST CASE
	@Test 
	void register_Account_with_Sending_keys_Negative_Case() {
		driver.get("http://localhost:3000/Register");
		String expected = "http://localhost:3000/CustomerHome";
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[1]")).sendKeys("Ali");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[2]")).sendKeys("ali_tariq1911@hotmail.com");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[3]")).sendKeys("Muhammad");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[4]")).sendKeys("Tariq");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[5]")).sendKeys("Password");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[6]")).click();
		String actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	
	
	@Test
	void registering_Account_without_Sending_keys_Positive_Case() {
		driver.get("http://localhost:3000/Register");
		String expected = "http://localhost:3000/Register";
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/input[6]")).click();
		String actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	
	
	@AfterAll
	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
