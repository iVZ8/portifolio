package filesportifolio;

import java.util.Objects;
import java.util.Scanner;

public class CesarCypher {
    public static void main(){
        boolean app = true;
        boolean debug = false;
        int op;
        String txt = "";
        int key = 0;

        do{
            System.out.print("Menu - Cifra de Cesar\n\n1. Codificar texto\n2. Decodificar texto\n3. Sair\n\n> ");
            op = getnumber();

            if(op == 1 || op == 2){
                System.out.print("Insira seu texto: ");
                txt = gettext();
                if(Objects.equals(txt, ".") || Objects.equals(txt, "debug")){
                    System.out.print("DEBUG ATIVO: Insira novamente seu texto: ");
                    txt = gettext();
                    debug = true;
                }
                System.out.print("Insira sua chave (de 0 á 25): ");
                key = getnumber();
            }

            switch (op){
                case 1:
                    if(key>=0 && key<26){
                        txt = code(txt, key, debug);
                        System.out.println("O resultado do seu texto é: "+txt);
                    }else{
                        System.out.println("Erro: Valor inserido é inválido.");
                    }
                    break;
                case 2:
                    if(key>=0 && key<26){
                        txt = decode(txt, key, debug);
                        System.out.println("O resultado do seu texto é: "+txt);
                    }else{
                        System.out.println("Erro: Valor inserido é inválido.");
                    }
                    break;
                case 3:
                    app = false;
                    break;
            }
        }while(app);
    }
    public static String code(String txt, int key, boolean debug){
        String alfabetoString = "abcdefghijklmnopqrstuvwxyz";
        String novoTexto = "";
        char[] vetorAlfabeto = alfabetoString.toCharArray();
        char[] vetorCodigo = new char[26];
        char[] vetorTexto = new char[txt.length()];
        // Preenchendo o Codigo com base na chave inserida.
        // Primeiro vamos preencher utilizando a chave como o indice.
        int j = 0;
        for(int i = key; i < vetorAlfabeto.length; i++){
            vetorCodigo[i] = vetorAlfabeto[j];
            j++;
        }
        // Depois vamos preencher as letras que restam.
        for(int i = 0; i < key; i++){
            vetorCodigo[i] = vetorAlfabeto[j];
            j++;
        }
        // Debug
        if(debug){
            System.out.print("DEBUG: VetorCodigo: ");
            for (char letra : vetorCodigo) {
                System.out.print(letra + " ");
            }
        }
        System.out.println();
        // Agora vamos percorrer o texto inserido e comparar com o nosso vetor codificado.
        for(int i = 0; i<txt.length();i++){
            for(int k = 0; k<vetorAlfabeto.length; k++){
                if(txt.charAt(i) == vetorAlfabeto[k]){
                    // Adiciona letra minuscula.
                    vetorTexto[i] += vetorCodigo[k];
                    break;
                }
                if(txt.charAt(i) == Character.toUpperCase(vetorAlfabeto[k])){
                    // Adiciona letra maiuscula.
                    vetorTexto[i] += Character.toUpperCase(vetorCodigo[k]);
                    break;
                }
                if(txt.charAt(i) == ' '){
                    // Adiciona espaço.
                    vetorTexto[i] += ' ';
                    break;
                }
            }
        }
        // Por último, vamos transformar o vetor em texto
        novoTexto = new String(vetorTexto);
        return novoTexto;
    }
    public static String decode(String txt, int key, boolean debug){
        String alfabetoString = "abcdefghijklmnopqrstuvwxyz";
        String novoTexto = "";
        char[] vetorAlfabeto = alfabetoString.toCharArray();
        char[] vetorCodigo = new char[26];
        char[] vetorTexto = new char[txt.length()];
        // Preenchendo o Codigo com base na chave inserida.
        // Primeiro vamos preencher utilizando a chave como o indice.
        int j = 0;
        for(int i = key; i < vetorAlfabeto.length; i++){
            vetorCodigo[i] = vetorAlfabeto[j];
            j++;
        }
        // Depois vamos preencher as letras que restam.
        for(int i = 0; i < key; i++){
            vetorCodigo[i] = vetorAlfabeto[j];
            j++;
        }
        // Debug
        if(debug){
            System.out.print("DEBUG: VetorCodigo: ");
            for (char letra : vetorCodigo) {
                System.out.print(letra + " ");
            }
        }
        // Agora vamos percorrer o texto inserido e comparar com o nosso vetor alfabeto.
        for(int i = 0; i<txt.length();i++){
            for(int k = 0; k<vetorCodigo.length; k++){
                if(txt.charAt(i) == vetorCodigo[k]){
                    // Adiciona letra minuscula.
                    vetorTexto[i] += vetorAlfabeto[k];
                    break;
                }
                if(txt.charAt(i) == Character.toUpperCase(vetorCodigo[k])){
                    // Adiciona letra maiuscula.
                    vetorTexto[i] += Character.toUpperCase(vetorAlfabeto[k]);
                    break;
                }
                if(txt.charAt(i) == ' '){
                    // Adiciona espaço.
                    vetorTexto[i] += ' ';
                    break;
                }
            }
        }
        // Por último, vamos transformar o vetor em texto
        novoTexto = new String(vetorTexto);
        return novoTexto;
    }
    public static int getnumber() {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        return num;
    }
    public static String gettext() {
        Scanner scan = new Scanner(System.in);
        String txt = scan.nextLine();
        return txt;
    }
}
