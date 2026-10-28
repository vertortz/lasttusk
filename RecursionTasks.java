import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecursionTasks {
    private RecursionTasks() {
    }

    // 1. Print numbers from 1 to n.
    public static void printAscending(int n) {
        if (n <= 0) {
            return;
        }
        printAscending(n - 1);
        System.out.println(n);
    }

    // 2. Print numbers from n to 1.
    public static void printDescending(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printDescending(n - 1);
    }

    // 3. Sum the natural numbers from 1 to n.
    public static long sumToN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        return n == 0 ? 0 : n + sumToN(n - 1);
    }

    // 4. Factorial, with a result that fits in long.
    public static long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("n must be between 0 and 20");
        }
        return n <= 1 ? 1 : n * factorial(n - 1);
    }

    // 5. Recursive integer power for a non-negative exponent.
    public static long power(int a, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        return n == 0 ? 1 : (long) a * power(a, n - 1);
    }

    // 6. Sum the digits of a non-negative number.
    public static int sumDigits(long number) {
        requireNonNegative(number);
        return number < 10 ? (int) number : (int) (number % 10) + sumDigits(number / 10);
    }

    // 7. Count digits; zero has one digit.
    public static int countDigits(long number) {
        requireNonNegative(number);
        return number < 10 ? 1 : 1 + countDigits(number / 10);
    }

    // 8. Multiply the digits of a non-negative number.
    public static long productDigits(long number) {
        requireNonNegative(number);
        return number < 10 ? number : number % 10 * productDigits(number / 10);
    }

    // 9. Find the largest digit.
    public static int maxDigit(long number) {
        requireNonNegative(number);
        return number < 10
                ? (int) number
                : Math.max((int) (number % 10), maxDigit(number / 10));
    }

    // 10. Find the smallest digit.
    public static int minDigit(long number) {
        requireNonNegative(number);
        return number < 10
                ? (int) number
                : Math.min((int) (number % 10), minDigit(number / 10));
    }

    // 11. Fibonacci sequence: F(0) = 0, F(1) = 1.
    public static long fibonacci(int n) {
        if (n < 0 || n > 92) {
            throw new IllegalArgumentException("n must be between 0 and 92");
        }
        return fibonacci(n, new long[n + 1]);
    }

    private static long fibonacci(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] == 0) {
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        }
        return memo[n];
    }

    // 12. Sum an array starting at the given index.
    public static long sumArray(int[] values, int index) {
        requireArray(values);
        if (index < 0 || index > values.length) {
            throw new IndexOutOfBoundsException("index is outside the array");
        }
        return index == values.length ? 0 : values[index] + sumArray(values, index + 1);
    }

    // 13. Find the largest array element.
    public static int maxArray(int[] values) {
        requireNonEmptyArray(values);
        return maxArray(values, 0);
    }

    private static int maxArray(int[] values, int index) {
        return index == values.length - 1
                ? values[index]
                : Math.max(values[index], maxArray(values, index + 1));
    }

    // 14. Find the smallest array element.
    public static int minArray(int[] values) {
        requireNonEmptyArray(values);
        return minArray(values, 0);
    }

    private static int minArray(int[] values, int index) {
        return index == values.length - 1
                ? values[index]
                : Math.min(values[index], minArray(values, index + 1));
    }

    // 15. Count even array elements.
    public static int countEven(int[] values) {
        requireArray(values);
        return countEven(values, 0);
    }

    private static int countEven(int[] values, int index) {
        if (index == values.length) {
            return 0;
        }
        return (values[index] % 2 == 0 ? 1 : 0) + countEven(values, index + 1);
    }

    // 16. Check whether an array is sorted in non-decreasing order.
    public static boolean isAscending(int[] values) {
        requireArray(values);
        return isAscending(values, 0);
    }

    private static boolean isAscending(int[] values, int index) {
        return index >= values.length - 1
                || (values[index] <= values[index + 1] && isAscending(values, index + 1));
    }

    // 17. Euclidean algorithm; the result is non-negative.
    public static long gcd(int a, int b) {
        return gcdNonNegative(Math.abs((long) a), Math.abs((long) b));
    }

    private static long gcdNonNegative(long a, long b) {
        return b == 0 ? a : gcdNonNegative(b, a % b);
    }

    // 18. Least common multiple of two positive numbers.
    public static long lcm(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("both numbers must be positive");
        }
        return (long) a / gcd(a, b) * b;
    }

    // 19. Binary representation of a positive decimal number.
    public static String toBinary(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("number must be positive");
        }
        return number < 2 ? "1" : toBinary(number / 2) + (number % 2);
    }

    // 20. Sum of squares from 1 to n.
    public static long sumSquares(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        return n == 0 ? 0 : (long) n * n + sumSquares(n - 1);
    }

    // 21. Reverse a string recursively.
    public static String reverse(String text) {
        requireString(text);
        return text.isEmpty() ? text : reverse(text.substring(1)) + text.charAt(0);
    }

    // 22. Check a palindrome (case-sensitive, including spaces).
    public static boolean isPalindrome(String text) {
        requireString(text);
        return isPalindrome(text, 0, text.length() - 1);
    }

    private static boolean isPalindrome(String text, int left, int right) {
        return left >= right
                || (text.charAt(left) == text.charAt(right)
                && isPalindrome(text, left + 1, right - 1));
    }

    // 23. Count occurrences of a character.
    public static int countCharacter(String text, char target) {
        requireString(text);
        return countCharacter(text, target, 0);
    }

    private static int countCharacter(String text, char target, int index) {
        if (index == text.length()) {
            return 0;
        }
        return (text.charAt(index) == target ? 1 : 0)
                + countCharacter(text, target, index + 1);
    }

    // 24. Count English and Russian vowels, case-insensitively.
    public static int countVowels(String text) {
        requireString(text);
        return countVowels(text, 0);
    }

    private static int countVowels(String text, int index) {
        if (index == text.length()) {
            return 0;
        }
        char ch = Character.toLowerCase(text.charAt(index));
        boolean vowel = "aeiouаеёиоуыэюя".indexOf(ch) >= 0;
        return (vowel ? 1 : 0) + countVowels(text, index + 1);
    }

    // 25. Remove all occurrences of a character.
    public static String removeCharacter(String text, char target) {
        requireString(text);
        if (text.isEmpty()) {
            return text;
        }
        String rest = removeCharacter(text.substring(1), target);
        return text.charAt(0) == target ? rest : text.charAt(0) + rest;
    }

    // 26. Replace all occurrences of one character with another.
    public static String replaceCharacter(String text, char oldChar, char newChar) {
        requireString(text);
        return replaceCharacter(text, oldChar, newChar, 0);
    }

    private static String replaceCharacter(String text, char oldChar, char newChar, int index) {
        if (index == text.length()) {
            return "";
        }
        char current = text.charAt(index) == oldChar ? newChar : text.charAt(index);
        return current + replaceCharacter(text, oldChar, newChar, index + 1);
    }

    // 27. Check whether all characters are identical.
    public static boolean hasIdenticalCharacters(String text) {
        requireString(text);
        return text.length() <= 1 || hasIdenticalCharacters(text, text.charAt(0), 1);
    }

    private static boolean hasIdenticalCharacters(String text, char expected, int index) {
        return index == text.length()
                || (text.charAt(index) == expected
                && hasIdenticalCharacters(text, expected, index + 1));
    }

    // 28. Count words separated by one or more whitespace characters.
    public static int countWords(String text) {
        requireString(text);
        return countWords(text, 0, false);
    }

    private static int countWords(String text, int index, boolean insideWord) {
        if (index == text.length()) {
            return 0;
        }
        boolean currentIsWhitespace = Character.isWhitespace(text.charAt(index));
        int startsWord = !currentIsWhitespace && !insideWord ? 1 : 0;
        return startsWord + countWords(text, index + 1, !currentIsWhitespace);
    }

    // 29. Compare recursively built character-frequency maps.
    public static boolean areAnagrams(String first, String second) {
        requireString(first);
        requireString(second);
        if (first.length() != second.length()) {
            return false;
        }
        Map<Character, Integer> firstCounts = new HashMap<>();
        Map<Character, Integer> secondCounts = new HashMap<>();
        countFrequencies(first, 0, firstCounts);
        countFrequencies(second, 0, secondCounts);
        return firstCounts.equals(secondCounts);
    }

    private static void countFrequencies(String text, int index, Map<Character, Integer> counts) {
        if (index == text.length()) {
            return;
        }
        char ch = text.charAt(index);
        counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        countFrequencies(text, index + 1, counts);
    }

    // 30. Lexicographic comparison: negative, zero, or positive.
    public static int compareStrings(String first, String second) {
        requireString(first);
        requireString(second);
        return compareStrings(first, second, 0);
    }

    private static int compareStrings(String first, String second, int index) {
        if (index == first.length() || index == second.length()) {
            return Integer.compare(first.length(), second.length());
        }
        int difference = first.charAt(index) - second.charAt(index);
        return difference == 0 ? compareStrings(first, second, index + 1) : difference;
    }

    // 31. Fast exponentiation in O(log n).
    public static long fastPower(long base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("exponent must be non-negative");
        }
        if (exponent == 0) {
            return 1;
        }
        long half = fastPower(base, exponent / 2);
        long squared = half * half;
        return exponent % 2 == 0 ? squared : squared * base;
    }

    // 32. Recursive binary search in a sorted array.
    public static int binarySearch(int[] values, int target) {
        requireArray(values);
        return binarySearch(values, target, 0, values.length - 1);
    }

    private static int binarySearch(int[] values, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (values[middle] == target) {
            return middle;
        }
        return values[middle] < target
                ? binarySearch(values, target, middle + 1, right)
                : binarySearch(values, target, left, middle - 1);
    }

    // 33. Merge sort; sorts the supplied array in place.
    public static void mergeSort(int[] values) {
        requireArray(values);
        mergeSort(values, new int[values.length], 0, values.length - 1);
    }

    private static void mergeSort(int[] values, int[] buffer, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(values, buffer, left, middle);
        mergeSort(values, buffer, middle + 1, right);
        merge(values, buffer, left, middle, right);
    }

    private static void merge(int[] values, int[] buffer, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;
        while (i <= middle && j <= right) {
            buffer[k++] = values[i] <= values[j] ? values[i++] : values[j++];
        }
        while (i <= middle) {
            buffer[k++] = values[i++];
        }
        while (j <= right) {
            buffer[k++] = values[j++];
        }
        System.arraycopy(buffer, left, values, left, right - left + 1);
    }

    // 34. Quick sort; sorts the supplied array in place.
    public static void quickSort(int[] values) {
        requireArray(values);
        quickSort(values, 0, values.length - 1);
    }

    private static void quickSort(int[] values, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int pivot = values[left + (right - left) / 2];
        while (i <= j) {
            while (values[i] < pivot) {
                i++;
            }
            while (values[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = values[i];
                values[i++] = values[j];
                values[j--] = temp;
            }
        }
        if (left < j) {
            quickSort(values, left, j);
        }
        if (i < right) {
            quickSort(values, i, right);
        }
    }

    // 35. Return Hanoi moves in order.
    public static List<String> hanoi(int disks, String from, String to, String auxiliary) {
        if (disks < 0) {
            throw new IllegalArgumentException("disks must be non-negative");
        }
        requireString(from);
        requireString(to);
        requireString(auxiliary);
        List<String> moves = new ArrayList<>();
        hanoi(disks, from, to, auxiliary, moves);
        return moves;
    }

    private static void hanoi(
            int disks, String from, String to, String auxiliary, List<String> moves) {
        if (disks == 0) {
            return;
        }
        hanoi(disks - 1, from, auxiliary, to, moves);
        moves.add(from + " -> " + to);
        hanoi(disks - 1, auxiliary, to, from, moves);
    }

    // 36. Generate all subsets, including the empty subset.
    public static List<List<Integer>> subsets(int[] values) {
        requireArray(values);
        List<List<Integer>> result = new ArrayList<>();
        subsets(values, 0, new ArrayList<>(), result);
        return result;
    }

    private static void subsets(
            int[] values, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == values.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        subsets(values, index + 1, current, result);
        current.add(values[index]);
        subsets(values, index + 1, current, result);
        current.remove(current.size() - 1);
    }

    // 37. Generate unique permutations, including for strings with repeated characters.
    public static List<String> uniquePermutations(String text) {
        requireString(text);
        char[] chars = text.toCharArray();
        Arrays.sort(chars);
        List<String> result = new ArrayList<>();
        uniquePermutations(chars, new boolean[chars.length], new StringBuilder(), result);
        return result;
    }

    private static void uniquePermutations(
            char[] chars, boolean[] used, StringBuilder current, List<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            current.append(chars[i]);
            uniquePermutations(chars, used, current, result);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    // 38. Find one path through a maze (0 = free, 1 = wall).
    // Coordinates in the returned path use "row,column" format.
    public static List<String> findMazePath(
            int[][] maze, int startRow, int startColumn, int endRow, int endColumn) {
        validateMaze(maze);
        int rows = maze.length;
        int columns = maze[0].length;
        if (!inside(startRow, startColumn, rows, columns)
                || !inside(endRow, endColumn, rows, columns)
                || maze[startRow][startColumn] != 0
                || maze[endRow][endColumn] != 0) {
            return new ArrayList<>();
        }
        boolean[][] visited = new boolean[rows][columns];
        List<String> path = new ArrayList<>();
        return findMazePath(maze, startRow, startColumn, endRow, endColumn, visited, path)
                ? path : new ArrayList<>();
    }

    private static boolean findMazePath(
            int[][] maze, int row, int column, int endRow, int endColumn,
            boolean[][] visited, List<String> path) {
        if (!inside(row, column, maze.length, maze[0].length)
                || maze[row][column] == 1 || visited[row][column]) {
            return false;
        }
        visited[row][column] = true;
        path.add(row + "," + column);
        if (row == endRow && column == endColumn) {
            return true;
        }
        if (findMazePath(maze, row - 1, column, endRow, endColumn, visited, path)
                || findMazePath(maze, row + 1, column, endRow, endColumn, visited, path)
                || findMazePath(maze, row, column - 1, endRow, endColumn, visited, path)
                || findMazePath(maze, row, column + 1, endRow, endColumn, visited, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    // 39. Return all N-Queens solutions as lists of rows, with Q marking a queen.
    public static List<List<String>> solveNQueens(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        List<List<String>> solutions = new ArrayList<>();
        solveNQueens(n, 0, new int[n], solutions);
        return solutions;
    }

    private static void solveNQueens(
            int n, int row, int[] columns, List<List<String>> solutions) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                char[] line = new char[n];
                Arrays.fill(line, '.');
                line[columns[r]] = 'Q';
                board.add(new String(line));
            }
            solutions.add(board);
            return;
        }
        for (int column = 0; column < n; column++) {
            if (isSafeQueen(row, column, columns)) {
                columns[row] = column;
                solveNQueens(n, row + 1, columns, solutions);
            }
        }
    }

    private static boolean isSafeQueen(int row, int column, int[] columns) {
        for (int previousRow = 0; previousRow < row; previousRow++) {
            int previousColumn = columns[previousRow];
            if (previousColumn == column
                    || Math.abs(previousColumn - column) == row - previousRow) {
                return false;
            }
        }
        return true;
    }

    // 40. Insert +, -, or * between digits to reach the target.
    // Multi-digit operands with a leading zero are not generated.
    public static List<String> expressionsForTarget(String digits, long target) {
        requireString(digits);
        if (!digits.matches("[0-9]*")) {
            throw new IllegalArgumentException("digits must contain only decimal digits");
        }
        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()) {
            expressionsForTarget(digits, target, 0, 0, 0, new StringBuilder(), result);
        }
        return result;
    }

    private static void expressionsForTarget(
            String digits, long target, int index, long value, long lastOperand,
            StringBuilder expression, List<String> result) {
        if (index == digits.length()) {
            if (value == target) {
                result.add(expression.toString());
            }
            return;
        }
        for (int end = index; end < digits.length(); end++) {
            if (end > index && digits.charAt(index) == '0') {
                break;
            }
            long operand = Long.parseLong(digits.substring(index, end + 1));
            int oldLength = expression.length();
            if (index == 0) {
                expression.append(operand);
                expressionsForTarget(
                        digits, target, end + 1, operand, operand, expression, result);
                expression.setLength(oldLength);
                continue;
            }
            expression.append('+').append(operand);
            expressionsForTarget(
                    digits, target, end + 1, value + operand, operand, expression, result);
            expression.setLength(oldLength);

            expression.append('-').append(operand);
            expressionsForTarget(
                    digits, target, end + 1, value - operand, -operand, expression, result);
            expression.setLength(oldLength);

            expression.append('*').append(operand);
            expressionsForTarget(
                    digits, target, end + 1,
                    value - lastOperand + lastOperand * operand,
                    lastOperand * operand, expression, result);
            expression.setLength(oldLength);
        }
    }

    private static void requireNonNegative(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("number must be non-negative");
        }
    }

    private static void requireArray(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("array must not be null");
        }
    }

    private static void requireNonEmptyArray(int[] values) {
        requireArray(values);
        if (values.length == 0) {
            throw new IllegalArgumentException("array must not be empty");
        }
    }

    private static void requireString(String text) {
        if (text == null) {
            throw new IllegalArgumentException("string must not be null");
        }
    }

    private static boolean inside(int row, int column, int rows, int columns) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    private static void validateMaze(int[][] maze) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            throw new IllegalArgumentException("maze must be a non-empty rectangular array");
        }
        int columns = maze[0].length;
        for (int[] row : maze) {
            if (row == null || row.length != columns) {
                throw new IllegalArgumentException("maze must be rectangular");
            }
            for (int cell : row) {
                if (cell != 0 && cell != 1) {
                    throw new IllegalArgumentException("maze cells must be 0 or 1");
                }
            }
        }
    }
}
