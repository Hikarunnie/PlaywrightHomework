package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import ge.tbc.automation.data.Constants;

public class ContactPage {
    public Locator pageTitle;
    public Locator sendButton;
    public Locator firstName;
    public Locator lastName;
    public Locator emailField;
    public Locator subject;
    public Locator message;
    public Locator alertMessages;
    public Locator fileAttachment;
    public Locator invalidFileError;

    public ContactPage(Page page){
        this.pageTitle=page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Contact"));
        this.sendButton=page.getByTestId("contact-submit");
        this.firstName=page.getByTestId("first-name");
        this.lastName=page.getByTestId("last-name");
        this.emailField =page.getByTestId(Constants.EMAIL);
        this.subject=page.getByTestId("subject");
        this.message =page.getByTestId("message");
        this.alertMessages=page.getByRole(AriaRole.ALERT);
        this.fileAttachment=page.getByTestId("attachment");
        this.invalidFileError=page.getByTestId("attachment-error");
    }
}
