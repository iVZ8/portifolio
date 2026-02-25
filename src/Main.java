import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        // Classe Main.
        // Responsável por chamar os arquivos do futuro portifolio.
        // Por enquanto, nada aqui.
        // Meta é fazer um projeto por semana.
        boolean app = true;
        int op;
        Scanner scan = new Scanner(System.in);

        do{
            System.out.print("Menu\n\nSelecione uma opção\n\n1. Calculadora simples\n2. Jogo da velha\n3. Crud\n4. Crud de Cruds\n5. Sair\n\n> ");
            op = scan.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Não implementado.");
                    break;
                case 2:
                    System.out.print("Não implementado.");
                    break;
                case 3:
                    System.out.print("Não implementado.");
                    break;
                case 4:
                    System.out.print("Não implementado.");
                    break;
                case 5:
                    app = false;
                    break;
            }
        }while (app);
    }
}