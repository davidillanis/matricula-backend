package com.spring.matricula.model.repository;
import com.spring.matricula.model.entity.MatriculaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<MatriculaEntidad, Long> {
    // Métodos de consulta personalizados, si es necesario
}
