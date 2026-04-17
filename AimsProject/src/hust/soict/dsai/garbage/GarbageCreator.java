package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.txt"; // Tên file bạn vừa tạo
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (Exception e) {
            System.out.println("Không tìm thấy file test.txt. Bạn hãy kiểm tra lại vị trí file!");
            return;
        }
        
        startTime = System.currentTimeMillis();
        String outputString = "";
        
        // Vòng lặp cộng chuỗi bằng dấu + (Gây ra rác)
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian nối chuỗi bằng String (Có Rác): " + (endTime - startTime) + " ms");
    }
}