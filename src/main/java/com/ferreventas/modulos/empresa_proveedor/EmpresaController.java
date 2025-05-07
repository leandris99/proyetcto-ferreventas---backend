package com.ferreventas.modulos.empresa_proveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    //contectar service con el controlador
    @Autowired
    public EmpresaController(EmpresaService empresaService){
        this.empresaService= empresaService;
    }

    //utilizar los metodos de la clase
    @GetMapping
    public List<Empresa> getEmpresa(){
        return this.empresaService.getEmpresa();
    }

    //metodo guargar
    @PostMapping
    public ResponseEntity<Object> registrarEmpresa (@RequestBody Empresa empresa){
        return this.empresaService.newEmpresa(empresa);

    }

    //metodo actualizar
    @PutMapping
    public ResponseEntity<Object> actualizarEmpresa (@RequestBody Empresa empresa){
        return this.empresaService.newEmpresa(empresa);
    }

    //metodo eliminar
    @DeleteMapping(path = "{idempresa}")
    public ResponseEntity<Object> eliminarEmpresa (@PathVariable("idempresa") Long idempresa){
        return this.empresaService.elminarEmpresa(idempresa);
    }
}
