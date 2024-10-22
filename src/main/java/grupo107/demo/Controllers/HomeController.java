package grupo107.demo.Controllers;

import grupo107.demo.entities.FinalizarPruebaRequest;
import grupo107.demo.entities.Prueba;
import grupo107.demo.interfaces.PruebaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car-rental/")
@RequiredArgsConstructor
public class HomeController {

    private final PruebaServices pruebaService;

    @GetMapping("/pruebas")
    public ResponseEntity<List<Prueba>> getAllPruebas() {
        List<Prueba> pruebas = pruebaService.findAll();
        return ResponseEntity.ok(pruebas);
    }

    @PostMapping
    public ResponseEntity<Prueba> createPrueba(@RequestBody Prueba prueba) {
        Prueba nuevaPrueba = pruebaService.create(prueba);
        return ResponseEntity.status(201).body(nuevaPrueba);
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Prueba> finalizarPrueba(@PathVariable int id, @RequestBody FinalizarPruebaRequest request)
    {
       return pruebaService.finalizar(id,request);
    }


}
