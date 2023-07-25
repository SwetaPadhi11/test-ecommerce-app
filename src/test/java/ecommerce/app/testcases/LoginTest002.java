package ecommerce.app.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import ecommerce.app.pageObjects.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTest002 extends BaseClass {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest002.class);

    @Test
    public void loginTest() throws IOException {
        ExtentTest test = getExtent().createTest("Login using Username and password");
        logger.info("URL is opened");

        UserLogin lp = new UserLogin(driver);
        lp.setUserName(username);
        logger.info("Entered username");

        lp.setPassword(password);
        logger.info("Entered password");

        lp.clickSubmit();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            assertTrue(true);
            logger.info("Login test passed");
            test.log(Status.PASS, "User login is successful");
            test.pass("Test has passed");
        } else {
            captureScreen(driver, "loginTest");
            assertTrue(false);
            logger.info("Login test failed");
        }
    }

    @Test
    public void hello() throws IOException {
        //ExtentTest test = getExtent().createTest("Hello thread");
        //System.out.println("Running thread..." + Thread.currentThread().getName());
    }
}
