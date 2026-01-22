package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductPage {
    public Locator addToFavourites;
    public Locator message;
    public Locator categoryTag;
    public Locator brandTag;
    public Locator name;
    public Locator price;
    public Locator description;
    public Locator rating;
    public Locator quantity;
    public Locator increseQuantityBtn;
    public Locator addToCartButton;
    public ProductPage(Page page){
        this.addToFavourites = page.getByTestId("add-to-favorites");
        this.categoryTag = page.getByLabel("category");
        this.brandTag = page.getByLabel("brand");

        this.name = page.getByTestId("product-name");
        this.price = page.getByLabel("unit-price");
        this.description = page.getByTestId("product-description");
        this.rating= page.getByTestId("co2-rating-badge");
        this.quantity= page.getByTestId("quantity");
        this.increseQuantityBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Increase quantity"));
        this.addToCartButton=page.getByTestId("add-to-cart");
        this.message = page.locator("#toast-container");
    }
}
