package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.ProductPage;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPageSteps extends CommonSteps{
    ProductPage productPage;

    public ProductPageSteps(Page page){
        super(page);
        productPage = new ProductPage(page);
    }
    @Step("Adding product to favourites")
    public ProductPageSteps addingToFavourites(){
        productPage.addToFavourites.waitFor();
        productPage.addToFavourites.click();
        productPage.message.waitFor();
        return this;
    }
    @Step("Asserting product category tag is correct")
    public ProductPageSteps assertingCorrectTag(String tag){
        assertThat(productPage.name).isVisible();
        assertThat(productPage.categoryTag).containsText(tag);
        return this;
    }
    @Step("Asserting product brand tag is correct")
    public ProductPageSteps assertingCorrectBrandTAg(){
        assertThat(productPage.brandTag).containsText(Constants.FORGE_FLEX_TOOLS);
        return this;
    }
    @Step("Asserting product name is displayed")
    public ProductPageSteps assertNameDisplay(){
        productPage.name.waitFor();
        assertThat(productPage.name).isVisible();
        return this;
    }
    @Step("Asserting product price is displayed")
    public ProductPageSteps assertPriceDisplay(){
        assertThat(productPage.price).isVisible();
        return this;
    }
    @Step("Asserting description is displayed")
    public ProductPageSteps assertDescriptionDisplay(){
        assertThat(productPage.description).isVisible();
        return this;
    }
    @Step("Asserting rating is displayed")
    public ProductPageSteps assertRatingDisplay(){
        assertThat(productPage.rating).isVisible();
        return this;
    }
    @Step("Asserting quantity field is displayed")
    public ProductPageSteps assertQuantityDisplay(){
        assertThat(productPage.quantity).isVisible();
        return this;
    }
    @Step("Increasing product quantity")
    public ProductPageSteps increasingQuantity(){
        productPage.increseQuantityBtn.click();
        return this;
    }
    @Step("Asserting product quantity value is correct")
    public ProductPageSteps assertingQuantity(){
        assertThat(productPage.quantity).hasValue(Constants.QUANTITY);
        return this;
    }
    @Step("Adding product to cart")
    public ProductPageSteps addingToCart(){
        productPage.addToCartButton.click();
        return this;
    }
    @Step("Asserting success notification message: {message}")
    public ProductPageSteps assertingSuccessNotification(String message){
        productPage.message.waitFor();
        assertThat(productPage.message).containsText(message);
        return this;
    }

}
