package testClasse;

import page.Calculadora;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

import java.util.Arrays;
import java.util.List;

public class OperacionesMatematicas {

    Calculadora calculadora;

    public OperacionesMatematicas(){
    }

    public void sumar(String nros){
        PdfQaNovaReports.addWebReportImage("Apertura Calculadora", "Se abre la aplicacion calculadora", EstadoPrueba.DONE, false);
        calculadora = new Calculadora();
        List<String> numeros = Arrays.asList(nros.split(","));
        for (int x = 0; x < numeros.size(); x++){
            calculadora.ingresarNumeros(numeros.get(x));
            calculadora.sumar();
        }
        PdfQaNovaReports.addWebReportImage("Operacion matematica", "La operacion de suma es la siguiente.", EstadoPrueba.DONE, false);
        System.out.println("La operacion matematica es: " + calculadora.obtenerResultado().substring(0, calculadora.obtenerResultado().length() - 1));
        calculadora.igual();
        PdfQaNovaReports.addWebReportImage("Resultado", "El resultado es.", EstadoPrueba.DONE, false);
        System.out.println("El resultado es: " + calculadora.obtenerResultado());
    }
}
