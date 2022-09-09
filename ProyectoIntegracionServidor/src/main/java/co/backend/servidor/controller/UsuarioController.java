package co.backend.servidor.controller;

import co.backend.servidor.dto.UsuarioDTO;
import co.backend.servidor.service.UsuarioManagamentService;
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

/**
 *
 * @author julio
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/base")
public class UsuarioController {

    @Autowired
    private UsuarioManagamentService service;

    @GetMapping(value = "/buscarCursosMatriculados")
    public ResponseEntity buscarCursosMatriculados() {
        return new ResponseEntity(service.buscarCursosMatriculados(), HttpStatus.OK);
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
    public ResponseEntity add(@RequestBody UsuarioDTO usuario) {
        return new ResponseEntity(service.add(usuario), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody UsuarioDTO usuario){
        return new ResponseEntity(service.edit(id,usuario), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
    

}
