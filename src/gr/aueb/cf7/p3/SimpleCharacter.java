package gr.aueb.cf7.p3;

public class SimpleCharacterFrequency {
    private static final int ASCII_CHARACTERS = 128;

    public static void main(String[] args) {
        int[] frequencies = new int[ASCII_CHARACTERS];

        // Read the file and count character frequencies
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/avram/Desktop/HelloWorldImThanos.txt")) {
            int c;
            while ((c = br.read()) != -1) {
                if (c < ASCII_CHARACTERS && !Character.isWhitespace(c)) {
                    frequencies[c]++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display statistics sorted by character
        System.out.println("Statistics sorted by character:");
        for (int i = 0; i < ASCII_CHARACTERS; i++) {
            if (frequencies[i] > 0) {
                System.out.printf("%c: %d%n", i, frequencies[i]);
            }
        }

        // Display statistics sorted by frequency
        System.out.println("\nStatistics sorted by frequency:");
        for (int i = 0; i < ASCII_CHARACTERS; i++) {
            for (int j = 0; j < ASCII_CHARACTERS - 1; j++) {
                if (frequencies[j] < frequencies[j + 1]) {
                    int temp = frequencies[j];
                    frequencies[j] = frequencies[j + 1];
                    frequencies[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < ASCII_CHARACTERS; i++) {
            if (frequencies[i] > 0) {
                System.out.printf("%c: %d%n", i, frequencies[i]);
            }
        }
    }
}
