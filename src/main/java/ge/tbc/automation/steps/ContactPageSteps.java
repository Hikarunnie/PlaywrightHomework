package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.ContactPage;
import java.nio.file.Path;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactPageSteps {
    ContactPage contactPage;
    public ContactPageSteps(Page page){
        contactPage=new ContactPage(page);
    }
    public ContactPageSteps assertHeaderDisplay(){
        assertThat(contactPage.pageTitle).isVisible();
        return this;
    }
    public ContactPageSteps submittingForm(){
        contactPage.sendButton.click();
        return this;
    }
    public ContactPageSteps assertErrorMessageDisplays(String[] errors){
        assertThat(contactPage.alertMessages).containsText(errors);
        return this;
    }
    public ContactPageSteps assertErrorMessagesSize(int size){
        assertThat(contactPage.alertMessages).hasCount(size);
        return this;
    }
    public ContactPageSteps fillingFirstName(String name){
        contactPage.firstName.fill(name);
    return this;
    }
    public ContactPageSteps fillingLastName(String lastName){
        contactPage.lastName.fill(lastName);
        return this;
    }
    public ContactPageSteps fillingEmail(String email){
        contactPage.emailField.fill(email);
        return this;
    }

    public ContactPageSteps choosingSubject(String subject){
        contactPage.subject.selectOption(subject);
        return this;
    }
    public ContactPageSteps fillingMessageArea(String message){
        contactPage.message.fill(message);
        return this;
    }

    public ContactPageSteps uploadingFile(Path path) {
        contactPage.fileAttachment.setInputFiles(path);
        return this;
    }

    public ContactPageSteps assertingFileAlertVisibility(){
        assertThat(contactPage.invalidFileError).isVisible();
        return this;
    }
    public ContactPageSteps assertingInvalidFileAlertContent(){
        assertThat(contactPage.invalidFileError).containsText(Constants.FILE_ALERT);
        return this;
    }

   public ContactPageSteps assertingFileAttachment(){
        assertThat(contactPage.fileAttachment).hasValue(Pattern.compile(".*TNT\\.txt"));
        return this;
   }

    public ContactPageSteps assertFirstNameIsEmpty() {
        assertThat(contactPage.firstName).isEmpty();
        return this;
    }

    public ContactPageSteps assertLastNameIsEmpty() {
        assertThat(contactPage.lastName).isEmpty();
        return this;
    }

    public ContactPageSteps assertEmailIsEmpty() {
        assertThat(contactPage.emailField).isEmpty();
        return this;
    }

    public ContactPageSteps assertMessageIsEmpty() {
        assertThat(contactPage.message).isEmpty();
        return this;
    }

    public ContactPageSteps assertFileAttachmentIsEmpty() {
        assertThat(contactPage.fileAttachment).isEmpty();
        return this;
    }

}
