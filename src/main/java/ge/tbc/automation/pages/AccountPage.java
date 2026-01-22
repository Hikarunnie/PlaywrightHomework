package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AccountPage {
public Locator homeRedirect;
public Locator pageTitle;
public Locator favourites;

public AccountPage(Page page){
     this.pageTitle = page.getByTestId("page-title");
     this.favourites =page.getByTestId("nav-favorites");
     this.homeRedirect = page.getByTestId("nav-home");
}
}
