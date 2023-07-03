package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


//@Listeners(TestListener.class)
public class NoBrokerProjectSteps {
	public WebDriver driver;
	public WebDriverWait wait;
	public HomePage homePage;
	public ScreenShot screenshot;
	public NoBrokerSupport noBrokerSupport;

	@Given("User should open the Site")
	//@Test
	public void userShouldOpenTheSite() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajag\\Eclipse work\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.nobroker.in/");
		wait = new WebDriverWait(driver, 10);
		
		homePage = new HomePage(driver, wait);
		screenshot = new ScreenShot(driver, wait);
		noBrokerSupport = new NoBrokerSupport(driver, wait);
			
	}

	@When("User should select the city")
	//@Test
	public void userShouldSelectTheCity() {
		homePage.selectCity("Chennai");
	}

	@Then("User should select the First area and check the text Add more...")
	//@Test
	public void userShouldSelectTheFirstAreaAndCheckTheTextAddMore() throws InterruptedException {
		homePage.selectArea("vel");
		homePage.checkPlaceholderText("Add more...");
	}

	@Then("User should select the Second area and check the text Add more...")
	//@Test
	public void userShouldSelectTheSecondAreaAndCheckTheTextAddMore() throws InterruptedException {
		homePage.selectArea("ady");
		homePage.checkPlaceholderText("Add more...");
	}

	@Then("User should select the Third area and check the text Add more...")
	//@Test
	public void userShouldSelectTheThirdAreaAndCheckTheTextAddMore() throws InterruptedException {
		homePage.selectArea("man");
		homePage.checkPlaceholderText("Add more...");
		System.out.println();
	}

	@Then("User click the search button and click Got it button")
	//@Test
	public void userClickTheSearchButtonAndClickGotItButton() {
		homePage.clickSearchButton();
		homePage.clickGotItButton();
	}

	@Then("User select the price range and get the house details")
	//@Test
	public void userSelectThePriceRangeAndGetTheHouseDetails() throws InterruptedException {
		homePage.selectPriceRange("Rent(Low to High)");
		System.out.println("The First Home details: ");
		homePage.printHouseDetails();
	}

	@Then("User scroll the price range and get the house details")
	//@Test
	public void userScrollThePriceRangeAndGetTheHouseDetails() throws InterruptedException {
		homePage.scrollPriceRange("Posted On (Newest First)");
		System.out.println("The Second Home details: ");
		homePage.printHouseDetails();
	}
	
	@Then("User select the price range again and get the Screenshot of house details")
	//@Test
	public void userSelectThePriceRangeAgainAndGetTheScreenshotOfHouseDetails() throws IOException, InterruptedException {
		screenshot.screenShot();
		
	}
	
	@Then("User handle the NoBroker Support")
	//@Test
	public void UserHandleTheNoBrokerSupport() throws IOException, InterruptedException {
		noBrokerSupport.noBrokersupport();
		
		Thread.sleep(1000);
		driver.quit();
		
	}
	

}
