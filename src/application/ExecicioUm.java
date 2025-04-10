package src.application;

public class ExecicioUm {
    public static void main(String[] args) {

        int indice = 13, soma = 0, K = 0;

        while (K < indice) {
            K++;
            soma += K;
        }
        System.out.println(soma);
    }
}