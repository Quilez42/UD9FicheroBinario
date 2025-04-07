package app;

import model.Alumno;
import model.Curso;
import model.Instituto;
import model.Profesor;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Instituto instituto = new Instituto();
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println("""
                    Menú
                    0. Salir
                    1. Nuevo Alumno
                    2. Nuevo Profesor
                    3. Mostrar Alumnos
                    4. Mostrar Profesores
                    5. Buscar Alumno
                    6. Buscar Profesor
                    7. Borrar Alumno
                    8. Borrar Profesor
                    9. Modificar Alumno
                    10. Modificar Profesor
                    11. Guardar lista de alumnos
                    12. Leer lista de alumnos
                    13. Guardar lista de profesores
                    14. Leer lista de profesores
                    """);
            opc = sc.nextInt();
            switch (opc) {
                case 1 -> {
                    instituto.nuevoAlumno();
                }
                case 2 -> {
                    instituto.nuevoProfesor();
                }
                case 3 -> {
                    instituto.mostrarAlumnos();
                }
                case 4 -> {
                    instituto.mostrarProfesores();
                }
                case 5 -> {
                    System.out.println("Introduce el DNI del alumno");
                    String DNI = sc.next();
                    instituto.buscarAlumno(DNI);
                }

                case 6 -> {
                    System.out.println("Introduce el DNI del profesor");
                    String DNI = sc.next();
                    instituto.buscarProfesor(DNI);
                }

                case 7 -> {
                    System.out.println("Introduce la posición del alumno");
                    int pos = sc.nextInt();
                    instituto.borrarAlumno(pos);
                }

                case 8 -> {
                    System.out.println("Introduce la posición del alumno");
                    int pos = sc.nextInt();
                    instituto.borrarProfesor(pos);
                }

                case 9 -> {
                    System.out.println("Introduce el DNI del alumno");
                    String dni = sc.next();
                    System.out.println("Introduce el nuevo nombre del alumno");
                    String nom = sc.next();
                    System.out.println("Introduce la nueva edad del alumno");
                    int edad;
                    try{
                        edad = sc.nextInt();
                    } catch (NumberFormatException e){
                        edad=1;
                    }
                    int op;
                    Curso curso = null;
                    do {
                        System.out.println("""
                                Introduce el nuevo curso del alumno
                                1. DAM
                                2. DAW
                                3. SMR
                                """);
                        try{
                            op = sc.nextInt();
                        } catch (NumberFormatException e){
                            op=1;
                        }

                        switch (opc) {
                            case 1 -> {
                                curso = Curso.DAM;
                            }
                            case 2 -> {
                                curso = Curso.DAW;
                            }
                            case 3 -> {
                                curso = Curso.SMR;
                            }
                        }
                    } while (opc < 1 || opc > 3);
                    Alumno alumno=new Alumno(dni,nom,edad,curso);
                    instituto.modificarAlumno(alumno);}

                case 10 -> {System.out.println("Introduce el DNI del profesor");
                    String dni = sc.next();
                    System.out.println("Introduce el nuevo " +
                            "nombre del profesor");
                    String nom = sc.next();
                    System.out.println("Introduce el nuevo salario del profesor");
                    int sueldo;
                    try{
                        sueldo = sc.nextInt();
                    } catch (NumberFormatException e){
                        sueldo=1;
                    }
                    System.out.println("Introduce la nueva edad del profesor");
                    int edad;
                    try{
                        edad = sc.nextInt();
                    } catch (NumberFormatException e){
                        edad=1;
                    }
                    Profesor profesor=new Profesor(dni,nom,sueldo,edad);
                    instituto.modificarProfesor(profesor);}
                case 11-> instituto.guardarAlumnosArchivo(instituto.getAlumnos(),"alumnos.dat");
                case 12 -> System.out.println(Arrays.toString(instituto.leerArchivoAlumnos("alumnos.dat")));
                case 13 -> instituto.guardarProfesoresArchivo(instituto.getProfesores(),"profesor.dat");
                case 14 -> System.out.println(instituto.leerArchivoProfesores("profesor.dat"));
            }
        }while (opc!=0);
    }
}