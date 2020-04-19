package com.JDER.x00138218;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continu = true;

        do {

                //-----------------------------------------------------------------------------------------
                // Para Servicio Profesional
                System.out.println("    Empleado de Servicio Profesional");

                // Pidiendo datos al usuario
                System.out.println("Digite el nombre del empleado: ");
                String nameSP = in.nextLine();
                System.out.println("Digite el puesto de trabajo de " + nameSP + ": ");
                String jobSP = in.nextLine();
                System.out.println("Digite el nombre del empleado: ");
                double SalarySP = in.nextDouble(); in.nextLine();
                System.out.println("Digite el nombre del empleado: ");
                int months = in.nextInt(); in.nextLine();

                ServicioProfesional servicioPro = new ServicioProfesional(nameSP, jobSP, SalarySP, months);
                //-----------------------------------------------------------------------------------------
                // Para plaza Fija

                System.out.println("    Empleado de Plaza Fija");

                // Pidiendo datos al usuario
                System.out.println("Digite el nombre del empleado: ");
                String namePF = in.nextLine();
                System.out.println("Digite el puesto de trabajo de " + namePF + ": ");
                String jobPF = in.nextLine();
                System.out.println("Digite el nombre del empleado: ");
                double SalaryPF = in.nextDouble(); in.nextLine();
                System.out.println("Digite el nombre del empleado: ");
                int extension = in.nextInt(); in.nextLine();

                PlazaFija plazaFij = new PlazaFija(namePF, jobPF, SalaryPF, extension);

        }while(continu);
    }

}
