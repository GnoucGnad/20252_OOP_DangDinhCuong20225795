package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);
        
        // In giỏ hàng
        cart.print();
        
        // Test tìm kiếm
        System.out.println("\n--- Tìm kiếm DVD ---");
        cart.search(2); // Tìm theo ID 2
        cart.search("Lion"); // Tìm theo tên có chữ "Lion"
        cart.search("Harry Potter"); // Tìm đĩa không tồn tại
    }
}