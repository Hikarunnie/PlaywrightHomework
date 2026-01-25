package ge.tbc.automation.tests;
import com.microsoft.playwright.*;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.steps.*;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Description("playwright Test")  //this is not scenario idk if i should include others T_T
@Severity(SeverityLevel.BLOCKER)
public class PlayWrightTests{
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    HomePageSteps homePageSteps;
    LoginPageSteps loginPageSteps;
    RegisterPageSteps registerPageSteps;
    AccountPageSteps accountPageSteps;
    ProductPageSteps productPageSteps;
    FavouritesPageSteps favouritesPageSteps;
    HandToolsPageSteps handToolsPageSteps;
    CommonSteps commonSteps;
    String email;
    String password;
    @BeforeClass
    public void  setUP(){  //had to add before class here, since i can't run this with shared baseTest
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
      //  launchOptions.setSlowMo(2000);
        launchOptions.setHeadless(false);
        playwright.selectors().setTestIdAttribute("data-test");
        browser = playwright.chromium().launch(launchOptions);
        context = browser.newContext();
        page = context.newPage();
        page.navigate(Constants.WEBSITE_URL);

        homePageSteps = new HomePageSteps(page);
        loginPageSteps = new LoginPageSteps(page);
        registerPageSteps= new RegisterPageSteps(page);
        accountPageSteps = new AccountPageSteps(page);
        productPageSteps = new ProductPageSteps(page);
        favouritesPageSteps = new FavouritesPageSteps(page);
        handToolsPageSteps = new HandToolsPageSteps(page);
        commonSteps = new CommonSteps(page);

        email = registerPageSteps.getEmail();
        password = registerPageSteps.getPassword();

        homePageSteps.goToSignIn();
        loginPageSteps.goToRegister();
        registerPageSteps.fillingFirstName()
                .fillingLastName()
                .fillingBirthDate()
                .fillingStreet()
                .fillingCountry()
                .fillingPostalCode()
                .fillingCity()
                .fillingState()
                .fillingEmail().fillingPassword().fillingPhone()
                .clickRegisterButton();
        email = registerPageSteps.getEmail();
        password = registerPageSteps.getPassword();

        loginPageSteps.enterEmail(email)
                .enterpassword(password)
                .clickLogInbutton();
    }

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
   public void removeFavouriteTest() {
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
