import java.util.Random;
import java.util.Scanner;

public class L_6_1_Squid_Game_vs_Bot {
    public static void main(String[] args) {
        Random random = new Random();
        int coins = random.nextInt(11) + 20;
        int player = 1;
        int counter = 1;
        boolean isGameOver = false;
        boolean isPlayerFirst = random.nextBoolean();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите максимальное количество монет, которое можно взять за ход: ");
        int maxPerTurn = scanner.nextInt();

        while (!isGameOver) {
            if (isPlayerFirst) {
                System.out.print("________________________"
                        + "\nХод №" + counter
                        + "\nОстаток монет: " + coins
                        + "\nИгрок №1 забирает: ");
                int coinsPerTurn = scanner.nextInt();
                if (coinsPerTurn < 1 || coinsPerTurn > maxPerTurn) {
                    System.out.println("Введено некорректное количество монет");
                    continue;
                }
                coins -= coinsPerTurn;
                if (coins <= 0) {
                    isGameOver = true;
                    continue;
                }
                counter++;

                player = 2;
                coinsPerTurn = random.nextInt(maxPerTurn) + 1;
                System.out.print("________________________"
                        + "\nХод №" + counter
                        + "\nОстаток монет: " + coins
                        + "\nИгрок №2 (К) забирает: " + coinsPerTurn
                        + "\n");
                coins -= coinsPerTurn;
                if (coins <= 0) {
                    isGameOver = true;
                    continue;
                }
                player = 1;
            } else {
                int coinsPerTurn = random.nextInt(maxPerTurn) + 1;
                if (player < 3) {
                    System.out.print("________________________"
                            + "\nХод №" + counter
                            + "\nОстаток монет: " + coins
                            + "\nИгрок №1 (К) забирает: " + coinsPerTurn
                            + "\n");
                    coins -= coinsPerTurn;
                    if (coins <= 0) {
                        isGameOver = true;
                        player = 1;
                        continue;
                    }
                    counter++;
                }

                System.out.print("________________________"
                        + "\nХод №" + counter
                        + "\nОстаток монет: " + coins
                        + "\nИгрок №2 забирает: ");
                coinsPerTurn = scanner.nextInt();
                if (coinsPerTurn < 1 || coinsPerTurn > maxPerTurn) {
                    System.out.println("Введено некорректное количество монет");
                    player = 3; //костыль, чтобы ход не переходил к компьютеру
                    continue;
                }
                coins -= coinsPerTurn;
                player = 2;
                if (coins <= 0) {
                    isGameOver = true;
                    continue;
                }
            }
            counter++;
        }
        System.out.println("________________________"
                + "\nПобедил игрок №" + player);
    }
}
