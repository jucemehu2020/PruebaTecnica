package co.backend.servidor.serviceImpl;

import co.backend.servidor.dto.PruebaDTO;
import co.backend.servidor.firebase.FirebaseInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.backend.servidor.service.PruebaManagamentService;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.time.Instant;
import java.math.BigInteger;

/**
 *
 * @author julio
 */
@Service
public class PruebaManagementServiceImpl implements PruebaManagamentService {

    private PruebaDTO prueba = new PruebaDTO();
    private String resultado = "";
    
    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public String esPalabraPalindroma(String palabra) {
        String invertida = "";
        prueba.setFuncion("Funcion Palindroma");
        prueba.setVariable_ingreso1(palabra);
        String estandarPalabra = palabra.toLowerCase();
        for (int indice = estandarPalabra.length() - 1; indice >= 0; indice--) {
            invertida += estandarPalabra.charAt(indice);
        }
        if(estandarPalabra.equals(invertida)){                 
            resultado = "Es una palabra palindroma";
        }else{
            resultado = "No es una palabra palindroma";
        }
        prueba.setResultado(resultado);
        registrarEnBD(prueba);
        return resultado;
    }
    
    @Override
    public ArrayList<Integer> serieFibonacci(int numero) {
        ArrayList guardar = new ArrayList<>();
        prueba.setFuncion("Funcion serie Fibonacci");
        prueba.setVariable_ingreso1(String.valueOf(numero));

        for (int i = 0; i <= numero; i++) {
            guardar.add(fibonacciRecursivo(i));
        }
        
        String str = guardar.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
        prueba.setResultado(str);
        registrarEnBD(prueba);
        return guardar;
    }
    
    public static int fibonacciRecursivo(int n) {
        if (n==0){
            return 0;  
        } else if(n==1) {
            return 1;
        } else {
            return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
        }
    }
     
    @Override
    public String esPrimo(int numero) {  
        int bandera = 0;
        prueba.setFuncion("Funcion si numero es primo");
        prueba.setVariable_ingreso1(String.valueOf(numero));
        if (numero == 0 || numero == 1 || numero == 4) {
            resultado = "No es primo";
            bandera = 1;
        }
        for (int x = 2; x < numero / 2; x++) {
          if (numero % x == 0){
              resultado = "No es primo";
              bandera = 1;
          }
        }
        if(bandera == 0){
            resultado = "Es primo";
        }
        prueba.setResultado(resultado);
        registrarEnBD(prueba);
        return resultado;
    }
    
    @Override
    public Integer multiplosHasta(int numero_multiplo,int numero_hastas) {
        int contador = 0;
        prueba.setFuncion("Funcion contar multiplos");
        prueba.setVariable_ingreso1(String.valueOf(numero_multiplo));
        prueba.setVariable_ingreso2(String.valueOf(numero_hastas));
        for (int i = numero_multiplo; i <= numero_hastas; i++) {
            if (i%numero_multiplo==0) {
                contador = contador + 1;
            }
        }
        prueba.setResultado(String.valueOf(contador));
        registrarEnBD(prueba);
         if(prueba.getVariable_ingreso2()!=null){
            prueba.setVariable_ingreso2(null);
        }
        return contador;
    }
    
    @Override
    public Integer calcularFactorial(int numero) {
        Integer contador = 1;
        prueba.setFuncion("Funcion calcular factorial");
        prueba.setVariable_ingreso1(String.valueOf(numero));
        for (int i=2;i<=numero;i++){
            contador=contador*i;
        }
        prueba.setResultado(String.valueOf(contador));
        registrarEnBD(prueba);
        return contador;
    }
    
    private Map<String, Object> getDocData(PruebaDTO prueba) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("fecha", prueba.getFecha());
        docData.put("funcion", prueba.getFuncion());
        docData.put("variable_ingreso1", prueba.getVariable_ingreso1());
        if(prueba.getVariable_ingreso2()!=null){
            docData.put("variable_ingreso2", prueba.getVariable_ingreso2());
        }
        docData.put("resultado", prueba.getResultado());
        return docData;
    }

    private CollectionReference getCollection(String Colecion) {
        return firebase.getFirestore().collection(Colecion);
    }
    
    private void registrarEnBD(PruebaDTO prueba){
        Date date = Date.from(Instant.now());
        prueba.setFecha(date);
        Map<String, Object> docData = getDocData(prueba);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection("valores").document().create(docData);
    }
}
