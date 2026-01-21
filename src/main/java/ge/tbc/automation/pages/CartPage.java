package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CartPage {
    public Locator allCards;
    public Locator productName;
    public Locator quantity;
    public Locator individualPrice;
    public Locator individualTotal;
    public Locator total;
    public Locator proceedToCheckout;
    public Locator currentWizardStep;
    public Locator guestOption;
    public Locator email;
    public Locator firstName;
    public Locator lastName;
    public Locator continueAsGuestBtn;
    public Locator guestConfirmationMessage;
    public Locator street;
    public Locator city;
    public Locator state;
    public Locator country;
    public Locator postcode;
    public Locator paymentTypeDropDown;
    public Locator confirmBtn;
    public Locator paymentSuccessMessage;
    public Locator orderConfirmation;

    public CartPage(Page page){
        this.paymentTypeDropDown=page.getByLabel("Payment Method"); //trying different selectors
        this.proceedToCheckout=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Proceed to checkout"));
        this.confirmBtn=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Confirm"));
        this.guestOption =page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Continue as Guest"));

        this.email=page.getByTestId("guest-email");
        this.firstName=page.getByTestId("guest-first-name");
        this.lastName=page.getByTestId("guest-last-name");

        this.continueAsGuestBtn =page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue as Guest"));
        this.guestConfirmationMessage=page.getByText("Continuing as guest");
        this.currentWizardStep =page.locator("li.current");

        this.productName =page.getByTestId("product-title");
        this.quantity =page.getByTestId("product-quantity");
        this.individualPrice = page.getByTestId("product-price");
        this.individualTotal = page.getByTestId("line-price");
        this.total=page.getByTestId("cart-total");


        this.allCards = page.locator("tr.ng-star-inserted");
        this.street= page.getByPlaceholder("Your Street");
        this.city= page.getByPlaceholder("Your City");
        this.state = page.getByPlaceholder("State");
        this.country= page.getByPlaceholder("Your country");
        this.postcode= page.getByPlaceholder("Your Postcode");

        this.paymentSuccessMessage =page.locator(".alert-success");
        this.orderConfirmation=page.locator("#order-confirmation");
    }
}
