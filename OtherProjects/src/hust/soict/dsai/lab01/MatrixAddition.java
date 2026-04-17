package hust.soict.dsai.lab01;

import java.util.Scanner;

public class MatrixAddition {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhap so hang cua ma tran: ");
		int rows = scanner.nextInt();
		System.out.print("Nhap so cot cua ma tran: ");
		int cols = scanner.nextInt();
		
		double[][] matrix1 = new double[rows][cols];
		double[][] matrix2 = new double[rows][cols];
		double[][] sumMatrix = new double[rows][cols];
		
		System.out.println("Nhap cac phan tu cho ma tran 1:");
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("matrix1[%d][%d] = ", i, j);
				matrix1[i][j] = scanner.nextDouble();
			}
		}
		System.out.println("Nhap cac phan tu cho ma tran 2:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++){
				System.out.printf("matrix2[%d][%d] = ", i, j);
				matrix2[i][j] = scanner.nextDouble();
			}
		}
		for (int i = 0; i < rows; i++) {
			for(int j = 0;j <cols; j++) {
				sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		System.out.println("Ket qua cong hai ma tran la:");
		for (int i =0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(sumMatrix[i][j] + "\t");
			}
			System.out.println();
		}
		
		scanner.close();
	}

}
