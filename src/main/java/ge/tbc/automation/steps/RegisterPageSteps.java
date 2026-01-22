package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.data.Constants;
import ge.tbc.automation.pages.RegisterPage;
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

    public RegisterPageSteps fillingFirstName() {
        registerPage.firstName.fill(faker.name().firstName());
        return this;
    }
    public RegisterPageSteps fillingLastName() {
        registerPage.lastName.fill(faker.name().lastName());
        return this;
    }
    public RegisterPageSteps fillingBirthDate() {
        LocalDate birthDate = LocalDate.now().minusYears(faker.number().numberBetween(18, 60));
        registerPage.birthDate.fill(birthDate.format(dateFormatter));
        return this;
    }
    public RegisterPageSteps fillingStreet() {
        registerPage.street.fill(faker.address().streetAddress());
        return this;
    }
    public RegisterPageSteps fillingPostalCode() {
        registerPage.postalCode.fill(faker.address().zipCode());
        return this;
    }
    public RegisterPageSteps fillingCity() {
        registerPage.city.fill(faker.address().city());
        return this;
    }
    public RegisterPageSteps fillingState() {
        registerPage.state.fill(faker.address().state());
        return this;
    }
    public RegisterPageSteps fillingCountry() {
        registerPage.country.selectOption(faker.address().country());
        return this;
    }
    public RegisterPageSteps fillingPhone() {
        registerPage.phone.fill(faker.phoneNumber().phoneNumber().replaceAll("[^0-9]", ""));
        return this;
    }
    public RegisterPageSteps fillingEmail() {
        this.email = faker.internet().emailAddress();
        registerPage.email.fill(this.email);
        return this;
    }
    public RegisterPageSteps fillingPassword() {
        this.password  ="Hik" + faker.number().numberBetween(44, 444444) + "#Hikn";
        registerPage.password.fill(this.password);
        return this;
    }
    public RegisterPageSteps clickRegisterButton() {
        registerPage.registerButton.click();
        return this;
    }
    public RegisterPageSteps assertInvalidEmailMessage(){
        assertThat(registerPage.invalidEmailMessage).hasText(Constants.INVALID_EMAIL_MESSAGE);
        return this;
    }
    public RegisterPageSteps assertInvalidPasswordMessage(){
        assertThat(registerPage.invalidPasswordMessage).containsText(Constants.INVALID_PASSWORD_MESSAGE);
        return this;
    }
    public RegisterPageSteps fillingEmail(String email) {
        this.email = email;
        registerPage.email.fill(email);
        return this;
    }
    public RegisterPageSteps assertingNoAlertIsPresent(){
        assertThat(registerPage.alerts).not().isVisible();
        return this;
    }
    public RegisterPageSteps fillingPassword(String password) {
        registerPage.password.fill(password);
        return this;
    }
    public RegisterPageSteps assertRegistrationHeader(){
        assertThat(registerPage.registrationFormHeader).isVisible();
        return this;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
