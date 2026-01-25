package ge.tbc.automation.steps;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.LoadState;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.HomePage;
import io.qameta.allure.Step;
import org.testng.Assert;
import com.microsoft.playwright.Page;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageSteps extends CommonSteps{
    HomePage homePage;
    int count1;
    int count2;
    int countBoth;
    public HomePageSteps(Page page){
        super(page);
        homePage = new HomePage(page);
    }
    @Step("Getting filtered product card count")
    public int getFilteredCardCount(){
        return homePage.filterResults.count();
    }

    @Step("opening Random product with index {}")
    public HomePageSteps openingRandomproduct(int i){
        homePage.filterResults.last().waitFor();
        homePage.filterResults.nth(i).click();
        return this;
    }
    @Step("Checking first category filter")
    public HomePageSteps checkCategory1(){
        homePage.categoryCheckbox1.check();
        assertThat(homePage.cardTitle.first()).containsText(Constants.FILTER_KEYWORDS);
        count1 = homePage.filterResults.count();
        return this;
    }
    @Step("Checking second category filter")
    public HomePageSteps checkCategory2(){
        homePage.categoryCheckbox2.check();
        homePage.filterResults.last().waitFor();
        count2 = homePage.filterResults.count();

        return this;
    }
    @Step("Unchecking first category filter")
    public HomePageSteps uncheckCategory1(){
        homePage.categoryCheckbox1.uncheck();
        return this;
    }
    @Step("Unchecking second category filter")
    public HomePageSteps uncheckCategory2(){
        homePage.categoryCheckbox2.uncheck();
        return this;
    }
    @Step("Checking both category filters")
    public HomePageSteps checkingBoth(){
        homePage.categoryCheckbox1.check();
        homePage.categoryCheckbox2.check();
        homePage.filterResults.last().waitFor();
        countBoth = homePage.filterResults.count();
        return this;
    }
    @Step("Asserting combined filter count equals sum of individual filters")
    public HomePageSteps assertingCountsSumIsCorrect(){
        homePage.cardTitle.last().waitFor();
        int expected = count1 + count2;
        Assert.assertEquals(countBoth, expected);
        return this;
    }
    @Step("Asserting sort section is displayed")
    public HomePageSteps assertSortSectionDisplay(){
        assertThat(homePage.sortTitle.first()).isVisible();
        return this;
    }

    @Step("Asserting sort options are displayed")
    public HomePageSteps assertSortOptionsDisplay(){
        assertThat(homePage.sortOptions).isVisible();
        return this;
    }
    @Step("Asserting filters section is displayed")
    public HomePageSteps assertFiltersDisplay(){
        assertThat(homePage.filtersTitle.last()).isVisible();
        return this;
    }
    @Step("Asserting pagination display")
    public HomePageSteps assertPaginationDisplay(){
        assertThat(homePage.pagination).isVisible();
        return this;
    }
    @Step("Entering product name into search field {}")
    public HomePageSteps enteringProductToSearch(String product){
        homePage.searchBar.fill(product);
        return this;
    }
    @Step("Submitting product search")
    public HomePageSteps searchingForProduct(){
        homePage.searchButton.click();
        return this;
    }
    @Step("Clearing search field")
    public HomePageSteps searchClear(){
        homePage.searchRemoveButton.click();
        return this;
    }
    @Step("Asserting search results contain product name {}")
    public HomePageSteps assertSearchResults(String product){
        assertThat(homePage.cardTitle.first()).isVisible();
        for(int i = 0; i < homePage.cardTitle.count(); i++) {
            assertThat(homePage.cardTitle.nth(i)).containsText(product, new LocatorAssertions.ContainsTextOptions().setIgnoreCase(true));
        }
        return this;
    }
    @Step("Choosing brand filter")
    public HomePageSteps choosingBrand(){
        homePage.brandCheckBox.check();
        return this;
    }

}
