package mx.unam.dgtic.participacion1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    private Integer matricula;
    private String nombre;
    private String apellido;
    private String correo;

}
