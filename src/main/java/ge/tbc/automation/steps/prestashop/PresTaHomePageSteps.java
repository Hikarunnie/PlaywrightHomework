package ge.tbc.automation.steps.prestashop;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.prestashop.HomePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class PresTaHomePageSteps extends PrestaCommonPageSteps {
    HomePage homePage;
    Page page;

    public PresTaHomePageSteps(Page page){
        super(page);
        homePage=new HomePage(page);
        this.page = page;
    }

    public PresTaHomePageSteps assertThereIsOneBreadCrumb(){
        assertThat(homePage.breadCrumbs).hasCount(1);
        return this;
    }
    public PresTaHomePageSteps assertWeAreOnHomePage(){
        assertThat(homePage.breadCrumbs).hasText(Constants.HOME);
        return this;
    }
    public PresTaHomePageSteps goToContactUs() {
        homePage.contactUsRedirect.click();
        return this;
    }

    public PresTaHomePageSteps scrollToPopularProducts() {
        homePage.popularProductsSection.scrollIntoViewIfNeeded();
        return this;
    }

    public PresTaHomePageSteps assertShopContentSectionVisibility() {
        assertThat(homePage.popularProductsSection).isVisible();
        return this;
    }
    public PresTaHomePageSteps assertingShopContentTitle() {
        assertThat(homePage.popularProductsTitle).isVisible();
        return this;
    }
    public PresTaHomePageSteps hoveringOverPopularProducts(){
        homePage.allPopularProducts.all().forEach(Locator::hover);
        return this;
    }
    public PresTaHomePageSteps assertingPopularProductsExist(){
        assertThat(homePage.allPopularProducts).not().hasCount(0);
        return this;
    }

}
