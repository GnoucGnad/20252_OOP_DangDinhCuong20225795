package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.txt"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (Exception e) {
            System.out.println("Lỗi đọc file!");
            return;
        }
        
        startTime = System.currentTimeMillis();
        
        // Dùng StringBuilder để nối chuỗi (Không sinh rác)
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian nối chuỗi bằng StringBuilder (Không Rác): " + (endTime - startTime) + " ms");
    }
}