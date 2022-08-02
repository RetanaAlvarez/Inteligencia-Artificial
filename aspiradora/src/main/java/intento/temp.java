package intento;

public class temp {
String b[][]=null;
    public static void main(String[] args) {
        Matriz Ma;
        
        
        /*-------------hacer tabla----------------
    default  void tabla_temperatura(double a[][], double b, double c) {
        Matriz m;
        m.registros(a);
        for (int i = 0; i < a.length; i++) {

            b = b + Integer.parseInt(m.registros(a[i][2]));
            c = b / a.length;
        }
         */
    }

}
/*
        System.out.println("-----------------------------Temperatura  (la media es= " + Math.round(mediatotal) + ")---------------------------------------------");
        System.out.println();
        /*----------tabla de Temperatura--------------------------------
        for (int i = 0; i < registros.length; i++) {
            if (Integer.parseInt(registros[i][2]) < mediatotal) {
                menor74 = menor74 + 1;
                if (registros[i][5] == "No jugar") {
                    menorc1 = menorc1 + 1;
                } else {
                    menorc2 = menor74 - menorc1;
                }
            } else if (Integer.parseInt(registros[i][2]) >= mediatotal) {
                mayor74 = mayor74 + 1;
                if (registros[i][5] == "No jugar") {
                    mayorc1 = mayorc1 + 1;
                } else {
                    mayorc2 = mayor74 - mayorc1;
                }
            }
        }
        /*-------------------tabla de Temperatura-------------------
        System.out.println("\t #_int\tC1\tC2");
        System.out.println(" >" + Math.round(mediatotal) + "\t" + menor74 + "\t" + Math.round(menorc1) + "\t" + Math.round(menorc2)
                + "\n<=" + Math.round(mediatotal) + "\t" + mayor74 + "\t" + Math.round(mayorc1) + "\t" + Math.round(mayorc2));
        /*-------------------------<74-------------------
        System.out.println(">74");
        menorN1 = menorc1 / menor74;
        menorN2 = menorc2 / menor74;
        System.out.println("Nm=" + menor74 + "\nN1=" + Math.round(menorc1) + ", P1=(" + Math.round(menorc1) + "/" + menor74 + ")= " + df.format(menorN1));
        System.out.println("N1=" + Math.round(menorc2) + ", P1=(" + Math.round(menorc2) + "/" + menor74 + ")= " + df.format(menorN2));
        IMmayor74 = -((menorN1 * (Math.log(menorN1) / Math.log(2))) + (menorN2 * (Math.log(menorN2) / Math.log(2))));
        System.out.println("Im=" + IMmayor74);
        System.out.println();

        /*------------------------->=74--------------------
        System.out.println(">=74");
        mayorN1 = mayorc1 / mayor74;
        mayorN2 = mayorc2 / mayor74;
        System.out.println("Nm=" + mayor74 + "\nN1=" + Math.round(mayorc1) + ", P1=(" + Math.round(mayorc1) + "/" + mayor74 + ")= " + df.format(mayorN1));
        System.out.println("N1=" + Math.round(mayorc2) + ", P1=(" + Math.round(mayorc2) + "/" + mayor74 + ")= " + df.format(mayorN2));
        IMmenor74 = -((mayorN1 * (Math.log(mayorN1) / Math.log(2))) + (mayorN2 * (Math.log(mayorN2) / Math.log(2))));
        System.out.println("Im=" + IMmenor74);
    
    /*----------------------------------media de temperatura------------------*/
