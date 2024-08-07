package com.spring.matricula.service.implementation;

import com.spring.matricula.model.entity.CursoEntidad;
import com.spring.matricula.model.repository.CursoRepository;
import com.spring.matricula.service.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServicioImpl implements CursoServicio {
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public boolean createEntity(CursoEntidad obj) {
        if(obj!=null){
            cursoRepository.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<CursoEntidad> getListEntity() {
        return cursoRepository.findAll();
    }

    @Override
    public CursoEntidad getEntity(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateEntity(CursoEntidad obj) {
        CursoEntidad cursoEntidad=cursoRepository.findById(obj.getIdCurso()).orElse(null);
        if(cursoEntidad!=null){
            cursoEntidad.setNombreCurso(obj.getNombreCurso());
            cursoEntidad.setDescripcion(obj.getDescripcion());
            cursoEntidad.setCreditos(obj.getCreditos());
            cursoEntidad.setDuracion(obj.getDuracion());
            cursoEntidad.setHorario(obj.getHorario());
            cursoEntidad.setNivel(obj.getNivel());
            cursoEntidad.setCapacidad(obj.getCapacidad());
            cursoEntidad.setUrl(obj.getUrl());
            cursoEntidad.setCostoCurso(obj.getCostoCurso());
            cursoEntidad.setCostoLibro(obj.getCostoLibro());
            cursoEntidad.setPrimeraMensualidad(obj.getPrimeraMensualidad());
            cursoEntidad.setFechaInicio(obj.getFechaInicio());
            cursoEntidad.setFechaFinalizacion(obj.getFechaFinalizacion());
            cursoEntidad.setProfesorEntidad(obj.getProfesorEntidad());
            cursoEntidad.setHabilitado(obj.isHabilitado());
            //cursoEntidad.setProfesor(obj.getProfesor());
            //cursoEntidad.setEstudiantes(obj.getEstudiantes());

            cursoRepository.save(cursoEntidad);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEntity(Long id) {
        if(cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
