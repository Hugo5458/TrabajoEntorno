package TrabajoEntorno;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombreAlumno;
    private int edad;
    private String dni;
    
    private static final List<String> dnisUsados = new ArrayList<>();
    private static final String PATRON_DNI = "^\\d{8}[A-Za-z]$";

    Alumno(String nombre, String dni, int edad) {
        setNombre(nombre);
        setEdad(edad);
        setDni(dni);
    }

    String getNombre() {
        return nombreAlumno;
    }

    void setNombre(String nombre) {
        if (nombre != null && nombre.matches("^[A-Za-z\\s]{3,50}$")) {
            this.nombreAlumno = nombre;
        } else {
            throw new IllegalArgumentException("Nombre erróneo");
        }
    }

    int getEdad() {
        return edad;
    }

    void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("Edad debe ser mayor que 0");
        }
    }

    String getDni() {
        return dni;
    }

    void setDni(String dni) {
        if (!dni.matches(PATRON_DNI)) {
            throw new IllegalArgumentException("Formato de DNI incorrecto");
        }
        if (dnisUsados.contains(dni)) {
            throw new IllegalArgumentException("El DNI ya está en uso");
        }
        dnisUsados.add(dni);
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Alumno{nombreAlumno=" + nombreAlumno + ", edad=" + edad + ", dni=" + dni + "}";
    }
}