package com.ferreventas.modulos.empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ferreventas.modulos.util.AppSettings;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/Empleado")
@CrossOrigin(origins = AppSettings.URL_CROOS_ORIGIN ) //conexion con el front
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    //contectar service con el controlador
    @Autowired
    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    //utilizar los metodos de la clase
    @GetMapping
    public List<Empleado> getEmpleado(){
        return this.empleadoService.getEmpleado();
    }

    //metodo guargar
    @PostMapping
    public ResponseEntity<Object> registrarEmpleado (@RequestBody Empleado empleado){
        return this.empleadoService.newEmpleado(empleado);

    }

    //metodo actualizar
    @PutMapping
    public ResponseEntity<Object> actualizarEpleado (@RequestBody Empleado empleado){
        return this.empleadoService.newEmpleado(empleado);
    }

    //metodo eliminar
    @DeleteMapping(path = "{idempleado}")
    public ResponseEntity<Object> eliminarEmpleado (@PathVariable("idempleado") Long idempleado){
        return this.empleadoService.elminarempleado(idempleado);
    }

}
