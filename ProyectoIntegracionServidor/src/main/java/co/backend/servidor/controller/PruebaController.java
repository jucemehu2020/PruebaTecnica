package co.backend.servidor.controller;

import co.backend.servidor.dto.PruebaDTO;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.backend.servidor.service.PruebaManagamentService;

/**
 *
 * @author julio
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/base")
public class PruebaController {

    @Autowired
    private PruebaManagamentService service;

    @GetMapping(value = "/esPalabraPalindroma/{palabra}")
    public ResponseEntity esPalabraPalindroma(@PathVariable(value = "palabra") String palabra) {
        return new ResponseEntity(service.esPalabraPalindroma(palabra), HttpStatus.OK);
    }
    
    @GetMapping(value = "/serieFibonacci/{numero}")
    public ResponseEntity serieFibonacci(@PathVariable(value = "numero") int numero) {
        return new ResponseEntity(service.serieFibonacci(numero), HttpStatus.OK);
    }
    
    @GetMapping(value = "/esPrimo/{numero}")
    public ResponseEntity esPrimo(@PathVariable(value = "numero") int numero) {
        return new ResponseEntity(service.esPrimo(numero), HttpStatus.OK);
    }
    
    @GetMapping(value = "/multiplosHasta/{numero_multiplo}/{numero_hastas}")
    public ResponseEntity multiplosHasta(@PathVariable(value = "numero_multiplo") int numero_multiplo,@PathVariable(value = "numero_hastas") int numero_hastas) {
        return new ResponseEntity(service.multiplosHasta(numero_multiplo,numero_hastas), HttpStatus.OK);
    }
    
    @GetMapping(value = "/calcularFactorial/{numero}")
    public ResponseEntity calcularFactorial(@PathVariable(value = "numero") int numero) {
        return new ResponseEntity(service.calcularFactorial(numero), HttpStatus.OK);
    }

}
