package ge.tbc.automation.tests;
import ge.tbc.automation.data.Constants;
import org.testng.annotations.Test;

@Test(description = "Complete Purchase Flow (HT-T7)")
public class CompletePurchaseFlowTest  extends BaseTest{

    @Test(description = "navigating to homepage", priority = 1)
    public void navigateToHomepage() {
         commonSteps.goToHome();
         homePageSteps.assertSortSectionDisplay()
                      .assertSortOptionsDisplay()
                      .assertFiltersDisplay()
                      . assertPaginationDisplay();
    }

    @Test(description = "searching for specific product", priority = 2)
    public void searchForProduct() {
        homePageSteps.enteringProductToSearch(Constants.HAMMER)
                .searchingForProduct()
                .assertSearchResults(Constants.HAMMER);
    }

    @Test(description = "applying category and brand filters", priority = 3)
    public void applyFilters() {
        homePageSteps.searchClear()
                .checkCategory1()
                .choosingBrand();
        for (int i = 0; i < homePageSteps.getFilteredCardCount(); i++) {   //I wanted to check tags for each card
            homePageSteps.openingRandomproduct(i);                //this was an only way I could write this(?) without using
            productPageSteps.assertingCorrectTag()              //productPageSteps in homePageSteps T_T
                    .assertingCorrectBrandTAg();
        }
    }

    @Test(description = "opening product detail page", priority = 4)
    public void navigatingToProductDetailPage() {
        homePageSteps.goToHome();
        homePageSteps.openingRandomproduct(Constants.RANDOM_PRODUCT);
        productPageSteps.assertNameDisplay()
                .assertPriceDisplay()
                .assertDescriptionDisplay()
                .assertRatingDisplay()
                .assertQuantityDisplay();
    }

    @Test(description = "increasing product quantity", priority = 5)
    public void increasingProductQuantity() {
         productPageSteps.increasingQuantity()
                         .assertingQuantity();
    }

    @Test(description = "adding product to shopping cart", priority = 6)
    public void addProductToCart() {
          productPageSteps.addingToCart()
                          .assertingSuccessNotification(Constants.CART_SUCCESS_NOTIFICATION);
    }

    @Test(description = "navigating to cart page", priority = 7)
    public void navigatingToCart() {
        commonSteps.goToCart();
        cartPageSteps.assertItemTitle()
                     .assertIndividualPriceDisplay()
                     .assertQuantity()
                     .assertIndividualPriceTotal();
    }

    @Test(description = "modifying quantity in cart", priority = 8)
    public void modifyingQuantityInCart() {
        cartPageSteps.changeQuantity(Constants.QUANTITY_NEW)
                     .assertTotalAfterQuantityChange(Constants.QUANTITY_NEW);
    }

    @Test(description = "proceeding to checkout", priority = 9)
    public void proceedToCheckout() {
       cartPageSteps.proceedToCheckOut()
               .assertCurrentState(Constants.SIGN_IN_STEP);
    }

    @Test(description = "continuing as a guest", priority = 10)
    public void continuingAsGuest() {
       cartPageSteps.choosingGuestOption()
               .fillingGuestEmail()
               .fillingGuestFirstName()
               .fillingGuestLastName()
               .continueAsaGuest()
               .assertConfirmMessageAsAGuest()
               .proceedToCheckOut()
              .assertCurrentState(Constants.BILLING_STEP);
    }

    @Test(description = "completing billing address", priority = 11)
    public void completingBillingAddress() {
        cartPageSteps.fillingBillingStreet()
                .fillingBillingCity()
                .fillingBillingState()
                .fillingBillingCountry()
                .fillingBillingPostCode()
                .proceedToCheckOut()
                .assertCurrentState(Constants.PAYMENT_STEP);
    }

    @Test(description = "completing order", priority = 12)
    public void completingOrder() {
        cartPageSteps.openPaymentMethodDropdown()
                .selectPaymentMethod(Constants.PAYMENT_METHOD)
                .confirmPaymentMethod()
                .assertPaymentSuccessMessage()
                .confirmPaymentMethod()
                .assertOrderConfirmation();
    }

}
