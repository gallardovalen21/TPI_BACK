package grupo107.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Posiciones")
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(mappedBy = "id")
    private Vehiculo id_vehiculo;
    @Column(name="FECHA_HORA")
    private LocalDateTime fecha_hora;
    @Column(name="LATITUD")
    private float latitud;
    @Column(name="LONGITUD")
    private float longitud;
}
