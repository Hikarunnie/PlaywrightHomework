package ge.tbc.automation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.HandToolsPage;
import io.qameta.allure.Step;

public class HandToolsPageSteps  extends CommonSteps{
    HandToolsPage handToolsPage;
    public HandToolsPageSteps(Page page){
        super(page);
        handToolsPage = new HandToolsPage(page);
    }
    @Step("checking, marking hammer filter")
    public HandToolsPageSteps checkingHammerFilter(){
        handToolsPage.hammerCheckbox.waitFor();
        handToolsPage.hammerCheckbox.check();
        return this;
    }
    @Step("clicking on hammer")
    public HandToolsPageSteps clickingOnHammer(){
        handToolsPage.hammer.waitFor();
        handToolsPage.hammer.click();
        return this;
    }
}
