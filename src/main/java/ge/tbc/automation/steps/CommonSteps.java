package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.CommonPage;
import org.testng.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CommonSteps {
    CommonPage commonPage;

    public CommonSteps(Page page){
        commonPage = new CommonPage(page);
    }

    public CommonSteps goToHome(){
        commonPage.homeRedirect.click();
        return this;
    }

    public CommonSteps goToSignIn(){
        commonPage.signInButton.click();
        return this;
    }
    public CommonSteps expandingAccountDropdown(){
        commonPage.accountRedirect.click();
        return this;
    }
    public CommonSteps signingOut(){
        commonPage.signOut.click();
        return this;
    }
    public CommonSteps goToFavourites(){
        commonPage.favouritesRedirect.click();
        return this;
    }

    public CommonSteps goToHandTools(){
        commonPage.categoryRedirect.waitFor();
        commonPage.categoryRedirect.click();
        commonPage.handToolsRedirect.click();
        return this;
    }
    public CommonSteps goToCart(){
        commonPage.cartRedirect.click();
        return this;
    }
    public CommonSteps goToContactPage(){
        commonPage.contactRedirect.click();
        return this;
    }

    public CommonSteps assertAccountMenuItem(){
        assertThat(commonPage.accountRedirect).isVisible();
        return this;
    }
    public CommonSteps assertSignInMenuItemVisible(){
        assertThat(commonPage.signInButton).isVisible();
        return this;
    }
}
