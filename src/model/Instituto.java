package model;

import java.util.Scanner;

public class Instituto {
    Scanner sc=new Scanner(System.in);
    //PROPIEDADES
    private Alumno[] alumnos;
    private static int maxAlumnos=2;
    private int totalAlumnos;
    private Profesor[] profesores;
    private static int maxProfesores=2;
    private int totalProfesores;

    //CONSTRUCTOR
    public Instituto(){
        alumnos=new Alumno[maxAlumnos];
        profesores=new Profesor[maxProfesores];
        totalAlumnos=0;
        totalProfesores=0;
    }

    public void nuevoAlumno(){
        if (totalAlumnos>=maxAlumnos){
            System.out.println("No queda espacio para más alumnos");
        } else {
            for (int c=totalAlumnos;c<maxAlumnos;c++) {
                Curso curso = null;
                //Pedimos el dni
                String dni="";
                do {
                System.out.println("Introduce el DNI del alumno");
                dni = sc.next();
                } while (!esCorrectoNIF(dni) || buscarAlumno(dni) != -1);
                //Pedimos el nombre
                System.out.println("Introduce el nombre del alumno");
                String nom = sc.next();
                //Pedimos el edad
                System.out.println("Introduce la edad del alumno");
                while (!sc.hasNextInt()) {
                    System.out.println("Introduce la edad del alumno");
                    sc.next();
                }
                int edad=sc.nextInt();
                int opc;
                do {
                    System.out.println("""
                            Introduce el curso del alumno
                            1. DAM
                            2. DAW
                            3. SMR
                            """);
                    opc = sc.nextInt();
                    switch (opc){
                        case 1 -> {curso = Curso.DAM;}
                        case 2 -> {curso = Curso.DAW;}
                        case 3 -> {curso = Curso.SMR;}
                    }
                totalAlumnos++;
                } while (opc<1 || opc>3);
                Alumno alumno=new Alumno(dni,nom,edad,curso);
                alumnos[c]=alumno;
            }
        }
    }

    public void nuevoProfesor(){
        if (totalProfesores>=maxProfesores){
            System.out.println("No queda espacio para más profesores");
        } else {
            for (int c=totalProfesores;c<maxProfesores;c++) {
                //Pedimos el dni
                String dni;
                do {
                    System.out.println("Introduce el DNI del profesor");
                    dni = sc.next();
                } while (!esCorrectoNIF(dni) || buscarProfesor(dni) != -1);
                //Pedimos el nombre
                System.out.println("Introduce el nombre del profesor");
                String nom = sc.next();
                //Pedimos el sueldo
                System.out.println("Introduce el sueldo del profesor");
                while (!sc.hasNextInt()) {
                    System.out.println("Introduce el sueldo del profesor");
                    sc.next();
                }
                int sueldo=sc.nextInt();
                //Pedimos el edad
                System.out.println("Introduce la edad del alumno");
                while (!sc.hasNextInt()) {
                    System.out.println("Introduce la edad del alumno");
                    sc.next();
                }
                int edad=sc.nextInt();
                Profesor profesor=new Profesor(dni,nom,sueldo,edad);
                profesores[c]=profesor;
                totalProfesores++;
            }
        }
    }

    public void mostrarAlumnos(){
        String result =String.format("%-15s%-15s%-15s","Curso","Alumno","DNI");
        result +="\n";
        for (int c=0; c<totalAlumnos;c++){
            result +=String.format("%-15s%-15s%-15s",alumnos[c].getCurso(),alumnos[c].getNombre(),alumnos[c].getDni());
            result +="\n";
        }
        System.out.println(result);
    }

    public void mostrarProfesores(){
        String result =String.format("%-15s%-15s%-15s","DNI","Profesor","Sueldo");
        result +="\n";
        for (int c= 0; c<totalProfesores;c++){
            result +=String.format("%-15s%-15s%-15s",profesores[c].getDni(),profesores[c].getNombre(),profesores[c].getSueldo());
            result +="\n";
        }
        System.out.println(result);
    }

    public int buscarAlumno(String dni){
        int result=-1;
        for (int c=0;c<totalAlumnos;c++){
            if (alumnos[c].equals(dni)) result=c;
        }
        return result;
    }

    public int buscarProfesor(String dni){
        int result=-1;
        for (int c=0;c<totalProfesores;c++){
            if (profesores[c].equals(dni)) result=c;
        }
        return result;
    }

    public void borrarAlumno(int puesto){
        if (puesto<0 || puesto>totalAlumnos) System.out.println("Posición incorrecta");
        else {
            totalAlumnos--;
            for (int c = puesto; c < totalAlumnos; c++) {
                alumnos[c] = alumnos[c + 1];
            }
        }
    }

    public void borrarProfesor(int puesto){
        if (puesto<0 || puesto>totalProfesores) System.out.println("Posición incorrecta");
        else {
            totalProfesores--;
            for (int c = puesto; c < totalProfesores; c++) {
                profesores[c] = profesores[c + 1];
            }
        }
    }

    public void modificarAlumno(Alumno alumno){
        for (int c=0;c<totalAlumnos;c++) {
            if (alumno.equals(alumnos[c])){
                alumnos[c]=alumno;
            }
        }
    }

    public void modificarProfesor(Profesor profesor){
        for (int c=0;c<totalProfesores;c++) {
            if (profesor.equals(profesores[c])){
                profesores[c]=profesor;
            }
        }
    }

    public static boolean esCorrectoNIF(String NIF){
        boolean nif=true;

        if (NIF.length()!=9)
            nif=false;

        if (nif) {
            for (int c = 0; c < 8; c++) {
                if (!Character.isDigit(NIF.charAt(c))) {
                    nif = false;
                }
            }
        }
        if (nif) {
            char letra = NIF.charAt(8);
            Character.toUpperCase(letra);
            if (!Character.isLetter(letra))
                nif = false;


            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            String numeros = NIF.substring(0, 8);
            int num = Integer.parseInt(numeros);
            char letraEsp = letras.charAt(num % 23);
            Character.toUpperCase(letraEsp);

            if (letraEsp != letra)
                nif = false;
        }
        return nif;
    }
}
