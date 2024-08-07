package com.spring.matricula.controller;

import com.spring.matricula.model.entity.CursoEntidad;
import com.spring.matricula.service.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CursoController {

    @Autowired
    private CursoServicio cursoServicio;

    @PostMapping("/create")
    public ResponseEntity<CursoEntidad> createCurso(@RequestBody CursoEntidad curso) {
        if (cursoServicio.createEntity(curso)) {
            return new ResponseEntity<>(curso, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CursoEntidad>> getAllCursos() {
        List<CursoEntidad> newList=cursoServicio.getListEntity().stream()
                .map(t->{
                    t.getMatriculaEntidadList().stream().map(m->{
                        m.setEstudianteEntidad(null);
                        m.setCursoEntidad(null);
                        return m;
                    }).toList();

                    t.getProfesorEntidad().setCursoEntidadList(null);
                    return t;
                }).toList();
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<CursoEntidad> getCurso(@PathVariable Long id) {
        CursoEntidad curso = cursoServicio.getEntity(id);
        if (curso != null) {
            curso.getMatriculaEntidadList().stream().map(m->{
                m.setEstudianteEntidad(null);
                m.setCursoEntidad(null);
                return m;
            }).toList();
            curso.getProfesorEntidad().setCursoEntidadList(null);
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<CursoEntidad> updateCurso(@RequestBody CursoEntidad curso) {
        if (cursoServicio.updateEntity(curso)) {
            return new ResponseEntity<>(curso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteCurso(@PathVariable Long id) {
        if (cursoServicio.deleteEntity(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
    }
}
