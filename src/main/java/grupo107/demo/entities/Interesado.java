package grupo107.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="Interesados")
@Getter
@Setter
public class Interesado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 3)
    @Column(name="TIPO_DOCUMENTO")
    private String tipoDoc;
    @Size(max = 10)
    @Column(name="DOCUMENTO")
    private String documento;
    @Size(max = 50)
    @Column(name="NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name="APELLIDO")
    private String apellido;
    @Column(name="RESTRINGIDO")
    private boolean restringido;
    @Column(name="NRO_LICENCIA", unique = true)
    private Integer nroLicencia;
    @Column(name="FECHA_VENICIMIENTO_LICENCIA")
    private LocalDateTime fechaVencimientoLicencia;

    public boolean estaRestringido() {
        return restringido;
    }
    public boolean tieneLicenciaAlDia() {
        return LocalDateTime.now().isBefore(fechaVencimientoLicencia);
    }

}
