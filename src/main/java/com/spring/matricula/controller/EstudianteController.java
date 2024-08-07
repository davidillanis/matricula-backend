package com.spring.matricula.controller;
import com.spring.matricula.model.entity.EstudianteEntidad;
import com.spring.matricula.service.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class EstudianteController {

    @Autowired
    private EstudianteServicio estudianteServicio;

    @PostMapping("/create")
    public ResponseEntity<EstudianteEntidad> createEstudiante(@RequestBody EstudianteEntidad estudiante) {
        if (estudianteServicio.createEntity(estudiante)) {
            return new ResponseEntity<>(estudiante, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<EstudianteEntidad>> getAllEstudiantes() {
        List<EstudianteEntidad> newList=estudianteServicio.getListEntity().stream()
                .map(e->{
                    e.getMatriculaEntidadList().stream()
                            .map(m->{
                                m.setEstudianteEntidad(null);
                                m.setCursoEntidad(null);
                                return m;
                            })
                            .toList();
                    return e;
                }).toList();
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<EstudianteEntidad> getEstudiante(@PathVariable Long id) {
        EstudianteEntidad estudiante = estudianteServicio.getEntity(id);
        if (estudiante != null) {
            estudiante.getMatriculaEntidadList().stream()
                    .map(m->{
                        m.setEstudianteEntidad(null);
                        m.setCursoEntidad(null);
                        return m;
                    })
                    .toList();
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byDni/{dni}")
    public ResponseEntity<EstudianteEntidad> getEstudianteByDNI(@PathVariable String dni) {
        EstudianteEntidad estudiante = estudianteServicio.findByDni(dni).orElse(null);
        if (estudiante != null) {
            estudiante.getMatriculaEntidadList().stream()
                    .map(m->{
                        m.setEstudianteEntidad(null);
                        m.setCursoEntidad(null);
                        return m;
                    })
                    .toList();
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<EstudianteEntidad> updateEstudiante(@RequestBody EstudianteEntidad estudiante) {
        if (estudianteServicio.updateEntity(estudiante)) {
            return new ResponseEntity(estudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteEstudiante(@PathVariable Long id) {
        if (estudianteServicio.deleteEntity(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
    }
}
