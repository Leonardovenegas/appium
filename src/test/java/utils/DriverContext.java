package utils;

import com.google.gson.JsonObject;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverContext {

    private static DriverManager driverManager = new DriverManager();

    public static void setUp(String propiedades, String url) throws MalformedURLException {
        driverManager.resolverDriver(propiedades, new URL(url));
    }

    public static AndroidDriver getDriver(){
        return driverManager.getAndroidDriver();
    }

    public static void closeDriver(){
        driverManager.closeAndroidDriver();
    }
}
