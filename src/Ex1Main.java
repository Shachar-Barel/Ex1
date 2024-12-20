
//package assignments.ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
import java.util.Scanner;

/**
 * Ex1 Main class implementation to match the specified output format.
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        while (!num1.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (num1.equals(quit)) {
                break;
            }
            System.out.println("num1= " + num1 + " is number: " + Ex1.isNumber(num1) + " , value: " + Ex1.number2Int(num1));
            if (!Ex1.isNumber(num1)) {
                System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                continue;
            }
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals(quit)) {
                break;
            }
            System.out.println("num2= " + num2 + " is number: " + Ex1.isNumber(num2) + " , value: " + Ex1.number2Int(num2));
            if (!Ex1.isNumber(num2)) {
                System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                continue;
            }
            System.out.println("Enter a base for output: (a number [2,16])");
            int base = sc.nextInt();
            if (base < 2 || base > 16) {
                System.out.println("ERR: Invalid base. Base should be in range [2,16].");
                continue;
            }
            int sum = Ex1.number2Int(num1) + Ex1.number2Int(num2);
            int mult = Ex1.number2Int(num1) * Ex1.number2Int(num2);
            String sumBase = Ex1.int2Number(sum, base);
            String multBase = Ex1.int2Number(mult, base);
            System.out.println(num1 + " + " + num2 + " = " + sumBase);
            System.out.println(num1 + " * " + num2 + " = " + multBase);
            String[] arr = {num1, num2, sumBase, multBase};
            int maxIndex = Ex1.maxIndex(arr);
            String maxNumber = arr[maxIndex];
            System.out.println("Max number over [" + String.join(",", arr) + "] is: " + maxNumber);
        }

        System.out.println("quitting now...");
    }
}
