package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;

    private static Actions action;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");

        driver.manage().window().maximize();

    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void navigateTo(String url){
        driver.get(url);
    }
    public void closeBrowser(){
        driver.quit();
    }
    public WebElement findById (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }
    public WebElement findByClass (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
    }
    public WebElement findByXpath (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    public void writeById(String locator,String textToWrite){
        findById(locator).clear();
        findById(locator).sendKeys(textToWrite);
    }

    public void writeByXpath(String locator,String textToWrite){
        findByXpath(locator).clear();
        findByXpath(locator).sendKeys(textToWrite);
    }
    public void clickElementId(String locator) {
        findById(locator).click();
    }
    public void clickElementClass(String locator) {
       findByClass(locator).click();
    }
    public void clickElementXpath(String locator) {
        findByXpath(locator).click();
    }
    public boolean elementIsDisplayed(String locator){
        return  findByXpath(locator).isDisplayed();
    }
    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    public String dayOfTheWeekCalendar(String day,String month,String year) throws ParseException {

        String inputDateStr = String.format("%s/%s/%s", day, month, year);
        Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputDate);
        String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
        if(dayOfWeek.equals("MONDAY")){
            dayOfWeek="lunes";
        }
        if(dayOfWeek.equals("TUESDAY")){
            dayOfWeek="martes";
        }
        if (dayOfWeek.equals("WEDNESDAY")){
            dayOfWeek="mi\u00e9rcoles";
        }
        if (dayOfWeek.equals("THURSDAY")){
            dayOfWeek="jueves";
        }
        if (dayOfWeek.equals("FRIDAY")){
            dayOfWeek="viernes";
        }
        if (dayOfWeek.equals("SATURDAY")){
            dayOfWeek="s\u00e1bado";
        }
        if (dayOfWeek.equals("SUNDAY")){
            dayOfWeek="domingo";
        }
        return dayOfWeek;
    }
    public String month(String month){
        String monthSpanish="";
        if(month.equals("1")){
            monthSpanish="enero";
        }
        if(month.equals("2")){
            monthSpanish="febrero";
        }
        if(month.equals("3")){
            monthSpanish="marzo";
        }
        if(month.equals("4")){
            monthSpanish="abril";
        }
        if(month.equals("5")){
            monthSpanish="mayo";
        }
        if(month.equals("6")){
            monthSpanish="junio";
        }
        if(month.equals("7")){
            monthSpanish="julio";
        }
        if(month.equals("8")){
            monthSpanish="agosto";
        }
        if(month.equals("9")){
            monthSpanish="septiembre";
        }
        if(month.equals("10")){
            monthSpanish="octubre";
        }
        if(month.equals("11")){
            monthSpanish="noviembre";
        }
        if(month.equals("12")){
            monthSpanish="diciembre";
        }
        return monthSpanish;
    }
    public void multipleClick(int amoungth, String locator){
        for(int i=0;i<amoungth;i++){
            findByXpath(locator).click();
        }
    }
}

