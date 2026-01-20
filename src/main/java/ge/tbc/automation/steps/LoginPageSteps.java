package ge.tbc.automation.steps;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.LoginPage;
public class LoginPageSteps {
    LoginPage loginPage;

    public LoginPageSteps(Page page){
        loginPage = new LoginPage(page);
    }

    public LoginPageSteps goToRegister(){
        loginPage.registerRedirect.click();
        return this;
    }

    public LoginPageSteps enterEmail(String email){
        loginPage.pageTitle.waitFor();
        loginPage.email.fill(email);
        return this;
    }

    public LoginPageSteps enterpassword(String password){
        loginPage.password.fill(password);
        return this;
    }

    public LoginPageSteps clickLogInbutton(){
        loginPage.LogButton.click();
        loginPage.resitle.waitFor();
        return this;
    }
}
