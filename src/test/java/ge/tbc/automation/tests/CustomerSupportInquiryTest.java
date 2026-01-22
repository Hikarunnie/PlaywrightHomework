package ge.tbc.automation.tests;
import ge.tbc.automation.data.Constants;
import org.testng.annotations.Test;

public class CustomerSupportInquiryTest extends BaseTest{
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
