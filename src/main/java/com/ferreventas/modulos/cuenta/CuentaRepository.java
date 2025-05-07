package com.ferreventas.modulos.cuenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    //esto seria lo mismo que agregar la sentencia de sql para buscar por nombre
    Optional<Cuenta> findCuentaByidcuenta(Long idcuenta);
}
