package ge.tbc.automation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.CartPage;
import io.qameta.allure.Step;
import net.datafaker.Faker;

import java.util.Locale;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPageSteps {
    CartPage cartPage;
    private Faker faker = new Faker(new Locale("en-US"));

    public  CartPageSteps(Page page){
        cartPage = new CartPage(page);
    }


    @Step("asserting item's title is correct")
    public CartPageSteps assertItemTitle(){
        cartPage.productName.waitFor();
        assertThat(cartPage.productName).containsText(Constants.PLIERS);
        return this;
    }
    @Step("asserting Quantity")
    public CartPageSteps assertQuantity(){
        cartPage.quantity.waitFor();
        assertThat(cartPage.quantity).hasValue(Constants.QUANTITY);
        return this;
    }
    @Step("asserting Individual Price Display")
    public CartPageSteps assertIndividualPriceDisplay(){
        assertThat(cartPage.individualPrice).isVisible();
        return this;
    }
    @Step("calculating Total")
    public double calculateTotal(){
        double price = Double.parseDouble(cartPage.individualPrice.innerText().replace("$", "").trim());
        double quantity = Double.parseDouble(cartPage.quantity.inputValue().trim());
        return price*quantity;
    }
    @Step("asserting Individual Price Total")
    public CartPageSteps assertIndividualPriceTotal(){
        double expected = calculateTotal();
        assertThat(cartPage.individualTotal).containsText(String.valueOf(expected));
        return this;
    }
    @Step("changing Quantity {}")
    public CartPageSteps changeQuantity(String quantity){
        cartPage.quantity.fill(quantity);
        return this;
    }
    @Step("asserting Total After Quantity Change")
    public CartPageSteps assertTotalAfterQuantityChange(String quantity){
        assertThat(cartPage.quantity).hasValue(quantity);
        return this;
    }
    @Step("proceeding To CheckOut")
    public CartPageSteps proceedToCheckOut(){
        cartPage.proceedToCheckout.click();
        return this;
    }
    @Step("asserting current state is correct")
    public CartPageSteps assertCurrentState(String expected){
        assertThat(cartPage.currentWizardStep).containsText(expected);
        return this;
    }
    @Step("choosing Guest Option")
    public CartPageSteps choosingGuestOption(){
        assertThat(cartPage.guestOption).isVisible();
        cartPage.guestOption.click();
        return this;
    }
    @Step("filling Guest Email")
    public CartPageSteps fillingGuestEmail(){
        cartPage.email.fill(faker.internet().emailAddress());
        return this;
    }
    @Step("filling Guest First Name")
    public CartPageSteps fillingGuestFirstName(){
        cartPage.firstName.fill(faker.name().firstName());
        return this;
    }
    @Step("filling Guest Last Name")
    public CartPageSteps fillingGuestLastName(){
        cartPage.lastName.fill(faker.name().lastName());
        return this;
    }
    @Step("continuing as a guest option")
    public CartPageSteps continueAsaGuest(){
        cartPage.continueAsGuestBtn.click();
        return this;
    }
    @Step("asserting confirmation message as a guest")
    public CartPageSteps  assertConfirmMessageAsAGuest(){
         assertThat(cartPage.guestConfirmationMessage).isVisible();
         return this;
    }
    @Step("filling Billing street details")
    public CartPageSteps fillingBillingStreet(){
        cartPage.street.fill(faker.address().streetAddress());
        return this;
     }
    @Step("filling Billing City")
    public CartPageSteps fillingBillingCity(){
        cartPage.city.fill(faker.address().city());
        return this;
    }
    @Step("filling Billing State")
    public CartPageSteps fillingBillingState(){
        cartPage.state.fill(faker.address().state());
        return this;
    }
    @Step("filling Billing Country")
    public CartPageSteps fillingBillingCountry(){
        cartPage.country.fill(faker.address().country());
        return this;
    }
    @Step("filling Billing Post Code")
    public CartPageSteps fillingBillingPostCode(){
        cartPage.postcode.fill(faker.address().zipCode());
        return this;
    }
    @Step("opening payment method dropdown")
     public CartPageSteps openPaymentMethodDropdown(){
         cartPage.paymentTypeDropDown.click();
         return this;
     }
    @Step("selecting payment method")
     public CartPageSteps selectPaymentMethod(String payment){
        cartPage.paymentTypeDropDown.selectOption(payment);
        return this;
     }
    @Step("confirming payment method")
     public CartPageSteps confirmPaymentMethod(){
        cartPage.confirmBtn.click();
        return this;
     }
    @Step("asserting payment success message display")
     public CartPageSteps assertPaymentSuccessMessage(){
        assertThat(cartPage.paymentSuccessMessage).isVisible();
        assertThat(cartPage.paymentSuccessMessage).containsText(Constants.PAYMENT_METHOD_MESSAGE);
        return this;
     }
    @Step("asserting order was confirmed")
    public CartPageSteps assertOrderConfirmation(){
        cartPage.orderConfirmation.waitFor();
        cartPage.orderConfirmation.isVisible();
        assertThat(cartPage.orderConfirmation).containsText(Constants.ORDER_CONFIRMATION);
        return this;
    }
}
