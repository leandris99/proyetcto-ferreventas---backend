package com.ferreventas.modulos.persona;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ferreventas.modulos.direccion.Direccion;
import jakarta.persistence.*;

@Entity(name = "personas")
public class Persona {

    //variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera valor id de forma automatica
    @Column(name="idPERSONAS")
    private Long idpersona ;

    @Column(name="IDENTIFICACION")
    private int identificacion;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="CORREO")
    private String correo;

    @Column(name="TELEFONO")
    private int telefono;

    /*@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToOne(fetch = FetchType.LAZY)*/
    @Column(name="DIRECCION_idDIRECCION")
    private int direccion;


    //constructor vacio
    public Persona() {
    }

    //constructor con id

    public Persona(Long idpersona, int identificacion, String nombre, String correo, int telefono, int direccion) {
        this.idpersona = idpersona;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }


    //constructor sin id
    public Persona(int identificacion, String nombre, String correo, int telefono, int direccion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }


    //Getter setter Setter

    public Long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
}
