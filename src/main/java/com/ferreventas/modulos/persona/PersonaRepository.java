package com.ferreventas.modulos.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PersonaRepository extends JpaRepository <Persona,Long> {

    //esto seria lo mismo que agregar la sentencia de sql para buscar por nombre
    Optional<Persona> findPersonaBynombre(String nombre);

}
