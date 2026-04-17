package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    // Sức chứa của kho hàng (Lớn hơn giỏ hàng nhiều)
    public static final int MAX_ITEMS_IN_STORE = 1000;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    // Quản lý thêm đĩa vào kho
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("Đã thêm đĩa '" + dvd.getTitle() + "' vào kho hàng.");
        } else {
            System.out.println("Kho hàng đã đầy!");
        }
    }

    // Quản lý xóa đĩa khỏi kho
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                // Dồn mảng lấp chỗ trống
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("Đã xóa đĩa '" + dvd.getTitle() + "' khỏi kho hàng.");
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đĩa '" + dvd.getTitle() + "' trong kho!");
        }
    }
}