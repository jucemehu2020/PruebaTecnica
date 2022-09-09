package co.backend.servidor.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author 
 */
@Data
public class PruebaDTO {

    private String id;
    private Integer idUsuario;
    private String correo;
    private String rol;
    private String nombre_completo;
    private ArrayList<String> cursos;
    private Integer estado;
}
