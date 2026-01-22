package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.AccountPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountPageSteps {
    AccountPage accountPage;
    public AccountPageSteps(Page page){
        accountPage= new AccountPage(page);
    }

    public AccountPageSteps goToHome(){
        accountPage.pageTitle.waitFor();
        accountPage.homeRedirect.click();
        return this;
    }

    public AccountPageSteps openFavourites(){
        accountPage.favourites.click();
        return this;
    }
    public AccountPageSteps assertPageTitleDisplay(){
        assertThat(accountPage.pageTitle).isVisible();
        return this;
    }
}
