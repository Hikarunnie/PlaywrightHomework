package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TechCanvasRegisterPage {
   public Locator firstName,
           lastName,
           genderMale,
           genderFemale,
           model,
           address1,
           address2,
           city,
           contact1,
           contact2;

    public TechCanvasRegisterPage(Page page){
             this.model=page.getByRole(AriaRole.COMBOBOX);
             this.firstName=page.locator("input[value='First Name']"); //horrible locators
             this.lastName=page.locator("input[value='Last Name']");
             this.genderMale=page.locator("input[value='male']");
             this.genderFemale=page.locator("input[value='female']");

             this.address1=page.locator("input[value ='Address1']");
             this.address2=page.locator("input[value='Address2']");
             this.city=page.locator("input[value='City']");
             this.contact1=page.locator("input[value='Contact1']");
             this.contact2=page.locator("input[value='Contact2']");
    }


}
