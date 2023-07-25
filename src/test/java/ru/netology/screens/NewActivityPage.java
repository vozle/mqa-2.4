package ru.netology.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class NewActivityPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "text")
    private MobileElement textOnScreen;

    public MobileElement getTextOnScreen() {
        return textOnScreen;
    }

    public NewActivityPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}
