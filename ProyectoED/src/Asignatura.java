package TrabajoEntorno;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
    private String nombreasignatura;
    private double notas;
    private Alumno alumno;

    private static final List<Alumno> alumnousado = new ArrayList<>();

    public Asignatura(String nombreasignatura, double notas, Alumno alumno) {
        setNotas(notas);
        this.alumno = alumno;
        setNombre(nombreasignatura);
    }

    public String getNombre() {
        return nombreasignatura;
    }

    public double getNotas() {
        return notas;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setNotas(double notas) {
        if (notas < 0 || notas > 10) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");       
        }
        this.notas = notas;
    }

    public void setNombre(String nombreasignatura) {
        if (nombreasignatura == null || nombreasignatura.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la asignatura no puede estar vacÃo.");
        }
        this.nombreasignatura = nombreasignatura;
    }

    public void inscribirAlumno(Alumno alumno) {
        if (alumno == null || alumnousado.contains(alumno)) {
            throw new IllegalArgumentException("No insertado");
        }
        alumnousado.add(alumno);
        System.out.println("Alumno " + alumno.getNombre() + " inscrito en " + this.nombreasignatura);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asignatura{");
        sb.append("notas=").append(notas);
        sb.append(", nombre=").append(nombreasignatura);
        sb.append(", alumno=").append(alumno.getnombre());
        sb.append('}');
        return sb.toString();
    }
}