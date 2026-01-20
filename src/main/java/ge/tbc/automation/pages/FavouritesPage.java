package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FavouritesPage {
    public Locator favouriteCards;
    public Locator deleteButton;
    public Locator pageTitle;

    public FavouritesPage(Page page){
        this.favouriteCards =page.locator("[data-test='product-name']");
        this.deleteButton = page.locator("button[data-test='delete']");
        this.pageTitle = page.locator("//h1[text()='Favorites']");
    }
}
