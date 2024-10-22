package grupo107.demo.repositories;

import grupo107.demo.entities.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
/*https://labsys.frc.utn.edu.ar/gitlab/backend-app/alumnos/proyectos-clase/3k8/sping-service-web/-/blob/main/src/main/java/ar/edu/utnfrc/sping_service_web/services/ClientServiceImpl.java?ref_type=heads*/
@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Integer> {
    List<Prueba> findByVehiculoId(int vehiculoId);

    List<Prueba> findByFechaInicioBeforeAndFechaFinAfter(LocalDateTime now,LocalDateTime now2);
}
