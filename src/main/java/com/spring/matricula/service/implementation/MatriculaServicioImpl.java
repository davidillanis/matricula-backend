package com.spring.matricula.service.implementation;

import com.spring.matricula.model.entity.MatriculaEntidad;
import com.spring.matricula.model.repository.MatriculaRepository;
import com.spring.matricula.service.MatriculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatriculaServicioImpl implements MatriculaServicio {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public boolean createEntity(MatriculaEntidad obj) {
        if (obj != null) {
            matriculaRepository.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<MatriculaEntidad> getListEntity() {
        return matriculaRepository.findAll();
    }

    @Override
    public MatriculaEntidad getEntity(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateEntity(MatriculaEntidad obj) {
        MatriculaEntidad matricula = matriculaRepository.findById(obj.getIdMatricula()).orElse(null);
        if (matricula != null) {
            matricula.setEstudianteEntidad(obj.getEstudianteEntidad());
            matricula.setFechaSolicitud(obj.getFechaSolicitud());
            matricula.setEstado(obj.getEstado());
            matricula.setCursoEntidad(obj.getCursoEntidad());
            matricula.setUrlVoucher(obj.getUrlVoucher());
            matricula.setUrlPdfMatricula(obj.getUrlPdfMatricula());
            matricula.setUrlPDFCartaCompromiso(obj.getUrlPDFCartaCompromiso());
            matricula.setUrlPdfDeclaracionJurada(obj.getUrlPdfDeclaracionJurada());
            matriculaRepository.save(matricula);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEntity(Long id) {
        if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
