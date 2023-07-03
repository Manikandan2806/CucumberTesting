package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoBrokerSupport {
	public WebDriver driver;
	public WebDriverWait wait;

	public NoBrokerSupport(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void noBrokersupport() throws InterruptedException {

		Thread.sleep(1000);
		WebElement support = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//iframe)[1]"))));
		support.click();
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder='0'])[2]")));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@__jx__id='___$_47__profile__fake_input']")))).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='___$_47__profile__name']")))).sendKeys("Manikandan");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='___$_47__profile__email']")))).sendKeys("sakthimani2803@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='___$_47__profile__phone']")).sendKeys("9597640716");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@id='___$_158']")).sendKeys("Hi this is Mani");
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='___$_47__submit']")))).click();
	}

}
