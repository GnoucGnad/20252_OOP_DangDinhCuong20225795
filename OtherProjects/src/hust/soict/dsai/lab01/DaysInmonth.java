package hust.soict.dsai.lab01;
import java.util.Scanner;

public class DaysInmonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monthInput;
        int year = -1;
        int monthNum = -1;

        while (true) {
            System.out.print("Nhập tháng (tên, viết tắt hoặc số): ");
            monthInput = scanner.nextLine().trim().toLowerCase();
            
            System.out.print("Nhập năm: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                scanner.nextLine(); 
                if (year < 0) {
                    System.out.println("Năm không hợp lệ. Vui lòng nhập lại!");
                    continue;
                }
            } else {
                System.out.println("Năm phải là một số. Vui lòng nhập lại!");
                scanner.nextLine();
                continue;
            }

            monthNum = convertMonth(monthInput);
            
            if (monthNum != -1) {
                break; 
            } else {
                System.out.println("Tháng không hợp lệ. Ví dụ: Jan, January, Jan. hoặc 1.");
            }
        }

        int days = getDaysInMonth(monthNum, year);
        System.out.println("Số ngày của tháng " + monthInput + " năm " + year + " là: " + days);
        
        scanner.close();
    }

    
    private static int convertMonth(String input) {
        if (input.equals("january") || input.equals("jan.") || input.equals("jan") || input.equals("1")) return 1;
        if (input.equals("february") || input.equals("feb.") || input.equals("feb") || input.equals("2")) return 2;
        if (input.equals("march") || input.equals("mar.") || input.equals("mar") || input.equals("3")) return 3;
        if (input.equals("april") || input.equals("apr.") || input.equals("apr") || input.equals("4")) return 4;
        if (input.equals("may") || input.equals("5")) return 5;
        if (input.equals("june") || input.equals("jun") || input.equals("6")) return 6;
        if (input.equals("july") || input.equals("jul") || input.equals("7")) return 7;
        if (input.equals("august") || input.equals("aug.") || input.equals("aug") || input.equals("8")) return 8;
        if (input.equals("september") || input.equals("sept.") || input.equals("sep") || input.equals("9")) return 9;
        if (input.equals("october") || input.equals("oct.") || input.equals("oct") || input.equals("10")) return 10;
        if (input.equals("november") || input.equals("nov.") || input.equals("nov") || input.equals("11")) return 11;
        if (input.equals("december") || input.equals("dec.") || input.equals("dec") || input.equals("12")) return 12;
        return -1;
    }

    
    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }
}