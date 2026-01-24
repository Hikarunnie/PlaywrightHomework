package ge.tbc.automation.tests;
import ge.tbc.automation.data.Constants;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;
@Description("playwright Isolated Tests")
@Severity(SeverityLevel.BLOCKER)
public class PlayWrightTestsIsolated extends BaseTestIsolated{

    @Test(description = "filter test", priority =1)
    public void favouritesTest() {
        accountPageSteps.goToHome();
        homePageSteps.openingRandomproduct(1);
        productPageSteps.addingToFavourites()
                .expandingAccountDropdown()
                .signingOut()
                .goToSignIn();
        loginPageSteps.enterEmail(email)
                .enterpassword(password)
                .clickLogInbutton();
        accountPageSteps.openFavourites();
        favouritesPageSteps.assertingCardWasAdded();
    }

    @Test(description = "filter test", priority =2)
    public void filterTest(){
        homePageSteps.goToHome();
        homePageSteps.checkCategory1()
                .uncheckCategory1()
                .checkCategory2()
                .uncheckCategory2()
                .checkingBoth()
                .assertingCountsSumIsCorrect();
    }

    @Test(description = "remove favourite test", priority =3)
    public void removeFavouriteTest() {  // this one fails -> newly created user with no favorites, so no delete button
        homePageSteps.expandingAccountDropdown()
                .goToFavourites();
        favouritesPageSteps.deletingFavourite()
                .expandingAccountDropdown()
                .signingOut()
                .goToSignIn();
        loginPageSteps.enterEmail(email)
                .enterpassword(password)
                .clickLogInbutton();
        accountPageSteps.openFavourites();
        favouritesPageSteps.assertingDeletionEmptiness();
    }

    @Test(description = "Tag test", priority =4)
    public void TagsTest() {
        handToolsPageSteps.goToHandTools();
        handToolsPageSteps.checkingHammerFilter()
                .clickingOnHammer();
        productPageSteps.assertingCorrectTag(Constants.HAMMER);
    }
}
