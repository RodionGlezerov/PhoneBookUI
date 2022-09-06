package fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase{

    public HeaderHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickOnAddLink() {
        click(By.cssSelector("a:nth-child(5)"));
    }

    public void clickOnSignOutButton() {
        driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }
}
