package grupo107.demo.repositories;

import grupo107.demo.entities.Interesado;
import grupo107.demo.entities.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresadoRepository extends JpaRepository<Interesado, Integer> {
}
