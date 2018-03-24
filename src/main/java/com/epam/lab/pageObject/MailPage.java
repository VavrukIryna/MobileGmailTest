package com.epam.lab.pageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class MailPage extends AbstractPage {
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@class='M j T b hc Zm  Ke']")
    private WebElement composeButton;

    @FindBy(xpath = "//*[@class='on Cv']")
    private WebElement senderMailField;

    @FindBy(xpath = "//*[@id='cmcsubj']")
    private WebElement subjectMailField;

    @FindBy(xpath = "//*[@role='textbox']")
    private WebElement messageMailField;

    @FindBy(xpath = "//div[@class='M j T b hc en Ee']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@class='M j T b hc Zm  Wm']")
    private WebElement gmailMenuButton;

    @FindBy(xpath = " //*[@class='il']/div[7]")
    private WebElement sentMailField;

    @FindBy(xpath = " //*[@class='M j dm']")
    private WebElement checkBoxButton;

    @FindBy(xpath = " //div[@class='V j Vd']")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@class='FB']")
    private WebElement deletedMessageField;

    public MailPage(AppiumDriver driver) throws MalformedURLException {
        super(driver);
        this.wait = new WebDriverWait(driver, 50, 100);

    }

    public void typeAndSubmitMessage() throws MalformedURLException {
        wait.until(ExpectedConditions.elementToBeClickable(composeButton));
        composeButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(senderMailField));
        senderMailField.sendKeys("test.iryna.mail@gmail.com");
        subjectMailField.sendKeys("subject");
        messageMailField.sendKeys("message");
        submitButton.click();
    }

    public void deleteMessage() throws MalformedURLException {
        wait.until(ExpectedConditions.elementToBeClickable(gmailMenuButton));
        gmailMenuButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(sentMailField));
        sentMailField.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxButton));
        checkBoxButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
    }

    public boolean verifyDeletedMessage() {
        return deletedMessageField.isEnabled();
    }
}
