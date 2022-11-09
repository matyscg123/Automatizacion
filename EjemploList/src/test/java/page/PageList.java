package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PageList extends BasePage {
    private String searchField = "/html/body/form/input";
    private String searchResoults = "name";

    public PageList() {
        super(driver);
    }

    public void navigateToListPage() {
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }

    public void enterSearchCriteria(String state) throws InterruptedException {
        try {
            Thread.sleep(600);
            write(searchField, state);
        } catch (NoSuchElementException e) {
            System.out.println("The webelement search field couldn't be found");
            e.printStackTrace();

        }

    }

    public List<String> getAllSearchResults() {
        //traemos la lista del tipo web elements para pasarla a una de tipo string
        List<WebElement> list = brigMeAllElements(searchResoults);
        List<String> stringFromList = new ArrayList<String>();
        for (WebElement e : list) {
            stringFromList.add(e.getText());
        }
        return stringFromList;
    }
}
