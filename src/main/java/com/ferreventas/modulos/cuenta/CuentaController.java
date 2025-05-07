package com.ferreventas.modulos.cuenta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    //contectar service con el controlador
    @Autowired
    public CuentaController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }

    //utilizar los metodos de la clase
    @GetMapping
    public List<Cuenta> getCuenta(){
        return this.cuentaService.getCuenta();
    }

    //metodo guargar
    @PostMapping
    public ResponseEntity<Object> registrarCuenta (@RequestBody Cuenta cuenta){
        return this.cuentaService.newCuenta(cuenta);

    }

    //metodo actualizar
    @PutMapping
    public ResponseEntity<Object> actualizarCuenta (@RequestBody Cuenta cuenta){
        return this.cuentaService.newCuenta(cuenta);
    }

    //metodo eliminar
    @DeleteMapping(path = "{idcuenta}")
    public ResponseEntity<Object> eliminarcuenta (@PathVariable("idcuenta") Long idcuenta){
        return this.cuentaService.elminarcuenta(idcuenta);
    }
}
