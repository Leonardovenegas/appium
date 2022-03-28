package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverManager {

    private DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private AndroidDriver androidDriver;

    public void resolverDriver(String propiedades, URL url){
        desiredCapabilities.setCapability("deviceName", ReadProperties.readFromConfig(propiedades).getProperty("deviceName"));
        desiredCapabilities.setCapability("udid", ReadProperties.readFromConfig(propiedades).getProperty("udid"));
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", ReadProperties.readFromConfig(propiedades).getProperty("platformVersion"));
        desiredCapabilities.setCapability("appPackage", ReadProperties.readFromConfig(propiedades).getProperty("appPackage"));
        desiredCapabilities.setCapability("appActivity", ReadProperties.readFromConfig(propiedades).getProperty("appActivity"));
        androidDriver = new AndroidDriver(url, desiredCapabilities);
    }

    public AndroidDriver getAndroidDriver(){
        return androidDriver;
    }

    public void closeAndroidDriver(){
        androidDriver.closeApp();
    }
}
