package com.spring.matricula.service;

import com.spring.matricula.model.entity.EstudianteEntidad;

import java.util.List;
import java.util.Optional;

public interface EstudianteServicio {
    boolean createEntity(EstudianteEntidad obj);
    List<EstudianteEntidad> getListEntity();
    EstudianteEntidad getEntity(Long id);
    boolean updateEntity(EstudianteEntidad obj);
    boolean deleteEntity(Long id);
    Optional<EstudianteEntidad> findByDni(String dni);
}
