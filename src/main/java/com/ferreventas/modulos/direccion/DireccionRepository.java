package com.ferreventas.modulos.direccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    //esto seria lo mismo que agregar la sentencia de sql para buscar por nombre
    Optional<Direccion> findDireccionBybarrio(String barrio);
}
