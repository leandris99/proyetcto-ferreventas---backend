package com.ferreventas.modulos.venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    HashMap<String, Object> datos;

    private final VentaRepository ventaRepository;

    @Autowired
    public VentaService(VentaRepository ventaRepository ){
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> getVenta(){
        return this.ventaRepository.findAll();
    }

    public ResponseEntity<Object> newVenta(Venta venta) {
        Optional<Venta> res = ventaRepository.findVentaByfecha(venta.getFecha());
        datos= new HashMap<>();

        if (res.isPresent() && venta.getIdventa() == null) {
            datos.put("error", true);
            datos.put("mensaje", "ya existe una venta con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        //parte de actualizar dato
        datos.put("mensaje", "se ha guardado con exito");
        if(venta.getIdventa() != null){
            datos.put("mensaje", "se ha actualizado con exito");
        }
        //parte de guardar dato
        ventaRepository.save(venta);
        datos.put("data", venta);
        //datos.put("mensaje", "se ha guardado con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    //para eliminar dato
    public ResponseEntity<Object> elminarVenta (Long idventa){
        datos = new HashMap<>();
        boolean existe = this.ventaRepository.existsById(idventa);
        if(!existe){
            datos.put("error", true);
            datos.put("mensaje", "No existe una venta con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        ventaRepository.deleteById(idventa);
        datos.put("mensaje", "Venta eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
