package com.ferreventas.modulos.venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/Venta")
public class VentaController {
    private final VentaService ventaService;

    //contectar service con el controlador
    @Autowired
    public VentaController(VentaService ventaService){
        this.ventaService = ventaService;
    }

    //utilizar los metodos de la clase
    @GetMapping
    public List<Venta> getVenta(){
        return this.ventaService.getVenta();
    }

    //metodo guargar
    @PostMapping
    public ResponseEntity<Object> registrarVenta (@RequestBody Venta venta){
        return this.ventaService.newVenta(venta);

    }

    //metodo actualizar
    @PutMapping
    public ResponseEntity<Object> actualizarVenta (@RequestBody Venta venta){
        return this.ventaService.newVenta(venta);
    }

    //metodo eliminar
    @DeleteMapping(path = "{idventa}")
    public ResponseEntity<Object> eliminarVenta (@PathVariable("idventa") Long idventa){
        return this.ventaService.elminarVenta(idventa);
    }
}
