package filesportifolio;

import java.util.Scanner;

public class Calculator {
    public static void main(){
        // Projeto da calculadora.
        boolean app = true;
        int op;
        int n1;
        int n2;

        do{
            System.out.print("Menu - Calculadora\n\n1. Soma\n2. Subtração\n3. Multiplicação\n4. Divisão\n5. Sair\n\n> ");
            op = getnumber();
            switch (op) {
                case 1:
                    System.out.print("Informe um número: ");
                    n1 = getnumber();
                    System.out.print("Informe outro número: ");
                    n2 = getnumber();
                    System.out.print("Resultado da operação: ");
                    System.out.println(addition(n1, n2));
                    break;
                case 2:
                    System.out.print("Informe um número: ");
                    n1 = getnumber();
                    System.out.print("Informe outro número: ");
                    n2 = getnumber();
                    System.out.print("Resultado da operação: ");
                    System.out.println(subtraction(n1, n2));
                    break;
                case 3:
                    System.out.print("Informe um número: ");
                    n1 = getnumber();
                    System.out.print("Informe outro número: ");
                    n2 = getnumber();
                    System.out.print("Resultado da operação: ");
                    System.out.println(multiplication(n1, n2));
                    break;
                case 4:
                    System.out.print("Informe um número: ");
                    n1 = getnumber();
                    System.out.print("Informe outro número: ");
                    n2 = getnumber();
                    System.out.print("Resultado da operação: ");
                    System.out.println(division(n1, n2));
                    break;
                case 5:
                    System.out.println("Encerrando Calculadora...");
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
    public static int addition(int n1, int n2){
        return (n1+n2);
    }
    public static int subtraction(int n1, int n2){
        return (n1-n2);
    }
    public static int multiplication(int n1, int n2){
        return (n1*n2);
    }
    public static int division(int n1, int n2){
        return (n1/n2);
    }
}
