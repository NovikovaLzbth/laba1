import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int Lenght = scanner.nextInt();
        int[] array = new int[Lenght];
        for(int i = 0; i < Lenght; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print ("Полученный массив: " + Arrays.toString(array));
        System.out.println();
        int Percent = 5;
        findMajoritarianNumbers(array, Percent);
    }

    public static void findMajoritarianNumbers(int[] array, int percent) {
        int Count = array.length;
        int Threshold = (int) Math.ceil(Count * (percent / 100.0));

        System.out.println("Мажоритарные числа (не менее чем " + Threshold + "):");

        boolean[] printed = new boolean[Count]; // массив для отслеживания уже напечатанных чисел

        for (int i = 0; i < Count; i++) {
            if (!printed[i]) { // проверка на повтор
                int count = 1; // начальное количество для текущего числа

                // счетчик количество вхождений для текущего числа
                for (int j = i + 1; j < Count; j++) {
                    if (array[i] == array[j]) {
                        count++;
                        printed[j] = true; // число уже обработано
                    }
                }

                // сравнение с пороговым значением
                if (count >= Threshold) {
                    System.out.println(array[i] + " встречается " + count + " раз");
                }
            }
        }
    }
}
