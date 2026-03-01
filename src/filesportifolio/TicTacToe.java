package filesportifolio;

import java.util.Scanner;

public class TicTacToe {
    public static void main(){
        char[][] table = new char[3][3];
        boolean app = true;
        char winner = ' ';
        char value = ' ';
        int turn = 0;
        int line;
        int column;
        int op;

        do {
            System.out.print("Menu - Jogo da velha\n\n1. Começar partida\n5. Sair\n\n> ");
            op = getnumber();
            switch (op) {
                case 1:
                    setalltable(table, ' ');
                    while (winner == ' '){
                        // Verificando de quem é a vez
                        turn++;
                        if(turn % 2 == 1){
                            value = 'X';
                        }else{
                            value = 'O';
                        }
                        // Mostra o jogo
                        System.out.print("Rodada do jogador "+value+"\n\n");
                        viewtable(table);
                        // Seleciona linha e coluna
                        System.out.print("Selecione uma linha entre 1 a 3: ");
                        line = getnumber() - 1;
                        System.out.print("Selecione uma coluna entre 1 a 3: ");
                        column = getnumber() - 1;
                        // Testa os valores e se aprovados são inseridos na tabela
                        validatepos(table, line, column, value);
                        // Testa os valores inseridos na tabela, se alguma linha ou diagonal for preenchida por um dos jogadores o jogo será encerrado
                        winner = validatefinal(table, value);
                    }
                    viewtable(table);
                    switch (winner){
                        case 'X':
                        case 'O':
                            System.out.println("Resultado final: Vitória do jogador "+winner);
                            break;
                        case 'V':
                            System.out.println("Resultado final: Empate");
                            break;
                    }
                    winner = ' ';
                    turn = 0;
                    break;
                case 5:
                    app = false;
                    break;
            }
        }while (app);
    }
    public static int getnumber(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        return (n);
    }
    public static char getcharacter(){
        Scanner scan = new Scanner(System.in);
        char text = scan.nextLine().charAt(0);
        return (text);
    }
    public static void setonetable(char[][] table, int line, int column, char value){
        table[line][column] = value;
    }
    public static void setalltable(char[][] table, char value){
        for(int i=0; i<table[0].length; i++){
            for(int j=0; j<table.length; j++){
                table[i][j] = value;
            }
            System.out.println();
        }
    }
    public static void viewtable(char[][] table){
        for(int i=0; i<table[0].length; i++){
            for(int j=0; j<table.length; j++){
                System.out.print("[ " + table[i][j] + " ]");
            }
            System.out.println();
        }
    }
    public static void validatepos(char[][] table, int line, int column, char value){
        // Testando se essa linha e coluna existem no tabuleiro
        if(line>=0 && line<=2 && column>=0 && column<=2){
            // Testando se esse espaço está vazio
            if(table[line][column] == ' '){
                setonetable(table, line, column, value);
            }
        }
    }
    public static char validatefinal(char[][] table, char value){
        // Testando se o jogo pode ser encerrado
        // Verificando linhas
        if(table[0][0] == value && table[0][1] == value && table[0][2] == value){
            return value;
        }else if(table[1][0] == value && table[1][1] == value && table[1][2] == value){
            return value;
        }else if(table[2][0] == value && table[2][1] == value && table[2][2] == value){
            return value;
        }
        // Verificando colunas
        else if(table[0][0] == value && table[1][0] == value && table[2][0] == value){
            return value;
        }else if(table[0][1] == value && table[1][1] == value && table[2][1] == value){
            return value;
        }else if(table[0][2] == value && table[1][2] == value && table[2][2] == value){
            return value;
        }
        // Verificando diagonal -- NÃO FOI TESTADO
        else if(table[0][0] == value && table[1][1] == value && table[2][2] == value){
            return value;
        }else if(table[0][2] == value && table[1][1] == value && table[2][0] == value){
            return value;
        }
        // Verificando se todos os elementos foram preenchidos
        int valuesEmpty = 0;
        for(int i=0; i<table[0].length; i++){
            for(int j=0; j<table.length; j++){
                if(table[i][j] == ' '){
                    valuesEmpty += 1;
                }
            }
            System.out.println();
        }
        if(valuesEmpty>=9){
            // Em caso de empate
            return 'V';
        }else{
            return ' ';
        }
    }
}
