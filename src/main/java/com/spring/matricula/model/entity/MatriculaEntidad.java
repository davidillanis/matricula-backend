package com.spring.matricula.model.entity;

import com.spring.matricula.util.other.EMatricula;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "matriculas")
public class MatriculaEntidad  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatricula;

    @Temporal(TemporalType.DATE)
    private LocalDate fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private EMatricula estado;

    @Column(length = 255, nullable = false)
    private String urlVoucher;

    @Column(length = 255)
    private String urlPdfMatricula;

    @Column(length = 255)
    private String urlPdfDeclaracionJurada;

    @Column(length = 255)
    private String urlPDFCartaCompromiso;

    @ManyToOne
    @JoinColumn(name = "idEstudiante", nullable = false)
    private EstudianteEntidad estudianteEntidad;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private CursoEntidad cursoEntidad;
}
