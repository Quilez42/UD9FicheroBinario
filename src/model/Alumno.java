package model;

import java.io.Serializable;

public class Alumno extends Persona implements Serializable {

    //PROPIEDADES
    private Curso curso;

    //CONSTRUCTOR
    public Alumno(String dni, String nombre, int edad, Curso curso){
        super(dni,nombre,edad);
        this.curso=curso;
    }

    //METODOS
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
