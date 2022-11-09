package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;



    static{
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.setProperty("webdriver.chrome.driver","C:\\Webdriver\\chromedriver.exe");
    }
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public void navigateTo(String url){
        driver.get(url);
    }
    public void closeBrowser(){
        driver.quit();
    }
    private WebElement Find (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    private WebElement FindByClass (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
    }
    private WebElement FindById(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }
    public void writeByXpath(String locator,String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }
    public void writeById(String locator,String textToWrite){
        FindById(locator).clear();
        FindById(locator).sendKeys(textToWrite);
    }

    public void clickElement(String locator){
        Find(locator).click();
    }
    public void clickElementByclass(String locator){
        FindByClass(locator).click();
    }
    public void clickElementById(String locator){
        FindById(locator).click();
    }

    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}
