package com.mercator.factory;

import com.mercator.util.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactoryManager {

    private static WebDriverFactoryManager instance = null;
    private WebDriver driver;

    private WebDriverFactoryManager() {
        createDriver();
    }

    public static synchronized WebDriverFactoryManager getInstance() {
        if (instance == null) {
            instance = new WebDriverFactoryManager();
        }
        return instance;
    }

    private void createDriver() {
        String browser = ConfigReader.getProperty("browser");
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                driver = new ChromeDriver();
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
