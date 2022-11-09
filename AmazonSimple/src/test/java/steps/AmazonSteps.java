package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page.AmazonPage;



public class AmazonSteps  {
    AmazonPage amazon = new AmazonPage();
    @Given("^the user navigates to www.amazon.com$")
    public void navigateToAmazon(){
        amazon.navigateToAmazon();
    }

    @And("^searches for (.+)$")
    public void enterSearchProducto(String criteria){
        amazon.enterSearchCriteria(criteria);
        amazon.clickSearch();
    }

    @And("^navigates to the second page$")
    public void clickPageTwo(){
        amazon.clickPageTwo();
    }
    @And("^selects the third item$")
    public void clickThirItemPage(){
        amazon.clickThirItemPage();
    }

    @Then("^the user is able to add it to the card$")
    public void addToCard(){
        amazon.addToCard();
    }

}
