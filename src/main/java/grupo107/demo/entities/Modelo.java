package grupo107.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Modelos")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_MARCA", nullable = false)
    private Marca marca;
    @Column(name="DESCRIPCION")
    private String descripcion;

}
