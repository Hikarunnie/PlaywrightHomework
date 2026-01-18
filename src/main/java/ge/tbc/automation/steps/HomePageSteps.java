package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.HomePage;
import org.testng.Assert;
public class HomePageSteps extends CommonSteps{
    HomePage homePage;
    int count1;
    int count2;
    int countBoth;
    public HomePageSteps(Page page){
        super(page);
        homePage = new HomePage(page);
    }

    public HomePageSteps openingRandomproduct(){
        homePage.randomProduct.click();
        return this;
    }
    public HomePageSteps checkCategory1(){
        homePage.categoryCheckbox1.check();
        homePage.filterResults.last().waitFor();
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
}
