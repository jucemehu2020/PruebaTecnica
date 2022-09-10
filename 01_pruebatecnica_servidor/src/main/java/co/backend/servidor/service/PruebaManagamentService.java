package co.backend.servidor.service;

import java.util.ArrayList;

/**
 *
 * @author Julio Mellizo
 */
public interface PruebaManagamentService {

    public String esPalabraPalindroma(String palabra);
    
    public ArrayList<Integer> serieFibonacci(int numero);
    
    public String esPrimo(int numero);
    
    public Integer multiplosHasta(int numero_multiplo,int numero_hastas);
    
    public Integer calcularFactorial(int numero);
    
}
