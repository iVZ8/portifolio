package projetosportifolio.jogos;

import projetosportifolio.geral.Leitura;

public class JogoDaVelha {
    public static void main(){
        char[][] table = new char[3][3];
        boolean app = true;
        String pos;
        String nomeJogador;
        String[] nomeJogadores = {"j1","j2"};
        char winner = ' ';
        char value = ' ';
        int turn = 0;
        int op;

        do {
            op = Leitura.lerInteiro("Menu - Jogo da velha\n\n1. Começar partida\n2. Configurar jogadores\n3. Extras\n5. Sair\n\n> ");
            switch (op) {
                case 1:
                    // Iniciando o jogo por definitivo.
                    setalltable(table, ' ');
                    do{
                        // Verificando de quem é a vez
                        turn++;
                        if(turn % 2 == 1){
                            value = 'X';
                            nomeJogador = nomeJogadores[0];
                        }else{
                            value = 'O';
                            nomeJogador = nomeJogadores[1];
                        }
                        // Mostra o jogo
                        System.out.print("Rodada do jogador "+nomeJogador+" ("+value+")\n\n");
                        viewtable(table);
                        // Seleciona linha e coluna --> Novo
                        pos = Leitura.lerString("Selecione uma posição (A1/C3): ");
                        // Testa os valores e se aprovados são inseridos na tabela
                        validatepos(table, pos, value);
                        // Testa os valores inseridos na tabela, se alguma linha ou diagonal for preenchida por um dos jogadores o jogo será encerrado
                        winner = validatefinal(table, value);
                    }while (winner == ' ');
                    // Encerrando o jogo da velha.
                    viewtable(table);
                    switch (winner){
                        case 'X':
                            System.out.println("Resultado final: Vitória do jogador "+nomeJogadores[0]+" ("+winner+")");
                            break;
                        case 'O':
                            System.out.println("Resultado final: Vitória do jogador "+nomeJogadores[1]+" ("+winner+")");
                            break;
                        case 'V':
                            System.out.println("Resultado final: Empate");
                            break;
                    }
                    winner = ' ';
                    turn = 0;
                    break;
                case 2:
                    // Configurando jogadores
                    for(int i=0; i<nomeJogadores.length; i++){
                        nomeJogadores[i] = Leitura.lerString("Informe o nome do "+(i+1)+"° jogador: ");
                    }
                    System.out.println("Jogadores adicionados com sucesso a lista de jogadores.");
                    break;
                case 3:
                    // Extras, considerações a fazer.
                    System.out.println("Sistema desenvolvido por VZ8.");
                    break;
                case 5:
                    app = false;
                    break;
            }
        }while (app);
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
        System.out.println("   [ A ][ B ][ C ]");
        for(int i=0; i<table[0].length; i++){
            System.out.print((i+1)+". ");
            for(int j=0; j<table.length; j++){
                System.out.print("[ " + table[i][j] + " ]");
            }
            System.out.println();
        }
    }
    public static void validatepos(char[][] table, String pos, char value){
        // Obtendo os respectivos valores de linha e coluna
        char column = pos.charAt(0);
        int columnValue = 0;
        int line = Integer.parseInt(pos.substring(1)) - 1;

        // Tratando o valor da coluna para um valor inteiro
        switch (column){
            case 'A':
                columnValue = 0;
                break;
            case 'B':
                columnValue = 1;
                break;
            case 'C':
                columnValue = 2;
                break;
            default:
                columnValue = -1;
                break;
        }

        // Testando se essa linha e coluna existem no tabuleiro
        if(line>=0 && line<=2 && columnValue>=0 && columnValue<=2){
            // Testando se esse espaço está vazio
            if(table[line][columnValue] == ' '){
                setonetable(table, line, columnValue, value);
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
        // Verificando diagonal
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
        if(valuesEmpty>0){
            return ' ';
        }else{
            // Em caso de empate
            return 'V';
        }
    }
}