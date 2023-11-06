package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] dna = new String[6];
        String cadena;
        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese 6 secuencias de Strings de 6 letras, usando solo los siguientes caracteres: A, C, G, T");
        for (int i = 0; i < dna.length; i++) {
            cadena=in.next();
            cadena=cadena.toUpperCase();
            dna[i]=cadena;
        }

        if(isMutant(dna)){
            System.out.println("Es mutante");
        }else{
            System.out.println("Es humano");
        }
    }

    public static boolean isMutant(String[] dna){
        boolean mutante = false;
        int contFilas;
        int contColumnas;
        int contMutantes=0;

        //Comprobaciones del tamaño de la matriz
        if (dna == null || dna.length == 0) {
            return false;
        }
        if(dna.length<6 || dna[0].length()<6){
            return false;
        }else if(dna.length!=dna[0].length()){
            return false;
        }

        //Comprobacion caracteres validos
        String validCharacters = "ATCG";

        for (String row : dna) {
            for (char c : row.toCharArray()) {
                if (validCharacters.indexOf(c) == -1) {
                    return false;
                }
            }
        }

        char[][] dnaMatrix = new char[dna.length][dna[0].length()];
        //Convierto el array de strings a Matriz
        for (int i = 0; i < dna.length; i++) {
            String cadena = dna[i];
            for (int j = 0; j < dna[0].length(); j++) {
                dnaMatrix[i][j] = cadena.charAt(j);
            }
        }

        //Recorro la matriz por filas
        for (int i = 0; i < dnaMatrix.length; i++) {
            contFilas = 0;
            for (int j = 0; j < dnaMatrix[0].length; j++) {
                if (j == 0) {
                    contFilas = 1;
                } else {
                    char actual = dnaMatrix[i][j];
                    char anterior = dnaMatrix[i][j - 1];

                    if (actual == anterior) {
                        contFilas++;
                    } else {
                        contFilas = 1;
                    }
                }

                if (contFilas >= 4) {
                    contMutantes++;
                    break;
                }
            }
        }

        //Recorro la matriz por columnas
        for (int i = 0; i < dnaMatrix[0].length; i++) {
            contColumnas = 0;
            for (int j = 0; j < dnaMatrix.length; j++) {
                if (j == 0) {
                    contColumnas = 1;
                } else {
                    char actual = dnaMatrix[j][i];
                    char anterior = dnaMatrix[j - 1][i];

                    if (actual == anterior) {
                        contColumnas++;
                    } else {
                        contColumnas = 1;
                    }
                }

                if (contColumnas >= 4) {
                    contMutantes++;
                    break;
                }
            }
        }


        //Recorro la matriz por diagonales
        //Izquierda a Derecha
        for (int i = 0; i < (dnaMatrix.length/2); i++) {
            for (int j = 0; j < (dnaMatrix[0].length/2); j++) {
                if(dnaMatrix[i][j]==dnaMatrix[i+1][j+1] && dnaMatrix[i][j]==dnaMatrix[i+2][j+2] && dnaMatrix[i][j]==dnaMatrix[i+3][j+3]){
                    contMutantes++;
                }
            }
        }


        //Derecha a Izquierda
        for (int i = (dnaMatrix.length-1); i >= (dnaMatrix.length/2); i--) {
            for (int j = 0; j < (dnaMatrix[0].length/2); j++) {
                if(dnaMatrix[i][j]==dnaMatrix[i-1][j+1] && dnaMatrix[i][j]==dnaMatrix[i-2][j+2] && dnaMatrix[i][j]==dnaMatrix[i-3][j+3]){
                    contMutantes++;
                }
            }
        }

        if(contMutantes>=2){
            mutante=true;
        }

        return mutante;
    }
}