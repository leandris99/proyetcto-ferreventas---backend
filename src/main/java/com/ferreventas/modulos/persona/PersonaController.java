package com.ferreventas.modulos.persona;

import com.ferreventas.modulos.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = AppSettings.URL_CROOS_ORIGIN )
@RequestMapping(path = "api/v1/Persona")
public class PersonaController {

    private final PersonaService personaService;

    //contectar service con el controlador
    @Autowired
    public PersonaController(PersonaService personaService){

        this.personaService = personaService;
    }

    //utilizar los metodos de la clase
    @GetMapping
    public List<Persona> getPersona(){
        return this.personaService.getPersona();
    }

    //metodo guargar
    @PostMapping
    public ResponseEntity<Object> registrarPersona (@RequestBody Persona persona){
        return this.personaService.newPersona(persona);

    }

    //metodo actualizar
    @PutMapping
    public ResponseEntity<Object> actualizarPersona (@RequestBody Persona persona){
        return this.personaService.newPersona(persona);
    }

    //metodo eliminar
    @DeleteMapping(path = "{idpersona}")
    public ResponseEntity<Object> eliminarpersona (@PathVariable("idpersona") Long idpersona){
        return this.personaService.elminarpersona(idpersona);
    }

}
