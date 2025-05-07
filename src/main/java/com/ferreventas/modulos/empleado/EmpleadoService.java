package com.ferreventas.modulos.empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    HashMap<String, Object> datos;

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> getEmpleado(){
        return this.empleadoRepository.findAll();
    }

    public ResponseEntity<Object> newEmpleado(Empleado empleado) {
        Optional<Empleado> res = empleadoRepository.findPersonaByidempleado(empleado.getIdempleado());
        datos= new HashMap<>();

        if (res.isPresent() && empleado.getIdempleado() == null) {
            datos.put("error", true);
            datos.put("mensaje", "ya existe un empleado con ese documento");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        //parte de actualizar dato
        datos.put("mensaje", "se ha guardado con exito");
        if(empleado.getIdempleado() != null){
            datos.put("mensaje", "se ha actualizado con exito");
        }
        //parte de guardar dato
        empleadoRepository.save(empleado);
        datos.put("data", empleado);
        //datos.put("mensaje", "se ha guardado con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    //para eliminar dato
    public ResponseEntity<Object> elminarempleado (Long idempleado){
        datos = new HashMap<>();
        boolean existe = this.empleadoRepository.existsById(idempleado);
        if(!existe){
            datos.put("error", true);
            datos.put("mensaje", "No existe un empleado con ese documento");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        empleadoRepository.deleteById(idempleado);
        datos.put("mensaje", "Empleado eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

}
