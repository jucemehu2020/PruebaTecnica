package co.backend.servidor.dto;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Julio Mellizo
 */
@Data
public class PruebaDTO {

    private Date fecha;
    private String funcion;
    private String variable_ingreso1;
    private String variable_ingreso2;
    private String resultado;
}
