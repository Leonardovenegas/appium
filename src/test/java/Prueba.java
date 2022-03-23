import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Prueba {

    public static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        abrirCalculadora();
    }

    public static void abrirCalculadora() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "BPN0218920002072");
        desiredCapabilities.setCapability("udid", "BPN0218920002072");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("appPackage", "com.android.chrome");
        desiredCapabilities.setCapability("appActivity", "com.android.chrome.Calculator");
        URL remoteUrl = new URL("http://192.168.0.24:4444/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        System.out.println(driver.getBatteryInfo());
        driver.closeApp();
    }
}
