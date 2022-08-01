package formula_de_bayes;

import java.util.logging.*;
import java.text.DecimalFormat;
import java.util.Arrays;

public class principal {

    public static void main(String[] args) {
        //instancias
        Matriz ma;
        temp t;
        //variable globales
        String c1 = "No jugar", c2 = "Jugar";
        DecimalFormat df = new DecimalFormat("###.###");
        double IM, media = 0, mediatotal = 0, menorc1 = 0, menorc2 = 0,
                menorN1 = 0, menorN2 = 0, mayorc1 = 0, mayorc2 = 0, mayorN1 = 0, mayorN2 = 0,
                IMsol, IMnu, IMllu, IMmenor74, IMmayor74, registro, total,
                Nm;
        //variables para estado general
        double soleado = 0, nublado = 0, lluvioso = 0;
        double nuN1 = 0, nuN2 = 0, nubladoc1 = 0, nubladoc2 = 0,
                solN1 = 0, solN2 = 0, soleadoc1 = 0, soleadoc2 = 0,
                lluN1 = 0, lluN2 = 0, lluviosoc1 = 0, lluviosoc2 = 0;
        //variable de temperatura
        double menor74 = 0, mayor74 = 0;
        //variable  de humedad
        double menor80 = 0, mayor80 = 0;
        //variable de viento
        double si = 0, no = 0, sic1 = 0,
                sic2 = 0, noc1 = 0, noc2 = 0,
                SiN1 = 0, SiN2 = 0, NoN1 = 0, NoN2 = 0;
        //impureza
        double impE = 0, impT, impH, impV, impES = 0, impEst = 0, impEstal = 0,
                impTEM, impTE, impHu, impHum, impVi, impVie;
        /*--------------------------------registros------------------------*/
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
            {"10", "lluvio", "75", "80", "No", "Jugar"},
            {"11", "soleado", "75", "70", "Si", "Jugar"},
            {"12", "Nublado", "72", "90", "Si", "jugar"},
            {"13", "Nublado", "81", "75", "No", "Jugar"},
            {"14", "lluvio", "71", "80", "Si", "No jugar"}};
        String[] Estado_Genero = {"soleado", "Nublado", "lluvio"};
        String[] numero = {"50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100"};
        String[] Viento = {"No", "Si"};
        String[] clase = {"No jugar", "Jugar"};
        /*------------------colocacion de los campos --------------------*/
        for (int x = 0; x < campos.length; x++) {
            System.out.print(campos[x] + "\t");
        }
        System.out.println();
        //*------------------------------colocacion de los registros-----------------------*/
        for (int i = 0; i < registros.length; i++) {
            for (int j = 0; j < registros[i].length; j++) {
                System.out.print(registros[i][j] + "\t");
            }
            System.out.println();
        }
        registro = registros.length;//contar los registros
        System.out.println("\n1.- Numero de instancias es " + registros.length);//atributos 
        System.out.println("\n2.- Conjunto de clases\nc1=" + c1 + ", c2=" + c2);
        System.out.println();
        /*----------------------------------------------------------------Estado General---------------------------*/
        System.out.println("-----------------------------Estado General---------------------------------------------");

