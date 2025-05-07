package com.ferreventas.modulos.empresa_proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa,Long> {
    //esto seria lo mismo que agregar la sentencia de sql para buscar por nombre
    Optional<Empresa> findEmpresaBynombre(String nombre);
}
