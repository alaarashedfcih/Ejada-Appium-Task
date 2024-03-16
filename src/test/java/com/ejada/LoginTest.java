package com.ejada;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class LoginTest {
    AppiumDriver driver;
    LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp () throws URISyntaxException, MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "14");
        cap.setCapability("deviceName", "AlaaTest");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        cap.setCapability("app", "D:/___/Ejada/appium task/src/test/resources/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }
    @Test(alwaysRun = true, priority = 2)
    public void loginWithValid()  {

        loginPage.loginAction("standard_user","secret_sauce");
        Assert.assertEquals(loginPage.loginSuccess(),"PRODUCTS");
    }

    @Test(alwaysRun = true, priority = 1)
    public void loginWithInValid(){
        loginPage.loginAction("standard_user","wrong_pass");
        Assert.assertEquals(loginPage.loginFailed(),"Username and password do not match any user in this service.");
    }

}
