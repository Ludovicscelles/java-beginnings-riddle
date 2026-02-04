package riddle;

// Imports Random and Scanner classes
import java.util.Random;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int secret = random.nextInt(100) + 1;
    int essais = 0;
    int proposition = 0;

    while (proposition != secret) {
      System.out.print("Ta proposition : ");
      proposition = scanner.nextInt();
      essais++;

      if (proposition < secret) {
        System.out.println("C'est trop petit !");
      } else if (proposition > secret) {
        System.out.println("C'est trop grand !");
      } else {
        System.out.printf("Bravo ! C'est gagné ! Le nombre était bien %d.%nNombre d'essais effectués : %d%n", secret,
            essais);
      }
    }
    scanner.close();
  }
}