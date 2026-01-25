package ge.tbc.automation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.TechCanvasRegisterPage;
import io.qameta.allure.Step;

public class TechCanvasRegisterPageSteps {
    TechCanvasRegisterPage techCanvasRegisterPage;

    public TechCanvasRegisterPageSteps(Page page){
        techCanvasRegisterPage=new TechCanvasRegisterPage(page);
    }

    @Step("filling first name {}")
    public TechCanvasRegisterPageSteps fillingFirstName(String firstName) {
        techCanvasRegisterPage.firstName.fill(firstName);
        return this;
    }
    @Step("filling last name {}")
    public TechCanvasRegisterPageSteps fillingLastName(String lastName) {
        techCanvasRegisterPage.lastName.fill(lastName);
        return this;
    }
    @Step("filling choosing gender {}")
    public TechCanvasRegisterPageSteps choosingGender(String gender) {
        if(gender.equals(Constants.FEMALE)) {
            techCanvasRegisterPage.genderFemale.check();
        }else{
            techCanvasRegisterPage.genderMale.check();
        }
        return this;
    }
    @Step("choosing model {}")
    public TechCanvasRegisterPageSteps choosingModel(String model) {
        techCanvasRegisterPage.model.selectOption(model);
        return this;
    }
    @Step("filling address 1 {}")
    public TechCanvasRegisterPageSteps fillingAddress1(String address1) {
        techCanvasRegisterPage.address1.fill(address1);
        return this;
    }
    @Step("filling address 2 {}")
    public TechCanvasRegisterPageSteps fillingAddress2(String address2) {
        techCanvasRegisterPage.address2.fill(address2);
        return this;
    }
    @Step("filling city {}")
    public TechCanvasRegisterPageSteps fillingCity(String city ) {
        techCanvasRegisterPage.city.fill(city);
        return this;
    }
    @Step("filling contact 1 {}")
    public TechCanvasRegisterPageSteps fillingContact1(String contact1) {
        techCanvasRegisterPage.contact1.fill(contact1);
        return this;
    }
    @Step("filling contact 2 {}")
    public TechCanvasRegisterPageSteps fillingContact2(String contact2) {
        techCanvasRegisterPage.contact2.fill(contact2);
        return this;
    }

}
