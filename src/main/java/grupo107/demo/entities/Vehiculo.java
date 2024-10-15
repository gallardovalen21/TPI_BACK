package grupo107.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Vehiculos")
@Getter @Setter
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @ManyToOne
    @JoinColumn(name="ID_MODELO", nullable = false)
    private Modelo modelo;
    @Column(name="PATENTE", nullable = false)
    private String patente;
    @Column(name="ANIO")
    private int anio;


}
