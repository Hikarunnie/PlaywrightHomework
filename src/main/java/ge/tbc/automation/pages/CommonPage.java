package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonPage {
    public Locator homeRedirect;
    public Locator accountRedirect;
    public Locator categoryRedirect;
    public Locator handToolsRedirect;
    public Locator signInButton;
    public Locator signOut;
    public Locator favouritesRedirect;
    public Locator cartRedirect;
    public Locator contactRedirect;

    public CommonPage(Page page){
        this.homeRedirect =  page.getByTestId("nav-home");
        this.accountRedirect =page.getByTestId("nav-menu");
        this.cartRedirect = page.getByTestId("nav-cart");
        this.signInButton= page.getByTestId("nav-sign-in");
        this.categoryRedirect = page.getByTestId("nav-categories");

        this.signOut = page.getByTestId("nav-sign-out");
        this.favouritesRedirect = page.getByTestId("nav-my-favorites");
        this.handToolsRedirect = page.getByTestId("nav-hand-tools");

        this.contactRedirect=page.getByTestId("nav-contact");
    }
}
