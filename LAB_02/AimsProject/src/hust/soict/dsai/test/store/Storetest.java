package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Storetest {
    public static void main(String[] args) {
        // Tạo một kho hàng mới
        Store store = new Store();
        
        // Tạo các đĩa DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        
        // Thêm đĩa vào kho
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        
        // Xóa đĩa khỏi kho
        store.removeDVD(dvd2); // Xóa Star Wars
        store.removeDVD(dvd2); // Cố tình xóa lại xem có báo lỗi không
    }
}