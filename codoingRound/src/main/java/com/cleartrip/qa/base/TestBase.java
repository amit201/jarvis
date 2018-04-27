package com.cleartrip.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	protected static WebDriver driver;

	static {
		String browserName = "chrome";
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\jars&drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public static void initialization() {

		driver.get("https://www.cleartrip.com/");

	}

}