        //temperatura(registro);
        for (int i = 0; i < registros.length; i++) {
            for (int j = 0; j < registros[i].length; j++) {
                //-----------------busca los soleados
                if (registros[i][j] == "soleado") {
                    soleado = soleado + 1;
                    //-----------------busca los No jugar
                    if (registros[i][5] == "No jugar") {
                        soleadoc1 = soleadoc1 + 1;
                    } else {
                        soleadoc2 = soleado - soleadoc1;
                    }
                    //-----------------busca los nublados
                } else if (registros[i][j] == "Nublado") {
                    nublado = nublado + 1;
                    if (registros[i][5] == "No jugar") { //-----------------busca los No jugar
                        nubladoc1 = nubladoc1 + 1;
                    } else {
                        nubladoc2 = nublado - nubladoc1;
                    }
                    //-----------------busca los lluviosos
                } else if (registros[i][j] == "lluvio") {
                    lluvioso = lluvioso + 1;
                    if (registros[i][5] == "No jugar") { //-----------------busca los No jugar
                        lluviosoc1 = lluviosoc1 + 1;
                    } else {
                        lluviosoc2 = lluvioso - lluviosoc1;
                    }
                }
            }
        }
        /*----------------------------tabla de soleados----------------------------*/
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
        double sol[] = {soleadoc1, soleadoc2};
        IMsol = -((solN1 * (Math.log(solN1) / Math.log(2))) + (solN2 * (Math.log(solN2) / Math.log(2))));
        if (Double.toString(IMsol) == "NaN") {
            IMsol = 0;
        }
        System.out.println("Im=" + IMsol);
        /*--------------nublado-----------------*/
        System.out.println("\n*Nublado");
        nuN1 = nubladoc1 / nublado;
        nuN2 = nubladoc2 / nublado;
        System.out.println("Nm=" + nublado + "\nN1=" + Math.round(nubladoc1) + ", P1=(" + Math.round(nubladoc1) + "/" + nublado + ")= " + nuN1);
        System.out.println("N2=" + Math.round(nubladoc2) + ", P2=(" + Math.round(nubladoc2) + "/" + nublado + ")= " + nuN2);
        double nubl[] = {nubladoc1, nubladoc2};
        IMnu = -((nuN1 * (Math.log(nuN1) / Math.log(2))) + (nuN2 * (Math.log(nuN2) / Math.log(2))));
        if (Double.toString(IMnu) == "NaN") {
            IMnu = 0;
        }
        System.out.println("Im=" + IMnu);

        /*--------------lluvioso-----------------*/
        System.out.println("\n*Nublado");
        lluN1 = lluviosoc1 / lluvioso;
        lluN2 = lluviosoc2 / lluvioso;
        System.out.println("Nm=" + lluvioso + "\nN1=" + Math.round(lluviosoc1) + ", P1=(" + Math.round(lluviosoc1) + "/" + lluvioso + ")= " + lluN1);
        System.out.println("N2=" + Math.round(lluviosoc2) + ", P2=(" + Math.round(lluviosoc2) + "/" + lluvioso + ")= " + lluN2);
        double lluv[] = {lluviosoc1, lluviosoc2};
        IMllu = -((lluN1 * (Math.log(lluN1) / Math.log(2))) + (lluN2 * (Math.log(lluN2) / Math.log(2))));
        if (Double.toString(IMllu) == "NaN") {
            IMllu = 0;
        }
        System.out.println("Im=" + IMllu);
        /*-------------------------Temperatura----------------------*/
 /*----------------------------------media de temperatura------------------*/

        for (int i = 0; i < registros.length; i++) {
            media = media + Integer.parseInt(registros[i][2]);
            mediatotal = media / registros.length;
        }

        System.out.println("-----------------------------Temperatura  (la media es= " + Math.round(mediatotal) + ")---------------------------------------------");
        System.out.println();
        /*----------tabla de Temperatura--------------------------------*/
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
        media = 0;

        /*-------------------tabla de Temperatura-------------------*/
        System.out.println("\t #_int\tC1\tC2");
        System.out.println(" >" + Math.round(mediatotal) + "\t" + menor74 + "\t" + Math.round(menorc1) + "\t" + Math.round(menorc2)
                + "\n<=" + Math.round(mediatotal) + "\t" + mayor74 + "\t" + Math.round(mayorc1) + "\t" + Math.round(mayorc2));
        /*-------------------------<74-------------------*/
        System.out.println(">" + mediatotal);
        menorN1 = menorc1 / menor74;
        menorN2 = menorc2 / menor74;
        System.out.println("Nm=" + menor74 + "\nN1=" + Math.round(menorc1) + ", P1=(" + Math.round(menorc1) + "/" + menor74 + ")= " + df.format(menorN1));
        System.out.println("N1=" + Math.round(menorc2) + ", P1=(" + Math.round(menorc2) + "/" + menor74 + ")= " + df.format(menorN2));
        IMmayor74 = -((menorN1 * (Math.log(menorN1) / Math.log(2))) + (menorN2 * (Math.log(menorN2) / Math.log(2))));
        System.out.println("Im=" + IMmayor74);
        System.out.println();

