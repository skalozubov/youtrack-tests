package com.jetbrains.youtrack.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver = null;

    public WebDriver getWebDriver(String browser) {
        if (driver != null) {
            return driver;
        }
        switch (browser.toUpperCase()) {
            case "CHROME":
                return getChromeWebDriver();
            case "FIREFOX":
                return getFirefoxWebDriver();
            case "MOBILE":
                return getMobileChromeWebDriver();
            default:
                return getFirefoxWebDriver();
        }
    }

    public void killDriver() {
        driver.quit();
        driver = null;
    }

    private WebDriver getChromeWebDriver() {
        System.out.println("Creating CHROME web driver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        String driverLocation;
        if (isWindows()) {
            driverLocation = WebDriverManager.class.getClassLoader().getResource("webdrivers/chromedriver.exe").getPath();
        } else {
            /* Since this driver uses the wire protocol we need to find the correct driver depending on the environment */
            driverLocation = WebDriverManager.class.getClassLoader().getResource("webdrivers/chromedriver_" + getOsId()).getPath();
        }
        System.setProperty("webdriver.chrome.driver", driverLocation);

        capabilities.setCapability("ACCEPT_SSL_CERTS", true);
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver getMobileChromeWebDriver() {
        String driverLocation;
        if (isWindows()) {
            driverLocation = WebDriverManager.class.getClassLoader().getResource("webdrivers/chromedriver.exe").getPath();
        } else {
            /* Since this driver uses the wire protocol we need to find the correct driver depending on the environment */
            driverLocation = WebDriverManager.class.getClassLoader().getResource("webdrivers/chromedriver_" + getOsId()).getPath();
        }
        System.setProperty("webdriver.chrome.driver", driverLocation);

        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Google Nexus 5");

        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability("ACCEPT_SSL_CERTS", true);
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver getFirefoxWebDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOADING_STRATEGY, "eager");
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private static String getOsId() {
        String osname = System.getProperty("os.name").toLowerCase();
        if (osname.contains("win")) {
            return "win";
        }
        if (osname.contains("mac")) {
            return "mac";
        }
        if (osname.contains("linux")) {
            return "linux";
        }
        return null;
    }

    private boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}
