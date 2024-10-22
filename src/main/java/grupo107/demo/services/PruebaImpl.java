package grupo107.demo.services;

import grupo107.demo.entities.*;
import grupo107.demo.interfaces.PruebaServices;
import grupo107.demo.repositories.EmpleadoRepository;
import grupo107.demo.repositories.InteresadoRepository;
import grupo107.demo.repositories.PruebaRepository;
import grupo107.demo.repositories.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PruebaImpl extends ServiceImpl<Prueba, Integer> implements PruebaServices {
   private final PruebaRepository pruebaRepository;
   private final InteresadoRepository interesadoRepository;
   private final VehiculoRepository vehiculoRepository;
   private final EmpleadoRepository empleadoRepository;
   /*https://labsys.frc.utn.edu.ar/gitlab/backend-app/alumnos/proyectos-clase/3k8/sping-service-web/-/blob/main/src/main/java/ar/edu/utnfrc/sping_service_web/services/ClientServiceImpl.java?ref_type=heads*/
   @Override
   public Prueba create(Prueba entity) {
       Integer ina = entity.getEmpleado().getLegajo();
       Optional<Empleado> em = empleadoRepository.findById(entity.getEmpleado().getLegajo());
       if (em.isEmpty()) {
           return null;
       }
       Interesado interesado2 = validarInteresado(entity.getInteresado());
       Vehiculo vehiculo = verificarDisponibilidadVehiculo(entity.getVehiculo());
       Prueba prueba = new Prueba();
       prueba.setEmpleado(em.get());
       prueba.setInteresado(interesado2);
       prueba.setVehiculo(vehiculo);

       prueba.setFechaInicio(entity.getFechaInicio());
       prueba.setFechaFin(entity.getFechaFin());
       prueba.setComentario(entity.getComentario());

       pruebaRepository.save(prueba);
       return prueba;
   }

   public ResponseEntity<Prueba> finalizar(int id, FinalizarPruebaRequest request) {
    return pruebaRepository.findById(id).map(prueba -> {
        //corroborar que fecha fin
        prueba.setFechaFin(LocalDateTime.now());
        prueba.agregarComentario(request.getComentario());
        Prueba pruebaActualizada = pruebaRepository.save(prueba);
        return ResponseEntity.ok(pruebaActualizada);
    }).orElse(ResponseEntity.notFound().build());
   }



    private Vehiculo verificarDisponibilidadVehiculo(Vehiculo vehiculo) {
        Vehiculo vehiculo1 = vehiculoRepository.findById(vehiculo.getId())
                .orElseThrow(() -> new IllegalArgumentException("No se encontro el vehiculo con id  " + vehiculo.getId()));
        List<Prueba> pruebas = pruebaRepository.findByVehiculoId(vehiculo1.getId());
        if(!pruebas.isEmpty())
        {   throw new IllegalArgumentException("El vehiculo esta en Uso");
        }
        return vehiculo1;

    }

    private Interesado validarInteresado(Interesado interesado) {
        Interesado interesado2 = interesadoRepository.findById(interesado.getId())
                .orElseThrow(() -> new IllegalArgumentException("Interesado no encontrado con ID: " + interesado.getId()));
        if(interesado2.estaRestringido()){
            throw new IllegalArgumentException("Interesado esta restringido");
        }
        if(!interesado2.tieneLicenciaAlDia()){
            throw new IllegalArgumentException(interesado2.getNombre()+" no tiene la licencia al dia");
        }
        return interesado2;
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


    public List<Prueba> obtenerPruebasCurso(){
        LocalDateTime ahora = LocalDateTime.now();
        return pruebaRepository.findByFechaInicioBeforeAndFechaFinAfter(ahora,ahora);

    }

    @Override
    public boolean existsById(Integer id) {
        return this.pruebaRepository.existsById(id);
    }
}
