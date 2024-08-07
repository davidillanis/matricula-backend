package com.spring.matricula.model.repository;

import com.spring.matricula.model.entity.ProfesorEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<ProfesorEntidad, Long> {
    // Métodos de consulta personalizados, si es necesario
}
