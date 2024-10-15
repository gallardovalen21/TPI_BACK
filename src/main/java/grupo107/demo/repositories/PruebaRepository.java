package grupo107.demo.repositories;

import grupo107.demo.entities.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Integer> {
    List<Prueba> findByVehiculoId(int vehiculoId);
}
