package com.JDER.x00138218;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continu = true, continu2 = true;
        int mesesSP = 0;

        System.out.println("-----------------------------------------------------------------------------------------");
        // Para Servicio Profesional

        ServicioProfesional servicioPro = null;
        do {
            try {
                System.out.println("    Empleado de Servicio Profesional");

                // Pidiendo datos al usuario
                System.out.println("Digite el nombre del empleado: ");
                String nameSP = in.nextLine().toLowerCase();
                if(nameSP.isEmpty() || nameSP.replaceAll("\\s+","").isEmpty()){
                    throw new FieldIsEmptyException("El campo esta vacio, intente nuevamente");
                }else{
                    if(verifyIsNumber(nameSP) == true){
                        throw new EntryIsInvalidException("Estimado usuario lo que ingreso es invalido");
                    }
                }

                System.out.println("Digite el puesto de trabajo de " + nameSP + ": ");
                String jobSP = in.nextLine();
                if(jobSP.isEmpty() || jobSP.replaceAll("\\s+","").isEmpty()){
                    throw new FieldIsEmptyException("El campo esta vacio, intente nuevamente");
                }else{
                    if(verifyIsNumber(jobSP) == true){
                        throw new EntryIsInvalidException("Estimado usuario lo que ingreso es invalido");
                    }
                }

                System.out.println("Digite el salario del empleado: ");
                double SalarySP = in.nextDouble(); in.nextLine();
                if(SalarySP < 0){
                    throw new EntryIsInvalidException("Estimado usuario lo que ingreso es invalido");
                }

                System.out.println("Digite la cantidad de meses que estara trabajando: ");
                int months = in.nextInt(); in.nextLine();
                mesesSP = months;
                if(SalarySP < 1){
                    throw new EntryIsInvalidException("Estimado usuario lo que ingreso es invalido");
                }

                servicioPro = new ServicioProfesional(nameSP, jobSP, SalarySP, months);
                continu = false;
            }
            catch (FieldIsEmptyException ex){
                System.out.println(ex.getMessage());
            }
            catch (EntryIsInvalidException  ex){
                System.out.println(ex.getMessage());
                in.nextLine();
                continu = true;
            }
            catch (InputMismatchException ex){
                in.nextLine();
                System.out.println("Estimado usuario, usted a ingresado caracteres no numericos");
                System.out.println("Intente de nuevo...");
                continu = true;
            }

        }while(continu);

        System.out.println("-----------------------------------------------------------------------------------------");
        // Para Plaza Fija

        PlazaFija plazaFij = null;
        do {

            try {
                System.out.println("    Empleado de Plaza Fija");

                // Pidiendo datos al usuario
                System.out.println("Digite el nombre del empleado: ");
                String namePF = in.nextLine();
                if(namePF.isEmpty() || namePF.replaceAll("\\s+","").isEmpty()){
                    throw new FieldIsEmptyException("El campo esta vacio, intente nuevamente");
                }else{
                    if(verifyIsNumber(namePF) == true){
                        throw new EntryIsInvalidException("Estimado usuario lo que ingreso es invalido");
                    }
                }

                System.out.println("Digite el puesto de trabajo de " + namePF + ": ");
                String jobPF = in.nextLine();
                if(jobPF.isEmpty() || jobPF.replaceAll("\\s+","").isEmpty()){
                    throw new FieldIsEmptyException("El campo esta vacio, intente nuevamente");
                }else{
                    if(verifyIsNumber(jobPF) == true){
                        throw new EntryIsInvalidException("Estimado usuario lo que ingreso es invalido");
                    }
                }

                System.out.println("Digite el Salario del empleado: ");
                double SalaryPF = in.nextDouble(); in.nextLine();
                if(SalaryPF < 0){
                    throw new EntryIsInvalidException("Estimado usuario lo que ingreso es invalido");
                }

                System.out.println("Digite la extension de " + namePF + " ");
                int extension = in.nextInt(); in.nextLine();
                if(extension < 0){
                    throw new EntryIsInvalidException("Estimado usuario lo que ingreso es invalido");
                }

                plazaFij = new PlazaFija(namePF, jobPF, SalaryPF, extension);
                continu2 = false;
            }
            catch (FieldIsEmptyException ex){
                System.out.println(ex.getMessage());
            }
            catch (EntryIsInvalidException  ex){
                System.out.println(ex.getMessage());
                in.nextLine();
                continu2 = true;
            }
            catch (InputMismatchException ex){
                in.nextLine();
                System.out.println("Estimado usuario, usted a ingresado caracteres no numericos");
                System.out.println("Intente de nuevo...");
                continu2 = true;
            }

        }while(continu2);

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("    Pagos Respectivos Mensual");
        System.out.println("");
        System.out.println(servicioPro.getNombre() + " --------- $" + CalculadoraImpuestos.calcularPago(servicioPro));
        System.out.println(servicioPro.toString());

        System.out.println("");
        System.out.println(plazaFij.getNombre() + " --------- $" + CalculadoraImpuestos.calcularPago(plazaFij));
        System.out.println(plazaFij.toString());

        System.out.println("");
        System.out.println(CalculadoraImpuestos.mostrarTotales());


        System.out.println("| ------------------------------------------------------------------------------------- |");
        System.out.println("                            Algo extra en el programa....                  ");
        System.out.println("  ya que el empleado por Servicio profesional trabajara " + mesesSP + " meses en total ");
        System.out.println("  Devengara: $" + mesesSP * CalculadoraImpuestos.calcularPago(servicioPro));
    }

    public static boolean verifyIsNumber(String cadena) {
        boolean result = false;

        try {
            Integer.parseInt(cadena);
            result = true;

        } catch (Exception ex) {
            result = false;
        }

        return result;
    }


}
