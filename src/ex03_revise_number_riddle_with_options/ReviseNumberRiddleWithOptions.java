package ex03_revise_number_riddle_with_options;

import java.util.Random;
import java.util.Scanner;

// Secret number game with difficulty, trial limit and replay option.
public class ReviseNumberRiddleWithOptions {

  public static void main(String[] args) {

    // Resources used for the entire application.
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    boolean replay = true;

    // Main loop: allows to replay multiple games.
    while (replay) {

      // Game parameters chosen by the user.
      int max = chooseDifficulty(scanner);
      int maxTrials = choiceMaxTrials(scanner);

      // Initialization of the game state.
      int secret = random.nextInt(1, max + 1);
      int trials = 0;
      boolean win = false;

      System.out.printf("%nTrouve le nombre secret entre 1 et %d. Tu as %d tentatives.%n", max, maxTrials);

      // Game loop: continues as long as there are trials left and the player hasn't
      // won.
      while (trials < maxTrials && !win) {

        // Input validation: ensures the user enters a valid integer within the
        // specified range.
        int proposition;
        do {
          System.out.print("Proposition : ");
          while (!scanner.hasNextInt()) {
            System.out.printf("Veuillez entrer un nombre entier valide entre 1 et %d : ", max);
            scanner.next();
          }
          proposition = scanner.nextInt();
          if (proposition < 1 || proposition > max) {
            System.out.printf("Tu es hors des limites ! Le nombre doit être entre 1 et %d. Réessaie. ", max);
          }
        } while (proposition < 1 || proposition > max);
        trials++;

        // Indications to guide the player.
        if (proposition < secret) {
          System.out.printf("Trop Petit !%n");
        } else if (proposition > secret) {
          System.out.printf("Trop grand !%n");
        } else {
          win = true;
          System.out.printf("Bravo ! Tu as gagné au bout de %d tentatives, le nombre secret est bien %d. ", trials,
              secret);
        }
      }

      // If the loop ends without a win -> defeat.
      if (!win) {
        System.out.printf("Perdu. Le nombre secret est %d. ", secret);
      }

      // Ask if the user wants to replay.
      System.out.println();
      System.out.print("Souhaites-tu rejouer ? (o/n) : ");
      String answer = scanner.next();
      replay = answer.equalsIgnoreCase("o");

    }

    scanner.close();

  }

  // Difficulty choice -> defines the upper bound of the secret number.
  static int chooseDifficulty(Scanner scanner) {

    int choice;

    do {
      System.out.println();
      System.out.println("Choisis un niveau de difficulté : ");
      System.out.println("1) Facile (entre 1 et 50)");
      System.out.println("2) Intermédiaire (entre 1 et 100)");
      System.out.println("3) Difficile (entre 1 et 500)");

      while (!scanner.hasNextInt()) {
        System.out.println("Veuillez entrer un nombre entier valide : ");
        scanner.next();

      }

      choice = scanner.nextInt();

    } while (choice < 1 || choice > 3);

    if (choice == 1) {
      return 50;
    } else if (choice == 3) {
      return 500;
    } else {
      return 100;
    }
  }

  // Asks for the maximum number of trials (minimum 1)
  static int choiceMaxTrials(Scanner scanner) {
    System.out.print("Choisis un nombre d'essais maximum (ex : 8) : ");
    while (!scanner.hasNextInt()) {
      System.out.println("Veuillez entrer un nombre entier valide : ");
      scanner.next();
    }
    int max = scanner.nextInt();
    return Math.max(max, 1);
  }
}