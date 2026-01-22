package ge.tbc.automation.tests;
import com.microsoft.playwright.*;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.steps.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTestIsolated { // i created separate baseTest, hope this isn't big mistake T_T
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

    String email;
    String password;


    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(true);
        browser = playwright.chromium().launch(launchOptions);
    }

    @BeforeMethod
    public void setUpTest() {
        context = browser.newContext(); //new context for ecg
        page = context.newPage();
        page.navigate(Constants.WEBSITE_URL);

        homePageSteps = new HomePageSteps(page);
        loginPageSteps = new LoginPageSteps(page);
        registerPageSteps = new RegisterPageSteps(page);
        accountPageSteps = new AccountPageSteps(page);
        productPageSteps = new ProductPageSteps(page);
        favouritesPageSteps = new FavouritesPageSteps(page);
        handToolsPageSteps = new HandToolsPageSteps(page);

        homePageSteps.goToSignIn();
        loginPageSteps.goToRegister();
       // registerPageSteps.fillUserDetails().clickRegisterButton();
        email = registerPageSteps.getEmail();
        password = registerPageSteps.getPassword();

        loginPageSteps.enterEmail(email)
                .enterpassword(password)
                .clickLogInbutton();
    }

    @AfterMethod()
    public void tearDownTest() {
        context.close();
    }

    @AfterClass
    public void tearDown(){
        browser.close();
        playwright.close();
    }
}