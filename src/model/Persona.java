package model;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable {

    //PROPIEDADES
    private String dni;
    private String nombre;
    private int edad;

    //CONSTRUCTOR
    public Persona(String dni, String nombre, int edad){
        setDni(dni);
        this.nombre=nombre;
        this.edad=edad;
    }

    //MÉTODOS
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    public int hashCode() {
        return Objects.hash(dni);
    }

    public String getDni() {
        return dni;
    }

    public void setEdad(int edad) throws IllegalArgumentException {
        if (edad>=0)
            this.edad = edad;
    }

    public void setDni(String dni) {
        if (esCorrectoNIF(dni))
            this.dni=dni;
        else
            this.dni="SinDNI";
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws IllegalArgumentException {
        if (!nombre.isEmpty())
            this.nombre = nombre;
        else
            throw new IllegalArgumentException("El nombre no uede estar vacio");
    }
}
