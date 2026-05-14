package projetosportifolio.util;

public class Ordenacao {
    public static void main(String[] args) {
        int[] vetor = {6, 8, 10, 5, 1};
        ordenarVetor(vetor, true);
    }
    public static void ordenarVetor(int[] v, boolean c){
        int aux=0;
        int acertos=0;
        if(c){
            // ordenacao de forma crescente
            for(int i=0; i<v.length; i++){
                if(v[i+1] < v[i]){
                    // trocar
                    aux = v[i+1];
                    v[i+1] = v[i];
                    v[i] = aux;
                    i=acertos;
                }else{
                    acertos++;
                }
            }
        }
        // imprimindo resultado
        System.out.println("Resultado vetor: ");
        for (int i : v) {
            System.out.print(i + " ");
        }
    }
}
