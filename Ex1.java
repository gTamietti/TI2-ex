package Ex;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número:");
        double numero1 = scanner.nextDouble();

        System.out.println("Digite o segundo número:");
        double numero2 = scanner.nextDouble();

        double soma = numero1 + numero2;

        System.out.println("A soma dos dois números é: " + soma);

        scanner.close(); 

}
}
