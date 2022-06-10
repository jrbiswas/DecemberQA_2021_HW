package variousConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

	static WebDriver driver;

	public static void main(String[] args) {

		launchBrowser();
		loginTest();
		tearDown();

	}

	public static void launchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Owner\\DecemberQA2021_HW\\BankCash\\driver\\chromedriver.exe"); // set property
		driver = new ChromeDriver(); // object variable
		driver.manage().deleteAllCookies();// cleanign cookies before luanching
		driver.get("https://www.techfios.com/billing/?ng=admin/"); // go to site
		driver.manage().window().maximize(); // maximize window
	}

	public static void loginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); // identify username and data insertaion
		driver.findElement(By.id("password")).sendKeys("abc123"); // identify Password and data insertion
		driver.findElement(By.name("login")).click(); // identify Signin element and click
		driver.findElement(By.partialLinkText("Bank & Cash")).click(); // for bank and cash button

		driver.findElement(By.partialLinkText("New Account")).click(); // for new account

	}

	public static void tearDown() {

		driver.close();
		driver.quit();

	}

}
