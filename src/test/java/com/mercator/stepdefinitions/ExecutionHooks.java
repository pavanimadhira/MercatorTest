package com.mercator.stepdefinitions;

import com.mercator.factory.PageFactoryManager;
import com.mercator.factory.WebDriverFactoryManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class ExecutionHooks {

    private WebDriver driver;

    private static final MutablePicoContainer container = new DefaultPicoContainer();

    @Before
    public void setUp() {
        System.out.println("I am here");
        System.out.println("Hooks: Before scenario - Initializing WebDriver...");

        // Initialize the TestContext to ensure WebDriver is set up
        System.out.println("Initializing WebDriver in Hooks class...");
        driver = WebDriverFactoryManager.getInstance().getDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
