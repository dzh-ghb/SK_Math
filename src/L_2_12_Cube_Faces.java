import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class L_2_12_Cube_Faces {
    private static final int REPEATS_COUNT = 1_000_000;

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> cubeList = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
        int count = REPEATS_COUNT;
        while (count > 0) {
            int position = random.nextInt(6);
            cubeList.set(position, cubeList.get(position) + 1);
            count--;
        }
        System.out.println(cubeList + "\n");

        double totalPercent = 0;
        for (int i = 0; i < cubeList.size(); i++) {
            double percent = (double) cubeList.get(i) / REPEATS_COUNT * 100;
            System.out.printf("Процент выпадения грани %d: %.2f\n", (i + 1), percent);
            totalPercent += percent;
        }
        System.out.printf("\nОбщая вероятность (для проверки): %.2f", totalPercent);
    }
}
