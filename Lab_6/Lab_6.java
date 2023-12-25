package Lab_6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab_6 {

    public static int octStringToInt(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string is empty or null");
        }

        int result = 0;
        int power = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char digitChar = s.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            result += digit * Math.pow(8, power);
            power++;
        }

        return result;
    }

    public static int countNumbersInSentence(String sentence) {
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(sentence);

        int count = 0;

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        // Приклад використання для перетворення вісімкового числа
        String octalString = "777";
        int octalResult = octStringToInt(octalString);
        System.out.println("Результат перетворення вісімкового числа '" + octalString + "' в int: " + octalResult);

        // Приклад використання для підрахунку чисел у реченні
        String inputSentence = "The user with the nickname koala757677 this month wrote 3 times more " +
                "comments than the user with the nickname croco181dile920 4 months ago";
        int numbersCount = countNumbersInSentence(inputSentence);
        System.out.println("Кількість чисел у реченні: " + numbersCount);
    }
}

