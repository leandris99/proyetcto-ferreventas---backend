package com.ferreventas.modulos.empleado;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ferreventas.modulos.persona.Persona;
import jakarta.persistence.*;

@Entity(name="empleado")
public class Empleado {

    //VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera valor id de forma automatica
    @Column(name = "idEMPLEADO")
    private Long idempleado;

    @Column(name = "CARGO")
    private String cargo;

    @Column(name = "SALARIO")
    private Float salario;


    @Column(name = "PERSONAS_idPERSONAS")
    private int datosEmpleado;

    //CONSTRUCTOR VACIO
    public Empleado() {

    }

    //CONSTRUCTOR SIN ID


    public Empleado(String cargo, Float salario, int datosEmpleado) {
        this.cargo = cargo;
        this.salario = salario;
        this.datosEmpleado = datosEmpleado;
    }

    //CONSTRUCTOR CON ID

    public Empleado(Long idempleado, String cargo, Float salario, int datosEmpleado) {
        this.idempleado = idempleado;
        this.cargo = cargo;
        this.salario = salario;
        this.datosEmpleado = datosEmpleado;
    }


    //SETTER Y GETTER


    public Long getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Long idempleado) {
        this.idempleado = idempleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public int getDatosEmpleado() {
        return datosEmpleado;
    }

    public void setDatosEmpleado(int datosEmpleado) {
        this.datosEmpleado = datosEmpleado;
    }
}