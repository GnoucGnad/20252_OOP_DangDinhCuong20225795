package hust.soict.dsai.lab01;
import java.util.Scanner;
public class InputFromKeyboard{
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Ten ban la gi?");
		String StrName = keyboard.next();
		System.out.println("Ban bao nhieu tuoi?");
		int iAge = keyboard.nextInt();
		System.out.println("Chieu cao cua ban la:");
		double dHeight = keyboard.nextDouble();
		
		System.out.println("Anh " + StrName + ", " + iAge + "tuoi." + "Chieu cao la: " + dHeight + "cm" );
		keyboard.close();
	}
}