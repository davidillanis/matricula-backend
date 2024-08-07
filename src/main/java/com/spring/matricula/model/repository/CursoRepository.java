package com.spring.matricula.model.repository;

import com.spring.matricula.model.entity.CursoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoEntidad, Long> {
    // Métodos de consulta personalizados, si es necesario
}
