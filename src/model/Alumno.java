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

    @Override
    public String toString() {
        return "Alumno{" +
                "DNI"+super.getDni() +
                "Nombre"+super.getNombre()+
                "Edad"+super.getEdad()+
                "curso=" + curso +
                '}';
    }
}
