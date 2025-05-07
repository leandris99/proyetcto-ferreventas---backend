package com.ferreventas.modulos.venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository <Venta, Long> {

    //esto seria lo mismo que agregar la sentencia de sql para buscar por nombre
    Optional<Venta> findVentaByfecha(LocalDate fecha);
}
