package com.ferreventas.modulos.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    HashMap<String, Object> datos;

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Producto> getProducto(){
        return this.productoRepository.findAll();
    }

    public ResponseEntity<Object> newProducto(Producto producto) {
        Optional<Producto> res = productoRepository.findProductoBynombreproducto(producto.getNombreproducto());
        datos= new HashMap<>();

        if (res.isPresent() && producto.getIdproducto() == null) {
            datos.put("error", true);
            datos.put("mensaje", "ya existe un producto con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        //parte de actualizar dato
        datos.put("mensaje", "se ha guardado con exito");
        if(producto.getIdproducto() != null){
            datos.put("mensaje", "se ha actualizado con exito");
        }
        //parte de guardar dato
        productoRepository.save(producto);
        datos.put("data", producto);
        //datos.put("mensaje", "se ha guardado con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    //para eliminar dato
    public ResponseEntity<Object> elminarproducto (Long idproducto){
        datos = new HashMap<>();
        boolean existe = this.productoRepository.existsById(idproducto);
        if(!existe){
            datos.put("error", true);
            datos.put("mensaje", "No existe una producto con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        productoRepository.deleteById(idproducto);
        datos.put("mensaje", "Producto eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
