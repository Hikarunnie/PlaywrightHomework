package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.AccountPage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountPageSteps {
    AccountPage accountPage;
    public AccountPageSteps(Page page){
        accountPage= new AccountPage(page);
    }

    @Step("navigating to home")
    public AccountPageSteps goToHome(){
        accountPage.pageTitle.waitFor();
        accountPage.homeRedirect.click();
        return this;
    }
    @Step("navigating to favourites")
    public AccountPageSteps openFavourites(){
        accountPage.favourites.click();
        return this;
    }
    @Step("asserting home page title display")
    public AccountPageSteps assertPageTitleDisplay(){
        assertThat(accountPage.pageTitle).isVisible();
        return this;
    }
}
