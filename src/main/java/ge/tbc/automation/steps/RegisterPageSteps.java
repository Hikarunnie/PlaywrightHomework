package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.RegisterPage;
import io.qameta.allure.Step;
import net.datafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterPageSteps {
    private Faker faker = new Faker(new Locale("en-US"));
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String email;
    private String password;
    RegisterPage registerPage;

    public RegisterPageSteps(Page page){
        registerPage = new RegisterPage(page);
    }

    @Step("Filling first name")
    public RegisterPageSteps fillingFirstName() {
        registerPage.firstName.fill(faker.name().firstName());
        return this;
    }
    @Step("Filling last name")
    public RegisterPageSteps fillingLastName() {
        registerPage.lastName.fill(faker.name().lastName());
        return this;
    }
    @Step("Filling birth date")
    public RegisterPageSteps fillingBirthDate() {
        LocalDate birthDate = LocalDate.now().minusYears(faker.number().numberBetween(18, 60));
        registerPage.birthDate.fill(birthDate.format(dateFormatter));
        return this;
    }
    @Step("Filling Street")
    public RegisterPageSteps fillingStreet() {
        registerPage.street.fill(faker.address().streetAddress());
        return this;
    }
    @Step("Filling PostalCode")
    public RegisterPageSteps fillingPostalCode() {
        registerPage.postalCode.fill(faker.address().zipCode());
        return this;
    }
    @Step("filling City ")
    public RegisterPageSteps fillingCity() {
        registerPage.city.fill(faker.address().city());
        return this;
    }
    @Step("filling State  ")
    public RegisterPageSteps fillingState() {
        registerPage.state.fill(faker.address().state());
        return this;
    }
    @Step("filling Country")
    public RegisterPageSteps fillingCountry() {
        registerPage.country.selectOption(faker.address().country());
        return this;
    }
    @Step("filling Phone")
    public RegisterPageSteps fillingPhone() {
        registerPage.phone.fill(faker.phoneNumber().phoneNumber().replaceAll("[^0-9]", ""));
        return this;
    }
    @Step("filling Email")
    public RegisterPageSteps fillingEmail() {
        this.email = faker.internet().emailAddress();
        registerPage.email.fill(this.email);
        return this;
    }
    @Step("filling Password")
    public RegisterPageSteps fillingPassword() {
        this.password  ="Hik" + faker.number().numberBetween(44, 444444) + "#Hikn";
        registerPage.password.fill(this.password);
        return this;
    }

    @Step("Clicking register button")
    public RegisterPageSteps clickRegisterButton() {
        registerPage.registerButton.click();
        return this;
    }
    @Step("Asserting invalid email validation message is displayed")
    public RegisterPageSteps assertInvalidEmailMessage(){
        assertThat(registerPage.invalidEmailMessage).hasText(Constants.INVALID_EMAIL_MESSAGE);
        return this;
    }
    @Step("Asserting invalid password validation message is displayed")
    public RegisterPageSteps assertInvalidPasswordMessage(){
        assertThat(registerPage.invalidPasswordMessage).containsText(Constants.INVALID_PASSWORD_MESSAGE);
        return this;
    }
    @Step("Filling email field with value {}")
    public RegisterPageSteps fillingEmail(String email) {
        this.email = email;
        registerPage.email.fill(email);
        return this;
    }
    @Step("Asserting no alert messages are present")
    public RegisterPageSteps assertingNoAlertIsPresent(){
        assertThat(registerPage.alerts).not().isVisible();
        return this;
    }
    @Step("Filling password field")
    public RegisterPageSteps fillingPassword(String password) {
        registerPage.password.fill(password);
        return this;
    }
    @Step("Asserting registration form header is displayed")
    public RegisterPageSteps assertRegistrationHeader(){
        assertThat(registerPage.registrationFormHeader).isVisible();
        return this;
    }
//i doubt these count as steps
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
