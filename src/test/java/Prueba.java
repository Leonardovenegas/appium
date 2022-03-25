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
        desiredCapabilities.setCapability("deviceName", "EML L09");
        desiredCapabilities.setCapability("udid", "BPN0218920002072");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //System.out.println(driver.getBatteryInfo());
        //driver.closeApp();
    }
}
