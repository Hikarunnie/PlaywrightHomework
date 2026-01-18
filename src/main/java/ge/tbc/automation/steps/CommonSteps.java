package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.CommonPage;
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

    public CommonSteps signingOut(){
        commonPage.accountRedirect.click();
        commonPage.signOut.click();
        return this;
    }
    public CommonSteps goToFavourites(){
        commonPage.accountRedirect.click();
        commonPage.favouritesRedirect.click();
        return this;
    }

    public CommonSteps goToHandTools(){
        commonPage.categoryRedirect.waitFor();
        commonPage.categoryRedirect.click();
        commonPage.handToolsRedirect.click();
        return this;
    }
}
