// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
   public NoGarbage() {
   }

   public static void main(String[] args) {
      String filename = "test.txt";
      byte[] inputBytes = new byte[1];

      try {
         inputBytes = Files.readAllBytes(Paths.get(filename));
      } catch (Exception var12) {
         return;
      }

      long startTime = System.currentTimeMillis();
      StringBuilder outputStringBuilder = new StringBuilder();

      for(byte b : inputBytes) {
         outputStringBuilder.append((char)b);
      }

      long endTime = System.currentTimeMillis();
      System.out.println("Thời gian nối chuỗi bằng StringBuilder (Không Rác): " + (endTime - startTime) + " ms");
   }
}
