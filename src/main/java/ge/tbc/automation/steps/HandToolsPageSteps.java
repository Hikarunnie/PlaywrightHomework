package ge.tbc.automation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.HandToolsPage;

public class HandToolsPageSteps  extends CommonSteps{
    HandToolsPage handToolsPage;
    public HandToolsPageSteps(Page page){
        super(page);
        handToolsPage = new HandToolsPage(page);
    }

    public HandToolsPageSteps checkingHammerFilter(){
        handToolsPage.hammerCheckbox.waitFor();
        handToolsPage.hammerCheckbox.check();
        return this;
    }

    public HandToolsPageSteps clickingOnHammer(){
        handToolsPage.hammer.waitFor();
        handToolsPage.hammer.click();
        return this;
    }
}
