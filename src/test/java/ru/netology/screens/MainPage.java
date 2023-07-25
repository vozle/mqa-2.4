package ru.netology.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "userInput")
    private MobileElement input;

    @AndroidFindBy(id = "buttonChange")
    private MobileElement buttonChange;

    @AndroidFindBy(id = "textToBeChanged")
    private MobileElement textField;

    @AndroidFindBy(id = "buttonActivity")
    private MobileElement newActivityButton;

    public MobileElement getInput() {
        return input;
    }
    public MobileElement getButtonChange() {
        return buttonChange;
    }

    public MobileElement getNewActivityButton() {
        return newActivityButton;
    }

    public MobileElement getTextField() {
        return textField;
    }

    public MainPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }


}
