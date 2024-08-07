package com.spring.matricula.model.repository;

import com.spring.matricula.model.entity.EstudianteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<EstudianteEntidad, Long> {
    // Métodos de consulta personalizados, si es necesario
    Optional<EstudianteEntidad> findByDni(String dni);
}
