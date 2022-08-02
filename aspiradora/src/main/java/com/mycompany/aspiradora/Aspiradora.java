package com.mycompany.aspiradora;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Aspiradora {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int basura = 0, v = 1, b = 2, d = 0, a = 1;
        int h, f, c;
        Integer[] options = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] options9 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] options8 = {0, 1, 2, 3, 4, 5, 6, 7, 8,};
        Integer[] options7 = {0, 1, 2, 3, 4, 5, 6, 7};
        Integer[] options6 = {0, 1, 2, 3, 4, 5, 6};
        Integer[] options5 = {0, 1, 2, 3, 4, 5};
        Integer[] options4 = {0, 1, 2, 3, 4};
        Integer[] options3 = {0, 1, 2, 3};
        Integer[] options2 = {0, 1, 2};
        Integer[] options1 = {0, 1};
        Integer[] options0 = {0};

        f = (Integer) JOptionPane.showInputDialog(null, "elige el tamaño de la matriz:", "casilla", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        /*------------------------------------------------------impresion de la matriz--------------------*/
        c = f;
        int matrix[][] = new int[f][c];
        //imprimir(matrix);
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("[%d]", matrix[i][j]);
                matrix[i][j] = v;
            }
            System.out.println();
        }
        /*----------------------colcacion de la basura---------------------*/
        JOptionPane.showMessageDialog(null, "la cantidad de basura no puede ser mayor que la matriz");
        basura = (Integer) JOptionPane.showInputDialog(null, "elige la cantidad de basura:", "basura", JOptionPane.QUESTION_MESSAGE, null, options9, options9[0]);
        for (a = 1; a <= basura; a++) {
            int m, n;
            if (c == 9) {
                m = (Integer) JOptionPane.showInputDialog(null, "Posicion m:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options8, options8[0]);
                n = (Integer) JOptionPane.showInputDialog(null, "Posicion n:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options8, options8[0]);
            } else if (f == 8) {
                m = (Integer) JOptionPane.showInputDialog(null, "Posicion m:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options7, options7[0]);
                n = (Integer) JOptionPane.showInputDialog(null, "Posicion n:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options7, options7[0]);
            } else if (f == 7) {
                m = (Integer) JOptionPane.showInputDialog(null, "Posicion m:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options6, options6[0]);
                n = (Integer) JOptionPane.showInputDialog(null, "Posicion n:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options6, options6[0]);
            } else if (f == 6) {
                m = (Integer) JOptionPane.showInputDialog(null, "Posicion m:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options5, options5[0]);
                n = (Integer) JOptionPane.showInputDialog(null, "Posicion n:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options5, options5[0]);
            } else if (f == 5) {
                m = (Integer) JOptionPane.showInputDialog(null, "Posicion m:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options4, options4[0]);
                n = (Integer) JOptionPane.showInputDialog(null, "Posicion n:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options4, options4[0]);
            } else if (f == 4) {
                m = (Integer) JOptionPane.showInputDialog(null, "Posicion m:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options3, options3[0]);
                n = (Integer) JOptionPane.showInputDialog(null, "Posicion n:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options3, options3[0]);
            } else if (f == 3) {
                m = (Integer) JOptionPane.showInputDialog(null, "Posicion m:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
                n = (Integer) JOptionPane.showInputDialog(null, "Posicion n:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
            } else if (f == 2) {
                m = (Integer) JOptionPane.showInputDialog(null, "Posicion m:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
                n = (Integer) JOptionPane.showInputDialog(null, "Posicion n:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
            } else {
                m = (Integer) JOptionPane.showInputDialog(null, "Posicion m:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options0, options0[0]);
                n = (Integer) JOptionPane.showInputDialog(null, "Posicion m:", "posicion", JOptionPane.QUESTION_MESSAGE, null, options0, options0[0]);
            }

            JOptionPane.showMessageDialog(null, "Matriz [" + a + "] colocados fueron [" + m + "," + n + "]");
            System.out.println("Matriz [" + a + "] colocados fueron [" + m + "," + n + "]");
            matrix[m][n] = b;

            //
        }
        //} while (basura > f);
        /*-------------------------impresion de matriz-------------*/
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("[%d]", matrix[i][j]);
            }
            System.out.println();
        }

        /*----------------------------colocacion de la aspiradora--------------*/
        int m = 0;
        int n = 0;

        System.out.println(
                "Matriz colocados fue [" + m + "," + n + "]");
        matrix[m][n] = 0;
        /*-------------------------impresion de matriz donde esta ubicada la aspiradora-------------*/
        System.out.println("--------------------------------");

        for (int i = 0;
                i < f;
                i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("[%d]", matrix[i][j]);
            }
            System.out.println();
        }
        /*-----------hacer el movimiento de la aspiradoras---------*/
        int tope = f - 1;
        int contador = 0;
        for (int y = 0;
                y <= tope;
                y++) {
            for (int x = 0; x < c; x++) {
                if ((matrix[y][x] = d) == 0) {
                    if (matrix[y][x] == 0) {
                        matrix[y][x] = 0;//deja un coero en la posicion que paso
                        /*imprime el contenido---------------*/
                        System.out.println("-------------------cambio de ubicacion-------------");
                        //JOptionPane.showMessageDialog(null, "contador es: " + contador );
                        contador = contador + 1;
                        for (int i = 0; i < f; i++) {
                            for (int j = 0; j < c; j++) {
                                System.out.printf("[%d]", matrix[i][j]);
                            }
                            System.out.println();
                        }
                    }
                }
                /*-------------------------impresion de matriz del IA-------------*/
            }
        }

        JOptionPane.showMessageDialog(null, "fin de programa");
    }
}
