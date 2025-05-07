package com.ferreventas.modulos.empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado, Long> {

    //esto seria lo mismo que agregar la sentencia de sql para buscar por nombre
    Optional<Empleado> findPersonaByidempleado(Long idempleado);
}
