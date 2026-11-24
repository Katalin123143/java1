
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Locale.setDefault(new Locale("uk", "UA"));

        while (true) {
            System.out.println("\nЛАБОРАТОРНА РОБОТА №1. ВАРІАНТ 17");
            System.out.println("1 - Завдання 1 (варіант 7)");
            System.out.println("2 - Завдання 2 (варіант 17)");
            System.out.println("3 - Завдання 3 (варіант 17)");
            System.out.println("4 - Завдання 4 (варіант 3)");
            System.out.println("0 - Вихід");
            System.out.print("Ваш вибір: ");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 0:
                    System.out.println("Роботу завершено.");
                    in.close();
                    return;
                default:
                    System.out.println("Неправильний пункт меню.");
            }
        }
    }

    // Завдання 1, варіант 7

    static double calculate(double a, double b) {
        return a / (b * b - 2) + b / (a * a + 2)
                + Math.pow(a * b, 3);
    }

    static void task1() {
        System.out.println("\nЗАВДАННЯ 1. ВАРІАНТ 7");
        System.out.println("1 - дійсні дані, дійсний результат");
        System.out.println("2 - цілі дані, дійсний результат");
        System.out.println("3 - дійсні дані, цілий результат");
        System.out.print("Оберіть спосіб: ");

        int mode = in.nextInt();

        double a;
        double b;

        if (mode == 2) {
            System.out.print("Введіть ціле a: ");
            int ai = in.nextInt();

            System.out.print("Введіть ціле b: ");
            int bi = in.nextInt();

            a = ai;
            b = bi;

        } else if (mode == 1 || mode == 3) {
            System.out.print("Введіть дійсне a: ");
            a = in.nextDouble();

            System.out.print("Введіть дійсне b: ");
            b = in.nextDouble();

        } else {
            System.out.println("Неправильний спосіб обчислення.");
            return;
        }

        if (Math.abs(b * b - 2) < 1e-12) {
            System.out.println("Помилка: знаменник дорівнює нулю.");
            return;
        }

        double result = calculate(a, b);

        if (mode == 3) {
            System.out.println("Результат (ціле число): " + (int) result);
        } else {
            System.out.println("Результат: " + result);
        }
    }

    // Завдання 2, варіант 17

    static void task2() {
        System.out.println("\nЗАВДАННЯ 2. ВАРІАНТ 17");
        System.out.print("Введіть кількість елементів (1-300): ");

        int n = in.nextInt();

        if (n < 1 || n > 300) {
            System.out.println("Розмір масиву має бути від 1 до 300.");
            return;
        }

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "] = ");
            a[i] = in.nextInt();
        }

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        System.out.println("Найбільша довжина ланцюжка: " + maxLength);
        System.out.println("Найдовші ланцюжки:");

        int i = 0;

        while (i < n) {
            int j = i + 1;

            while (j < n && a[j] == a[i]) {
                j++;
            }

            int length = j - i;

            if (length == maxLength) {
                System.out.println("Число " + a[i]
                        + ", кількість: " + length
                        + ", позиції: " + i + "-" + (j - 1));
            }

            i = j;
        }
    }

    // Завдання 3, варіант 17

    static void task3() {
        System.out.println("\nЗАВДАННЯ 3. ВАРІАНТ 17");
        System.out.print("Введіть розмір квадратної матриці (1-20): ");

        int n = in.nextInt();

        if (n < 1 || n > 20) {
            System.out.println("Розмір матриці має бути від 1 до 20.");
            return;
        }

        int[][] m = new int[n][n];

        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("M[" + i + "][" + j + "] = ");
                m[i][j] = in.nextInt();
            }
        }

        int[] rowSums = new int[n];
        int[] colSums = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += m[i][j];
                colSums[j] += m[i][j];
            }
        }

        boolean found = false;

        System.out.println("Пари рядків і стовпців з однаковими сумами:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rowSums[i] == colSums[j]) {
                    System.out.println("Рядок " + (i + 1)
                            + " і стовпець " + (j + 1)
                            + ": сума = " + rowSums[i]);

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Рядків і стовпців з однаковими сумами немає.");
        }
    }

    // Завдання 4, варіант 3

    static void task4() {
        System.out.println("\nЗАВДАННЯ 4. ВАРІАНТ 3");
        System.out.println("Введіть текст:");

        String text = in.nextLine();

        String[] words = text.split("[^\\p{L}]+");

        boolean found = false;

        System.out.println("Симетричні слова:");

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            String lower = word.toLowerCase();
            boolean symmetric = true;

            for (int i = 0; i < lower.length() / 2; i++) {
                if (lower.charAt(i)
                        != lower.charAt(lower.length() - 1 - i)) {
                    symmetric = false;
                    break;
                }
            }

            if (symmetric) {
                System.out.print(word + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Симетричних слів немає.");
        } else {
            System.out.println();
        }
    }
}
