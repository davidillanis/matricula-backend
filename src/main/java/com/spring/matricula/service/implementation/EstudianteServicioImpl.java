package com.spring.matricula.service.implementation;

import com.spring.matricula.model.entity.CursoEntidad;
import com.spring.matricula.model.entity.EstudianteEntidad;
import com.spring.matricula.model.repository.CursoRepository;
import com.spring.matricula.model.repository.EstudianteRepository;
import com.spring.matricula.service.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicioImpl implements EstudianteServicio {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public boolean createEntity(EstudianteEntidad obj) {
        if (obj != null) {
            estudianteRepository.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<EstudianteEntidad> getListEntity() {
        return estudianteRepository.findAll();
    }

    @Override
    public EstudianteEntidad getEntity(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateEntity(EstudianteEntidad obj) {
        EstudianteEntidad estudiante = estudianteRepository.findById(obj.getIdEstudiante()).orElse(null);
        if (estudiante != null) {
            estudiante.setCodigoEstudiante(obj.getCodigoEstudiante());
            estudiante.setNombre(obj.getNombre());
            estudiante.setApellido(obj.getApellido());
            estudiante.setTelefono(obj.getTelefono());
            estudiante.setDni(obj.getDni());
            estudiante.setCorreoElectronico(obj.getCorreoElectronico());
            estudiante.setUrlDni(obj.getUrlDni());
            // estudiante.setCursos(obj.getCursos());

            estudianteRepository.save(estudiante);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEntity(Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<EstudianteEntidad> findByDni(String dni) {
        return estudianteRepository.findByDni(dni);
    }
}

