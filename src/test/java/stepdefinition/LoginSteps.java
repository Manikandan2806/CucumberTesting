package stepdefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	WebDriver driver;

	@Given("User should navigate to the application")
	public void userShouldNavigate() {
		System.setProperty("webdriver.chrome.driver", "J:\\Eclipse work\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.get("https://bookcart.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;	
		
	}
	
	@Given("User clicks on the Login link")
	public void userClicksOnTheLoginLink() {
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	    
	}

	@Given("User enter the username as ortoni")
	public void userEnterTheUsernameAsOrtoni() {
		driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("ortoni");
	    
	}

	@Given("User enter the password as pass1234")
	public void userEnterThePasswordAsPass() {

		driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys("pass1234");
	}

	@When("User click the login button")
	public void userClickTheLoginButton() {
		driver.findElement(By.xpath("(//span[text()='Login'])[2]")).click();
	    
	}

	@Then("login should be success")
	public void loginShouldBeSuccess() {
		String text = driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")).getText();
		System.out.println(text);
		driver.quit();
	    
	}

}
