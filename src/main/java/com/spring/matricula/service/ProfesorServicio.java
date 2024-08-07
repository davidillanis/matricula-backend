package com.spring.matricula.service;

import com.spring.matricula.model.entity.ProfesorEntidad;

import java.util.List;

public interface ProfesorServicio {
    boolean createEntity(ProfesorEntidad obj);
    List<ProfesorEntidad> getListEntity();
    ProfesorEntidad getEntity(Long id);
    boolean updateEntity(ProfesorEntidad obj);
    boolean deleteEntity(Long id);
}
