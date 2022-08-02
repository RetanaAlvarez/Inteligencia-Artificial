
package intento;

import java.text.DecimalFormat;
import java.lang.*;

public class principal_1 {
    
    public static void main(String[] args) {
        //variable globales
        String c1 = "No jugar", c2 = "Jugar";
        DecimalFormat df = new DecimalFormat("###.#");
        double media = 0, mediatotal = 0, menorc1 = 0, menorc2 = 0, menorN1 = 0, menorN2 = 0, mayorc1 = 0, mayorc2 = 0, mayorN1 = 0, mayorN2 = 0;;

        //variables para estado general
        double soleado = 0, nublado = 0, lluvioso = 0, viento=0, viento2=0;
        double nuN1 = 0, nuN2 = 0, nubladoc1 = 0, nubladoc2 = 0,
                solN1 = 0, solN2 = 0, soleadoc1 = 0, soleadoc2 = 0,
                lluN1 = 0, lluN2 = 0, lluviosoc1 = 0, lluviosoc2 = 0,
                vieN1 = 0, vieN2 = 0, vientoc1= 0, vientoc2 =0,
                viento2c1= 0, viento2c2 =0;        
                
        double IMsol = 0, IMnub = 0, IMllu = 0, IMTem =0,
               IMTem2 = 0,IMHum = 0,IMHum2= 0, 
               IMVie=0, IMVie2 = 0;
        //variable de temperatura
        double menor74 = 0, mayor74 = 0;
        //variable  de humedad
        double menor80 = 0, mayor80 = 0;

        String[] campos = {"#_inst", "Estado", "Tempe", "Humedad", "viento", "Clase"};
        String[][] registros = {
            {"1",   "soleado",  "85", "85", "No", "No jugar"},
            {"2",   "soleado",  "80", "90", "Si", "No jugar"},
            {"3",   "Nublado",  "83", "78", "No", "Jugar"},
            {"4",   "lluvio",   "70", "96", "No", "Jugar"},
            {"5",   "lluvio",   "68", "80", "No", "Jugar"},
            {"6",   "lluvio",   "65", "70", "Si", "No jugar"},
            {"7",   "Nublado",  "64", "65", "Si", "Jugar"},
            {"8",   "soleado",  "72", "95", "No", "No jugar"},
            {"9",   "soleado",  "69", "70", "No", "Jugar"},
            {"10",  "lluvio",   "75", "80", "No", "Jugar"},
            {"11",  "soleado",  "75", "70", "Si", "Jugar"},
            {"12",  "Nublado",  "72", "90", "Si", "Jugar"}};/*
            {"13",  "Nublado",  "81", "75", "No", "Jugar"},
            {"14",  "lluvio",   "71", "80", "Si", "No Jugar"}};*/
        //Impresión de campos
        for (int x = 0; x < campos.length; x++) {
            System.out.print(campos[x] + "\t");
        }
        System.out.println();
        
        //Impresión de registros
        for (int i = 0; i < registros.length; i++) {
            for (int j = 0; j < registros[i].length; j++) {
                System.out.print(registros[i][j] + "\t");
            }
            System.out.println();
        }
        
        double todos_registros = registros.length;
        //Impresión de pasos
        System.out.println("\n1.- Numero de instancias es:\n" + todos_registros);
        System.out.println("\n2.- Conjunto de clases\nc1=" + c1 + ", \nc2=" + c2);
        System.out.println();
        
        System.out.println("-----------------------------Estado General---------------------------------------------\n");
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
        System.out.println("soleado  =  " + Math.round(soleado) + "\t" + Math.round(soleadoc1) + "\t" + Math.round(soleadoc2)
                        + "\nnublado  =  "+ Math.round(nublado) + "\t" + Math.round(nubladoc1) + "\t" + Math.round(nubladoc2)
                        + "\nlluvioso =  "+ Math.round(lluvioso) + "\t" + Math.round(lluviosoc1) + "\t" + Math.round(lluviosoc2));
       
        /*--------------soleado estado general-----------------*/
        System.out.println("\n*Soleado");
        solN1 = soleadoc1 / soleado;
        solN2 = soleadoc2 / soleado;
        System.out.println("Nm=" + Math.round(soleado) + "\nN1=" + Math.round(soleadoc1) + ", P1=(" + Math.round(soleadoc1) + "/" + Math.round(soleado) + ")= " + solN1);
        System.out.println("N2=" + Math.round(soleadoc2) + ", P2=(" + Math.round(soleadoc2) + "/" + Math.round(soleado) + ")= " + solN2);
    
    if(solN1 == 0 || solN2 == 0 || solN1 == 1 || solN2 == 1){
        IMsol = 0;
        System.out.println("Im es puro =" + IMsol);
        
    }else {
        IMsol = -((solN1 * (Math.log(solN1) / Math.log(2))) + (solN2 * (Math.log(solN2) / Math.log(2))));
        System.out.println("Im= " + IMsol);
    }
    
        /*--------------nublado estado general-----------------*/
        System.out.println("\n*Nublado");
        nuN1 = nubladoc1 / nublado;
        nuN2 = nubladoc2 / nublado;
        System.out.println("Nm=" + Math.round(nublado) + "\nN1=" + Math.round(nubladoc1) + ", P1=(" + Math.round(nubladoc1) + "/" + Math.round(nublado) + ")= " + nuN1);
        System.out.println("N2=" + Math.round(nubladoc2) + ", P2=(" + Math.round(nubladoc2) + "/" + Math.round(nublado) + ")= " + nuN2);
    
    if(nuN1 == 0 || nuN2 == 0 || nuN1 == 1 || nuN2 == 1){
        IMnub = 0;
        System.out.println("Im es puro = " + IMnub);
        
    }else {
        IMnub = -((nuN1 * (Math.log(nuN1) / Math.log(2))) + (nuN2 * (Math.log(nuN2) / Math.log(2))));
        System.out.println("Im= " + IMnub);
    }

        /*--------------lluvioso estado general-----------------*/
        System.out.println("\n*Lluvioso");
        lluN1 = lluviosoc1 / lluvioso;
        lluN2 = lluviosoc2 / lluvioso;
        System.out.println("Nm=" + Math.round(lluvioso) + "\nN1=" + Math.round(lluviosoc1) + ", P1=(" + Math.round(lluviosoc1) + "/" + Math.round(lluvioso) + ")= " + lluN1);
        System.out.println("N2=" + Math.round(lluviosoc2) + ", P2=(" + Math.round(lluviosoc2) + "/" + Math.round(lluvioso) + ")= " + lluN2);

    if(lluN1 == 0 || lluN2 == 0 || lluN1 == 1 || lluN2 == 1){
        IMllu = 0;
        System.out.println("Im es puro = " + IMllu);
        
    }else {
        IMllu = -((lluN1 * (Math.log(lluN1) / Math.log(2))) + (lluN2 * (Math.log(lluN2) / Math.log(2))));
        System.out.println("Im= " + IMllu);
    }

/*-------------------------Temperatura----------------------*/

        for (int i = 0; i < registros.length; i++) {
            media = media + Integer.parseInt(registros[i][2]);
            mediatotal = media / registros.length;
        }

        System.out.println("\n-------------------Temperatura para estado general  (la media es= " + Math.round(mediatotal) + ")----------------------------------");
        System.out.println();
        
        /*----------tabla de temperatura de lo general------------------------------*/
        for (int i = 0; i < registros.length; i++) {
            if (Integer.parseInt(registros[i][2]) < Math.round(mediatotal)) {
                menor74 = menor74 + 1;
                if (registros[i][5] == "No jugar") {
                    menorc1 = menorc1 + 1;
                } else {
                    menorc2 = menor74 - menorc1;
                }
            } else if (Integer.parseInt(registros[i][2]) >= Math.round(mediatotal)) {
                mayor74 = mayor74 + 1;
                if (registros[i][5] == "No jugar") {
                    mayorc1 = mayorc1 + 1;
                } else {
                    mayorc2 = mayor74 - mayorc1;
                }
            }
        }
        
        System.out.println("\t#_int\tC1\tC2");
        System.out.println("<" + Math.round(mediatotal) + "\t" + Math.round(menor74) + "\t" + Math.round(menorc1) + "\t" + Math.round(menorc2)
                + "\n>=" + Math.round(mediatotal) + "\t" + Math.round(mayor74) + "\t" + Math.round(mayorc1) + "\t" + Math.round(mayorc2));
        
        
        /*-------------------------<74--------------------*/
        System.out.println("\n<"+Math.round(mediatotal));
        
        menorN1 = menorc1 / menor74;
        menorN2 = menorc2 / menor74;
        
        System.out.println("Nm=" + menor74 + "\nN1=" + Math.round(menorc1) + ", P1=(" + Math.round(menorc1) + "/" + Math.round(menor74) + ")= " + menorN1);
        System.out.println("N2=" + Math.round(menorc2) + ", P2=(" + Math.round(menorc2) + "/" + df.format(menor74) + ")= " + menorN2);
        
        
    if(menorN1 == 0 || menorN2 == 0 || menorN1 == 1 || menorN2 == 1){
        IMTem = 0;
        System.out.println("Im es puro = " + IMTem);
    }else{
        
        IMTem = -((menorN1 * (Math.log(menorN1) / Math.log(2))) + (menorN2 * (Math.log(menorN2) / Math.log(2))));
        System.out.println("Im= " + IMTem);
        System.out.println();
    }

        /*------------------------->=74--------------------*/
 
        System.out.println(">="+Math.round(mediatotal));
        mayorN1 = mayorc1 / mayor74;
        mayorN2 = mayorc2 / mayor74;
        
        System.out.println("Nm=" + mayor74 + "\nN1=" + Math.round(mayorc1) + ", P1=(" + Math.round(mayorc1) + "/" + df.format(mayor74) + ")= " + mayorN1);
        System.out.println("N2=" + Math.round(mayorc2) + ", P2=(" + Math.round(mayorc2) + "/" + Math.round(mayor74) + ")= " + mayorN2);
        
    if(mayorN1 == 0 || mayorN2 == 0 || mayorN1 == 1 || mayorN2 == 1){
        IMTem2 = 0;
        System.out.println("Im es puro = " + IMTem2);
    }else{
        IMTem2 = -((mayorN1 * (Math.log(mayorN1) / Math.log(2))) + (mayorN2 * (Math.log(mayorN2) / Math.log(2))));
        System.out.println("Im= " + IMTem2);
    }

        
/*-------------------------Humedad de lo general---------------------*/        
        media=0; mediatotal = 0;
        
        for (int i = 0; i < registros.length; i++) {
            media = media + Integer.parseInt(registros[i][3]);
            mediatotal = media / registros.length;
        }
        System.out.println("\n-------------------Humedad para estado general  (la media es= " + Math.round(mediatotal) + ")---------------------\n");
        
menorc1 = 0;menorc2 = 0;menorN1 = 0;menorN2 = 0;mayorc1 = 0;mayorc2 = 0;mayorN1 = 0;mayorN2 = 0;
    
        /*----------tabla--------------------------------*/
        for (int i = 0; i < registros.length; i++) {
            if (Integer.parseInt(registros[i][3]) < Math.round(mediatotal)) {
                menor80 = menor80 + 1;
                if (registros[i][5] == "No jugar") {
                    menorc1 = menorc1 + 1;
                } else {
                    menorc2 = menor80 - menorc1;
                }
            } else if (Integer.parseInt(registros[i][3]) >= Math.round(mediatotal)) {
                mayor80 = mayor80 + 1;
                if (registros[i][5] == "No jugar") {
                    mayorc1 = mayorc1 + 1;
                } else {
                    mayorc2 = mayor80 - mayorc1;
                }
            }

        }
        System.out.println("\t#_int\tC1\tC2");
        System.out.println(" <" + Math.round(mediatotal) + "\t" + Math.round(menor80) + "\t" + Math.round(menorc1) + "\t" + Math.round(menorc2)
                + "\n>=" + Math.round(mediatotal) + "\t" + Math.round(mayor80) + "\t" + Math.round(mayorc1) + "\t" + Math.round(mayorc2));
        
        /*-------------------------<80--------------------*/
        System.out.println("\n<80");

        menorN1 = menorc1 / menor80;
        menorN2 = menorc2 / menor80;
        System.out.println("Nm=" + menor80 + "\nN1=" + Math.round(menorc1) + ", P1=(" + Math.round(menorc1) + "/" + Math.round(menor80) + ")= " + menorN1);
        System.out.println("N2=" + Math.round(menorc2) + ", P2=(" + Math.round(menorc2) + "/" + Math.round(menor80) + ")= " + menorN2);
    
    if(menorN1 == 0 || menorN2 == 0){
        IMHum = 0;
        System.out.println("Im es puro = " + IMHum);
    }else{
        
        IMHum = -((menorN1 * (Math.log(menorN1) / Math.log(2))) + (menorN2 * (Math.log(menorN2) / Math.log(2))));
        System.out.println("Im= " + IMHum);
        System.out.println();
    }
        /*------------------------->=80--------------------*/
        System.out.println(">=80");
        mayorN1 = mayorc1 / mayor80;
        mayorN2 = mayorc2 / mayor80;
        System.out.println("Nm=" + Math.round(mayor80) + "\nN1=" + Math.round(mayorc1) + ", P1=(" + Math.round(mayorc1) + "/" + Math.round(mayor80) + ")= " + mayorN1);
        System.out.println("N2=" + Math.round(mayorc2) + ", P2=(" + Math.round(mayorc2) + "/" + Math.round(mayor80) + ")= " + mayorN2);
   
    if(menorN1 == 0 || menorN2 == 0 || menorN1 == 1 || menorN2 == 1){
        IMHum2 = 0;
        System.out.println("Im es puro = " + IMHum2);
    }else{
        IMHum2 = -((mayorN1 * (Math.log(mayorN1) / Math.log(2))) + (mayorN2 * (Math.log(mayorN2) / Math.log(2))));
        System.out.println("Im= " + IMHum2);
    }
        
/*-------------------------VIENTO de lo general---------------------*/        
        System.out.println("\n-------------------Viento para estado general---------------------------------------------\n");
        for (int i = 0; i < registros.length; i++) {
            //for (int j = 0; j < registros[i].length; j++) {
                if (registros[i][4] == "Si") {

                    viento = viento + 1;
                    
                    if (registros[i][5] == "No jugar") {
                    
                        vientoc1 = vientoc1 + 1;
                    
                    } else {
                        
                        vientoc2 = viento - vientoc1;
                    }

                } else if (registros[i][4] == "No") {
                    viento2 = viento2 + 1;
                    
                    if (registros[i][5] == "No jugar") {
                        viento2c1 = viento2c1 + 1;
                    } else {
                        viento2c2 = viento2 - viento2c1;
                    }
                }
            //}
        }
        
        System.out.println("\t#_int\tC1\tC2");
        System.out.println("Si =     " + viento + "\t" + vientoc1 + "\t" + vientoc2
                        + "\nNo =     "+ viento2 + "\t" + viento2c1 + "\t" + viento2c2);
        
        /*--------------Si-----------------*/
        System.out.println("\n*Si");
        vieN1 = vientoc1 / viento;
        vieN2 = vientoc2 / viento;
        System.out.println("Nm=" + viento + "\nN1=" + vientoc1 + ", P1=(" + df.format(vientoc1) + "/" + viento + ")= " + vieN1);
        System.out.println("N2=" + vientoc2 + ", P2=(" + df.format(vientoc2) + "/" + viento + ")= " + vieN2);
    
    if(vieN1 == 0 || vieN2 == 0 || vieN1 == 1 || vieN2 == 1){
        IMVie = 0;
        System.out.println("Im es puro = " + IMVie);
        
    }else {
        IMVie = -((vieN1 * (Math.log(vieN1) / Math.log(2))) + (vieN2 * (Math.log(vieN2) / Math.log(2))));
        System.out.println("Im= " + IMVie);
    }
    
    /*--------------No-----------------*/
        double vieN11 = 0, vieN22=0;     
        System.out.println("\n*No");
        vieN11 = viento2c1 / viento2;
        vieN22 = viento2c2 / viento2;
        System.out.println("Nm=" + viento2 + "\nN1=" + viento2c1 + ", P1=(" + df.format(viento2c1) + "/" + viento2 + ")= " + vieN11);
        System.out.println("N2=" + viento2c2 + ", P2=(" + df.format(viento2c2) + "/" + viento2 + ")= " + vieN22);
    
    if(vieN11 == 0 || vieN22 == 0 || vieN11 == 1 || vieN22 == 1){
        IMVie2 = 0;
        System.out.println("Im es puro = " + IMVie2);
        
    }else {
        IMVie2 = -((vieN11 * (Math.log(vieN11) / Math.log(2))) + (vieN22 * (Math.log(vieN22) / Math.log(2))));
        System.out.println("Im= " + IMVie2);
    }

    /*--------------IMPUREZA DE LA DIVISIÓN---------------------------------------------*/
    
    /*____________________________________ESTADO GENERAL*/
        double IMI1 = 0, IMI2 = 0, IMI3 = 0, IMI4 = 0,
                s = 0, n = 0, l =0,
                t1 = 0, t2 = 0,
                h1 = 0, h2 = 0,
                v1 = 0, v2 = 0;
        s = soleado /todos_registros;
        n = nublado /todos_registros;
        l = lluvioso/todos_registros;
        t1 = menor74 / todos_registros;
        t2 = mayor74 / todos_registros;
        h1 = menor80 / todos_registros;
        h2 = mayor80 / todos_registros;
        v1 = viento  / todos_registros;
        v2 = viento2 / todos_registros;
        
        IMI1 = (s*IMsol) + (n*IMnub) + (l*IMllu);
        IMI2 = (t1 * IMTem) + (t2 * IMTem2);
        IMI3 = (h1 * IMHum) + (h2 * IMHum2);
        IMI4 = (v1 * IMVie) + (v2 * IMVie2);
        System.out.println("\n-------------------Impureza de la división---------------------------------------------\n");
        
        System.out.println();
        System.out.println("IMI1 = (((" + df.format(soleado) + "/" + df.format(todos_registros) + ")*" +IMsol+") + ((" +df.format(nublado)+"/" +df.format(todos_registros)+")*"+IMnub+") + (("  +df.format(lluvioso)+"/" +df.format(todos_registros)+")*"+IMllu+"))");
        System.out.println("IMI1_Estado_General =    "+IMI1);
        System.out.println("");
        
        System.out.println("IMI2 = (((" + df.format(menor74) + "/" + df.format(todos_registros) + ")*" +IMTem+") + ((" +df.format(mayor74)+"/" +df.format(todos_registros)+")*"+IMTem2+ "))");
        System.out.println("IMI2_Temperatura =       "+IMI2);
        System.out.println("");
        
        System.out.println("IMI3 = (((" + df.format(menor80) + "/" + df.format(todos_registros) + ")*" +IMHum+") + ((" +df.format(mayor80)+"/" +df.format(todos_registros)+")*"+IMHum2+ "))");
        System.out.println("IMI3_Humedad =           "+IMI3);
        System.out.println();
        
        System.out.println("IMI4 = (((" + df.format(viento) + "/" + df.format(todos_registros) + ")*" +IMVie+") + ((" +df.format(viento2)+"/" +df.format(todos_registros)+")*"+IMVie2+ "))");
        System.out.println("IMI4_Viento =            "+IMI4);
        System.out.println();
        
System.out.println();
    
//SI EL ESTADO GENERAL ES MENOR SE INICIA POR ESE MISMO
    if(IMI1 < IMI2 && IMI1 < IMI3 && IMI1 < IMI4){
        System.out.println("El menor es la opción:  " +IMI1 +" que es el Estado General");
        System.out.println("\n\n______________________________________________________________________");
        System.out.println("\n\t\t\t   Arbolito Yei :)\n");
        System.out.println("______________________________________________________________________\n\n");
        System.out.println("\t\t        -------------------");
        System.out.println("\t\t\t| Estado General  |  -> "+IMI1);
        System.out.println("\t\t        ---------o---------");
        System.out.println("\t\t                 |");
        System.out.println("\t o-----------------------°-----------------------o");
        System.out.println("\t |                       |                       |");
        System.out.println("-> "+IMsol+"\t-> "+IMllu+"\t-> "+IMnub +"\t |");
        System.out.println("\t |                       |                       |");
        System.out.println("---------°--------\t---------°--------\t---------°--------");
        System.out.println("|    Soleado     |\t|    Lluvioso    |\t|    Nublado     |");
        System.out.println("------------------\t------------------\t------------------");
    
//Pausa para las ramas

    if(IMsol ==0 && soleadoc2!= 0){          //Si soleado está en 0 puro
        System.out.println("\t |\n-> 0.0   |\n"+
                           "\t |\n"+
                           "     oooo°oooo \n"+
                           "   o           o \n"+
                           "  o    Jugar    o\n"+
                           "   o           o\n"+
                           "     ooooooooo \n");
    }else if(IMsol == 0 && soleadoc1!=0){    
        System.out.println("\t |\n-> 0.0   |\n"+
                           "\t |\n"+
                           "     oooo°oooo \n"+
                           "   o           o \n"+
                           "  o   No Jugar  o\n"+
                           "   o           o\n"+
                           "     ooooooooo \n");
    }
    
    else if(IMllu == 0 && lluviosoc2 != 0){   //Si lluvioso está en 0 puro
        System.out.println("\t\t\t\t |\n \t\t\t-> 0.0   |\n"+
                           "\t\t\t\t |\n"+
                           "\t\t\t     oooo°oooo \n"+
                           "\t\t\t   o           o \n"+
                           "\t\t\t  o    Jugar    o\n"+
                           "\t\t\t   o           o\n"+
                           "\t\t\t     ooooooooo \n");
    }else if(IMllu == 0 && soleadoc1!=0){    
        System.out.println("\t\t\t\t |\n \t\t\t-> 0.0   |\n"+
                           "\t\t\t\t |\n"+
                           "\t\t\t     oooo°oooo \n"+
                           "\t\t\t   o           o \n"+
                           "\t\t\t  o   No Jugar  o\n"+
                           "\t\t\t   o           o\n"+
                           "\t\t\t     ooooooooo \n");
    }
    
    else if(IMnub == 0 && nubladoc2!=0){ //Si nublado está en 0 puro    
        System.out.println("\r\r\t\t\t\t\t\t\t |\n \t\t\t\t\t\t-> 0.0   |\n"+
                           "\t\t\t\t\t\t\t |\n"+
                           "\t\t\t\t\t\t     oooo°oooo \n"+
                           "\t\t\t\t\t\t   o           o \n"+
                           "\t\t\t\t\t\t  o    Jugar    o\n"+
                           "\t\t\t\t\t\t   o           o\n"+
                           "\t\t\t\t\t\t     ooooooooo \n");
    }else if(IMnub == 0 && nubladoc1!=0){    
        System.out.println("\t\t\t\t\t\t\t |\n \t\t\t\t\t\t-> 0.0   |\n"+
                           "\t\t\t\t\t\t\t |\n"+
                           "\t\t\t\t\t\t     oooo°oooo \n"+
                           "\t\t\t\t\t\t   o           o \n"+
                           "\t\t\t\t\t\t  o   No Jugar  o\n"+
                           "\t\t\t\t\t\t   o           o\n"+
                           "\t\t\t\t\t\t     ooooooooo \n");
    }
//SI SE LLEGARA A INICIAR POR TEMPERATURA
    }else if (IMI2 < IMI1 && IMI2 < IMI3 && IMI2 < IMI4){
        System.out.println("Si se llega a iniciar por temperatura, todavia no hay árbol");
              
//SI SE LLEGARA A INICIAR POR HUMEDAD        
    }else if (IMI3 < IMI1 && IMI3 < IMI2 && IMI3 < IMI4){
        System.out.println("El menor es la opción: " +IMI3);
        System.out.println("3.- Todavía no hay árbol jejeje");
//SI SE LLEGARA A INICIAR POR VIENTO
    }else if (IMI4 < IMI1 && IMI4 < IMI2 && IMI4 < IMI3){
        System.out.println("Todavía no hay árbol jajaj");
        System.out.println("4.- El menor es la opción: " +IMI4);
    }
    
    
    
//________________________________________________INICIO DE LA SEGUNDA ITERACIóN_EN_SOLEADO_____________________________________________

media = 0;
double menor76 = 0, mayor76 = 0;

/*-------------------------Temperatura de soleado----------------------*/
        for (int i = 0; i < registros.length; i++) {
            if(registros[i][1] == "soleado"){
                media = media + Integer.parseInt(registros[i][2]);
                mediatotal = media / soleado;
            }
        }
        System.out.println("-------------------Temperatura para soleado  (la media es= " + Math.round(mediatotal) + ")---------------------------------------------");
        System.out.println();
        
        /*----------tabla de temperatura soleado segunda vuelta------------------------------*/

double menorc1soltem=0, menorc2soltem=0, menorN1soltem=0, menorN2soltem=0, mayorc1soltem=0, mayorc2soltem=0,
        mayorN1soltem=0, mayorN2soltem=0, IMTemsoltem1=0, IMTemsoltem2=0;
//media = 0;menorc1 = 0;menorc2 = 0;menorN1 = 0;menorN2 = 0;mayorc1 = 0;mayorc2 = 0;mayorN1 = 0;mayorN2 = 0;
   media = 0;
   
        for (int i = 0; i < todos_registros; i++) {

            if(registros[i][1] == "soleado"){   /*Solo va a registrar de las palabras que sean soleado, si lo dejamos sin esta condicion, toma nublado y lluvioso*/

                if (Integer.parseInt(registros[i][2]) > Math.round(mediatotal)) {
                    mayor76 = mayor76 + 1;
 
                    if (registros[i][5] == "No jugar" && registros[i][1] == "soleado") {
                        mayorc1soltem = mayorc1soltem + 1;
                    } else {
                        mayorc2soltem = mayor76 - mayorc2soltem;
                    }
                }else if (Integer.parseInt(registros[i][2]) <= Math.round(mediatotal)) {
                    menor76 = menor76 + 1;
                    
                    if (registros[i][5] == "No jugar" && registros[i][1] == "soleado") {
                        menorc1soltem = menorc1soltem + 1;
                        
                    } else {
                        menorc2soltem = menor76-menorc1soltem;
                    }
                }
            }       
        }  
 
        System.out.println("\t#_int\tC1\tC2");
        System.out.println(" >" + Math.round(mediatotal) + "\t" + Math.round(mayor76) + "\t" + Math.round(mayorc1soltem) + "\t" + Math.round(mayorc2soltem)
                + "\n<=" + Math.round(mediatotal) + "\t" + Math.round(menor76) + "\t" + Math.round(menorc1soltem) + "\t" + Math.round(menorc2soltem));
        
        
    /*------------------------->76--------------------*/

        System.out.println("\n>"+Math.round(mediatotal));
        mayorN1soltem = mayorc1soltem / mayor76;
        mayorN2soltem = mayorc2soltem / mayor76;
        
        System.out.println("Nm=" + mayor76 + "\nN1=" + Math.round(mayorc1soltem) + ", P1=(" + Math.round(mayorc1soltem) + "/" + df.format(mayor76) + ")= " + mayorN1soltem);
        System.out.println("N2=" + Math.round(mayorc2soltem) + ", P2=(" + Math.round(mayorc2soltem) + "/" + Math.round(mayor76) + ")= " + mayorN2soltem);
        
    if(mayorN1soltem == 0 || mayorN2soltem == 0 || mayorN1soltem == 1 || mayorN2soltem == 1){
        IMTemsoltem2 = 0;
        System.out.println("Im es puro = " + IMTemsoltem2);
    }else{
        IMTemsoltem2 = -((mayorN1soltem * (Math.log(mayorN1soltem) / Math.log(2))) + (mayorN2soltem * (Math.log(mayorN2soltem) / Math.log(2))));
        System.out.println("Im= " + IMTemsoltem2);
    }

    /*-------------------------<=76--------------------*/ 
    
        System.out.println("\n<="+Math.round(mediatotal));
        
        menorN1soltem = menorc1soltem / menor76;
        menorN2soltem = menorc2soltem / menor76;
        
        System.out.println("Nm=" + Math.round(menor76) + "\nN1=" + Math.round(menorc1soltem) + ", P1=(" + Math.round(menorc1soltem) + "/" + Math.round(menor76) + ")= " + menorN1soltem);
        System.out.println("N2=" + Math.round(menorc2soltem) + ", P2=(" + Math.round(menorc2soltem) + "/" + df.format(menor76) + ")= " + menorN2soltem);
        
    if(menorN1soltem == 0 || menorN2soltem == 0 || menorN1soltem == 1 || menorN2soltem == 1){
        IMTemsoltem1 = 0;
        System.out.println("Im es puro = " + IMTemsoltem1);
    }else{
        IMTemsoltem1 = -((menorN1soltem * (Math.log(menorN1soltem) / Math.log(2))) + (menorN2soltem * (Math.log(menorN2soltem) / Math.log(2))));
        System.out.println("Im= " + IMTemsoltem1);
        System.out.println();
    } 
    
/*-------------------------Humedad de lo soleado---------------------*/        
media=0; mediatotal = 0;
double menorc1humsol=0, menorc2humsol=0, menorN1humsol=0, menorN2humsol=0, mayorc1humsol=0, mayorc2humsol=0,
       mayorN1humsol=0, mayorN2humsol=0, menor82=0, mayor82=0, IMHumsol1 =0, IMHumsol2=0;
        
        for (int i = 0; i < registros.length; i++) {
            if(registros[i][1] == "soleado"){
            media = media + Integer.parseInt(registros[i][3]);
            mediatotal = media / soleado;
            }
        }
        
        System.out.println("-------------------Humedad para soleado  (la media es= " + Math.round(mediatotal) + ")---------------------------------------------");
        
        /*----------tabla de soleado-------------------------------*/
        for (int i = 0; i < registros.length; i++) {
            
            if(registros[i][1] == "soleado"){
                if (Integer.parseInt(registros[i][3]) > Math.round(mediatotal)) {
                    mayor82 = mayor82 + 1;
                    if (registros[i][5] == "No jugar" && registros[i][1] == "soleado") {
                        mayorc1humsol = mayorc1humsol + 1;
                    } else {
                        mayorc2humsol = mayor82 - mayorc1humsol;
                    }
                }else if (Integer.parseInt(registros[i][3]) <= Math.round(mediatotal)) {
                    menor82 = menor82 + 1;
                    if (registros[i][5] == "No jugar" && registros[i][1] == "soleado") {
                        menorc1humsol = menorc1humsol + 1;
                    } else {
                        menorc2humsol = menor82 - menorc1humsol;
                    }
                }
            }
        }
        System.out.println("\t#_int\tC1\tC2");
        System.out.println(" >" + Math.round(mediatotal) + "\t" + Math.round(mayor82) + "\t" + Math.round(mayorc1humsol) + "\t" + Math.round(mayorc2humsol)
                + "\n<=" + Math.round(mediatotal) + "\t" + Math.round(menor82) + "\t" + Math.round(menorc1humsol) + "\t" + Math.round(menorc2humsol));
        
        /*------------------------->82--------------------*/

        System.out.println("\n>"+Math.round(mediatotal));
        mayorN1humsol = mayorc1humsol / mayor82;
        mayorN2humsol = mayorc2humsol / mayor82;
        System.out.println("Nm=" + Math.round(mayor82) + "\nN1=" + Math.round(mayorc1humsol) + ", P1=(" + Math.round(mayorc1humsol) + "/" + Math.round(mayor82) + ")= " + mayorN1humsol);
        System.out.println("N2=" + Math.round(mayorc2humsol) + ", P2=(" + Math.round(mayorc2humsol) + "/" + Math.round(mayor82) + ")= " + mayorN2humsol);
   
    if(mayorN1humsol == 0 || mayorN2humsol == 0 || mayorN1humsol == 1 || mayorN2humsol == 1){
        IMHumsol2 = 0;
        System.out.println("Im es puro = " + IMHumsol2);
    }else{
        IMHumsol2 = -((mayorN1humsol * (Math.log(mayorN1humsol) / Math.log(2))) + (mayorN2humsol * (Math.log(mayorN2humsol) / Math.log(2))));
        System.out.println("Im= " + IMHumsol2);
    }

        /*-------------------------<=82--------------------*/

        System.out.println("\n<"+Math.round(mediatotal));

        menorN1humsol = menorc1humsol / menor82;
        menorN2humsol = menorc2humsol / menor82;
        System.out.println("Nm=" + Math.round(menor82) + "\nN1=" + Math.round(menorc1humsol) + ", P1=(" + Math.round(menorc1humsol) + "/" + Math.round(menor82) + ")= " + menorN1humsol);
        System.out.println("N2=" + Math.round(menorc2humsol) + ", P2=(" + Math.round(menorc2humsol) + "/" + Math.round(menor82) + ")= " + menorN2humsol);
    
    if(menorN1humsol == 0 || menorN2humsol == 0 || menorN1humsol == 1 || mayorN2humsol == 1){
        IMHumsol1 = 0;
        System.out.println("Im es puro = " + IMHumsol1);
    }else{
        
        IMHumsol1 = -((menorN1humsol * (Math.log(menorN1humsol) / Math.log(2))) + (menorN2humsol * (Math.log(menorN2humsol) / Math.log(2))));
        System.out.println("Im= " + IMHumsol1);
        System.out.println();
    }
    
/*-------------------------VIENTO para soleado---------------------*/
double viesolc1=0, viesolc2=0, viesol2c1=0, viesol2c2=0, 
       viesolN1=0, viesolN2=0, IMViesol1=0, IMViesol2=0,
       viesol2N1=0,viesol2N2=0;
viento = 0; viento2= 0;

        System.out.println("\n-------------------Viento para soleado---------------------------------------------\n");
        for (int i = 0; i < registros.length; i++) {
            //for (int j = 0; j < soleado; j++) {
                if (registros[i][1] == "soleado"){
                    if (registros[i][4] == "Si") {
                        viento = viento + 1;
                        if (registros[i][5] == "No jugar" && registros[i][1] == "soleado") {
                            viesolc1 = viesolc1 + 1;
                        } else {
                            viesolc2 = viento - viesolc1;
                        }
                    } else if (registros[i][4] == "No") {
                        viento2 = viento2 + 1;
                        if (registros[i][5] == "No jugar" && registros[i][1] == "soleado") {
                            viesol2c1 = viesol2c1 + 1;
                        } else {
                            viesol2c2 = viento2 - viesol2c1;
                        }
                    }
                }
            //}
        }
        
        System.out.println("\t#_int\tC1\tC2");
        System.out.println("Si =     " + Math.round(viento) + "\t" + Math.round(viesolc1) + "\t" + Math.round(viesolc2)
                        + "\nNo =     "+ Math.round(viento2) + "\t" + Math.round(viesol2c1) + "\t" + Math.round(viesol2c2));
        
        /*--------------Si-----------------*/
        System.out.println("\n*Si");
        viesolN1 = viesolc1 / viento;
        viesolN2 = viesolc2 / viento;
        System.out.println("Nm=" + Math.round(viento) + "\nN1=" + Math.round(viesolc1) + ", P1=(" + Math.round(viesolc1) + "/" + Math.round(viento) + ")= " + viesolN1);
        System.out.println("N2=" + Math.round(viesolc2) + ", P2=(" + Math.round(viesolc2) + "/" + Math.round(viento) + ")= " + viesolN2);
    
    if(viesolN1 == 0 || viesolN2 == 0 || viesolN1 == 1 || viesolN2 == 1){
        IMViesol1 = 0;
        System.out.println("Im es puro = " + IMViesol1);
        
    }else {
        IMViesol1 = -((viesolN1 * (Math.log(viesolN1) / Math.log(2))) + (viesolN2 * (Math.log(viesolN2) / Math.log(2))));
        System.out.println("Im= " + IMViesol1);
    }
    
    /*--------------No-----------------*/
        //double vieN11 = 0, vieN22=0;     
        System.out.println("\n*No");
        viesol2N1 = viesol2c1 / viento2;
        viesol2N2 = viesol2c2 / viento2;
        System.out.println("Nm=" + Math.round(viento2) + "\nN1=" + Math.round(viesol2c1) + ", P1=(" + Math.round(viesol2c1) + "/" + Math.round(viento2) + ")= " + viesol2N1);
        System.out.println("N2=" + Math.round(viesol2c2) + ", P2=(" + Math.round(viesol2c2) + "/" + Math.round(viento2) + ")= " + viesol2N2);
    
    if(viesol2N1 == 0 || viesol2N2 == 0 || viesol2N1 == 1 || viesol2N2 == 1){
        IMViesol2 = 0;
        System.out.println("Im es puro = " + IMViesol2);
        
    }else {
        IMViesol2 = -((viesol2N1 * (Math.log(viesol2N1) / Math.log(2))) + (viesol2N2 * (Math.log(viesol2N2) / Math.log(2))));
        System.out.println("Im= " + IMViesol2);
    }
    
    /*--------------IMPUREZA DE LA DIVISIÓN---------------------------------------------*/
    
    /*____________________________________SOLEADO*/
        double IMIS1 = 0, IMIS2 = 0, IMIS3 = 0,
                te1 = 0, te2 = 0,
                he1 = 0, he2 = 0,
                ve1 = 0, ve2 = 0;
        te1 = menor76 / soleado;
        te2 = mayor76 / soleado;
        he1 = menor82 / soleado;
        he2 = mayor82 / soleado;
        ve1 = viento  / soleado;
        ve2 = viento2 / soleado;
        
        IMIS1 = (te1 * IMTemsoltem1) + (te2 * IMTemsoltem2);
        IMIS2 = (he1 * IMHumsol1) + (he2 * IMHumsol2);
        IMIS3 = (ve1 * IMViesol1) + (ve2 * IMViesol2);
        System.out.println("\n---------Impureza de la división segunda iteración (soleado)--------------------------------------------\n");
        
        System.out.println();
        System.out.println("IMI1 = (((" + df.format(menor76) + "/" + df.format(soleado) + ")*" +IMTemsoltem1+") + ((" +df.format(mayor76)+"/" +df.format(soleado)+")*"+IMTemsoltem2+ "))");
        System.out.println("IMI1_Temperatura_Soleado =       "+IMIS1);
        System.out.println();
        
        System.out.println("IMI2 = (((" + df.format(menor82) + "/" + df.format(soleado) + ")*" +IMHumsol1+") + ((" +df.format(mayor82)+"/" +df.format(soleado)+")*"+IMHumsol2+ "))");
        System.out.println("IMI2_Humedad_Soleado =           "+IMIS2);
        System.out.println();
        
        System.out.println("IMI3 = (((" + df.format(viento) + "/" + df.format(soleado) + ")*" +IMViesol1+") + ((" +df.format(viento2)+"/" +df.format(soleado)+")*"+IMViesol2+ "))");
        System.out.println("IMI3_Viento_Soleado =            "+IMIS3);
        System.out.println();
        
//CREACIÓN DEL ÁRBOL
System.out.println();

//Si Temperatura es el menor
    if(IMIS1 < IMIS2 && IMIS1 < IMIS3){
        System.out.println("El menor es la opción:  " +IMIS1 +" que es el Temperatura");
        System.out.println("\n\n______________________________________________________________________");
        System.out.println("\n\t\t\t   Arbolito Yei :)\n");
        System.out.println("______________________________________________________________________\n\n");
        System.out.println("\t\t        -------------------");
        System.out.println("\t\t\t| Estado General  |  -> "+IMI1);
        System.out.println("\t\t        ---------o---------");
        System.out.println("\t\t                 |");
        System.out.println("\t o-----------------------°-----------------------o");
        System.out.println("\t |                       |                       |");
        System.out.println("-> "+IMsol+"\t-> "+IMllu+"\t-> "+IMnub +"\t |");
        System.out.println("\t |                       |                       |");
        System.out.println("---------°--------\t---------°--------\t---------°--------");
        System.out.println("|    Soleado     |\t|    Lluvioso    |\t|    Nublado     |");
        System.out.println("------------------\t------------------\t------------------");

        if(IMsol ==0 && soleadoc2!= 0){          //Si soleado está en 0 puro
            System.out.println("\t |\n-> 0.0   |\n"+
                               "\t |\n"+
                               "     oooo°oooo \n"+
                               "   o           o \n"+
                               "  o    Jugar    o\n"+
                               "   o           o\n"+
                               "     ooooooooo \n");
        }else if(IMsol == 0 && soleadoc1!=0){    
            System.out.println("\t |\n-> 0.0   |\n"+
                               "\t |\n"+
                               "     oooo°oooo \n"+
                               "   o           o \n"+
                               "  o   No Jugar  o\n"+
                               "   o           o\n"+
                               "     ooooooooo \n");
        }

        else if(IMllu == 0 && lluviosoc2 != 0){   //Si lluvioso está en 0 puro
            System.out.println("\t\t\t\t |\n \t\t\t-> 0.0   |\n"+
                               "\t\t\t\t |\n"+
                               "\t\t\t     oooo°oooo \n"+
                               "\t\t\t   o           o \n"+
                               "\t\t\t  o    Jugar    o\n"+
                               "\t\t\t   o           o\n"+
                               "\t\t\t     ooooooooo \n");
        }else if(IMllu == 0 && soleadoc1!=0){    
            System.out.println("\t\t\t\t |\n \t\t\t-> 0.0   |\n"+
                               "\t\t\t\t |\n"+
                               "\t\t\t     oooo°oooo \n"+
                               "\t\t\t   o           o \n"+
                               "\t\t\t  o   No Jugar  o\n"+
                               "\t\t\t   o           o\n"+
                               "\t\t\t     ooooooooo \n");
        }

        else if(IMnub == 0 && nubladoc2!=0){ //Si nublado está en 0 puro    
            System.out.println("\r\r\t\t\t\t\t\t\t |\n \t\t\t\t\t\t-> 0.0   |\n"+
                               "\t\t\t\t\t\t\t |\n"+
                               "\t\t\t\t\t\t     oooo°oooo \n"+
                               "\t\t\t\t\t\t   o           o \n"+
                               "\t\t\t\t\t\t  o    Jugar    o\n"+
                               "\t\t\t\t\t\t   o           o\n"+
                               "\t\t\t\t\t\t     ooooooooo \n");
        }else if(IMnub == 0 && nubladoc1!=0){    
            System.out.println("\t\t\t\t\t\t\t |\n \t\t\t\t\t\t-> 0.0   |\n"+
                               "\t\t\t\t\t\t\t |\n"+
                               "\t\t\t\t\t\t     oooo°oooo \n"+
                               "\t\t\t\t\t\t   o           o \n"+
                               "\t\t\t\t\t\t  o   No Jugar  o\n"+
                               "\t\t\t\t\t\t   o           o\n"+
                               "\t\t\t\t\t\t     ooooooooo \n");
        }
    
        if(IMIS1==0){
                System.out.println("\t |");
                System.out.println("-> "+IMIS1+"\t |");
                System.out.println("\t |");
                System.out.println("---------°--------");
                System.out.println("|  Temperatura   |");
                System.out.println("------------------");
                if(IMIS1 == 0 && IMTemsoltem1 == 0 && IMTemsoltem2 ==0){
                    System.out.println("   |\t    |");
                    System.out.println("-> |"+IMTemsoltem1+"\t -> |"+IMTemsoltem2);
                    System.out.println("   |\t    |");
                    System.out.println("---°---\t ---°---");
                    System.out.println("| >Te |\t |<=Te |");
                    System.out.println("-------\t -------");

                    if(IMHumsol1 == 0 && IMHumsol2 == 0){
                        System.out.println("   |\t    |\n-> |0.0   ->|0.0\n"+
                               "   |\t    |\n"+
                               "  o°o\t   o°o\n"+
                               " o N o\t  o   o\n"+
                               "o  J  o\t o  J  o\n"+
                               " o   o\t  o   o\n"+
                               "  ooo\t   ooo \n");
                    }
                }
        }
    }
//Si humedad es el menor
    if (IMIS2 < IMIS1 && IMIS2 < IMIS3){
        
        System.out.println("El menor es la opción: " +IMIS2);
        System.out.println("\n\n______________________________________________________________________");
        System.out.println("\n\t\t\t   Arbolito Yei :)\n");
        System.out.println("______________________________________________________________________\n\n");
        System.out.println("\t\t        -------------------");
        System.out.println("\t\t\t| Estado General  |  -> "+IMI1);
        System.out.println("\t\t        ---------o---------");
        System.out.println("\t\t                 |");
        System.out.println("\t o-----------------------°-----------------------o");
        System.out.println("\t |                       |                       |");
        System.out.println("-> "+IMsol+"\t-> "+IMllu+"\t-> "+IMnub +"\t |");
        System.out.println("\t |                       |                       |");
        System.out.println("---------°--------\t---------°--------\t---------°--------");
        System.out.println("|    Soleado     |\t|    Lluvioso    |\t|    Nublado     |");
        System.out.println("------------------\t------------------\t------------------");
        
        if(IMsol ==0 && soleadoc2!= 0){          //Si soleado está en 0 puro
            System.out.println("\t |\n-> 0.0   |\n"+
                               "\t |\n"+
                               "     oooo°oooo \n"+
                               "   o           o \n"+
                               "  o    Jugar    o\n"+
                               "   o           o\n"+
                               "     ooooooooo \n");
        }else if(IMsol == 0 && soleadoc1!=0){    
            System.out.println("\t |\n-> 0.0   |\n"+
                               "\t |\n"+
                               "     oooo°oooo \n"+
                               "   o           o \n"+
                               "  o   No Jugar  o\n"+
                               "   o           o\n"+
                               "     ooooooooo \n");
        }

        else if(IMllu == 0 && lluviosoc2 != 0){   //Si lluvioso está en 0 puro
            System.out.println("\t\t\t\t |\n \t\t\t-> 0.0   |\n"+
                               "\t\t\t\t |\n"+
                               "\t\t\t     oooo°oooo \n"+
                               "\t\t\t   o           o \n"+
                               "\t\t\t  o    Jugar    o\n"+
                               "\t\t\t   o           o\n"+
                               "\t\t\t     ooooooooo \n");
        }else if(IMllu == 0 && soleadoc1!=0){    
            System.out.println("\t\t\t\t |\n \t\t\t-> 0.0   |\n"+
                               "\t\t\t\t |\n"+
                               "\t\t\t     oooo°oooo \n"+
                               "\t\t\t   o           o \n"+
                               "\t\t\t  o   No Jugar  o\n"+
                               "\t\t\t   o           o\n"+
                               "\t\t\t     ooooooooo \n");
        }

        else if(IMnub == 0 && nubladoc2!=0){ //Si nublado está en 0 puro    
            System.out.println("\r\r\t\t\t\t\t\t\t |\n \t\t\t\t\t\t-> 0.0   |\n"+
                               "\t\t\t\t\t\t\t |\n"+
                               "\t\t\t\t\t\t     oooo°oooo \n"+
                               "\t\t\t\t\t\t   o           o \n"+
                               "\t\t\t\t\t\t  o    Jugar    o\n"+
                               "\t\t\t\t\t\t   o           o\n"+
                               "\t\t\t\t\t\t     ooooooooo \n");
        }else if(IMnub == 0 && nubladoc1!=0){    
            System.out.println("\t\t\t\t\t\t\t |\n \t\t\t\t\t\t-> 0.0   |\n"+
                               "\t\t\t\t\t\t\t |\n"+
                               "\t\t\t\t\t\t     oooo°oooo \n"+
                               "\t\t\t\t\t\t   o           o \n"+
                               "\t\t\t\t\t\t  o   No Jugar  o\n"+
                               "\t\t\t\t\t\t   o           o\n"+
                               "\t\t\t\t\t\t     ooooooooo \n");
        }
        
//Pausa para las ramas
        if(IMIS2==0){
            System.out.println("\t |");
            System.out.println("-> "+IMIS2+"\t |");
            System.out.println("\t |");
            System.out.println("---------°--------");
            System.out.println("|    Humedad     |");
            System.out.println("------------------");
            if(IMIS2 == 0 && IMHumsol1 == 0 && IMHumsol2 ==0){
                System.out.println("   |\t    |");
                System.out.println("-> |"+IMHumsol1+"\t -> |"+IMHumsol2);
                System.out.println("   |\t    |");
                System.out.println("---°---\t ---°---");
                System.out.println("| >Hu |\t |<=Hu |");
                System.out.println("-------\t -------");
                
                if(IMHumsol1 == 0 && IMHumsol2 == 0){
                    System.out.println("   |\t    |\n-> |0.0   ->|0.0\n"+
                           "   |\t    |\n"+
                           "  o°o\t   o°o\n"+
                           " o N o\t  o   o\n"+
                           "o  J  o\t o  J  o\n"+
                           " o   o\t  o   o\n"+
                           "  ooo\t   ooo \n");
                }
            }
        }
    }    
    //RAMAS FINALES
    //Línea de jugar (c1)
 if(IMIS3==0){
            System.out.println("\t |\n"+
                               "-> "+IMIS3+"\t |");
            System.out.println("\t |");
            System.out.println("---------°--------");
            System.out.println("|     Viento     |");
            System.out.println("------------------");
        }

System.out.println("______________________________________________________________________\n\n");



//________________________________________________INICIO DE LA TERCERA ITERACIóN_EN_LLUVIOSO_____________________________________________

media = 0;
double menor70 = 0, mayor70 = 0, menorc1llutem=0, menorc2llutem=0, menorN1llutem=0, menorN2llutem=0, mayorc1llutem=0, mayorc2llutem=0,
       mayorN1llutem=0, mayorN2llutem=0, IMTemllutem1=0, IMTemllutem2=0;

/*-------------------------Temperatura de lluvioso----------------------*/
        for (int i = 0; i < registros.length; i++) {
            if(registros[i][1] == "lluvio"){
                media = media + Integer.parseInt(registros[i][2]);
                mediatotal = media / lluvioso;
            }
        }
        System.out.println("\n-------------------Temperatura para lluvioso  (la media es= " + Math.round(mediatotal) + ")---------------------------------------------");
        System.out.println();
        
        /*----------tabla de temperatura soleado segunda vuelta------------------------------*/


   
        for (int i = 0; i < todos_registros; i++) {

            if(registros[i][1] == "lluvio"){   

                if (Integer.parseInt(registros[i][2]) > Math.round(mediatotal)) {
                    mayor70 = mayor70 + 1;
 
                    if (registros[i][5] == "No jugar" && registros[i][1] == "lluvio") {
                        mayorc1llutem = mayorc1llutem + 1;
                    } else {
                        mayorc2llutem = mayor70 - mayorc2llutem;
                    }
                }else if (Integer.parseInt(registros[i][2]) <= Math.round(mediatotal)) {
                    menor70 = menor70 + 1;
                    
                    if (registros[i][5] == "No jugar" && registros[i][1] == "lluvio") {
                        menorc1llutem = menorc1llutem + 1;            
                    } else {
                        menorc2llutem = menor70-menorc1llutem;
                    }
                }
            }       
        }  
 
        System.out.println("\t#_int\tC1\tC2");
        System.out.println(" >" + Math.round(mediatotal) + "\t" + Math.round(mayor70) + "\t" + Math.round(mayorc1llutem) + "\t" + Math.round(mayorc2llutem)
                + "\n<=" + Math.round(mediatotal) + "\t" + Math.round(menor70) + "\t" + Math.round(menorc1llutem) + "\t" + Math.round(menorc2llutem));
        
        
    /*------------------------->70--------------------*/

        System.out.println("\n>"+Math.round(mediatotal));
        mayorN1llutem = mayorc1llutem / mayor70;
        mayorN2llutem = mayorc2llutem / mayor70;
        
        System.out.println("Nm=" + Math.round(mayor70) + "\nN1=" + Math.round(mayorc1llutem) + ", P1=(" + Math.round(mayorc1llutem) + "/" + df.format(mayor70) + ")= " + mayorN1llutem);
        System.out.println("N2=" + Math.round(mayorc2llutem) + ", P2=(" + Math.round(mayorc2llutem) + "/" + Math.round(mayor70) + ")= " + mayorN2llutem);
        
    if(mayorN1llutem == 0 || mayorN2llutem == 0 || mayorN1llutem == 1 || mayorN2llutem == 1){
        IMTemllutem2 = 0;
        System.out.println("Im es puro = " + IMTemllutem2);
    }else{
        IMTemllutem2 = -((mayorN1llutem * (Math.log(mayorN1llutem) / Math.log(2))) + (mayorN2llutem * (Math.log(mayorN2llutem) / Math.log(2))));
        System.out.println("Im= " + IMTemllutem2);
    }

    /*-------------------------<=70--------------------*/ 
    
        System.out.println("\n<="+Math.round(mediatotal));
        
        menorN1llutem = menorc1llutem / menor70;
        menorN2llutem = menorc2llutem / menor70;
        
        System.out.println("Nm=" + Math.round(menor70) + "\nN1=" + Math.round(menorc1llutem) + ", P1=(" + Math.round(menorc1llutem) + "/" + Math.round(menor70) + ")= " + menorN1llutem);
        System.out.println("N2=" + Math.round(menorc2llutem) + ", P2=(" + Math.round(menorc2llutem) + "/" + df.format(menor70) + ")= " + menorN2llutem);
        
    if(menorN1llutem == 0 || menorN2llutem == 0 || menorN1llutem == 1 || menorN2llutem == 1){
        IMTemllutem1 = 0;
        System.out.println("Im es puro = " + IMTemllutem1);
    }else{
        IMTemllutem1 = -((menorN1llutem * (Math.log(menorN1llutem) / Math.log(2))) + (menorN2llutem * (Math.log(menorN2llutem) / Math.log(2))));
        System.out.println("Im= " + IMTemllutem1);
        System.out.println();
    } 
/*-------------------------Humedad de lo lluvioso---------------------*/        
media=0; mediatotal = 0;
double menorc1humllu=0, menorc2humllu=0, menorN1humllu=0, menorN2humllu=0, mayorc1humllu=0, mayorc2humllu=0,
       mayorN1humllu=0, mayorN2humllu=0, IMTemhumllu1=0, IMTemhumllu2=0, menor81=0, mayor81=0, IMHumllu1 =0, IMHumllu2=0;
        
        for (int i = 0; i < registros.length; i++) {
            if(registros[i][1] == "lluvio"){
            media = media + Integer.parseInt(registros[i][3]);
            mediatotal = media / lluvioso;
            }
        }
        
        System.out.println("--------------------Humedad para lluvioso  (la media es= " + Math.round(mediatotal) + ")---------------------------------------------\n");
        
        /*----------tabla de lluvioso-------------------------------*/
        for (int i = 0; i < registros.length; i++) {
            
            if(registros[i][1] == "lluvio"){
                if (Integer.parseInt(registros[i][3]) < Math.round(mediatotal)) {
                    menor81 = menor81 + 1;
                    if (registros[i][5] == "No jugar" && registros[i][1] == "lluvio") {
                        menorc1humllu = menorc1humllu + 1;
                    } else {
                        menorc2humllu = menor81 - menorc1humllu;
                    }
                }else if (Integer.parseInt(registros[i][3]) >= Math.round(mediatotal)) {
                    mayor81 = mayor81 + 1;
                    if (registros[i][5] == "No jugar" && registros[i][1] == "lluvio") {
                        mayorc1humllu = mayorc1humllu + 1;
                    } else {
                        mayorc2humllu = mayor81 - mayorc1humllu;
                    }
                }
            }
        }
        System.out.println("\t#_int\tC1\tC2");
        System.out.println(" <" + Math.round(mediatotal) + "\t" + Math.round(menor81) + "\t" + Math.round(menorc1humllu) + "\t" + Math.round(menorc2humllu)
                + "\n>=" + Math.round(mediatotal) + "\t" + Math.round(mayor81) + "\t" + Math.round(mayorc1humllu) + "\t" + Math.round(mayorc2humllu));
        
        /*-------------------------<82--------------------*/

        System.out.println("\n<"+Math.round(mediatotal));
        menorN1humllu = menorc1humllu / menor81;
        menorN2humllu = menorc2humllu / menor81;
        System.out.println("Nm=" + Math.round(menor81) + "\nN1=" + Math.round(menorc1humllu) + ", P1=(" + Math.round(menorc1humllu) + "/" + Math.round(menor81) + ")= " + menorN1humllu);
        System.out.println("N2=" + Math.round(menorc2humllu) + ", P2=(" + Math.round(menorc2humllu) + "/" + Math.round(menor81) + ")= " + menorN2humllu);
   
    if(menorN1humllu == 0 || menorN2humllu == 0 || menorN1humllu == 1 || menorN2humllu == 1){
        IMHumllu2 = 0;
        System.out.println("Im es puro = " + IMHumllu2);
    }else{
        IMHumllu2 = -((menorN1humllu * (Math.log(menorN1humllu) / Math.log(2))) + (menorN2humllu * (Math.log(menorN2humllu) / Math.log(2))));
        System.out.println("Im= " + IMHumllu2);
    }

        /*-------------------------<=82--------------------*/

        System.out.println("\n>="+Math.round(mediatotal));

        mayorN1humllu = mayorc1humllu / mayor81;
        mayorN2humllu = mayorc2humllu / mayor81;
        System.out.println("Nm=" + Math.round(mayor81) + "\nN1=" + Math.round(mayorc1humllu) + ", P1=(" + Math.round(mayorc1humllu) + "/" + Math.round(mayor81) + ")= " + mayorN1humllu);
        System.out.println("N2=" + Math.round(mayorc2humllu) + ", P2=(" + Math.round(mayorc2humllu) + "/" + Math.round(mayor81) + ")= " + mayorN2humllu);
    
    if(mayorN1humllu == 0 || mayorN2humllu == 0 || mayorN1humllu == 1 || mayorN2humllu == 1){
        IMHumllu1 = 0;
        System.out.println("Im es puro = " + IMHumllu1);
    }else{
        IMHumllu1 = -((mayorN1humllu * (Math.log(mayorN1humllu) / Math.log(2))) + (mayorN2humllu * (Math.log(mayorN2humllu) / Math.log(2))));
        System.out.println("Im= " + IMHumllu1);
        System.out.println();
    }
    
/*-------------------------VIENTO para lluvioso---------------------*/
double vielluc1=0, vielluc2=0, viellu2c1=0, viellu2c2=0, 
       vielluN1=0, vielluN2=0, IMViellu1=0, IMViellu2=0,
       viellu2N1=0,viellu2N2=0;
viento = 0; viento2= 0;
        System.out.println("lluviosooooooooooooo: " +lluvioso);
        System.out.println("sesesee: "+viento2 +"fefe: "+registros.length);
        System.out.println("\n-------------------Viento para lluvioso---------------------------------------------\n");
        for (int i = 0; i < registros.length; i++) {
            //for (int j = 0; j < lluvioso; j++) {
                if (registros[i][1] == "lluvio"){
                    if (registros[i][4] == "Si" && registros[i][1] == "lluvio") {
                        viento = viento + 1;
                        if (registros[i][5] == "No jugar" && registros[i][1] == "lluvio") {
                            vielluc1 = vielluc1 + 1;
                        } else {
                            vielluc2 = viento - vielluc1;
                        }
                    } else if (registros[i][4] == "No") {
                        viento2 = viento2 + 1;
                        if (registros[i][5] == "No jugar" && registros[i][1] == "lluvio") {
                            viellu2c1 = viellu2c1 + 1;
                        } else {
                            viellu2c2 = viento2 - viellu2c1;
                        }
                    }
                }
            //}
        }
        
        System.out.println("\t#_int\tC1\tC2");
        System.out.println("Si =     " + Math.round(viento) + "\t" + Math.round(vielluc1) + "\t" + Math.round(vielluc2)
                        + "\nNo =     "+ Math.round(viento2) + "\t" + Math.round(viellu2c1) + "\t" + Math.round(viellu2c2));
        
        /*--------------Si-----------------*/
        System.out.println("\n*Si");
        vielluN1 = vielluc1 / viento;
        vielluN2 = vielluc2 / viento;
        System.out.println("Nm=" + Math.round(viento) + "\nN1=" + Math.round(vielluc1) + ", P1=(" + Math.round(vielluc1) + "/" + Math.round(viento) + ")= " + vielluN1);
        System.out.println("N2=" + Math.round(vielluc2) + ", P2=(" + Math.round(vielluc2) + "/" + Math.round(viento) + ")= " + vielluN2);
    
    if(vielluN1 == 0 || vielluN2 == 0 || vielluN1 == 1 || vielluN2 == 1){
        IMViellu1 = 0;
        System.out.println("Im es puro = " + IMViellu1);
        
    }else {
        IMViellu1 = -((vielluN1 * (Math.log(vielluN1) / Math.log(2))) + (vielluN2 * (Math.log(vielluN2) / Math.log(2))));
        System.out.println("Im= " + IMViellu1);
    }
    
    /*--------------No-----------------*/     
        System.out.println("\n*No");
        viellu2N1 = viellu2c1 / viento2;
        viellu2N2 = viellu2c2 / viento2;
        System.out.println("Nm=" + Math.round(viento2) + "\nN1=" + Math.round(viellu2c1) + ", P1=(" + Math.round(viellu2c1) + "/" + Math.round(viento2) + ")= " + viellu2N1);
        System.out.println("N2=" + Math.round(viellu2c2) + ", P2=(" + Math.round(viellu2c2) + "/" + Math.round(viento2) + ")= " + viellu2N2);
    
    if(viellu2N1 == 0 || viellu2N2 == 0 || viellu2N1 == 1 || viellu2N2 == 1){
        IMViellu2 = 0;
        System.out.println("Im es puro = " + IMViellu2);    
    }else {
        IMViellu2 = -((viellu2N1 * (Math.log(viellu2N1) / Math.log(2))) + (viellu2N2 * (Math.log(viellu2N2) / Math.log(2))));
        System.out.println("Im= " + IMViellu2);
    }
    
    /*--------------IMPUREZA DE LA DIVISIÓN---------------------------------------------*/
    
    /*____________________________________LLUVIOSO*/
        double IMIL1 = 0, IMIL2 = 0, IMIL3 = 0,
                tem1 = 0, tem2 = 0,
                hem1 = 0, hem2 = 0,
                vem1 = 0, vem2 = 0;
        tem1 = menor70 / lluvioso;
        tem2 = mayor70 / lluvioso;
        hem1 = mayor81 / lluvioso;
        hem2 = menor81 / lluvioso;
        vem1 = viento  / lluvioso;
        vem2 = viento2 / lluvioso;
        
        IMIL1 = (tem1 * IMTemllutem1) + (tem2 * IMTemllutem2);
        IMIL2 = (hem1 * IMHumllu1) + (hem2 * IMHumllu2);
        IMIL3 = (vem1 * IMViellu1) + (vem2 * IMViellu2);
        System.out.println("\n---------Impureza de la división tercera iteración (lluvioso)--------------------------------------------\n");
        
        System.out.println();
        System.out.println("IMI1 = (((" + df.format(menor70) + "/" + df.format(lluvioso) + ")*" +IMTemllutem1+") + ((" +df.format(mayor70)+"/" +df.format(lluvioso)+")*"+IMTemllutem2+ "))");
        System.out.println("IMI1_Temperatura_Lluvioso =       "+IMIL1);
        System.out.println();
        
        System.out.println("IMI2 = (((" + df.format(menor81) + "/" + df.format(lluvioso) + ")*" +IMHumllu2+") + ((" +df.format(mayor81)+"/" +df.format(lluvioso)+")*"+IMHumllu1+ "))");
        System.out.println("IMI2_Humedad_Lluvioso =           "+IMIL2);
        System.out.println();
        
        System.out.println("IMI3 = (((" + df.format(viento) + "/" + df.format(lluvioso) + ")*" +IMViellu1+") + ((" +df.format(viento2)+"/" +df.format(lluvioso)+")*"+IMViellu2+ "))");
        System.out.println("IMI3_Viento_Lluvioso =            "+IMIL3);
        System.out.println();

        /*CONSTRUCCIÓN DEL ÁRBOL*/
System.out.println();
//SI TEMPERATURA ES EL MENOR
    if(IMIL1 < IMIL2 && IMIL1 < IMIL3){
        System.out.println("El menor es la opción:  " +IMIL1 +" que es el Temperatura");
        System.out.println("\n\n______________________________________________________________________");
        System.out.println("\n\t\t\t   Arbolito Yei :)\n");
        System.out.println("______________________________________________________________________\n\n");
        System.out.println("\t\t        -------------------");
        System.out.println("\t\t\t| Estado General  |  -> "+IMI1);
        System.out.println("\t\t        ---------o---------");
        System.out.println("\t\t                 |");
        System.out.println("\t o-----------------------°-----------------------o");
        System.out.println("\t |                       |                       |");
        System.out.println("-> "+IMsol+"\t-> "+IMllu+"\t-> "+IMnub +"\t |");
        System.out.println("\t |                       |                       |");
        System.out.println("---------°--------\t---------°--------\t---------°--------");
        System.out.println("|    Soleado     |\t|    Lluvioso    |\t|    Nublado     |");
        System.out.println("------------------\t------------------\t------------------");
    
        
        if(IMIL1==0){
            System.out.println("\t\t\t\t |");
            System.out.println("\t\t\t-> "+IMIL1+"\t |");
            System.out.println("\t\t\t\t |");
            System.out.println("\t\t\t---------°--------");
            System.out.println("\t\t\t|  Temperatura   |");
            System.out.println("\t\t\t------------------");
        }
//Pausa para las ramas
        
    if(IMsol ==0){          //Si soleado está en 0 puro
        System.out.println("Falta hacer el árbol para esta opción");
    }else if(IMllu == 0){   //Si lluvioso está en 0 puro
        System.out.println("Falta hacer el árbol para esta opción");
    
    }else if(IMnub == 0 && nubladoc2!=0){ //Si nublado está en 0 puro    
        System.out.println("\t\t\t\t\t\t\t |\n \t\t\t\t\t\t-> 0.0   |\n"+
                           "\t\t\t\t\t\t\t |\n"+
                           "\t\t\t\t\t\t     oooo°oooo \n"+
                           "\t\t\t\t\t\t   o           o \n"+
                           "\t\t\t\t\t\t  o    Jugar    o\n"+
                           "\t\t\t\t\t\t   o           o\n"+
                           "\t\t\t\t\t\t     ooooooooo \n");
    }else if(IMnub == 0 && nubladoc1!=0){    
        System.out.println("\t\t\t\t\t\t\t |\n \t\t\t\t\t\t-> 0.0   |\n"+
                           "\t\t\t\t\t\t\t |\n"+
                           "\t\t\t\t\t\t     oooo°oooo \n"+
                           "\t\t\t\t\t\t   o           o \n"+
                           "\t\t\t\t\t\t  o   No Jugar  o\n"+
                           "\t\t\t\t\t\t   o           o\n"+
                           "\t\t\t\t\t\t     ooooooooo \n");
    }
}    
    
//SI HUMEDAD ES EL MENOR   
    else if (IMIL2 < IMIL1 && IMIL2 < IMIL3){
        System.out.println("El menor es la opción:  " +IMIL2 +" que es el Temperatura");
        System.out.println("\n\n______________________________________________________________________");
        System.out.println("\n\t\t\t   Arbolito Yei :)\n");
        System.out.println("______________________________________________________________________\n\n");
        System.out.println("\t\t        -------------------");
        System.out.println("\t\t\t| Estado General  |  -> "+IMI1);
        System.out.println("\t\t        ---------o---------");
        System.out.println("\t\t                 |");
        System.out.println("\t o-----------------------°-----------------------o");
        System.out.println("\t |                       |                       |");
        System.out.println("-> "+IMsol+"\t-> "+IMllu+"\t-> "+IMnub +"\t |");
        System.out.println("\t |                       |                       |");
        System.out.println("---------°--------\t---------°--------\t---------°--------");
        System.out.println("|    Soleado     |\t|    Lluvioso    |\t|    Nublado     |");
        System.out.println("------------------\t------------------\t------------------");
        
        if(IMIL2==0){
            System.out.println("\t\t\t\t |");
            System.out.println("\t\t\t-> "+IMIL2+"\t |");
            System.out.println("\t\t\t\t |");
            System.out.println("\t\t\t---------°--------");
            System.out.println("\t\t\t|    Humedad     |");
            System.out.println("\t\t\t------------------");
        }
    }

//SI VIENTO ES EL MENOR    
    else if (IMIL3 < IMIL1 && IMIL3 < IMIL2){
        
        System.out.println("El menor es la opción: " +IMIL3);
        System.out.println("\n\n______________________________________________________________________");
        System.out.println("\n\t\t\t   Arbolito Yei :)\n");
        System.out.println("______________________________________________________________________\n\n");
        System.out.println("\t\t        -------------------");
        System.out.println("\t\t\t| Estado General  |  -> "+IMI1);
        System.out.println("\t\t        ---------o---------");
        System.out.println("\t\t                 |");
        System.out.println("\t o-----------------------°-----------------------o");
        System.out.println("\t |                       |                       |");
        System.out.println("-> "+IMsol+"\t-> "+IMllu+"\t-> "+IMnub +"\t |");
        System.out.println("\t |                       |                       |");
        System.out.println("---------°--------\t---------°--------\t---------°--------");
        System.out.println("|    Soleado     |\t|    Lluvioso    |\t|    Nublado     |");
        System.out.println("------------------\t------------------\t------------------");
        
//Pausa para las ramas
               
        /////////////////////////////////////////
        if(IMsol ==0 && soleadoc2!= 0){          //Si soleado está en 0 puro
            System.out.println("\t |\n-> 0.0   |\n"+
                               "\t |\n"+
                               "     oooo°oooo \n"+
                               "   o           o \n"+
                               "  o    Jugar    o\n"+
                               "   o           o\n"+
                               "     ooooooooo \n");
        }else if(IMsol == 0 && soleadoc1!=0){    
            System.out.println("\t |\n-> 0.0   |\n"+
                               "\t |\n"+
                               "     oooo°oooo \n"+
                               "   o           o \n"+
                               "  o   No Jugar  o\n"+
                               "   o           o\n"+
                               "     ooooooooo \n");
        }

        else if(IMllu == 0 && lluviosoc2 != 0){   //Si lluvioso está en 0 puro
            System.out.println("\t\t\t\t |\n \t\t\t-> 0.0   |\n"+
                               "\t\t\t\t |\n"+
                               "\t\t\t     oooo°oooo \n"+
                               "\t\t\t   o           o \n"+
                               "\t\t\t  o    Jugar    o\n"+
                               "\t\t\t   o           o\n"+
                               "\t\t\t     ooooooooo \n");
        }else if(IMllu == 0 && soleadoc1!=0){    
            System.out.println("\t\t\t\t |\n \t\t\t-> 0.0   |\n"+
                               "\t\t\t\t |\n"+
                               "\t\t\t     oooo°oooo \n"+
                               "\t\t\t   o           o \n"+
                               "\t\t\t  o   No Jugar  o\n"+
                               "\t\t\t   o           o\n"+
                               "\t\t\t     ooooooooo \n");
        }

        else if(IMnub == 0 && nubladoc2!=0){ //Si nublado está en 0 puro    
            System.out.println("\r\r\t\t\t\t\t\t\t |\n \t\t\t\t\t\t-> 0.0   |\n"+
                               "\t\t\t\t\t\t\t |\n"+
                               "\t\t\t\t\t\t     oooo°oooo \n"+
                               "\t\t\t\t\t\t   o           o \n"+
                               "\t\t\t\t\t\t  o    Jugar    o\n"+
                               "\t\t\t\t\t\t   o           o\n"+
                               "\t\t\t\t\t\t     ooooooooo \n");
        }else if(IMnub == 0 && nubladoc1!=0){    
            System.out.println("\t\t\t\t\t\t\t |\n \t\t\t\t\t\t-> 0.0   |\n"+
                               "\t\t\t\t\t\t\t |\n"+
                               "\t\t\t\t\t\t     oooo°oooo \n"+
                               "\t\t\t\t\t\t   o           o \n"+
                               "\t\t\t\t\t\t  o   No Jugar  o\n"+
                               "\t\t\t\t\t\t   o           o\n"+
                               "\t\t\t\t\t\t     ooooooooo \n");
        }
        
        
        if(IMIL3==0){
            System.out.println("\t\t\t\t |"+
                               "\n\t\t\t-> "+IMIL3+"\t |");
            System.out.println("\t\t\t\t |");
            System.out.println("\t\t\t---------°--------");
            System.out.println("\t\t\t|     Viento     |");
            System.out.println("\t\t\t------------------");
        }
                if(IMIL3 == 0 && IMViellu1 == 0 && IMViellu2 ==0){
                    System.out.println("\t\t\t   |\t    |");
                    System.out.println("\t\t\t-> |"+IMViellu1+"\t -> |"+IMViellu2);
                    System.out.println("\t\t\t   |\t    |");
                    System.out.println("\t\t\t---°---\t ---°---");
                    System.out.println("\t\t\t| Sí  |\t |  No |");
                    System.out.println("\t\t\t-------\t -------");

                    if(IMViellu1 == 0 && IMViellu2 == 0){
                        System.out.println("\t\t\t   |\t    |\n\t\t\t-> |0.0   ->|0.0\n"+
                               "\t\t\t   |\t    |\n"+
                               "\t\t\t  o°o\t   o°o\n"+
                               "\t\t\t o N o\t  o   o\n"+
                               "\t\t\to  J  o\t o  J  o\n"+
                               "\t\t\t o   o\t  o   o\n"+
                               "\t\t\t  ooo\t   ooo \n");
                    }
                }
        
    } //FINAL SI ES VIENTO 
System.out.println("______________________________________________________________________\n\n");

    }//fin del main
}//fin de la clase
