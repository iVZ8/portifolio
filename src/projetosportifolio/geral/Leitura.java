package projetosportifolio.geral;

import java.util.Scanner;

public class Leitura {
    public static int lerInteiro(String contexto){
        Scanner s = new Scanner(System.in);
        int valor = 0;
        while (true){
            try {
                System.out.print(contexto);
                valor = s.nextInt();
                break;
            }catch (Exception e){
                System.out.println("[ERRO]: O valor inserido não é um número inteiro.");
            }finally {
                s.nextLine();
            }
        }
        return valor;
    }
    public static String lerString(String contexto) {
        Scanner scan = new Scanner(System.in);
        String txt = scan.nextLine();
        return txt;
    }
    public static char lerChar(String contexto){
        Scanner scan = new Scanner(System.in);
        char txt = scan.nextLine().charAt(0);
        return (txt);
    }
}
