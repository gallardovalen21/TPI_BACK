package grupo107.demo.repositories;

import grupo107.demo.entities.Empleado;
import grupo107.demo.entities.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
