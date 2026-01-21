package ge.tbc.automation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import ge.tbc.automation.data.Constants;

public class RegisterPage {
    public Locator firstName;
    public Locator lastName;
    public Locator birthDate;
    public Locator street;
    public Locator postalCode;
    public Locator city;
    public Locator state;
    public Locator country;
    public Locator phone;
    public Locator email;
    public Locator password;
    public Locator invalidPasswordMessage;
    public Locator invalidEmailMessage;
    public Locator registerButton;
    public Locator registrationFormHeader;
    public Locator alerts;
    public Locator formTitle;

    public RegisterPage(Page page){
        this.firstName= page.getByLabel("First name");
        this.lastName= page.getByLabel("Last name");
        this.birthDate= page.getByLabel("Date of Birth");
        this.street= page.getByLabel("Street");
        this.postalCode= page.getByLabel("Postal code");
        this.city= page.getByLabel("City");
        this.state= page.getByLabel("State");
        this.country= page.getByTestId("country");
        this.phone= page.getByLabel("Phone");
        this.email= page.getByTestId(Constants.EMAIL);
        this.password= page.getByTestId(Constants.PASSWORD);

        this.registerButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Register"));
        this.registrationFormHeader=page.getByRole(AriaRole.HEADING,new Page.GetByRoleOptions().setName("Customer registration"));

        this.invalidPasswordMessage =page.getByTestId("password-error");
        this.invalidEmailMessage=page.getByTestId("email-error");
        this.alerts = page.locator("div.alert");

        this.formTitle=page.getByRole(AriaRole.HEADING,new Page.GetByRoleOptions().setName(Constants.REGISTER_HEADER));
    }
}
