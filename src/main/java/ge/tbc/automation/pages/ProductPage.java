package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {
    public Locator addToFavourites;
    public Locator message;
    public Locator tag;
    public ProductPage(Page page){
        this.addToFavourites = page.locator("#btn-add-to-favorites");
        this.message = page.locator("#toast-container");
        this.tag = page.locator("span[aria-label='category']");
    }
}
