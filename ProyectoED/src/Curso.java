package ProyectoED.src;

import java.util.List;

public class Curso {
    private String nombreCurso;
    private List<Asignatura> asignaturas =;
    private Alumno alumno;
    
    public Curso(String nombreCurso, Alumno alumno, List<Asignatura> asignaturas) {
        setNombreCurso(nombreCurso);
        setAlumno(alumno);
        setAsignaturas(asignaturas);
    }

    public String getNombreCurso() {
        return nombreCurso;
    }
    
    public void setNombreCurso(String nombreCurso) {
        if (nombreCurso == null || !nombreCurso.matches("^\\D{1}º[A-Z]{1}$")) {
            throw new IllegalArgumentException("El nombre del curso solo puede contener una letra, el símbolo 'º' y una letra mayúscula");
        }
        this.nombreCurso = nombreCurso;
    }

    public Alumno getAlumno() { 
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo");
        }
        this.alumno = alumno;
    }
    
    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    
    public void setAsignaturas(List<Asignatura> asignaturas) {
        if (asignaturas == null || asignaturas.isEmpty()) {
            throw new IllegalArgumentException("El curso debe tener al menos una asignatura");
        }
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Curso [nombreCurso=" + nombreCurso + ", alumno=" + alumno + ", asignaturas=" + asignaturas + "]";
    }
}