import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Main {
    private Main() {
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        int[] numbers = {4, 2, 7, 1, 6};
        int[] sortable = {5, 1, 4, 1, 3};
        int[][] maze = {
                {0, 0, 1, 0},
                {1, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0}
        };

        System.out.println("1. Числа от 1 до 5:");
        RecursionTasks.printAscending(5);

        System.out.println("\n2. Числа от 5 до 1:");
        RecursionTasks.printDescending(5);

        System.out.println("\n3. Сумма чисел от 1 до 5: " + RecursionTasks.sumToN(5));
        System.out.println("4. Факториал 5: " + RecursionTasks.factorial(5));
        System.out.println("5. 2 в степени 10: " + RecursionTasks.power(2, 10));
        System.out.println("6. Сумма цифр числа 583: " + RecursionTasks.sumDigits(583));
        System.out.println("7. Количество цифр в 583: " + RecursionTasks.countDigits(583));
        System.out.println("8. Произведение цифр числа 234: " + RecursionTasks.productDigits(234));
        System.out.println("9. Максимальная цифра числа 583: " + RecursionTasks.maxDigit(583));
        System.out.println("10. Минимальная цифра числа 583: " + RecursionTasks.minDigit(583));
        System.out.println("11. Число Фибоначчи F(10): " + RecursionTasks.fibonacci(10));
        System.out.println("12. Сумма массива: " + RecursionTasks.sumArray(numbers, 0));
        System.out.println("13. Максимум массива: " + RecursionTasks.maxArray(numbers));
        System.out.println("14. Минимум массива: " + RecursionTasks.minArray(numbers));
        System.out.println("15. Количество чётных элементов: " + RecursionTasks.countEven(numbers));
        System.out.println("16. Массив отсортирован по возрастанию: "
                + RecursionTasks.isAscending(numbers));
        System.out.println("17. НОД чисел 48 и 18: " + RecursionTasks.gcd(48, 18));
        System.out.println("18. НОК чисел 12 и 18: " + RecursionTasks.lcm(12, 18));
        System.out.println("19. Число 13 в двоичной системе: " + RecursionTasks.toBinary(13));
        System.out.println("20. Сумма квадратов от 1 до 3: " + RecursionTasks.sumSquares(3));
        System.out.println("21. Переворот строки Java: " + RecursionTasks.reverse("Java"));
        System.out.println("22. Строка «казак» — палиндром: "
                + RecursionTasks.isPalindrome("казак"));
        System.out.println("23. Количество букв «а» в строке «банан»: "
                + RecursionTasks.countCharacter("банан", 'а'));
        System.out.println("24. Количество гласных в строке «Привет, Java»: "
                + RecursionTasks.countVowels("Привет, Java"));
        System.out.println("25. Удаление букв «а» из строки «банан»: "
                + RecursionTasks.removeCharacter("банан", 'а'));
        System.out.println("26. Замена букв в строке «banana»: "
                + RecursionTasks.replaceCharacter("banana", 'a', 'o'));
        System.out.println("27. Все символы строки «aaaaa» одинаковые: "
                + RecursionTasks.hasIdenticalCharacters("aaaaa"));
        System.out.println("28. Количество слов в строке: "
                + RecursionTasks.countWords("Java   очень полезна"));
        System.out.println("29. Строки «listen» и «silent» — анаграммы: "
                + RecursionTasks.areAnagrams("listen", "silent"));
        System.out.println("30. Сравнение строк «abc» и «abd»: "
                + RecursionTasks.compareStrings("abc", "abd"));
        System.out.println("31. Быстрое возведение 2 в степень 10: "
                + RecursionTasks.fastPower(2, 10));
        System.out.println("32. Индекс числа 7 в массиве: "
                + RecursionTasks.binarySearch(new int[]{1, 3, 5, 7, 9}, 7));

        RecursionTasks.mergeSort(sortable);
        System.out.println("33. Сортировка слиянием: " + Arrays.toString(sortable));
        RecursionTasks.quickSort(sortable);
        System.out.println("34. Быстрая сортировка: " + Arrays.toString(sortable));
        System.out.println("35. Ханойская башня для 3 дисков: "
                + RecursionTasks.hanoi(3, "A", "C", "B"));
        System.out.println("36. Подмножества массива [1, 2]: "
                + RecursionTasks.subsets(new int[]{1, 2}));
        System.out.println("37. Уникальные перестановки строки ABC: "
                + RecursionTasks.uniquePermutations("ABC"));
        System.out.println("38. Путь в лабиринте: "
                + RecursionTasks.findMazePath(maze, 0, 0, 3, 3));

        List<List<String>> queenSolutions = RecursionTasks.solveNQueens(4);
        System.out.println("39. Количество решений задачи о 4 ферзях: "
                + queenSolutions.size());
        System.out.println("40. Выражения из 123 с результатом 6: "
                + RecursionTasks.expressionsForTarget("123", 6));
    }
}
