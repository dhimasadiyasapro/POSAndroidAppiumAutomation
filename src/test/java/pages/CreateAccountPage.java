package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Dhimas Adiyasa Wirawan on 12/26/2015.
 */
public class CreateAccountPage extends BasePage {
    By userEmail = By.id(app_package_name+"email");
    By userPass = By.id(app_package_name+"password");
    By confirmPass = By.id(app_package_name+"passwordConfirmation");
    By createAcc = By.id(app_package_name+"signUpButton");
    By Title = By.id(app_package_name+"title");
    By Content = By.id(app_package_name+"content");
    By OKButton = By.id(app_package_name+"buttonDefaultNegative");

    public CreateAccountPage(WebDriver driver) { super(driver);}

    public CreateAccountPage AllEmptySignUpAttempt(){
        // Sign Up Screen
        waitForVisibilityOf(userEmail);
        driver.findElement(createAcc).click();
        waitForVisibilityOf(Content);
        String ErrTitle = driver.findElement(Title).getText();
        String ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");
        Assert.assertEquals(ErrContent,"Email cannot be blank");

        return new CreateAccountPage(driver);
    }

    public CreateAccountPage InvalidEmailSignUpAttempt(){
        // Sign Up Screen
        waitForVisibilityOf(userEmail);
        // 1st validation
        driver.findElement(userEmail).sendKeys("dhimas23staging");
        driver.findElement(createAcc).click();
        waitForVisibilityOf(Content);
        String ErrTitle = driver.findElement(Title).getText();
        String ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");
        Assert.assertEquals(ErrContent,"Email is not valid");
        driver.findElement(OKButton).click();
        // 2nd validation
        driver.findElement(userEmail).sendKeys("dhimas23staging@mailinator");
        driver.findElement(createAcc).click();
        waitForVisibilityOf(Content);
        ErrTitle = driver.findElement(Title).getText();
        ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");
        Assert.assertEquals(ErrContent,"Email is not valid");
        driver.findElement(OKButton).click();
        // 3rd validation
        driver.findElement(userEmail).sendKeys("dhimas23staging@mailinator@com");
        driver.findElement(createAcc).click();
        waitForVisibilityOf(Content);
        ErrTitle = driver.findElement(Title).getText();
        ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");
        Assert.assertEquals(ErrContent,"Email is not valid");
        driver.findElement(OKButton).click();
        // 4th validation
        driver.findElement(userEmail).sendKeys("dhimas23staging.mailinator.com");
        driver.findElement(createAcc).click();
        waitForVisibilityOf(Content);
        ErrTitle = driver.findElement(Title).getText();
        ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");
        Assert.assertEquals(ErrContent,"Email is not valid");
        driver.findElement(OKButton).click();

        return new CreateAccountPage(driver);
    }

    public CreateAccountPage ExistingEmailValidationSignUpAttempt(){
        // Sign Up Screen
        waitForVisibilityOf(userEmail);
        driver.findElement(userEmail).sendKeys("dhimas23staging@mailinator.com");
        driver.findElement(userPass).sendKeys("123456");
        driver.findElement(confirmPass).sendKeys("123456");
        driver.findElement(createAcc).click();
        waitForVisibilityOf(Content);
        String ErrTitle = driver.findElement(Title).getText();
        String ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");
        Assert.assertEquals(ErrContent,"Email exists");

        return new CreateAccountPage(driver);
    }

}
