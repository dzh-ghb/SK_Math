import java.util.Random;
import java.util.Scanner;

public class L_5_8_Squid_Game {
    public static void main(String[] args) {
        Random random = new Random();
        int coins = random.nextInt(11) + 20;
        int player = 1;
        int counter = 1;
        boolean isGameOver = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите максимальное количество монет, которое можно взять за ход: ");
        int maxPerTurn = scanner.nextInt();

        while (!isGameOver) {
            System.out.print("_____________________"
                    + "\nХод №" + counter
                    + "\nОстаток монет: " + coins
                    + "\nИгрок №" + player + " забирает: ");
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

            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
            counter++;
        }
        System.out.println("_____________________"
                + "\nПобедил игрок №" + player);
    }
}
