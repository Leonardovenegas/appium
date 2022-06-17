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
        int suma = 0;
        String calculo = "";
        List<String> numeros = Arrays.asList(nros.split(","));
        for (int x = 0; x < numeros.size(); x++){
            calculadora.ingresarNumeros(numeros.get(x));
            PdfQaNovaReports.addWebReportImage("Ingreso numero "+(x+1), "Se ingresa numero " + (x+1) + ", el cual es " + numeros.get(x), EstadoPrueba.DONE, false);
            calculo = calculo + numeros.get(x).replace(".", "") + "+";
            suma = suma + Integer.parseInt(numeros.get(x));
            calculadora.sumar();
        }
        calculo = calculo.substring(0, calculo.length() - 1);
        String calculoTelefono = calculadora.obtenerResultado().replace(".", "");
        calculoTelefono = calculoTelefono.substring(0, calculoTelefono.length() - 1);
        if (calculo.equals(calculoTelefono)){
            PdfQaNovaReports.addWebReportImage("Operacion matematica.", "La operacion matematica ingresada es igual a la entregada, " + calculo, EstadoPrueba.PASSED, false);
        } else {
            PdfQaNovaReports.addWebReportImage("Operacion matematica.", "La operacion matematica ingresada es diferente a la entregada, operacion entregada " + calculo + ", operacion ingresada " + calculoTelefono, EstadoPrueba.FAILED, false);
        }
        System.out.println("La operacion matematica es: " + calculoTelefono);
        calculadora.igual();
        int sumaTelefono = Integer.parseInt(calculadora.obtenerResultado().replace(".", ""));
        if (sumaTelefono == suma){
            PdfQaNovaReports.addWebReportImage("Resultado.", "El resultado es el correcto, " + suma, EstadoPrueba.PASSED, false);
        } else {
            PdfQaNovaReports.addWebReportImage("Resultado.", "El resultado es incorrecto, resultado " + suma + ", resultado calculadora " + sumaTelefono, EstadoPrueba.FAILED, false);
        }
        System.out.println("El resultado es: " + sumaTelefono);
    }
}
