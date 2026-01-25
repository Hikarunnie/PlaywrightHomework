package ge.tbc.automation.tests;
import ge.tbc.automation.data.Constants;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;

@Test(description ="Contact/Support Form Submission Flow (HT-T9)")
@Description("Contact Form Submission Test")
@Severity(SeverityLevel.BLOCKER)
@Epic("support")
@Feature("contact")
@Story("submitting contact form")
public class ContactFormSubmissionTest extends BaseTest {

    @Test(description = "navigating to contact page", priority = 1)
    public void navigatingToContactPage() {
        page.navigate(Constants.WEBSITE_URL);
        commonSteps.goToHome()
                   .goToContactPage();
        contactPageSteps.assertHeaderDisplay();
    }

    @Test(description = "submitting empty form", priority = 2)
    public void submittingEmptyForm() {
        contactPageSteps.submittingForm()
                .assertErrorMessagesSize(Constants.ALL_INVALID_INPUT_SIZE)
                .assertErrorMessageDisplays(Constants.ALL_CONTACT_ALERTS);
    }

    @Test(description = "filling personal data", priority = 3)
    public void fillingPersonalData() {
       contactPageSteps.fillingFirstName(Constants.NAME)
               .fillingLastName(Constants.LAST_NAME)
               .fillingEmail(Constants.CONTACT_EMAIL)
               .assertErrorMessagesSize(Constants.TWO_INVALID_INPUT_SIZE) //email,lastname name alerts disappeared
               .assertErrorMessageDisplays(Constants.SUBJECT_AND_MESSAGE_ALERTS);
    }

    @Test(description = "selecting subject", priority = 4)
    public void selectingSubject() {
        contactPageSteps.choosingSubject(Constants.SUBJECT)
                .assertErrorMessagesSize(Constants.ONE_ALERT_SIZE)
                .assertErrorMessageDisplays(new String[]{Constants.MESSAGE_ALERT});
    }

    @Test(description = "entering message", priority = 5)
    public void enteringMessage() {
        contactPageSteps.fillingMessageArea(Constants.CONTACT_MESSAGE)
                .assertErrorMessagesSize(Constants.NO_ALERT_SIZE);
    }

    @Test(description = "attaching invalid file", priority = 6)
    public void attachingInvalidFile() {
        contactPageSteps.uploadingFile(Constants.INVALID_FILE)
                .assertErrorMessagesSize(Constants.ONE_ALERT_SIZE)
                .assertingFileAlertVisibility()
                .assertingInvalidFileAlertContent();
    }

    @Test(description = "attaching valid file", priority = 7)
    public void attachingValidFile() {
        contactPageSteps.uploadingFile(Constants.VALID_FILE)
                .assertErrorMessagesSize(Constants.NO_ALERT_SIZE)
                .assertingFileAttachment();
    }

    @Test(description = "submitting form with valid data", priority = 8)
    public void submittingFormWithValidData() {
        contactPageSteps.submittingForm()
                .assertErrorMessageDisplays(new String[]{Constants.CONTACT_FORM_SUCCESS});
    }

    @Test(description = "verifying form reset", priority = 9)
    public void verifyingFormReset() { //mm it doesn't reset or anything, ill assert going to contact displays new form
        commonSteps.goToContactPage();  //doesn't redirect, doensn't reset - this test fails
        contactPageSteps.assertHeaderDisplay()
                .assertFirstNameIsEmpty()
                .assertLastNameIsEmpty()
                .assertEmailIsEmpty()
                .assertMessageIsEmpty()
                .assertFileAttachmentIsEmpty();
 }
}