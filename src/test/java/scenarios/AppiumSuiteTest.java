package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AppGatePage;
import pages.CreateAccountPage;
import pages.LoginPage;

/**
 * Created by Dhimas Adiyasa Wirawan on 11/29/2015.
 */
public class AppiumSuiteTest extends AndroidConfig {
    @BeforeClass
    public void setUp() throws Exception{
        prepareAppiumAndroid();
    }

    @AfterClass
    public void tearDown() throws Exception{
        driver.quit();
    }

    // Login Test Cases
    @Test
    public void EmptyLoginAttemptTest() throws InterruptedException{
        new AppGatePage(driver).accessLogin();
        new LoginPage(driver).allEmptyLoginAttempt();
    }

    @Test
    public void EmptyEmailLoginAttemptTest() throws InterruptedException{
        new AppGatePage(driver).accessLogin();
        new LoginPage(driver).emailEmptyLoginAttempt();
    }

    @Test
    public void EmptyPassLoginAttemptTest() throws InterruptedException{
        new AppGatePage(driver).accessLogin();
        new LoginPage(driver).emailPassLoginAttempt();
    }

    @Test
    public void InvalidEmailLoginTest() throws InterruptedException{
        new AppGatePage(driver).accessLogin();
        new LoginPage(driver).invalidEmailLogin();
    }

    @Test
    public void InvalidPassLoginTest() throws InterruptedException{
        new AppGatePage(driver).accessLogin();
        new LoginPage(driver).invalidPassLogin();
    }

    @Test
    public void ValidLoginTest() throws InterruptedException{
        new AppGatePage(driver).accessLogin();
        new LoginPage(driver).validLogin();
        new LoginPage(driver).invalidOutletOption();
    }

    // Sign Up Test Cases
    @Test
    public void EmptyCreateAccountTest() throws InterruptedException{
        new AppGatePage(driver).accessSignUp();
        new CreateAccountPage(driver).AllEmptySignUpAttempt();
    }

    @Test
    public void EmptyEmailCreateAccountTest() throws InterruptedException{
        new AppGatePage(driver).accessSignUp();
        new CreateAccountPage(driver).InvalidEmailSignUpAttempt();
    }

    @Test
    public void ExistingEmailCreateAccountTest() throws InterruptedException{
        new AppGatePage(driver).accessSignUp();
        new CreateAccountPage(driver).ExistingEmailValidationSignUpAttempt();
    }
}
