package com.spring.matricula.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "cursos")
public class CursoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    @Column(nullable = false, length = 45)
    private String nombreCurso;

    @Column(length = 1000)
    private String descripcion;

    private Integer creditos;

    @Column(length = 45)
    private String duracion;

    @Column(length = 95)
    private String horario;

    @Column(length = 45)
    private String nivel;

    private Integer capacidad;

    @Column(length = 255)
    private String url;

    @Column(nullable = false)
    private double costoCurso;

    @Column(nullable = false)
    private double costoLibro;

    @Column(nullable = false)
    private double primeraMensualidad;

    @Temporal(TemporalType.DATE)
    private LocalDate fechaInicio;

    @Temporal(TemporalType.DATE)
    private LocalDate fechaFinalizacion;

    private boolean habilitado;

    @OneToMany(targetEntity = MatriculaEntidad.class, cascade = CascadeType.ALL, mappedBy = "cursoEntidad")
    private List<MatriculaEntidad> matriculaEntidadList;

    @ManyToOne
    @JoinColumn(name = "idProfesor", nullable = false)
    private ProfesorEntidad profesorEntidad;
}
