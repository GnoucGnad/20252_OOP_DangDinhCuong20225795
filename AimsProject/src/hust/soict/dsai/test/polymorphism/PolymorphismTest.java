package hust.soict.dsai.test.polymorphism;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class PolymorphismTest {
    public static void main(String[] args) {
        // Tạo một ArrayList chứa các đối tượng Media [cite: 245, 249]
        List<Media> mediae = new ArrayList<Media>();

        // Tạo các đối tượng CD, DVD, Book [cite: 251]
        CompactDisc cd = new CompactDisc(1, "Album Nhac Tre", "Music", 15.5f, 45, "Various", "Ca si A");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book(3, "Harry Potter", "Fantasy", 20.0f);

        // Thêm các phương tiện vào danh sách [cite: 245, 253, 254, 255]
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // Lặp qua danh sách và in thông tin của các phương tiện bằng cách sử dụng phương thức toString() [cite: 246, 257, 260]
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}