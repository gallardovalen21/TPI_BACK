package grupo107.demo.Controllers;

import grupo107.demo.entities.Prueba;
import grupo107.demo.repositories.PruebaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class EmpleadoController {

    private final PruebaRepository pruebaRepository;

    @GetMapping("/empleados/{id_empleado}/incidentes")
    public ResponseEntity<List<Prueba>> getAllIncidentes_empleado(@PathVariable int id_empleado) {
        List<Prueba> pruebas = pruebaRepository.findAll().stream()
                .filter(x -> (x.getEmpleado().getLegajo())==id_empleado && x.isIncidente())
                .toList();
        return ResponseEntity.status(200).body(pruebas);
    }
}
