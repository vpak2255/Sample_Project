package com.company.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Driver {

        private Driver() {
        }

        static String browser;

        private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

        public static WebDriver getDriver() {

            if (driverPool.get() == null) {

                System.out.println("Browser: "+System.getProperty("BROWSER"));
                if (System.getProperty("BROWSER") == null) {
                    browser = ConfigurationReader.getProperty("browser");
                } else {
                    browser = System.getProperty("BROWSER");
                }

                synchronized (Driver.class) {

                    System.out.println("'BROWSER' = " + browser.toUpperCase());
                    System.out.println("'OPERATING SYSTEM' = " + System.getProperty("os.name").toUpperCase());

                    switch (browser) {

                        case "chrome":
                            WebDriverManager.chromedriver().setup();
                            LoggingPreferences preferences = new LoggingPreferences();
                            preferences.enable(LogType.PERFORMANCE, Level.ALL);
                            ChromeOptions option = new ChromeOptions();
                            option.setCapability(CapabilityType.LOGGING_PREFS, preferences);
                            option.setCapability("goog:loggingPrefs", preferences);
                            option.addArguments();
                  //          option.addArguments("headless");
                            driverPool.set(new ChromeDriver(option));
                            driverPool.get().manage().window().maximize();
                            break;

                        case "chrome-headless":
                            ChromeOptions options = new ChromeOptions();
                            options.addArguments("headless");
                            options.addArguments("window-size=1440, 900");
                            WebDriverManager.chromedriver().setup();
                            driverPool.set(new ChromeDriver(options));
                            break;

                        case "firefox":
                            WebDriverManager.firefoxdriver().setup();
                            driverPool.set(new FirefoxDriver());
                            driverPool.get().manage().window().maximize();
                            break;

                        case "firefox-headless":
                            FirefoxOptions firefoxOptions = new FirefoxOptions();
                            firefoxOptions.setHeadless(true);
                            WebDriverManager.firefoxdriver().setup();
                            driverPool.set(new FirefoxDriver(firefoxOptions = firefoxOptions));
                            break;

                        case "safari":
                            driverPool.set(new SafariDriver());
                            driverPool.get().manage().window().maximize();
                            break;

                        default:
                            WebDriverManager.chromedriver().setup();
                            driverPool.set(new ChromeDriver());
                            driverPool.get().manage().window().maximize();
                            break;
                    }
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
            }
            return driverPool.get();

        }

        public static void closeDriver() {
            if (driverPool.get() != null) {
                driverPool.get().quit();
                driverPool.remove();
            }
        }
}
