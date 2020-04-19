package com.JDER.x00138218;

public final class CalculadoraImpuestos {
    private static double totalRenta = 0;
    private static double totalISSS = 0;
    private static double totalAFP = 0;

    private CalculadoraImpuestos(){
    }

    public static double calcularPago(Empleado empleado){
        double SalaryLi = 0, rent = 0, AFP = 0, ISSS = 0;

        // para empleado de servicio Profesional, solo se descuenta el 10% de renta
        if (empleado instanceof ServicioProfesional){
            rent = 0.1 * empleado.getSalario();
            SalaryLi = empleado.getSalario() - rent;
        }

        // para empleado de Plaza Fija, se calcula afp, isss y reta.
        if (empleado instanceof PlazaFija){
            double resto = 0;

            AFP = 0.0625 * empleado.getSalario();
            ISSS = 0.03 * empleado.getSalario();
            resto = empleado.getSalario() - AFP - ISSS;

            // En base al restante se calcula la renta
            if(resto >= 0.01 && resto <= 472)
                rent = 0;
            else if(resto >= 472.01 && resto <= 895.24)
                rent = (0.1) * (resto - 472) + 17.67;
            else if(resto >= 895.25 && resto <= 2038.10)
                rent = (0.2) * (resto - 895.24) + 60;
            else if(resto >= 2038.11)
                rent = (0.3) * (resto - 2038.10) + 299.57;

            // pago al empleado
            SalaryLi = resto - rent; SalaryLi = Math.round(SalaryLi * 100.0) / 100.0;
        }

        totalRenta =totalRenta + rent; totalRenta = Math.round(totalRenta * 100.0) / 100.0;

        totalISSS = totalISSS + ISSS; totalISSS = Math.round(totalISSS * 100.0) / 100.0;

        totalAFP= totalAFP + AFP; totalISSS = Math.round(totalAFP * 100.0) / 100.0;

        return SalaryLi;
    }

    public static String mostrarTotales(){
        return "  Total de Impuestos\n " + "-Renta Total: $" + totalRenta + "\n -ISSS Total: $" + totalISSS + "\n -AFP Total: $" + totalAFP;
    }

}
