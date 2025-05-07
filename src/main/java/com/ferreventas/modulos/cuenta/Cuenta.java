package com.ferreventas.modulos.cuenta;

import jakarta.persistence.*;


@Entity(name="cuenta")
public class Cuenta {

    //VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera valor id de forma automatica
    @Column(name="idCUENTA")
    private Long idcuenta ;


    @Column(name="USUARIO")
    private String usuario;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="EMPLEADO_idEMPLEADO")
    private int idempleado;

    //construcor vacio
    public Cuenta() {
    }

    //constructor sin id

    public Cuenta(String usuario, int idempleado, String password) {
        this.usuario = usuario;
        this.idempleado = idempleado;
        this.password = password;
    }

    public Cuenta(Long idcuenta, String usuario, String password, int idempleado) {
        this.idcuenta = idcuenta;
        this.usuario = usuario;
        this.password = password;
        this.idempleado = idempleado;
    }

    public Long getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Long idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setcontraseña(String password) {
        this.password = password;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }
}
