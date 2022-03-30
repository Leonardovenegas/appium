package testSuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClasse.OperacionesMatematicas;
import utils.DriverContext;
import utils.Reporte.PdfQaNovaReports;

import java.net.MalformedURLException;

public class Prueba {

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DriverContext.setUp( "EML L09.properties", "http://localhost:4723/wd/hub");
        PdfQaNovaReports.createPDF();
    }

    @AfterTest
    public void close(){
        //DriverContext.closeDriver();
    }

    @Test
    public void sumar(){
        OperacionesMatematicas operacionesMatematicas = new OperacionesMatematicas();
        operacionesMatematicas.sumar("305,908,1506");
        PdfQaNovaReports.closePDF();
    }
}
