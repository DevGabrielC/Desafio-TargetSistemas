package src.application;

import java.util.Locale;
import java.util.Scanner;

public class ExecicioDois {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Fibonacci

        System.out.print("Digite um número: ");
        int numero = sc.nextInt();

        if (pertenceFibonacci(numero)) {
            System.out.printf(String.format("O número %d pertence a sequência Fibonacci!", numero));
        } else {
            System.out.printf(String.format("O número %d não pertence a sequência Fibonacci!", numero));
        }

        sc.close();
    }

    public static boolean pertenceFibonacci(int numero) {
        if (numero < 0) {
            return false;
        }
        int a = 0, b = 1;

        if (numero == a || numero == b) {
            return true;
        }

        int c = a + b;
        while (c <= numero) {
            if (c == numero) {
                return true;
            }
            a = b;
            b = c;
            c = a + b;
        }

        return false;
    }
}
