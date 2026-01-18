package ge.tbc.automation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class LoginPage {
    public Locator registerRedirect;
    public Locator email;
    public Locator password;
    public Locator LogButton;
    public Locator pageTitle;
    public Locator resitle;

    public LoginPage(Page page){
        this.registerRedirect= page.locator("a[data-test='register-link']");
        this.email =page.locator("#email");
        this.password = page.locator("#password");
        this.LogButton = page.locator("input.btnSubmit");
        this.pageTitle = page.locator("//h3[text()='Login']");
        this.resitle = page.locator("//h1[text()='My account']");
    }
}
