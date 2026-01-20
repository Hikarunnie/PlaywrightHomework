package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;

public class HomePage{
    public Locator randomProduct;
    public Locator categoryCheckbox1;
    public Locator categoryCheckbox2;
    public Locator filterResults;

    public HomePage(Page page){
        this.randomProduct= page.locator("//h5[text() ='"+ Constants.FAVOURITE_CARD+"']");
        this.categoryCheckbox1 = page.locator("//label[text()='"+ Constants.POWER_TOOLS +"']/input");
        this.categoryCheckbox2 = page.locator("//label[text()='"+ Constants.TOOLS_BELTS +"']/input");
        this.filterResults =page.locator("div[data-test='filter_completed'] a");
    }
}
