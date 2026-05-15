package projetosportifolio.geral;

import projetosportifolio.criptografia.CifraCesar;
import projetosportifolio.jogos.JogoDaVelha;
import projetosportifolio.util.Calculadora;
import projetosportifolio.util.Ordenacao;

public class Menu{
    public static void main(String[] args){
        // Classe Main, responsável por chamar os arquivos do futuro portifolio(meta é fazer um projeto por semana).
        boolean app = true;
        int op;

        do{
            op = Leitura.lerInteiro("Menu\n\nSelecione uma opção\n\n1. Calculadora simples\n2. Jogo da velha\n3. Cifra de Cesar\n4. Algoritmo de ordenação\n5. Crud\n6. Crud de Cruds\n7. Sair\n\n> ");
            switch (op) {
                case 1:
                    Calculadora.main();
                    break;
                case 2:
                    JogoDaVelha.main();
                    break;
                case 3:
                    CifraCesar.main();
                    break;
                case 4:
                    Ordenacao.main();
                    break;
                case 5:
                    System.out.println("Crud ainda não implementado.");
                    break;
                case 6:
                    System.out.println("Crud de Crud não implementado.");
                    break;
                case 7:
                    app = false;
                    break;
                default:
                    System.out.println("Sistema não encontrado.");
                    break;
            }
        }while (app);
    }
}