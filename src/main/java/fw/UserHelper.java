package fw;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[contains(.,'Registration')]"));
    }

    public boolean isErrorMessagePresent() {
        return isElementPresent(By.xpath("//div[contains(.,'Registration failed with code 400')]"));
    }

    public void login() {
        fillLoginRegistrationForm(new User().setEmail("Man@gmail.com").setPassword( "Aa123456789~"));
        click(By.xpath("//button[contains(.,'Login')]"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(.,'Login')]"));
    }

    public boolean isLoginRegFormPresent() {
        return isElementPresent(By.cssSelector(".login_login__3EHKB"));
    }
}
