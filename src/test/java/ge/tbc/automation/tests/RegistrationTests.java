package ge.tbc.automation.tests;

import com.microsoft.playwright.*;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.data.RegistrationDataProvider;
import ge.tbc.automation.data.UserModel;
import ge.tbc.automation.steps.*;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Description("Registration Tests")  //this is not scenario idk if i should include others T_T
@Severity(SeverityLevel.BLOCKER)
public class RegistrationTests{

Playwright playwright;
Browser browser;
BrowserContext context;
Page page;
TechCanvasRegisterPageSteps techCanvasRegisterPageSteps;

@BeforeClass   // baseTest is pretty full + includes browserType so i'll do beforeClass here this once
public void setUp() {
    playwright = Playwright.create();
    BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
    launchOptions.setHeadless(false);
    browser = playwright.chromium().launch(launchOptions);
    context = browser.newContext();
    page = context.newPage();
    page.navigate(Constants.TECH_CANVAS_URL);
    techCanvasRegisterPageSteps = new TechCanvasRegisterPageSteps(page);
}

    @Test(description = "registering",  dataProvider = "newUsersDataProvider", dataProviderClass = RegistrationDataProvider.class)
    public void registeringUSer(UserModel user){
        techCanvasRegisterPageSteps.fillingFirstName(user.getFirstName())
                .fillingLastName(user.getLastName())
                .choosingGender(user.getGender())
                .choosingModel(user.getModel())
                .fillingAddress1(user.getAddress1())
                .fillingAddress2(user.getAddress2())
                .fillingCity(user.getCity())
                .fillingContact1(user.getContact1())
                .fillingContact2(user.getContact2());

    }

    @AfterClass
    public void tearDown(){
       page.close();
       browser.close();
       playwright.close();
    }
}

