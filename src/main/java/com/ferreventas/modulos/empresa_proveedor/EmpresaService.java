package com.ferreventas.modulos.empresa_proveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    HashMap<String, Object> datos;

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getEmpresa(){
        return this.empresaRepository.findAll();
    }

    public ResponseEntity<Object> newEmpresa(Empresa empresa) {
        Optional<Empresa> res = empresaRepository.findEmpresaBynombre(empresa.getNombre());
        datos= new HashMap<>();

        if (res.isPresent() && empresa.getIdempresa() == null) {
            datos.put("error", true);
            datos.put("mensaje", "ya existe una empresa con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        //parte de actualizar dato
        datos.put("mensaje", "se ha guardado con exito");
        if(empresa.getIdempresa()!= null){
            datos.put("mensaje", "se ha actualizado con exito");
        }
        //parte de guardar dato
        empresaRepository.save(empresa);
        datos.put("data", empresa);
        //datos.put("mensaje", "se ha guardado con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    //para eliminar dato
    public ResponseEntity<Object> elminarEmpresa (Long idempresa){
        datos = new HashMap<>();
        boolean existe = this.empresaRepository.existsById(idempresa);
        if(!existe){
            datos.put("error", true);
            datos.put("mensaje", "No existe una persona con ese documento");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        empresaRepository.deleteById(idempresa);
        datos.put("mensaje", "Empresa eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
