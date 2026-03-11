package filesportifolio;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        // Classe Main, responsável por chamar os arquivos do futuro portifolio(meta é fazer um projeto por semana).
        boolean app = true;
        int op;

        do{
            System.out.print("Menu\n\nSelecione uma opção\n\n1. Calculadora simples\n2. Jogo da velha\n3. Cifra de Cesar\n4. Crud\n5. Crud de Cruds\n6. Sair\n\n> ");
            op = getnumber();
            switch (op) {
                case 1:
                    Calculator.main();
                    break;
                case 2:
                    TicTacToe.main();
                    break;
                case 3:
                    CesarCypher.main();
                    break;
                case 4:
                    System.out.println("Crud ainda não implementado.");
                    break;
                case 5:
                    System.out.println("Crud de Crud não implementado.");
                    break;
                case 6:
                    app = false;
                    break;
                default:
                    System.out.println("Sistema não encontrado.");
                    break;
            }
        }while (app);
    }
    public static int getnumber() {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        return num;
    }
}