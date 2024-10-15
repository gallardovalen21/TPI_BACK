package grupo107.demo.repositories;

import grupo107.demo.entities.Prueba;
import grupo107.demo.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}
