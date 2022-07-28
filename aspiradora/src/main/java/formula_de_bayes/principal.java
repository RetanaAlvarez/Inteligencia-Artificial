package formula_de_bayes;

import java.util.logging.*;

public class principal {

    public static void main(String[] args) {
        //variable globales
        String c1 = "No jugar", c2 = "Jugar";
        double IM;
        //variables para estado general
        int soleado = 0, nublado = 0, lluvioso = 0;
        double nuN1 = 0, nuN2 = 0, nubladoc1 = 0, nubladoc2 = 0,
                solN1 = 0, solN2 = 0, soleadoc1 = 0, soleadoc2 = 0,
                lluN1 = 0, lluN2 = 0, lluviosoc1 = 0, lluviosoc2 = 0;
        //variable de temperatura
        double media = 0, mediatotal = 0,
                menor74 = 0, menorc1 = 0, menorc2 = 0, menorN1 = 0, menorN2 = 0,
                mayor74 = 0, mayorc1 = 0, mayorc2 = 0, mayorrN1 = 0, mayorN2 = 0,
                temperatura = 0;

        String[] campos = {"#_inst", "Estado", "Tempe", "Humedad", "viento", "Clase"};
        String[][] registros = {
            {"1", "soleado", "85", "85", "No", "No jugar"},
            {"2", "soleado", "80", "90", "Si", "No jugar"},
            {"3", "Nublado", "83", "78", "No", "Jugar"},
            {"4", "lluvio", "70", "96", "No", "Jugar"},
            {"5", "lluvio", "68", "80", "No", "Jugar"},
            {"6", "lluvio", "65", "70", "Si", "No jugar"},
            {"7", "Nublado", "64", "65", "Si", "Jugar"},
            {"8", "soleado", "72", "95", "No", "No jugar"},
            {"9", "soleado", "69", "70", "No", "Jugar"},
            {"10", "lluvio", "75", "80", "no", "Jugar"},
            {"11", "soleado", "75", "70", "Si", "Jugar"},
            {"12", "Nublado", "72", "90", "Si", "jugar"},
            {"13", "Nublado", "81", "75", "No", "Jugar"},
            {"14", "lluvio", "71", "80", "Si", "No jugar"}};
        for (int x = 0; x < campos.length; x++) {
            System.out.print(campos[x] + "\t");
        }
        System.out.println();
        for (int i = 0; i < registros.length; i++) {
            for (int j = 0; j < registros[i].length; j++) {
                System.out.print(registros[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n1.- Numero de instancias es " + registros.length);
        System.out.println("\n2.- Conjunto de clases\nc1=" + c1 + ", c2=" + c2);
        System.out.println();
        System.out.println("-----------------------------Estado General---------------------------------------------");
        for (int i = 0; i < registros.length; i++) {
            for (int j = 0; j < registros[i].length; j++) {
                if (registros[i][j] == "soleado") {

                    soleado = soleado + 1;
                    if (registros[i][5] == "No jugar") {
                        soleadoc1 = soleadoc1 + 1;
                    } else {
                        soleadoc2 = soleado - soleadoc1;
                    }

                } else if (registros[i][j] == "Nublado") {
                    nublado = nublado + 1;
                    if (registros[i][5] == "No jugar") {
                        nubladoc1 = nubladoc1 + 1;
                    } else {
                        nubladoc2 = nublado - nubladoc1;
                    }
                } else if (registros[i][j] == "lluvio") {
                    lluvioso = lluvioso + 1;
                    if (registros[i][5] == "No jugar") {
                        lluviosoc1 = lluviosoc1 + 1;
                    } else {
                        lluviosoc2 = lluvioso - lluviosoc1;
                    }
                }
            }
        }
        System.out.println("\t #_int\tC1\tC2");
        System.out.println("soleado= " + soleado + "\t" + Math.round(soleadoc1) + "\t" + Math.round(soleadoc2)
                + "\nnublado= " + nublado + "\t" + Math.round(nubladoc1) + "\t" + Math.round(nubladoc2)
                + "\nlluvioso=" + lluvioso + "\t" + Math.round(lluviosoc1) + "\t" + Math.round(lluviosoc2));
        /*--------------soleado-----------------*/
        System.out.println("\n*Soleado");
        solN1 = soleadoc1 / soleado;
        solN2 = soleadoc2 / soleado;
        System.out.println("Nm=" + soleado + "\nN1=" + Math.round(soleadoc1) + ", P1=(" + Math.round(soleadoc1) + "/" + soleado + ")= " + solN1);
        System.out.println("N2=" + Math.round(soleadoc2) + ", P2=(" + Math.round(soleadoc2) + "/" + soleado + ")= " + solN2);

        IM = -((solN1 * (Math.log(solN1) / Math.log(2))) + (solN2 * (Math.log(solN2) / Math.log(2))));
        System.out.println("Im=" + IM);

        /*--------------nublado-----------------*/
        System.out.println("\n*Nublado");
        nuN1 = nubladoc1 / nublado;
        nuN2 = nubladoc2 / nublado;
        System.out.println("Nm=" + nublado + "\nN1=" + Math.round(nubladoc1) + ", P1=(" + Math.round(nubladoc1) + "/" + nublado + ")= " + nuN1);
        System.out.println("N2=" + Math.round(nubladoc2) + ", P2=(" + Math.round(nubladoc2) + "/" + nublado + ")= " + nuN2);

        IM = -((nuN1 * (Math.log(nuN1) / Math.log(2))) + (nuN2 * (Math.log(nuN2) / Math.log(2))));
        System.out.println("Im=" + IM);

        /*--------------lluvioso-----------------*/
        System.out.println("\n*Nublado");
        lluN1 = lluviosoc1 / lluvioso;
        lluN2 = lluviosoc2 / lluvioso;
        System.out.println("Nm=" + lluvioso + "\nN1=" + Math.round(lluviosoc1) + ", P1=(" + Math.round(lluviosoc1) + "/" + lluvioso + ")= " + lluN1);
        System.out.println("N2=" + Math.round(lluviosoc2) + ", P2=(" + Math.round(lluviosoc2) + "/" + lluvioso + ")= " + lluN2);

        IM = -((lluN1 * (Math.log(lluN1) / Math.log(2))) + (lluN2 * (Math.log(lluN2) / Math.log(2))));
        System.out.println("Im=" + IM);
        /*-------------------------Temperatura----------------------*/

        for (int i = 0; i < registros.length; i++) {
            media = media + Integer.parseInt(registros[i][2]);
            mediatotal = media / registros.length;
        }

        System.out.println("-----------------------------Temperatura  (la media es= " + Math.round(mediatotal) + ")---------------------------------------------");
        System.out.println();
        /*----------tabla--------------------------------*/
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
        System.out.println("\t #_int\tC1\tC2");
        System.out.println(" <" + Math.round(mediatotal) + "\t" + menor74 + "\t" + Math.round(menorc1) + "\t" + Math.round(menorc2)
                + "\n>=" + Math.round(mediatotal) + "\t" + mayor74 + "\t" + Math.round(mayorc1) + "\t" + Math.round(mayorc2));
        /*-------------------------<74--------------------*/
        System.out.println("<74");
        
        menorN1 = menorc1 / menor74;
        menorN2 = menorc2 / menor74;
        System.out.println("Nm=" + menor74 + "\nN1=" + Math.round(menorc1) + ", P1=(" + Math.round(menorc2) + "/" + menor74 + ")= " + menorN1);
        System.out.println("N1=" + Math.round(menorc2) + ", P1=(" + Math.round(menorc2) + "/" + menor74 + ")= " + menorN2);

        IM = -((solN1 * (Math.log(solN1) / Math.log(2))) + (solN2 * (Math.log(solN2) / Math.log(2))));
        System.out.println("Im=" + IM);

    }//fin del main
}//fin de la clase
