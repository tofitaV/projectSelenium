package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import properties.Properties;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ManagerWebDriver {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private WebDriver driver;

    int implicitWait = 10;

    public WebDriver startDriver() {
        if (threadLocalDriver.get() != null) {
            driver = threadLocalDriver.get();
            return driver;
        }

        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

        threadLocalDriver.set(driver);

        return driver;
    }

    public void stopDriver() {
        driver.quit();
        driver = null;
        threadLocalDriver.set(null);
    }

    private void setLocalDriver(DriverType driverType) {
        String browserPlatform = Properties.props.browserPlatform();
        switch (driverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", driverType.getDriverPath(browserPlatform));
                driver = new ChromeDriver(setChromeDriverOptions()
                        .addArguments("--start-maximized"));
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", driverType.getDriverPath(browserPlatform));
                driver = new FirefoxDriver(setFirefoxDriverOptions());
                driver.manage().window().maximize();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", driverType.getDriverPath(browserPlatform));
                driver = new ChromeDriver(setChromeDriverOptions());
                break;
        }
    }

    private ChromeOptions setChromeDriverOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    private FirefoxOptions setFirefoxDriverOptions() {
        FirefoxOptions options = new FirefoxOptions();
        return options;
    }

    public enum DriverType {
        CHROME("tools/chromedriver.exe", "", ""),
        FIREFOX("", "", "");

        private final String windowsPath;
        private final String linuxPath;
        private final String macPath;

        DriverType(String windowsPath, String linuxPath, String macPath) {
            this.windowsPath = windowsPath;
            this.linuxPath = linuxPath;
            this.macPath = macPath;
        }

        public String getDriverPath(String browserPlatform) {
            switch (browserPlatform) {
                case "windows":
                    return windowsPath;
                case "linux":
                    return linuxPath;
                case "mac":
                    return macPath;
                default:
                    return windowsPath;
            }
        }

    }
}
