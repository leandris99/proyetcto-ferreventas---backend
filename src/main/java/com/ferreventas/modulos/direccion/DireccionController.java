package com.ferreventas.modulos.direccion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Direccion")
public class DireccionController {
    private final DireccionService direccionService;

    //contectar service con el controlador
    @Autowired
    public DireccionController(DireccionService direccionService){

        this.direccionService = direccionService;
    }

    //utilizar los metodos de la clase
    @GetMapping
    public List<Direccion> getDireccion(){
        return this.direccionService.getDireccion();
    }

    //metodo guargar
    @PostMapping
    public ResponseEntity<Object> registrarDireccion (@RequestBody Direccion direccion){
        return this.direccionService.newDireccion(direccion);

    }

    //metodo actualizar
    @PutMapping
    public ResponseEntity<Object> actualizarDireccion (@RequestBody Direccion direccion){
        return this.direccionService.newDireccion(direccion);
    }

    //metodo eliminar
    @DeleteMapping(path = "{iddireccion}")
    public ResponseEntity<Object> eliminarpersona (@PathVariable("iddireccion") Long iddireccion){
        return this.direccionService.elminardirecion(iddireccion);
    }
}
