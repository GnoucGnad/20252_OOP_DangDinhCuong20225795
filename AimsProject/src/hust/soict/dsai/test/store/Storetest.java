package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Storetest {
    public static void main(String[] args) {
        // Tạo một kho hàng mới
        Store store = new Store();
        
        // Tạo các đĩa DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        
        // Thêm đĩa vào kho (Đã sửa addDVD thành addMedia)
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        
        // Xóa đĩa khỏi kho (Đã sửa removeDVD thành removeMedia)
        store.removeMedia(dvd2); // Xóa Star Wars
        store.removeMedia(dvd2); // Cố tình xóa lại xem có báo lỗi không
    }
}