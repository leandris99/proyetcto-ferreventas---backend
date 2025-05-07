package com.ferreventas.modulos.direccion;

import jakarta.persistence.*;

@Entity(name="direccion")
public class Direccion {

    //VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera valor id de forma automatica
    @Column(name="idDIRECCION")
    private Long iddireccion;

    @Column(name="BARRIO")
    private String barrio;

    @Column(name="MANZANA")
    private int manzana;

    @Column(name="LOTE")
    private int lote;

    //CONSTRUCTOR VACIO
    public Direccion(){

    }

    //CONSTRUCTOR SIN ID

    public Direccion(String barrio, int manzana, int lote) {
        this.barrio = barrio;
        this.manzana = manzana;
        this.lote = lote;
    }

    //CONSTRUCTOR CON ID

    public Direccion(Long iddireccion, String barrio, int manzana, int lote) {
        this.iddireccion = iddireccion;
        this.barrio = barrio;
        this.manzana = manzana;
        this.lote = lote;
    }

    //GETTER Y SETTER

    public Long getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Long iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public int getManzana() {
        return manzana;
    }

    public void setManzana(int manzana) {
        this.manzana = manzana;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }
}
