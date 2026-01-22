package ge.tbc.automation.pages.prestashop;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import ge.tbc.automation.data.Constants;

public class ContactUsPage {
    public Frame frame;
    public Locator pageTitle;
    public Locator sendButton;
    public Locator emailField;
    public Locator subject;
    public Locator message;
    public Locator successMessage;
    public Locator fileAttachment;

    public ContactUsPage(Page page){
        this.frame=page.frame("framelive");
        this.pageTitle=frame.getByRole(AriaRole.HEADING, new Frame.GetByRoleOptions().setName(Constants.CONTACT_US_TEXT));
        this.sendButton=frame.getByRole(AriaRole.BUTTON, new Frame.GetByRoleOptions().setName(Constants.SEND_BUTTON_TEXT));
        this.subject=frame.getByRole(AriaRole.COMBOBOX,new Frame.GetByRoleOptions().setName("Subject"));
        this.emailField =frame.getByLabel(Constants.EMAIL_ADDRESS_TEXT);
        this.successMessage=frame.getByText(Constants.CONTACT_SUCCESS_MESSAGE);
        this.fileAttachment=frame.getByLabel("Attachment");
        this.message=frame.getByLabel("Message");
    }
}
