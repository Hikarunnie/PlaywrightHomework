package ge.tbc.automation.pages.prestashop;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import ge.tbc.automation.data.Constants;

public class PrestaCommonPage {
    public Frame frame;
    public Locator homePageRedirect;
    public Locator footer;
    public Locator contactInfo;
    public Locator emailUs;

    public PrestaCommonPage(Page page){
        this.frame=page.frame("framelive");
        this.homePageRedirect=frame.getByAltText(Constants.PRESTA_SHOP);
        this.footer=frame.locator("#footer");
        this.contactInfo=frame.locator("#contact-infos");
        this.emailUs=contactInfo.getByRole(AriaRole.LINK);
    }
}
