package com.spring.matricula.controller;

import com.spring.matricula.model.entity.MatriculaEntidad;
import com.spring.matricula.service.MatriculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tuition")
public class MatriculaController {

    @Autowired
    private MatriculaServicio matriculaServicio;

    @PostMapping("/create")
    public ResponseEntity<MatriculaEntidad> createMatricula(@RequestBody MatriculaEntidad matricula) {
        if (matriculaServicio.createEntity(matricula)) {
            return new ResponseEntity<>(matricula, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<MatriculaEntidad>> getAllMatriculas() {
        List<MatriculaEntidad> newList=matriculaServicio.getListEntity();
        newList.stream()
                .map(m->{
                    m.getEstudianteEntidad().setMatriculaEntidadList(null);
                    m.getCursoEntidad().setMatriculaEntidadList(null);
                    m.getCursoEntidad().setProfesorEntidad(null);
                    return m;
                }).toList();
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<MatriculaEntidad> getMatricula(@PathVariable Long id) {
        MatriculaEntidad matricula = matriculaServicio.getEntity(id);
        if (matricula != null) {
            matricula.getEstudianteEntidad().setMatriculaEntidadList(null);
            matricula.getCursoEntidad().setMatriculaEntidadList(null);
            matricula.getCursoEntidad().setProfesorEntidad(null);
            return ResponseEntity.ok(matricula);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<MatriculaEntidad> updateMatricula(@RequestBody MatriculaEntidad matricula) {
        if (matriculaServicio.updateEntity(matricula)) {
            return new ResponseEntity<>(matricula, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteMatricula(@PathVariable Long id) {
        if (matriculaServicio.deleteEntity(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
    }
}
