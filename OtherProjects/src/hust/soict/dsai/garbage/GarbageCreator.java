// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
   public GarbageCreator() {
   }

   public static void main(String[] var0) {
      String var1 = "test.txt";
      byte[] var10000 = new byte[]{0};

      byte[] var2;
      try {
         var2 = Files.readAllBytes(Paths.get(var1));
      } catch (Exception var12) {
         System.out.println("Không tìm thấy file test.txt. Bạn hãy kiểm tra lại vị trí file!");
         return;
      }

      long var3 = System.currentTimeMillis();
      String var7 = "";

      for(byte var11 : var2) {
         var7 = var7 + (char)var11;
      }

      long var5 = System.currentTimeMillis();
      System.out.println("Thời gian nối chuỗi bằng String (Có Rác): " + (var5 - var3) + " ms");
   }
}
