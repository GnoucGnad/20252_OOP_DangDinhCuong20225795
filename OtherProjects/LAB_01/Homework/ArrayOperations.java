package Exercise;

//import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhap so phan tu cua mang: ");

		int n = scanner.nextInt();

		double[] myArray = new double[n];

		System.out.println("Nhap cac phan tu cua mang:");

		for (int i = 0; i < n; i++) {

			System.out.print("Phan tu " + (i + 1) + ": ");

			myArray[i] = scanner.nextDouble();

		}

		java.util.Arrays.sort(myArray);

		double sum = 0;

		for (double num : myArray) {

			sum += num;

		}

		double average = sum / n;

		System.out.println("--- Ket qua ---");

		System.out.println("Mang sau khi sap xep: " + java.util.Arrays.toString(myArray));

		System.out.println("Tong cac phan tu: " + sum);

		System.out.printf("Gia tri tring binh: %.2f\n", average);

		scanner.close();

	}

}