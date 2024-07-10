import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of days:");
        int n = scanner.nextInt();
        int[] temperatures = new int[n];
        System.out.println("Enter the temperatures:");
        for (int i = 0; i < n; i++) {
            temperatures[i] = scanner.nextInt();
        }
    }
}