package model;

public class Profesor extends Persona{

    //PROPIEDADES
    private int sueldo;

    //CONSTRUCTOR
    public Profesor(String dni, String nombre, int sueldo, int edad){
        super(dni,nombre,edad);
        if (sueldo<0)
            this.sueldo=0;
        else
            this.sueldo=sueldo;
    }

    //METODOS
    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        if (sueldo<0)
            this.sueldo=0;
        else
            this.sueldo=sueldo;
    }
}
