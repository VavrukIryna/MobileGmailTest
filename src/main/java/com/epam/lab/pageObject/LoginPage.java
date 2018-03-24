package com.epam.lab.pageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class LoginPage extends AbstractPage {
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@type = 'email']")
    private WebElement loginInput;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextButton;

    public LoginPage(AppiumDriver driver) throws MalformedURLException {
        super(driver);
        this.wait = new WebDriverWait(driver, 50, 100);
    }

    public void typeLogin(String login) throws InterruptedException, MalformedURLException {

        wait.until(ExpectedConditions.elementToBeClickable(loginInput));
        loginInput.click();
        loginInput.sendKeys(login);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();

    }


}
