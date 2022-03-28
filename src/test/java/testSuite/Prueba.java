package testSuite;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClasse.OperacionesMatematicas;
import utils.DriverContext;

import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class Prueba {

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DriverContext.setUp( "EML L09.properties", "http://localhost:4723/wd/hub");
    }

    @AfterTest
    public void close(){
        //DriverContext.closeDriver();
    }

    @Test
    public void sumar(){
        OperacionesMatematicas operacionesMatematicas = new OperacionesMatematicas();
        operacionesMatematicas.sumar("305,908");
    }
}
