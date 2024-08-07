package com.spring.matricula.service.implementation;

import com.spring.matricula.model.entity.ProfesorEntidad;
import com.spring.matricula.model.repository.ProfesorRepository;
import com.spring.matricula.service.ProfesorServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfesorServicioImpl implements ProfesorServicio {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public boolean createEntity(ProfesorEntidad obj) {
        if (obj != null) {
            profesorRepository.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<ProfesorEntidad> getListEntity() {
        return profesorRepository.findAll();
    }

    @Override
    public ProfesorEntidad getEntity(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateEntity(ProfesorEntidad obj) {
        ProfesorEntidad profesor = profesorRepository.findById(obj.getIdProfesor()).orElse(null);
        if (profesor != null) {
            profesor.setNombre(obj.getNombre());
            profesor.setApellido(obj.getApellido());
            profesor.setTelefono(obj.getTelefono());
            profesor.setCorreoElectronico(obj.getCorreoElectronico());
            profesor.setHabilitado(obj.isHabilitado());
            // profesor.setCursos(obj.getCursos());

            profesorRepository.save(profesor);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEntity(Long id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
