package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.LoginPage;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageSteps extends CommonSteps{
    LoginPage loginPage;

    public LoginPageSteps(Page page){
        super(page);
        loginPage = new LoginPage(page);
    }

    @Step("Navigating to registration page ")
    public LoginPageSteps goToRegister(){
        loginPage.registerRedirect.click();
        return this;
    }
    @Step("Entering email {}")
    public LoginPageSteps enterEmail(String email){
        loginPage.pageTitle.waitFor();
        loginPage.email.fill(email);
        return this;
    }
    @Step("Entering password")
    public LoginPageSteps enterpassword(String password){
        loginPage.password.fill(password);
        return this;
    }
    @Step("Clicking login button")
    public LoginPageSteps clickLogInbutton(){
        loginPage.LogButton.click();
        loginPage.resitle.waitFor();
        return this;
    }
    @Step("Asserting login page header is displayed")
    public LoginPageSteps assertLogInHeaderDisplay(){
        assertThat(loginPage.pageTitle).isVisible();
        return this;
    }
    @Step("Opening forgot password page")
    public LoginPageSteps openingForgotPasswordLink(){
        loginPage.forgotPasswordLink.click();
        return this;
    }
}
