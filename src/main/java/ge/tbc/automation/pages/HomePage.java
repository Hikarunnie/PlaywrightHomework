package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import ge.tbc.automation.data.Constants;

public class HomePage{
    public Locator randomProduct;
    public Locator categoryCheckbox1;
    public Locator categoryCheckbox2;
    public Locator filterResults;
    public Locator sortTitle;
    public Locator sortOptions;
    public Locator filtersTitle;
    public Locator pagination;
    public Locator searchBar;
    public Locator searchButton;
    public Locator searchRemoveButton;
    public Locator cardTitle;
    public Locator brandCheckBox;

    public HomePage(Page page){
        this.sortTitle = page.getByText("Sort");
        this.sortOptions = page.getByLabel("sort");
        this.filtersTitle = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Filters"));
        this.pagination = page.locator(".pagination");
        this.searchBar = page.getByRole(AriaRole.TEXTBOX);
        this.searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        this.searchRemoveButton = page.getByTestId("search-reset");
        this.filterResults =page.locator("a.card");
        this.cardTitle = filterResults.getByTestId("product-name");
        this.brandCheckBox = page.getByLabel(Constants.FORGE_FLEX_TOOLS);
        this.categoryCheckbox1 =  page.getByLabel(Constants.SAFETY_GEAR);


        this.randomProduct= page.getByText(Constants.FAVOURITE_CARD);
        this.categoryCheckbox2 = page.locator("//label[text()='"+ Constants.TOOLS_BELTS +"']/input");
    }
}