        /*------------------------->=74--------------------*/
        System.out.println(">=" + mediatotal);
        mayorN1 = mayorc1 / mayor74;
        mayorN2 = mayorc2 / mayor74;
        System.out.println("Nm=" + mayor74 + "\nN1=" + Math.round(mayorc1) + ", P1=(" + Math.round(mayorc1) + "/" + mayor74 + ")= " + df.format(mayorN1));
        System.out.println("N1=" + Math.round(mayorc2) + ", P1=(" + Math.round(mayorc2) + "/" + mayor74 + ")= " + df.format(mayorN2));
        IMmenor74 = -((mayorN1 * (Math.log(mayorN1) / Math.log(2))) + (mayorN2 * (Math.log(mayorN2) / Math.log(2))));
        System.out.println("Im=" + IMmenor74);
        /*----------------------------------media de Humedad------------------*/
        media = 0;
        mediatotal = 0;
        for (int i = 0; i < registros.length; i++) {
            media = media + Integer.parseInt(registros[i][3]);
            mediatotal = media / registros.length;
        }
        System.out.println("-----------------------------humedad  (la media es= " + Math.round(mediatotal) + ")---------------------------------------------");
        System.out.println();
        menorc1 = 0;
        menorc2 = 0;
        menorN1 = 0;
        menorN2 = 0;
        mayorc1 = 0;
        mayorc2 = 0;
        mayorN1 = 0;
        mayorN2 = 0;
        /*----------busqueda de Humedad--------------------------------*/
        for (int i = 0; i < registros.length; i++) {
            if (Integer.parseInt(registros[i][3]) < mediatotal) {
                menor80 = menor80 + 1;
                if (registros[i][5] == "No jugar") {
                    menorc1 = menorc1 + 1;
                } else {
                    menorc2 = menor80 - menorc1;
                }
            } else if (Integer.parseInt(registros[i][3]) >= mediatotal) {
                mayor80 = mayor80 + 1;
                if (registros[i][5] == "No jugar") {
                    mayorc1 = mayorc1 + 1;
                } else {
                    mayorc2 = mayor80 - mayorc1;
                }
            }
        }
        /*-----------------------tabla de Humedad-------------------------*/
        System.out.println("\t #_int\tC1\tC2");
        System.out.println(" <" + Math.round(mediatotal) + "\t" + menor80 + "\t" + Math.round(menorc1) + "\t" + Math.round(menorc2)
                + "\n>=" + Math.round(mediatotal) + "\t" + mayor80 + "\t" + Math.round(mayorc1) + "\t" + Math.round(mayorc2));
        /*-------------------------<80--------------------*/
        System.out.println("<" + mediatotal);

        menorN1 = menorc1 / menor80;
        menorN2 = menorc2 / menor80;
        System.out.println("Nm=" + menor80 + "\nN1=" + Math.round(menorc1) + ", P1=(" + Math.round(menorc1) + "/" + menor80 + ")= " + df.format(menorN1));
        System.out.println("N1=" + Math.round(menorc2) + ", P1=(" + Math.round(menorc2) + "/" + menor80 + ")= " + df.format(menorN2));
        double IMmenor80 = -((menorN1 * (Math.log(menorN1) / Math.log(2))) + (menorN2 * (Math.log(menorN2) / Math.log(2))));
        System.out.println("Im=" + IMmenor80);
        System.out.println();

        /*------------------------->=80--------------------*/
        System.out.println(">=" + mediatotal);
        mayorN1 = mayorc1 / mayor80;
        mayorN2 = mayorc2 / mayor80;
        System.out.println("Nm=" + mayor80 + "\nN1=" + Math.round(mayorc1) + ", P1=(" + Math.round(mayorc1) + "/" + mayor80 + ")= " + df.format(mayorN1));
        System.out.println("N1=" + Math.round(mayorc2) + ", P1=(" + Math.round(mayorc2) + "/" + mayor80 + ")= " + df.format(mayorN2));
        double IMmayor80 = -((mayorN1 * (Math.log(mayorN1) / Math.log(2))) + (mayorN2 * (Math.log(mayorN2) / Math.log(2))));
        System.out.println("Im=" + IMmayor80);
        /*--------------------------viento-------------------------*/
 /*--------------------------Busqueda de viento-------------------------*/
        for (int i = 0; i < registros.length; i++) {
            if (registros[i][4] == "Si") {
                si = si + 1;
                if (registros[i][5] == "No jugar") {
                    sic1 = sic1 + 1;
                } else {
                    sic2 = si - sic1;
                }
            } else if (registros[i][4] == "No") {
                no = no + 1;
                if (registros[i][5] == "No jugar") {
                    noc1 = noc1 + 1;
                } else {
                    noc2 = no - noc1;
                }
            }

        }
        /*-------------------------tabla de Viento------------------------*/
        System.out.println("-------------------------Viento----------------------------------");
        System.out.println("\t #_int\tC1\tC2");

