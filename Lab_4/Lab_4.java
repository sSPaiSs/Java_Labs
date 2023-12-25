package Lab_4;

public class Lab_4 {
    public static int findMaxByAbsoluteValue(int[] arr) {
        int maxAbsValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(maxAbsValue)) {
                maxAbsValue = arr[i];
            }
        }
        return maxAbsValue;
    }

    public static double calculateAverageForIndicesDivisibleBy3(int[] arr) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i += 3) {
            sum += arr[i];
            count++;
        }
        return (double) sum / count;
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversedArray = new int[arr.length];
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            reversedArray[j] = arr[i];
        }
        return reversedArray;
    }

    public static void main(String[] args) {
        // Заданий масив
        int[] myArray = {10, -5, 8, -3, 7, -1, -9, 4, 2, -6};

        // Знайти максимальний за модулем елемент масиву
        int maxAbsoluteValue = findMaxByAbsoluteValue(myArray);
        System.out.println("Максимальний за модулем елемент масиву: " + maxAbsoluteValue);

        // Знайти середнє арифметичне елементів масиву, індекс яких кратний 3
        double averageForIndicesDivisibleBy3 = calculateAverageForIndicesDivisibleBy3(myArray);
        System.out.println("Середнє арифметичне елементів масиву, індекс яких кратний 3: " + averageForIndicesDivisibleBy3);

        // Сформувати новий масив, елементи якого це елементи старого масиву у зворотному порядку
        int[] reversedArray = reverseArray(myArray);
        System.out.print("Новий масив у зворотному порядку: ");
        for (int element : reversedArray) {
            System.out.print(element + " ");
        }
    }
}