package com.epam.lab;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SingletonDriver {

    private AppiumDriver driver;

    private void InitDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "GoogleNexus5X");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, capabilities);

    }

    public AppiumDriver getDriver() throws MalformedURLException {
        InitDriver();
        return driver;
    }

    public void removeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}

