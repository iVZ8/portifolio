package projetosportifolio.util;

import projetosportifolio.geral.Leitura;

public class Ordenacao {
    public static void main() {
        int[] v = new int[0];
        int[][] m = new int[0][0];
        int op;
        boolean app=true;

        do{
            op = Leitura.lerInteiro("Menu: Algoritmo de Ordenação\n\n1. Criar novo vetor\n2. Criar nova matriz\n3. Ordenar Vetor\n4. Ordenar Matriz\n5. Sair\n\n> ");

            switch (op){
                case 1:
                    v = criarVetor();
                    break;
                case 2:
                    // Não implementado.
                    m = criarMatriz();
                    break;
                case 3:
                    if(v.length==0){
                        v = criarVetor();
                    }
                    System.out.print("Ordem crescente: ");
                    ordenarVetor(v, true);
                    System.out.println();
                    System.out.print("Ordem Decrescente: ");
                    ordenarVetor(v, false);
                    System.out.println();
                    break;
                case 4:
                    // Não implementado.
                    if(m.length==0 || m[0].length==0){
                        m = criarMatriz();
                    }
                    System.out.print("Ordem crescente: ");
                    ordenarMatriz(m, true);
                    System.out.println();
                    System.out.print("Ordem Decrescente: ");
                    ordenarMatriz(m, false);
                    System.out.println();
                    break;
                case 5:
                    app = false;
                    break;
            }
        }while (app);
    }
    public static int[] criarVetor(){
        int tamanhoVetor = Leitura.lerInteiro("Informe a quantidade de elementos para esse vetor: ");
        int[] vetor = new int[tamanhoVetor];

        // preenchendo valores do vetor
        for(int i=0; i<vetor.length; i++){
            vetor[i] = Leitura.lerInteiro("Informe um valor para a "+(i+1)+"° posição do vetor: ");
        }
        return vetor;
    }
    public static int[][] criarMatriz(){
        int linhas = Leitura.lerInteiro("Informe a quantidade de linhas para essa matriz: ");
        int colunas = Leitura.lerInteiro("Informe a quantidade de colunas para essa matriz: ");
        int[][] matriz = new int[linhas][colunas];

        // preenchendo valores da matriz
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[0].length; j++){
                matriz[i][j] = Leitura.lerInteiro("Informe um valor para a "+(i+1)+"° linha do matriz e "+(j+1)+"° coluna da matriz: ");
            }
        }
        return matriz;
    }
    public static void ordenarVetor(int[] numeros, boolean crescente){
        int auxiliar=0;
        if(crescente){
            // ordenacao de forma crescente
            for(int i=0; i<numeros.length - 1; i++){
                for(int j=0; j<numeros.length - 1 - i; j++){
                    if(numeros[j] > numeros[j + 1]){
                        auxiliar = numeros[j];
                        numeros[j] = numeros[j + 1];
                        numeros[j + 1] = auxiliar;
                    }
                }
            }
        }else{
            // ordenacao de forma decrescente
            for(int i=0; i<numeros.length - 1; i++){
                for(int j=0; j<numeros.length - 1 - i; j++){
                    if(numeros[j] < numeros[j + 1]){
                        auxiliar = numeros[j];
                        numeros[j] = numeros[j + 1];
                        numeros[j + 1] = auxiliar;
                    }
                }
            }
        }
        // imprimindo resultado
        System.out.println("Resultado vetor: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
    }
    public static void ordenarMatriz(int[][] numeros, boolean crescente){
        int linhas = numeros.length;
        int colunas = numeros[0].length;

        int total = linhas * colunas;

        if(crescente){
            for (int i = 0; i < total - 1; i++) {

                for (int j = 0; j < total - 1 - i; j++) {

                    int linha1 = j / colunas;
                    int coluna1 = j % colunas;
                    int linha2 = (j + 1) / colunas;
                    int coluna2 = (j + 1) % colunas;

                    if (numeros[linha1][coluna1] > numeros[linha2][coluna2]) {
                        int temp = numeros[linha1][coluna1];
                        numeros[linha1][coluna1] = numeros[linha2][coluna2];
                        numeros[linha2][coluna2] = temp;
                    }
                }
            }
        }else{
            for (int i = 0; i < total - 1; i++) {

                for (int j = 0; j < total - 1 - i; j++) {

                    int linha1 = j / colunas;
                    int coluna1 = j % colunas;
                    int linha2 = (j + 1) / colunas;
                    int coluna2 = (j + 1) % colunas;

                    if (numeros[linha1][coluna1] < numeros[linha2][coluna2]) {
                        int temp = numeros[linha1][coluna1];
                        numeros[linha1][coluna1] = numeros[linha2][coluna2];
                        numeros[linha2][coluna2] = temp;
                    }
                }
            }
        }
        // imprimindo resultado
        System.out.println("Resultado matriz: ");
        for(int i=0; i<numeros.length; i++){
            for(int j=0; j<numeros[0].length; j++){
                System.out.print(numeros[i][j]+" ");
            }
            System.out.println();
        }
    }
}
