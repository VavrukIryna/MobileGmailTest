package com.epam.lab;


import com.epam.lab.businessObjects.LoginBusinessObject;
import com.epam.lab.businessObjects.MailBusinessObject;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class gmailTest extends SingletonDriver {

    AppiumDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void open() throws MalformedURLException {
        driver = getDriver();
        driver.get("https://accounts.google.com/signin");
    }

    @Test
    public void androidGmailTest() throws MalformedURLException, InterruptedException {
        LoginBusinessObject loginBusinessObject = new LoginBusinessObject(driver);
        MailBusinessObject mailBusinessObject = new MailBusinessObject(driver);
        loginBusinessObject.loginUser("test.iryna.mail", "testmail");
        mailBusinessObject.writeMessage();
        mailBusinessObject.deleteMessage();
        Assert.assertTrue(mailBusinessObject.checkDeletedMail());
    }

    @AfterMethod
    public void closeDriver() {
        removeDriver();
    }
}
