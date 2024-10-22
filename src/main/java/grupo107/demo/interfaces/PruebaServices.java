package grupo107.demo.interfaces;

import grupo107.demo.entities.FinalizarPruebaRequest;
import grupo107.demo.entities.Prueba;
import grupo107.demo.entities.Vehiculo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PruebaServices extends Service<Prueba,Integer> {

    ResponseEntity<Prueba> finalizar(int id, FinalizarPruebaRequest request);
}
