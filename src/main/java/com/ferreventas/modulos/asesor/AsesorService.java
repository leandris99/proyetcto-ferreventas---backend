package com.ferreventas.modulos.asesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AsesorService {

    HashMap<String, Object> datos;

    private final AsesorRepository asesorRepository;

    @Autowired
    public AsesorService(AsesorRepository asesorRepository){
        this.asesorRepository = asesorRepository;
    }

    public List<Asesor> getAsesor(){
        return this.asesorRepository.findAll();
    }

    public ResponseEntity<Object> newAsesor(Asesor asesor) {
        Optional<Asesor> res = asesorRepository.findAsesorByidasesor(asesor.getIdasesor());
        datos= new HashMap<>();

        if (res.isPresent() && asesor.getIdasesor() == null) {
            datos.put("error", true);
            datos.put("mensaje", "ya existe una asesor con ese documento");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        //parte de actualizar dato
        datos.put("mensaje", "se ha guardado con exito");
        if(asesor.getIdasesor() != null){
            datos.put("mensaje", "se ha actualizado con exito");
        }
        //parte de guardar dato
        asesorRepository.save(asesor);
        datos.put("data", asesor);
        //datos.put("mensaje", "se ha guardado con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    //para eliminar dato
    public ResponseEntity<Object> elminarasesor (Long idasesor){
        datos = new HashMap<>();
        boolean existe = this.asesorRepository.existsById(idasesor);
        if(!existe){
            datos.put("error", true);
            datos.put("mensaje", "No existe un asesor con ese documento");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        asesorRepository.deleteById(idasesor);
        datos.put("mensaje", "Persona eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

}
