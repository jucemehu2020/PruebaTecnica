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

/**
 *
 * @author julio
 */
@Service
public class PruebaManagementServiceImpl implements PruebaManagamentService {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public String esPalabraPalindroma(String palabra) {
        Date date = Date.from(Instant.now());
        PruebaDTO prueba = new PruebaDTO();
        String invertida = "";
        String resultado = "";
        prueba.setFecha(date);
        prueba.setFuncion("Funcion Palindroma");
        prueba.setVariable_ingreso1(palabra);
        for (int indice = palabra.length() - 1; indice >= 0; indice--) {
            invertida += palabra.charAt(indice);
        }
        if(palabra.equals(invertida)){                 
            resultado = "Es una palabra palindroma";
        }else{
            resultado = "No es una palabra palindroma";
        }
        prueba.setResultado(resultado);
        Map<String, Object> docData = getDocData(prueba);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection("valores").document().create(docData);
        return resultado;
    }
    
    @Override
    public ArrayList<Integer> serieFibonacci(int numero) {
        Date date = Date.from(Instant.now());
        ArrayList guardar = new ArrayList<>();
        PruebaDTO prueba = new PruebaDTO();
        prueba.setFecha(date);
        prueba.setFuncion("Funcion serie Fibonacci");
        prueba.setVariable_ingreso1(String.valueOf(numero));
 
        for (int i = 0; i <= numero; i++) {
            guardar.add(fibonacciRecursivo(i));
        }
        System.out.println(guardar);
        String str = guardar.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
        prueba.setResultado(str);
        Map<String, Object> docData = getDocData(prueba);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection("valores").document().create(docData);
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
        if (numero == 0 || numero == 1 || numero == 4) {
          return "No es primo";
        }
        for (int x = 2; x < numero / 2; x++) {
          if (numero % x == 0)
            return "No es primo";
        }
        return "Es primo";
    }
    
    @Override
    public Integer multiplosHasta(int numero_multiplo,int numero_hastas) {
        int contador = 0;
        for (int i = numero_multiplo; i <= numero_hastas; i++) {
            if (i%numero_multiplo==0) {
                contador = contador + 1;
            }
        }
        return contador;
    }
    
    @Override
    public Integer calcularFactorial(int numero) {
        int contador = 1;
        for (int i=numero;i>0;i--){
            contador=contador*i;
        }
        return contador;
    }
    
    private Map<String, Object> getDocData(PruebaDTO prueba) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("fecha", prueba.getFecha());
        docData.put("funcion", prueba.getFuncion());
        docData.put("variable_ingreso1", prueba.getVariable_ingreso1());
        docData.put("resultado", prueba.getResultado());
        return docData;
    }

    private CollectionReference getCollection(String Colecion) {
        return firebase.getFirestore().collection(Colecion);
    }
}
