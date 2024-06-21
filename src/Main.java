import java.util.Scanner;

public class Main {

    static final String[] romanNumerals = {
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

    static final int[] arabicValues = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
            51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
            61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
            71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
            81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
            91, 92, 93, 94, 95, 96, 97, 98, 99, 100
    };


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println(result);
        }
        catch (Exception exception) {
            System.out.println("Ошибка: " + exception.getMessage());
        }

    }

    public static String calc(String input) throws Exception {

        String[] numbers = input.split(" ");
        if (numbers.length != 3) {
            throw new Exception("Неверный формат ввода");
        }

        String num1 = numbers[0];
        String num2 = numbers[2];
        String operator = numbers[1];

        int number1;
        int number2;

        boolean isRoman = (isRomanNumeral(num1) && isRomanNumeral(num2));

        if (isRoman) {
            number1 = romanToArabic(num1);
            number2 = romanToArabic(num2);
        }
        else {
            number1 = Integer.parseInt(num1);
            number2 = Integer.parseInt(num2);

        }

        if (number1 < 1 || number2 > 10 || number1 > 10 || number2 < 1) {
            throw new Exception("Числа должны быть больше нуля и меньше десяти (включительно)");
        }

        int result = 0;
        switch (operator) {
            case "-":
                result = number1 - number2;
                break;
            case "+":
                result = number1 + number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 == 0) {
                    throw new Exception("Деление на ноль");
                }
                result = number1 / number2;
                break;
            default:
                throw new Exception("Неверный оператор");
        }

        if (isRoman)
        {
             return arabicToRoman(result); }
        else
            return String.valueOf(result);

    }

    static boolean isRomanNumeral(String input) {
        for (String numeral : romanNumerals) {
            if (numeral.equals(input)) {
                return true;
            }
        }
        return false;
    }
    static int romanToArabic(String input) throws Exception {
        for (int i = 0; i < romanNumerals.length; i++) {
            if (romanNumerals[i].equals(input)) {
                return arabicValues[i];
            }
        }
        throw new Exception("Некорректное римское число");
    }

    static String arabicToRoman(int result) throws Exception {
        for (int i = 0; i < arabicValues.length; i++) {
            if (arabicValues[i] == result) {
                return romanNumerals[i];
            }
        }
        throw new Exception("Некорректное арабское число");
    }



}
