import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //ЗАДАЧА a
        int N  = 11;
        int n1 = -20;
        int n2 = 30;

        if (args.length >= 3) {
            N  = Integer.parseInt(args[0]);
            n1 = Integer.parseInt(args[1]);
            n2 = Integer.parseInt(args[2]);
        }

        Random random = new Random();
        int[] series = new int[N];
        for (int i = 0; i < N; i++) {
            series[i] = n1 + random.nextInt(n2 - n1 + 1);
        }

        System.out.println("ЗАДАЧА a. Сгенерированный ряд из " + N + " элементов");
        System.out.println("Диапазон: [" + n1 + "; " + n2 + "]");
        System.out.println("Ряд: " + Arrays.toString(series));

        //ЗАДАЧА b
        int min = series[0];
        int max = series[0];
        for (int v : series) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        int range = max - min;

        System.out.println("\nЗАДАЧА b. Размах ряда");
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("R = max - min = " + range);

        //ЗАДАЧА c
        int[] sorted = Arrays.copyOf(series, series.length);
        Arrays.sort(sorted);

        double median;
        int size = sorted.length;
        if (size % 2 == 1) {
            median = sorted[size / 2];
        } else {
            median = (sorted[size / 2 - 1] + sorted[size / 2]) / 2.0;
        }

        System.out.println("\nЗАДАЧА c. Медиана ряда");
        System.out.println("Упорядоченный ряд: " + Arrays.toString(sorted));
        System.out.println("Медиана = " + median);

        //ЗАДАЧА d
        String text  = "кот пёс кот сова кот пёс сова кот";
        String word1 = "кот";
        String word2 = "пёс";
        String word3 = "сова";

        String[] tokens = text.split("\\s+");

        Map<String, Integer> freq = new HashMap<>();
        freq.put(word1, 0);
        freq.put(word2, 0);
        freq.put(word3, 0);

        for (String token : tokens) {
            if (freq.containsKey(token)) {
                freq.put(token, freq.get(token) + 1);
            }
        }

        System.out.println("\nЗАДАЧА d. Частоты слов");
        System.out.println("Строка: " + text);
        System.out.println("Слова для поиска: \"" + word1 + "\", \""
                + word2 + "\", \"" + word3 + "\"");
        System.out.println("\nРезультат:");
        System.out.println("  \"" + word1 + "\" встречается " + freq.get(word1) + " раз");
        System.out.println("  \"" + word2 + "\" встречается " + freq.get(word2) + " раз");
        System.out.println("  \"" + word3 + "\" встречается " + freq.get(word3) + " раз");
    }
}