package co.backend.servidor.service;

import java.util.concurrent.ExecutionException;
import co.backend.servidor.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julio
 */
public interface UsuarioManagamentService {

    public String buscarCursosMatriculados();
    
    List<UsuarioDTO> list();
    UsuarioDTO listById(String id) throws ExecutionException, InterruptedException;
    Boolean add(UsuarioDTO usuario);
    Boolean edit(String id, UsuarioDTO usuario);
    Boolean delete(String id);
    
}
