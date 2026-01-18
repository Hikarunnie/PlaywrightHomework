package ge.tbc.automation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.FavouritesPage;
import org.testng.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FavouritesPageSteps extends CommonSteps {
    FavouritesPage favouritesPage;

    public FavouritesPageSteps(Page page){
        super(page);
        favouritesPage = new FavouritesPage(page);
    }

    public FavouritesPageSteps assertingCardWasAdded(){
        assertThat(favouritesPage.favouriteCards.first()).containsText(Constants.FAVOURITE_CARD);
        return this;
    }
    public FavouritesPageSteps deletingFavourite(){
        favouritesPage.deleteButton.click();
        assertThat(favouritesPage.deleteButton).not().isVisible();

        return this;
    }
    public FavouritesPageSteps assertingDeletionEmptiness(){
       Assert.assertEquals(favouritesPage.favouriteCards.count(),0);
       return this;
    }
}
