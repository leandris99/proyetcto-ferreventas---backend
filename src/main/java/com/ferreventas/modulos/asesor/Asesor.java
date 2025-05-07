package com.ferreventas.modulos.asesor;

import jakarta.persistence.*;


@Entity(name="asesor")
public class Asesor {
    //variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera valor id de forma automatica
    @Column(name="idASESOR")
    private Long idasesor ;

    @Column(name="NOMBRE_EMPRESA")
    private String nombreEmpresa;

    @Column(name="PERSONAS_idPERSONAS")
    private int DatosPersona;

    @Column(name="EMPRESA_PROVEEDOR_idEMPRESA_PROVEEDOR")
    private int AsesorEmpresa;

    //contructor vacio
    public Asesor(){

    }

    //constructo sin id
    public Asesor(String nombreEmpresa, int datosPersona, int asesorEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.DatosPersona = datosPersona;
        this.AsesorEmpresa = asesorEmpresa;
    }

    //contructor con id
    public Asesor(Long idasesor, String nombreEmpresa, int datosPersona, int asesorEmpresa) {
        this.idasesor = idasesor;
        this.nombreEmpresa = nombreEmpresa;
        this.DatosPersona = datosPersona;
        this.AsesorEmpresa = asesorEmpresa;
    }

    public Long getIdasesor() {
        return idasesor;
    }

    public void setIdasesor(Long idasesor) {
        this.idasesor = idasesor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getDatosPersona() {
        return DatosPersona;
    }

    public void setDatosPersona(int datosPersona) {
        DatosPersona = datosPersona;
    }

    public int getAsesorEmpresa() {
        return AsesorEmpresa;
    }

    public void setAsesorEmpresa(int asesorEmpresa) {
        AsesorEmpresa = asesorEmpresa;
    }
}




