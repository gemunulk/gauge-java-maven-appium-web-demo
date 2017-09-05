package utils;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }


    @BeforeSuite
    public void Setup() throws MalformedURLException {

        // Get Appium Properties
        String browser_name = System.getenv("BROWSER_NAME");
        String platform_name = System.getenv("PLATFORM_NAME");
        String platform_version = System.getenv("PLATFORM_VERSION");
        String new_command_timeout = System.getenv("NEW_COMMAND_TIMEOUT");
        String device_name = System.getenv("DEVICE_NAME");
        String appium_host_url = System.getenv("APPIUM_HOST_URL");

        // Set desiredCapabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser_name);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, new_command_timeout);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
        URL url = new URL(appium_host_url);

        driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void TearDown() {
        driver.close();
        driver.quit();
    }
}
