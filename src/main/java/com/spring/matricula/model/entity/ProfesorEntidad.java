package com.spring.matricula.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "profesores")
public class ProfesorEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesor;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(nullable = false, length = 45)
    private String apellido;

    @Column(length = 15)
    private String telefono;

    @Column(nullable = false, unique = true, length = 95)
    private String correoElectronico;

    private boolean habilitado;

    @OneToMany(targetEntity = CursoEntidad.class, cascade = CascadeType.ALL, mappedBy = "profesorEntidad")
    private List<CursoEntidad> cursoEntidadList;
}
