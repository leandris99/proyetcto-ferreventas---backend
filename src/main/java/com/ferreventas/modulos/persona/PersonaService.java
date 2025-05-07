package com.ferreventas.modulos.persona;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    HashMap<String, Object> datos;

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository iPersonaRepository){
        this.personaRepository = iPersonaRepository;
    }

    public List<Persona> getPersona(){
        return this.personaRepository.findAll();
    }

    public ResponseEntity<Object> newPersona(Persona persona) {
        Optional<Persona> res = personaRepository.findPersonaBynombre(persona.getNombre());
        datos= new HashMap<>();

        if (res.isPresent() && persona.getIdpersona() == null) {
            datos.put("error", true);
            datos.put("mensaje", "ya existe una persona con ese documento");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        //parte de actualizar dato
        datos.put("mensaje", "se ha guardado con exito");
        if(persona.getIdpersona() != null){
            datos.put("mensaje", "se ha actualizado con exito");
        }
        //parte de guardar dato
        personaRepository.save(persona);
        datos.put("data", persona);
        //datos.put("mensaje", "se ha guardado con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
        //para eliminar dato
    public ResponseEntity<Object> elminarpersona (Long idpersona){
        datos = new HashMap<>();
        boolean existe = this.personaRepository.existsById(idpersona);
        if(!existe){
            datos.put("error", true);
            datos.put("mensaje", "No existe una persona con ese documento");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        personaRepository.deleteById(idpersona);
        datos.put("mensaje", "Persona eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
