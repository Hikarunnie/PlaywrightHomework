package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.RegisterPage;
import net.datafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RegisterPageSteps {
    private Faker faker = new Faker(new Locale("en-US"));
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String email;
    private String password;
    RegisterPage registerPage;

    public RegisterPageSteps(Page page){
        registerPage = new RegisterPage(page);
    }

    public RegisterPageSteps fillUserDetails() {
        LocalDate birthDate = LocalDate.now().minusYears(faker.number().numberBetween(18, 60));
        this.password  ="Hik" + faker.number().numberBetween(44, 444444) + "#Hikn";
        this.email = faker.internet().emailAddress();

        registerPage.firstName.fill(faker.name().firstName());
        registerPage.lastName.fill(faker.name().lastName());
        registerPage.birthDate.fill(birthDate.format(dateFormatter));
        registerPage.street.fill(faker.address().streetAddress());
        registerPage.postalCode.fill(faker.address().zipCode());
        registerPage.city.fill(faker.address().city());
        registerPage.state.fill(faker.address().state());
        registerPage.country.selectOption("Georgia");
        registerPage.phone.fill(faker.phoneNumber().phoneNumber().replaceAll("[^0-9]", ""));
        registerPage.email.fill(this.email );
        registerPage.password.fill(this.password );

        return this;
    }

    public RegisterPageSteps clickRegisterButton() {
        registerPage.registerButton.click();
        return this;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
