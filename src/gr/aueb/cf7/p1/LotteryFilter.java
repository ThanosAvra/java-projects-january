package gr.aueb.cf7.p1;

import java.io.*;
import java.util.*;

public class LotteryFilter {
    public static void main(String[] args) throws IOException {

        // Διάβασμα αρχείου
        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/avram/Desktop/numbers.txt"));


        List<Integer> numbersList = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                numbersList.add(Integer.parseInt(line));
            }
        }
        reader.close();


        if (numbersList.size() < 6 || numbersList.size() > 49) {
            throw new IllegalArgumentException("Το αρχείο πρέπει να περιέχει περισσότερους από 6 αριθμούς και το πολύ 49 αριθμούς.");
        }

        int[] numbers = numbersList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(numbers);

        // Άνοιγμα αρχείου για αποθήκευση των τελικών εξάδων
        BufferedWriter writer = new BufferedWriter(new FileWriter("final_combinations.txt"));

        // Παράγει εξάδες και τις φιλτράρει κατά τη διάρκεια δημιουργίας τους
        int n = numbers.length;
        for (int i = 0; i < n - 5; i++) {
            for (int j = i + 1; j < n - 4; j++) {
                for (int k = j + 1; k < n - 3; k++) {
                    for (int l = k + 1; l < n - 2; l++) {
                        for (int m = l + 1; m < n - 1; m++) {
                            for (int o = m + 1; o < n; o++) {
                                int[] combo = {numbers[i], numbers[j], numbers[k], numbers[l], numbers[m], numbers[o]};
                                if (isValidCombination(combo)) {
                                    writer.write(Arrays.toString(combo));
                                    writer.newLine();
                                }
                            }
                        }
                    }
                }
            }
        }

        writer.close();
    }

    private static boolean isValidCombination(int[] combo) {
        return countEvens(combo) <= 4 && countOdds(combo) <= 4 &&
                countContiguous(combo) <= 2 && countSameEnding(combo) <= 3 &&
                countSameTen(combo) <= 3;
    }

    private static int countEvens(int[] combo) {
        int count = 0;
        for (int num : combo) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int countOdds(int[] combo) {
        int count = 0;
        for (int num : combo) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    private static int countContiguous(int[] combo) {
        int count = 0;
        for (int i = 0; i < combo.length - 1; i++) {
            if (combo[i] + 1 == combo[i + 1]) {
                count++;
            }
        }
        return count;
    }

    private static int countSameEnding(int[] combo) {
        int[] endings = new int[10];
        for (int num : combo) {
            endings[num % 10]++;
        }
        int max = 0;
        for (int ending : endings) {
            if (ending > max) {
                max = ending;
            }
        }
        return max;
    }

    private static int countSameTen(int[] combo) {
        int[] tens = new int[5];
        for (int num : combo) {
            tens[num / 10]++;
        }
        int max = 0;
        for (int ten : tens) {
            if (ten > max) {
                max = ten;
            }
        }
        return max;
    }
}
