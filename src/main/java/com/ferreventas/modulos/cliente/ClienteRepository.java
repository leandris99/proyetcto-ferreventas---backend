package com.ferreventas.modulos.cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
    //esto seria lo mismo que agregar la sentencia de sql para buscar por id
    Optional<Cliente> findClienteByidcliente(Long idcliente);
}
