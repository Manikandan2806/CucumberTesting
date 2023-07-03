package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class NoBrokerProject {
	public WebDriver driver;
	//public WebDriverWait wait;

	@Given("User should open the Site")
	@Test
	public void userShouldOpenTheSite() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajag\\Eclipse work\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.nobroker.in/");
	
	}

	@When("User should select the city")
	@Test
	public void userShouldSelectTheCity() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='searchCity']/div[1]/div[2]/div")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Chennai')]")))).click();
	}

	@Then("User should select the First area and check the text Add more...")
	@Test
	public void userShouldSelectTheFirstAreaAndCheckTheTextAddMore() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement sec = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("listPageSearchLocality"))));
		sec.sendKeys("vel");
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sec.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sec.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement pick = driver.findElement(By.id("listPageSearchLocality"));
		String val = pick.getAttribute("placeholder");
		String realVal = "Add more...";
		if (val.equalsIgnoreCase(realVal)) {
			System.out.println("The Value inside is: " + val);
		} else {
			System.out.println("There is no Value like that");
		}
	}

	@Then("User should select the Second area and check the text Add more...")
	@Test
	public void userShouldSelectTheSecondAreaAndCheckTheTextAddMore() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement sec = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("listPageSearchLocality"))));
		sec.sendKeys("ady");
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sec.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sec.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement pick = driver.findElement(By.id("listPageSearchLocality"));
		String val = pick.getAttribute("placeholder");
		String realVal = "Add more...";
		if (val.equalsIgnoreCase(realVal)) {
			System.out.println("The Value inside is: " + val);
		} else {
			System.out.println("There is no Value like that");
		}
	}

	@Then("User should select the Third area and check the text Add more...")
	@Test
	public void userShouldSelectTheThirdAreaAndCheckTheTextAddMore() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement sec = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("listPageSearchLocality"))));
		sec.sendKeys("man");
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sec.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sec.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement pick = driver.findElement(By.id("listPageSearchLocality"));
		String val = pick.getAttribute("placeholder");
		String realVal = "Add more...";
		if (val.equalsIgnoreCase(realVal)) {
			System.out.println("The Value inside is: " + val);
		} else {
			System.out.println("There is no Value like that");
		}
	}

	@Then("User click the search button and click Got it button")
	@Test
	public void userClickTheSearchButtonAndClickGotItButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[4]/button")))).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), 'Got it')]")))).click();
	}

	@Then("User select the price range and get the house details")
	@Test
	public void userSelectThePriceRangeAndGetTheHouseDetails() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='css-1wy0on6 nb-select__indicators']")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Rent(Low to High)')]")))).click();
		Thread.sleep(1000);
		
		System.out.println("The First Home details: ");
		WebElement rentDetails = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='p-1.5p flex border-b border-b-solid border-cardbordercolor tp:py-1p tp:px-1.5p tp:border-b-0'])[1]"))));
		String RentDetails = rentDetails.getText();
		System.out.println(RentDetails);
		System.out.println();

		WebElement homeDetails = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='flex p-0.5p border-b border-b-solid border-b-cardbordercolor items-center'])[1]"))));
		String HomeDetials = homeDetails.getText();
		System.out.println(HomeDetials);
		System.out.println();

		WebElement secondDetails = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='flex p-0.5p items-center'])[1]"))));
		String SecondDetails = secondDetails.getText();
		System.out.println(SecondDetails);
		System.out.println();
	}

	@Then("User scroll the price range and get the house details")
	@Test
	public void userScrollThePriceRangeAndGetTheHouseDetails() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='css-1wy0on6 nb-select__indicators']")))).click();
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), 'Posted On (Newest First)')]")))).click();
		Thread.sleep(1000);
		
		System.out.println("The Second Home details: ");
		WebElement scroll = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='rc-slider-step']"))));
		Actions ac = new Actions(driver);
		ac.dragAndDropBy(scroll, 50, 0).perform();
		Thread.sleep(1000);

		WebElement rentDetails = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='p-1.5p flex border-b border-b-solid border-cardbordercolor tp:py-1p tp:px-1.5p tp:border-b-0'])[1]"))));
		String RentDetails = rentDetails.getText();
		System.out.println(RentDetails);
		System.out.println();

		WebElement homeDetails = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='flex p-0.5p border-b border-b-solid border-b-cardbordercolor items-center'])[1]"))));
		String HomeDetials = homeDetails.getText();
		System.out.println(HomeDetials);
		System.out.println();

		WebElement secondDetails = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='flex p-0.5p items-center'])[1]"))));
		String SecondDetails = secondDetails.getText();
		System.out.println(SecondDetails);
		System.out.println();
	}
}

