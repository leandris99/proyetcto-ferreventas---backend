package com.ferreventas.modulos.cliente;


import jakarta.persistence.*;

@Entity(name ="cliente")
public class Cliente {

    //VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera valor id de forma automatica
    @Column(name="idCLIENTE")
    private Long idcliente ;

    @Column(name="COMPRA")
    private int compra;

    @Column(name="PERSONAS_idPERSONAS")
    private int datoscliente;

    //constructor vacio
    public Cliente(){

    }

    //constructor sin id
    public Cliente(int compra, int datoscliente) {
        this.compra = compra;
        this.datoscliente = datoscliente;
    }

    //constructor con id
    public Cliente(Long idcliente, int compra, int datoscliente) {
        this.idcliente = idcliente;
        this.compra = compra;
        this.datoscliente = datoscliente;
    }

    //getter y setter

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public int getDatoscliente() {
        return datoscliente;
    }

    public void setDatoscliente(int datoscliente) {
        this.datoscliente = datoscliente;
    }
}
