package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;

    private static Actions action;

    static{
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.setProperty("webdriver.chrome.driver","C:\\Webdriver\\chromedriver.exe");
        //forma implicita para poner las esperar de esta forma seria global
        //driver.manage().timeouts().getImplicitWaitTimeout(10, TimeUnit.SECONDS);
    }
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }
    private WebElement Find (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    public void write(String locator, String textToWrite){
        Find(locator).clear();//limpiar la caja de texto
        Find(locator).sendKeys(textToWrite);//lo ubica y escribe algo
    }
    public void clickElement(String locator){
        Find(locator).click();
    }
    public List<WebElement> brigMeAllElements(String locator){
        //la funcion findElements nos devuelve una lista del tipo WebElement
        return  driver.findElements(By.className(locator));
    }
}
