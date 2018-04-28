import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cleartrip.qa.base.TestBase;

public class HotelBookingTest extends TestBase {

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@BeforeClass
	public void criarDriver() throws InterruptedException {
		initialization();
		PageFactory.initElements(driver, this);
	}

	@Test
	public void shouldBeAbleToSearchForHotels() {

		System.out.println(hotelLink);
		hotelLink.click();

		localityTextBox.sendKeys("Indiranagar, Bangalore");

		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		searchButton.click();

		driver.quit();

	}

	/*
	 * private void setDriverPath() { System.setProperty("webdriver.chrome.driver",
	 * "chromedriver.exe"); }
	 * 
	 * private void setDriverPath() { if (PlatformUtil.isMac()) {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver"); } if
	 * (PlatformUtil.isWindows()) { System.setProperty("webdriver.chrome.driver",
	 * "chromedriver.exe"); } if (PlatformUtil.isLinux()) {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver_linux"); } }
	 */

}
