package projetosportifolio.jogos;

import projetosportifolio.geral.Leitura;

import java.util.Scanner;

public class Hannoi {
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        int[][] t = new int[5][3];
        int linha = 0;
        int coluna;
        int valorDisco = 0;
        int acaoUsuario = 0; // 0. Retirar o disco 1. Colocar o disco
        int qtdDiscos;
        int jogo = 0; // -1 = Derrota, 0 = Jogo Ativo, 1 = Vitória
        String msg = "Informe a quantidade de discos: ";

        // Preparando o jogo: Configurando Tabela e Torre
        t = preencherTabela(t);
        qtdDiscos = Leitura.lerInteiro(msg);
        if(validarDiscos(t, qtdDiscos)){
            t = adicionarTorre(t, qtdDiscos);
        }else{
            // Caso o jogador insira quantidades inválidas de disco
            qtdDiscos = 3;
            t = adicionarTorre(t, qtdDiscos);
        }
        // Inicializar o jogo: Controle do usuário.
        do{
            switch (acaoUsuario%2){
                case 0:
                    msg = "- Informe a coluna referente ao disco a retirar: ";
                    break;
                case 1:
                    msg = "- Informe a coluna referente ao disco a colocar: ";
                    break;
            }
            System.out.println("- Disco em mãos: "+valorDisco);
            imprimirTabela(t);
            coluna = Leitura.lerInteiro(msg);
            coluna--;
            if(validarColuna(t, coluna)){
                linha = procurarLinhaDisco(t, coluna);
            }
            // valor do disco só obtem ao retirar disco
            if((acaoUsuario%2)==0){
                if(validarLinha(t, linha)){
                    valorDisco = procurarValorDisco(t, linha, coluna);
                }
            }
            switch (acaoUsuario%2){
                case 0:
                    t = removerDisco(t, linha, coluna);
                    break;
                case 1:
                    t = colocarDisco(t, linha-1, coluna, valorDisco);
                    valorDisco = 0;
                    break;
            }
            // verificar se o jogo pode ser encerrado.
            //System.out.println("[DEBUG]: tamanho da linha: "+t.length);
            //System.out.println("[DEBUG]: posição da condição de finalização do jogo: linha: "+(t.length-qtdDiscos));
            // verificar se o jogo pode ser encerrado: derrota do jogador.
            if(acaoUsuario%2==1){
                if(linha-1<t.length-1){
                    if(t[linha-1][coluna] > t[linha][coluna]){
                        jogo = -1;
                    }
                }
            }
            // verificar se o jogo pode ser encerrado: vitória do jogador.
            if(t[(t.length-qtdDiscos)][2] == 1){
                jogo = 1;
            }
            acaoUsuario++;
        }while (jogo==0);
        imprimirTabela(t);
        switch(jogo){
            case -1:
                System.out.println("- Você perdeu o jogo, obrigado por jogar.");
                break;
            case 1:
                System.out.println("- Você venceu o jogo, meus parabéns e obrigado por jogar!");
                break;
        }
    }
    public static int[][] preencherTabela(int[][] table){
        for (int i=0; i<table.length; i++){
            for (int j=0; j<table[0].length; j++){
                table[i][j] = 0;
            }
        }
        return table;
    }
    public static void imprimirTabela(int[][] table){
        for (int i=0; i<table.length; i++){
            for (int j=0; j<table[0].length; j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] adicionarTorre(int[][] table, int tamanhoTorre){
        for(int i=table.length-1; i>=0; i--){
            table[i][0] = tamanhoTorre;
            tamanhoTorre--;
            if(tamanhoTorre==0){
                break;
            }
        }
        return table;
    }
    public static int procurarValorDisco(int[][] table, int linha, int coluna){
        return table[linha][coluna];
    }
    public static int procurarLinhaDisco(int[][] table, int coluna){
        int valorLinha=0;
        int linha=0;
        //System.out.println("[DEBUG]: tamanho da linha da tabela: "+table.length);
        for(int i=0; i<table.length;i++){
            valorLinha = table[i][coluna];
            if(valorLinha!=0){
                // Caso seja encontrado
                linha = i;
                break;
            }
        }
        // Caso não encontre uma posição válida
        if(valorLinha==0){
            return table.length;
        }
        return linha; // retornar a posição da linha, não o valor
    }
    public static boolean validarDiscos(int[][] table, int qtd){
        if(qtd >= 1 && qtd < table.length){
            return true;
        }
        return false;
    }
    public static boolean validarLinha(int[][] table, int linha){
        if(linha >= 0 && linha < table.length){
            return true;
        }
        return false;
    }
    public static boolean validarColuna(int[][] table, int coluna){
        if(coluna >= 0 && coluna < table[0].length){
            return true;
        }
        return false;
    }
    public static int[][] removerDisco(int[][] table, int linha, int coluna){
        table[linha][coluna] = 0;
        return table;
    }
    public static int[][] colocarDisco(int[][] table, int linha, int coluna, int disco){
        //System.out.println("[DEBUG]: Valor a inserir: "+disco+" Linha a se inserir: "+linha);
        table[linha][coluna] = disco;
        return table;
    }
}
