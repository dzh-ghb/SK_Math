import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class L_2_18_Roll_Dice_n_Drop_1 {
    private static final int TOTAL_GAMES = 10_000_000; //всего игр
    private static final int TOTAL_ROLL_PER_GAME = 4; //количество бросков в одной игре

    public static void main(String[] args) {
        Random random = new Random();
        int currentGame = 1;
        List<Integer> playersResultList = new ArrayList<>(List.of(0, 0)); //для хранения результатов игр
        List<Integer> rollsPerGameList = new ArrayList<>(List.of(0, 0, 0, 0)); //для хранения результатов бросков

        while (currentGame <= TOTAL_GAMES) {
            for (int i = 0; i < TOTAL_ROLL_PER_GAME; i++) { //4 броска за игру
                int roll = random.nextInt(6) + 1;
                rollsPerGameList.set(i, roll);
            }

            int unitCounter = 0;
            for (int each : rollsPerGameList) { //подсчет выпавших единиц
                if (each == 1) {
                    unitCounter++;
                }
            }

            if (unitCounter == 1) {
                playersResultList.set(0, playersResultList.get(0) + 1); //если единица одна - счетчик 1-го игрока ++
            } else {
                playersResultList.set(1, playersResultList.get(1) + 1); //счетчик 2-го игрока ++
            }
//            System.out.println("Серия №" + currentGame
//                    + ": промежуточный итог - " + playersResultList.get(0) + " : " + playersResultList.get(1)
//                    + " (результаты бросков - " + rollsPerGameList + ")");
            currentGame++;
        }

//        System.out.println();
        System.out.printf("Итоговый результат - %d (Игрок №1) : %d (Игрок №2)"
                        + "\nВ процентном соотношении - %.2f%% : %.2f%%",
                playersResultList.get(0),
                playersResultList.get(1),
                (double) playersResultList.get(0) / TOTAL_GAMES * 100,
                (double) playersResultList.get(1) / TOTAL_GAMES * 100);
    }
}
