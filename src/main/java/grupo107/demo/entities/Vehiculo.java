package grupo107.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Vehiculos")
@Getter @Setter
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @OneToMany(mappedBy = "vehiculo")
    private List<Posicion> posiciones;
    @ManyToOne
    @JoinColumn(name="ID_MODELO", nullable = false)
    private Modelo modelo;
    @Column(name="PATENTE", nullable = false)
    private String patente;
    @Column(name="ANIO")
    private int anio;


}
