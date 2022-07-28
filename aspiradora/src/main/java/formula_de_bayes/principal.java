package formula_de_bayes;

public class principal {

    public static void main(String[] args) {
        String c1 = "No jugar", c2 = "Jugar";
        int soleado = 0, soleadoc1 = 0, soleadoc2 = 0;
        int nublado = 0, nubladoc1 = 0, nubladoc2 = 0;
        int lluvioso = 0, lluviosoc1 = 0, lluviosoc2 = 0;
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
            {"10", "lluvio", "75", "80", "no", "Jugar"}};
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
        System.out.println("Estado General");
        for (int i = 0; i < registros.length; i++) {
            for (int j = 0; j < registros[i].length; j++) {
                if (registros[i][j] == "soleado") {
                    soleado = soleado + 1;
                    if (registros[i][j] == "No jugar") {
                        soleadoc1 = soleadoc1 + 1;
                    } else if (registros[i][j] == "Jugar") {
                        soleadoc2 = soleadoc2 + 1;
                    }
                } else if (registros[i][j] == "Nublado") {
                    nublado = nublado + 1;
                    /*if (registros[i][j] == "No jugar") {
                        nubladoc1 = nubladoc1 + 1;
                    } else if (registros[i][j] == " jugar") {
                        nubladoc2 = nubladoc2 + 1;
                    }*/
                } else if (registros[i][j] == "lluvio") {
                    lluvioso = lluvioso + 1;
                    /*if (registros[i][j] == "soleado"&&registros[i][j] == "No jugar") {
                        lluviosoc1 = lluviosoc1 + 1;
                    } else if (registros[i][j] == "soleado"&&registros[i][j] == " jugar"){
                        lluviosoc2 = lluviosoc2 + 1;
                    }*/
                }
            }
        }
        System.out.println("\t #_int\tC1\tC2");
        System.out.println("soleado= " + soleado+"\t"+soleadoc1+"\t"+soleadoc2
                + "\nnublado= " + nublado+"\t"+nubladoc1+"\t"+nubladoc2
                + "\nlluvioso= " + lluvioso+"\t"+lluviosoc1+"\t"+lluviosoc2);

    }
}
