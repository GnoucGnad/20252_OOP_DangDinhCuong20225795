package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; // Sức chứa tối đa
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0; // Số lượng đĩa đang có

    // Thêm đĩa vào giỏ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Đã thêm đĩa '" + disc.getTitle() + "' vào giỏ hàng.");
        } else {
            System.out.println("Giỏ hàng đã đầy! Không thể thêm.");
        }
    }
 // 1. Nạp chồng: Thêm một danh sách đĩa (Truyền vào một mảng)
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = dvd;
                qtyOrdered++;
                System.out.println("Đã thêm đĩa: " + dvd.getTitle() + " vào giỏ.");
            } else {
                System.out.println("Giỏ hàng đã đầy! Không thể thêm đĩa: " + dvd.getTitle());
                break; // Thoát vòng lặp vì giỏ đã đầy
            }
        }
    }

    // 2. Nạp chồng: Thêm 2 đĩa cùng một lúc (Truyền vào 2 tham số)
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        // Thêm đĩa thứ 1
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("Đã thêm đĩa: " + dvd1.getTitle() + " vào giỏ.");
        } else {
            System.out.println("Giỏ hàng đã đầy! Không thể thêm đĩa: " + dvd1.getTitle());
        }

        // Thêm đĩa thứ 2
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("Đã thêm đĩa: " + dvd2.getTitle() + " vào giỏ.");
        } else {
            System.out.println("Giỏ hàng đã đầy! Không thể thêm đĩa: " + dvd2.getTitle());
        }
    }

    // Xóa đĩa khỏi giỏ (Logic dồn mảng)
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) { // Tìm thấy đĩa cần xóa
                // Dồn các đĩa phía sau lên trước 1 bậc để lấp chỗ trống
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Xóa phần tử thừa ở cuối
                qtyOrdered--; // Giảm số lượng đi 1
                System.out.println("Đã xóa đĩa '" + disc.getTitle() + "' khỏi giỏ hàng.");
                return; // Thoát hàm sau khi xóa xong
            }
        }
        System.out.println("Không tìm thấy đĩa trong giỏ hàng.");
    }

    // Tính tổng tiền
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
 // In danh sách đĩa trong giỏ hàng
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    // Tìm kiếm theo ID
    public void search(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Tìm thấy: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đĩa nào có ID: " + id);
        }
    }

    // Tìm kiếm theo Tiêu đề
    public void search(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Tìm thấy: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đĩa nào có tiêu đề: " + title);
        }
    }
}