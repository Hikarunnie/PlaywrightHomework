package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.CommonPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CommonSteps {
    CommonPage commonPage;

    public CommonSteps(Page page){
        commonPage = new CommonPage(page);
    }
    @Step("Navigating to Home page")
    public CommonSteps goToHome(){
        commonPage.homeRedirect.click();
        return this;
    }
    @Step("Navigating to Sign In page")
    public CommonSteps goToSignIn(){
        commonPage.signInButton.click();
        return this;
    }
    @Step("Expanding account dropdown menu")
    public CommonSteps expandingAccountDropdown(){
        commonPage.accountRedirect.click();
        return this;
    }
    @Step("Signing out from account")
    public CommonSteps signingOut() {
        commonPage.signOut.click();
        return this;
    }
    @Step("Navigating to Favourites page")
    public CommonSteps goToFavourites(){
        commonPage.favouritesRedirect.click();
        return this;
    }
    @Step("Navigating to Hand Tools category")
    public CommonSteps goToHandTools(){
        commonPage.categoryRedirect.waitFor();
        commonPage.categoryRedirect.click();
        commonPage.handToolsRedirect.click();
        return this;
    }
    @Step("Navigating to Cart page")
    public CommonSteps goToCart(){
        commonPage.cartRedirect.click();
        return this;
    }
    @Step("Navigating to Contact Us page")
    public CommonSteps goToContactPage(){
        commonPage.contactRedirect.click();
        return this;
    }
    @Step("Verifying account menu item is visible")
    public CommonSteps assertAccountMenuItem(){
        assertThat(commonPage.accountRedirect).isVisible();
        return this;
    }
    @Step("Verifying Sign In menu item is visible")
    public CommonSteps assertSignInMenuItemVisible(){
        assertThat(commonPage.signInButton).isVisible();
        return this;
    }
}
