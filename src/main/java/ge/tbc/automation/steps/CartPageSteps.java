package ge.tbc.automation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.CartPage;
import net.datafaker.Faker;

import java.util.Locale;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPageSteps {
    CartPage cartPage;
    private Faker faker = new Faker(new Locale("en-US"));

    public  CartPageSteps(Page page){
        cartPage = new CartPage(page);
    }

    public CartPageSteps assertItemTitle(){
        cartPage.productName.waitFor();
        assertThat(cartPage.productName).containsText(Constants.PLIERS);
        return this;
    }
    public CartPageSteps assertQuantity(){
        cartPage.quantity.waitFor();
        assertThat(cartPage.quantity).hasValue(Constants.QUANTITY);
        return this;
    }

    public CartPageSteps assertIndividualPriceDisplay(){
        assertThat(cartPage.individualPrice).isVisible();
        return this;
    }

    public double calculateTotal(){
        double price = Double.parseDouble(cartPage.individualPrice.innerText().replace("$", "").trim());
        double quantity = Double.parseDouble(cartPage.quantity.inputValue().trim());
        return price*quantity;
    }

    public CartPageSteps assertIndividualPriceTotal(){
        double expected = calculateTotal();
        assertThat(cartPage.individualTotal).containsText(String.valueOf(expected));
        return this;
    }

    public CartPageSteps changeQuantity(String quantity){
        cartPage.quantity.fill(quantity);
        return this;
    }

    public CartPageSteps assertTotalAfterQuantityChange(String quantity){
        assertThat(cartPage.quantity).hasValue(quantity);
        return this;
    }
    public CartPageSteps proceedToCheckOut(){
        cartPage.proceedToCheckout.click();
        return this;
    }
    public CartPageSteps assertCurrentState(String expected){
        assertThat(cartPage.currentWizardStep).containsText(expected);
        return this;
    }
    public CartPageSteps choosingGuestOption(){
        assertThat(cartPage.guestOption).isVisible();
        cartPage.guestOption.click();
        return this;
    }
    public CartPageSteps fillingGuestEmail(){
        cartPage.email.fill(faker.internet().emailAddress());
        return this;
    }
    public CartPageSteps fillingGuestFirstName(){
        cartPage.firstName.fill(faker.name().firstName());
        return this;
    }
    public CartPageSteps fillingGuestLastName(){
        cartPage.lastName.fill(faker.name().lastName());
        return this;
    }
    public CartPageSteps continueAsaGuest(){
        cartPage.continueAsGuestBtn.click();
        return this;
    }
    public CartPageSteps  assertConfirmMessageAsAGuest(){
         assertThat(cartPage.guestConfirmationMessage).isVisible();
         return this;
    }
    public CartPageSteps fillingBillingStreet(){
        cartPage.street.fill(faker.address().streetAddress());
        return this;
     }
    public CartPageSteps fillingBillingCity(){
        cartPage.city.fill(faker.address().city());
        return this;
    }
    public CartPageSteps fillingBillingState(){
        cartPage.state.fill(faker.address().state());
        return this;
    }
    public CartPageSteps fillingBillingCountry(){
        cartPage.country.fill(faker.address().country());
        return this;
    }
    public CartPageSteps fillingBillingPostCode(){
        cartPage.postcode.fill(faker.address().zipCode());
        return this;
    }

     public CartPageSteps openPaymentMethodDropdown(){
         cartPage.paymentTypeDropDown.click();
         return this;
     }
     public CartPageSteps selectPaymentMethod(String payment){
        cartPage.paymentTypeDropDown.selectOption(payment);
        return this;
     }
     public CartPageSteps confirmPaymentMethod(){
        cartPage.confirmBtn.click();
        return this;
     }

     public CartPageSteps assertPaymentSuccessMessage(){
        assertThat(cartPage.paymentSuccessMessage).isVisible();
        assertThat(cartPage.paymentSuccessMessage).containsText(Constants.PAYMENT_METHOD_MESSAGE);
        return this;
     }
    public CartPageSteps assertOrderConfirmation(){
        cartPage.orderConfirmation.waitFor();
        cartPage.orderConfirmation.isVisible();
        assertThat(cartPage.orderConfirmation).containsText(Constants.ORDER_CONFIRMATION);
        return this;
    }



}
