package com.ferreventas.modulos.empresa_proveedor;

/*import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;*/

import jakarta.persistence.*;

@Entity(name="empresa_proveedor")
public class Empresa {

    //VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera valor id de forma automatica
    @Column(name="idEMPRESA_PROVEEDOR")
    private Long idempresa;

    @Column(name="NIT")
    private String nit;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="TELEFONO")
    private String telefono;

    @Column(name="DIRECCION_idDIRECCION")
    private int direccion;

    //CONSTRUCTOR VACIO
     public Empresa(){

     }

    //CONSTRUCTOR SIN ID
    public Empresa(String nit, String nombre, String telefono, int direccion) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    //CONSTRUCTOR CON ID
    public Empresa(Long idempresa, String nit, String nombre, String telefono, int direccion) {
        this.idempresa = idempresa;
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    //GETTER Y SETTER

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
}
