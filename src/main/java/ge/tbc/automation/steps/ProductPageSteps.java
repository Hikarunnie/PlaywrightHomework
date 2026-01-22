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
        assertThat(productPage.name).isVisible();
        assertThat(productPage.categoryTag).containsText(Constants.SAFETY_GEAR);
        return this;
    }
    public ProductPageSteps assertingCorrectBrandTAg(){
        assertThat(productPage.brandTag).containsText(Constants.FORGE_FLEX_TOOLS);
        return this;
    }
    public ProductPageSteps assertNameDisplay(){
        productPage.name.waitFor();
        assertThat(productPage.name).isVisible();
        return this;
    }

    public ProductPageSteps assertPriceDisplay(){
        assertThat(productPage.price).isVisible();
        return this;
    }
    public ProductPageSteps assertDescriptionDisplay(){
        assertThat(productPage.description).isVisible();
        return this;
    }
    public ProductPageSteps assertRatingDisplay(){
        assertThat(productPage.rating).isVisible();
        return this;
    }
    public ProductPageSteps assertQuantityDisplay(){
        assertThat(productPage.quantity).isVisible();
        return this;
    }
    public ProductPageSteps increasingQuantity(){
        productPage.increseQuantityBtn.click();
        return this;
    }
    public ProductPageSteps assertingQuantity(){
        assertThat(productPage.quantity).hasValue(Constants.QUANTITY);
        return this;
    }
    public ProductPageSteps addingToCart(){
        productPage.addToCartButton.click();
        return this;
    }
    public ProductPageSteps assertingSuccessNotification(String message){
        productPage.message.waitFor();
        assertThat(productPage.message).containsText(message);
        return this;
    }

}
