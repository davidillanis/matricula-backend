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
@Table(name = "estudiantes")
public class EstudianteEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    @Column(nullable = false, unique = true, length = 25)
    private String codigoEstudiante;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(nullable = false, length = 45)
    private String apellido;

    @Column(length = 15)
    private String telefono;

    @Column(nullable = false, unique = true, length = 25)
    private String dni;

    @Column(nullable = false, length = 95)
    private String correoElectronico;

    @Column(length = 255)
    private String urlDni;

    @OneToMany(targetEntity = MatriculaEntidad.class, cascade = CascadeType.ALL, mappedBy = "estudianteEntidad")
    private List<MatriculaEntidad> matriculaEntidadList;
}

