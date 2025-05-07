package com.ferreventas.modulos.producto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Producto")
public class ProductoController {
    private final ProductoService productoService;

    //contectar service con el controlador
    @Autowired
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    //utilizar los metodos de la clase
    @GetMapping
    public List<Producto> getProducto(){
        return this.productoService.getProducto();
    }

    //metodo guargar
    @PostMapping
    public ResponseEntity<Object> registrarproducto (@RequestBody Producto producto){
        return this.productoService.newProducto(producto);

    }

    //metodo actualizar
    @PutMapping
    public ResponseEntity<Object> actualizarProducto (@RequestBody Producto producto){
        return this.productoService.newProducto(producto);
    }

    //metodo eliminar
    @DeleteMapping(path = "{idproducto}")
    public ResponseEntity<Object> eliminarEmpresa (@PathVariable("idproducto") Long idproducto){
        return this.productoService.elminarproducto(idproducto);
    }
}
