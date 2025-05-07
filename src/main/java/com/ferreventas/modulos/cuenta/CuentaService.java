package com.ferreventas.modulos.cuenta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    HashMap<String, Object> datos;

    private final CuentaRepository cuentaRepository;

    @Autowired
    public CuentaService(CuentaRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }

    public List<Cuenta> getCuenta(){
        return this.cuentaRepository.findAll();
    }

    public ResponseEntity<Object> newCuenta(Cuenta cuenta) {
        Optional<Cuenta> res = cuentaRepository.findCuentaByidcuenta(cuenta.getIdcuenta());
        datos= new HashMap<>();

        if (res.isPresent() && cuenta.getIdcuenta() == null) {
            datos.put("error", true);
            datos.put("mensaje", "ya existe una cuenta con ese usuario");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        //parte de actualizar dato
        datos.put("mensaje", "se ha guardado con exito");
        if(cuenta.getIdcuenta() != null){
            datos.put("mensaje", "se ha actualizado con exito");
        }
        //parte de guardar dato
        cuentaRepository.save(cuenta);
        datos.put("data", cuenta);
        //datos.put("mensaje", "se ha guardado con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    //para eliminar dato
    public ResponseEntity<Object> elminarcuenta (Long idcuenta){
        datos = new HashMap<>();
        boolean existe = this.cuentaRepository.existsById(idcuenta);
        if(!existe){
            datos.put("error", true);
            datos.put("mensaje", "No existe una cuenta con ese usuario");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        cuentaRepository.deleteById(idcuenta);
        datos.put("mensaje", "cuenta eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
