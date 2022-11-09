package page;

import org.junit.Assert;

public class AmazonPage extends BasePage{
    private  String textToSearch = "twotabsearchtextbox";
    private String buttomSearch = "nav-search-submit-button";
    private String thirdItemPage = "//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]";
    private  String buttonAddToCard="add-to-cart-button";
    public AmazonPage(){
        super(driver);
    }
    public void navigateToAmazon(){
        navigateTo("https://www.amazon.com");
    }
    public void enterSearchCriteria(String product){
        writeById(textToSearch,product);
    }

    public void clickSearch(){
        clickElementById(buttomSearch);
    }
     public void clickPageTwo(){
       goToLinkText("2");
     }

     public void clickThirItemPage(){
        clickElement(thirdItemPage);
     }

     public void addToCard(){
        clickElementById(buttonAddToCard);
        //asert para validar que si se halla agregado al carrito
        // Assert.assertEquals("Agregado al carrito");
     }
}
