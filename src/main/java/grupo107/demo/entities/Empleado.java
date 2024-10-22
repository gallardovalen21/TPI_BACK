package grupo107.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Empleados")
@Getter @Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LEGAJO", nullable = false)
    private int legajo;
    @Size(max=30)
    @Column(name="NOMBRE", nullable = false)
    private String nombre;
    @Size(max=50)
    @Column(name="APELLIDO", nullable=false)
    private String apellido;
    @Column(name="TELEFONO_CONTACTO", nullable = false)
    private String telefonoContacto;



}
