package ge.tbc.automation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

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
    public Locator registerButton;

    public RegisterPage(Page page){
        this.firstName= page.locator("#first_name");
        this.lastName=  page.locator("#last_name");
        this.birthDate= page.locator("#dob");
        this.street= page.locator("#street");
        this.postalCode=  page.locator("#postal_code");
        this.city=  page.locator("#city");
        this.state=  page.locator ("#state");
        this.country= page.locator ("#country");
        this.phone= page.locator("#phone");
        this.email =page.locator("#email");
        this.password = page.locator("#password");
        this.registerButton = page.locator("button.btnSubmit");
    }
}
