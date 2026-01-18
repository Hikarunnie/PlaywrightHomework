package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.ProductPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPageSteps extends CommonSteps{
    ProductPage productPage;

    public ProductPageSteps(Page page){
        super(page);
        productPage = new ProductPage(page);
    }

    public ProductPageSteps addingToFavourites(){
        productPage.addToFavourites.waitFor();
        productPage.addToFavourites.click();
        productPage.message.waitFor();
        return this;
    }

    public ProductPageSteps assertingCorrectTag(){
        assertThat(productPage.tag).containsText(Constants.HAMMER);
        return this;
    }
}
