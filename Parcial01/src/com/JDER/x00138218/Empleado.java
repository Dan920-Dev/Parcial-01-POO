package com.JDER.x00138218;

public abstract class Empleado {
    protected String nombre;
    protected String puesto;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
