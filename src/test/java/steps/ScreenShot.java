package steps;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class ScreenShot {
	public WebDriver driver;
	public WebDriverWait wait;

	public By ele = By.xpath("(//article[@aria-label='article'])[1]");
	public By priceRangeDropdown = By.xpath("//div[@class='css-1wy0on6 nb-select__indicators']");
	public By priceRangeOption = By.xpath("//div[contains(text(),'Rent(High to Low)')]"); //Rent(High to Low)


	public ScreenShot(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void screenShot() throws IOException, InterruptedException {

		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(priceRangeDropdown)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(priceRangeOption)).click();
		Thread.sleep(1000);
		File f = (File)((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\rajag\\eclipse-workspace\\CucumberTesting\\NoBroker.jpg"));
	}

}
