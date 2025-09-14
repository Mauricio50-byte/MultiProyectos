package Parcial_Corte3;
//Crear un programa que por medio de herencia calcule la cantidad de años y calcule: 
//1. cantidad de meses en un metodo
//2. semanas
//3. horas

class Tiempo {
    protected int anios;

    public Tiempo(int anios) {
        this.anios = anios;
    }

    public int getAnios() {
        return anios;
    }
}

class Meses extends Tiempo {
    public Meses(int anios) {
        super(anios);
    }

    public int calcularMeses() {
        return anios * 12;
    }
}


class Semanas extends Tiempo {
    public Semanas(int anios) {
        super(anios);
    }

    public int calcularSemanas() {
        return anios * 52; 
    }
}

class Horas extends Tiempo {
    public Horas(int anios) {
        super(anios);
    }

    public int calcularHoras() {
        return anios * 365 * 24; 
    }
}

public class Parciasl {
    public static void main(String[] args) {
        int anios = 5; 

        Meses meses = new Meses(anios);
        Semanas semanas = new Semanas(anios);
        Horas horas = new Horas(anios);

        System.out.println("Años: " + anios);
        System.out.println("Meses: " + meses.calcularMeses());
        System.out.println("Semanas: " + semanas.calcularSemanas());
        System.out.println("Horas: " + horas.calcularHoras());
    }
}
