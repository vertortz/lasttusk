import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RecursionTasksTest {
    private static int checks;

    private RecursionTasksTest() {
    }

    public static void main(String[] args) throws Exception {
        testNumberMethods();
        testArrayMethods();
        testStringMethods();
        testSearchAndSortMethods();
        testBacktrackingMethods();
        System.out.println("Все проверки пройдены: " + checks);
    }

    private static void testNumberMethods() throws Exception {
        equal("1. Вывод от 1 до N", "1\n2\n3\n", captureOutput(() ->
                RecursionTasks.printAscending(3)));
        equal("2. Вывод от N до 1", "3\n2\n1\n", captureOutput(() ->
                RecursionTasks.printDescending(3)));
        equal("3. Сумма от 1 до N", 15L, RecursionTasks.sumToN(5));
        equal("4. Факториал", 120L, RecursionTasks.factorial(5));
        equal("5. Степень", 1024L, RecursionTasks.power(2, 10));
        equal("6. Сумма цифр", 16, RecursionTasks.sumDigits(583));
        equal("7. Количество цифр", 1, RecursionTasks.countDigits(0));
        equal("8. Произведение цифр", 24L, RecursionTasks.productDigits(234));
        equal("9. Максимальная цифра", 8, RecursionTasks.maxDigit(583));
        equal("10. Минимальная цифра", 3, RecursionTasks.minDigit(583));
        equal("11. Число Фибоначчи", 55L, RecursionTasks.fibonacci(10));
        equal("11. Большое число Фибоначчи", 7540113804746346429L,
                RecursionTasks.fibonacci(92));
        equal("17. НОД", 6L, RecursionTasks.gcd(48, 18));
        equal("17. НОД для Integer.MIN_VALUE", 2147483648L,
                RecursionTasks.gcd(Integer.MIN_VALUE, 0));
        equal("18. НОК", 36L, RecursionTasks.lcm(12, 18));
        equal("19. Двоичное представление", "1101", RecursionTasks.toBinary(13));
        equal("20. Сумма квадратов", 14L, RecursionTasks.sumSquares(3));
        equal("31. Быстрое возведение в степень", 1024L,
                RecursionTasks.fastPower(2, 10));
    }

    private static void testArrayMethods() {
        int[] values = {4, 2, 7, 1, 6};
        equal("12. Сумма массива", 20L, RecursionTasks.sumArray(values, 0));
        equal("12. Сумма с индекса", 14L, RecursionTasks.sumArray(values, 2));
        equal("13. Максимум массива", 7, RecursionTasks.maxArray(values));
        equal("14. Минимум массива", 1, RecursionTasks.minArray(values));
        equal("15. Подсчёт чётных", 3, RecursionTasks.countEven(values));
        equal("16. Проверка возрастания", true,
                RecursionTasks.isAscending(new int[]{1, 2, 2, 4}));
        equal("16. Невозрастающий массив", false,
                RecursionTasks.isAscending(new int[]{1, 3, 2}));
        equal("16. Пустой массив", true, RecursionTasks.isAscending(new int[]{}));
    }

    private static void testStringMethods() {
        equal("21. Переворот строки", "avaJ", RecursionTasks.reverse("Java"));
        equal("22. Палиндром", true, RecursionTasks.isPalindrome("казак"));
        equal("22. Не палиндром", false, RecursionTasks.isPalindrome("Java"));
        equal("23. Подсчёт символа", 2, RecursionTasks.countCharacter("банан", 'а'));
        equal("24. Русские и английские гласные", 4,
                RecursionTasks.countVowels("Привет, Java"));
        equal("24. Буква y не учитывается как гласная", 0,
                RecursionTasks.countVowels("rhythm"));
        equal("25. Удаление символа", "бнн",
                RecursionTasks.removeCharacter("банан", 'а'));
        equal("26. Замена символа", "bonono",
                RecursionTasks.replaceCharacter("banana", 'a', 'o'));
        equal("27. Одинаковые символы", true,
                RecursionTasks.hasIdenticalCharacters("aaaaa"));
        equal("27. Разные символы", false,
                RecursionTasks.hasIdenticalCharacters("aaaba"));
        equal("28. Подсчёт слов", 3,
                RecursionTasks.countWords("  Java   очень полезна  "));
        equal("29. Анаграмма", true, RecursionTasks.areAnagrams("listen", "silent"));
        equal("29. Не анаграмма", false, RecursionTasks.areAnagrams("abc", "ab"));
        equal("30. Равные строки", 0, RecursionTasks.compareStrings("abc", "abc"));
        check("30. Порядок строк", RecursionTasks.compareStrings("abc", "abd") < 0);
        check("30. Префиксные строки", RecursionTasks.compareStrings("ab", "abc") < 0);
    }

    private static void testSearchAndSortMethods() {
        int[] searchValues = {1, 3, 5, 7, 9};
        equal("32. Бинарный поиск найденного", 3,
                RecursionTasks.binarySearch(searchValues, 7));
        equal("32. Бинарный поиск отсутствующего", -1,
                RecursionTasks.binarySearch(searchValues, 8));
        equal("32. Поиск в пустом массиве", -1,
                RecursionTasks.binarySearch(new int[]{}, 8));

        Random random = new Random(2026);
        for (int sample = 0; sample < 100; sample++) {
            int[] original = new int[random.nextInt(80)];
            for (int i = 0; i < original.length; i++) {
                original[i] = random.nextInt(201) - 100;
            }
            int[] expected = original.clone();
            Arrays.sort(expected);
            int[] mergeSorted = original.clone();
            RecursionTasks.mergeSort(mergeSorted);
            equal("33. Сортировка слиянием, пример " + sample,
                    Arrays.toString(expected), Arrays.toString(mergeSorted));
            int[] quickSorted = original.clone();
            RecursionTasks.quickSort(quickSorted);
            equal("34. Быстрая сортировка, пример " + sample,
                    Arrays.toString(expected), Arrays.toString(quickSorted));
        }
    }

    private static void testBacktrackingMethods() {
        equal("35. Ханойская башня", 7,
                RecursionTasks.hanoi(3, "A", "C", "B").size());
        equal("36. Количество подмножеств", 4, RecursionTasks.subsets(new int[]{1, 2}).size());
        check("36. Пустое подмножество",
                RecursionTasks.subsets(new int[]{1, 2}).contains(new ArrayList<Integer>()));
        equal("37. Перестановки ABC", 6,
                RecursionTasks.uniquePermutations("ABC").size());
        equal("37. Уникальные перестановки AAB",
                new HashSet<>(Arrays.asList("AAB", "ABA", "BAA")),
                new HashSet<>(RecursionTasks.uniquePermutations("AAB")));

        int[][] maze = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0}
        };
        List<String> path = RecursionTasks.findMazePath(maze, 0, 0, 2, 2);
        check("38. Путь существует", !path.isEmpty());
        equal("38. Начало пути", "0,0", path.get(0));
        equal("38. Конец пути", "2,2", path.get(path.size() - 1));
        equal("38. Непроходимый лабиринт", 0,
                RecursionTasks.findMazePath(new int[][]{{0, 1}, {1, 0}}, 0, 0, 1, 1).size());

        equal("39. Число решений для четырёх ферзей", 2,
                RecursionTasks.solveNQueens(4).size());
        equal("39. Нет решений для двух ферзей", 0, RecursionTasks.solveNQueens(2).size());
        equal("40. Выражения для цели 6",
                new HashSet<>(Arrays.asList("1+2+3", "1*2*3")),
                new HashSet<>(RecursionTasks.expressionsForTarget("123", 6)));
        equal("40. Ноль в числе", Arrays.asList("1*0+5", "10-5"),
                RecursionTasks.expressionsForTarget("105", 5));
    }

    private static String captureOutput(Runnable action) throws Exception {
        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(output, true, "UTF-8"));
            action.run();
        } finally {
            System.setOut(original);
        }
        return output.toString("UTF-8").replace("\r\n", "\n");
    }

    private static void check(String name, boolean condition) {
        checks++;
        if (!condition) {
            throw new AssertionError(name);
        }
    }

    private static void equal(String name, Object expected, Object actual) {
        check(name + " (ожидалось: " + expected + ", получено: " + actual + ")",
                expected.equals(actual));
    }
}