        System.out.println("Si=" + "\t" + si + "\t" + sic1 + "\t" + sic2
                + "\nNo=" + "\t" + no + "\t" + noc1 + "\t" + noc2);
        /*-------------------------Si--------------------*/
        System.out.println("Si");
        SiN1 = sic1 / si;
        SiN2 = sic2 / si;
        System.out.println("Nm=" + si + "\nN1=" + Math.round(sic1) + ", P1=(" + Math.round(sic1) + "/" + si + ")= " + df.format(SiN1));
        System.out.println("N1=" + Math.round(sic2) + ", P1=(" + Math.round(sic2) + "/" + si + ")= " + df.format(SiN2));
        double IMsi = -((SiN1 * (Math.log(SiN1) / Math.log(2))) + (SiN2 * (Math.log(SiN2) / Math.log(2))));
        System.out.println("Im=" + IMsi);
        /*-------------------------No--------------------*/
        System.out.println("No");
        NoN1 = noc1 / no;
        NoN2 = noc2 / no;
        System.out.println("Nm=" + no + "\nN1=" + Math.round(noc1) + ", P1=(" + Math.round(noc1) + "/" + no + ")= " + df.format(NoN1));
        System.out.println("N1=" + Math.round(noc2) + ", P1=(" + Math.round(noc2) + "/" + no + ")= " + df.format(NoN2));
        double IMno = -((NoN1 * (Math.log(NoN1) / Math.log(2))) + (NoN2 * (Math.log(NoN2) / Math.log(2))));
        System.out.println("Im=" + IMno);

        /*----------------------------------impureza----------------------------------*/
        System.out.println("------------------------impureza de la division---------------------");
        System.out.println("--------Estado General");/*----------------------------------General----------------------------------*/

        impE = (soleado / registro * IMsol);
        impES = ((nublado / registro * IMnu));
        impEst = (lluvioso / registro * IMllu);
        if (Double.toString(impE) == "NaN") {
            impE = 0;
        } else if (Double.toString(impES) == "NaN") {
            impES = 0;
        } else if (Double.toString(impEst) == "NaN") {
            impEst = 0;
        }
        impEstal = impE + impES + impEst;
        System.out.println(df.format(impEstal));

        System.out.println("--------Temperatura");/*----------------------------------Temperatura----------------------------------*/
        impT = ((menor74 / registro) * IMmenor74);
        impTE = ((mayor74 / registro) * IMmayor74);
        if (Double.toString(impT) == "NaN") {
            impT = 0;
        } else if (Double.toString(impTE) == "NaN") {
            impTE = 0;
        }
        impTEM = impT + impTE;
        System.out.println(impTEM);

        System.out.println("--------Humedad");/*----------------------------------Humedad----------------------------------*/
        impH = ((menor80 / registro) * IMmenor80);
        impHu = ((mayor80 / registro) * IMmayor80);
        if (Double.toString(impH) == "NaN") {
            impH = 0;
        } else if (Double.toString(impHu) == "NaN") {
            impHu = 0;
        }
        impHum = impH + impHu;
        System.out.println(impHum);

        System.out.println("--------Viento");/*----------------------------------Viento----------------------------------*/
        impV = ((si / registro) * IMsi);
        impVi = ((no / registro) * IMno);
        if (Double.toString(impV) == "NaN") {
            impV = 0;
        } else if (Double.toString(impVi) == "NaN") {
            impVi = 0;
        }
        impVie = impV + impVi;
        System.out.println(impVie);
        System.out.println();

