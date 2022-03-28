package testClasse;

import page.Calculadora;

import java.util.Arrays;
import java.util.List;

public class OperacionesMatematicas {

    Calculadora calculadora;

    public OperacionesMatematicas(){
    }

    public void sumar(String nros){
        calculadora = new Calculadora();
        List<String> numeros = Arrays.asList(nros.split(","));
        for (int x = 0; x < numeros.size(); x++){
            calculadora.ingresarNumeros(numeros.get(x));
            calculadora.sumar();
        }
        calculadora.igual();
        System.out.println("El resultado es: " + calculadora.obtenerResultado());
    }
}
