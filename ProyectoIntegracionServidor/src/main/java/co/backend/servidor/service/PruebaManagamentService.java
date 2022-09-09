package co.backend.servidor.service;

import java.util.concurrent.ExecutionException;
import co.backend.servidor.dto.PruebaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julio
 */
public interface PruebaManagamentService {

    public String esPalabraPalindroma(String palabra);
    
    List<PruebaDTO> list();
    PruebaDTO listById(String id) throws ExecutionException, InterruptedException;
    Boolean add(PruebaDTO usuario);
    Boolean edit(String id, PruebaDTO usuario);
    Boolean delete(String id);
    
}
