package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logintest {

	static WebDriver di;

	public static void main(String[] args) {
		init();
		Logintest();
		teardown();

		init();
		negLogin();
		teardown();

	}

	public static void init() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\diyor\\selenium\\crm\\driver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		di = new ChromeDriver();
		di.manage().deleteAllCookies();
		di.get("https://www.techfios.com/billing/?ng=admin/");
		di.manage().window().maximize();
		di.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void Logintest() {
		di.findElement(By.id("username")).sendKeys("demo@techfios.com");
		di.findElement(By.id("password")).sendKeys("abc123");
		di.findElement(By.name("login")).click();
	}

	public static void negLogin() {
		di.findElement(By.id("username")).sendKeys("demo@techfios.com");
		di.findElement(By.id("password")).sendKeys("abc12345");
		di.findElement(By.name("login")).click();

	}

	public static void teardown() {

		// di.close();
		// di.quit();

	}
}
