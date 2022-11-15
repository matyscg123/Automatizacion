package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.PageViva;

import java.text.ParseException;

public class StepsViva {
    PageViva pageViva = new PageViva();
    @Given("^go to the fligth page$")
    public void navigateTo(){
        pageViva.navigateTo();
    }
    @When("^select1 the (.+)$")
    public void enterOrigin(String origin) throws InterruptedException {
        pageViva.enterOrigin(origin);
    }
    @And("select2 the (.+)$")
    public void enterDeparture(String departure) throws InterruptedException {
        pageViva.enterDeparture(departure);
    }

    @And("^select departure date (.+) / (.+) / (.+)$")
    public void enterdateDeparture(String dia,String mes,String ano) throws InterruptedException, ParseException {
        pageViva.enterDateDeparture(dia,mes,ano);
    }
    @And("^select income date (.+) / (.+) / (.+)$")
    public void enterdateIncome(String dia,String mes,String ano) throws InterruptedException, ParseException {
        pageViva.enterDateIncome(dia,mes,ano);
    }

    @And("^select the amoungth of (.+) / (.+) / (.+)$")
    public void amounth(int  adulto,int nino ,int bebe) throws InterruptedException, ParseException {
        pageViva.amouth(adulto,nino,bebe);
    }

    @And("^search the most economic price and select$")
    public void economicPrice() throws InterruptedException, ParseException {
        pageViva.economicPrice();
    }
}
