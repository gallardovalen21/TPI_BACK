package grupo107.demo.services;

import grupo107.demo.entities.Interesado;
import grupo107.demo.entities.Prueba;
import grupo107.demo.entities.Vehiculo;
import grupo107.demo.interfaces.PruebaServices;
import grupo107.demo.repositories.EmpleadoRepository;
import grupo107.demo.repositories.InteresadoRepository;
import grupo107.demo.repositories.PruebaRepository;
import grupo107.demo.repositories.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PruebaImpl extends ServiceImpl<Prueba, Integer> implements PruebaServices {
   private final PruebaRepository pruebaRepository;
   private final InteresadoRepository interesadoRepository;
   private final VehiculoRepository vehiculoRepository;
   private final EmpleadoRepository empleadoRepository;

    @Override
    public void create(Prueba entity) {
        validarInteresado(entity.getInteresado());
        verificarDisponibilidadVehiculo(entity.getVehiculo());
        this.pruebaRepository.save(entity);
    }

    private void verificarDisponibilidadVehiculo(Vehiculo vehiculo) {
        Vehiculo vehiculo1 = vehiculoRepository.findById(vehiculo.getId())
                .orElseThrow(() -> new IllegalArgumentException("No se encontro el vehiculo con id  " + vehiculo.getId()));
        List<Prueba> pruebas = pruebaRepository.findByVehiculoId(vehiculo1.getId());
        if(!pruebas.isEmpty())
        {   throw new IllegalArgumentException("El vehiculo esta en Uso");
        }

    }

    private void validarInteresado(Interesado interesado) {
        Interesado interesado2 = interesadoRepository.findById(interesado.getId())
                .orElseThrow(() -> new IllegalArgumentException("Interesado no encontrado con ID: " + interesado.getId()));
        if(interesado2.estaRestringido()){
            throw new IllegalArgumentException("Interesado esta restringido");
        }
        if(!interesado2.tieneLicenciaAlDia()){
            throw new IllegalArgumentException(interesado2.getNombre()+" no tiene la licencia al dia");
        }
    }

    @Override
    public void update(Prueba entity) {
        this.pruebaRepository.save(entity);
    }

    @Override
    public Prueba delete(Integer id) {
        Prueba prueba = this.pruebaRepository.findById(id).orElse(null);
        this.pruebaRepository.delete(prueba);
        return prueba;
    }

    @Override
    public Prueba findById(Integer id) {
        return this.pruebaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prueba> findAll() {
        return this.pruebaRepository.findAll();
    }

    @Override
    public boolean existsById(Integer id) {
        return this.pruebaRepository.existsById(id);
    }
}
