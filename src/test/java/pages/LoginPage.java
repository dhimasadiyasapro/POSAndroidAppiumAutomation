package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


/**
 * Created by Dhimas Adiyasa Wirawan on 11/29/2015.
 */
public class LoginPage extends BasePage {
    By userEmail = By.id(app_package_name+"email");
    By userPass = By.id(app_package_name+"password");
    By LoginButton = By.id(app_package_name+"signInButton");
    By Title = By.id(app_package_name+"title");
    By Content = By.id(app_package_name+"content");
    By outletOption = By.id(app_package_name+"outlet_name");
    By outletContinueButton = By.id(app_package_name+"outlet_continue");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage allEmptyLoginAttempt(){
        // Sign In Screen
        waitForVisibilityOf(userEmail);
        driver.findElement(LoginButton).click();
        waitForVisibilityOf(Title);
        String ErrTitle = driver.findElement(Title).getText();
        String ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");
        Assert.assertEquals(ErrContent,"Please enter your valid email and password");

        return new LoginPage(driver);
    }

    public LoginPage emailEmptyLoginAttempt(){
        // Sign In Screen
        waitForVisibilityOf(userEmail);
        driver.findElement(userPass).sendKeys("123456");
        driver.findElement(LoginButton).click();
        waitForVisibilityOf(Title);
        String ErrTitle = driver.findElement(Title).getText();
        String ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");
        Assert.assertEquals(ErrContent,"Please enter your valid email and password");

        return new LoginPage(driver);
    }

    public LoginPage emailPassLoginAttempt(){
        // Sign In Screen
        waitForVisibilityOf(userEmail);
        driver.findElement(userEmail).sendKeys("dhimas23staging@mailinator.com");
        driver.findElement(LoginButton).click();
        waitForVisibilityOf(Title);
        String ErrTitle = driver.findElement(Title).getText();
        String ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");
        Assert.assertEquals(ErrContent,"Please enter your valid email and password");

        return new LoginPage(driver);
    }

    public LoginPage invalidEmailLogin(){
        // Sign In Screen
        waitForVisibilityOf(userEmail);
        driver.findElement(userEmail).sendKeys("dhimas23staging@mailinator.co.id");
        driver.findElement(userPass).sendKeys("123456");
        driver.findElement(LoginButton).click();
        waitForVisibilityOf(Title);
        String ErrTitle = driver.findElement(Title).getText();
        String ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");// Check Error Title
        Assert.assertEquals(ErrContent,"Authentication failed. Please check your username and password.");// Check Error Content

        return new LoginPage(driver);
    }

    public LoginPage invalidPassLogin(){
        // Sign In Screen
        waitForVisibilityOf(userEmail);
        driver.findElement(userEmail).sendKeys("dhimas23staging@mailinator.com");
        driver.findElement(userPass).sendKeys("654321");
        driver.findElement(LoginButton).click();
        waitForVisibilityOf(Title);
        String ErrTitle = driver.findElement(Title).getText();
        String ErrContent = driver.findElement(Content).getText();
        Assert.assertEquals(ErrTitle,"Error");
        Assert.assertEquals(ErrContent,"Authentication failed. Please check your username and password.");

        return new LoginPage(driver);
    }

    public LoginPage validLogin(){
        // Sign In Screen
        waitForVisibilityOf(userEmail);
        driver.findElement(userEmail).sendKeys("dhimas23staging@mailinator.com");
        driver.findElement(userPass).sendKeys("123456");
        driver.findElement(LoginButton).click();
        waitForVisibilityOf(outletOption);
        String outletOptionText = driver.findElement(outletOption).getText();
        Assert.assertEquals(outletOptionText,"-Select Your Outlet-"); // Check the Outlet Option Dropdown List for Multiple Outlet

        return new LoginPage(driver);
    }

    public LoginPage invalidOutletOption(){
        driver.findElement(outletContinueButton).click();

        return new LoginPage(driver);
    }

}
