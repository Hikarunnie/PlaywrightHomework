package ge.tbc.automation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import ge.tbc.automation.data.Constants;

public class LoginPage {
    public Locator registerRedirect;
    public Locator email;
    public Locator password;
    public Locator LogButton;
    public Locator pageTitle;
    public Locator resitle;
    public Locator forgotPasswordLink;

    public LoginPage(Page page){
        this.email =page.getByTestId(Constants.EMAIL);
        this.password = page.getByTestId(Constants.PASSWORD);
        this.pageTitle = page.getByRole(AriaRole.HEADING,new Page.GetByRoleOptions().setName("Login"));

        this.registerRedirect= page.getByTestId("register-link");
        this.LogButton = page.getByTestId("login-submit");
        this.forgotPasswordLink =page.getByLabel("Forgot your Password?");

        this.resitle = page.getByTestId("page-title");

    }
}
