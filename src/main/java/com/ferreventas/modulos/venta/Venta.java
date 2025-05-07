package com.ferreventas.modulos.venta;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity(name="VENTA")
public class Venta {

    //VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera valor id de forma automatica
    @Column(name="idVENTA")
    private Long idventa;

    @Column(name="CODIGO_VENTA")
    private int codigo;
    @Column(name="FECHA")
    private LocalDate fecha;
    @Column(name="CANTIDAD")
    private int catidad;
    @Column(name="PRECIO")
    private float precio;
    @Column(name="EMPLEADO_idEMPLEADO")
    private int idempleado;
    @Column(name="CLIENTE_idCLIENTE")
    private int idcliente;

    //CONSTRUCTOR VACIO
    public Venta(){
    }

    //CONSTRUCTOR SIN ID
    public Venta(int codigo, LocalDate fecha, int catidad, float precio, int idempleado, int idcliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.catidad = catidad;
        this.precio = precio;
        this.idempleado = idempleado;
        this.idcliente = idcliente;
    }

    //CONSTRUCTOR CON ID
    public Venta(Long idventa, int codigo, LocalDate fecha, int catidad, float precio, int idempleado, int idcliente) {
        this.idventa = idventa;
        this.codigo = codigo;
        this.fecha = fecha;
        this.catidad = catidad;
        this.precio = precio;
        this.idempleado = idempleado;
        this.idcliente = idcliente;
    }

    //GETTER Y SETTER
    public Long getIdventa() {
        return idventa;
    }

    public void setIdventa(Long idventa) {
        this.idventa = idventa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }


}
