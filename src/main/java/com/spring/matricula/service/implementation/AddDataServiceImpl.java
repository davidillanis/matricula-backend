package com.spring.matricula.service.implementation;

import com.spring.matricula.model.entity.CursoEntidad;
import com.spring.matricula.model.entity.EstudianteEntidad;
import com.spring.matricula.model.entity.MatriculaEntidad;
import com.spring.matricula.model.entity.ProfesorEntidad;
import com.spring.matricula.service.CursoServicio;
import com.spring.matricula.service.EstudianteServicio;
import com.spring.matricula.service.MatriculaServicio;
import com.spring.matricula.service.ProfesorServicio;
import com.spring.matricula.util.other.EMatricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AddDataServiceImpl {
    @Autowired
    private CursoServicio cursoServicio;
    @Autowired
    private EstudianteServicio estudianteServicio;
    @Autowired
    private MatriculaServicio matriculaServicio;
    @Autowired
    private ProfesorServicio profesorServicio;


    public void addData(){
        addDataProfesor();
        addDataCurso();
        addDataEstudiante();
        addDataMatricula();
    }

    private void addDataCurso(){
        String url1="https://play-lh.googleusercontent.com/Xs_GrinVuNFnIEmfGSX6FMJiRRuTS0NFyII2oQvYuUFtJIO1h4miZ0mFY1urJNh0SZZ1";
        String url2="https://wikiculturas.com/wp-content/uploads/2022/04/los-quechuas.jpg";
        String url3="https://edfu3007italia.wordpress.com/wp-content/uploads/2015/02/tu-idioma-en-italia-01-300x300.jpg";
        ProfesorEntidad p1=profesorServicio.getEntity(1l);
        ProfesorEntidad p2=profesorServicio.getEntity(2l);
        ProfesorEntidad p3=profesorServicio.getEntity(3l);
        ProfesorEntidad p4=profesorServicio.getEntity(4l);
        cursoServicio.createEntity(new CursoEntidad(0l, "Ingles", "", 2, "2 semananas", "lunes viernes", "basico",60,  url1, 23, 20,  20,LocalDate.now(), LocalDate.now(), true, null, p1));
        cursoServicio.createEntity(new CursoEntidad(0l, "Ingles", "", 2, "1 semananas", "lunes viernes", "Intermedio",26, url1, 23, 20,  20,LocalDate.now(), LocalDate.now(), true, null, p2));
        cursoServicio.createEntity(new CursoEntidad(0l, "Ingles", "", 2, "3 semananas", "lunes viernes", "Avanzado",62, url1, 21, 20,  20,LocalDate.now(), LocalDate.now(), true, null, p3));

        cursoServicio.createEntity(new CursoEntidad(0l, "Quechua", "", 2, "2 semananas", "lunes viernes", "basico",60, url2, 25, 20,  20,LocalDate.now(), LocalDate.now(), true, null, p3));
        cursoServicio.createEntity(new CursoEntidad(0l, "Quechua", "", 2, "1 semananas", "lunes viernes", "Intermedio",26, url2, 12, 20,  20, LocalDate.now(), LocalDate.now(), true, null, p4));
        cursoServicio.createEntity(new CursoEntidad(0l, "Quechua", "", 2, "3 semananas", "lunes viernes", "Avanzado",62, url2, 10, 20,  20,LocalDate.now(), LocalDate.now(), true,null, p4));


        cursoServicio.createEntity(new CursoEntidad(0l, "Italiano", "", 2, "3 semananas", "lunes viernes", "Avanzado",62, url3, 10, 20,  20,LocalDate.now(), LocalDate.now(), true,null, p4));

    }

    private void addDataProfesor(){
        profesorServicio.createEntity(new ProfesorEntidad(0l, "P001", "Apellido1", "9988022", "P001@gmail.com", true, null));
        profesorServicio.createEntity(new ProfesorEntidad(0l, "P002", "Apellido2", "9988422", "P002@gmail.com", true, null));
        profesorServicio.createEntity(new ProfesorEntidad(0l, "P003", "Apellido3", "9388022", "P003@gmail.com", true, null));
        profesorServicio.createEntity(new ProfesorEntidad(0l, "P004", "Apellido4", "9888022", "P004@gmail.com", true,null));
    }

    private void addDataEstudiante(){
        estudianteServicio.createEntity(new EstudianteEntidad(0l, "1007920212", "David", "illanis", "95938234", "75195279", "david@gmail.com", null, null));
        estudianteServicio.createEntity(new EstudianteEntidad(0l, "1007820212", "Juan", "huaraca", "95938612", "75195277", "juan@gmail.com", null, null));
        estudianteServicio.createEntity(new EstudianteEntidad(0l, "1007720212", "Tomas", "garcia", "95438212", "75195276", "tomasd@gmail.com", null, null));
        estudianteServicio.createEntity(new EstudianteEntidad(0l, "1007620212", "Pepe", "serna", "954512033", "75195274", "pepe@gmail.com", null, null));
        estudianteServicio.createEntity(new EstudianteEntidad(0l, "1007520212", "Ramirez", "berrocal", "9437862", "75195271", "ramirez@gmail.com", null, null));
    }

    private void addDataMatricula(){
        EstudianteEntidad e1=estudianteServicio.getEntity(1l);
        EstudianteEntidad e2=estudianteServicio.getEntity(2l);
        EstudianteEntidad e3=estudianteServicio.getEntity(3l);
        EstudianteEntidad e4=estudianteServicio.getEntity(4l);
        EstudianteEntidad e5=estudianteServicio.getEntity(5l);
        CursoEntidad c1=cursoServicio.getEntity(1l);
        CursoEntidad c2=cursoServicio.getEntity(2l);
        CursoEntidad c3=cursoServicio.getEntity(3l);
        CursoEntidad c4=cursoServicio.getEntity(4l);
        CursoEntidad c5=cursoServicio.getEntity(5l);
        CursoEntidad c6=cursoServicio.getEntity(6l);

        matriculaServicio.createEntity(new MatriculaEntidad(0l, LocalDate.now(), EMatricula.PENDIENTE, "https://imgv2-1-f.scribdassets.com/img/document/473786904/original/38cae5630d/1717728935?v=1", "https://cdn02.jotfor.ms/templates/screenshot/form-templates/ficha-de-matricula-2021.png?v=3083441605&t=classic", "", "", e1, c1));
        matriculaServicio.createEntity(new MatriculaEntidad(0l, LocalDate.now(), EMatricula.CONFIRMADA, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8WNQE-NodrZ5E9MAvOXwLgqJ-080t3pR0Tw&s","", "", "", e1, c2));
        matriculaServicio.createEntity(new MatriculaEntidad(0l, LocalDate.now(), EMatricula.RECHAZADA, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8WNQE-NodrZ5E9MAvOXwLgqJ-080t3pR0Tw&s", "", "", "", e2, c2));
        matriculaServicio.createEntity(new MatriculaEntidad(0l, LocalDate.now(), EMatricula.PENDIENTE, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8WNQE-NodrZ5E9MAvOXwLgqJ-080t3pR0Tw&s", "", "", "", e2, c3));
        matriculaServicio.createEntity(new MatriculaEntidad(0l, LocalDate.now(), EMatricula.PENDIENTE, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8WNQE-NodrZ5E9MAvOXwLgqJ-080t3pR0Tw&s", "", "", "", e3, c4));
        matriculaServicio.createEntity(new MatriculaEntidad(0l, LocalDate.now(), EMatricula.CONFIRMADA, "https://imgv2-1-f.scribdassets.com/img/document/473786904/original/38cae5630d/1717728935?v=1", "", "", "", e3, c4));
        matriculaServicio.createEntity(new MatriculaEntidad(0l, LocalDate.now(), EMatricula.PENDIENTE, "https://imgv2-1-f.scribdassets.com/img/document/473786904/original/38cae5630d/1717728935?v=1", "", "", "", e4, c5));
        matriculaServicio.createEntity(new MatriculaEntidad(0l, LocalDate.now(), EMatricula.PENDIENTE, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRyxw4wg-ViQVy3Ag0eC8CefGcFfMjab_5kQ&s", "", "", "", e5, c5));
        matriculaServicio.createEntity(new MatriculaEntidad(0l, LocalDate.now(), EMatricula.PENDIENTE, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRyxw4wg-ViQVy3Ag0eC8CefGcFfMjab_5kQ&s", "", "", "", e5, c6));
        matriculaServicio.createEntity(new MatriculaEntidad(0l, LocalDate.now(), EMatricula.PENDIENTE, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRyxw4wg-ViQVy3Ag0eC8CefGcFfMjab_5kQ&s", "", "", "", e5, c6));

    }
}
