package ru.netology;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.screens.MainPage;
import ru.netology.screens.NewActivityPage;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UIAutomatorAppTest {
    private AndroidDriver driver;
    MainPage screenOne;
    NewActivityPage screenTwo;
    private String textToSet = "I changed text";
    private String textNewActivity = "It's text for newActivity";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Mi9t");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", ".MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        screenOne = new MainPage(driver);
        screenTwo = new NewActivityPage(driver);
    }

    @Test
    void shouldChangeText() {
        screenOne.getInput().sendKeys(textToSet);
        screenOne.getButtonChange().click();

        String textAfter = screenOne.getTextField().getText();

        assertEquals(textToSet, textAfter);
    }

    @Test
    public void shouldInputEmptyText() {
        String textBefore = screenOne.getTextField().getText();

        screenOne.getInput().sendKeys(" ");
        screenOne.getButtonChange().click();

        String textAfter = screenOne.getTextField().getText();
        assertEquals(textBefore, textAfter);
    }

    @Test
    public void shouldOpenTextNewActivity() {
        screenOne.getInput().sendKeys(textNewActivity);
        screenOne.getNewActivityButton().click();

        String textAfter = screenTwo.getTextOnScreen().getText();

        assertEquals(textNewActivity, textAfter);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}


