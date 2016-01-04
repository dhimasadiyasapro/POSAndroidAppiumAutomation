package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dhimas Adiyasa Wirawan on 11/29/2015.
 */
public class AppGatePage extends BasePage {
    By signInButton = By.id(app_package_name+"goToSignIn");
    By createAccButton = By.id(app_package_name+"goToCreateAccount");

    public AppGatePage(WebDriver driver) {
        super(driver);
    }

    public AppGatePage accessLogin(){
        waitForVisibilityOf(signInButton);
        driver.findElement(signInButton).click();

        return new AppGatePage(driver);
    }

    public AppGatePage accessSignUp(){
        waitForVisibilityOf(createAccButton);
        driver.findElement(createAccButton).click();

        return new AppGatePage(driver);
    }
}
