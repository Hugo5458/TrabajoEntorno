//BY
package TrabajoEntorno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainasignatura {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Alumno> alumnos = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Asignatura> asignaturas = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear Alumno");
            System.out.println("2. Crear Curso");
            System.out.println("3. Agregar Asignaturas");
            System.out.println("4. Ingresar Notas");
            System.out.println("5. Mostrar Información");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: crearAlumno(); break;
                case 2: crearCurso(); break;
                case 3: agregarAsignaturas(); break;
                case 4: ingresarNotas(); break;
                case 5: mostrarInformacion(); 
                case 6: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void crearAlumno() {
        boolean datosValidos;
        do {
            datosValidos = true;
            try{
                System.out.print("Ingrese el nombre del alumno: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese la edad del alumno: ");
                int edad = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Ingrese el DNI del alumno: ");
                String dni = scanner.nextLine();
                Alumno alumno = new Alumno(, dni, edad);
                alumnos.add(alumno);
                System.out.println("Alumno creado exitosamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                datosValidos = false;
                scanner.nextLine();
            }
        } while (!datosValidos);
    }

    private static void crearCurso() {
        boolean datosValidos;
        do {
            datosValidos = true;
            try {
                Alumno alumno = seleccionarAlumno();
                if (alumno == null) ;
                System.out.print("Ingrese el nombre del curso (Ej: 1ºA): ");
                String nombreCurso = scanner.nextLine();
                Curso curso = new Curso(nombreCurso, alumno, new ArrayList<>());
                cursos.add(curso);
                System.out.println("Curso creado exitosamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                datosValidos = false;
                scanner.nextLine();
            }
        } while (!datosValidos);
    }

    private static void agregarAsignaturas() {
        boolean datosValidos;
        do {
            datosValidos = true;
            try {
                Alumno alumno = seleccionarAlumno();
                if (alumno == null) return;
                System.out.print("Ingrese la cantidad de asignaturas: ");
                int cantidadAsignaturas = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < cantidadAsignaturas; i++) {
                    System.out.print("Ingrese el nombre de la asignatura " + ( + 1) + ": ");
                    String nombreAsignatura = scanner.nextLine();
                    Asignatura asignatura = new Asignatura(nombreAsignatura, 0, alumno);
                    asignaturas.add(asignatura);
                }
                System.out.println("Asignaturas agregadas exitosamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                datosValidos = false;
                scanner.nextLine();
            }
        } while (!datosValidos);
    }

    private static void ingresarNotas() {
        boolean datosValidos;
        do {
            datosValidos = true;
            try {
                Alumno alumno = seleccionarAlumno();
                if (alumno == null) return;
                List<Asignatura> asignaturasAlumno = new ArrayList<>();
                for (Asignatura asignatura : asignaturas) {
                    if (asignatura.getAlumno().equals(alumno)) {
                        asignaturasAlumno.add(asignatura);
                    }
                }
                if (asignaturasAlumno.isEmpty()) {
                    System.out.println("Este alumno no tiene asignaturas registradas.");
                    return;
                }
                for (Asignatura asignatura : asignaturasAlumno) {
                    System.out.print("Ingrese la nota de " + asignatura.() + ": ");
                    double nota = scanner.nextDouble();
                    asignatura.setNotas(nota);
                }
                System.out.println("Notas ingresadas exitosamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                datosValidos = false;
                scanner.nextLine();
            }
        } while (!datosValidos);
    }

    private static void mostrarInformacion() {
        boolean datosValidos;
        do {
            datosValidos = true;
            try {
                Alumno alumno = seleccionarAlumno();
                if (alumno == null) return;
                System.out.println("\nInformación del Alumno:");
                System.out.println(alumno);
                for (Curso curso : cursos) {
                    if (curso.getAlumno().equals(alumno)) {
                        System.out.println("Curso: " + curso.getNombreCurso());
                    }
                }
                for (Asignatura asignatura : asignaturas) {
                    if (asignatura.getAlumno().equals(alumno)) {
                        System.out.println("Asignatura: " + asignatura.getNombre() + " - Nota: " + asignatura.getNombre());
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage();
                datosValidos = false;
                scanner.nextLine();
            }
        } while (datosValidos);
    }

    private static Alumno seleccionarAlumno() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados. Primero cree un alumno.");
            return null;
        }
        System.out.println("Seleccione un alumno por DNI: ");
        for (Alumno alumno : alumnos) {
            System.out.println("- " + alumno.getDni() + " (" + alumno.getNombre() + ")");
        }
        System.out.print("Ingrese el DNI  ");
        String dni = scanner.nextLine();
        for (Alumno alumno : alumnos) {
            if (alumno.getDni().equals(dni)) {
                return alumno;
            }
        }
        System.out.println("Alumno no encontrado.");
        return null;
    }
}