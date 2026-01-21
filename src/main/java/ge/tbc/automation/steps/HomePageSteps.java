package ge.tbc.automation.steps;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.LoadState;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.HomePage;
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

    public int getFilteredCardCount(){
        return homePage.filterResults.count();
    }

    public HomePageSteps openingRandomproduct(int i){
        homePage.filterResults.last().waitFor();
        homePage.filterResults.nth(i).click();
        return this;
    }
    public HomePageSteps checkCategory1(){
        homePage.categoryCheckbox1.check();
        assertThat(homePage.cardTitle.first()).containsText(Constants.FILTER_KEYWORDS);
        count1 = homePage.filterResults.count();
        return this;
    }
    public HomePageSteps checkCategory2(){
        homePage.categoryCheckbox2.check();
        homePage.filterResults.last().waitFor();
        count2 = homePage.filterResults.count();

        return this;
    }
    public HomePageSteps uncheckCategory1(){
        homePage.categoryCheckbox1.uncheck();
        return this;
    }
    public HomePageSteps uncheckCategory2(){
        homePage.categoryCheckbox2.uncheck();
        return this;
    }

    public HomePageSteps checkingBoth(){
        homePage.categoryCheckbox1.check();
        homePage.categoryCheckbox2.check();
        homePage.filterResults.last().waitFor();
        countBoth = homePage.filterResults.count();
        return this;
    }
    public HomePageSteps assertingCountsSumIsCorrect(){
        int expected = count1 + count2;
        Assert.assertEquals(countBoth, expected);
        return this;
    }
    public HomePageSteps assertSortSectionDisplay(){
        assertThat(homePage.sortTitle).isVisible();
        return this;
    }
    public HomePageSteps assertSortOptionsDisplay(){
        assertThat(homePage.sortOptions).isVisible();
        return this;
    }

    public HomePageSteps assertFiltersDisplay(){
        assertThat(homePage.filtersTitle).isVisible();
        return this;
    }
    public HomePageSteps assertPaginationDisplay(){
        assertThat(homePage.pagination).isVisible();
        return this;
    }
    public HomePageSteps enteringProductToSearch(String product){
        homePage.searchBar.fill(product);
        return this;
    }
    public HomePageSteps searchingForProduct(){
        homePage.searchButton.click();
        return this;
    }
    public HomePageSteps searchClear(){
        homePage.searchRemoveButton.click();
        return this;
    }

    public HomePageSteps assertSearchResults(String product){
        assertThat(homePage.cardTitle.first()).isVisible();
        for(int i = 0; i < homePage.cardTitle.count(); i++) {
            assertThat(homePage.cardTitle.nth(i)).containsText(product, new LocatorAssertions.ContainsTextOptions().setIgnoreCase(true));
        }
        return this;
    }
    public HomePageSteps choosingBrand(){
        homePage.brandCheckBox.check();
        return this;
    }

}
