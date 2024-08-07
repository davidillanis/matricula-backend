package com.spring.matricula.service;

import com.spring.matricula.model.entity.MatriculaEntidad;

import java.util.List;

public interface MatriculaServicio {
    boolean createEntity(MatriculaEntidad obj);
    List<MatriculaEntidad> getListEntity();
    MatriculaEntidad getEntity(Long id);
    boolean updateEntity(MatriculaEntidad obj);
    boolean deleteEntity(Long id);
}
