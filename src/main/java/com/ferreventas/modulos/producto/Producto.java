package com.ferreventas.modulos.producto;

import jakarta.persistence.*;

@Entity(name="producto")
public class Producto {
    //variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera valor id de forma automatica
    @Column(name="idPRODUCTO")
    private Long idproducto;

    @Column(name="CODIGO PRODUCTO")
    private int codigo;

    @Column(name="NOMBRE PRODUCTO")
    private String nombreproducto;

    @Column(name="CATEGORIA")
    private String categoria;

    @Column(name="MARCA")
    private String marca;

    @Column(name="PRECIO")
    private float precio;

    @Column(name="EMPRESA_PROVEEDOR_idEMPRESA_PROVEEDOR")
    private int idempresa;

    @Column(name="EXISTENCIA")
    private String existencia;

    //CONSTRUCTOR VACIO
    public Producto(){
    }

    //CONSTRUCTOR SIN ID
    public Producto(int codigo, String nombreproducto, String categoria, String marca, float precio, int idempresa, String existencia) {
        this.codigo = codigo;
        this.nombreproducto = nombreproducto;
        this.categoria = categoria;
        this.marca = marca;
        this.precio = precio;
        this.idempresa = idempresa;
        this.existencia = existencia;
    }

    //CONSTRUCTOR CON ID
    public Producto(Long idproducto, int codigo, String nombreproducto, String categoria, String marca, float precio, int idempresa, String existencia) {
        this.idproducto = idproducto;
        this.codigo = codigo;
        this.nombreproducto = nombreproducto;
        this.categoria = categoria;
        this.marca = marca;
        this.precio = precio;
        this.idempresa = idempresa;
        this.existencia = existencia;
    }


    //GETTER Y SETTER
    public Long getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }
}
