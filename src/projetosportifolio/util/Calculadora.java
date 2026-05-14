package projetosportifolio.util;

import projetosportifolio.geral.Leitura;

public class Calculadora {
    public static void main(){
        // Projeto da calculadora.
        boolean app = true;
        int op;
        int n1;
        int n2;
        int r = 0;

        do{
            op = Leitura.lerInteiro("Menu - Calculadora\n\n1. Soma\n2. Subtração\n3. Multiplicação\n4. Divisão\n5. Sair\n\n> ");
            n1 = Leitura.lerInteiro("Informe um número: ");
            n2 = Leitura.lerInteiro("Informe outro número: ");
            switch (op) {
                case 1:
                    r = addition(n1, n2);
                    break;
                case 2:
                    r = subtraction(n1, n2);
                    break;
                case 3:
                    r = multiplication(n1, n2);
                    break;
                case 4:
                    r = division(n1, n2);
                    break;
                case 5:
                    System.out.println("Encerrando Calculadora...");
                    app = false;
                    break;
            }
            System.out.println("Resultado da operação: "+r);
        }while (app);
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
