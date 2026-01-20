package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HandToolsPage {
   public Locator hammerCheckbox;
   public Locator hammer;

    public  HandToolsPage(Page page){
        this.hammerCheckbox =page.locator("//label[text()=' Hammer']/input");
        this.hammer = page.locator("//h5[text()=' Hammer ']");
    }
}
