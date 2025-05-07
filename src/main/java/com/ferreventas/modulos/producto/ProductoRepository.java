package com.ferreventas.modulos.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long> {

    //esto seria lo mismo que agregar la sentencia de sql para buscar por nombre
    Optional<Producto> findProductoBynombreproducto(String nombreproducto);
}
