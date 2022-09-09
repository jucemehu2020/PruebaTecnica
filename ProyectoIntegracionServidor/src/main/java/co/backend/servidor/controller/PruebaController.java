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

     @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity edit(@PathVariable(value = "id") String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity(service.listById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody PruebaDTO usuario) {
        return new ResponseEntity(service.add(usuario), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody PruebaDTO usuario){
        return new ResponseEntity(service.edit(id,usuario), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
    

}
