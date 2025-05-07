package com.ferreventas.modulos.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Cliente")
public class ClienteController {
    private final ClienteService clienteService;

    //contectar service con el controlador
    @Autowired
    public ClienteController(ClienteService clienteService){

        this.clienteService = clienteService;
    }

    //utilizar los metodos de la clase
    @GetMapping
    public List<Cliente> getCliente(){
        return this.clienteService.getCliente();
    }

    //metodo guargar
    @PostMapping
    public ResponseEntity<Object> registrarCliente (@RequestBody Cliente cliente){
        return this.clienteService.newCliente(cliente);

    }

    //metodo actualizar
    @PutMapping
    public ResponseEntity<Object> actualizarCliente (@RequestBody Cliente cliente){
        return this.clienteService.newCliente(cliente);
    }

    //metodo eliminar
    @DeleteMapping(path = "{idcliente}")
    public ResponseEntity<Object> eliminarcliente (@PathVariable("idcliente") Long idcliente){
        return this.clienteService.elminarcliente(idcliente);
    }
}
