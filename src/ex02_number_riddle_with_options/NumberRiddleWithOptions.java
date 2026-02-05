package ex02_number_riddle_with_options;

import java.util.Random;
import java.util.Scanner;

// Jeu du nombre mystère avec difficulté, nombre d'essais limité et option rejouer.
public class NumberRiddleWithOptions {

  // Le programme génère un nombre aléatoire entre 1 et un maximum choisi par l'utilisateur.
  public static void main(String[] args) {

    // Ressources partagées pour toute l'application.
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    boolean replay = true;

    // Boucle principale : permet de rejouer plusieurs parties.
    while (replay) {

     // Paramètres de la partie choisis par l'utilisateur.
      int max = chooseDifficulty(scanner);
      int maxTrials = choiceMaxTrials(scanner);

      // Initialisation de l'état du jeu.
      int secret = random.nextInt(max) + 1; // nombre entre 1 et max
      int trials = 0;
      boolean win = false;

      System.out.printf("%nTrouve le nombre entre 1 et %d. Tu as %d tentatives.", max, maxTrials);

      // Boucle du jeu : continue tant qu'il reste des essais et que le joueur n'a pas gagné.
      while (trials < maxTrials && !win) {

        System.out.print("Proposition : ");
        int proposition = scanner.nextInt();
        trials++;

        // Indications pour guider le joueur.
        if (proposition < secret) {
          System.out.println("Trop petit !");
        } else if (proposition > secret) {
          System.out.println("Trop grand !");
        } else {
          win = true;
          System.out.printf("Bravo ! Tu as gagné en effectuant %d essais, le nombre secret est bien %d.", trials, secret);
        }
      }

      // Si la boucle se termine sans victoire -> defaite.
      if (!win) {
        System.out.printf("Perdu. Le nombre était %d.", secret);
      }
      // Demande si l'utilisateur souhaite rejouer.
      System.out.println();
      System.out.print("Veux-tu rejouer ? (o/n) : ");
      String answer = scanner.next();
      replay = answer.equalsIgnoreCase("o");

    }
  }

  // Choix de la difficulté -> définit la borne maximale du nombre secret.
  static int chooseDifficulty(Scanner scanner) {
    System.out.println();
    System.out.println("Choisis un niveau de difficulté : ");
    System.out.println("1) Facile (entre 1 et 50)");
    System.out.println("2) Intermédiaire (entre 1 et 100)");
    System.out.println("3) Difficile (entre 1 et 500)");

    int choice = scanner.nextInt();
    if (choice == 1)
      return 50;
    if (choice == 3)
      return 500;
    return 100;
  }

  // Demande le nombre maximum d'essais (minimum 1)
  static int choiceMaxTrials(Scanner scanner) {
    System.out.print("Choisis un nombre d'essais maximum (ex: 8) : ");
    int n = scanner.nextInt();
    return Math.max(n, 1);
  }
}