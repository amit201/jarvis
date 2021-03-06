import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cleartrip.qa.base.TestBase;

public class FlightBookingTest extends TestBase {

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

	
		initialization();
		waitFor(2000);
		driver.findElement(By.id("OneWay")).click();
		WebElement fromCity = driver.findElement(By.cssSelector("input[id='FromTag']"));

		// fromCity.clear();
		fromCity.sendKeys("Bangalore");
		// wait for the auto complete options to appear for the origin

		waitFor(2000);

		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();

		WebElement toCity = driver.findElement(By.cssSelector("input[id='ToTag']"));

		toCity.clear();

		toCity.sendKeys("Delhi");

		// wait for the auto complete options to appear for the destination

		waitFor(2000);
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[2]/td[2]/a")).click();

		// all fields filled in. Now click on search
		driver.findElement(By.id("SearchBtn")).click();

		waitFor(5000);
		// verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));

		// close the browser
		driver.quit();

	}

	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * private void setDriverPath() { System.setProperty("webdriver.chrome.driver",
	 * "chromedriver.exe"); }
	 */
	/*
	 * private void setDriverPath() { if (PlatformUtil.isMac()) {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver"); } if
	 * (PlatformUtil.isWindows()) { System.setProperty("webdriver.chrome.driver",
	 * "chromedriver.exe"); } if (PlatformUtil.isLinux()) {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver_linux"); } }
	 */
}
