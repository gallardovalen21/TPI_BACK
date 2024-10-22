package grupo107.demo.Controllers;


import grupo107.demo.entities.Interesado;
import grupo107.demo.repositories.InteresadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interesado")
@RequiredArgsConstructor
public class InteresadoController {

    private final InteresadoRepository interesadoRepository;

    // Obtener todos los interesados
    @GetMapping
    public List<Interesado> getAllInteresados() {
        return interesadoRepository.findAll();
    }

    // Obtener un interesado por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Interesado> getInteresadoById(@PathVariable Integer id) {
        return interesadoRepository.findById(id)
                .map(interesado -> ResponseEntity.ok().body(interesado))
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo interesado
    @PostMapping
    public Interesado createInteresado(@RequestBody Interesado interesado) {
        return interesadoRepository.save(interesado);
    }
/*
    // Actualizar un interesado por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Interesado> updateInteresado(@PathVariable Integer id, @RequestBody Interesado interesadoDetails) {
        return interesadoRepository.findById(id)
                .map(interesado -> {
                    interesado.setNombre(interesadoDetails.getNombre()); // Ejemplo, ajusta según atributos
                    interesado.setLicencia(interesadoDetails.getLicencia());

                    // actualiza otros atributos necesarios
                    Interesado updatedInteresado = interesadoRepository.save(interesado);
                    return ResponseEntity.ok().body(updatedInteresado);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteresado(@PathVariable Integer id) {
        return interesadoRepository.findById(id)
                .map(interesado -> {
                    interesadoRepository.delete(interesado);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }*/
}

