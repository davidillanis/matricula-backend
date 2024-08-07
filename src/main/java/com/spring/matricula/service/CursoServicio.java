package com.spring.matricula.service;

import com.spring.matricula.model.entity.CursoEntidad;

import java.util.List;

public interface CursoServicio {
    boolean createEntity(CursoEntidad obj);
    List<CursoEntidad> getListEntity();
    CursoEntidad getEntity(Long id);
    boolean updateEntity(CursoEntidad obj);
    boolean deleteEntity(Long id);
}
