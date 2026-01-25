package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.ForgotPasswordPage;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class ForgotPasswordPageSteps {
    ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordPageSteps(Page page){
        forgotPasswordPage=new ForgotPasswordPage(page);
    }
    @Step("Asserting forgot password page title is displayed")
    public ForgotPasswordPageSteps assertPageTitleDisplay(){
        assertThat(forgotPasswordPage.pageTitle).containsText(Constants.FORGOT_PASSWORD_HEADER);
        return this;
    }
    @Step("Filling email field with value {}")
    public ForgotPasswordPageSteps fillingEmailField(String email){
        forgotPasswordPage.emailField.fill(email);
        return this;
    }
    @Step("Clicking set new password button")
    public ForgotPasswordPageSteps clickSetNewPasswordButton(){
        forgotPasswordPage.setNewPasswordButton.click();
        return this;
    }
    @Step("Asserting password reset success message is displayed")
    public ForgotPasswordPageSteps assertPasswordResetSuccess(){
        assertThat(forgotPasswordPage.passwordResetMessage).containsText(Constants.PASSWORD_UPDATE_SUCCESS_MESSAGE);
        return this;
    }

}
