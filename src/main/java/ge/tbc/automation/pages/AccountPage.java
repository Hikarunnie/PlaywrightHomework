package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AccountPage {
public Locator homeRedirect;
public Locator pageTitle;
public Locator favourites;

public AccountPage(Page page){
     this.pageTitle = page.locator("//h1[text()='My account']");
     this.favourites =page.locator("a[routerlink ='favorites']");
     this.homeRedirect = page.locator("a[data-test='nav-home']");
}
}
