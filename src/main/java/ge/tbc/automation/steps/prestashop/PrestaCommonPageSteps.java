package ge.tbc.automation.steps.prestashop;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.prestashop.PrestaCommonPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PrestaCommonPageSteps {
    PrestaCommonPage prestaCommonPage;
    public PrestaCommonPageSteps(Page page){
        prestaCommonPage=new PrestaCommonPage(page);
    }
    public PrestaCommonPageSteps navigatingToHome(){
        prestaCommonPage.homePageRedirect.click();
        return this;
    }


    public PrestaCommonPageSteps scrollToFooter() {
        prestaCommonPage.footer.waitFor();
        prestaCommonPage.footer.scrollIntoViewIfNeeded();
        return this;
    }

    public PrestaCommonPageSteps assertContactInfoSectionDisplay(){
        assertThat(prestaCommonPage.contactInfo).isVisible();
        return this;
    }
    public PrestaCommonPageSteps assertEmailDisplay() {
        assertThat(prestaCommonPage.emailUs).isVisible();
        System.out.println(extractStoreEmail());
        return this;
    }

    public String extractStoreEmail() {
        return (String) prestaCommonPage.frame.evaluate("el => el.textContent.trim()", prestaCommonPage.emailUs.elementHandle());
    }
}
