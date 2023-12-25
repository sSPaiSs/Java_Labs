package Lab_5;

public class Lab_5 {

    public static void insertionSortDescending(short[] array) {
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            short key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void bubbleSortDescending(short[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    short temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Приклад використання для Insertion Sort
        short[] insertionSortArray = {5, 2, 8, 1, 3};
        insertionSortDescending(insertionSortArray);

        System.out.print("Масив після сортування за спаданням (Insertion Sort): ");
        for (short element : insertionSortArray) {
            System.out.print(element + " ");
        }

        System.out.println();  // Розділовий рядок між двома методами сортування

        // Приклад використання для Bubble Sort
        short[] bubbleSortArray = {5, 2, 8, 1, 3};
        bubbleSortDescending(bubbleSortArray);

        System.out.print("Масив після сортування за спаданням (Bubble Sort): ");
        for (short element : bubbleSortArray) {
            System.out.print(element + " ");
        }
    }
}