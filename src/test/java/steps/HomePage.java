package steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public WebDriver driver;
	public WebDriverWait wait;

	public  By searchCityDropdown = By.xpath("//*[@id='searchCity']/div[1]/div[2]/div");
	public  By cityOption = By.xpath("//div[contains(text(),'Chennai')]");
	public  By localitySearchBox = By.id("listPageSearchLocality");
	public  By placeholderText = By.xpath("//input[@id='listPageSearchLocality']");
	public  By searchButton = By.xpath("//*[@id='app']/div/div/div[1]/div[4]/button");
	public  By gotItButton = By.xpath("//div[contains(text(), 'Got it')]");
	public  By priceRangeDropdown = By.xpath("//div[@class='css-1wy0on6 nb-select__indicators']");
	public  By priceRangeOption = By.xpath("//div[contains(text(),'Rent(Low to High)')]");
	public  By houseDetails = By.xpath("//div[@class='p-1.5p flex border-b border-b-solid border-cardbordercolor tp:py-1p tp:px-1.5p tp:border-b-0']");
	public  By homeDetails = By.xpath("(//div[@class='flex p-0.5p border-b border-b-solid border-b-cardbordercolor items-center'])[1]");
	public  By secondDetails = By.xpath("(//div[@class='flex p-0.5p items-center'])[1]");
	public  By scrollSlider = By.xpath("//div[@class='rc-slider-step']");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selectCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchCityDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityOption)).click();
    }

    public void selectArea(String area) throws InterruptedException {
        WebElement searchBox =driver.findElement(localitySearchBox);
        searchBox.sendKeys(area);
        Thread.sleep(1000);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    public void checkPlaceholderText(String expectedText) {
        WebElement placeholder = driver.findElement(placeholderText);
        String actualText = placeholder.getAttribute("placeholder");
        if (actualText.equalsIgnoreCase(expectedText)) {
            System.out.println("The Value inside is: " + actualText);
        } else {
            System.out.println("There is no Value like that");
        }
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
    }

    public void clickGotItButton() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(gotItButton)).click();
    }

    public void selectPriceRange(String priceRange) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceRangeDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceRangeOption)).click();
        Thread.sleep(1000);
    }

    public void scrollPriceRange(String priceRange) throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceRangeDropdown)).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '" + priceRange + "')]"))).click();
        Thread.sleep(1000);
        WebElement scroll = wait.until(ExpectedConditions.visibilityOfElementLocated(scrollSlider));
        Actions ac = new Actions(driver);
        ac.dragAndDropBy(scroll, 50, 0).perform();
        Thread.sleep(1000);
    }

    public void printHouseDetails() {
        System.out.println("The Home details: ");
        WebElement rentDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(houseDetails));
        String RentDetails = rentDetails.getText();
        System.out.println(RentDetails);
        System.out.println();

        WebElement homedetails = wait.until(ExpectedConditions.visibilityOfElementLocated((By) homeDetails));
        String HomeDetails = homedetails.getText();
        System.out.println(HomeDetails);
        System.out.println();

        WebElement seconddetails = wait.until(ExpectedConditions.visibilityOfElementLocated((By) secondDetails));
        String SecondDetails = seconddetails.getText();
        System.out.println(SecondDetails);
        System.out.println();
    }
}
