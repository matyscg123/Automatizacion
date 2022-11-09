package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.PageList;

import java.util.List;

public class StepsList {
    PageList list = new PageList();

    @Given("^I navigate to the list page$")
    public void navigateToListPage() {
        list.navigateToListPage();
    }

    //(.+) eso significa cualquier string
    @When("^I search (.+)  in the list$")
    public void searchTheList(String state) throws InterruptedException {
        list.enterSearchCriteria(state);
    }

    @Then("^I can find the (.+) in the list$")
    public void theTableIsThere(String city) {
        List<String> lista = list.getAllSearchResults();
        boolean textIsThere = lista.contains(city);
        if (textIsThere) {
            System.out.println("The next text is on the list: PASSED.");
        } else {
            throw new Error("The next text not is on the list: failed.");
        }
    }
}
