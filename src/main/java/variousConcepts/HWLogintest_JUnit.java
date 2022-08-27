package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWLogintest_JUnit {

	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}

	@Before
	public void inter() {
		System.out.println("starting");
		// setup properties and create an object variable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\diyor\\selenium\\crm\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		driver.get("http://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void login() {
		System.out.println("testing");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

		driver.findElement(By.linkText("Bank & Cash")).click();
		driver.findElement(By.linkText("New Account")).click();

		driver.findElement(By.id("account")).sendKeys("jose");

		driver.findElement(By.id("description")).sendKeys("Account");
		driver.findElement(By.id("balance")).sendKeys("$ 2,000");
		driver.findElement(By.id("account_number")).sendKeys("566556");
		driver.findElement(By.id("contact_person")).sendKeys("jay");
		driver.findElement(By.id("contact_phone")).sendKeys("9789345789");
		// driver.findElement(By.id("submit")).click();

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	}

	@After
	public void teardown() throws InterruptedException {
		System.out.println("closing");
		// pause execution
		Thread.sleep(5000);
		driver.close();
		// driver.quit();
	}

}
