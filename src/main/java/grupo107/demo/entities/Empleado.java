package grupo107.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LEGAJO")
    private int legajo;
    @Size(max=30)
    @Column(name="NOMBRE")
    private String nombre;
    @Size(max=50)
    @Column(name="APELLIDO")
    private String apellido;
    @Column(name="TELEFONO_CONTACTO")
    private double telefonoContacto;



}
