package co.backend.servidor.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author 
 */
@Data
public class PruebaDTO {

    private Date fecha;
    private String funcion;
    private String variable_ingreso1;
    private String variable_ingreso2;
    private String resultado;
}