        /*---------------------------------------arbol --------------------------*/
        System.out.println();
        System.out.println("-------------impresion de arbol-------------------");
        double[] a = {IMsol, IMllu, IMnu};
        Arrays.sort(a);
        System.out.println("Estado General");
        for (int i = 0; i < a.length; i++) {
            if (a[i] == a[0]) {//------------para la primera rama
                if (a[i] == IMsol) {
                    System.out.println("soleado=" + a[0]);
                    Arrays.sort(sol);
                    if (IMsol == a[0]) {
                        if (sol[i] == sol[0]) {
                            System.out.println("\tJugar");
                        } else {
                            System.out.println("\tNo Jugar");
                        }
                    }
                    Nm = soleado;
                    System.out.println(Nm);
                } else if (a[i] == IMllu) {
                    System.out.println("lluvioso=" + a[0]);
                    Arrays.sort(lluv);
                    if (IMllu == a[0]) {
                        if (lluv[i] == lluv[0]) {
                            System.out.println("\tJugar");
                        } else {
                            System.out.println("\tNo Jugar");
                        }
                    }
                    Nm = lluvioso;
                    System.out.println(Nm);
                } else if (a[i] == IMnu) {
                    System.out.println("nublado=" + a[0]);
                    Arrays.sort(nubl);
                    if (IMnu == a[0]) {
                        if (nubl[i] == nubl[0]) {
                            System.out.println("\tJugar");
                        } else {
                            System.out.println("\tNo Jugar");
                        }
                    }
                    if (a[1] == a[2]) {
                        System.out.println("soleado");
                        Nm = soleado;
                        soleadoc1 = 0;
                        soleadoc1 = 0;
                        soleado = 0;

                        for (int h = 0; h < registros.length; h++) {
                            for (int j = 0; j < registros[h].length; j++) {
                                if (registros[h][j] == "soleado") {
                                    soleado = soleado + 1;
                                    //-----------------busca los No jugar
                                    if (registros[h][5] == "No jugar") {
                                        soleadoc1 = soleadoc1 + 1;
                                    } else {
                                        soleadoc2 = soleado - soleadoc1;
                                    }

                                }
                            }
                            //-----------------busca los nublados
                        }
                        System.out.println("\n*Soleado");
                        solN1 = soleadoc1 / soleado;
                        solN2 = soleadoc2 / soleado;
                        System.out.println("Nm=" + soleado + "\nN1=" + Math.round(soleadoc1) + ", P1=(" + Math.round(soleadoc1) + "/" + soleado + ")= " + solN1);
                        System.out.println("N2=" + Math.round(soleadoc2) + ", P2=(" + Math.round(soleadoc2) + "/" + soleado + ")= " + solN2);

                        IMsol = -((solN1 * (Math.log(solN1) / Math.log(2))) + (solN2 * (Math.log(solN2) / Math.log(2))));
                        if (Double.toString(IMsol) == "NaN") {
                            IMsol = 0;
                        }
                        System.out.println("Im=" + IMsol);

                        media = 0;
                        mediatotal = 0;
                        menor74 = menorc1 = menorc2 = mayor74 = mayorc1 = mayorc2 = 0;
                        for (int v = 0; v < registros.length; v++) {
                            for (int j = 0; j < registros[v].length; j++) {
                                if (registros[v][j] == "soleado") {
                                    media = media + Integer.parseInt(registros[v][2]);
                                    mediatotal = media / soleado;
                                }
                            }
                        }
                        menor74 = 0;
                        menorc1 = 0;
                        menorc2 = 0;
                        mayor74 = 0;
                        mayorc1 = 0;
                        mayorc2 = 0;
                        for (int v = 0; v < registros.length; v++) {
                            for (int j = 0; j < registros[v].length; j++) {
                                if (registros[v][j] == "soleado") {
                                    if (Integer.parseInt(registros[v][2]) > mediatotal) {
                                        menor74 = menor74 + 1;
                                        if (registros[v][5] == "No jugar") {
                                            menorc1 = menorc1 + 1;
                                        } else if (registros[v][5] == "Jugar") {
                                            menorc2 = menorc2 + 1;
                                        }
                                    } else if (Integer.parseInt(registros[v][2]) < mediatotal) {
                                        mayor74 = mayor74 + 1;
                                        System.out.println("gola" + mayor74);
                                        if (registros[v][5] == "No jugar") {
                                            mayorc1 = mayorc1 + 1;

                                        } else if (registros[v][5] == "Jugar") {
                                            mayorc2 = mayorc2 + 1;
                                        }
                                        System.out.println(mayorc1);
                                    }
                                }
                            }
                        }

                        //  mediatotal = mediatotal - 1;
                        System.out.println("-----------------------------Temperatura  (la media es= " + mediatotal + ")---------------------------------------------");
                        System.out.println();

                        /*----------tabla de Temperatura--------------------------------*/
 /*-------------------tabla de Temperatura-------------------*/
                        System.out.println("\t #_int\tC1\tC2");
                        System.out.println(" >" + Math.round(mediatotal) + "\t" + menor74 + "\t" + Math.round(menorc1) + "\t" + Math.round(menorc2)
                                + "\n<=" + Math.round(mediatotal) + "\t" + mayor74 + "\t" + Math.round(mayorc1) + "\t" + Math.round(mayorc2));
                        /*-------------------------<74-------------------*/
                        System.out.println(">" + mediatotal);
                        menorN1 = menorc1 / menor74;
                        menorN2 = menorc2 / menor74;
                        System.out.println("Nm=" + menor74 + "\nN1=" + Math.round(menorc1) + ", P1=(" + Math.round(menorc1) + "/" + menor74 + ")= " + df.format(menorN1));
                        System.out.println("N1=" + Math.round(menorc2) + ", P1=(" + Math.round(menorc2) + "/" + menor74 + ")= " + df.format(menorN2));
                        IMmayor74 = -((menorN1 * (Math.log(menorN1) / Math.log(2))) + (menorN2 * (Math.log(menorN2) / Math.log(2))));
                        System.out.println("Im=" + IMmayor74);
                        System.out.println();

                        //*------------------------->=74--------------------*/
                        System.out.println(">=" + mediatotal);
                        mayorN1 = mayorc1 / mayor74;
                        mayorN2 = mayorc2 / mayor74;
                        System.out.println("Nm=" + mayor74 + "\nN1=" + Math.round(mayorc1) + ", P1=(" + Math.round(mayorc1) + "/" + mayor74 + ")= " + df.format(mayorN1));
                        System.out.println("N1=" + Math.round(mayorc2) + ", P1=(" + Math.round(mayorc2) + "/" + mayor74 + ")= " + df.format(mayorN2));

                        IMmenor74 = -((mayorN1 * (Math.log(mayorN1) / Math.log(2))) + (mayorN2 * (Math.log(mayorN2) / Math.log(2))));
                        System.out.println("Im=" + IMmenor74);

                        /*-----------------------hasta aqui va bien-------------*/
 /*----------------------------------media de Humedad------------------*/
                        media = 0;
                        mediatotal = 0;
                        menor74 = menorc1 = menorc2 = mayor74 = mayorc1 = mayorc2 = 0;
                        for (int v = 0; v < registros.length; v++) {
                            for (int j = 0; j < registros[v].length; j++) {
                                if (registros[v][j] == "soleado") {
                                    media = media + Integer.parseInt(registros[v][3]);
                                    mediatotal = media / soleado;
                                }
                            }
                        }
                        menor74 = menorc1 = menorc2 = mayor74 = mayorc1 = mayorc2 = menor80 = mayor80 = 0;
                        for (int v = 0; v < registros.length; v++) {
                            for (int j = 0; j < registros[v].length; j++) {
                                if (registros[v][j] == "soleado") {
                                    if (Integer.parseInt(registros[v][3]) > mediatotal) {
                                        menor80 = menor80 + 1;
                                        if (registros[v][5] == "No jugar") {
                                            menorc1 = menorc1 + 1;
                                        } else if (registros[v][5] == "Jugar") {
                                            menorc2 = menorc2 + 1;
                                        }
                                    } else if (Integer.parseInt(registros[v][3]) < mediatotal) {
                                        mayor80 = mayor80 + 1;
                                        System.out.println("gola" + mayor74);
                                        if (registros[v][5] == "No jugar") {
                                            mayorc1 = mayorc1 + 1;

                                        } else if (registros[v][5] == "Jugar") {
                                            mayorc2 = mayorc2 + 1;
                                        }
                                        System.out.println(mayorc1);
                                    }
                                }
                            }
                        }
                        System.out.println("-----------------------------humedad  (la media es= " + Math.round(mediatotal) + ")---------------------------------------------");
                        System.out.println();

                        /*-----------------------tabla de Humedad-------------------------*/
                        System.out.println("\t #_int\tC1\tC2");
                        System.out.println(" <" + Math.round(mediatotal) + "\t" + menor80 + "\t" + Math.round(menorc1) + "\t" + Math.round(menorc2)
                                + "\n>=" + Math.round(mediatotal) + "\t" + mayor80 + "\t" + Math.round(mayorc1) + "\t" + Math.round(mayorc2));
                        /*-------------------------<80--------------------*/
                        System.out.println("<" + mediatotal);

                        menorN1 = menorc1 / menor80;
                        menorN2 = menorc2 / menor80;
                        System.out.println("Nm=" + menor80 + "\nN1=" + Math.round(menorc1) + ", P1=(" + Math.round(menorc1) + "/" + menor80 + ")= " + df.format(menorN1));
                        System.out.println("N1=" + Math.round(menorc2) + ", P1=(" + Math.round(menorc2) + "/" + menor80 + ")= " + df.format(menorN2));
                        IMmenor80 = 0;
                        IMmenor80 = -((menorN1 * (Math.log(menorN1) / Math.log(2))) + (menorN2 * (Math.log(menorN2) / Math.log(2))));
                        System.out.println("Im=" + IMmenor80);
                        System.out.println();

                        /*------------------------->=80--------------------*/
                        System.out.println(">=" + mediatotal);
                        mayorN1 = mayorc1 / mayor80;
                        mayorN2 = mayorc2 / mayor80;
                        System.out.println("Nm=" + mayor80 + "\nN1=" + Math.round(mayorc1) + ", P1=(" + Math.round(mayorc1) + "/" + mayor80 + ")= " + df.format(mayorN1));
                        System.out.println("N1=" + Math.round(mayorc2) + ", P1=(" + Math.round(mayorc2) + "/" + mayor80 + ")= " + df.format(mayorN2));
                        IMmayor80 = 0;
                        IMmayor80 = -((mayorN1 * (Math.log(mayorN1) / Math.log(2))) + (mayorN2 * (Math.log(mayorN2) / Math.log(2))));
                        System.out.println("Im=" + IMmayor80);

                        /*-----------------------hasta aqui va bien-------------*/
 /*--------------------------viento-------------------------*/
 /*--------------------------Busqueda de viento-------------------------*/
                        si = sic1 = sic2 = no = noc1 = noc2 = 0;
                        for (int v = 0; v < registros.length; v++) {
                            for (int j = 0; j < registros[v].length; j++) {
                                if (registros[v][j] == "soleado") {
                                    if (registros[v][4] == "Si") {
                                        si = si + 1;
                                        if (registros[v][5] == "No jugar") {
                                            sic1 = sic1 + 1;
                                        } else if (registros[v][5] == "Jugar") {
                                            sic2 = si - sic1;
                                        }
                                    } else if (registros[v][4] == "No") {
                                        no = no + 1;
                                        if (registros[v][5] == "No jugar") {
                                            noc1 = noc1 + 1;
                                        } else if (registros[v][5] == "Jugar") {
                                            noc2 = no - noc1;
                                        }
                                        System.out.println(mayorc1);
                                    }
                                }
                            }
                        }
                        /*-------------------------tabla de Viento------------------------*/
                        System.out.println("-------------------------Viento----------------------------------");
                        System.out.println("\t #_int\tC1\tC2");

                        System.out.println("Si=" + "\t" + si + "\t" + sic1 + "\t" + sic2
                                + "\nNo=" + "\t" + no + "\t" + noc1 + "\t" + noc2);
                        /*-------------------------Si--------------------*/
                        System.out.println("Si");
                        SiN1 = sic1 / si;
                        SiN2 = sic2 / si;
                        System.out.println("Nm=" + si + "\nN1=" + Math.round(sic1) + ", P1=(" + Math.round(sic1) + "/" + si + ")= " + df.format(SiN1));
                        System.out.println("N1=" + Math.round(sic2) + ", P1=(" + Math.round(sic2) + "/" + si + ")= " + df.format(SiN2));
                        IMsi = 0;
                        IMsi = -((SiN1 * (Math.log(SiN1) / Math.log(2))) + (SiN2 * (Math.log(SiN2) / Math.log(2))));
                        System.out.println("Im=" + IMsi);
                        /*-------------------------No--------------------*/
                        System.out.println("No");
                        NoN1 = noc1 / no;
                        NoN2 = noc2 / no;
                        System.out.println("Nm=" + no + "\nN1=" + Math.round(noc1) + ", P1=(" + Math.round(noc1) + "/" + no + ")= " + df.format(NoN1));
                        System.out.println("N1=" + Math.round(noc2) + ", P1=(" + Math.round(noc2) + "/" + no + ")= " + df.format(NoN2));
                        IMno = 0;
                        IMno = -((NoN1 * (Math.log(NoN1) / Math.log(2))) + (NoN2 * (Math.log(NoN2) / Math.log(2))));
                        System.out.println("Im=" + IMno);

                        /*-----------------------hasta aqui va bien-------------*/
 /*-----------------------impureza----------------------------------*/
                        System.out.println("------------------------impureza de la division---------------------");

                        System.out.println("--------Temperatura");/*----------------------------------Temperatura----------------------------------*/
                        impT = ((menor74 / soleado) * IMmenor74);
                        impTE = ((mayor74 / soleado) * IMmayor74);

                        if (Double.toString(impT) == "NaN") {
                            impT = 0;
                        } else if (Double.toString(impTE) == "NaN") {
                            impTE = 0;
                        }
                        impTEM = impT + impTE;
                        if (impTEM == 0) {
                            impTEM = impTEM + 1;
                        } else if (Double.toString(impTEM) == "NaN") {
                            impTEM = 0;
                        }
                        System.out.println(impTEM);

                        System.out.println("--------Humedad");/*----------------------------------Humedad----------------------------------*/
                        impH = ((menor80 / soleado) * IMmenor80);
                        impHu = ((mayor80 / soleado) * IMmayor80);
                        if (Double.toString(impH) == "NaN") {
                            impH = 0;
                        } else if (Double.toString(impHu) == "NaN") {
                            impHu = 0;
                        }
                        impHum = impH + impHu;
                        if (impHum == 0) {
                            impHum = impHum + 1;
                        } else if (Double.toString(impHum) == "NaN") {
                            impHum = 0;
                        }
                        System.out.println(impHum);

                        System.out.println("--------Viento");/*----------------------------------Viento----------------------------------*/

                        impV = ((si / soleado) * IMsi);
                        impVi = ((no / soleado) * IMno);
                        if (Double.toString(impV) == "NaN") {
                            impV = 0;
                        } else if (Double.toString(impVi) == "NaN") {
                            impVi = 0;
                        }
                        impVie = impV + impVi;
                        System.out.println(impVie);
                        if (impVie == 0) {
                            impVie = impVie + 1;
                        } else if (Double.toString(impVie) == "NaN") {
                            impVie = 0;
                        }
                        System.out.println();

                        double[] b = {impTEM, impHum, impVie};
                        Arrays.sort(b);
                        System.out.println(b);
                        for (int y = 0; y < b.length; y++) {
                            if (a[y] == b[0]) {//------------para la primera rama
                                if (a[y] == IMsol) {
                                    System.out.println("Templado=" + b[0]);
                                    Arrays.sort(sol);
                                    if (IMsol == b[0]) {
                                        if (sol[y] == sol[0]) {
                                            System.out.println("\tJugar");
                                        } else {
                                            System.out.println("\tNo Jugar");
                                        }
                                    }
                                    Nm = soleado;
                                    System.out.println(Nm);
                                } else if (a[y] == IMllu) {
                                    System.out.println("humedad=" + b[0]);
                                    Arrays.sort(lluv);
                                    if (IMllu == a[0]) {
                                        if (lluv[y] == lluv[0]) {
                                            System.out.println("\tJugar");
                                        } else {
                                            System.out.println("\tNo Jugar");
                                        }
                                    }
                                    Nm = lluvioso;
                                    System.out.println(Nm);
                                } else if (a[y] == IMllu) {
                                    System.out.println("viento=" + b[0]);
                                    Arrays.sort(lluv);
                                    if (IMllu == b[0]) {
                                        if (lluv[y] == lluv[0]) {
                                            System.out.println("\tJugar");
                                        } else {
                                            System.out.println("\tNo Jugar");
                                        }
                                    }
                                    Nm = lluvioso;
                                    System.out.println(Nm);
                                }

                            } else {
                                Nm = nublado;
                                System.out.println(Nm);
                                System.out.println("lluvioso");
                            }

                        }
                    }

                }

            }//fin del main
        }
    }
}//fin de la clase
