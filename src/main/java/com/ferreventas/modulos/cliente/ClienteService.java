package com.ferreventas.modulos.cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    HashMap<String, Object> datos;

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getCliente(){
        return this.clienteRepository.findAll();
    }

    public ResponseEntity<Object> newCliente(Cliente cliente) {
        Optional<Cliente> res = clienteRepository.findClienteByidcliente(cliente.getIdcliente());
        datos= new HashMap<>();

        if (res.isPresent() && cliente.getIdcliente() == null) {
            datos.put("error", true);
            datos.put("mensaje", "ya existe una persona con ese documento");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        //parte de actualizar dato
        datos.put("mensaje", "se ha guardado con exito");
        if(cliente.getIdcliente() != null){
            datos.put("mensaje", "se ha actualizado con exito");
        }
        //parte de guardar dato
        clienteRepository.save(cliente);
        datos.put("data", cliente);
        //datos.put("mensaje", "se ha guardado con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    //para eliminar dato
    public ResponseEntity<Object> elminarcliente (Long idcliente){
        datos = new HashMap<>();
        boolean existe = this.clienteRepository.existsById(idcliente);
        if(!existe){
            datos.put("error", true);
            datos.put("mensaje", "No existe una persona con ese documento");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        clienteRepository.deleteById(idcliente);
        datos.put("mensaje", "Persona eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
