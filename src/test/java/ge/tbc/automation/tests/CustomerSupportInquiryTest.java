package ge.tbc.automation.tests;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.steps.prestashop.ContactUsPageSteps;
import ge.tbc.automation.steps.prestashop.PresTaHomePageSteps;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(description = "Submitting Customer Support Inquiry (HT-T10)")
@Description("Customer Support Inquiry Test")
@Severity(SeverityLevel.BLOCKER)
@Epic("support")
@Feature("contact")
@Story("sending Support Inquiry")
public class CustomerSupportInquiryTest extends BaseTest{
    ContactUsPageSteps contactUsPageSteps;
    PresTaHomePageSteps presTaHomePageSteps;
    @BeforeClass
    public void  declar(){
        page.navigate(Constants.PRESTA_SHOP_URL);
        contactUsPageSteps = new ContactUsPageSteps(page);
        presTaHomePageSteps = new PresTaHomePageSteps(page);
    }
    @Test(description = "going to Home page", priority = 1)
    public void navigateToHomePage() {
        presTaHomePageSteps.navigatingToHome();
        presTaHomePageSteps.assertThereIsOneBreadCrumb()
                           .assertWeAreOnHomePage();
    }

    @Test(description = "browsing popular products", priority = 2)
    public void browsingPopularProducts() {
        presTaHomePageSteps.scrollToPopularProducts()
                .hoveringOverPopularProducts()
                .assertShopContentSectionVisibility()
                .assertingShopContentTitle()
                .assertingPopularProductsExist();
    }

    @Test(description = "finding contact email", priority = 3)
    public void findContactEmail() {
        presTaHomePageSteps.scrollToFooter()
                .assertContactInfoSectionDisplay()
                .assertEmailDisplay();
    }

    @Test(description = "navigating to contact page", priority = 4)
    public void navigateToContactPage() {
        presTaHomePageSteps.goToContactUs();
        contactUsPageSteps.assertContactHeaderDisplay();
    }

    @Test(description = "filling details", priority = 5)
    public void fillDetails() {
        contactUsPageSteps.selectSubject(Constants.PRESTA_CONTACT_SUBJECT)
                .fillingEmail(Constants.CONTACT_EMAIL)
                .uploadingFile(Constants.TO_UPLOAD_FILE)
                .fillingMessage(Constants.CONTACT_MESSAGE)
                .assertSubjectWasSelected(Constants.PRESTA_CONTACT_SUBJECT)
                .assertCorrectEmail(Constants.CONTACT_EMAIL)
                .assertCorrectMessageContent(Constants.CONTACT_MESSAGE)
                .assertingFileAttachment(Constants.FILE_NAME);
    }

    @Test(description = "submitting inquiry", priority = 6)
    public void submitInquiry() {
        contactUsPageSteps.submitForm()
                .assertingSuccessMessageVisibility();
    }
}
