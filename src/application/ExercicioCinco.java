package src.application;

import java.util.Scanner;

public class ExercicioCinco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma string para inverter: ");
        String stringOriginalDigitavel = sc.nextLine();
        sc.close();

        String stringInvertida = inverterString(stringOriginalDigitavel);

        System.out.println("String original: " + stringOriginalDigitavel);
        System.out.println("String invertida: " + stringInvertida);
    }

    public static String inverterString(String str) {

        char[] caracteres = str.toCharArray();
        int inicio = 0;
        int fim = caracteres.length - 1;

        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;

            inicio++;
            fim--;
        }
        return new String(caracteres);
    }
}