package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.ForgotPasswordPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class ForgotPasswordPageSteps {
    ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordPageSteps(Page page){
        forgotPasswordPage=new ForgotPasswordPage(page);
    }

    public ForgotPasswordPageSteps assertPageTitleDisplay(){
        assertThat(forgotPasswordPage.pageTitle).containsText(Constants.FORGOT_PASSWORD_HEADER);
        return this;
    }
    public ForgotPasswordPageSteps fillingEmailField(String email){
        forgotPasswordPage.emailField.fill(email);
        return this;
    }
    public ForgotPasswordPageSteps clickSetNewPasswordButton(){
        forgotPasswordPage.setNewPasswordButton.click();
        return this;
    }
    public ForgotPasswordPageSteps assertPasswordResetSuccess(){
        assertThat(forgotPasswordPage.passwordResetMessage).containsText(Constants.PASSWORD_UPDATE_SUCCESS_MESSAGE);
        return this;
    }

}
