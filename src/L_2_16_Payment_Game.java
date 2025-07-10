import java.util.Random;

public class L_2_16_Payment_Game {
    private static final int TOTAL_GAMES = 1000; //количество серий игр
    private static final int FIRST_PLAYER_WIN_COMBO = 7; //выигрышная комбинация первого игрока
    private static final int SECOND_PLAYER_WIN_COMBO = 8; //-//- второго игрока
    private static final int PLAYER_ROLLS = 50; //бросков за одну серию

    public static void main(String[] args) {
        Random random = new Random();
        int[] totalScore = {0, 0}; //итоговый счет {победы игрока №1, победы игрока №2}
        int currentGame = 1; //счетчик текущей серии игры
        int drawCount = 0; //счетчик ничьих

        while (currentGame <= TOTAL_GAMES) {
            int firstPlayerRolls = PLAYER_ROLLS, secondPlayerRolls = firstPlayerRolls; //бросков внутри одной серии

            int firstPlayerWins = 0, secondPlayerWins = 0; //счетчик побед в одной серии

            while (firstPlayerRolls > 0) {
                int firstRoll = random.nextInt(6) + 1; //значение кубика - от 1 до 6 (через рандом - 0..5 + 1)
                int secondRoll = random.nextInt(6) + 1;
                if (firstRoll + secondRoll == FIRST_PLAYER_WIN_COMBO) {
                    firstPlayerWins++;
                }
                firstPlayerRolls--;
            }
            while (secondPlayerRolls > 0) {
                int firstRoll = random.nextInt(6) + 1;
                int secondRoll = random.nextInt(6) + 1;
                if (firstRoll + secondRoll == SECOND_PLAYER_WIN_COMBO) {
                    secondPlayerWins++;
                }
                secondPlayerRolls--;
            }
//            System.out.println("Счет в серии №" + currentGame + ": {Игрок №1 - " + firstPlayerWins + " : Игрок №2 - " + secondPlayerWins + "}");

            if (firstPlayerWins > secondPlayerWins) {
                totalScore[0]++; //по итогам серии игры победил игрок №1
            } else if (firstPlayerWins < secondPlayerWins) {
                totalScore[1]++; //-//- игрок №2
            } else {
                drawCount++; //ничья в серии (за 50 попыток у каждого игрока нужное значение выпало одинаковое количество раз)
            }
            currentGame++;
        }
        System.out.println("\nВсего серий игр: " + TOTAL_GAMES
                + "\nИтоговый счет после всех серий: " + totalScore[0] + " : " + totalScore[1]
                + "\nНичьих внутри одной серии: " + drawCount
                + "\n(Проверочное значение - сумм всех итогов игр: " + (totalScore[0] + totalScore[1] + drawCount) + ")");
    }
}
