package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ForgotPasswordPage {
    public Locator pageTitle;
    public Locator setNewPasswordButton;
    public Locator emailField;
    public Locator passwordResetMessage;

    public ForgotPasswordPage(Page page){
        this.pageTitle=page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Forgot Password"));
        this.setNewPasswordButton =page.getByTestId("forgot-password-submit");
        this.emailField=page.getByTestId("email");
        this.passwordResetMessage=page.getByRole(AriaRole.ALERT);
    }
}
