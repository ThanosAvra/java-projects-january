package gr.aueb.cf7.p5;

public class TheaterBooking {
    private static final int ROWS = 30;
    private static final int COLUMNS = 12;
    private static boolean[][] theater = new boolean[ROWS][COLUMNS];

    public static void main(String[] args) {
        book('C', 2);
        book('A', 1);
        cancel('C', 2);
        printTheater();
    }

    public static void book(char column, int row) {
        int colIndex = column - 'A';
        int rowIndex = row - 1;
        if (!theater[rowIndex][colIndex]) {
            theater[rowIndex][colIndex] = true;
            System.out.println("Θέση " + column + row + " κλείστηκε.");
        } else {
            System.out.println("Θέση " + column + row + " είναι ήδη κλεισμένη.");
        }
    }

    public static void cancel(char column, int row) {
        int colIndex = column - 'A';
        int rowIndex = row - 1;
        if (theater[rowIndex][colIndex]) {
            theater[rowIndex][colIndex] = false;
            System.out.println("Κράτηση της θέσης " + column + row + " ακυρώθηκε.");
        } else {
            System.out.println("Θέση " + column + row + " δεν είναι κλεισμένη.");
        }
    }

    public static void printTheater() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print((theater[i][j] ? "B " : "- "));
            }
            System.out.println();
        }
    }
}
