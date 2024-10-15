package grupo107.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="Pruebas")
@Getter @Setter
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @OneToOne
    @JoinColumn(name = "ID_INTERESADO", nullable = false)
    private Interesado interesado;
    @ManyToOne
    @JoinColumn(name = "ID_VEHICULO", nullable = false)
    private Vehiculo vehiculo;
    @ManyToOne
    @JoinColumn(name = "ID_EMPLEADO", nullable = false)
    private Empleado empleado;
    @Column(name="FECHA_HORA_INICIO")
    private LocalDateTime fechaInicio;
    @Column(name="FECHA_HORA_FIN")
    private LocalDateTime fechaFin;
    @Size(max=500)
    @Column(length=500, name="COMENTARIOS")
    private String comentario;

}
