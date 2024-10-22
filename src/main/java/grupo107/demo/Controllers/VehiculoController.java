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
public class VehiculoController {

    private final PruebaRepository pruebaRepository;

    @GetMapping("/vehiculos/{id_vehiculo}/pruebas")
    public ResponseEntity<List<Prueba>> getAllPruebasVehiculo(@PathVariable int id_vehiculo) {
        List<Prueba> pruebas = pruebaRepository.findAll().stream()
                .filter(x -> (x.getVehiculo().getId())==id_vehiculo)
                .toList();
        return ResponseEntity.status(200).body(pruebas);
    }
}
