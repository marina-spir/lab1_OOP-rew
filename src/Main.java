import java.util.Arrays;
import java.util.Random;

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

        if (N < 1 || n1 > n2) {
            System.out.println("Ошибка: должно быть N >= 1 и n1 <= n2");
            return;
        }

        int[] series = generateSeries(N, n1, n2);

        System.out.println("ЗАДАЧА a. Сгенерированный ряд из " + N + " элементов");
        System.out.println("Диапазон: [" + n1 + "; " + n2 + "]");
        System.out.println("Ряд: " + Arrays.toString(series));

        //ЗАДАЧА b
        int min = findMin(series);
        int max = findMax(series);
        int range = max - min;

        System.out.println("\nЗАДАЧА b. Размах ряда");
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("R = max - min = " + range);

        //ЗАДАЧА c
        int[] sorted = sortSeries(series);
        double median = findMedian(sorted);

        System.out.println("\nЗАДАЧА c. Медиана ряда");
        System.out.println("Упорядоченный ряд: " + Arrays.toString(sorted));
        System.out.println("Медиана = " + median);

        //ЗАДАЧА d
        String text  = "кот пёс кот сова кот пёс сова кот";
        String word1 = "кот";
        String word2 = "пёс";
        String word3 = "сова";

        System.out.println("\nЗАДАЧА d. Частоты слов");
        System.out.println("Строка: " + text);
        System.out.println("Слова для поиска: \"" + word1 + "\", \""
                + word2 + "\", \"" + word3 + "\"");
        System.out.println("\nРезультат:");
        System.out.println("  \"" + word1 + "\" встречается " + countWord(text, word1) + " раз");
        System.out.println("  \"" + word2 + "\" встречается " + countWord(text, word2) + " раз");
        System.out.println("  \"" + word3 + "\" встречается " + countWord(text, word3) + " раз");
    }

    // формирует ряд из n случайных целых чисел из диапазона [n1; n2]
    private static int[] generateSeries(int n, int n1, int n2) {
        Random random = new Random();
        int[] series = new int[n];
        for (int i = 0; i < n; i++) {
            series[i] = n1 + random.nextInt(n2 - n1 + 1);
        }
        return series;
    }

    // возвращает минимальный элемент ряда
    private static int findMin(int[] series) {
        int min = series[0];
        for (int v : series) {
            if (v < min) min = v;
        }
        return min;
    }

    // возвращает максимальный элемент ряда
    private static int findMax(int[] series) {
        int max = series[0];
        for (int v : series) {
            if (v > max) max = v;
        }
        return max;
    }

    // возвращает упорядоченную по возрастанию копию ряда
    private static int[] sortSeries(int[] series) {
        int[] sorted = Arrays.copyOf(series, series.length);
        Arrays.sort(sorted);
        return sorted;
    }

    // вычисляет медиану упорядоченного ряда
    private static double findMedian(int[] sorted) {
        int size = sorted.length;
        if (size % 2 == 1) {
            return sorted[size / 2];
        } else {
            return (sorted[size / 2 - 1] + sorted[size / 2]) / 2.0;
        }
    }

    // подсчитывает, сколько раз слово word встречается в строке text
    private static int countWord(String text, String word) {
        String[] tokens = text.split("\\s+");
        int count = 0;
        for (String token : tokens) {
            if (token.equals(word)) count++;
        }
        return count;
    }
}