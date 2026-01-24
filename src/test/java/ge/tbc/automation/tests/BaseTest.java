package ge.tbc.automation.tests;
import com.microsoft.playwright.*;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.steps.*;
import ge.tbc.automation.steps.prestashop.ContactUsPageSteps;
import ge.tbc.automation.steps.prestashop.PresTaHomePageSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
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
    CartPageSteps cartPageSteps;
    ForgotPasswordPageSteps forgotPasswordPageSteps;
    ContactPageSteps contactPageSteps;
//    String email;
//    String password;
    ContactUsPageSteps contactUsPageSteps;
    PresTaHomePageSteps presTaHomePageSteps;
    @BeforeClass
    @Parameters("browserType")
    public void setUp(String browserType) {
        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
        playwright.selectors().setTestIdAttribute("data-test");
      //  launchOptions.setSlowMo(4000);

        if (browserType.equalsIgnoreCase("webkit")){
            browser = playwright.webkit().launch(launchOptions);
        } else if (browserType.equalsIgnoreCase("chrome")) {
            browser = playwright.chromium().launch(launchOptions);
        }

        context = browser.newContext();
        page = context.newPage();

        page.navigate(Constants.PRESTA_SHOP_URL);

        homePageSteps = new HomePageSteps(page);
        loginPageSteps = new LoginPageSteps(page);
        registerPageSteps= new RegisterPageSteps(page);
        accountPageSteps = new AccountPageSteps(page);
        productPageSteps = new ProductPageSteps(page);
        favouritesPageSteps = new FavouritesPageSteps(page);
        handToolsPageSteps = new HandToolsPageSteps(page);
        commonSteps = new CommonSteps(page);
        cartPageSteps = new CartPageSteps(page);
        forgotPasswordPageSteps=new ForgotPasswordPageSteps(page);
        contactPageSteps = new ContactPageSteps(page);
//        email = registerPageSteps.getEmail();
//        password = registerPageSteps.getPassword();
        contactUsPageSteps = new ContactUsPageSteps(page);
        presTaHomePageSteps = new PresTaHomePageSteps(page);
    }

    @AfterClass
    public void tearDown(){
        page.close();
        browser.close();
        playwright.close();
    }
}
