package ge.tbc.automation.tests;
import ge.tbc.automation.data.Constants;
import org.testng.annotations.Test;

@Test(description ="User Registration and Login (HT-T8)")
public class UserRegistrationAndLoginTest extends BaseTest {
    @Test(description = "navigating to sign in from homepage", priority = 1)
    public void navigateToSignIn() {
        page.navigate(Constants.WEBSITE_URL);
        commonSteps.goToHome()
                   .goToSignIn();
        loginPageSteps.assertLogInHeaderDisplay();
    }

    @Test(description = "accessing registration form", priority = 2)
    public void accessRegistrationForm() {
        loginPageSteps.goToRegister();
        registerPageSteps.assertRegistrationHeader();
    }

    @Test(description = "filling form with invalid data", priority = 3)
    public void fillFormWithInvalidData() {
        registerPageSteps.fillingEmail(Constants.INVALID_EMAIL)
                .fillingPassword(Constants.INVALID_PASSWORD)
                .clickRegisterButton()
                .assertInvalidEmailMessage()
                .assertInvalidPasswordMessage();
    }

    @Test(description = "filling registration form with valid data", priority = 4)
    public void fillRegistrationFormWithValidData() {
        registerPageSteps.fillingFirstName()
                .fillingLastName()
                .fillingBirthDate()
                .fillingStreet()
                .fillingPostalCode()
                .fillingCity()
                .fillingState()
                .fillingCountry()
                .fillingPhone()
                .fillingEmail()
                .fillingPassword()
                .assertingNoAlertIsPresent();
    }

    @Test(description = "submitting registration", priority = 5)
    public void submitRegistration() {

        registerPageSteps.clickRegisterButton();
        loginPageSteps.assertLogInHeaderDisplay();
    }

    @Test(description = "logging in with new credentials", priority = 6)
    public void loginWithNewCredentials() {
       loginPageSteps.enterEmail(registerPageSteps.getEmail()) //ii need to log in after registering
               .enterpassword(registerPageSteps.getPassword())
               .clickLogInbutton()
               .assertAccountMenuItem();
       accountPageSteps.assertPageTitleDisplay();
    }

    @Test(description = "browsing products", priority = 7)
    public void browseProducts() {
        commonSteps.goToHome();
        homePageSteps.openingRandomproduct(Constants.THOR_HAMMER_INDEX);
        productPageSteps.assertNameDisplay();

    }

    @Test(description = "adding product to favorites", priority = 8)
    public void addProductToFavorites() {
       productPageSteps.addingToFavourites()
               .assertingSuccessNotification(Constants.FAVOURITE_ADDED_MESSAGE);
    }


    @Test(description = "logging out", priority = 9)
    public void logout() {
        commonSteps.expandingAccountDropdown()
                .signingOut()
                .assertSignInMenuItemVisible();
    }

    @Test(description = "navigating to password reset page", priority = 10)
    public void navigateToPasswordResetPage() {
        commonSteps.goToSignIn();
        loginPageSteps.openingForgotPasswordLink();
        forgotPasswordPageSteps.assertPageTitleDisplay();
    }

    @Test(description = "resetting password", priority = 11)
    public void resetPassword() {
         forgotPasswordPageSteps.fillingEmailField(registerPageSteps.getEmail())
                 .clickSetNewPasswordButton()
                 .assertPasswordResetSuccess();
    }
}