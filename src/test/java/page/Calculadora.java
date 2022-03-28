package page;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.DriverContext;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    @AndroidFindBy(id = "com.android.calculator2:id/op_add")
    private AndroidElement btnSumar;

    @AndroidFindBy(id = "com.android.calculator2:id/op_sub")
    private AndroidElement btnRestar;

    @AndroidFindBy(id = "com.android.calculator2:id/op_mul")
    private AndroidElement btnMultiplicar;

    @AndroidFindBy(id = "com.android.calculator2:id/op_div")
    private AndroidElement btnDividir;

    @AndroidFindBy(id = "com.android.calculator2:id/eq")
    private AndroidElement btnIgual;

    @AndroidFindBy(id = "com.android.calculator2:id/formula")
    private AndroidElement lblResultado;

    public Calculadora(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverContext.getDriver(), Duration.ofSeconds(10)), this);
    }

    public void ingresarNumeros(String nro){
        List<String> nros = new ArrayList<>();
        for (int x = 0; x < nro.length(); x++){
            nros.add(nro.substring(x, x+1));
        }
        for (int x = 0; x < nros.size(); x++){
            DriverContext.getDriver().findElement(By.id("com.android.calculator2:id/digit_" + nros.get(x))).click();
        }
    }

    public void sumar(){
        btnSumar.click();
    }

    public void restar(){
        btnRestar.click();
    }

    public void multiplicar(){
        btnMultiplicar.click();
    }

    public void dividir(){
        btnDividir.click();
    }

    public void igual(){
        btnIgual.click();
    }

    public String obtenerResultado(){
        return lblResultado.getAttribute("text");
    }
}
