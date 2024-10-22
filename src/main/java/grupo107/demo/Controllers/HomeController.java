package grupo107.demo.Controllers;

import grupo107.demo.entities.FinalizarPruebaRequest;
import grupo107.demo.entities.Prueba;
import grupo107.demo.interfaces.PruebaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class HomeController {

    private final PruebaServices pruebaService;

    @GetMapping("/pruebas/in-course")
    public ResponseEntity<List<Prueba>> getAllPruebasEnCurso() {
        List<Prueba> pruebas = pruebaService.findAll().stream()
                .filter(x -> x.getFechaFin() == null)
                .toList();
        return ResponseEntity.status(200).body(pruebas);
    }

    @PostMapping("/pruebas")
    public ResponseEntity<Prueba> createPrueba(@RequestBody Prueba prueba) {
        Prueba nuevaPrueba = pruebaService.create(prueba);
        return ResponseEntity.status(201).body(nuevaPrueba);
    }

    @PutMapping("/pruebas/{id}/finalizar")
    public ResponseEntity<Prueba> finalizarPrueba(@PathVariable int id, @RequestBody FinalizarPruebaRequest request)
    {
       return pruebaService.finalizar(id,request);
    }


    @GetMapping("/pruebas/incidentes")
    public ResponseEntity<List<Prueba>> getAllIncidentes() {
        List<Prueba> pruebas = pruebaService.findAll().stream()
                .filter(Prueba::isIncidente)
                .toList();
        return ResponseEntity.status(200).body(pruebas);
    }

}
