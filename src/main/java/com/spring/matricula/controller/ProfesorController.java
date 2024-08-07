package com.spring.matricula.controller;

import com.spring.matricula.model.entity.ProfesorEntidad;
import com.spring.matricula.service.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class ProfesorController {

    @Autowired
    private ProfesorServicio profesorServicio;

    @PostMapping("/create")
    public ResponseEntity<ProfesorEntidad> createProfesor(@RequestBody ProfesorEntidad profesor) {
        if (profesorServicio.createEntity(profesor)) {
            return new ResponseEntity<>(profesor, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProfesorEntidad>> getAllProfesores() {
        List<ProfesorEntidad> newList=profesorServicio.getListEntity();
        newList.stream().map(t->{
            t.getCursoEntidadList().stream().map(c->{
                c.setMatriculaEntidadList(null);
                c.setProfesorEntidad(null);
                return c;
            }).toList();
            return t;
        }).toList();
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<ProfesorEntidad> getProfesor(@PathVariable Long id) {
        ProfesorEntidad profesor = profesorServicio.getEntity(id);
        if (profesor != null) {
            profesor.getCursoEntidadList().stream().map(c->{
                c.setMatriculaEntidadList(null);
                c.setProfesorEntidad(null);
                return c;
            }).toList();
            return ResponseEntity.ok(profesor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ProfesorEntidad> updateProfesor(@RequestBody ProfesorEntidad profesor) {
        if (profesorServicio.updateEntity(profesor)) {
            return new ResponseEntity<>(profesor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteProfesor(@PathVariable Long id) {
        if (profesorServicio.deleteEntity(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
    }
}
