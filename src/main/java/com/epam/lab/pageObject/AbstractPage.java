package com.epam.lab.pageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;


import java.net.MalformedURLException;

public abstract class AbstractPage {
    private AppiumDriver driver;

    public AbstractPage(AppiumDriver driver) throws MalformedURLException {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}

