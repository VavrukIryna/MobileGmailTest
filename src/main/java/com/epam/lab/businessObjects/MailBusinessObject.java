package com.epam.lab.businessObjects;

import com.epam.lab.pageObject.MailPage;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;


public class MailBusinessObject {

    private MailPage mailPage;


    public MailBusinessObject(AppiumDriver driver) throws MalformedURLException {
        this.mailPage = new MailPage(driver);
    }


    public void writeMessage() throws MalformedURLException {
        mailPage.typeAndSubmitMessage();

    }

    public void deleteMessage() throws MalformedURLException {
        mailPage.deleteMessage();
    }

    public boolean checkDeletedMail() {
        return mailPage.verifyDeletedMessage();
    }

}
