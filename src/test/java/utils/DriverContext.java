package utils;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverContext {

    private static DriverManager driverManager = new DriverManager();
    private static String tipoNavegador;
    private static String ambienteURL = "";

    public static void setUp(String propiedades, String url) throws MalformedURLException {
        setAmbienteURL(url);
        setTipoNavegador("ANDROID");
        driverManager.resolverDriver(propiedades, new URL(url));
    }

    public static AndroidDriver getDriver(){
        return driverManager.getAndroidDriver();
    }

    public static void closeDriver(){
        driverManager.closeAndroidDriver();
    }

    public static String getAmbienteURL() {
        return ambienteURL;
    }

    public static void setAmbienteURL(String ambienteURL) {
        DriverContext.ambienteURL = ambienteURL;
    }

    public static void setTipoNavegador(String tipoNavegador) {
        DriverContext.tipoNavegador = tipoNavegador;
    }

    public static String getTipoNavegador() {
        return tipoNavegador.toString();
    }
}
