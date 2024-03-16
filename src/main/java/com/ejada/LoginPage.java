package com.ejada;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

        AppiumDriver driver;
        private By userName = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
        private By password = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
        private By errorMsg = By.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]");
        private By productsTitle = By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
        private By loginBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");

    public LoginPage(AppiumDriver driver) {
         this.driver = driver;
    }

    public void loginAction(String Name ,String pass) {
        driver.findElement(userName).sendKeys(Name);
        driver.findElement(password).sendKeys(pass);
        WebElement btn = driver.findElement(loginBtn);
        btn.click();
    }

    public  String loginSuccess(){
        return driver.findElement(productsTitle).getText();
    }

    public  String loginFailed(){
        return driver.findElement(errorMsg).getText();
    }

}
