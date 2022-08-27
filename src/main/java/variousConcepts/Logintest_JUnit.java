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

public class Logintest_JUnit {

	WebDriver di;

	@BeforeClass
	public static void beforclass() {
		System.out.println("beforclass");
	}

	@AfterClass
	public static void afterclass() {
		System.out.println("after class");
	}

	@Before
	public void init() {
		System.out.println("init method");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

		di = new ChromeDriver();
		di.manage().deleteAllCookies();
		di.get("https://www.techfios.com/billing/?ng=admin/");
		di.manage().window().maximize();
		di.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void Logintest() {
		System.out.println("logintest method");
		di.findElement(By.id("username")).sendKeys("demo@techfios.com");
		di.findElement(By.id("password")).sendKeys("abc123");
		di.findElement(By.name("login")).click();
	}

	@Test
	public void negLogin() {
		System.out.println("neg login");
		di.findElement(By.id("username")).sendKeys("demo@techfios.com");
		di.findElement(By.id("password")).sendKeys("abc1234");
		di.findElement(By.name("login")).click();
	}

	@After
	public void teardown() {
		System.out.println("teardown");
		di.close();
		// di.quit();

	}

}
