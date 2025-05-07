package com.ferreventas.modulos.asesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = ("api/v1/Asesor"))
public class AsesorController {

    private final AsesorService asesorService;

    //contectar service con el controlador
    @Autowired
    public AsesorController(AsesorService asesorService){

        this.asesorService = asesorService;
    }

    //utilizar los metodos de la clase
    @GetMapping
    public List<Asesor> getAsesor () {
        return this.asesorService.getAsesor();

    }

    //metodo guargar
    @PostMapping
    public ResponseEntity<Object> registrarPersona (@RequestBody Asesor asesor){
        return this.asesorService.newAsesor(asesor);

    }

    //metodo actualizar
    @PutMapping
    public ResponseEntity<Object> actualizarPersona (@RequestBody Asesor asesor){
        return this.asesorService.newAsesor(asesor);
    }

    //metodo eliminar
    @DeleteMapping(path = "{idasesor}")
    public ResponseEntity<Object> eliminarasesor (@PathVariable("idasesor") Long idasesor){
        return this.asesorService.elminarasesor(idasesor);
    }
}
