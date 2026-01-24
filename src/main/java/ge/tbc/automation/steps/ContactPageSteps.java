package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.ContactPage;
import io.qameta.allure.Step;

import java.nio.file.Path;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactPageSteps {
    ContactPage contactPage;
    public ContactPageSteps(Page page){
        contactPage=new ContactPage(page);
    }

    @Step("Asserting contact page header is displayed")
    public ContactPageSteps assertHeaderDisplay(){
        assertThat(contactPage.pageTitle).isVisible();
        return this;
    }
    @Step("Asserting contact page header is displayed")
    public ContactPageSteps submittingForm(){
        contactPage.sendButton.click();
        return this;
    }
    @Step("Asserting correct error message are displayed")
    public ContactPageSteps assertErrorMessageDisplays(String[] errors){
        assertThat(contactPage.alertMessages).containsText(errors);
        return this;
    }
    @Step("Asserting number of error messages is {}")
    public ContactPageSteps assertErrorMessagesSize(int size){
        assertThat(contactPage.alertMessages).hasCount(size);
        return this;
    }
    @Step("Filling first name with value {}")
    public ContactPageSteps fillingFirstName(String name){
        contactPage.firstName.fill(name);
    return this;
    }
    @Step("Filling last name with value {}")
    public ContactPageSteps fillingLastName(String lastName){
        contactPage.lastName.fill(lastName);
        return this;
    }
    @Step("Filling email with value {}")
    public ContactPageSteps fillingEmail(String email){
        contactPage.emailField.fill(email);
        return this;
    }
    @Step("Choosing subject {}")
    public ContactPageSteps choosingSubject(String subject){
        contactPage.subject.selectOption(subject);
        return this;
    }
    @Step("filling message area{}")
    public ContactPageSteps fillingMessageArea(String message){
        contactPage.message.fill(message);
        return this;
    }
    @Step("uploading file from path {}")
    public ContactPageSteps uploadingFile(Path path) {
        contactPage.fileAttachment.setInputFiles(path);
        return this;
    }

    @Step("Asserting invalid file alert is visible")
    public ContactPageSteps assertingFileAlertVisibility(){
        assertThat(contactPage.invalidFileError).isVisible();
        return this;
    }

    @Step("Asserting invalid file alert content")
    public ContactPageSteps assertingInvalidFileAlertContent(){
        assertThat(contactPage.invalidFileError).containsText(Constants.FILE_ALERT);
        return this;
    }
    @Step("Asserting file attachment is correctly attached")
   public ContactPageSteps assertingFileAttachment(){
        assertThat(contactPage.fileAttachment).hasValue(Pattern.compile(".*TNT\\.txt"));
        return this;
   }
    @Step("Asserting first name field is empty")
    public ContactPageSteps assertFirstNameIsEmpty() {
        assertThat(contactPage.firstName).isEmpty();
        return this;
    }
    @Step("Asserting last name field is empty")
    public ContactPageSteps assertLastNameIsEmpty() {
        assertThat(contactPage.lastName).isEmpty();
        return this;
    }
    @Step("Asserting email field is empty")
    public ContactPageSteps assertEmailIsEmpty() {
        assertThat(contactPage.emailField).isEmpty();
        return this;
    }
    @Step("Asserting message field is empty")
    public ContactPageSteps assertMessageIsEmpty() {
        assertThat(contactPage.message).isEmpty();
        return this;
    }
    @Step("Asserting file attachment field is empty")
    public ContactPageSteps assertFileAttachmentIsEmpty() {
        assertThat(contactPage.fileAttachment).isEmpty();
        return this;
    }
}
