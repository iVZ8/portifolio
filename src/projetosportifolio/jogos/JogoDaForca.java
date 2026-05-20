package projetosportifolio.jogos;

import java.util.Random;

public class JogoDaForca {
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        boolean app = true;
        do{
            char[][] table = new char[11][7];
            String[] palavras = {"matematica", "história", "geografia"};
            int erros = 0;

            table = setEmptyTable(table);
            printTable(table);
            table = setErrorTable(table, erros);
            printTable(table);
        }while (app);
    }
    public static void printTable(char[][] table){
        for(int i=0; i<table.length;i++){
            for(int j=0; j< table[0].length;j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }
    public static char[][] setEmptyTable(char[][] table){
        for(int i=0; i<table.length;i++){
            for(int j=0; j< table[0].length;j++){
                table[i][j] = ' ';
            }
        }

        table[0][0] = '+';
        table[0][1] = '-';
        table[0][2] = '-';
        table[0][3] = '-';
        table[0][4] = '+';
        table[1][0] = '|';
        table[1][4] = '|';
        table[2][0] = '|';
        table[3][0] = '|';
        table[4][0] = '|';
        table[5][0] = '|';
        table[6][0] = '|';
        table[7][0] = '|';
        table[8][0] = '|';
        table[9][0] = '|';
        table[10][0] = '+';
        table[10][1] = '-';
        table[10][2] = '-';
        table[10][3] = '-';
        table[10][4] = '-';
        return table;
    }
    public static char[][] setErrorTable(char[][] table, int erros){
        for(int i=0; i<=erros; i++){
            switch (i) {
                case 0:
                    table = setEmptyTable(table);
                    break;
                case 1:
                    table[2][4] = 'O';
                    break;
                case 2:
                    table[3][4] = '+';
                    break;
                case 3:
                    table[3][3] = '-';
                    break;
                case 4:
                    table[3][5] = '-';
                    break;
                case 5:
                    table[4][2] = '/';
                    break;
                case 6:
                    table[4][6] = '\\';
                    break;
                case 7:
                    table[4][4] = '|';
                    break;
                case 8:
                    table[5][4] = '|';
                    break;
                case 9:
                    table[6][4] = '+';
                    break;
                case 10:
                    table[6][3] = '-';
                    break;
                case 11:
                    table[6][5] = '-';
                    break;
                case 12:
                    table[7][3] = '|';
                    break;
                case 13:
                    table[7][5] = '|';
                    break;
            }
        }
        return table;
    }
    public static String[] palavraAleatoria(String[] palavras){
        Random r = new Random();
        String p;
        //Ta errado
        //int palavraAleatoria = r.ints(0, palavras.length);
        //palavras[palavraAleatoria];
        return palavras;
    }
}
