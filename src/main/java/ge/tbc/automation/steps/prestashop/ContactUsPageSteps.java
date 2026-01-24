package ge.tbc.automation.steps.prestashop;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.prestashop.ContactUsPage;
import java.nio.file.Path;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class ContactUsPageSteps {
    ContactUsPage contactUsPage;
    public ContactUsPageSteps(Page page){
        contactUsPage=new ContactUsPage(page);
    }

    public ContactUsPageSteps assertContactHeaderDisplay() {
        assertThat(contactUsPage.pageTitle).isVisible();
        return this;
    }

    public ContactUsPageSteps selectSubject(String subject) {
        contactUsPage.subject.selectOption(subject);
        return this;
    }

    public ContactUsPageSteps fillingEmail(String email) {
        contactUsPage.emailField.fill(email);
        return this;
    }

    public ContactUsPageSteps fillingMessage(String message) {
        contactUsPage.message.fill(message);
        return this;
    }

    public ContactUsPageSteps uploadingFile(Path path) {
        contactUsPage.fileAttachment.setInputFiles(path);
        return this;
    }

    public ContactUsPageSteps assertSubjectWasSelected(String subject) {
        assertThat(contactUsPage.subject).containsText(subject);
        return this;
    }
    public ContactUsPageSteps assertCorrectEmail(String email) {
        assertThat(contactUsPage.emailField).hasValue(email);
        return this;
    }

    public ContactUsPageSteps assertCorrectMessageContent(String message) {
        assertThat(contactUsPage.message).hasValue(message);
        return this;
    }
    public ContactUsPageSteps assertingFileAttachment(String fileName){
        assertThat(contactUsPage.fileAttachment).hasValue(Pattern.compile(".*" + fileName + ".*"));
        return this;
    }

    public ContactUsPageSteps submitForm() {
        contactUsPage.sendButton.click();
        return this;
    }

    public ContactUsPageSteps assertingSuccessMessageVisibility() {
        contactUsPage.successMessage.waitFor();
        assertThat(contactUsPage.successMessage).isVisible();
        return this;
    }

}
