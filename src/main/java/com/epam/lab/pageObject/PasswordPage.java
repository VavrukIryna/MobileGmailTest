package com.epam.lab.pageObject;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class PasswordPage extends AbstractPage {
    private WebDriverWait wait;

    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextButton;

    public PasswordPage(AppiumDriver driver) throws MalformedURLException {
        super(driver);
        this.wait = new WebDriverWait(driver, 50, 100);
    }


    public void typePassword(String password) throws MalformedURLException {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }


}

