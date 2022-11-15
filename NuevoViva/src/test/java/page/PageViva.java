package page;

import java.text.ParseException;

public class PageViva extends BasePage {

    private String btnCokies="//button[normalize-space()='Aceptar']";
    private String textBoxOrig="//ultra-station-select[1]/div/div/input";
    private String textBoxDest="//ultra-station-select[2]/div[1]/div/input";
   private String firstOptionDest="//body//demo-root//li[2]";

   private String dateDeparture="//input[@placeholder='Salida']";
   private String buttonSearch="//button[@data-cy='searchButton']";
   private String  emptySpace="//div[@class='search-button-container rounded-corners-field']";

   private String buttonAmounght="//div[@aria-label='1 Guest(s). 1 Adult. 0 Child']";

   private String buttonAdultAmounght="//button[@aria-label='Add Adult']";
   private String buttonChildAmoungth="//button[@aria-label='Add Child']";
   private String buttonBabyAmoungth="//button[@aria-label='Añadir menor de edad']";
   
    public PageViva() {
        super(driver);
    }


    public void navigateTo(){
        navigateTo("https://www.ultraair.com/home/search");

    }
    public void enterOrigin(String origin) throws InterruptedException {
       findByXpath(btnCokies).click();
          if(findByXpath(textBoxOrig).isDisplayed()){
            writeByXpath(textBoxOrig,origin);
            findByXpath("//span[contains(text(),'"+origin+"')]");
        }
    }

    public void enterDeparture(String desparture) throws InterruptedException {
        if( findByXpath(textBoxDest).isDisplayed()){
            writeByXpath(textBoxDest,desparture);
            findByXpath(firstOptionDest).click();
        }

    }

    public void enterDateDeparture(String day,String month,String year) throws ParseException {

        String wordDay = null;
        String wordMonth = null;
        if (findByXpath(dateDeparture).isDisplayed()){
            findByXpath(dateDeparture).click();
            wordDay = dayOfTheWeekCalendar(day, month, year);
            wordMonth = month(month);
            if(findByXpath("//ultra-calendar-day[@aria-label='" + wordDay + ", " + day + " de " + wordMonth + " de " + year + "']").isDisplayed()) {
                findByXpath("//ultra-calendar-day[@aria-label='" + wordDay + ", " + day + " de " + wordMonth + " de " + year + "']").click();
            }
            }
    }
    public void enterDateIncome(String day,String month,String year) throws ParseException, InterruptedException {
            String wordDay = dayOfTheWeekCalendar(day,month,year);
            String wordMonth = month(month);
            if(findByXpath("//ultra-calendar-day[@aria-label='"+wordDay+", "+day+" de "+wordMonth+" de "+year+"']").isDisplayed()){
                Thread.sleep(4000);
               findByXpath("//ultra-calendar-day[@aria-label='"+wordDay+", "+day+" de "+wordMonth+" de "+year+"']").click();
            }

    }

    public void amouth(int adult,int child ,int baby){
        adult=adult-1;
        findByXpath(buttonAmounght).click();
        multipleClick(adult,buttonAdultAmounght);
        multipleClick(child,buttonChildAmoungth);
        multipleClick(baby,buttonBabyAmoungth);
        findByXpath(emptySpace).click();
        findByXpath(buttonSearch).click();
    }

    public void economicPrice() throws InterruptedException {
        getValuePrice();
    }
}
