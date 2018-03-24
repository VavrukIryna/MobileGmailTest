package com.epam.lab.businessObjects;

import com.epam.lab.SingletonDriver;
import com.epam.lab.pageObject.LoginPage;
import com.epam.lab.pageObject.PasswordPage;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;


public class LoginBusinessObject extends SingletonDriver {
    private LoginPage loginPage;
    private PasswordPage passwordPage;

    public LoginBusinessObject(AppiumDriver driver) throws MalformedURLException {


        this.loginPage = new LoginPage(driver);
        this.passwordPage = new PasswordPage(driver);
    }

    public void loginUser(String login, String password) throws InterruptedException, MalformedURLException {
        loginPage.typeLogin(login);
        passwordPage.typePassword(password);
    }
}
