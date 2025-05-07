package com.ferreventas.modulos.direccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionService {

    HashMap<String, Object> datos;

    private final DireccionRepository direccionRepository;

    @Autowired
    public DireccionService(DireccionRepository direccionRepository){
        this.direccionRepository = direccionRepository;
    }

    public List<Direccion> getDireccion(){
        return this.direccionRepository.findAll();
    }

    public ResponseEntity<Object> newDireccion(Direccion direccion) {
        Optional<Direccion> res = direccionRepository.findDireccionBybarrio(direccion.getBarrio());
        datos= new HashMap<>();

        if (res.isPresent() && direccion.getIddireccion() == null) {
            datos.put("error", true);
            datos.put("mensaje", "ya existe un barrio con ese nombre");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        //parte de actualizar datos
        datos.put("mensaje", "se ha guardado con exito");
        if(direccion.getIddireccion() != null){
            datos.put("mensaje", "se ha actualizado con exito");
        }
        //parte de guardar dato
        direccionRepository.save(direccion);
        datos.put("data", direccion);
        //datos.put("mensaje", "se ha guardado con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    //para eliminar dato
    public ResponseEntity<Object> elminardirecion (Long iddireccion){
        datos = new HashMap<>();
        boolean existe = this.direccionRepository.existsById(iddireccion);
        if(!existe){
            datos.put("error", true);
            datos.put("mensaje", "No existe una direccion con ese nombre");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        direccionRepository.deleteById(iddireccion);
        datos.put("mensaje", "Direccion eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
