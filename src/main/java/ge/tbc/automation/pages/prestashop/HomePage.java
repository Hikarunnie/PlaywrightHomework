package ge.tbc.automation.pages.prestashop;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import ge.tbc.automation.data.Constants;

public class HomePage {
    public Frame frame;
    public Locator contactUsRedirect;
    public Locator  popularProductsSection;
    public Locator popularProductsTitle;
    public Locator allPopularProducts;
    public Locator breadCrumbs;
    public HomePage(Page page){
        this.frame=page.frame("framelive");
        this.contactUsRedirect=frame.locator("li").getByText(Constants.CONTACT_US_TEXT);
        this.popularProductsSection=frame.locator("section[data-type='popularproducts']");
        this.popularProductsTitle=frame.getByRole(AriaRole.HEADING,new Frame.GetByRoleOptions().setName("Popular Products"));



        this.breadCrumbs=frame.locator("nav.breadcrumb").getByText(Constants.HOME);
        this.allPopularProducts=popularProductsSection.locator("div.js-product ");
    }
}
