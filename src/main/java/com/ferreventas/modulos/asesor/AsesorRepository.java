package com.ferreventas.modulos.asesor;

//import com.ferreventas.modulos.persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AsesorRepository extends JpaRepository<Asesor, Long> {
    //esto seria lo mismo que agregar la sentencia de sql para buscar por nombre
    Optional<Asesor> findAsesorByidasesor(Long idasesor);

}
