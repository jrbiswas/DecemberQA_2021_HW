package variousConcepts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Owner\\DecemberQA2021_HW\\BankCash\\driver\\chromedriver.exe"); // set property
		driver = new ChromeDriver(); // object variable
		driver.manage().deleteAllCookies();// cleanign cookies before luanching
		driver.get("https://www.techfios.com/billing/?ng=admin/"); // go to site
		driver.manage().window().maximize(); // maximize window
	}

	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); // identify username and data insertaion
		driver.findElement(By.id("password")).sendKeys("abc123"); // identify Password and data insertion
		driver.findElement(By.name("login")).click(); // identify Signin element and click
		driver.findElement(By.partialLinkText("Bank & Cash")).click(); // for bank and cash button
		Thread.sleep(4000);
		driver.findElement(By.partialLinkText("New Account")).click(); // for new account
	}

	@Test
	public void BankAndCash() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");//
		driver.findElement(By.id("password")).sendKeys("abc123"); //
		driver.findElement(By.name("login")).click();
		driver.findElement(By.partialLinkText("Bank & Cash")).click();
		Thread.sleep(4000);
		driver.findElement(By.partialLinkText("New Account")).click();
		Thread.sleep(4000);
		// now I am assigning the value in the New Account input box
		
		driver.findElement(By.id("account")).sendKeys("Checking Account");
		driver.findElement(By.id("description")).sendKeys("House Hold expense");
		driver.findElement(By.id("balance")).sendKeys("3000");
		driver.findElement(By.id("account_number")).sendKeys("0000-444-666-339");
		driver.findElement(By.id("contact_person")).sendKeys("112-334-5648");
		driver.findElement(By.id("contact_phone")).sendKeys("123-456-7890");
		driver.findElement(By.id("ib_url")).sendKeys("https://techfios.com/billing/?ng=accounts/add/");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'and @type='submit']")).click();
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
