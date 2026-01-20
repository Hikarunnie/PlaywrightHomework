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

    public CommonPage(Page page){
        this.homeRedirect = page.locator("a[data-test='nav-home']");
        this.categoryRedirect = page.locator("a[data-test='nav-categories']");
        this.accountRedirect =page.locator("a#menu");
        this.signOut = page.locator("//a[text() ='Sign out']");
        this.signInButton= page.locator("a[data-test='nav-sign-in']");
        this.favouritesRedirect = page.locator("//a[text() ='My favorites']");
        this.handToolsRedirect = page.locator("//a[text() ='Hand Tools']");
    }
}
