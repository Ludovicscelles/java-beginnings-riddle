package ex01_number_riddle;

import java.util.Random;
import java.util.Scanner;

public class NumberRiddle {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int secret = random.nextInt(1, 101);
    int essais = 0;
    int proposition;

    System.out.println("Devinez le chiffre secret entre 1 et 100 ! ");

    while (true) {
      System.out.print("Votre proposition : ");
      proposition = scanner.nextInt();
      essais++;

      if (proposition < secret) {
        System.out.println("Trop petit !");
      } else if (proposition > secret) {
        System.out.println("Trop grand !");
      } else {
        System.out.printf("Bravo ! %d est le chiffre secret !%nNombre d'essais : %d.%n", secret, essais);
        break;
      }

    }
    scanner.close();
  }
}